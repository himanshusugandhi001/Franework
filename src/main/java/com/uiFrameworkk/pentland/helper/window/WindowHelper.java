package com.uiFrameworkk.pentland.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;

public class WindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);
 
	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}
//	This method will switch to parent window
	public void switchToParentWindow() {
		log.info("Switching to Parent Window...");
		driver.switchTo().defaultContent();
	}
//	This method will switch to child window based on index
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i=1;
		for(String window : windows) {
			if(i==index) {
				log.info("Switching to : " + index + "Window");
				driver.switchTo().window(window);
			}else {
				i++;
			}
		}
	}
//	This method will closed all the tabed window and
//	switched to main window
	public void closeALlTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();
		for(String window : windows) {
			if(!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}
		}
		log.info("Switching to mainwindow : ");
		driver.switchTo().window(mainwindow);
	}
//	This method will do browser back navigation
	public void navigateBack() {
		log.info("Navigating Back");
		driver.navigate().back();
	}
//	This method will do browser forward navigation
	public void navigateForward() {
		log.info("Navigating forward");
		driver.navigate().forward();
	}
	
	
}
