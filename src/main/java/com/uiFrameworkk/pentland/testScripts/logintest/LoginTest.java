package com.uiFrameworkk.pentland.testScripts.logintest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFrameworkk.pentland.helper.assertion.AssertionHelper;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.pageObject.LoginPage;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class LoginTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="Login Test with Valid Credentials")
	public void testLoginToApplication() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		boolean status = loginPage.verifySuccessLoginMsg();
		AssertionHelper.updateTestStatus(status);
	}
}
