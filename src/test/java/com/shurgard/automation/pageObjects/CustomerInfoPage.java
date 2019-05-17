package com.shurgard.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shurgard.automation.helper.Excel;
import com.shurgard.automation.helper.UI;
import com.shurgard.automation.helper.PlaybackWait;

/***
 * 
 * @author saurabhprakash
 * Customer Info Page & there respected methods
 */
public class CustomerInfoPage {

	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();
	UI uiHelper = new UI();

	@FindBy(xpath = "//*[@id = 'lang-rad-E']")
	private WebElement language;

	@FindBy(xpath = "//*[@id = 'add-title']")
	private WebElement title;

	@FindBy(xpath = "//*[@id = 'add-c-store']")
	private WebElement customerStore;

	@FindBy(xpath = "//*[@id = 'add-f-n']")
	private WebElement firstName;

	@FindBy(xpath = "//*[@name= 'lname']")
	private WebElement lastName;

	@FindBy(xpath = "//*[@name= 'dob']")
	private WebElement dob;

	@FindBy(xpath = "//*[@value= 'E']")
	private WebElement sendDocAs;

	@FindBy(xpath = "//*[@value= 'RESIDENTIAL']")
	private WebElement cusutomerGroup;

	@FindBy(xpath = "//*[contains(@id,'phone_number')]")
	private WebElement phoneNo;

	@FindBy(xpath = "//*[contains(@id,'email_id')]")
	private WebElement email;

	@FindBy(xpath = "//button[@type='submit' and text()='NEXT']")
	private WebElement nextButton;

	@FindBy(xpath = "//*[@class='btn btn-default btn-add-cont-add btn-align-contact' and text()='+ CONTACTS']")
	private WebElement emergencyContact;

	@FindBy(xpath = "//*[contains(@id,'add-title-contacts')]")
	private WebElement emergencyContactTitle;

	@FindBy(xpath = "//*[contains(@id,'contact_id') and @placeholder='First Name']")
	private WebElement emergencyContactFirstName;
	
	@FindBy(xpath = "//*[contains(@id,'contact_id') and @placeholder='Last Name']")
	private WebElement emergencyContactLastName;

	@FindBy(xpath = "//*[contains(@id,'contact_phone_id')]")
	private WebElement emergencyContactPhone;

	@FindBy(xpath = "//*[contains(@id,'contact_emailid')]")
	private WebElement emergencyContactEmail;

	@FindBy(xpath = "//*[@id='thirdAccr']")
	private WebElement addressDetails;

	@FindBy(xpath = "//*[@class='btn btn-default btn-add-cont-add btn-align-contact' and text()='+ ADDRESS']")
	private WebElement addressButton;

	@FindBy(xpath = "//*[contains(@id,'huse-nm')]")
	private WebElement houseNumber;

	@FindBy(xpath = "//*[contains(@id,'care-off')]")
	private WebElement careOff;

	@FindBy(xpath = "//*[@class='btn btn-success postalcodepopup' and contains(text(),'SELECT')]")
	private WebElement postalCode;

	@FindBy(xpath = "//*[@class='ag-cell ag-cell-not-inline-editing ag-cell-no-focus ag-cell-value' and text()='1005']")
	private WebElement selectPostalCode;

	/*
	 * @FindBy(xpath =
	 * "//*[@class='btn btn-default btn-add-cont-add btn-add-postal' and text()='+ NEW']"
	 * ) private WebElement newPostalCode;
	 * 
	 * @FindBy(xpath = "//*[@id='modal-pc']") private WebElement postalCode;
	 * 
	 * @FindBy(xpath = "//*[@id='modal-cc']") private WebElement countryPostalCode;
	 * 
	 * @FindBy(xpath = "//*[@id='modal-city']") private WebElement cityPostalCode;
	 * 
	 * @FindBy(xpath =
	 * "//*[@class='form-group']//*[@type='submit' and text()='SAVE']") private
	 * WebElement savePostalCode;
	 */

