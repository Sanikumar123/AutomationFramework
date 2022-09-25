package com.XYZBank.TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerHomePage extends BasePage {

	// Initalization
	public BankManagerHomePage(WebDriver driver) {
		super.driver=driver;//to pass driver refrence to basepage
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// Bank Manager Home Page - WebElements
	@FindBy(xpath = "//button[@ng-click='addCust()']")
	WebElement addCustomerSectionBtn;

	@FindBy(xpath = "//button[@ng-click='openAccount()']")
	WebElement openAccountBtn;

	@FindBy(xpath = "//button[@ng-click='showCust()']")
	WebElement showCustomerBtn;

	@FindBy(xpath = "//button[@ng-click='home()")
	WebElement homeBtn;

	
	
	// Add Customer Section - WebElements
	@FindBy(xpath = "//input[@ng-model='fName']")
	WebElement firstNameTextField;

	@FindBy(xpath = "//input[@ng-model='lName']")
	WebElement lastNameTextField;

	@FindBy(xpath = "//input[@ng-model='postCd']")
	WebElement postCodeTextField;

	@FindBy(xpath = "//button[text()='Add Customer']")
	WebElement addCustomerBtn;

	
	
	public void clickAddCustomerBtn() {

		click(addCustomerSectionBtn);

	}

	public void addACustomer(String fName, String lName, String PostCode) {
		
		type(firstNameTextField,fName );
		type(lastNameTextField,lName );
		type(postCodeTextField,PostCode );
		click(addCustomerBtn);
		

		
		
		

	}

}
