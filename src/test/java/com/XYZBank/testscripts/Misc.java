package com.XYZBank.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Misc {
	
	
	ExtentTest test;
	ExtentReports extent;
	WebDriver driver=null;
	ExtentSparkReporter sparkReporter;
	
	@BeforeSuite
	public void extentrun()
	{

	 sparkReporter = new ExtentSparkReporter("D:\\Core_JAVA_23rd_July\\AutomationFrawework\\test-output\\extent.html");
	
	 extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	
	
	System.setProperty("webdriver.edge.driver",
			"C:\\Users\\91898\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	
	
	
	
	
	}
	
	@Test
	public void testRun()
	
	{
		test = extent.createTest("testRun");
		driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/");// open the URL in the browser

		driver.manage().window().maximize();// maximize the browser
		test.log(Status.PASS, "Passed");
		

	}
	
	
	@Test
	public void testRun1()
	
	{
		
		test = extent.createTest("testRun1");
		driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/");// open the URL in the browser

		driver.manage().window().maximize();// maximize the browser
		test.log(Status.FAIL, "Failed");
		

	}
	
	
	
	@AfterSuite
	public void quit()
	{

	
	driver.quit();
	extent.flush();
	
	
	
	}
	
	 

	}


