package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private  By firstName= By.xpath("//input[@placeholder='First Name']");
	private By lastname= By.xpath("//input[@placeholder='Last Name']");
	private By Email = By.xpath("//input[@placeholder='E-Mail']");
	private By telephone= By.xpath("//input[@placeholder='Telephone']");
	private By pwd= By.xpath("//input[@placeholder='Password']");
	private By pwdConfirm =By.xpath("//input[@placeholder='Password Confirm']");
	
	private By subscribeYes= By.xpath("(//label[text()='Subscribe']//following-sibling::div//input)[position()=1]");
	private By subscribeNo = By.xpath("(//label[text()='Subscribe']//following-sibling::div//input)[position()=2]");
	private By agree =By.xpath("//a[.='Privacy Policy']//following-sibling::input[@name='agree']");
	private By submit =By.xpath("//a[.='Privacy Policy']//following-sibling::input[@value='Continue']");
	private By caretIcon = By.cssSelector(".caret");
	private By register = By.xpath("//li[@class=\"dropdown open\"]//a[.='Register']");
	public RegisterAccountPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void RegisterUsers(String fn, String ln, String email, String Phone,
			String pawd, String pwdConfirm, String Subscribe) {
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(caretIcon)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(register)).click();
		driver.findElement(firstName).sendKeys(fn);
		driver.findElement(lastname).sendKeys(ln);
		driver.findElement(Email).sendKeys(email);
		driver.findElement(telephone).sendKeys(Phone);
		driver.findElement(pwd).sendKeys(pawd);
		driver.findElement(this.pwdConfirm).sendKeys(pwdConfirm);
		driver.findElement(agree).click();
		driver.findElement(submit).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
