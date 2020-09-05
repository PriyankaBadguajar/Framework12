package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.AddCustomerPage;
import com.Pages.LoginPage;
import com.Pages.SearchCustomerPage;
import com.utility.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass{
	@Test
	public void searchCustomerbyName() throws InterruptedException, IOException
	{
		logger.info("********* starting TC_SearchCustomerByName_005 *************");
		
		driver.get(configPropobj.getProperty("url"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropobj.getProperty("userMail"));
		lp.setPassword(configPropobj.getProperty("password"));
		lp.clickLogin();
		
		//Go to search page
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		//Name
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.setFirstName("Victoria");
		searchcust.setLastName("Terces");
		searchcust.clickSearch();
		Thread.sleep(3000);
		
		boolean status=searchcust.searchCustomerByName("Victoria Terces");
		if(status==true)
		{
			logger.info("********* Search customer by name is passed *************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("********* Search customer by name is failed*************");
			captureScreen(driver,"searchCustomerbyName");
			Assert.assertTrue(false);
		}
		logger.info("********* End of TC_SearchCustomerByName_005 *************");
	}
	


}
