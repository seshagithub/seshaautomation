package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {
  
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	
	
	@BeforeMethod
	
    public void setUp() {
		basePage = new BasePage(); // by creating object for Basepage class WE CAN CALL methods on basepage class
	prop =	basePage.init_properties(); 
	driver = basePage.init_driver(prop);
	  loginPage =new LoginPage(driver); // creating obj for loginpage class 
	
	}
	
	@Test(priority=1)
	
	public void verifyLoginPageTitle() {
		
	String title =loginPage.getLoginPageTitle();
	 
	System.out.println("title of the page is " +title );
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExisits());
	}
	@Test(priority=3)
	
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	@AfterMethod
	
	public void quitBrowser() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
