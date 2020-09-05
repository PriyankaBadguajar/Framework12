package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.AddCustomerPage;
import com.Pages.LoginPage;
import com.Pages.SearchCustomerPage;
import com.utility.BaseClass;

public class TC_SearchCustomerByEmail_004 extends BaseClass{
	@Test
	public void searchCustomerbyEmail() throws InterruptedException, IOException
	{
		logger.info("********* starting TC_SearchCustomerByEmail_004 *************");
		
		driver.get(configPropobj.getProperty("url"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropobj.getProperty("userMail"));
		lp.setPassword(configPropobj.getProperty("password"));
		lp.clickLogin();
		
		//Go to search page
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		//Email ID
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
		searchcust.clickSearch();
		Thread.sleep(3000);
		
		boolean status=searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		if(status==true)
		{
			logger.info("********* Search customer by email is passed *************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("********* Search customer by email is failed*************");
			captureScreen(driver,"searchCustomerbyEmail");
			Assert.assertTrue(false);
		}
		logger.info("********* End of TC_SearchCustomerByEmail_004 *************");
	}
	


}
