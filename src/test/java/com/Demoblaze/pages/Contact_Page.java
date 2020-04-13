package com.Demoblaze.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.Demoblaze.utility.BrowserFactory;
/**
 * This program particuaraly contains the methods with web elements  that are used for automating the message sending process
 * @author SAIPRIYA
 *
 */

public class Contact_Page {
	WebDriver driver;
	BrowserFactory b = new BrowserFactory();
	/**
	 * The Absolute Xpath of the contact link is stored in webelement contact
	 */


	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Contact')]")
	@CacheLookup
	WebElement contact;
	/**
	 * The Absolute Xpath of the contact e-mail text box is stored in webelement contactemail
	 */
	@FindBy(how = How.XPATH, using = "//input[@id='recipient-email']")
	@CacheLookup  //cache memory for increasing performnce
	WebElement contactemail;
	/**
	 * The Absolute Xpath of the contact name text box is stored in webelement contactname
	 */

	@FindBy(how=How.XPATH, using = "//input[@id='recipient-name']")
	@CacheLookup
	WebElement contactname;
	/**
	 * The Absolute Xpath of the message text box is stored in webelement message
	 */

	@FindBy(how=How.XPATH, using ="//textarea[@id='message-text']")
	@CacheLookup
	WebElement message;
	/**
	 * The Absolute Xpath of the contact send button is stored in webelement send message
	 */

	@FindBy(how=How.XPATH, using ="//button[contains(text(),'Send message')]")
	@CacheLookup
	WebElement sendmessage;
	/**
	 * The properties of the webdriver driver is invoked to local driver using this keyword
	 * @param driver
	 */


	public Contact_Page(WebDriver driver) {
		this.driver=driver;
		/**
		 * This particular method used to automate the clicking process of contact link
		 * @throws Exception
		 */
	}

	public void clickcontact() throws Exception {
		contact.click();


	}
	/**
	 * This particular method is used to enter e-mail in the textbox using sendkeys
	 * @param email
	 * @throws Exception
	 */
	public void contactmail(String email) throws Exception{
		b.sleep(1);
		contactemail.sendKeys(email);


	}
	/**
	 * This particular method is used to enter name using send keys 
	 * @param name
	 */

	public void contacname(String name){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		contactname.sendKeys(name);
		/**
		 * This particular method is used to enter message in textbax using seend keys
		 * @param msg
		 */

	}
	public void contacmesage(String msg){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		message.sendKeys(msg);

	}

	/**
	 * This particular method used to automate the clicking process of send button
	 */

	public void sendingmessage() {
		sendmessage.click();


	}


}



