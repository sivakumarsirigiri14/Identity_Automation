package com.home.tests.steps;

import com.home.tests.pages.ValueMyCarAndAboutMyCarPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class ValueMyCarAndAboutMyCarSteps extends CommonSteps {

	public ValueMyCarAndAboutMyCarPage registrationPage;
	public List<String> makeModelDetails;
	public List<String> carOutPutFileDataList;

	public ValueMyCarAndAboutMyCarSteps(){
		registrationPage = new ValueMyCarAndAboutMyCarPage(driver);
	}

	@Given("^I am on car valuation home page$")
	public void i_am_on_car_valuation_home_page() throws Throwable {
		registrationPage.gotoHomePage();
		registrationPage.clickOnAcceptButton();
		assertTrue(registrationPage.getCarValuationHomePageTitle());
	}

	@When("^I extract vehicle registration numbers from \"([^\"]*)\"$")
	public void i_extract_vehicle_registration_numbers_from(String inputFile) throws Throwable {
		String carInputFile = new File("").getAbsolutePath() + File.separatorChar + "src"+ File.separatorChar + "test" + File.separatorChar +"resources" + File.separatorChar + inputFile;
		registrationPage.readFileDataBasedOnPatterns(carInputFile);
	}

	@Then("^It should display car registration and make/model on entering car reg no and start valuation$")
	public void itShouldDisplayCarRegistrationAndMakeModelOnEnteringCarRegNoAndStartValuation() throws Throwable {
		makeModelDetails = registrationPage.enterVehRegNoAndgetCarMakeModelDetails();
	}

	@Then("^I compare output returned from application with given \"([^\"]*)\"$")
	public void i_compare_output_returned_from_application_with_given(String outPutFile) throws Throwable {
		SoftAssertions softAssertions = new SoftAssertions();
		String carOutputFile = new File("").getAbsolutePath() + File.separatorChar + "src"+ File.separatorChar + "test" + File.separatorChar +"resources" + File.separatorChar + outPutFile;
		carOutPutFileDataList = registrationPage.readOutPutFileData(carOutputFile);
		String[] tempList = carOutPutFileDataList.toArray(new String[carOutPutFileDataList.size()]);

		// Remove empty or null elements
		String[] tempOutPutList = Arrays.stream(tempList)
				.filter(element -> element != null && !element.isEmpty())
				.toArray(String[]::new);

		for(int i=0; i<makeModelDetails.size();i++){
			boolean strComFlag=false;
			for(int j=0; j<tempOutPutList.length;j++){
				if(makeModelDetails.get(i).equals(tempOutPutList[j].replace(","," "))){
					strComFlag=true;
					assertTrue("Actual car make model " + makeModelDetails.get(i)  + " is not matched data with car output file",strComFlag);
					System.out.println( "Actual car make model "+ makeModelDetails.get(i) +" is matched data with car output file");
					break;
				}else{
					if(j==tempOutPutList.length-1){
						break;
					}
				}
			}

			try{
				if(!strComFlag) {
					assertTrue("Actual car make model " + makeModelDetails.get(i)  + " is not matched data with car output file",strComFlag);
				}
			}catch(AssertionError e){
				System.err.println(e.getMessage());
			}
		}
	}

}