	@FindBy(xpath = "//*[contains(@id,'street-nm') and @placeholder='Line 1']")
	private WebElement streetNameLine1;

	@FindBy(xpath = "//*[contains(@id,'street-nm') and @placeholder='Line 2']")
	private WebElement streetNameLine2;

	@FindBy(xpath = "//*[contains(@id,'street-nm') and @placeholder='Line 3']")
	private WebElement streetNameLine3;

	@FindBy(xpath = "//*[@class='panel-collapse collapse in show']//*[text()='NEXT']")
	private WebElement addressNextButton;

	@FindBy(xpath = "//*[@name='optionsRadiosEmail' and @value='Y']")
	private WebElement acceptsEmail;

	@FindBy(xpath = "//*[@name='postalMail' and @value='Y']")
	private WebElement postalEmail;

	@FindBy(xpath = "//*[@name='thirdParty' and @value='Y']")
	private WebElement thirdPartAuthorization;

	@FindBy(xpath = "//*[@class = 'btn btn-default btn-save' and @type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//*[@col-id='Status' and @role='gridcell']")
	private WebElement inquiryStatus;

	@FindBy(xpath = "//a[contains(@href,'customer-inquiry')]")
	private WebElement inquiryTab;

	public CustomerInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterCustomerGeneralInformation() throws InterruptedException {
		waitHelper.waitForElementToBeClickable(driver, 20, language);
		language.click();
		Select select = new Select(title);
		select.selectByVisibleText(Excel.getCellData(2, 1).toString());
		firstName.sendKeys(Excel.getCellData(3, 1).toString());
		lastName.sendKeys(Excel.getCellData(4, 1).toString());
		dob.sendKeys(Excel.getCellData(5, 1).toString());
		phoneNo.sendKeys(Excel.getCellData(6, 1).toString());
		email.sendKeys(Excel.getCellData(7, 1).toString());
		uiHelper.scrollIntoView(driver, nextButton);
		waitHelper.waitForElementToBeClickable(driver, 20, nextButton);
		nextButton.click();

		emergencyContact.click();
		Select select1 = new Select(emergencyContactTitle);
		select1.selectByVisibleText(Excel.getCellData(8, 1).toString());
		emergencyContactFirstName.sendKeys(Excel.getCellData(9, 1).toString());
		emergencyContactLastName.sendKeys(Excel.getCellData(28, 1).toString());
		emergencyContactPhone.sendKeys(Excel.getCellData(10, 1).toString());
		emergencyContactEmail.sendKeys(Excel.getCellData(11, 1).toString());
		waitHelper.waitForElementToBeClickable(driver, 10, addressDetails);
		addressDetails.click();

		addressButton.click();
		//houseNumber.sendKeys(Excel.getCellData(12, 1).toString());
		careOff.sendKeys(Excel.getCellData(13, 1).toString());

		waitHelper.waitForElementToBeClickable(driver, 20, postalCode);
		Thread.sleep(5000);
		postalCode.click();
		waitHelper.waitForElementToBeClickable(driver, 10, selectPostalCode);
		selectPostalCode.click();

		streetNameLine1.sendKeys(Excel.getCellData(14, 1).toString());
		streetNameLine2.sendKeys(Excel.getCellData(15, 1).toString());
		streetNameLine3.sendKeys(Excel.getCellData(16, 1).toString());
		uiHelper.scrollIntoView(driver, addressNextButton);
		Thread.sleep(5000);
		addressNextButton.click();
		acceptsEmail.click();
		postalEmail.click();
		thirdPartAuthorization.click();
		saveButton.click();
		Thread.sleep(5000);
		uiHelper.scrollUp(driver);
		waitHelper.waitForElementToBeClickable(driver, 20, inquiryTab);
		inquiryTab.click();
	}

	public String getInquiryStatus() throws InterruptedException {
		Thread.sleep(5000);
		return inquiryStatus.getText();
	}
}
