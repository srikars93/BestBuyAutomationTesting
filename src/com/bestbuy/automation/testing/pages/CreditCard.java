package com.bestbuy.automation.testing.pages;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bestbuy.automation.testing.constants.DataConstants;
import com.bestbuy.automation.testing.constants.ElementsConstants;
import com.bestbuy.automation.testing.singleton.BestBuyDriver;
import com.bestbuy.automation.testing.singleton.PropertyLoader;

public class CreditCard {
	public static void AddCreditCard() throws Exception {

		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getDataProps();
		Properties props1 = PropertyLoader.getElementsProps();
		WebElement creditcard = driver.findElement(By.className(props1.getProperty(ElementsConstants.ADDCREDITCARD_ELEMENT)));
		if (creditcard.isDisplayed()) {
			creditcard.click();
			driver.findElement(By.id(props1.getProperty(ElementsConstants.CARDNUMBER_ELEMENT))).sendKeys(props.getProperty(DataConstants.CARDNUMBER_DATA));
			WebElement month = driver.findElement(By.id(props1.getProperty(ElementsConstants.EXPIRYMONTH_ELEMENT)));
			Select monthexpiry = new Select(month);
			monthexpiry.selectByValue(props.getProperty(DataConstants.EXPIRYMONTH_DATA));
			WebElement year = driver.findElement(By.id(props1.getProperty(ElementsConstants.EXPIRYYEAR_ELEMENT)));
			Select yearexpiry = new Select(year);
			yearexpiry.selectByValue(props.getProperty(DataConstants.EXPIRYYEAR_DATA));
			driver.findElement(By.name(props1.getProperty(ElementsConstants.FIRSTNAME_ELEMENT))).sendKeys(props.getProperty(DataConstants.FIRSTNAME_DATA));
			driver.findElement(By.name(props1.getProperty(ElementsConstants.LASTNAME_ELEMENT))).sendKeys(props.getProperty(DataConstants.LASTNAME_DATA));
			driver.findElement(By.name(props1.getProperty(ElementsConstants.ADDRESSLINE1_ELEMENT))).sendKeys(props.getProperty(DataConstants.ADDRESSLINE1_DATA));
			driver.findElement(By.name(props1.getProperty(ElementsConstants.CITY_ELEMENT))).sendKeys(props.getProperty(DataConstants.CITY_DATA));
			WebElement state = driver.findElement(By.name(props1.getProperty(ElementsConstants.STATE_ELEMENT)));
			Select selectstate = new Select(state);
			selectstate.selectByValue(props.getProperty(DataConstants.STATE_DATA));
			driver.findElement(By.name(props1.getProperty(ElementsConstants.POSTALCODE_ELEMENT))).sendKeys(props.getProperty(DataConstants.POSTALCODE_DATA));
			driver.findElement(By.name(props1.getProperty(ElementsConstants.PHONENUMBER_ELEMENT))).sendKeys(props.getProperty(DataConstants.PHONENUMBER_DATA));
			driver.findElement(By.className(props1.getProperty(ElementsConstants.BUTTON_ELEMENT))).click();
			Thread.sleep(3000);
			driver.findElement(By.className(props1.getProperty(ElementsConstants.BUTTON_ELEMENT))).click();
			WebElement cardsuccess = driver.findElement(By.className(props1.getProperty(ElementsConstants.ALERTSUCCESS_ELEMENT)));
			if (cardsuccess.isDisplayed()){
				assertEquals(cardsuccess.getText(), "Your new card has been successfully added.");
				System.out.println("Your new card has been successfully added.");
			}
		} else {
			System.out.println("A credit card is already present");
		}
	}
}
