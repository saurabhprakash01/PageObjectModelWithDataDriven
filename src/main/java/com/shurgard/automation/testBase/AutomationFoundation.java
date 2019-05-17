package com.shurgard.automation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class AutomationFoundation{

	public WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;
	
	public static final String testDataExcelFileName = "testdata.xlsx";

	@BeforeTest
	public WebDriver launchBrowser() {
		try {
			loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Config config = new Config(OR);
		getBrowser(config.getBrowser());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public void getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
	}

	public void loadProperties() throws IOException {
		OR = new Properties();
		f1 = new File(
				System.getProperty("user.dir") + "/src/main/java/com/shurgard/automation/config/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);
	}

	public String getScreenshot(String imageName) throws IOException {
		if (imageName.equals("")) {
			imageName = "blank";
		}
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = System.getProperty("user.dir") + "/src/main/java/com/shurgard/automation/screenshot/";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImage = imageLocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";

		File destFile = new File(actualImage);
		FileUtils.copyFile(image, destFile);
		return actualImage;
	}

/*	@AfterTest
	public void tearDown() {
		// driver.quit();
	}*/
}
