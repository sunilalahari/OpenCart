package com.qa.opencart.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.qa.opencart.driverfactory.DriverFactory;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private DriverFactory df;
	private By email = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@type='password']");
	private By submit= By.xpath("//input[@type='submit']");
	private By frgPassword= By.xpath("//input//following-sibling::a[.='Forgotten Password']");
	private By footerLinks= By.xpath("//footer//div[@class='container']//ul//li//a");
	private By caretIcon = By.cssSelector(".caret");
	private By logOut= By.xpath("//li//a[.='Logout']");
	
	@FindBy(how = How.XPATH, using="//input[@name='email']")
	private WebElement ele;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Actions
	
	public boolean verifyForgoteenLink() {	
		return driver.findElement(frgPassword).isDisplayed();
			
	}
	
	public AccountsPage doLogin() {
		df= new DriverFactory();
		Properties prop= df.initProperties();
		driver.findElement(email).sendKeys(prop.getProperty("username"));
		driver.findElement(password).sendKeys(prop.getProperty("pwd"));
		driver.findElement(submit).click();	
		return new AccountsPage(driver);	
	}

	public RegisterAccountPage doLogOut() {
	wait= new WebDriverWait(driver, Duration.ofSeconds(10));	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	wait.until(ExpectedConditions.elementToBeClickable(caretIcon)).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(logOut)).click();
	return new RegisterAccountPage(driver);
	}
	@DataProvider
	public Object[][] getDataFromExcel() {
		Object[][] obj=
			{
				{"Sunil","Kumar"}
			};
		return obj;
		}
	
	
	public List<String> verifyPageFooterLinks() {
		List<WebElement> links= driver.findElements(footerLinks);
		List<String> list = new ArrayList<String>();
		for(WebElement ele: links) {
			String s= ele.getText();
			list.add(s);
		}
		return list;	
	}
	}
	
