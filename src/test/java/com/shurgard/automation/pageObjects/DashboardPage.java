package com.shurgard.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shurgard.automation.helper.PlaybackWait;

/***
 * 
 * @author saurabhprakash
 * Dashboard Page & there respected methods
 */
public class DashboardPage {

	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();

	@FindBy(xpath = "//*[@col-id='Name' and text()='Belgium']")
	private WebElement country;

	@FindBy(xpath = "//*[@col-id='StoreName' and text()='(XXDVBE) Waterloo']")
	private WebElement storeName;

	@FindBy(xpath = "//*[@class='card-block']//*[contains(text(),'CUSTOMER')]")
	private WebElement cutomerManagement;

	@FindBy(xpath = "//*[@class='cst_Details_value']")
	private WebElement cutomerManagementStatus;
	
	@FindBy(xpath = "//*[@class='spinner']")
	private WebElement spinner;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCountryAndStorename() throws InterruptedException {
		Thread.sleep(3000);
		waitHelper.waitForElementToBeClickable(driver, 10, country);
		country.click();
		waitHelper.waitForElementToBeClickable(driver, 10, storeName);
		storeName.click();
	}

	public void clickCustomerManagement() throws InterruptedException {
		waitHelper.waitForElementNotVisible(10, driver, spinner);
		cutomerManagement.click();
	}
	
	public String getCutomerManagementStatus() {
		return cutomerManagementStatus.getText();
	}
}
