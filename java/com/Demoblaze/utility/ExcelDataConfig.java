package com.Demoblaze.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *This class is particularly used for implementing data driven framework in test automation
 */
public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet1;
	/**
	 * To get excel sheet path
	 * @param excelpath
	 */
	public ExcelDataConfig(String excelpath) {

		try {
			File src=new File(excelpath);
			FileInputStream fis=new FileInputStream(src);	
			wb=new XSSFWorkbook(fis);
			sheet1=wb.getSheetAt(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	}
	/**
	 * To get data available at given parameters
	 * @param sheetNumber
	 * @param row
	 * @param column
	 * @return
	 */
	public String getData(int sheetNumber,int row,int column) {
		sheet1=wb.getSheetAt(sheetNumber);
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	/**
	 * To get No. of rows in excel
	 * @param sheetIndex
	 * @return
	 */
	public int getRowCount(int sheetIndex) {
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}
	public Object[][] passData() {


		int noofrows=getRowCount(0);
		Object[][] data=new Object[noofrows][2];

		for(int i=0;i<noofrows; i++) {
			data[i][0]=getData(0, i, 0);
			data[i][1]=getData(0, i, 1);
		}

		return data;
	}
}
