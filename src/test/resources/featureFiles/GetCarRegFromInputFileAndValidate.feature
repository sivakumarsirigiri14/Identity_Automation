@vehicleregistration
Feature: Validate Car Registration numbers
  
  Scenario Outline: : verify to input extracted car Registration numbers from Input file and search in car valuation page and compare output registration, make or model against car out file data
	Given I am on car valuation home page
	When I extract vehicle registration numbers from <Inputfile>
	Then It should display car registration and make/model on entering car reg no and start valuation
	And I compare output returned from application with given <OutputFile>
	
	Examples:
	  
	  | Inputfile       | OutputFile       |
	  | "car_input.txt" | "car_output.txt" |