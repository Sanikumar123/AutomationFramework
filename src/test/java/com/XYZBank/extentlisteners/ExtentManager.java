package com.XYZBank.extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.XYZBank.utility.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
	
private static ExtentReports extent;
	
	
	

    public static ExtentReports createInstance(String fileName) {
    	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
       
       // htmlReporter.config().setTestViewChartLocation(CharacterSection.);
        //htmlReporter.config().setChartVisibilityOnOpen(true);
    	sparkReporter.config().setTheme(Theme.STANDARD);
    	sparkReporter.config().setDocumentTitle(fileName);
    	sparkReporter.config().setEncoding("utf-8");
    	sparkReporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Automation Tester", "Sunny Kumar");
        extent.setSystemInfo("Organization", "XYZBankApplication");
        extent.setSystemInfo("Build no", "1.0");
        
        
        return extent;
    }

    
    public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() {

		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			 FileHandler.copy(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}





}
