package com.bestbuy.automation.testing.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bestbuy.automation.testing.constants.DataConstants;
import com.bestbuy.automation.testing.constants.ElementsConstants;
import com.bestbuy.automation.testing.singleton.BestBuyDriver;
import com.bestbuy.automation.testing.singleton.PropertyLoader;

public class SignOnPage {

	public static String loadSignInPage(){
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		WebElement account = driver.findElement(By.className(props.getProperty(ElementsConstants.ACCOUNT)));
		account.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement signin = driver.findElement(By.className(props.getProperty(ElementsConstants.SIGNIN)));
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		signin.click();
		return driver.getTitle();
		
	}
	
	public static String signIn(){
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		Properties props1 = PropertyLoader.getDataProps();
		WebElement email = driver.findElement(By.id(props.getProperty(ElementsConstants.EMAIL_ELEMENT)));
		email.sendKeys(props1.getProperty(DataConstants.EMAIL));
		WebElement pass = driver.findElement(By.id(props.getProperty(ElementsConstants.PASS_ELEMENT)));
		pass.sendKeys(props1.getProperty(DataConstants.PASS));
		WebElement signin = driver.findElement(By.className(props.getProperty(ElementsConstants.LOGIN)))	;
		signin.click();
		return driver.getTitle();
	}
	
	public static void signOut(){
		
	}

}
