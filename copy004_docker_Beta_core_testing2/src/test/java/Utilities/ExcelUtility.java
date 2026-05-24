package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;          //class-level variable declarations (instance variables / fields)
	public CellStyle style;          //variable declarations (instance variables / fields) 
	String path;                                       
	
	public ExcelUtility(String path)    //It initializes the object with the Excel file path so that all methods in the class can use it to read and write data
	{
		this.path=path;
	}
		
	public int getRowCount(String sheetName) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;		
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter(); //Uses DataFormatter to convert any type (numeric, string, date) →to  String
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}                                                                           
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	} 
	
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);  //Create a File object using the given path
		if(!xlfile.exists())    // If the file does not exist:
		{
		workbook=new XSSFWorkbook(); //Create a new Excel workbook (XSSFWorkbook).
		fo=new FileOutputStream(path); //Open a FileOutputStream.
		workbook.write(fo);                 //Write the empty workbook to disk (this creates the file).
		}
				
		fi=new FileInputStream(path); //Create a FileInputStream to read the file.
		workbook=new XSSFWorkbook(fi); //Load the workbook from the file into memory. 
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet, If it returns -1, the sheet does not exist.
			workbook.createSheet(sheetName); //Create a new sheet with the given sheetName.
		sheet=workbook.getSheet(sheetName); //Get the sheet object using getSheet(sheetName).

					
		if(sheet.getRow(rownum)==null)   // Check if the row at rownum is null , If yes, create a new row using createRow(rownum).
				sheet.createRow(rownum);
		row=sheet.getRow(rownum); //Retrieve the row using getRow(rownum).
		cell=row.createCell(colnum);  //Create a new cell at column colnum using createCell(colnum).

		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);		
		workbook.close();
		fi.close();
		fo.close();
	}
	
	
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path); 
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle(); // creating style object
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); //Set color (GREEN)
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); //Set fill type
				
		cell.setCellStyle(style); //Apply style to cell
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
}
