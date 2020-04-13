package com.Demoblaze.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

 public class ValidUsernameAndPasswordTest {
	  WebDriver driver;
	  @Given("^Open chrome and start application$")
	  public void open_chrome_and_start_application() throws Throwable {

	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Documents\\Programs\\Demoblaze\\src\\test\\resources\\binaries\\chromedriver.exe");
	  driver=new ChromeDriver();

	  driver.get("https://www.demoblaze.com/");
	  driver.manage().window().maximize();
	  
	  }
	  @When("^user should be able to click$")

	  public void user_should_be_able_to_click() throws Throwable {
		  driver.findElement(By.id("login2")).click();
	  }
	  @When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	  public void i_enter_valid_and_valid(String Satya, String satya) throws Throwable {
	  driver.findElement(By.id("loginusername")).sendKeys(Satya);
	  driver.findElement(By.id("loginpassword")).sendKeys(satya);
	  
	  
 Thread.sleep(5000);
	  }

 @Then("^user should be able to login$")
	  public void user_should_be_able_to_login() throws Throwable {
	  driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	  Assert.assertEquals("https://www.demoblaze.com/", driver.getCurrentUrl());
	  System.out.println(driver.getCurrentUrl());
	  System.out.println("User is able to login sucessfully");
	  }

	  @Then("^application should be closed$")
	  public void application_should_be_closed() throws Throwable {
	  driver.close();

	  } 
  }
