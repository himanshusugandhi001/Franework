package com.uiFrameworkk;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFrameworkk.pentland.testbase.TestBase;

public class C extends TestBase {
	int i = 1;
	
	@Test
	public void testLoginC() {
		
			System.out.println(i);
			i++;
			Assert.assertTrue(false);
			
	}
	}

