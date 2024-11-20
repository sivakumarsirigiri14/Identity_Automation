package com.home.tests.pages;

import com.home.tests.test.configutils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValueMyCarAndAboutMyCarPage {

    private WebDriver driver;

    @FindBy(id = "btn-go")
    private WebElement getMyCarValuationBtn;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(id = "vehicleReg")
    private WebElement vehicleRegNumber;

    @FindBy(id = "Mileage")
    private WebElement mileage;

    @FindBy(xpath = "//p[contains(text(), 'car valuation')]")
    private WebElement carValuationTitle;

    @FindBy(css = ".d-sm-block.order-2>div > vehicle-details > div.d-none.d-lg-block.vehicle-details>#vehicleImage>.details-vrm.ng-star-inserted")
    private WebElement vehicleNumber;

    @FindBy(css = ".d-sm-block.order-2>div > vehicle-details > div.d-none.d-lg-block.vehicle-details > div.d-table > div:nth-child(1) > div.d-table-cell.value")
    private WebElement vehicleMake;

    @FindBy(css = ".d-sm-block.order-2>div > vehicle-details > div.d-none.d-lg-block.vehicle-details > div.d-table > div:nth-child(2) > div.d-table-cell.value")
    private WebElement vehicleModel;

    @FindBy(css = ".d-sm-block.order-2>div > vehicle-details > div.d-none.d-lg-block.vehicle-details > div.d-table > div:nth-child(3) > div.d-table-cell.value")
    private WebElement vehicleYear;

    @FindBy(css = ".text-focus.ng-star-inserted")
    private WebElement checkCarNotFoundMessage;

    private List<String> vehicleList;

    public void clearRegNoBox() {
        vehicleRegNumber.clear();
    }

    public ValueMyCarAndAboutMyCarPage(WebDriver driver) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }

    public void gotoHomePage() {
        driver.get(ConfigUtils.getWebEndPoint());
    }

    public void clickOnAcceptButton(){
        if(acceptCookies.isDisplayed()){
            acceptCookies.click();
        }
    }

    public void setValueMileageInputBox() {
        int randomMileage  = (int) (Math.random() * (50000 - 10000 + 1)) + 10000;
        mileage.sendKeys(String.valueOf(randomMileage));
    }

    public List<String> enterVehRegNoAndgetCarMakeModelDetails() {
        String vehDetailsAre=null;
        List<String> makeModelDetailsList = new ArrayList<String>();
        for(int i=0;i<vehicleList.size();i++) {
            vehicleRegNumber.sendKeys(vehicleList.get(i));
            setValueMileageInputBox();
            clickOnValueMyCarBtn();
            String actualVal = "";
            String notFoundMsg = getCheckCarNotFoundMessage();
            if(notFoundMsg.contains("Sorry")) {
                vehDetailsAre = vehicleList.get(i)+ " is not displayed and error is: " + notFoundMsg;
            }
            else{
                actualVal= getVehicleNumber()+" "+getMake()+" "+getModel()+" "+getYear();
                vehDetailsAre = actualVal;
            }
            makeModelDetailsList.add(vehDetailsAre);
            gotoHomePage();
            clearRegNoBox();
        }
        return makeModelDetailsList;
    }

    public void clickOnValueMyCarBtn(){
        getMyCarValuationBtn.click();
    }

    public boolean getCarValuationHomePageTitle(){
        return carValuationTitle.isDisplayed();
    };

    public String getMake(){
        return vehicleMake.getText();
    }
    public String getModel(){
        return vehicleModel.getText();
    }

    public String getYear(){
        return vehicleYear.getText();
    }

    public String getVehicleNumber() {
        return vehicleNumber.getText();
    }

    public String getCheckCarNotFoundMessage() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            String textVal = checkCarNotFoundMessage.getText();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return textVal;
        }
        catch (Exception e) {
            return "not found";
        }
    }

    public void readFileDataBasedOnPatterns(String fileToRead) {
        ArrayList<String> vehList = new ArrayList<String>();
        String input = "[A-Z]{2}[0-9]{2}\\s[A-Z]{3}|[A-Z]{2}[0-9]{2}[A-Z]{3}";
        try
        {
            File file=new File(fileToRead);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String line;
            while((line=br.readLine())!=null)
            {
                Pattern p = Pattern.compile(input);
                Matcher m = p.matcher(line);
                while(m.find()){
                    String b = m.group(0);
                    vehList.add(b.replace(" ",""));
                }
                vehicleList=vehList;
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public List<String> readOutPutFileData(String outPutfileToRead) {
        ArrayList<String> outPutfileData = new ArrayList<String>();
        try
        {
            File file=new File(outPutfileToRead);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null)
            {
                outPutfileData.add(line);
            }
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return outPutfileData;
    }
}
