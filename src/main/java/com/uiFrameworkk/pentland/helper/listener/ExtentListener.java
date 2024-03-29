package com.uiFrameworkk.pentland.helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.utils.ExtentManager;

public class ExtentListener implements ITestListener {
	private Logger log = LoggerHelper.getLogger(ExtentListener.class);
	public static ExtentReports extent;
	public static ExtentTest test;

	public void onTestStart(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName() + "Started...");
		Reporter.log(arg0.getMethod().getMethodName() + " Test Started..");
		log.info(arg0.getMethod().getMethodName() + " Test Started..");
	}

	public void onTestSuccess(ITestResult arg0) {
		// test.log(Status.INFO, arg0.getName() + "Passed...");
		Reporter.log(arg0.getMethod().getMethodName() + " Test Passed..");
		log.info(arg0.getMethod().getMethodName() + " Test Passed..");

	}

	public void onTestFailure(ITestResult arg0) {
		// test.log(Status.FAIL, arg0.getThrowable());
		Reporter.log(arg0.getMethod().getMethodName() + " Test Failed.." + arg0.getThrowable());
		log.error(arg0.getMethod().getMethodName() + " Test Failed.." + arg0.getThrowable());
	}

	public void onTestSkipped(ITestResult arg0) {
		// test.log(Status.SKIP, arg0.getThrowable());
		Reporter.log(arg0.getMethod().getMethodName() + " Test Skipped.." + arg0.getThrowable());
		log.warn(arg0.getMethod().getMethodName() + " Test Skipped.." + arg0.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// extent = ExtentManager.getInstance();
		// test = extent.createTest(arg0.getName());
		// test = extent.createTest(arg0.getCurrentXmlTest().getName());
		Reporter.log(arg0.getCurrentXmlTest().getName() + " Test Started..");
		log.info(arg0.getCurrentXmlTest().getName() + " Test Started..");
	}

	public void onFinish(ITestContext arg0) {
//		extent.flush();
		Reporter.log(arg0.getName() + " Test Finshed..");
		log.info(arg0.getName() + " Test Finshed..");
	}

}
