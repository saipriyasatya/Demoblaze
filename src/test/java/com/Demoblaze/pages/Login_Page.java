package com.Demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.Demoblaze.utility.BrowserFactory;
import com.Demoblaze.utility.Screenshot;
/**
 * This program particuaraly contains the methods with web elements  that are used for automating user login process
 * @author SAIPRIYA
 *
 */


public class Login_Page {
	WebDriver driver;
	Screenshot ss = new Screenshot();
	BrowserFactory b = new BrowserFactory();
	/**
	 * Absolute Xpath of the login is stored in webelement firstloginClick
	 */



	@FindBy(how = How.XPATH, using = "//a[@id='login2']")
	@CacheLookup
	WebElement firstloginClick;
	/**
	 * ID of the username text box is stored in webelement username
	 */


	@FindBy(how = How.ID, using = "loginusername")
	@CacheLookup  //cache memory for increasing performnce
	WebElement username;
	/**
	 * ID of the password text box is stored in webelement password
	 */


	@FindBy(how=How.ID, using = "loginpassword")
	@CacheLookup
	WebElement password;
	/**
	 *The Absolute Xpath of the login button is stored in webeelement finalloginButton
	 * 
	 */

	@FindBy(how=How.XPATH, using ="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement finalloginButton;

	/**
	 * The properties of the webdriver driver is invoked to local driver using this keyword
	 * @param driver
	 */

	public Login_Page(WebDriver driver) {
		this.driver=driver;
	}

	/**
	 * This particular method used to click the login link in the website
	 * @throws Exception
	 */
	public void firstlogin() throws Exception {
		firstloginClick.click();
		b.sleep(1);

		/**
		 * This particular method is used to send username and password to the respective textboxes using sendkeys
		 * @param userid
		 * @param pass
		 * @throws Exception
		 */
	}
	public void userlogin(String userid,String pass) throws Exception {

		username.sendKeys(userid);
		b.sleep(1);
		password.sendKeys(pass);
		b.sleep(1);
	}
	/**
	 * This paticular method is used to click login button and take sceenshot of the webpage after login
	 * @throws InterruptedException
	 */


	public void clicklogin() throws InterruptedException {
		finalloginButton.click();
		b.sleep(1);
		ss.getScreenshot(driver);
	}


}


