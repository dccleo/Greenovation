package main

import (
	"fmt"
)

//Greenovation is a company that focuses on greener energy solutions
func main() {
	fmt.Println("Welcome to Greenovation")
}

//Prime calculates the nth prime
func Prime(n int) int {
	if n < 2 {
		return 0
	}

	p := make([]int, n)
	p[0] = 2

	// populate the array with prime numbers
	for i := 1; i < n; i++ {
		x := p[i-1] + 1
		for {
			isPrime := true
			for _, v := range p {
				if x%v == 0 {
					isPrime = false
					break
				}
			}
			if isPrime {
				p[i] = x
				break
			}
			x++
		}
	}
	return p[n-1]
}

//Fibonacci calculates the nth Fibonacci number
func Fibonacci(n int) int {
	if n < 0 {
		return 0
	}
	if n == 0 {
		return 0
	}
	if n == 1 {
		return 1
	}

	return Fibonacci(n-1) + Fibonacci(n-2)
}

//SolarEnergy is a function that is used to measure the amount of solar energy produced
func SolarEnergy(hours int) float64 {
	//measure amount of solar energy produced in kWh
	const kWhPerHour = 0.08
	return float64(hours) * kWhPerHour
}

//WindEnergy is a function that is used to measure the amount of wind energy produced
func WindEnergy(hours int) float64 {
	//measure amount of wind energy produced in MWh
	const MWhPerHour = 0.1
	return float64(hours) * MWhPerHour
}

//HydroEnergy is a function that is used to measure the amount of hydro energy produced
func HydroEnergy(hours int) float64 {
	//measure amount of hydro energy produced in kWh
	const kWhPerHour = 1.2
	return float64(hours) * kWhPerHour
}

//CalculateEnergy calculates the total amount of energy produced
func CalculateEnergy(solar, wind, hydro int) float64 {
	return SolarEnergy(solar) + WindEnergy(wind) + HydroEnergy(hydro)
}

//EcoFriendly paints calculates the environmental impact of the paint
func EcoFriendlyPaints(liters int) float64 {
	//measure in carbon emissions reduced
	const emissionsPerLiter = 0.05
	return float64(liters) * emissionsPerLiter
}

//RecycledMaterials calculates the environmental benefits of using recycled materials
func RecycledMaterials(liters int) float64 {
	//measure in carbon emissions reduced
	const emissionsPerLiter = 0.1
	return float64(liters) * emissionsPerLiter
}

//CalculateEcoImpact calculates the total environmental impact
func CalculateEcoImpact(ecoFriendly, recycled int) float64 {
	return EcoFriendlyPaints(ecoFriendly) + RecycledMaterials(recycled)
}

//LEDLighting calculates the cost savings of using LED lighting
func LEDLighting(liters int) float64 {
	//measure in cost savings
	const costSavingsPerLiter = 0.07
	return float64(liters) * costSavingsPerLiter
}

//CleanWater calculates the cost savings of using clean water
func CleanWater(liters int) float64 {
	//measure in cost savings
	const costSavingsPerLiter = 0.1
	return float64(liters) * costSavingsPerLiter
}

//CalculateCostSavings calculates the total cost savings
func CalculateCostSavings(led, cleanWater int) float64 {
	return LEDLighting(led) + CleanWater(cleanWater)
}

//DevelopSoftware is a function that is used to measure the cost savings for software development
func DevelopSoftware(hours int) float64 {
	//measure cost savings in hours
	const costSavingsPerHour = 0.2
	return float64(hours) * costSavingsPerHour
}

//Consulting is a function that is used to measure the cost savings for consulting
func Consulting(hours int) float64 {
	//measure cost savings in hours
	const costSavingsPerHour = 0.3
	return float64(hours) * costSavingsPerHour
}

//CalculateServicesCostSavings calculates the total cost savings for services
func CalculateServicesCostSavings(software, consulting int) float64 {
	return DevelopSoftware(software) + Consulting(consulting)
}

//ElectricVehicles calculates the cost savings of using electric vehicles
func ElectricVehicles(miles int) float64 {
	//measure in cost savings
	const costSavingsPerMile = 0.06
	return float64(miles) * costSavingsPerMile
}

//PublicTransportation calculates the cost savings of using public transportation
func PublicTransportation(miles int) float64 {
	//measure in cost savings
	const costSavingsPerMile = 0.08
	return float64(miles) * costSavingsPerMile
}

