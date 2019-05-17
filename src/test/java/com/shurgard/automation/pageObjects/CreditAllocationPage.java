package com.shurgard.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shurgard.automation.helper.Excel;
import com.shurgard.automation.helper.UI;
import com.shurgard.automation.helper.PlaybackWait;

/***
 * 
 * @author saurabhprakash
 * Credit Allocation Page & there respected methods
 */
public class CreditAllocationPage {
	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();
	UI uiHelper = new UI();
	
	@FindBy(xpath = "//*[@class='form-horizontal ng-untouched ng-pristine ng-valid']/div[3]//*[@col-id='AmountInclusiveVAT' and @role='gridcell']")
	private WebElement amountInclusiveVAT;
	
	@FindBy(xpath = "//*[@class='form-horizontal ng-untouched ng-pristine ng-valid']/div[3]//*[@col-id='OutstandingAmount' and @role='gridcell']")
	private WebElement allocatedAmount;
	
	@FindBy(xpath = "//*[@class='form-horizontal ng-untouched ng-pristine ng-valid']/div[5]//*[@col-id='OutstandingAmount' and @role='gridcell']")
	private WebElement outstandingAmount;
	
	@FindBy(xpath = "//*[@class='btn btn-default btn-save' and text()='FINISH']")
	private WebElement paymentFinishButton;
	
	@FindBy(xpath = "//*[@id='pswrd']")
	private WebElement userAuthenticationPassword ;
	
	@FindBy(xpath = "//*[@class='btn btn-default btn-back btn-warning' and text()='CONFIRM']")
	private WebElement confirmButton ;
	
	@FindBy(xpath = "//*[@class='spinner']")
	private WebElement spinner;
	
	@FindBy(xpath = "//*[@id='PrintReceipt']")
	private WebElement receiptRadioButton;
	
	@FindBy(xpath = "//*[@heading='Print']//*[@class='btn btn-warning eop-ok-btn' and contains(text(),'OK')]")
	private WebElement endOfProcessOkButton ;
	
	public CreditAllocationPage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getAmountInclusiveVAT() {
		return amountInclusiveVAT.getText();
	}
	
	public String getAllocatedAmount() {
		return allocatedAmount.getText();
	}
	
	public String getOutstandingAmount() {
		return outstandingAmount.getText();
	}
	
	public void receiptValidation() {
		uiHelper.scrollIntoView(driver, paymentFinishButton);
		paymentFinishButton.click();
		userAuthenticationPassword.sendKeys(Excel.getCellData(26, 1).toString());
		confirmButton.click();
		waitHelper.waitForElementNotVisible(10, driver, spinner);
		waitHelper.waitForElementToBeClickable(driver, 20, receiptRadioButton);
		receiptRadioButton.click();
		endOfProcessOkButton.click();
	}
}
