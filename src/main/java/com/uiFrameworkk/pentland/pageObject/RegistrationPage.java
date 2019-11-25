package com.uiFrameworkk.pentland.pageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class RegistrationPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(RegistrationPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='id_gender1']")
	public WebElement mrRadioButton;

	@FindBy(xpath = "//*[@id='id_gender2']")
	public WebElement mrsRadioButton;

	@FindBy(xpath = "//*[@id='customer_firstname']")
	public WebElement firstName;

	@FindBy(xpath = "//*[@id='customer_lastname']")
	public WebElement lastName;

	@FindBy(xpath = "//*[@id='email']")
	public WebElement emailAddress;

	@FindBy(xpath = "//*[@id='passwd']")
	public WebElement password;

	@FindBy(xpath = "//*[@id='days']")
	public WebElement day;

	@FindBy(xpath = "//*[@id='months']")
	public WebElement month;

	@FindBy(xpath = "//*[@id='years']")
	public WebElement year;

	@FindBy(xpath = "//*[@id='firstname']")
	public WebElement yourAddressFirstName;

	@FindBy(xpath = "//*[@id='lastname']")
	public WebElement yourAddressLastName;

	@FindBy(xpath = "//*[@id='company']")
	public WebElement yourAddressCompany;

	@FindBy(xpath = "//*[@id='address1']")
	public WebElement address;

	@FindBy(xpath = "//*[@id='address2']")
	public WebElement address2;

	@FindBy(xpath = "//*[@id='city']")
	public WebElement yourAddressCity;

	@FindBy(xpath = "//*[@id='id_state']")
	public WebElement yourAddressState;

	@FindBy(xpath = "//*[@id='postcode']")
	public WebElement yourAddressPostCode;

	@FindBy(xpath = "//*[@id='id_country']")
	public WebElement additionalInformation;

	@FindBy(xpath = "//*[@id='phone']")
	public WebElement homePhone;

	@FindBy(xpath = "//*[@id='phone_mobile']")
	public WebElement mobilephone;

	@FindBy(xpath = "//*[@id='alias']")
	public WebElement addressAlias;

	@FindBy(xpath = "//*[@id='submitAccount']")
	public WebElement registration;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(mrRadioButton, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("RegistrationPage object Created...");

	}

	public void setMrRadioButton() {
		log.info("selecting mr checkbox...");
		TestBase.logExtentReport("selecting mr checkbox...");
		this.mrRadioButton.click();
	}

	public void setMrsRadioButton() {
		log.info("selecting mrs checkbox...");
		TestBase.logExtentReport("selecting mrs checkbox...");
		this.mrsRadioButton.click();
	}

	public void setFirstName(String firstName) {
		log.info("Entering first Name..." + firstName);
		TestBase.logExtentReport("Entering first Name..." + firstName);
		this.firstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		log.info("Entering last Name..." + lastName);
		TestBase.logExtentReport("Entering last Name..." + lastName);
		this.lastName.sendKeys(lastName);
	}

	public void setEmailAddress(String emailAddress) {
		log.info("Entering email Address..." + emailAddress);
		TestBase.logExtentReport("Entering email Address..." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}

	public void setPassword(String password) {
		log.info("Entering password..." + password);
		TestBase.logExtentReport("Entering password..." + password);
		this.password.sendKeys(password);
	}

	public void setDay(String day) {
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='days']/option"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(day)) {
				System.out.println(day);
				c.click();
				break;
			}
		}
	}

	public void setMonth(String month) {
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='months']/option"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(month)) {
				System.out.println(month);
				c.click();
				break;
			}
		}
	}

	public void setYear(String year) {
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='years']/option"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(year)) {
				System.out.println(year);
				c.click();
				break;
			}
		}
	}

	public void setYourAddressFirstName(String yourAddressFirstName) {
		log.info("Entering your Address FirstName..." + yourAddressFirstName);
		this.yourAddressFirstName.sendKeys(yourAddressFirstName);
	}

	public void setYourAddressLastName(String yourAddressLastName) {
		log.info("Entering your Address LastName..." + yourAddressLastName);
		this.yourAddressLastName.sendKeys(yourAddressLastName);
	}

	public void setYourAddressCompany(String yourAddressCompany) {
		log.info("Entering your Address Company ..." + yourAddressCompany);
		this.yourAddressCompany.sendKeys(yourAddressCompany);
	}

	public void setAddress(String address) {
		log.info("Entering your Address  ..." + address);
		this.address.sendKeys(address);
	}

	public void setAddress2(String address2) {
		log.info("Entering your Address  ..." + address2);
		this.address2.sendKeys(address2);
	}

	public void setYourAddressCity(String yourAddressCity) {
		log.info("Entering your City2  ..." + yourAddressCity);
		this.yourAddressCity.sendKeys(yourAddressCity);
	}

	public void setYourAddressState(String yourAddressState) {
		log.info("Entering your Addres state  ..." + yourAddressState);
		new Select(this.yourAddressState).selectByVisibleText(yourAddressState);
	}

	public void setYourAddressPostCode(String yourAddressPostCode) {
		log.info("Entering your Addres state  ..." + yourAddressPostCode);
		this.yourAddressPostCode.sendKeys(yourAddressPostCode);
	}

	public void setAdditionalInformation(String additionalInformation) {
		log.info("Entering your additional Information..." + additionalInformation);
		this.additionalInformation.sendKeys(additionalInformation);
	}

	public void setPhoneHome(String homePhone) {
		log.info("Entering home phone..." + homePhone);
		this.homePhone.sendKeys(homePhone);
	}

	public void setMobilePhone(String mobilephone) {
		log.info("Entering mobile phone..." + mobilephone);
		this.mobilephone.sendKeys(mobilephone);
	}

	public void setAddressAlias(String addressAlias) {
		log.info("Entering addressAlias..." + addressAlias);
		this.addressAlias.sendKeys(addressAlias);
	}

	public void clickRegistration() {
		log.info("Click on Registration..." + registration);
		this.registration.click();
	}

}
