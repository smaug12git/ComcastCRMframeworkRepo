package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/test data.xls");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		book.close();
		
	return data;
	}
	
	
	public int getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./TestData/test data.xls");
		Workbook book = WorkbookFactory.create(fis);
		int rowcount = book.getSheet(SheetName).getPhysicalNumberOfRows(); //getLastRowNum();
		book.close();
		
	return rowcount ;
	}
	
	
	public int getCellCount(String SheetName,int rowNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./TestData/test data.xls");
		Workbook book = WorkbookFactory.create(fis);
		int cellcount = book.getSheet(SheetName).getRow(rowNum).getLastCellNum();// getPhysicalNumberOfCells();
		book.close();
		
	return cellcount ;
	}
	
	
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./TestData/test data.xls");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream("./TestData/test data.xls");
		book.write(fos);
		book.close();
		
	}
	
	
	
	
	
}
