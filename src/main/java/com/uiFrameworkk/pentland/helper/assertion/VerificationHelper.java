package com.uiFrameworkk.pentland.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class VerificationHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Verification Helper has been initilaized");
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is Displayed" + element.getText());
			TestBase.logExtentReport("element is Displayed" + element.getText());
			return true;
		}catch(Exception e) {
			log.error("element is not  Displayed" , e.getCause());
			TestBase.logExtentReport("element is not  Displayed"  + e.getMessage());
			return false ;
		}
	}
	
	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is Present.." + element.getText());
			TestBase.logExtentReport("element is Present" + element.getText());
			return false;
		}catch(Exception e) {
			log.error("element is not  Present");
			return true ;
		}
	}
	
	public String readValueFromElement(WebElement element) {
		if(null==element) {
			log.info("WebElement is NULL");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status) {
			log.info("Element text is .." + element.getText());
			return element.getText();
		}else {
			return null;
		}
	}
	public String getText(WebElement element) {
		if(null==element) {
			log.info("WebElement is NULL");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status) {
			log.info("Element text is .." + element.getText());
			return element.getText();
		}else {
			return null;
		}
	}
	
	public String getTitle() {
		log.info("Page Title is.." + driver.getTitle());
		return driver.getTitle();
	}
	
	
}
