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

	public static String loadSignInPage() {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement account = driver.findElement(By.className(props.getProperty(ElementsConstants.ACCOUNT_ELEMENT)));
		wait.until(ExpectedConditions.elementToBeClickable(account));
		account.click();
		WebElement signin = driver.findElement(By.className(props.getProperty(ElementsConstants.SIGNIN_ELEMENT)));
		signin.click();
		return driver.getTitle();
	}

	public static void signIn() {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		Properties props1 = PropertyLoader.getDataProps();
		WebElement email = driver.findElement(By.id(props.getProperty(ElementsConstants.EMAILID_ELEMENT)));
		email.sendKeys(props1.getProperty(DataConstants.EMAILID_DATA));
		WebElement pass = driver.findElement(By.id(props.getProperty(ElementsConstants.PASSWORD_ELEMENT)));
		pass.sendKeys(props1.getProperty(DataConstants.PASSWORD_DATA));
		WebElement signin = driver.findElement(By.className(props.getProperty(ElementsConstants.LOGIN_ELEMENT)));
		signin.click();

	}

	public static String AccountVerify() {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props2 = PropertyLoader.getElementsProps();
		WebElement srikar = driver.findElement(By.id(props2.getProperty(ElementsConstants.HISRIKAR_ELEMENT)));
		return srikar.getText();
	}

	public static void signOut() throws Exception {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getElementsProps();
		WebElement signout = driver.findElement(By.id(props.getProperty(ElementsConstants.HISRIKAR_ELEMENT)));
		signout.click();
		Thread.sleep(1000);
		WebElement logout = driver.findElement(By.id(props.getProperty(ElementsConstants.LOGOUTBUTTON_ELEMENT)));
		logout.click();
	}
}
