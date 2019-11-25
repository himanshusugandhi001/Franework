package com.uiFrameworkk.pentland.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class HomePage {

	private WebDriver driver;
	WaitHelper waitHelper;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
				
	}

}
