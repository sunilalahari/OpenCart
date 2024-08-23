package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage {
	
	private WebDriver driver;
	private By productImages=By.cssSelector(".image-additional");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	

}
