package com.uiFrameworkk.pentland.testScripts.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFrameworkk.pentland.helper.assertion.AssertionHelper;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.pageObject.LoginPage;
import com.uiFrameworkk.pentland.pageObject.MyAccount;
import com.uiFrameworkk.pentland.pageObject.RegistrationPage;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class RegistrationTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(RegistrationTest.class);
	LoginPage loginpage;
	RegistrationPage register;
	MyAccount myAccountPage;
	
	
	@Test
	public void testLoginToApplication() {
//		Go to Application URL
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		loginpage = new LoginPage(driver);
		loginpage.clickOnSignInLink();
		loginpage.enterRegistrationEmail();
		loginpage.clickOnCreateAnAccount();
		
//		Enter Registration data
		register = new RegistrationPage(driver);
		
		register.setMrRadioButton();
		register.setFirstName("firstName");
		register.setLastName("lastName");
		register.setPassword("password");
		register.setAddress("address");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("yourAddressFirstName");
		register.setYourAddressLastName("yourAddressLastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9988998899");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
		
		
		myAccountPage = new MyAccount(driver);
		boolean status = myAccountPage.isYourAccountPageMessage();
		
		AssertionHelper.updateTestStatus(status);
		
	}

}
