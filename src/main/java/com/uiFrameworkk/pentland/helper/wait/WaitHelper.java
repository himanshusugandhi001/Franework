package com.uiFrameworkk.pentland.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;

public class WaitHelper {
//	whenever i called from any of the class i have to inilize the driver from that class
//	But How we initilize
//	Through constructor we have to initlize that
//	so we have to create a constructor
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.info("WaitHelper Object Created..");
	}
//	This is ImplicitWait method 
	
	public void setImplicitWait(long timeout , TimeUnit unit) {
		log.info("Implicit Wait has been set to :" + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
//	This will help us to get webdriver wait object 
	private WebDriverWait getWait(int timeOutInSeconds , int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
		
	}
//	This method will make sure element is visible 
	
	public void WaitForElementVisibleWithPollingTime(WebElement element , int timeOutInSeconds,int pollingEveryInMiliSec  ) {
		log.info("Waiting for :" + element.toString() + "for : " + timeOutInSeconds + "Seconds");
		WebDriverWait wait = getWait(timeOutInSeconds ,pollingEveryInMiliSec );
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is Visble Now "); 
	}
//	This method will make sure element is clickable 
	public void WaitForElementClickable(WebElement element , int timeOutInSeconds ) {
		log.info("Waiting for :" + element.toString() + "for : " + timeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is Clcickable Now "); 
	}
//	This method will make sure invisibility Of web element
	public Boolean waitForElementNotPresent(WebElement element ,long timeOutInSeconds) {
		log.info("Waiting for :" + element.toString() + "for : " + timeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		Boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is invisible now ");
		return status;
	}
//	This method will wait for frameToBeAvailableAndSwitchToIt 
	public void waitForFrameToBeAvailableAndSwitchToIt( WebElement element , long timeOutInSeconds ) {
		log.info("Waiting for :" + element.toString() + "for : " + timeOutInSeconds + "Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available and switched");
		
	}
//	this method will give us fluent wait object
	private Wait<WebDriver> getFluentWait(int timeOutInSeconds , int pollingEveryInMiliSec) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).
				withTimeout(Duration.ofSeconds(timeOutInSeconds)).
				pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fwait;
	}
	
	public WebElement waitForElement(WebElement element ,int timeOutInSeconds , int pollingEveryInMiliSec ) {
		Wait<WebDriver> fwait = getFluentWait( timeOutInSeconds , pollingEveryInMiliSec);
		 fwait.until(ExpectedConditions.visibilityOf(element));
		return element ;
	}
	
	public void pageLoadTime(long timeout , TimeUnit unit) {
		log.info("Waiting for page to load for :" + unit + "Seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout,unit );
		log.info(" page is loaded ");
	}
	
	public void waitForElement(WebElement element ,int timeOutInSeconds ) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " Seconds" );
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		 wait.until(ExpectedConditions.visibilityOf(element));
		 log.info("Element is visible now " );
	}
	
	
	
	
	
	
}