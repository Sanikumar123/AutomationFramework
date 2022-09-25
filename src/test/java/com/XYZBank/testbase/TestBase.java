package com.XYZBank.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.XYZBank.extentlisteners.ExtentListeners;
import com.XYZBank.utility.Constants;
import com.XYZBank.utility.DriverFactory;
import com.XYZBank.utility.DriverManager;




public class TestBase {

	public static WebDriver driver = null;
	static Properties  config = new Properties();
	FileInputStream fin;

	@BeforeSuite
	public void frameworksetUp() {
		
		
		DriverFactory.setConfigPropertyFile(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		DriverFactory.setChromeDriverExePath(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\firefox.exe");
		

		// loading properties file
		try {
			fin = new FileInputStream(
					DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DriverFactory.setGridPath(config.getProperty("huburl"));

			}
	
	public void logInfo(String message) {
		ExtentListeners.testReport.get().info(message);
	}
	
	public static  void openBrowser()
	{
		// opening browser
		
		
		DriverFactory.setRemote(Constants.REMOTE_STATUS);

		if (DriverFactory.isRemote()) {
			DesiredCapabilities cap = null;

			if (Constants.CHROME_BROWSER.equals(config.getProperty("browser"))) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (Constants.CHROME_BROWSER.equals("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			}

			try {
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

			else if (config.getProperty("browser").equals(Constants.CHROME_BROWSER)) {

					// Driver location
					System.setProperty("webdriver.chrome.driver",
						DriverFactory.getChromeDriverExePath());

					// open a chrome browser
					
					driver = new ChromeDriver();
				} else if (config.getProperty("browser").equals(Constants.FIREFOX_BROWSER)) {
					// Driver location
					System.setProperty("webdriver.firefox.driver",
							DriverFactory.getGeckoDriverExePath());

					// open a chrome browser
					driver = new FirefoxDriver();
				}

				DriverManager.setDriver(driver);
				DriverManager.getDriver().manage().window().maximize();// maximize the browser
				
				// launch testurl
				DriverManager.getDriver().get(config.getProperty("testurl"));// open the URL in the
				DriverManager.getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_TIME, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void close() {
		DriverManager.getDriver().close();
	}

}
