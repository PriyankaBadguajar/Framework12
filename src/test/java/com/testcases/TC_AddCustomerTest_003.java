package com.testcases;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.AddCustomerPage;
import com.Pages.LoginPage;
import com.utility.BaseClass;


public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		logger.info("********* starting TC_AddCustomerTest_003 *************");
		
		driver.get(configPropobj.getProperty("url"));
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(configPropobj.getProperty("userMail"));
		lp.setPassword(configPropobj.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(3000);
		
		logger.info("*********Adding new customer *************");
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();
		Thread.sleep(2000);

		logger.info("***************  Providing customer details  *********** ");

		String email=randomestring()+"@gmail.com";
		
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFirstName("Priyanka");
		addcust.setLastName("Badgujar");
		addcust.setGender("Male");
		addcust.setDob("10/10/90"); // Format: MM/DD/YYY
		addcust.setCompanyName("busyQA");
		addcust.setCustomerRoles("Vendors");
		Thread.sleep(3000);
		addcust.setManagerOfVendor("Vendor 2");
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();
		Thread.sleep(3000);

		// validation
				if (addcust.verifyConfirmationMsg()) {
					logger.info("***************  Customer added succesfully *********** ");
					Assert.assertTrue(true);

				} else {
					logger.error("*************** Customer Not added succesfully *********** ");
					captureScreen(driver,"addNewCustomer");
					Assert.assertTrue(false);
				}
				logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
	}
	


}
