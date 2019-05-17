package com.shurgard.automation.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.shurgard.automation.testBase.AutomationFoundation;
import com.shurgard.automation.testBase.Config;
/***
 * 
 * @author saurabhprakash
 * Downloading PDF & Reading data from PDF
 */
public class PDF extends AutomationFoundation{

	Config config = new Config(OR);
	
	/**
	 * Getting text from PDF
	 */
	public String getTextFromPDF() throws IOException {
		URL url = new URL(config.getPDF());
		BufferedInputStream file = new BufferedInputStream(url.openStream());

		PDDocument document = null;
		document = PDDocument.load(file);
		String pdfContent = new PDFTextStripper().getText(document);
		return pdfContent;
	}

	/**
	 * Downloading PDF into local
	 */
	public void downloadingPDFIntoLocal() throws AWTException, InterruptedException {
		Robot rb = new Robot();
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}
	
	/**
	 * Downloading PDF into local
	 */
	public void downloadingInvoicePDFIntoLocal() throws AWTException, InterruptedException {
		Robot rb = new Robot();
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}

	public String getTextFromReceiptPDF() throws IOException, InterruptedException {
		Thread.sleep(5000);
		URL url = new URL(config.getReceiptPDF());
		BufferedInputStream file = new BufferedInputStream(url.openStream());

		PDDocument document = null;
		document = PDDocument.load(file);
		String pdfContent = new PDFTextStripper().getText(document);
		return pdfContent;
	}
}
