package com.bestbuy.automation.testing.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.bestbuy.automation.testing.constants.DataConstants;
import com.bestbuy.automation.testing.pages.AccountDetails;
import com.bestbuy.automation.testing.pages.CreditCard;
import com.bestbuy.automation.testing.pages.HomePage;
import com.bestbuy.automation.testing.pages.ShippingAddress;
import com.bestbuy.automation.testing.pages.SignOnPage;
import com.bestbuy.automation.testing.singleton.BestBuyDriver;
import com.bestbuy.automation.testing.singleton.PropertyLoader;

public class SignOnPage_Test {
	@Test
	public void test_signInPage() throws Exception {
		WebDriver driver = BestBuyDriver.getDriver();
		String title = HomePage.loadHomePage();
		assertEquals(title, PropertyLoader.getDataProps().getProperty(DataConstants.HOMEPAGETITLE_DATA));
		HomePage.closePopUp();
		title = SignOnPage.loadSignInPage();
		assertEquals(title, PropertyLoader.getDataProps().getProperty(DataConstants.SIGNINPAGETITLE_DATA));
		SignOnPage.signIn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String srikar = SignOnPage.AccountVerify();
		assertEquals(srikar, PropertyLoader.getDataProps().getProperty(DataConstants.HISRIKAR_DATA));
		AccountDetails.AccountHome();
		String srikar1 = AccountDetails.VerifyAccountHome();
		assertEquals(srikar1, PropertyLoader.getDataProps().getProperty(DataConstants.WELCOMENAME_DATA));
		AccountDetails.VerifyMemberShipID();
		String memberid = AccountDetails.VerifyMemberShipID();
		assertEquals(memberid, PropertyLoader.getDataProps().getProperty(DataConstants.MEMBERID_DATA));
		CreditCard.AddCreditCard();
		Thread.sleep(500);
		ShippingAddress.AddAddress();		
		SignOnPage.signOut();	
		}
		
	}


