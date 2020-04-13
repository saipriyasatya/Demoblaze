package com.Demoblaze.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Demoblaze.pages.Login_Page;
import com.Demoblaze.pages.SignUp_Page;
import com.Demoblaze.utility.BrowserFactory;
import com.Demoblaze.utility.ConfigReader;
import com.Demoblaze.utility.ExcelDataConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This program is used for automating demoblaze website particularly tests Sign-up operation in website
 * This program particularly clicks the sign-up button, reads the credentials from excel sheet and performs sign-up operation
 */
public class SignUp_StepDefinition {
	public WebDriver driver;
	ConfigReader conf = new ConfigReader();
	Login_Page s = new Login_Page(driver);
	ExcelDataConfig configExcel=new ExcelDataConfig(conf.getExcelpath());
	BrowserFactory b = new BrowserFactory();
	Logger logger;

	/**
	 * The ExtentReports class is used to generate extent reports to check whether a particular test case is passed or failed 
	 */
	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport_Signup.html");
	ExtentTest test = report.startTest("Sign up Test");

	/**
	 * This method launches the browser and navigates to demoblaze.com
	 */

	@Given("^Open chrome and navigate to url$")
	public void open_chrome_and_navigate_to_url() throws Throwable {
		logger = Logger.getLogger("SignUpStepDefinition");
		PropertyConfigurator.configure("Log4j.properties"); 
		driver = b.startBrowser("chrome", conf.getApplicationURL());
		logger.info(" Browser is opened and Navigated to url");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/");
		test.log(LogStatus.PASS,"Browser is opened and Navigated to url");

	}

	/**
	 * 
	 * This method is used to read the valid user name and password from the excel sheet
	 */
	@When("^user enters valid \"([^\"]*)\"$")
	public void user_enters_valid(String usernameNumber) throws Throwable {
		SignUp_Page obj = PageFactory.initElements(driver,SignUp_Page.class);
		obj.firstSignUp();
		logger.info(" Click action performed on SignUp link ");
		Object[][] data=configExcel.passData();
		String username="";
		String password="";

		if(null!= usernameNumber ) {
			int userCount = Integer.parseInt(usernameNumber.trim());

			username = (String )data[userCount+1][0];
			password = (String )data[userCount+1][1];	

		}
		obj.userSignUp(username, password);
		Assert.assertEquals(username, "demo");
		Assert.assertEquals(password, "demo111");
		test.log(LogStatus.PASS,"Credentials Entered");
		logger.info(" Credentials Entered are-->"  + "username: "+username + " password: " +password);
	}

	/**
	 * This method is used to click on the sign up button
	 * @throws Throwable
	 */
	@When("^user clicks signup user should be able to SignUp$")
	public void user_clicks_signup_user_should_be_able_to_SignUp() throws Throwable {
		SignUp_Page obj = PageFactory.initElements(driver,SignUp_Page.class);
		obj.clickSignUpButton();
		logger.info(" Click action performed on SignUp Button");
		test.log(LogStatus.PASS,"Click action performed on SignUp Button");
	}

	/**
	 * This method is used to handle the pop-upand display whether the sign up was successful 
	 * @throws Throwable
	 */
	@When("^user handles popup$")
	public void user_handles_popup() throws Throwable {
		Alert PopUpName = driver.switchTo().alert();
		String errormessage =  PopUpName.getText();
		System.out.println("-------------------------------------------->  pop-up says: " + errormessage);
		Thread.sleep(2000);
		PopUpName.accept();
		logger.info(" pop-up handled");
		Assert.assertEquals(errormessage, "This user already exist.");
		test.log(LogStatus.PASS,"Sign up Successful");

	}

	/**
	 * This method is used to close the browser
	 * @throws Throwable
	 */
	@Then("^Browser is closed$")
	public void browser_is_closed() throws Throwable {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		b.quit();
		logger.info("Browser is closed");
		test.log(LogStatus.PASS,"Browser is closed");
		report.endTest(test);
		report.flush();


	}
}
