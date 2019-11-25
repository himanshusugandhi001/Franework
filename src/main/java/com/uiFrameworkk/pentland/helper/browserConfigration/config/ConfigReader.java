package com.uiFrameworkk.pentland.helper.browserConfigration.config;

import com.uiFrameworkk.pentland.helper.browserConfigration.BrowserType;

public interface ConfigReader {
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();
	

}
