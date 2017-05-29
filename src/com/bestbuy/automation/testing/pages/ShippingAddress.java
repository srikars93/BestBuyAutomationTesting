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

public class ShippingAddress {
	public static void AddAddress() throws Exception {
		WebDriver driver = BestBuyDriver.getDriver();
		Properties props = PropertyLoader.getDataProps();
		Properties props1 = PropertyLoader.getElementsProps();
		driver.findElement(By.className(props1.getProperty(ElementsConstants.DIRECTACCOUNTHOME_ELEMENT))).click();
		try {
			WebElement shippingaddress = driver.findElement(By.linkText("Add a Shipping Address"));
			if (shippingaddress.isDisplayed()) {
				shippingaddress.click();
				driver.findElement(By.id(props1.getProperty(ElementsConstants.FIRSTNAME_ELEMENT))).sendKeys(props.getProperty(DataConstants.FIRSTNAME_DATA));
				driver.findElement(By.id(props1.getProperty(ElementsConstants.LASTNAME_ELEMENT))).sendKeys(props.getProperty(DataConstants.LASTNAME_DATA));
				driver.findElement(By.id(props1.getProperty(ElementsConstants.ADDRESSLINE1_ELEMENT))).sendKeys(props.getProperty(DataConstants.ADDRESSLINE1_DATA));
				driver.findElement(By.name(props1.getProperty(ElementsConstants.CITY_ELEMENT))).sendKeys(props.getProperty(DataConstants.CITY_DATA));
				WebElement state = driver.findElement(By.name(props1.getProperty(ElementsConstants.STATE_ELEMENT)));
				Select selectstate = new Select(state);
				selectstate.selectByValue(props.getProperty(DataConstants.STATE_DATA));
				driver.findElement(By.id(props1.getProperty(ElementsConstants.POSTALCODE_ELEMENT))).sendKeys(props.getProperty(DataConstants.POSTALCODE_DATA));
				driver.findElement(By.name(props1.getProperty(ElementsConstants.PHONENUMBER_ELEMENT))).sendKeys(props.getProperty(DataConstants.PHONENUMBER_DATA));
				driver.findElement(By.name(props1.getProperty(ElementsConstants.SETPRIMARYADDRESS_ELEMENT))).click();
				driver.findElement(By.className(props1.getProperty(ElementsConstants.BUTTON_ELEMENT))).click();
				Thread.sleep(1000);
				driver.findElement(By.className(props1.getProperty(ElementsConstants.BUTTON_ELEMENT))).click();
				WebElement addressadded = driver.findElement(By.className(props1.getProperty(ElementsConstants.ALERTSUCCESS_ELEMENT)));
				if (addressadded.isDisplayed()) {
					assertEquals(addressadded.getText(), props.getProperty(DataConstants.ADDRESSSAVEDMSG_DATA));
					System.out.println(props.getProperty(DataConstants.ADDRESSSAVEDMSG_DATA));
				}
			}
		} catch (Exception exp) {
			System.out.println(props.getProperty(DataConstants.SHIPPINGMSG_DATA));
		}

	}
}
