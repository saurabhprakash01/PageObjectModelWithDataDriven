package com.shurgard.automation.testBase;

import java.util.Properties;

public class Config extends AutomationFoundation{

	private Properties OR;
	
	public Config(Properties OR){
		this.OR = OR;
	}

	public int getImplicitWait() {
		return Integer.parseInt(OR.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("ExplicitWait"));
	}
	
	public String getBrowser() {
		return OR.getProperty("Browser");
	}	
	
	public String getWebsite() {
		return OR.getProperty("Website");
	}
	
	public String getPDF() {
		return OR.getProperty("PDF");
	}
	
	public String getReceiptPDF() {
		return OR.getProperty("receiptPDF");
	}
	
	public String getUsername() {
		return OR.getProperty("username");
	}
	
	public String getPassword() {
		return OR.getProperty("password");
	}
}
