package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	/**
	 * This method used for reading data
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable {
		
		FileInputStream fis=new FileInputStream(IpathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
			String value = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;		
	}
	/**
	 * This method used to writing data in excellsheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws Throwable
	 */
	
	public void writingDataInExcel(String sheetname,int rownum,int cellnum,String value) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		 sh.createRow(rownum).createCell(cellnum).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IpathConstant.EXCELPATH);
		wb.write(fos);
	}
	
	/**
	 * This method used for reading multiple data
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> readMultipleDataFromExcel(String sheetname) throws Throwable {
		
		FileInputStream fis=new FileInputStream(IpathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=count;i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();	
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
	
		}
		return map;
		
	}
	
	
	public Object[][] getexceldatapro(String sheetname) throws Throwable {
		
		FileInputStream fis=new FileInputStream(IpathConstant.DATAPATH);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

	
	
}
