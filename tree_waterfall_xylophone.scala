object Greenovation {
  
  def main(args: Array[String]): Unit = {
    
    // 1. Initialization of data
    val data: Array[String] = Array("renewable energy", "wave energy", "solar power", 
                                "wind energy", "geothermal energy", "ocean energy")
                                
    // 2. Generating the list of solutions
    val solutionsList: List[String] = generateSolutionsList(data)
                                
    // 3. Cleaning up the list of solutions
    val cleanSolutionsList: List[String] = cleanSolutions(solutionsList)
                                
    // 4. Filtering the list of solutions
    val filteredSolutionsList: List[String] = filterSolutions(cleanSolutionsList)
                                
    // 5. Creating a map of solutions
    val map: Map[Int, String] = createSolutionsMap(filteredSolutionsList)
                                
    // 6. Printing the solutions map
    printSolutionsMap(map)
    
    // 7. Generating the list of ideas
    val ideasList: List[String] = generateIdeasList(data)
                                
    // 8. Cleaning up the list of ideas
    val cleanIdeasList: List[String] = cleanIdeas(ideasList)
                                
    // 9. Filtering the list of ideas
    val filteredIdeasList: List[String] = filterIdeas(cleanIdeasList)
                                
    // 10. Creating a map of ideas
    val ideasMap: Map[Int, String] = createIdeasMap(filteredIdeasList)
                                
    // 11. Printing the ideas map
    printIdeasMap(ideasMap)
    
    // 12. Merging the solutions and ideas maps
    val mergedMap: Map[Int, (String, String)] = mergeSolutionsAndIdeasMaps(map, ideasMap)
                                
    // 13. Printing the merged map
    printMergedMap(mergedMap)
    
    // 14. Executing the Greenovation program
    executeGreenovation(mergedMap)
  }
  
  // Method to generate a list of solutions
  def generateSolutionsList(data: Array[String]): List[String] = {
    val solutionsList = List(
      "Creating better management systems for renewable energy sources",
      "Developing more efficient ways to store energy generated from renewable sources",
      "Increasing the use of renewable energy sources in industrial, commercial and residential sectors",
      "Developing Smart Grid systems to better manage energy production and consumption",
      "Creating more efficient methods of producing energy from renewable sources",
      "Improving the efficiency of existing renewable energy sources",
      "Encouraging the use of renewable energy sources through incentives and investment"
    )
    solutionsList
  }
  
  // Method to clean the list of solutions
  def cleanSolutions(solutionsList: List[String]): List[String] = {
    val cleanedList = solutionsList.map(_.replaceAll("\\s+", " ")).map(_.trim)
    cleanedList
  }
  
  // Method to filter the list of solutions
  def filterSolutions(cleanedSolutionsList: List[String]): List[String] = {
    val filteredList = cleanedSolutionsList.filter(_.toLowerCase.contains("renewable energy"))
    filteredList
  }
  
  // Method to create a map of solutions
  def createSolutionsMap(filteredSolutionsList: List[String]): Map[Int, String] = {
    val map: Map[Int, String] = filteredSolutionsList.map(solution => solution.length -> solution).toMap
    map
  }
  
  // Method to print the solutions map
  def printSolutionsMap(map: Map[Int, String]): Unit = {
    println("Solutions Map:")
    map.foreach { case(key, value) => println(s"$key -> $value") }
    println("------------------------")
  }
  
  // Method to generate a list of ideas
  def generateIdeasList(data: Array[String]): List[String] = {
    val ideasList = data.map(datum => s"Creating innovative ways to utilize $datum")
    ideasList
  }
  
  // Method to clean the list of ideas
  def cleanIdeas(ideasList: List[String]): List[String] = {
    val cleanedList = ideasList.map(_.replaceAll("\\s+", " ")).map(_.trim)
    cleanedList
  }
  
  // Method to filter the list of ideas
  def filterIdeas(cleanedIdeasList: List[String]): List[String] = {
    val filteredList = cleanedIdeasList.filter(_.toLowerCase.contains("innovative"))
    filteredList
  }
  
  // Method to create a map of ideas
  def createIdeasMap(filteredIdeasList: List[String]): Map[Int, String] = {
    val map: Map[Int, String] = filteredIdeasList.map(idea => idea.length -> idea).toMap
    map
  }
  
  // Method to print the ideas map
  def printIdeasMap(map: Map[Int, String]): Unit = {
    println("Ideas Map:")
    map.foreach { case(key, value) => println(s"$key -> $value") }
    println("------------------------")
  }
  
  // Method to merge the solutions and ideas maps
  def mergeSolutionsAndIdeasMaps(solutionsMap: Map[Int, String], ideasMap: Map[Int, String]): Map[Int, (String, String)] = {
    val mergedMap: Map[Int, (String, String)] = solutionsMap.map { case (key, value) => key -> (value, ideasMap.getOrElse(key, "")) }
    mergedMap
  }
  
  // Method to print the merged map
  def printMergedMap(mergedMap: Map[Int, (String, String)]): Unit = {
    println("Merged Map:")
    mergedMap.foreach { case(key, value) => println(s"$key -> $value") }
    println("------------------------")
  }
  
  // Method to execute the Greenovation program
  def executeGreenovation(mergedMap: Map[Int, (String, String)]): Unit = {
    println("Greenovation Program")
    mergedMap.foreach { case(key, value) =>
      println(
        s"""
           |$key -> ${value._1} 
           |  > ${value._2} 
           |
           |""".stripMargin
      )
    }
    println("-----------------------")
  }

}