package com.shurgard.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shurgard.automation.helper.Excel;
import com.shurgard.automation.helper.UI;
import com.shurgard.automation.helper.PlaybackWait;
import com.shurgard.automation.helper.Windows;

/***
 * 
 * @author saurabhprakash
 * Customer MoveIn Page & there respected methods
 */
public class CustomerMoveInPage {
	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();
	UI uiHelper = new UI();
	Windows windowsHelper = new Windows(driver); 

	@FindBy(xpath = "//*[@id='add-c-store']")
	private WebElement moveInStore;

	@FindBy(xpath = "//*[@id='product-class']")
	private WebElement moveInProductClass;

	@FindBy(xpath = "//*[@name='securityDeposit']")
	private WebElement securityDeposit;

	@FindBy(xpath = "//label[@for='add-l-n']//following::div[4]")
	private WebElement productType;

	@FindBy(xpath = "//input[@id='add-l-n']")
	private WebElement productTypeText;

	@FindBy(xpath = "//*[@role='columnheader' and text()='AVAILABILITY']")
	private WebElement availableProductType;

	@FindBy(xpath = "//*[@class='ag-body-container']//*[@row-index='0']//*[@col-id='ProductTypeName']")
	private WebElement availableProduct;

	@FindBy(xpath = "//*[@id='borderLayout_eRootPanel']/following::div[2]//*[@class='btn btn-warning' and contains(text(),'OK')]")
	private WebElement okButton;

	@FindBy(xpath = "//input[@name='unitNumber']/following::div//*[@class='select-btn reset-select-btn dt-cur disabedCursor']")
	private WebElement unitNo;

	@FindBy(xpath = "//*[@class='ag-body-container']//*[@row-index='0']//*[@col-id='Unit']")
	private WebElement selectUnit;

	@FindBy(xpath = "//*[@class='btn btn-default btn-warning' and @type='submit']")
	private WebElement selectUnitOkButton;

	@FindBy(xpath = "//*[@name='priceExVat']")
	private WebElement priceExVat;

	@FindBy(xpath = "//*[@class='btn btn-default btn-next' and @type='submit']")
	private WebElement moveInMainProductNextButton;

	@FindBy(xpath = "//*[@class='panel-collapse collapse in show']//*[@class='btn btn-default btn-next' and text()='NEXT']")
	private WebElement moveInNextButton;

	@FindBy(xpath = "//*[@name='MainAccessor_AccessCode']")
	private WebElement accessCode;

	@FindBy(xpath = "//*[@name='MainAccessor_TimeZone']")
	private WebElement timeZone;

	@FindBy(xpath = "//*[@class='btn btn-warning' and contains(text(),'Continue')]")
	private WebElement continueButton;

	@FindBy(xpath = "//*[@id='select-InsuranceScale']")
	private WebElement insuranceValue;

	@FindBy(xpath = "//*[@id='select-ProductClass']")
	private WebElement insuranceProductClass;

	@FindBy(xpath = "//*[@name='PriceEUR']")
	private WebElement insurancePriceExVat;

	@FindBy(xpath = "//*[@placeholder='Invoicing Frequency']/following::button[text()='Click Here']")
	private WebElement invoicingFrequency;

	@FindBy(xpath = "//*[@class='ag-body-container']//*[@row-index='1']//*[@col-id='DISCOUNT']")
	private WebElement discountInvoicingFrequency;

