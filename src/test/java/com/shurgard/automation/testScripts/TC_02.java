package com.shurgard.automation.testScripts;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.shurgard.automation.helper.Excel;
import com.shurgard.automation.helper.PDF;
import com.shurgard.automation.helper.Windows;
import com.shurgard.automation.pageObjects.ContractPage;
import com.shurgard.automation.pageObjects.CreditAllocationPage;
import com.shurgard.automation.pageObjects.CustomerInfoPage;
import com.shurgard.automation.pageObjects.CustomerMoveInPage;
import com.shurgard.automation.pageObjects.CustomerReservationPage;
import com.shurgard.automation.pageObjects.CustomerSearchPage;
import com.shurgard.automation.pageObjects.DashboardPage;
import com.shurgard.automation.pageObjects.LoginPage;
import com.shurgard.automation.testBase.AutomationFoundation;
import com.shurgard.automation.testBase.Config;

/***
 * 
 * @author saurabhprakash
 * Login to Application
 * Creating a new customer
 * Verifying the customer & Inquiry status
 * Creating the new reservation & Verifying reservation Status
 * Creating Contract & Validating MoveIn Preview Page
 * Validating Contract PDF
 * Making Payment & Verifying Credit Allocation
 * Validating receipt PDF
 */
//@Listeners(CustomReport.class)
public class TC_02 extends AutomationFoundation {

	@BeforeTest
	public void setupTestData() {
		System.out.println("****Setup Test Level Data****");
		Excel.setExcelFileSheet("LoginData");
	}

	//ExtentTest test;
	//ITestResult result;

