package com.XYZBank.testscripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.XYZBank.TestPages.BankManagerHomePage;
import com.XYZBank.TestPages.HomePage;
import com.XYZBank.dataReader.DataProviders;
import com.XYZBank.testbase.TestBase;
import com.XYZBank.utility.DriverManager;


public class BankManagerHomePageTest extends TestBase{
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void addACustomerTest(String fname, String lname, String postcode) throws InterruptedException
	{
		openBrowser();
		HomePage homePage = new HomePage(DriverManager.getDriver());
		Thread.sleep(3000);
		logInfo("Browser Opened...");
		BankManagerHomePage bankManagerHomePage = homePage.clickBankManagerLoginbtn();
		Thread.sleep(3000);
		logInfo("Clicked on BankManager Login button...");
		bankManagerHomePage.clickAddCustomerBtn();
		Thread.sleep(3000);
		logInfo("Clicked on Add Customer button...");
		bankManagerHomePage.addACustomer(fname,lname,postcode );
		logInfo("FirstName entered as - " + fname + "  LastName entered as - " + lname +"  Postcode entered as - " + postcode );
		Alert alert = driver.switchTo().alert();
		logInfo("Switched to Alert...");
		String AlertMessage = alert.getText();
		String message [] = AlertMessage.split(":");
		String ActualAlertMessage = message[0];
		String expectedlAlertMessage = "Customer added successfully with customer id ";
		logInfo("Verifying Actual with Expected...");
		try {
		Assert.assertEquals(ActualAlertMessage, expectedlAlertMessage);
		}catch(Exception e)
		{
			logInfo("Verification not matched...");
		}
		logInfo("Verification matched...");
		alert.accept();
		
		
		
		
		
		

	}

}
