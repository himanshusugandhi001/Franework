package com.uiFrameworkk.pentland.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;

public class AssertionHelper {
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2) {
		log.info("Verifying Text " + s1 + " With " + s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue() {
		log.info("Making Script Pass");
		Assert.assertTrue(true);
	}

	public static void makeTrue(String message) {
		log.info("Making Script Pass" + message);
		Assert.assertTrue(true, message);
	}

	public static void makeFalse() {
		log.info("Making Script Fail..");
		Assert.assertTrue(false);
	}

	public static void makeFalse(String message) {
		log.info("Making Script Fail.." + message);
		Assert.assertTrue(false, message);
	}

	public static void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}

	public static void verifyFalse(boolean status) {
		Assert.assertFalse(status);
	}
	public static void verifyNull(String s1) {
		log.info("Verify Object is null..");
		Assert.assertNull(s1);
	}
	public static void verifyNotNull(String s1) {
		log.info("Verify Object is not null..");
		Assert.assertNotNull(s1);
	}
	
	public static void fail() {
		Assert.assertTrue(false);
	}
	
	public static void pass() {
		Assert.assertTrue(true);
	}
	
	public static void updateTestStatus(boolean status) {
		if(status) {
			pass();
		}
		else {
			fail();
		}
	}

}
