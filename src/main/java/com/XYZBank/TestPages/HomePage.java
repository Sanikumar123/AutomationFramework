package com.XYZBank.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	WebDriver driver=null;
	
	
	//Initalization
	public HomePage(WebDriver driver)
	{  
		super.driver=driver;//to pass driver refrence to basepage
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElements
	@FindBy(xpath="//button[@ng-click='manager()']")
	WebElement bankManagerLoginBtn;
	
	@FindBy(xpath="//button[@ng-click='customer()']")
	WebElement customerLoginBtn;
	
	@FindBy(xpath="//button[@ng-click='home()']")
	WebElement homeBtn;
	
	@FindBy(xpath="//*[text()='XYZ Bank']")
	WebElement homePageHeadingText;
	
	
	public BankManagerHomePage clickBankManagerLoginbtn()
	{
		waitForPageToLoad(bankManagerLoginBtn);
		click(bankManagerLoginBtn);
		return new BankManagerHomePage(driver);
	}
	

}
