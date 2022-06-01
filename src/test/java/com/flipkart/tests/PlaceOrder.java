package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.SearchPage;
import com.flipkart.pages.SelectProduct;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PlaceOrder extends TestBase{
	
	
	  @Test
	  public void loginTest() {
		  LoginPage loginPage = new LoginPage();
		  String actResult = loginPage.validateLogin("9767144780", "Flipkart@1811");
		  
		  Assert.assertEquals(actResult, "Prasad");
	  }
	  
	  @Test (dependsOnMethods = {"loginTest"})
	  public void searchProduct() {
		  
		  SearchPage searchpage = new SearchPage();
		  boolean act = searchpage.validateSearchProduct("Laptop");
		  
		  Assert.assertTrue(act);
		  
		  
	  }
	  @Test(dependsOnMethods = {"searchProduct"})
	  public void selectProduct() {
		  SelectProduct selectproduct = new SelectProduct();
		  boolean result = selectproduct.selectingProduct();
          Assert.assertTrue(result);
	  }
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void setUp() {
		 
		  launchBrowser();
		  navigateToURL();
		 
	  }

	  @AfterClass
	  public void afterClass() {
	  }

	}
