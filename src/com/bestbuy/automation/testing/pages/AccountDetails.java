package com.bestbuy.automation.testing.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bestbuy.automation.testing.constants.ElementsConstants;
import com.bestbuy.automation.testing.singleton.BestBuyDriver;
import com.bestbuy.automation.testing.singleton.PropertyLoader;

public class AccountDetails {
	public static void AccountHome() {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		WebElement srikar = driver.findElement(By.id(props.getProperty(ElementsConstants.HISRIKAR_ELEMENT)));
		srikar.click();
		WebElement accounthome = driver.findElement(By.linkText(props.getProperty(ElementsConstants.ACCOUNTHOME_ELEMENT)));
		accounthome.click();

	}

	public static String VerifyAccountHome() {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		WebElement srikar1 = driver.findElement(By.className(props.getProperty(ElementsConstants.WELCOMENAME_ELEMENT)));
		return srikar1.getText();

	}
	public static String VerifyMemberShipID(){
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		WebElement memberid = driver.findElement(By.className(props.getProperty(ElementsConstants.MEMBERID_ELEMENT)));
		return memberid.getText();
	}
}