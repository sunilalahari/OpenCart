package com.qa.opencart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterAccountPage;

public class LoginTest extends BaseTest{
	@Test(priority = 1)
	
	public void footers() {
	System.out.println(login.verifyPageFooterLinks());
	}
	
	@Test(priority = 2)
	public void verifyLogin() {
		account = login.doLogin();
		RegisterAccountPage registeraccount= login.doLogOut();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority = 1)
	public void forGotLinkAvailable() {
		Assert.assertEquals(true,login.verifyForgoteenLink());
	}
	
	

}
