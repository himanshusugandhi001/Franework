package com.uiFrameworkk.pentland.testScripts.productDetailsPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiFrameworkk.pentland.helper.assertion.AssertionHelper;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.pageObject.NavigationMenu;
import com.uiFrameworkk.pentland.pageObject.ProductCategoryPage;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class VerifyLowestFirstPriceFilter extends TestBase {
	private final Logger log = LoggerHelper.getLogger(VerifyLowestFirstPriceFilter.class);
	
	@Test
	public void verifyLowestFirstPriceListInProduct_detailsPage() throws InterruptedException {
		getApplicationUrl(ObjectReader.reader.getUrl());
		NavigationMenu navigationMenu = new NavigationMenu(driver);
		
		ProductCategoryPage pcategoryPage = navigationMenu.clickOnMenu(navigationMenu.womenMenu);
//		Select price filter 
		pcategoryPage.selectSortByFilter("Price: Lowest first");
		
//		Wait for some time so price get selected
		Thread.sleep(8000);
		 
		List<WebElement> price = pcategoryPage.getAllProductPrice();
		ArrayList<Integer> array = new ArrayList<Integer>();
		Iterator<WebElement> itr = price.iterator();
		
		ArrayList<Integer> data = pcategoryPage.getPriceMassagedData(itr);
		boolean status = pcategoryPage.verifyArrayHasAscendingData(data);
		AssertionHelper.updateTestStatus(status);
		
		
////		Price comes in "$16.40" format
////		remove $ from begining and change to int for sorting order verification
////		Store it in array List
//		while(itr.hasNext()) {
//			String p = itr.next().getText();
//			if(p.contains("$")) {
//				String actualData = p.substring(1);
//				log.info(actualData);
//				double p1 = Double.parseDouble(actualData);
//				int productPrice = (int) (p1);
//				array.add(productPrice);
//			}
//		}
//		
//		 
//		log.info(array);
////		16,16,26,26,27,28,30,50
//		for(int i = 0; i<array.size()-1;i++) {
////			This condition will check all the next price should be smaller than previous price 
////			next price can be grated and equal 
//			if(array.get(i)<=array.get(i)+1) {
//				log.info("Obh.get(i):- " + array.get(i));
//				log.info("Obh.get(i+1):- " + array.get(i+1));
//			}else {
//				Assert.assertTrue(false, "Price FIlter is not working");
//			}
//		}
		
	}
}
