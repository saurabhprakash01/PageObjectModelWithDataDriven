package com.shurgard.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shurgard.automation.helper.PlaybackWait;

/***
 * 
 * @author saurabhprakash
 * Customer Search Page & there respected methods
 */
public class CustomerSearchPage {

	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();

	@FindBy(xpath = "//button[@class='btn btn-default btn-cust-add pull-right']//*[text()='+']")
	private WebElement newCustomer;

	public CustomerSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createNewCustomer() throws InterruptedException {
		Thread.sleep(3000);
		newCustomer.click();
	}
}
