package com.Demoblaze.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.Demoblaze.pages.Login_Page;
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
 *  This program is used for automating demoblaze website particularly tests Login option in website
 * This program particularly clicks the login button, reads the credentials from excel sheet and performs login operation
 */
public class Login_StepDefinition {

	public WebDriver driver;
	ConfigReader conf = new ConfigReader();
	Login_Page s = new Login_Page(driver);
	ExcelDataConfig configExcel=new ExcelDataConfig(conf.getExcelpath());
	BrowserFactory b = new BrowserFactory();
	Logger logger;
	/**
	 * The ExtentReports class is used to generate extent reports to check whether a particular test case is passed or failed 
	 */

	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport_Login.html");
	ExtentTest test = report.startTest("Login Test");
	/**
	 * This method launches the browser and navigates to demoblaze.com
	 * @throws Throwable
	 */
	@Given("^user in demoblaze homepage$")
	public void user_in_demoblaze_homepage() throws Throwable {
		logger = Logger.getLogger("LoginStepDefinition");
		PropertyConfigurator.configure("Log4j.properties"); 
		driver = b.startBrowser("chrome", conf.getApplicationURL());
		logger.info(" Browser is opened and Navigated to url");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/");
		test.log(LogStatus.PASS,"Browser is opened and Navigated to url");
	}
	/**
	 * This method is used to read the credentials from excel sheet
	 * @param usernameNumber
	 * @throws Throwable
	 */

	@When("^user enters  \"([^\"]*)\"$")
	public void user_enters(String usernameNumber) throws Throwable {
		Login_Page obj = PageFactory.initElements(driver,Login_Page.class);

		obj.firstlogin();
		logger.info(" Click action performed on Login link");
		Object[][] data=configExcel.passData();
		String username="";
		String password="";

		if(null!= usernameNumber ) {
			int userCount = Integer.parseInt(usernameNumber.trim());

			username = (String )data[userCount][0];
			password = (String )data[userCount][1];	
		}
		obj.userlogin(username,password);
		Assert.assertEquals(username, "demoblaze1");
		logger.info(" Credentials Entered are-->"  + "username: "+username + " password: " +password);
		Assert.assertEquals(password, "demoblaze123");
		test.log(LogStatus.PASS,"Credentials Entered");
	}
	/**
	 * This method is used to click the login button
	 * @throws Throwable
	 */
	@When("^user clicks login user should be able to login$")
	public void user_clicks_login_user_should_be_able_to_login() throws Throwable {
		Login_Page obj = PageFactory.initElements(driver,Login_Page.class);
		obj.clicklogin();
		b.sleep(3);
		Assert.assertEquals(driver.findElement(By.id("nameofuser")).getText(), "Welcome demoblaze1");
		test.log(LogStatus.PASS,"Login Successful");
		logger.info(" Click action performed on Login button");
	}
	/**
	 * This method is used to close the browser
	 * @throws Throwable
	 */
	@Then("^Browser should be closed$")
	public void browser_should_be_closed() throws Throwable {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		b.quit();
		logger.info(" Browser is Closed");
		test.log(LogStatus.PASS,"Browser is closed");
		report.endTest(test);
		report.flush();


	}


}