	@FindBy(xpath = "//*[@class='row store-mar ']//*[@class='btn btn-warning' and contains(text(),'SAVE')]")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@class='btn btn-default btn-save' and text()=' PREVIEW AND SUBMIT']")
	private WebElement previewAndSubmitButton;

	@FindBy(xpath = "//button[text()='PAYMENT']")
	private WebElement paymentButton;

	@FindBy(xpath = "//*[@class='modal-body text-align-popupmodal']//*[contains(text(),'YES')]")
	private WebElement yesButton;

	@FindBy(xpath = "//*[@class='table preview-table']/tbody/tr[6]/td[4]")
	private WebElement moveInPreviewInsurance;

	@FindBy(xpath = "//*[@class='table preview-table']/tbody/tr[1]/td[4]")
	private WebElement moveInPreviewProductType;
	
	@FindBy(xpath = "//*[@class='table preview-table']/tbody/tr[4]/td[4]")
	private WebElement moveInContractAccessType;
	
	@FindBy(xpath = "//*[@class='table preview-table']/tbody/tr[7]/td[4]")
	private WebElement moveInProduct;

	@FindBy(xpath = "//*[@class='btn btn-default btn-next' and text()='FINISH']")
	private WebElement moveInPreviewFinishButton;

	@FindBy(xpath = "//*[@id='PrintContractDisplay']")
	private WebElement mainProductContractCheckbox;

	@FindBy(xpath = "//*[@id='PrintInvoiceDisplay']")
	private WebElement invoiceCheckbox;

	@FindBy(xpath = "//*[@id='PrintInsuranceDisplay']")
	private WebElement contractInsuranceCheckbox;
	
	@FindBy(xpath = "//*[@id='pswrd']")
	private WebElement userAuthenticationPassword ;
	
	@FindBy(xpath = "//*[@class='btn btn-default btn-back btn-warning' and text()='CONFIRM']")
	private WebElement confirmButton ;
	
	@FindBy(xpath = "//*[@heading='Print']//*[@class='btn btn-warning eop-ok-btn' and contains(text(),'OK')]")
	private WebElement endOfProcessOkButton ;
	
	@FindBy(xpath = "//*[@heading='Print']//*[contains(text(),'close')]")
	private WebElement endOfProcessCloseButton ;
	
	@FindBy(xpath = "//*[@class='spinner']")
	private WebElement spinner;
	
	@FindBy(xpath = "//*[@class='table lease-table']//*[text()='New Balance']/following::td[1]/span")
	private WebElement newBalance;
	
	public CustomerMoveInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterMoveInDetails() throws InterruptedException {
		Thread.sleep(3000);
		moveInStore.click();
		Select selectMoveInStore = new Select(moveInStore);
		selectMoveInStore.selectByVisibleText(Excel.getCellData(20, 1).toString());
		Select selectMoveInProductClass = new Select(moveInProductClass);
		selectMoveInProductClass.selectByVisibleText(Excel.getCellData(21, 1).toString());
		productType.click();
		Thread.sleep(3000);
		availableProductType.click();
		Actions actions = new Actions(driver);
		actions.doubleClick(availableProductType).perform();
		availableProduct.click();
		okButton.click();
		Thread.sleep(3000);
		unitNo.click();
		Thread.sleep(3000);
		//selectUnit.click();
		//selectUnitOkButton.click();
	}

	public String getPriceExVat() {
		waitHelper.waitForvisibilityOfElement(driver, 10, priceExVat);
		return priceExVat.getAttribute("value");
	}

	public String getproductType() {
		waitHelper.waitForvisibilityOfElement(driver, 10, productTypeText);
		return productTypeText.getAttribute("value");
	}

	public void enterAccessCodeDetails() throws InterruptedException {
		Thread.sleep(5000);
		uiHelper.scrollIntoView(driver, moveInNextButton);
		moveInNextButton.click();
		moveInNextButton.click();
		accessCode.sendKeys("1234");
		Select selectTimeZone = new Select(timeZone);
		selectTimeZone.selectByVisibleText(Excel.getCellData(22, 1).toString());
		continueButton.click();
		Thread.sleep(5000);
		moveInNextButton.click();
	}

	public void enterInsuranceDetails() {
		Select selectInsuranceValue = new Select(insuranceValue);
		selectInsuranceValue.selectByVisibleText(Excel.getCellData(23, 1).toString());
		Select selectInsuranceProductClass = new Select(insuranceProductClass);
		selectInsuranceProductClass.selectByVisibleText(Excel.getCellData(24, 1).toString());
		getInsurancePriceExVat();
	}

	public void enterInvoicingDetails() throws InterruptedException {
		moveInNextButton.click();
		moveInNextButton.click();
		invoicingFrequency.click();
		discountInvoicingFrequency.click();
		saveButton.click();
		uiHelper.scrollIntoView(driver, previewAndSubmitButton);
		Thread.sleep(3000);
		previewAndSubmitButton.click();
	}

	public String getInsurancePriceExVat() {
		waitHelper.waitForvisibilityOfElement(driver, 10, insurancePriceExVat);
		return insurancePriceExVat.getAttribute("value");
	}

	public String getMoveInPreviewInsurance() {
		return moveInPreviewInsurance.getText();
	}

	public String getMoveInPreviewProductType() {
		return moveInPreviewProductType.getText();
	}
	
	public String getMoveInContractAccessType() {
		return moveInContractAccessType.getText();
	}
	
	public String getMoveInProduct() {
		return moveInProduct.getText();
	}

	public void openInvoicePDF() throws InterruptedException {
		uiHelper.scrollIntoView(driver, moveInPreviewFinishButton);
		waitHelper.waitForElementToBeClickable(driver, 10, moveInPreviewFinishButton);
		moveInPreviewFinishButton.click();
		userAuthenticationPassword.sendKeys(Excel.getCellData(26, 1).toString());
		confirmButton.click();
		waitHelper.waitForElementNotVisible(10, driver, spinner);
		waitHelper.waitForElementToBeClickable(driver, 10, mainProductContractCheckbox);
		mainProductContractCheckbox.click();
		//invoiceCheckbox.click();
		endOfProcessOkButton.click();
		Thread.sleep(20000);
	}
	
	public int getNewBalance() {
		String newBal = newBalance.getText();
		int roundoff_value = (int) Double.parseDouble(newBal); 
		return roundoff_value;
	}
	
	public void clickEndOfProcessCloseButton() {
		endOfProcessCloseButton.click();
	}
}
