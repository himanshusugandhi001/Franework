package com.uiFrameworkk.pentland.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;


public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver){
		this.driver = driver;
	}
//	This method will switch to frame based on fame Index
	public void switchToFrame(int frameindex) {
		driver.switchTo().frame(frameindex);
		log.info("Switch to : " + frameindex + "Frame");
	}
//	This method will switch to frame based on fame Name
	public void switchToFrame(String frameName ) {
		driver.switchTo().frame(frameName);
		log.info("Switch to : " + frameName + "Frame");
	}
//	This method will switch to frame based on frame webelement
	public void switchToFrame(WebElement element ) {
		driver.switchTo().frame(element);
		log.info("Switch to : " + element.toString());
	}
	

}
