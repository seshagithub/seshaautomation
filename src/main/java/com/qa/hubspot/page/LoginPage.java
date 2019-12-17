package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	
	WebDriver driver;
	
	// 1. page objects /By locators
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signupLink = By.linkText("Sign up");
	
	//2.creating page class constructor
	
	public LoginPage(WebDriver driver) {
	this.driver =driver;
		
}
    //3.page actions/methods
	
	public String getLoginPageTitle() {
		
	return	driver.getTitle();
	}


   public boolean isSignUpLinkExisits() {
	   return  driver.findElement(signupLink).isDisplayed();
   }

   public HomePage doLogin(String username, String pswd) {
	   driver.findElement(emailId).sendKeys(username);
	   driver.findElement(password).sendKeys(pswd);
	   driver.findElement(loginButton).click();
	   
	   return new HomePage(driver);  // returning home page object ref
	   
   }























}


