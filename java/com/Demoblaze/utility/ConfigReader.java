package com.Demoblaze.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pro;

	public ConfigReader() {

		try {
			File src=new File("C:\\Users\\Lenovo\\Documents\\Programs\\Demoblaze\\Configuration\\Config.property");

			FileInputStream fis=new FileInputStream(src);

			pro=new Properties();

			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is" + e.getMessage());
		}

	}
	/**
	 * This method returns ecxelpath
	 */
	public String getExcelpath() {
		String Excelpath=pro.getProperty("ExcelPath");
		return Excelpath;
	}

	/**
	 * This method returns chromepath
	 * @return
	 */
	public String getchromepath() {
		String chromepath=pro.getProperty("chromeDriver");
		return chromepath;
	}
	/**
	 * This method returns firefoxpath
	 */

	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxDriver");
		return firefoxpath;
	}
	/**
	 * This method returns the url
	 */
	public String getApplicationURL() {
		return pro.getProperty("URL");
	}



}


