package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.RegisterAccountPage;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterTest extends BaseTest{
	
	private WebDriver driver;
	private AccountsPage accounts;
	private RegisterAccountPage register;
	private ExcelUtil eUtil;
	
	@BeforeTest
	public void login() {
		 accounts = login.doLogin();
		 register= login.doLogOut();
	}
	@DataProvider
	public Object[][] getDataforRegister() {
		String location = System.getProperty("user.dir")+"/src/test/resources/data/RegisterAccount.xlsx";
		eUtil= new ExcelUtil();
		
		return eUtil.getRegisterTestData("Register", location);
		
		}
	@Test(dataProvider = "getDataforRegister")
	public void RegisterUsers(String fn, String ln, String email, 
			String Phone, String pwd, String pwdConfir,String sub) {
		register.RegisterUsers(fn, ln, email, Phone, pwd, pwdConfir, sub);
		login.doLogOut();
		
		
	}
	
	
	
	

}
