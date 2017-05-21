package com.bestbuy.automation.testing.singleton;

	import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


	public class BestBuyDriver {

		private static WebDriver driver;
		
		private BestBuyDriver(){
			
		}
		
		public static WebDriver getDriver(){
			if(driver == null){
				System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
				ChromeOptions Options = new ChromeOptions();
				Map <String,Object> prefs = new HashMap<String,Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				Options.setExperimentalOption("prefs", prefs);
				driver  = new ChromeDriver(Options);
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			}
			return driver;
		}
	}


