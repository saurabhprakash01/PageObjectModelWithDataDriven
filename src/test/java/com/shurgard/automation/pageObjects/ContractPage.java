package com.shurgard.automation.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shurgard.automation.helper.Excel;
import com.shurgard.automation.helper.PlaybackWait;

/***
 * 
 * @author saurabhprakash
 * Contract page Webelements and there respected methods
 */
public class ContractPage {
	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();

	@FindBy(xpath = "//*[@title='Payment']")
	private WebElement paymentTab;
	
	@FindBy(xpath = "//*[@id='select-TimeZone']")
	private WebElement paymentName;

	@FindBy(xpath = "//*[@name='amountValue']")
	private WebElement paymentAmount;

	@FindBy(xpath = "//*[@class='btn btn-default btn-save' and text()='NEXT']")
	private WebElement paymentNextButton;

	public ContractPage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPaymentTab() throws InterruptedException {
		Thread.sleep(5000);
		paymentTab.click();
	}
	
	public String getPaymentAmount() {
		waitHelper.waitForvisibilityOfElement(driver, 10, paymentAmount);
		return paymentAmount.getAttribute("value");
	}
	
	public String[] enterPaymentDetails() throws InterruptedException{
		Select selectPaymentMethod = new Select(paymentName);
		selectPaymentMethod.selectByVisibleText(Excel.getCellData(25, 1).toString());
		String actualAmount = getPaymentAmount();
		int roundoff_value = (int) Float.parseFloat(actualAmount);
		int someAmount = roundoff_value-20;
		String newAmount = Integer.toString(someAmount);
		String arr[] = new String[2];
		arr[0] = Integer.toString(roundoff_value);
		arr[1] = Integer.toString(someAmount);
		waitHelper.waitForvisibilityOfElement(driver, 20, paymentAmount);
		paymentAmount.sendKeys(Keys.CONTROL + "a");
		paymentAmount.sendKeys(Keys.DELETE); 
		Thread.sleep(5000);
		paymentAmount.sendKeys(newAmount);
		paymentNextButton.click();
		return arr;
	}
}
