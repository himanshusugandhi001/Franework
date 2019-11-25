package com.uiFrameworkk.pentland.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFrameworkk.pentland.helper.assertion.VerificationHelper;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.javaScripts.JavaScriptHelper;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class LoginPage {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitLogin;
	
	@FindBy(xpath="//*[@id='center_column']/p")
	WebElement successMsgObject;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement registrationEmailAddress;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement createAnAccount;
	
	@FindBy(xpath="//*[@id='center_column']/h1")
	WebElement authentication;
	
	@FindBy(xpath="//*[@id='create-account_form']/div/p")
	WebElement createAnAccountMessage;
	
	@FindBy(xpath="//*[@title='Log me out']")
	WebElement	logout;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(signin, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Login Page Object Created");
	}
	
	public void clickOnSignInLink() {
		log.info("Clicked on SIgnIn Link..");
		logExtentReport("Clicked on SIgnIn Link..");
		signin.click();
	}
	
	public void enterEmailAddress(String emailAddress) {
		log.info("entering the email address..." + emailAddress);
		logExtentReport("entering the email address..." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		log.info("entering Password..." + password);
		logExtentReport("entering Password..." + password);
		this.password.sendKeys(password);
	}
	
	public HomePage clickOnSubmitButton() {
		log.info("Click on the submit button...");
		logExtentReport("Click on the submit button...");
		new JavaScriptHelper(driver).scrollDownVertically();
		submitLogin.click();
		return new HomePage(driver);
	}
	
	public boolean verifySuccessLoginMsg() {
		return new VerificationHelper(driver).isDisplayed(successMsgObject);
	}
	
	public void enterRegistrationEmail() {
		String email = System.currentTimeMillis()+ "@gmail.com";
		log.info("Enter the registration email.." + email);
		registrationEmailAddress.sendKeys(email);
	}
	
	public RegistrationPage clickOnCreateAnAccount() {
		createAnAccount.click();
		return new RegistrationPage(driver);
	}
	
	public void loginToApplication(String emailAddress , String password) {
		clickOnSignInLink();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}
	
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}
	
	public void logout() {
		logout.click();
		waitHelper.waitForElement(signin, ObjectReader.reader.getExplicitWait());
	}
	
	
}
