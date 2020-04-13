package com.Demoblaze.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.Demoblaze.utility.BrowserFactory;
/**
 * This program particuaraly contains the methods with web elements  that are used for automating user sign up process
 * @author SAIPRYA
 *
 */


public class SignUp_Page {
	BrowserFactory b = new BrowserFactory();
	WebDriver driver;
	/**
	 * The ID of the Sign up link is stored in webelement clickSignUp
	 */

	@FindBy(how = How.ID, using = "signin2")
	@CacheLookup
	WebElement clickSignUp;
	/**
	 * The Absolute Xpath of the username text box is stored in webelement userName
	 */

	@FindBy(how = How.XPATH, using = "//input[@id='sign-username']")
	@CacheLookup
	WebElement userName;
	/**
	 * The Absolute Xpath of the password text box is stored in webelement password
	 */

	@FindBy(how = How.XPATH, using = "//input[@id='sign-password']")
	@CacheLookup
	WebElement passWord;
	/**
	 * The Absolute Xpath of the signup button is stored in webelement signUpButton
	 */
	

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign up')]")
	@CacheLookup
	WebElement signUpButton;
	/**
	 * The properties of the webdriver driver is invoked to local driver using this keyword
	 * @param driver
	 */


	public SignUp_Page(WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * This particular method used to click the signup link
	 */

	public void firstSignUp() {
		clickSignUp.click();

	}
	/**
	 *  This particular method is used to enter username and password to the respective textboxes using sendkeys
	 * @param userid
	 * @param pass
	 */

	public void userSignUp(String userid,String pass) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userName.sendKeys(userid);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		passWord.sendKeys(pass);

	}

	/**
	 *  This paticular method is used to click signup button
	 * @throws Exception
	 */

	public void clickSignUpButton() throws Exception {

		signUpButton.click();
		b.sleep(2);
	}




}


