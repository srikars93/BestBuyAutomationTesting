package com.bestbuy.automation.testing.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.bestbuy.automation.testing.constants.DataConstants;
import com.bestbuy.automation.testing.pages.HomePage;
import com.bestbuy.automation.testing.pages.SignOnPage;
import com.bestbuy.automation.testing.singleton.PropertyLoader;

public class SignOnPage_Test {
  @Test
  public void test_signInPage(){
		String title = HomePage.loadHomePage();
		assertEquals(title, PropertyLoader.getDataProps().getProperty(DataConstants.HOME_PAGE_TITLE));
		HomePage.closePopUp();
		title = SignOnPage.loadSignInPage();
		assertEquals(title, PropertyLoader.getDataProps().getProperty(DataConstants.SIGN_IN_TITLE));
		SignOnPage.signIn();
	}
  
}
