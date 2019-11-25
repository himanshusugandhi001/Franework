package com.uiFrameworkk;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFrameworkk.pentland.testbase.TestBase;

public class B extends TestBase {
	int i = 1;
	
	@Test
	public void testLoginB() {
		if(i==2) {
			Assert.assertTrue(true);
			
		}else {
			System.out.println(i);
			i++;
			Assert.assertTrue(false);
		}
	
	}
}