//CalculateTransitCostSavings calculates the total cost savings for transit
func CalculateTransitCostSavings(electric, public int) float64 {
	return ElectricVehicles(electric) + PublicTransportation(public)
}

//EcoFriendlyWorkers calculates the cost savings of hiring eco friendly workers
func EcoFriendlyWorkers(hours int) float64 {
	//measure in cost savings
	const costSavingsPerHour = 0.4
	return float64(hours) * costSavingsPerHour
}

//LocalOrganicFood calculates the cost savings of using local, organic food
func LocalOrganicFood(meals int) float64 {
	//measure in cost savings
	const costSavingsPerMeal = 0.3
	return float64(meals) * costSavingsPerMeal
}

//CalculateFoodCostSavings calculates the total cost savings for food
func CalculateFoodCostSavings(ecoFriendly, localOrganic int) float64 {
	return EcoFriendlyWorkers(ecoFriendly) + LocalOrganicFood(localOrganic)
}

//Paperless calculates the cost savings of going paperless
func Paperless(pages int) float64 {
	//measure in cost savings
	const costSavingsPerPage = 0.01
	return float64(pages) * costSavingsPerPage
}

//DigitalBilling calculates the cost savings of using digital billing
func DigitalBilling(invoices int) float64 {
	//measure in cost savings
	const costSavingsPerInvoice = 0.02
	return float64(invoices) * costSavingsPerInvoice
}

//CalculatePaperCostSavings calculates the total cost savings for paper
func CalculatePaperCostSavings(paperless, digitalBilling int) float64 {
	return Paperless(paperless) + DigitalBilling(digitalBilling)
}

//EnergyMonitor is a function that is used to monitor energy usage
func EnergyMonitor(simulations int) float64 {
	//measure cost savings in simulations
	const costSavingsPerSimulation = 0.2
	return float64(simulations) * costSavingsPerSimulation
}

//GreenBuilding calculates the cost savings of using green building materials
func GreenBuilding(liters int) float64 {
	//measure in cost savings
	const costSavingsPerLiter = 0.4
	return float64(liters) * costSavingsPerLiter
}

//CalculateBuildingCostSavings calculates the total cost savings for buildings
func CalculateBuildingCostSavings(energyMonitor, greenBuilding int) float64 {
	return EnergyMonitor(energyMonitor) + GreenBuilding(greenBuilding)
}

//GreenOfficeSupplies calculates the cost savings of using green office supplies
func GreenOfficeSupplies(items int) float64 {
	//measure in cost savings
	const costSavingsPerItem = 0.1
	return float64(items) * costSavingsPerItem
}

//Recycling calculates the cost savings of recycling
func Recycling(items int) float64 {
	//measure in cost savings
	const costSavingsPerItem = 0.05
	return float64(items) * costSavingsPerItem
}

//CalculateSupplyCostSavings calculates the total cost savings for supplies
func CalculateSupplyCostSavings(greenOffice, recycling int) float64 {
	return GreenOfficeSupplies(greenOffice) + Recycling(recycling)
}

//GreenComputing calculates the cost savings of using green computing
func GreenComputing(hours int) float64 {
	//measure in cost savings
	const costSavingsPerHour = 0.15
	return float64(hours) * costSavingsPerHour
}

//GreenDataCenters calculates the cost savings of using green data centers
func GreenDataCenters(kwh int) float64 {
	//measure in cost savings
	const costSavingsPerKwh = 0.2
	return float64(kwh) * costSavingsPerKwh
}

//CalculateComputingCostSavings calculates the total cost savings for computing
func CalculateComputingCostSavings(greenComputing, greenDataCenters int) float64 {
	return GreenComputing(greenComputing) + GreenDataCenters(greenDataCenters)
}

//GreenCleaning calculates the cost savings of using green cleaning
func GreenCleaning(liters int) float64 {
	//measure in cost savings
	const costSavingsPerLiter = 0.2
	return float64(liters) * costSavingsPerLiter
}

//EnergyEfficiency calculates the cost savings of using energy efficiency
func EnergyEfficiency(hours int) float64 {
	//measure in cost savings
	const costSavingsPerHour = 0.3
	return float64(hours) * costSavingsPerHour
}

//CalculateCleaningCostSavings calculates the total cost savings for cleaning
func CalculateCleaningCostSavings(greenCleaning, energyEfficiency int) float64 {
	return GreenCleaning(greenCleaning) + EnergyEfficiency(energyEfficiency)
}