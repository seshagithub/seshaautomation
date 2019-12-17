package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {

	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SoftAssert softAssert;
	
	@BeforeMethod
	
    public void setUp() {
		basePage = new BasePage(); // by creating object for Basepage class WE CAN CALL methods on basepage class
	    prop =	basePage.init_properties(); 
	   driver = basePage.init_driver(prop);
	   loginPage =new LoginPage(driver); // creating obj for logged in page class 
	 //  homePage = new HomePage(driver);
	   homePage =  loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	   softAssert = new SoftAssert();
	}
	
	
	@Test(priority=1)
	
	public void verifyHomePageHeaderValueTest() {
		softAssert.assertTrue(homePage.verifyHomePageHeaderExists());
		
		 String headerValue =  homePage.getHomePageHeader();
		System.out.println("homepage header value is "+headerValue);
		Assert.assertEquals(headerValue, Constants.HOME_PAGE_HEADER);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	
	public void  verifyLoggedInUserTest() {
		softAssert.assertTrue(homePage.verifyAccountNameExists());
	String accountName =homePage.getHomePageAccountName();
	System.out.println("Logged in user account name is  "+ accountName);
	Assert.assertEquals(accountName, prop.getProperty(accountName));
	
	softAssert.assertAll();
	}
	
	@Test(priority=3)
	
	public void verifyHomePageTitleTest() {
		String title =homePage.verifyHomePageTitle();
		System.out.println("home page title is  "+title );
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
		
		
	}
	
	
	@AfterMethod
	
	public void quitBrowser() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
