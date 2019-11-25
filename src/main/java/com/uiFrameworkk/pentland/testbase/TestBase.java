package com.uiFrameworkk.pentland.testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFrameworkk.pentland.helper.browserConfigration.BrowserType;
import com.uiFrameworkk.pentland.helper.browserConfigration.ChromeBrowser;
import com.uiFrameworkk.pentland.helper.browserConfigration.FirefoxBrowser;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.PropertyReader;
import com.uiFrameworkk.pentland.helper.excel.ExcelHelper;
import com.uiFrameworkk.pentland.helper.javaScripts.JavaScriptHelper;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.helper.resource.ResourceHelper;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.utils.ExtentManager;

public class TestBase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectery;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.getInstance();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
//		ConfigReader reader = new PropertyReader();
		ObjectReader.reader = new PropertyReader();
		reportDirectery = new File(ResourceHelper.getResourcePath("\\src\\main\\resources\\screenShots"));
		setUpDriver(ObjectReader.reader.getBrowserType());
		test = extent.createTest(getClass().getSimpleName());
	}
	

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + " test Started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is pass");
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		extent.flush();
	}
	
	@AfterTest
		public void afterTest() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch(btype) {
			case Chrome:
//				Get Object of chrome browser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);
     			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);
				
				default :
					throw new Exception("Driver not found " + btype.name());
			}
			
		}catch(Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}
	
	public void setUpDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);
		log.info("Inilialize web Driver: " + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String captureScreen(String fileName, WebDriver driver) {
		if(driver == null) {
			log.info("Driver is Null..");
			return null;
		}
		if(fileName=="") {
			fileName = "blank";
			
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		try {
			destFile = new File(reportDirectery + "/"+ fileName + "_"+ formater.format(calendar.getTime())+ ".png");
			Files.copy(screFile.toPath(), destFile.toPath());
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='" +destFile.getAbsolutePath()+"'heigth='100' width='100'/></a>");
		}catch(Exception e) {
					e.printStackTrace();
		}
		return destFile.toString();
	}
	
	
	public void getNavigationScreen(WebDriver driver) {
		log.info("Capturing the UI Navigation screen...");
		new JavaScriptHelper(driver).zoomInBy60Percent();
		String screen = captureScreen("" , driver);
		new JavaScriptHelper(driver).zoomInBy100Percent();
		try {
			test.addScreenCaptureFromPath(screen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void logExtentReport(String s1) {
		test.log(Status.INFO, s1);
	}
	
	public void getApplicationUrl(String url) {
		driver.get(url);
		logExtentReport("Navigation to ..." + url);
	}
	
	public Object[][] getExcelData(String excelName , String sheetName){
		String excelLocation = ResourceHelper.getResourcePath("\\src\\main\\resources\\configfile\\")+excelName;
		log.info("EXcel Location " + excelName);
		ExcelHelper excelHelper= new ExcelHelper();
		Object[][]data = excelHelper.getExcelData(excelLocation, sheetName);
		return data;
		
	}

}