	@Test
	public void testFailedShurgardApplication() throws Exception {
		Config config = new Config(OR);
		driver.get(config.getWebsite());

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();

		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.selectCountryAndStorename();
		dashboard.clickCustomerManagement();

		CustomerSearchPage customerSearchPage = new CustomerSearchPage(driver);
		customerSearchPage.createNewCustomer();

		CustomerInfoPage customerInfoPage = new CustomerInfoPage(driver);
		customerInfoPage.enterCustomerGeneralInformation();

		Boolean inquiryStatus = customerInfoPage.getInquiryStatus()
				.equalsIgnoreCase(Excel.getCellData(3, 3).toString());
		Boolean customerStatus = dashboard.getCutomerManagementStatus().contains(Excel.getCellData(2, 3).toString());

		if (inquiryStatus && customerStatus) {
			System.out.println("Inquiry Status is New & Customer Status is Prospect....");
			Assert.assertTrue(true);
			//test = extent.startTest("TestShurgardApplication");
			//test.log(LogStatus.INFO,"Inquiry Status is New & Customer Status is Prospect....");
		} else {
			System.out.println("Inquiry Status Validation Failed....");
			System.out.println("Expected Inquiry Status : " + Excel.getCellData(1, 3).toString());
			System.out.println("Actual Inquiry Status : " + Excel.getCellData(3, 3).toString());
			getScreenshot("testShurgardApplication");
			Assert.fail();
			//test.log(LogStatus.FAIL, "TestCase FAILED !!!");
		}

		CustomerReservationPage customerReservationPage = new CustomerReservationPage(driver);
		customerReservationPage.createReservation();
		Boolean reservationStatus = customerReservationPage.getReservationStatus()
				.equalsIgnoreCase(Excel.getCellData(3, 3).toString());

		String expectedTooltip = Excel.getCellData(4, 3).toString();
		String actualTooltip = customerReservationPage.getReservationToolTip();

		if (reservationStatus && actualTooltip.equals(expectedTooltip)) {
			System.out.println("Reservation Status is Open & Tooltip verified Successfully....");
			Assert.assertTrue(true);
		} else {
			System.out.println("Reservation Status : " + customerReservationPage.getReservationStatus());
			getScreenshot("testShurgardApplication");
			//test.log(LogStatus.FAIL, "TestCase FAILED !!!");
			Assert.assertFalse(true);
		}

		customerReservationPage.clickMoveInTab();

		CustomerMoveInPage customerMoveInPage = new CustomerMoveInPage(driver);
		customerMoveInPage.enterMoveInDetails();
		customerMoveInPage.enterAccessCodeDetails();
		customerMoveInPage.enterInsuranceDetails();
		customerMoveInPage.enterInvoicingDetails();

		String moveInPreviewInsurance = customerMoveInPage.getMoveInPreviewInsurance();
		String moveInContractAccessType = customerMoveInPage.getMoveInContractAccessType();
		String moveInProduct = customerMoveInPage.getMoveInProduct();
		int newBalanceInt = customerMoveInPage.getNewBalance();
		String newBal = Integer.toString(newBalanceInt);

		if (moveInPreviewInsurance.contains(Excel.getCellData(5, 3).toString())
				&& moveInContractAccessType.contains(Excel.getCellData(7, 3).toString())
				&& moveInProduct.contains(Excel.getCellData(8, 3).toString())) {
			System.out.println("MOVEIN Preview Validated....");
			Assert.assertTrue(true);
		} else {
			System.out.println("MoveIn Preview Status : " + customerMoveInPage.getMoveInPreviewInsurance());
			System.out.println("MoveIn Preview Product Type : " + customerMoveInPage.getMoveInPreviewProductType());
			getScreenshot("testShurgardApplication");
		}

		customerMoveInPage.openInvoicePDF();
		Windows windowsHelper = new Windows(driver);
		windowsHelper.switchToNextTab();

		PDF pdfHelper = new PDF();
		pdfHelper.downloadingInvoicePDFIntoLocal();
		String pdfContent = pdfHelper.getTextFromPDF();

		if (pdfContent.contains(newBal) && pdfContent.contains(Excel.getCellData(3, 1).toString())) {
			System.out.println("PDF Validation Successfull....");
			Assert.assertTrue(true);
		} else {
			System.out.println("PDF Validation Failed....");
			getScreenshot("testShurgardApplication");
		}

		windowsHelper.switchToNextTab();
		customerMoveInPage.clickEndOfProcessCloseButton();

		ContractPage contractPage = new ContractPage(driver);
		contractPage.clickPaymentTab();
		String[] arr = contractPage.enterPaymentDetails();
		String expectedAmountInclVat = arr[0];
		String expectedAllocatedAmount = arr[1];

		CreditAllocationPage creditAllocationPage = new CreditAllocationPage(driver);
		String actualAmount = creditAllocationPage.getAmountInclusiveVAT();
		String actualAllocatedAmount = creditAllocationPage.getAllocatedAmount();
		String actualOutstandingAmount = creditAllocationPage.getOutstandingAmount();

		if (actualAmount.contains(expectedAmountInclVat) && actualAllocatedAmount.contains(expectedAllocatedAmount)
				&& actualOutstandingAmount.contains("20")) {
			System.out.println("Credit Allocation Verified Successfull....");
			Assert.assertTrue(true);
		} else {
			System.out.println("Credit Allocation Validation Failed....");
			getScreenshot("testShurgardApplication");
		}

		creditAllocationPage.receiptValidation();
		windowsHelper.switchToNextTab();
		PDF pdfHelper1 = new PDF();
		pdfHelper1.downloadingPDFIntoLocal();
		String receiptPDFContent = pdfHelper.getTextFromReceiptPDF();

		if (receiptPDFContent.contains(actualAmount) && receiptPDFContent.contains(actualAllocatedAmount)) {
			System.out.println("Receipt PDF Verified Successfull....");
			//test = extent.startTest("Receipt PDF Verified Successfull....");
			Assert.assertTrue(true);
			//test.log(LogStatus.PASS, "TestCase passed successfully");
		} else {
			System.out.println("Receipt PDF Validation Failed....");
			getScreenshot("testShurgardApplication");
			//test.log(LogStatus.FAIL, "TestCase FAILED !!!");
		}
	}
}
