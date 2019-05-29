package ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static XSSFSheet ExcelWSheet;    
	public static XSSFWorkbook ExcelWBook;    
	public static XSSFCell Cell;    
	public static XSSFRow Row;

	
	/*
	 public static Object[][] getdata(String FilePath, String SheetName) throws Exception { 		    
		    String[][] tabdata = null;	   	 
		    FileInputStream ExcelFile = new FileInputStream(FilePath);		 
		    ExcelWBook = new XSSFWorkbook(ExcelFile);
		    ExcelWSheet = ExcelWBook.getSheet(SheetName);   		   
		    int totalRows = ExcelWSheet.getLastRowNum();		    
		    int totalCols = 2;		 
		    tabdata=new String[totalRows][totalCols];				  
		    for (int i= 0; i<totalRows-1; i++) 
		    {     	 
		        		 
		        for (int j= 0; j<totalCols; j++)
		        {
		        	tabdata[i][j]=getCellData(i,j);  		 
		             System.out.println(tabdata[i][j]); 		 
		      }		 
		    }		    
		 return(tabdata);		 
		 }*/   
   
    
    
    public static Object[][] getdata(String FilePath, String SheetName) throws Exception 
    { 
    	
	    Object[][] tabdata = null;		
	    FileInputStream ExcelFile = new FileInputStream(FilePath);
	    
	    ExcelWBook = new XSSFWorkbook(ExcelFile);
	    ExcelWSheet = ExcelWBook.getSheet(SheetName);  
	    
	    int row = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
	   	int col = ExcelWSheet.getRow(0).getLastCellNum();    
	
   	    tabdata = new Object[row][col];
   	    for (int i = 0; i < row; i++) 
   	    {
    		Row rowdata = ExcelWSheet.getRow(i+1);
  	  		for (int j = 0; j < rowdata.getLastCellNum(); j++) 
  		{
  		       tabdata[i][j] = rowdata.getCell(j).toString();
  		        //tabdata[i][j]=getCellData(i,j);
             
  		    }       
         }
		return tabdata;
     }	
	 
		  /*public static String getCellData(int RowNum, int ColNum) throws Exception {			
		   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);		 
		   String CellData = Cell.getStringCellValue();		 
		   return CellData;						 
		 }*/
    
    
    

public void writexl(String FilePath,String SheetName,int rowno1,String actresult) throws IOException
{   
    FileInputStream inputStream = new FileInputStream(FilePath);  
    Sheet sheet = ExcelWBook.getSheet(SheetName);
  
    Row rowcount = sheet.getRow(0);
    Row row = sheet.getRow(rowno1);        
    int cellno =rowcount.getLastCellNum();
    Cell cell = row.createCell(cellno-1);
    
    cell.setCellValue(actresult);	
    
    inputStream.close();
    FileOutputStream outputStream = new FileOutputStream(FilePath);
    ExcelWBook.write(outputStream);
    outputStream.close();
    }
   }
