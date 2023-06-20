# install and load required packages
install.packages('tidyverse') 
library(tidyverse)

# define a dataframe that includes characteristics of Greenovation
greenovation <- data.frame(
  color = c("Green", "Blue", "Orange"),
  description = c("Innovation", "Technology", "Eco-Friendly")
)

# create a function to print out Greenovation's characteristics
green_characteristics <- function(){
  print("Greenovation is characterized by:")
  for(i in 1:nrow(greenovation)) {
    print(paste0(greenovation$color[i], ": ", greenovation$description[i], sep=""))
  }
}

# create a dataframe of activities related to Greenovation
greenovation_activities <- data.frame(
  activity = c("Recycle", "Reduce Waste", "Educate"),
  description = c("Conserve Resources", "Cut Carbon Footprint", "Spread Awareness")
)

# create a function to print out Greenovation activities
green_activities <- function(){
  print("Greenovation activities include:")
  for(i in 1:nrow(greenovation_activities)) {
    print(paste0(greenovation_activities$activity[i], ": ", 
                 greenovation_activities$description[i], sep=""))
  }
}

# create a dataframe of organizations related to Greenovation
greenovation_orgs <- data.frame(
  name = c("Greenpeace", "WWF", "Solar Schools"),
  country = c("International", "International", "US"),
  focus = c("Environmentalism", "Conservation", "Renewable Energy")
)

# create a function to print out organizations related to Greenovation
green_orgs <- function(){
  print("Organizations related to Greenovation include:")
  for(i in 1:nrow(greenovation_orgs)) {
    print(paste0(greenovation_orgs$name[i], " in ", greenovation_orgs$country[i], 
                 " focusing on ", greenovation_orgs$focus[i], sep=""))
  }
}

# create a main function to serve as an entry point
greenovation_summary <- function(){
  green_characteristics()
  print("")
  green_activities()
  print("")
  green_orgs()
}

# call the main entry point function
greenovation_summary()