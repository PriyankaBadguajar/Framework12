package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.utility.BaseClass;



public class TC_LoginPage_001 extends BaseClass {
	@Test
	public void loginTest() throws IOException
	{
		logger.info("***  Starting TC_LoginPage_001  ***");
		driver.get(configPropobj.getProperty("url"));
		LoginPage lp=new LoginPage(driver);
		logger.info("***  Provinding login details  ***");
		lp.setUserName(configPropobj.getProperty("userMail"));
		lp.setPassword(configPropobj.getProperty("password"));
		lp.clickLogin();
		logger.info("***  Validating login  ***");
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			logger.info("***  Login suceessfull  ***");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("***    login is unsucessfull  ***");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);

		}
	}
}
