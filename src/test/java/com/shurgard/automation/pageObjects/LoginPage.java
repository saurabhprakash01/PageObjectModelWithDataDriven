package com.shurgard.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shurgard.automation.helper.Excel;
import com.shurgard.automation.helper.PlaybackWait;

/***
 * 
 * @author saurabhprakash
 * Login Page & there repected methods
 */
public class LoginPage {

	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();
	//Config config = new Config(OR);

	@FindBy(xpath = "//*[contains(@id,'InputEmail')]")
	private WebElement username;

	@FindBy(xpath = "//*[contains(@id,'InputPassword')]")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//*[@class='circular']")
	private WebElement spinner;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login() {
		waitHelper.waitForElementNotVisible(10, driver, spinner);
		username.sendKeys(Excel.getCellData(0, 1).toString());
		password.sendKeys(Excel.getCellData(1, 1).toString());
		loginButton.click();
	}
}
