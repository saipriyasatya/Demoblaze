package com.Demoblaze.TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
glue = {"com.Demoblaze.StepDefinition"},
tags ="@Test_Contact",
plugin= {"html:target/cucumber-html.report"})

public class Contact_TestRunner {
	private TestNGCucumberRunner testRunner;



	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(Contact_TestRunner.class);			
	}

	@Test(description="Test_Demoblaze",dataProvider="features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}

	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}


	@AfterClass
	public void tearDown() throws InterruptedException
	{		
		testRunner.finish();


	}

}


