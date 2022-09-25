package com.XYZBank.dataReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	 static FileInputStream fin=null;
	 static XSSFWorkbook workbook=null;
	 static XSSFSheet sheet=null;
	 static XSSFRow row=null;
	
	
	
	public static Object[][] readData(String path, String sheetname) throws IOException 
	    {
		
		 try {
				fin = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      try {
				workbook = new XSSFWorkbook(fin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 
		 sheet=workbook.getSheet(sheetname);
	     row = sheet.getRow(0);
	      int rownum=sheet.getLastRowNum();
	      int colnum=row.getLastCellNum();
	      
	      Object[][] data = new Object[rownum][colnum];

	      
	      for(int i=1;i<=sheet.getLastRowNum();i++)
	      {
	    	  for(int j=0;j<row.getLastCellNum();j++)
	    	  {
	    		  data[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();

	    	  }
	      }
	      
	     // System.out.println(sheet.getLastRowNum());
	     // System.out.println(row.getLastCellNum());
	      
	     return data;
		
	    }
	 


}
