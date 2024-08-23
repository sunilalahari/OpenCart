package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public AccountsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By sectionHeader= By.cssSelector("#content h2");
	private By linksAvailble = By.cssSelector("#content ul>li");
	private By searchTextbox= By.xpath("//div[@id='search']//input[@name='search']");
	private By searchbtn= By.xpath("//div[@id='search']//input[@name='search']//following-sibling::span//button//i");
	
	public void searchProduct(String productKey) {
		driver.findElement(searchTextbox).clear();
		driver.findElement(searchTextbox).sendKeys(productKey);
		driver.findElement(searchbtn).click();
	}
	
	public ProductInfoPage selectProductFromSearch(String product) {
		wait= new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("//h4//a[text()='"+product+"']"))).click();
		return new ProductInfoPage(driver);
		
	}
	

	

}
