package com.uiFrameworkk.pentland.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFrameworkk.pentland.helper.assertion.VerificationHelper;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class MyAccount {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(MyAccount.class);
	WaitHelper waitHelper;

	@FindBy(xpath="//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")	
	public WebElement yourAccountPageMessage;
	
	@FindBy(xpath="//*[contains(text(),'Order history and details')]")
	public WebElement OrderHistoryAndDetails;
	
	@FindBy(xpath="//*[contains(text(),'My Personal Information')]")
	public WebElement MyPersonalInformation;
	
	
	@FindBy(xpath="//*[@id='center_column']/div/div[2]/ul/li/a/span")
	public WebElement wishLists;
	
	@FindBy(xpath="//*[@id='center_column']/h1")
	public WebElement myAccount;
	
	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(OrderHistoryAndDetails, ObjectReader.reader.getExplicitWait());
		TestBase.test.log(Status.INFO,"MyAccountPage Object is created..");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void clickOnWishLists() {
		wishLists.click();
		log.info("Clicked on..." + wishLists.getText());
		TestBase.test.log(Status.INFO, "Clicked on..." + wishLists.getText());
	}
	
	public void clickOnOrderHistoryAndDetails() {
		OrderHistoryAndDetails.click();
		log.info("Clicked on..." + OrderHistoryAndDetails.getText());
		TestBase.test.log(Status.INFO, "Clicked on..." + OrderHistoryAndDetails.getText());
	}
	
	public boolean isYourAccountPageMessage() {
		return new VerificationHelper(driver).isDisplayed(yourAccountPageMessage);
	}
	
}
