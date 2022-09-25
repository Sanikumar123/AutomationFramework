package com.XYZBank.dataReader;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.XYZBank.utility.Constants;



public class DataProviders {
	
	
	@DataProvider(name="masterDP")
	public Object[][] getDataFromExcel(Method m) throws IOException
	{
		Object[][] data = ExcelReader.readData(Constants.MASTER_XL_PATH, "Data");
		return data;
	}

}
