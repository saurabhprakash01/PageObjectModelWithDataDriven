package com.shurgard.automation.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UI {
	
	/**
	 * Scroll the page down to find the element
	 */
	public void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * Scroll the page to top
	 */
	public void scrollUp(WebDriver driver) {
		WebElement element = driver.findElement(By.tagName("header"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); 
	}
}
