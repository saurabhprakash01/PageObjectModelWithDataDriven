package com.shurgard.automation.helper;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * 
 * @author saurabhprakash
 *
 */
public class PlaybackWait {
	public WebDriverWait wait;

	/***
	 * Waiting for element to be clickable
	 */
	public WebElement waitForElementToBeClickable(WebDriver driver, long time, WebElement element) {
		wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/***
	 * Waiting for element to be visible
	 */
	public WebElement waitForvisibilityOfElement(WebDriver driver, long time, WebElement element) {
		wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/***
	 * Waiting for element if not found it will poll for every 5 secs
	 */
	public WebElement waitForElementWithPollingInterval(WebDriver driver, long time, WebElement element) {
		wait = new WebDriverWait(driver, time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/***
	 * Implicit wait on driver instance
	 */
	public void implicitWait(WebDriver driver, long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/***
	 * Handling Spinner while loading the page
	 */
	public String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, WebElement element) {
		if ((driver == null) || (element == null)) {

			return "Either WebDriver or WebElement is null";
		}
		try {
			(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOf(element));
			return null;
		} catch (Exception e) {
			return "Spinner Disappeared...";
		}
	}
}
