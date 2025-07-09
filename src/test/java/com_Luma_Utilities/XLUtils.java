package com_Luma_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fs;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//get the row count for the Excell sheet
	public static int getRowcount(String XLFile,String XLsheet) throws IOException {	//3
	
		 fs = new FileInputStream(XLFile);
		 wb = new XSSFWorkbook(fs);
		 sheet  = wb.getSheet(XLsheet);
		 int rowcount =sheet.getLastRowNum();
		 wb.close();
		 fs.close();
		return rowcount;
		 
	}	
	
	//get the cell count
	public static int getcellcount(String XLFile, String XLsheet,int rownum) throws IOException {
		fs = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fs);
		sheet  = wb.getSheet(XLsheet);
		row = sheet.getRow(rownum);
		int cellcount =row.getLastCellNum();
		return cellcount;
		
	}
	
	
	//get the cell data
	public static String getcelldata(String XLFile,String XLsheet,int rownum, int cellnum) throws IOException {
		fs = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fs);
		sheet  = wb.getSheet(XLsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;
		try {
		DataFormatter format = new DataFormatter();
		String celldata = format.formatCellValue(cell);
		return celldata;
		}catch (Exception e) {
			data = "";
		}
		
		wb.close();
		fs.close();
		return data;
	}
	
	
	
	public static void setcelldata(String XLFile,String XLsheet,int rownum, int cellnum,String data) throws IOException {
		fs = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fs);
		sheet  = wb.getSheet(XLsheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(XLFile); //write the data
		wb.write(fo);
		fs.close();
		fo.close();
	//	return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}