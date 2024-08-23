package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.ExcelUtil;

public class MyAccounts extends BaseTest {
	private WebDriver driver;
	
	@BeforeTest
	public void preRequisite() {
		account= login.doLogin();
	}
	
	@DataProvider
	public Object[][] getProductData() {
		ExcelUtil utils = new ExcelUtil();
		String location = System.getProperty("user.dir")+"/src/test/resources/data/RegisterAccount.xlsx";
		
		return utils.getRegisterTestData("Products", location);
	}
	@Test(dataProvider = "getProductData")
	public void searchProducts(String searchKey, String product) throws InterruptedException {
		account.searchProduct(searchKey);
		Thread.sleep(2000);
		products= account.selectProductFromSearch(product);
		Thread.sleep(2000);
		//Assert.assertEquals(false, true);
		
	}

}
