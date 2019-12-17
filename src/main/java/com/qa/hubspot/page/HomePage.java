package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;
	HomePage homePage;
	
	By header = By.cssSelector("h1.private-page__title");
	By accountName =By.cssSelector("div.navAccount-accountName");

	public HomePage(WebDriver driver) {
		
		this.driver =driver;
	}
	
	public String verifyHomePageTitle() {
		
	return	driver.getTitle();
	}
	
	
	public boolean verifyAccountNameExists() {
		
		return  driver.findElement(accountName).isDisplayed();
	}
	public String getHomePageAccountName() {
		return driver.findElement(accountName).getText();
	}
	
public boolean verifyHomePageHeaderExists() {
		
		return  driver.findElement(header).isDisplayed();
	}
	public String getHomePageHeader() {
		return driver.findElement(header).getText();
	}
	
	
	
	
	
	
	
}
