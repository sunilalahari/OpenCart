package com.qa.opencart.base;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;

public class BaseTest {
	protected WebDriver driver;
	protected DriverFactory driverFactory;
	protected Properties prop;
	protected LoginPage login;
	protected AccountsPage account;
	protected ProductInfoPage products;
	
	
	@BeforeTest
	public void setUp() {
		driverFactory = new DriverFactory();
		prop= driverFactory.initProperties();
		String browser= prop.getProperty("browser");
		System.out.println(browser);
		driver =driverFactory.initDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		login = new LoginPage(driver);	
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
