#Greenovation

#importing required libraries
import time
import pandas as pd
import numpy as np
from matplotlib import pyplot as plt

#Defining a function to calculate the cost of green energy
def green_energy_cost(green_energy_unit, state, rate):
    '''
    Parameters:
    green_energy_unit: Green energy unit used to calculate the cost
    state: State of residence
    rate: Cost per green energy unit
    
    Returns:
    Cost for the green energy units
    '''
    cost = green_energy_unit * rate[state]
    return cost

#Defining a function to calculate the savings from using green energy
def green_energy_savings(previous_energy_usage, green_energy_usage):
    '''
    Parameters:
    previous_energy_usage: Previous energy usage
    green_energy_usage: Green energy usage
    
    Returns:
    Savings from using green energy
    '''
    savings = previous_energy_usage - green_energy_usage
    return savings

#Defining a function to calculate the carbon emissions saved by using green energy
def carbon_emissions_saved(previous_emissions, green_energy_usage):
    '''
    Parameters:
    previous_emissions: Previous emissions
    green_energy_usage: Green energy usage
    
    Returns:
    Carbon emissions saved by using green energy
    '''
    emissions_saved = previous_emissions - (green_energy_usage * 0.000464)
    return emissions_saved

#Defining a function to generate a report
def generate_report(previous_energy_usage, green_energy_usage, cost, savings, emissions_saved):
    '''
    Parameters:
    previous_energy_usage: Previous energy usage
    green_energy_usage: Green energy usage
    cost: Cost for the green energy units
    savings: Savings from using green energy
    emissions_saved: Carbon emissions saved by using green energy
    
    Returns:
    A report containing information about the green energy usage
    '''
    report_data = {
        "Previous Energy Usage": previous_energy_usage,
        "Green Energy Usage": green_energy_usage,
        "Cost": cost,
        "Savings": savings,
        "Carbon Emissions Saved": emissions_saved
    }
    
    report = pd.DataFrame(report_data, index=['Green Energy Usage'])
    report.index.name = 'Details'
    
    return report

#Defining a function to plot a graph
def plot_graph(previous_energy_usage, green_energy_usage):
    '''
    Parameters:
    previous_energy_usage: Previous energy usage
    green_energy_usage: Green energy usage
    
    Returns:
    A graph indicating the previous and new energy usage
    '''
    x_values = [0,1]
    y_values = [previous_energy_usage, green_energy_usage]
    
    plt.plot(x_values, y_values)
    plt.title("Energy Usage Comparison")
    plt.xlabel("Green Energy Usage")
    plt.ylabel("Energy Usage (kwh)")
    plt.show()

#Defining a main function
def greenovation(state, rate, previous_energy_usage, green_energy_usage):
    '''
    Parameters:
    state: State of residence
    rate: Cost per green energy unit
    previous_energy_usage: Previous energy usage
    green_energy_usage: Green energy usage
    
    Returns:
    A report of the green energy usage and a graph indicating the previous and new energy usage
    '''

    #Calculating the cost
    cost = green_energy_cost(green_energy_usage, state, rate)
    #Calculating the savings
    savings = green_energy_savings(previous_energy_usage, green_energy_usage)
    #Calculating the carbon emissions saved
    emissions_saved = carbon_emissions_saved(previous_energy_usage, green_energy_usage)
    #Generating a report
    report = generate_report(previous_energy_usage, green_energy_usage, cost, savings, emissions_saved)
    #Plotting a graph
    plot_graph(previous_energy_usage, green_energy_usage)

    return report

#Taking user input
state = input("Enter the state of residence: ")
rate = float(input("Enter the cost per green energy unit: "))
previous_energy_usage = float(input("Enter the previous energy usage (kwh): "))
green_energy_usage = float(input("Enter the green energy usage (kwh): "))

#Calling the main function
greenovation_report = greenovation(state, rate, previous_energy_usage, green_energy_usage)

#Printing the report
print("\nGreen Energy Usage Report: \n")
print(greenovation_report)