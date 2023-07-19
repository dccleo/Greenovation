object Greenovation {
  ////Function to compare two integers
  def compareInts(a: Int, b: Int) : Int = {
    if (a == b) 0
    else if (a < b) -1
    else 1
  }

  ////Function to check if an integer is odd
  def isOdd(n: Int) : Boolean = {
    n % 2 != 0
  }

  ////Function to find the maximum value from a list of integers
  def maxIntFromList(lst: List[Int]) : Int = {
    lst.reduceLeft(Math.max)
  }

  ////Function to find the sum of all integers in a given range
  def sumRange(r: Range) : Int = {
    r.sum
  }

  ////Function to check if a given string is a palindrome
  def isPalindrome(str: String) : Boolean = {
    str == str.reverse
  }

  ////Function to calculate the factorial of a number
  def factorial(n: Int) : Int = {
    if (n <= 0) 1
    else factorial(n - 1) * n
  }

  ////Function to find the GCD of two numbers
  def GCD(a: Int, b: Int) : Int = {
    if (b == 0) a
    else GCD(b, a % b)
  }

  ////Function to check if a number is prime
  def isPrime(n: Int) : Boolean = {
    if (n <= 1) false
    else if (n == 2) true
    else !(2 to (n - 1)).exists(x => n % x == 0)
  }

  ////Function to check if a number is perfect
  def isPerfect(n: Int) : Boolean = {
    (1 until n).filter(x => n % x == 0).sum == n
  }

  ////Function to check if a number is abundant
  def isAbundant(n: Int) : Boolean = {
    (1 until n).filter(x => n % x == 0).sum > n
  }

  ////Function to check if a number is deficient
  def isDeficient(n: Int) : Boolean = {
    (1 until n).filter(x => n % x == 0).sum < n
  }

  ////Function to check if a number is a Fibonacci number
  def isFiboNum(n: Int) : Boolean = {
    if (n == 0 || n == 1) true
    else isFiboNum(n - 1) && isFiboNum(n - 2)
  }

  ////Function to check if a number is an Armstrong number
  def isArmstrong(n: Int) : Boolean = {
    val numDigits = n.toString.length
    n == n.toString.map(x => Math.pow(x.asDigit, numDigits)).sum
  }

  ////Function to check if a number is a multiple of another number
  def isMultiple(n: Int, m: Int) : Boolean = {
    n % m == 0
  }

  ////Function to check if a number is a multiple of two given numbers
  def isMultipleOfTwo(n: Int, m1: Int, m2: Int) : Boolean = {
    n % m1 == 0 && n % m2 == 0
  }

  ////Function to calculate the power of a number x raised to the power of y
  def power(x: Int, y: Int) : Int = {
    if (y == 0) 1
    else x * power(x, y - 1)
  }

  ////Function to check if a number is even
  def isEven(n: Int) : Boolean = {
    n % 2 == 0
  }

  ////Function to generate the nth Fibonacci number
  def fiboNumAt(n: Int) : Int = {
    if (n == 0 || n == 1) n
    else fiboNumAt(n - 1) + fiboNumAt(n - 2)
  }

  ////Function to generate the prime numbers up to a given number
  def primesUpTo(n: Int) : List[Int] = {
    if (n <= 1) List()
    else if (isPrime(n)) primesUpTo(n - 1) :+ n
    else primesUpTo(n - 1)
  }

  ////Function to return the number of digits in a number
  def numDigits(n: Int) : Int = {
    n.toString.length
  }

  ////Function to calculate the sum of digits in a number
  def sumDigits(n: Int) : Int = {
    n.toString.toList.map(_.asDigit).sum
  }

  ////Function to calculate the average of a given list of numbers
  def avg(lst: List[Int]) : Int = {
    lst.sum / lst.length
  }

  ////Function to check if a given string is a palindrome
  def isPalindrome(str: String) : Boolean = {
    str == str.reverse
  }

  ////Function to calculate the greatest common divisor of two numbers
  def GCDOfTwo(a: Int, b: Int) : Int = {
    if (b == 0) a
    else GCDOfTwo(b, a % b)
  }

  ////Function to calculate the least common multiple of two numbers
  def LCMOfTwo(a: Int, b: Int) : Int = {
    (a * b) / GCDOfTwo(a, b)
  }

  ////Function to calculate the square root of a number
  def squareRoot(n: Int) : Double = {
    Math.sqrt(n)
  }

  ////Function to find the mean of two numbers
  def meanOfTwo(a: Int, b: Int) : Double = {
    (a + b) / 2.0
  }

  ////Function to check if a number is divisible by three
  def divisibleByThree(n: Int) : Boolean = {
    n % 3 == 0
  }

  ////Function to generate a random integer
  def randomInt() : Int = {
    scala.util.Random.nextInt()
  }

  ////Function to generate a random double
  def randomDouble() : Double = {
    scala.util.Random.nextDouble()
  }

  ////Function to find the median of a given list of numbers
  def median(lst: List[Int]) : Double = {
    val (lower, upper) = lst.sortWith(_<_).splitAt(lst.size / 2)
    if (lst.size % 2 == 0) (lower.last + upper.head) / 2.0 else upper.head
  }

  ////Function to find the standard deviation of a given list of numbers
  def standardDeviation(lst: List[Int]) : Double = {
    val mean = lst.sum.toDouble / lst.length
    val squareDiffs = lst.map {x => Math.pow(x - mean, 2)}
    Math.sqrt(squareDiffs.sum / squareDiffs.length)
  }

  ////Function to check if the sum of two numbers is even
  def isSumEven(a: Int, b: Int) : Boolean = {
    isEven(a + b)
  }

  ////Function to check if the sum of two numbers is odd
  def isSumOdd(a: Int, b: Int) : Boolean = {
    isOdd(a + b)
  }

  ////Function to check if a number is divisible by both 5 and 7
  def isDivisibleByFiveAndSeven(n: Int) : Boolean = {
    isMultipleOfTwo(n, 5, 7)
  }

  ////Function to check if a number is a perfect square
  def isPerfectSquare(n: Int) : Boolean = {
    Math.sqrt(n).isWhole
  }

  ////Function to check if a number is a perfect cube
  def isPerfectCube(n: Int) : Boolean = {
    Math.cbrt(n).isWhole
  }

  ////Function to check if the sum of two numbers is a perfect square
  def isSumPerfectSquare(a: Int, b: Int) : Boolean = {
    isPerfectSquare(a + b)
  }

  ////Function to check if the sum of two numbers is a perfect cube
  def isSumPerfectCube(a: Int, b: Int) : Boolean = {
    isPerfectCube(a + b)
  }

  ////Function to calculate the distance between two points
  def distance(x1: Double, y1: Double, x2: Double, y2: Double) : Double = {
    Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
  }

  ////Function to return a list of prime numbers up to a given number
  def listPrimesUpTo(n: Int) : List[Int] = {
    (2 to n).filter(isPrime(_)).toList
  }

  ////Function to generate the unpaired elements of two given lists
  def unpairedElements(lst1: List[Int], lst2: List[Int]) : List[Int] = {
    lst1.diff(lst2) ++ lst2.diff(lst1)
  }

  ////Function to calculate the total sum of all elements in a list of lists
  def sumOfLists(lst: List[List[Int]]) : Int = {
    lst.flatten.sum
  }

  ////Function to reverse the elements of a list in place
  def reverseListInPlace(lst: List[Int]) : List[Int] = {
    lst.reverse
  }

}