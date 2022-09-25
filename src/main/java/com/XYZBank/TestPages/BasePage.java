package com.XYZBank.TestPages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	static WebDriver driver;
	static WebDriverWait wait;
	static Alert alert;
	static Select drop;
	static Actions action;

	public static void BasePage() {
		wait = new WebDriverWait(driver, 30);

	}

	public static void waitForPageToLoad(WebElement element) {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void click(WebElement element) {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}
		element.click();

	}

	public void type(WebElement element, String text) {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		element.sendKeys(text);

	}

	public static void switchToAlert() {

		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert = driver.switchTo().alert();

	}

	public static void typeTextToAlert(String text) {

		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert.sendKeys(text);

	}

	public static void acceptAlert() {

		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert.accept();

	}

	public static void dismissAlert() {

		try {

			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			System.out.println(e);
		}

		alert.dismiss();

	}

	public static void selectDropdownValueByText(WebElement element, String dropValue) {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		drop = new Select(element);
		drop.selectByVisibleText(dropValue);

	}

	public static void selectDropdownValueByIndex(WebElement element, int index) {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		drop = new Select(element);
		drop.selectByIndex(index);

	}

	public static void selectDropdownValueByValue(WebElement element, String value) {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}

		drop = new Select(element);
		drop.selectByValue(value);

	}

	public static void switchToFrameByFrameName(String frameName) {

		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void switchToFrameByFrameIndex(int index) {

		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void switchToFrameByFrameLocator(WebElement element) {

		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void dragAndDrop(WebElement source, WebElement dest) {

		try {

			wait.until(ExpectedConditions.visibilityOf(source));
			wait.until(ExpectedConditions.visibilityOf(dest));
		} catch (Exception e) {
			System.out.println(e);
		}

		action = new Actions(driver);
		action.dragAndDrop(source, dest).perform();

	}

	public static void moveToElement(WebElement element) {

		try {

			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			System.out.println(e);
		}

		action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public static void switchToTab(int index) {

		Set<String> tabs = driver.getWindowHandles();

		ArrayList<String> tabindex = new ArrayList<String>(tabs);

		driver.switchTo().window(tabindex.get(index));

	}

}
