package com.Demoblaze.StepDefinition;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Demoblaze.pages.PlacingOrder_Page;
import com.Demoblaze.utility.BrowserFactory;
import com.Demoblaze.utility.ConfigReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 *  This program is used for automating demoblaze website particularly tests order placing operation in website
 * This program particularly selects a specified item and adds it to the cart
 */
public class PlacingOrder_StepDefinition {
	WebDriver driver;
	ConfigReader conf = new ConfigReader();
	PlacingOrder_Page s = new PlacingOrder_Page(driver);
	BrowserFactory b = new BrowserFactory();
	Logger logger;
	/**
	 * The ExtentReports class is used to generate extent reports to check whether a particular test case is passed or failed 
	 */

	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport_Ordering.html");
	ExtentTest test = report.startTest("Placing an order Test");
	/**
	 * This method launches the browser and navigates to demoblaze.com
	 * @throws Throwable
	 */

	@Given("^user is in Demoblaze page$")
	public void user_is_in_Demoblaze_page() throws Throwable {
		logger = Logger.getLogger("PlacingOrderStepDefinition");
		PropertyConfigurator.configure("Log4j.properties"); 

		driver = b.startBrowser("chrome", conf.getApplicationURL());
		logger.info(" Browser opened and Navigated to url");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/");
		test.log(LogStatus.PASS,"Browser is opened and Navigated to url");
	}
	/**
	 * This method is used to click on the category option 
	 * @throws Throwable
	 */
	@When("^user clicks on laptop category$")
	public void user_clicks_on_laptop_category() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.category();
		logger.info(" Click action performed  on Laptops link in categories");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/#");
		test.log(LogStatus.PASS,"Click action performed  on Laptops link in categories");
	}
	/**
	 * This method is used to click on the next button
	 * @throws Throwable
	 */
	@When("^user clicks on next$")
	public void user_clicks_on_next() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.goToNext();
		logger.info(" Click action performed on NEXT button");
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/#");
		test.log(LogStatus.PASS,"Next button is clicked");
	}
	/**
	 * This method is used to select a paticular product 
	 * @throws Throwable
	 */

	@When("^user select a particular product$")
	public void user_select_a_particular_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.product();
		logger.info(" Click action performed on the product");

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/prod.html?idp_=12");
		test.log(LogStatus.PASS,"Product is selected");
	}
	/**
	 * This method is used to click on add to cart button 
	 * @throws Throwable
	 */
	@When("^user clicks on add to cart$")
	public void user_clicks_on_add_to_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.adding();
		logger.info(" Click action performed on add to cart button");
	}
	/**
	 * This method is used to handl the pop-up
	 * @throws Throwable
	 */
	@When("^user hanldes the pop up$")
	public void user_hanldes_the_pop_up() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Alert PopUpName = driver.switchTo().alert();
		String message =  PopUpName.getText();
		System.out.println("-------------------------------------------------->  Pop-up says: " +message);
		PopUpName.accept();
		logger.info(" Pop-up is handled");

		Assert.assertEquals(message, "Product added");
		test.log(LogStatus.PASS,"Product is addded to cart and pop-up message handled");

	}
	/**
	 * This method is used to click on the cart button
	 * @throws Throwable
	 */

	@When("^user clicks cart$")
	public void user_clicks_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.cartClicking();
		logger.info("Click action performed on the cart");

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/cart.html");
		test.log(LogStatus.PASS,"Cart is opened");
	}
	/**
	 * This method is used to click on place order button
	 * @throws Throwable
	 */
	@When("^user clicks place order$")
	public void user_clicks_place_order() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.placingorderdetails();
		logger.info("Click action performed  on Place Order button");
		test.log(LogStatus.PASS,"place order is clicked");
	}
	/**
	 * This method is used to read the customer name
	 * @throws Throwable
	 */
	@When("^user gives valid Name$")
	public void user_gives_valid_Name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.name("ADMIN");
		logger.info("Entered Customer Name");
	}
	/**
	 * This method is used to read  the country name
	 * @throws Throwable
	 */

	@When("^user gives country name$")
	public void user_gives_country_name() throws Throwable {
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.countryName("INDIA");
		logger.info("Entered Country Name");
	}
	/**
	 * This method is used to read the city name
	 * @throws Throwable
	 */
	@When("^user gives city Name$")
	public void user_gives_city_Name() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.cityName("CHENNAI");
		logger.info("Entered City Name");
	}
	/**
	 * This method is used to read the Credit card credentials
	 * @throws Throwable
	 */

	@When("^user gives valid Credit Card Details$")
	public void user_gives_valid_Credit_Card_Details() throws Throwable {
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.creditCardDetails("9999 8888 7777 6666", "05", "2030");
		logger.info("Entered Credit Card Details");

		test.log(LogStatus.PASS,"Details Entered");
	}
	/**
	 * This method is used to clicl on purchase button
	 * @throws Throwable
	 */
	@When("^user clicks purchase$")
	public void user_clicks_purchase() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.purchaseproduct();
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).getText(), "Thank you for your purchase!");
		test.log(LogStatus.PASS,"Order Placed Successfully");

		logger.info("Click action performed on purchase buttton");

	}
	/**
	 * This method is used to take screenshot
	 * @throws Throwable
	 */
	@When("^order is placed user takes screenshot$")
	public void order_is_placed_user_takes_screenshot() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.screenshot();
		logger.info("Screenshot is Captured");
	}
	/**
	 * This method is used to click on ok button and close the  browser
	 * @throws Throwable
	 */

	@Then("^click ok$")
	public void click_ok() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		PlacingOrder_Page obj = PageFactory.initElements(driver,PlacingOrder_Page.class);
		obj.clickOk();
		logger.info("Click action performed on OK button");
		b.quit();
		logger.info("Browser is closed");
		test.log(LogStatus.PASS,"Browser is closed");
		report.endTest(test);
		report.flush();
	}



}
