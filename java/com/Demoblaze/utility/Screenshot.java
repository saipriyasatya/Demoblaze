package com.Demoblaze.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 *This class is particularly used for taking screenshots in test automationS
 */

public class Screenshot {
	/**
	 * This method takes the screenshot and stores it in the png format in current user directory
	 * @param driver
	 * @return
	 */
	public String getScreenshot(WebDriver driver) {

		TakesScreenshot ts= (TakesScreenshot)driver;

		File source=ts.getScreenshotAs(OutputType.FILE);

		String path= System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";

		File destination=new File(path);

		try {
			FileUtils.copyFile(source,destination );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Capture Failed" + e.getMessage());
		}
		return path;
	}




}
