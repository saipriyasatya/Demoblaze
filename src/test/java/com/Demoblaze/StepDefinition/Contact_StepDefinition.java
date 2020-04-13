package com.Demoblaze.StepDefinition;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.Demoblaze.pages.Contact_Page;
import com.Demoblaze.utility.BrowserFactory;
import com.Demoblaze.utility.ConfigReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This program is used for automating demoblaze website particularly tests contact option in website
 * This program particularly clicks the contact and sends a message 
 * @author WINDOWS
 */
public class Contact_StepDefinition {

	BrowserFactory b = new BrowserFactory();
	ConfigReader config = new ConfigReader();
	public WebDriver driver;
	Logger logger;

	/**
	 * The ExtentReports class is used to generate extent reports to check whether a particular test case is passed or failed 
	 */
	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport_Contact.html");
	ExtentTest test = report.startTest("Contact Test");

	/**
	 * This method launches the browser and navigates to demoblaze.com
	 * @throws Throwable
	 */
	@Given("^user is in first page$")
	public void user_is_in_first_page() throws Throwable {
		driver = b.startBrowser("chrome", config.getApplicationURL());
		logger = Logger.getLogger("ContactStepDefinition");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info(" Browser opened and Navigated to url");

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/");
		test.log(LogStatus.PASS,"Browser is opened and Navigated to url");
	}

	/**
	 * This method is used to click the contact button
	 */

	@When("^user clicks contact$")
	public void user_clicks_contact() throws Throwable {

		Contact_Page info = PageFactory.initElements(driver,Contact_Page.class);
		info.clickcontact();
		logger.info(" Click action performed on Contact link");
		b.sleep(2);
		Assert.assertEquals(driver.findElement(By.id("exampleModalLabel")).getText(), "New message");
		test.log(LogStatus.PASS,"Contact link is clicked");
	}
	/**
	 * This method is used to read the email-id from the method contactmail()
	 * @throws Throwable
	 */
	@When("^user enters e-mail$")
	public void user_enters_e_mail() throws Throwable {
		Contact_Page info = PageFactory.initElements(driver,Contact_Page.class);
		info.contactmail("demomail@gmail.com");	

		logger.info(" Contact E-mail is entered");

		test.log(LogStatus.PASS," E-mail is entered");
	}
	/**
	 * This method is used to read the user name from contactname()
	 * @throws Throwable
	 */
	@When("^user enters name$")
	public void user_enters_name() throws Throwable {
		Contact_Page info = PageFactory.initElements(driver,Contact_Page.class);
		info.contacname("ADMIN");

		logger.info(" Contact Name is entered");
		test.log(LogStatus.PASS," Name is entered");
	}
	/**
	 * This method is used to enter a message using contacmesage() 
	 * @throws Throwable
	 */
	@When("^user enters message$")
	public void user_enters_message() throws Throwable {
		Contact_Page info = PageFactory.initElements(driver,Contact_Page.class);
		info.contacmesage("Hi, i want to track my order");
		logger.info(" Message is entered");
		test.log(LogStatus.PASS," Message is entered");
	}
	/**
	 * This method is used to click the send message button
	 * @throws Throwable
	 */
	@When("^user clicks sendmessage$")
	public void user_clicks_sendmessage() throws Throwable {

		Contact_Page info = PageFactory.initElements(driver,Contact_Page.class);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/");
		info.sendingmessage();  
		logger.info("Click action performed on Send button");
		test.log(LogStatus.PASS,"Send button is clicked");
	}
	/**
	 * This method is used to handle the pop-up and close the browser
	 * @throws Throwable
	 */
	@Then("^user clicks the pop-up$")
	public void user_clicks_the_pop_up() throws Throwable {
		Alert PopUpName = driver.switchTo().alert();
		String message =  PopUpName.getText();
		System.out.println("--------------------------------------------->  Pop-up says: " +message );
		PopUpName.accept();

		logger.info("Pop-up is handled");
		Assert.assertEquals(message, "Thanks for the message!!");
		test.log(LogStatus.PASS,"Message Sent Successfully");
		b.quit();
		logger.info("Browser is closed");
		test.log(LogStatus.PASS,"Browser is closed");
		report.endTest(test);
		report.flush();
	}
}