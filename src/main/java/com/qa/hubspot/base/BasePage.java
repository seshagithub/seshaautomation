package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	
	
	
	/**
	 * this method is used to initialize the driver on the basis of browser name
	 * @param browser
	 * @return driver
	 */
	
	public WebDriver init_driver(Properties prop) {
	
	String browser =	prop.getProperty("browser");
		
	if(browser.equals("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	
	}else if(browser.equals("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}else if(browser.equals("fsafari")) {
		
		WebDriverManager.getInstance(SafariDriver.class).setup();
		driver= new SafariDriver();
	}else {
		System.out.println("please enter valid browser name ..");	
	}
		
	driver.manage().window().fullscreen();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	
	return driver;
	
	}	

	/**
	 * this method is used to initialize the properties from config.properties file
	 * @return prop
	 */
	
	public Properties init_properties() {
		
		prop = new Properties();
		
		try {
			FileInputStream	ip = new FileInputStream("/Users/seshavenu/Documents/sesha_automation/OctBatchPomSeries/"
					+"src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (IOException e) {
				
				e.printStackTrace();
		}
				
			
		return prop;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
