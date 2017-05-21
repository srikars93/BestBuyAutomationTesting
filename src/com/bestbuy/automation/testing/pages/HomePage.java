package com.bestbuy.automation.testing.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bestbuy.automation.testing.constants.DataConstants;
import com.bestbuy.automation.testing.constants.ElementsConstants;
import com.bestbuy.automation.testing.singleton.BestBuyDriver;
import com.bestbuy.automation.testing.singleton.PropertyLoader;

public class HomePage {
	public static void closePopUp() {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();

		try {
			driver.findElement(By.className(props.getProperty(ElementsConstants.CLOSE_BUTTON))).click();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String loadHomePage() {
		Properties props = PropertyLoader.getDataProps();
		WebDriver driver = BestBuyDriver.getDriver();
		driver.get(props.getProperty(DataConstants.HOME_PAGE_URL));
		return driver.getTitle();
	}
}
