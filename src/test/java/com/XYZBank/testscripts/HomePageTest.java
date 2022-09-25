package com.XYZBank.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.XYZBank.TestPages.HomePage;
import com.XYZBank.testbase.TestBase;
import com.XYZBank.utility.DriverManager;


public class HomePageTest extends TestBase {
	
	
	@Test
	public void bankManagerLogin() throws InterruptedException
	{
		openBrowser();
		logInfo("Browser Launched...");
		HomePage homepage = new HomePage(DriverManager.getDriver());
		//Thread.sleep(3000);
		homepage.clickBankManagerLoginbtn();
		logInfo("Clicked on BankManager Login button...");
		
		

	}

}
