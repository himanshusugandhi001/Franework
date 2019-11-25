package com.uiFrameworkk.pentland.testScripts;

import org.testng.annotations.Test;

import com.uiFrameworkk.pentland.testbase.TestBase;

public class TestScreenShot extends TestBase {
	
	@Test
	public void testScreen() {
		driver.get("https://www.seleniumhq.org/download/");
		captureScreen("firstScreen", driver);
		
	}
	

}
