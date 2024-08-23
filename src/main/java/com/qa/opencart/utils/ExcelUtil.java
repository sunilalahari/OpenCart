package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static FileInputStream fis;
	public String sheetName;
	public String location;
	public Object[][] data;
	
	
	public Object[][] getRegisterTestData(String sheetName, String location) {
		//Object[][] data = null;
		try {
			fis = new FileInputStream
					(location);
			workbook = new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			int rowCount = sheet.getLastRowNum();
			int colCount= sheet.getRow(0).getLastCellNum();
			data= new Object[rowCount][colCount];
			for(int i=0;i<rowCount;i++)
			{
				for(int j=0;j<colCount;j++) {
					data[i][j]= sheet.getRow(i+1).getCell(j).toString();
					System.out.print(data[i][j]+"   ");
					
				}
				System.out.println();
			}
			
			return data;
		
	}
	
	
	
	


}
