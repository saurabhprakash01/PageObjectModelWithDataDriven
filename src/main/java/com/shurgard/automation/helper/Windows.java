package com.shurgard.automation.helper;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.shurgard.automation.testBase.AutomationFoundation;

public class Windows {

	AutomationFoundation tb = new AutomationFoundation();
	WebDriver driver;
	PlaybackWait waitHelper = new PlaybackWait();

	public Windows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Switching control to next tab
	 */
	public void switchToNextTab() throws InterruptedException {
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				Thread.sleep(5000);
			}
		}
	}
}
