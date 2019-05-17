package com.shurgard.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shurgard.automation.helper.Excel;
import com.shurgard.automation.helper.PlaybackWait;
import com.shurgard.automation.helper.UI;

/***
 * 
 * @author saurabhprakash
 * Customer Reservation Page & respected methods
 */
public class CustomerReservationPage {

	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();
	UI uiHelper = new UI();

	@FindBy(xpath = "//*[@title='Create Reservation']")
	private WebElement createReservationTab;

	@FindBy(xpath = "//*[@class='row create-reservation']//*[@placeholder='dd-mm-yyyy']")
	private WebElement moveInDate;

	@FindBy(xpath = "//*[@class='form-group']//*[@name='reservationFee']")
	private WebElement reservationFee;

	@FindBy(xpath = "//input[@class='select-btn reset-select-btn dt-cur' and @type='button']")
	private WebElement productType;

	@FindBy(xpath = "//*[@role='columnheader' and text()='AVAILABLE']")
	private WebElement availableColumn;
	
	@FindBy(xpath = "//*[@role='columnheader' and text()='RESERVED']")
	private WebElement reservedColumn;

	@FindBy(id = "reservation-store")
	private WebElement reservationStore;

	@FindBy(id = "product-class")
	private WebElement productClass;

	@FindBy(xpath = "//div[@class='ag-body-container']//div[@row-index='0']")
	private WebElement availableProduct;

	@FindBy(xpath = "//button[@class='btn btn-warning' and contains(text(),'SAVE')]")
	private WebElement productTypeSaveButton;

	@FindBy(xpath = "//*[@class='btn btn-default btn-next' and text()='NEXT']")
	private WebElement reservationNextButton;

	@FindBy(xpath = "//*[@class='btn btn-default btn-add-cont-add move-center' and text()='SELECT']")
	private WebElement merchandiseSaleSelect;

	@FindBy(xpath = "//*[@class='btn btn-default btn-next' and text()='PREVIEW AND SAVE']")
	private WebElement previewAndSaveButton;

	@FindBy(xpath = "//*[@col-id='Status' and @role='gridcell']")
	private WebElement reservationStatus;
	
	@FindBy(xpath = "//*[@col-id='Channel' and @role='gridcell']")
	private WebElement reservationChannel;

	@FindBy(xpath = "//*[@title='Move-In']")
	private WebElement moveInTab;

	@FindBy(xpath = "//*[@class='btn btn-default btn-left-mg' and text()='SKIP']")
	private WebElement skipButton;

	public CustomerReservationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createReservation() throws InterruptedException {
		waitHelper.waitForElementToBeClickable(driver, 10, createReservationTab);
		createReservationTab.click();
		Select select = new Select(reservationStore);
		select.selectByVisibleText(Excel.getCellData(17, 1).toString());
		Select select1 = new Select(productClass);
		select1.selectByVisibleText(Excel.getCellData(18, 1).toString());
		Thread.sleep(5000);	
		productType.click();
		Thread.sleep(5000);
		//reservedColumn.click();
		Actions actions = new Actions(driver);
		actions.doubleClick(reservedColumn).perform();
		availableProduct.click();
		productTypeSaveButton.click();
		moveInDate.sendKeys(Excel.getCellData(19, 1).toString());
		Thread.sleep(5000);
		uiHelper.scrollIntoView(driver, previewAndSaveButton);
		previewAndSaveButton.click();
	}

	public String getReservationStatus() {
		return reservationStatus.getText();
	}
	
	public String getReservationToolTip() {
		return reservationChannel.getAttribute("title");
	}

	public void clickMoveInTab() {
		moveInTab.click();
		waitHelper.waitForElementToBeClickable(driver, 10, skipButton);
		skipButton.click();
	}
}
