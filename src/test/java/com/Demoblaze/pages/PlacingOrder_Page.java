package com.Demoblaze.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.Demoblaze.utility.BrowserFactory;
import com.Demoblaze.utility.Screenshot;
/**
 * This program particuaraly contains the methods with web elements  that are used for automating the process of creating an order
 * @author SAIPRIYA
 *
 */

public class PlacingOrder_Page {
	Screenshot ss = new Screenshot();
	WebDriver driver;
	BrowserFactory b = new BrowserFactory();
	/**
	 * The partial link test of the laptops link is stored in webelement productSelection
	 */

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Laptops")
	@CacheLookup WebElement productSelection;
	/**
	 * The ID of the next button  is stored in webelement next
	 */



	@FindBy(how = How.ID, using = "next2")
	@CacheLookup  WebElement next;
	/**
	 * The Absolute Xpath of the product is stored in webelement selectProduct
	 */



	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Dell i7 8gb')]")
	@CacheLookup WebElement selectProduct;
	/**
	 * The Absolute Xpath of the text is stored in webelement  productDescription
	 */

	@FindBy(how = How.XPATH, using = "//h2[@class='name']")
	@CacheLookup  WebElement productDescription;
	/**
	 * The Absolute Xpath of the add to cart button is stored in webelement  addToCart
	 */


	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-success btn-lg']")
	@CacheLookup WebElement addToCart;
	/**
	 * The Absolute Xpath of the cart link  is stored in webelement  cartClick
	 */



	@FindBy(how = How.XPATH, using = "//a[@id='cartur']")
	@CacheLookup WebElement cartClick;
	/**
	 * The Absolute Xpath of the place order button  is stored in webelement  placingorder
	 */


	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-success']")
	@CacheLookup WebElement placingorder;
	/**
	 * The Absolute Xpath of the customer name text box is stored in webelement  name
	 */



	@FindBy(how=How.XPATH, using = "//input[@id='name']")
	@CacheLookup WebElement name;
	/**
	 * The Absolute Xpath of the country text box is stored in webelement  country
	 */

	@FindBy(how=How.XPATH, using ="//input[@id='country']")
	@CacheLookup WebElement country;
	/**
	 * The Absolute Xpath of the city name text box is stored in webelement city
	 */

	@FindBy(how=How.XPATH, using = "//input[@id='city']")
	@CacheLookup WebElement city ;
	/**
	 * The Absolute Xpath of the credit card text box is stored in webelement  card
	 */


	@FindBy(how=How.XPATH, using = "//input[@id='card']")
	@CacheLookup WebElement card;
	/**
	 * The Absolute Xpath of the month  text box is stored in webelement  month
	 */


	@FindBy(how=How.XPATH, using = "//input[@id='month']")
	@CacheLookup WebElement month;
	/**
	 * The Absolute Xpath of the year text box is stored in webelement  year
	 */


	@FindBy(how=How.XPATH, using = "//input[@id='year']")
	@CacheLookup WebElement year;
	/**
	 * The Absolute Xpath of the purchase button stored in webelement  purchase
	 */


	@FindBy(how=How.XPATH, using = "//button[contains(text(),'Purchase')]")
	@CacheLookup WebElement purchase;
	/**
	 * The Relative Xpath of the  text is stored in webelement  message
	 */

	@FindBy(how=How.XPATH, using = "/html[1]/body[1]/div[10]/h2[1]")
	@CacheLookup WebElement message;
	/**
	 * The Absolute Xpath of the Ok button is stored in webelement  close
	 */

	@FindBy(how=How.XPATH, using = "//button[@class='confirm btn btn-lg btn-primary']")
	@CacheLookup WebElement close;
	/**
	 * The properties of the webdriver driver is invoked to local driver using this keyword
	 * @param driver
	 */

	public PlacingOrder_Page(WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * This method is used to automate click operation on laptops link
	 * @throws InterruptedException
	 */


	public void category() throws InterruptedException{

		productSelection.click();
		b.sleep(1);
	}
	/**
	 * This method is used to automate click operation on next button
	 * @throws InterruptedException
	 */

	public void goToNext() throws InterruptedException{
		next.click();
		b.sleep(1);
	}
	/**
	 * This method is used to automate click operation on a produt link
	 * @throws InterruptedException
	 */


	public void product() throws Exception{
		selectProduct.click();
		b.sleep(2);
	}
	/**
	 * This method is used to automate click operation on add to cart button and print product description in console
	 * @throws InterruptedException
	 */


	public void adding() throws Exception{
		String str =productDescription.getText();
		System.out.println("-------------------------------------------------->  " +str + " is succesfully added to  the cart");
		addToCart.click();
		b.sleep(1);
	}
	/**
	 * This method is used to automate pop-up handling and display op-up meessage in console
	 * @throws Exception
	 */

	public void handlePopup() throws Exception {
		Alert PopUpName = driver.switchTo().alert();
		String message =  PopUpName.getText();
		System.out.println("-------------------------------------------------->  Pop-up says: " +message);
		PopUpName.accept();
	}
	/**
	 *This method is used to automate click operation on cart link
	 * @throws Exception
	 */

	public void cartClicking() throws Exception{	
		cartClick.click();
		b.sleep(1);
	}
	/**
	 * This method is used to automate click operation on cart place order button
	 */

	public void  placingorderdetails() {
		placingorder.click();

	}
	/**
	 * This method is used to automate entering name in text box using sendkeys
	 * @param customername
	 */

	public void  name(String customername) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		name.sendKeys(customername);



	}
	/**
	 * This method is used to automate entering country name in text box using sendkeys
	 * @param countryname
	 */

	public void  countryName(String countryname) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		country.sendKeys(countryname);
	}
	/**
	 * This method is used to automate entering city name in text box using sendkeys
	 * @param cityname
	 */

	public void  cityName(String cityname) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		city.sendKeys(cityname);
	}
	/**
	 * This method is used to automate entering card details in respective text boxes using sendkeys
	 * @param cardnumer
	 * @param Month
	 * @param Year
	 */

	public void  creditCardDetails(String cardnumer, String Month, String Year) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		card.sendKeys(cardnumer);
		month.sendKeys(Month);
		year.sendKeys(Year);

	}
	/**
	 * This method is used to automate click operation on purchase button and print text in console window
	 */

	public void purchaseproduct() {

		purchase.click();
		String s = message.getText();
		System.out.println("-------------------------------------------------->  " +s);
	}
	/**
	 * This method is used to take screenshot
	 * @throws Exception
	 */

	public void screenshot() throws Exception {
		Thread.sleep(2000);
		ss.getScreenshot(driver);
	}
	/**
	 * This method is used to automate click operation on Ok button
	 */

	public void clickOk() {

		close.click();
	}	

}









