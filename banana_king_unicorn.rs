// Imports
use std::io;
use std::collections::HashMap;

// Greenthreads
struct Greenthread {
    name: String,
    id: u32,
    capacity: u32,
}

// Greenthread Pool
struct GreenthreadPool {
    threads: Vec<Greenthread>,
    size: usize,
    capacity_capacity: u32,
}

impl GreenthreadPool {
    fn new(size: usize) -> GreenthreadPool {
        GreenthreadPool {
            threads: Vec::with_capacity(size),
            size,
            capacity_capacity: 0,
        }
    }

    fn add_thread(&mut self, name: String, id: u32, capacity: u32) -> bool {
        if self.capacity_capacity + capacity > self.size as u32 {
            false
        } else {
            let thread = Greenthread {
                name,
                id,
                capacity
            };

            self.threads.push(thread);
            self.capacity_capacity += capacity;
            true
        }
    }

    // Changing thread capacity
    fn update_capacity(&mut self, id: u32, capacity: u32) -> bool {
        for thread in &mut self.threads {
            if thread.id == id {
                let old_capacity = thread.capacity;

                if self.capacity_capacity + capacity - old_capacity > self.size as u32 {
                    return false;
                }

                thread.capacity = capacity;
                self.capacity_capacity = self.capacity_capacity + capacity - old_capacity;

                return true;
            }
        }
        false
    }
}

// Greenthread Usage
struct GreenthreadUsage {
    used_capacity: u32,
    pool: GreenthreadPool,
}

impl GreenthreadUsage {
    fn new(pool: GreenthreadPool) -> GreenthreadUsage {
        GreenthreadUsage {
            used_capacity: 0,
            pool,
        }
    }

    fn use_thread(&mut self, id: u32, capacity: u32) -> bool {
        if self.used_capacity + capacity > self.pool.capacity_capacity {
            false
        } else {
            self.used_capacity += capacity;
            true
        }
    }

    fn release_thread(&mut self, id: u32, capacity: u32) -> bool {
        if self.used_capacity < capacity {
            false
        } else {
            self.used_capacity -= capacity;
            true
        }
    }
}

// Greenthread Task
#[derive(Debug)]
struct GreenthreadTask {
    id: u32,
    priority: u8,
    action: Box<dyn Fn() + Send + Sync>, // Plus for the trait objects
    running: bool,
}

impl GreenthreadTask {
    fn new(id: u32, priority: u8, action: Box<dyn Fn() + Send + Sync>) -> GreenthreadTask {
        GreenthreadTask {
            id,
            priority,
            action,
            running: false,
        }
    }
}

// Greenthread Manager
struct GreenthreadManager {
    pool: GreenthreadPool,
    usage: GreenthreadUsage,
    tasks: HashMap<u32, GreenthreadTask>,
    next_task_id: u32,
}

impl GreenthreadManager {
    fn new(pool: GreenthreadPool) -> GreenthreadManager {
        GreenthreadManager {
            pool,
            usage: GreenthreadUsage::new(pool),
            tasks: HashMap::new(),
            next_task_id: 0,
        }
    }

    fn add_task(&mut self, priority: u8, action: Box<dyn Fn() + Send + Sync>) {
        let id = self.next_task_id;
        self.next_task_id += 1;

        let task = GreenthreadTask::new(id, priority, action);
        self.tasks.insert(id, task);
    }

    // Allocating resources to a task
    fn allocate_resources(&mut self, id: u32, capacity: u32) -> bool {
        if self.usage.use_thread(id, capacity) {
            self.tasks.get_mut(&id).map(|task| {
                task.running = true;
            });

            true
        } else {
            false
        }
    }

    // Releasing resources from a task
    fn release_resources(&mut self, id: u32, capacity: u32) -> bool {
        if self.usage.release_thread(id, capacity) {
            self.tasks.get_mut(&id).map(|task| {
                task.running = false;
            });

            true
        } else {
            false
        }
    }

    // Run all running tasks
    fn run_tasks(&mut self) {
        for (_, task) in &mut self.tasks {
            if task.running {
                (task.action)();
            }
        }
    }
}

// Greenovation Main Function
fn greenovation() -> io::Result<()> {
    // Setting up the Greenthread pool
    let mut pool = GreenthreadPool::new(8);
    pool.add_thread(String::from("Thread 1"), 1, 2);
    pool.add_thread(String::from("Thread 2"), 2, 2);
    pool.add_thread(String::from("Thread 3"), 3, 2);
    pool.add_thread(String::from("Thread 4"), 4, 2);

    // Setting up the Greenthread manager
    let mut manager = GreenthreadManager::new(pool);

    // Adding tasks to the manager
    manager.add_task(
        8,
        Box::new(|| {
            println!("Task 1 has started!");
            // Simulated task
            for _ in 0..2000000 {
            }
            println!("Task 1 has completed!");
        }
    ));

    manager.add_task(
        5,
        Box::new(|| {
            println!("Task 2 has started!");
            // Simulated task
            for _ in 0..5000000 {
            }
            println!("Task 2 has completed!");
        }
    ));

    // Allocating resources to tasks
    manager.allocate_resources(1, 2);
    manager.allocate_resources(2, 2);

    // Running the tasks
    manager.run_tasks();

    // Releasing resources from tasks
    manager.release_resources(1, 2);
    manager.release_resources(2, 2);

    // Updating thread capacity
    pool.update_capacity(2, 4);

    Ok(())
}

// Main function
fn main() {
    greenovation().unwrap();
}