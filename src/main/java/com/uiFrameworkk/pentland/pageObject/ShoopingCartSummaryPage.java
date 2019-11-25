package com.uiFrameworkk.pentland.pageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFrameworkk.pentland.helper.assertion.VerificationHelper;
import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class ShoopingCartSummaryPage {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(ShoopingCartSummaryPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='columns']/div[1]/span[2]")
	public WebElement yourShoppingCart;

	@FindBy(xpath = "//a[@title='Delete']")
	List<WebElement> quantity_delete;

	@FindBy(xpath = "//*[contains(text(),'Your shopping cart is empty']")
	public WebElement emptyShoppingCartMessage;

	public ShoopingCartSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(yourShoppingCart, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("ShoopingCartSummaryPage object Created...");
	}

	public boolean verifyProduct(String prod) {
		log.info("Select Product..." + prod);
		WebElement product = driver.findElement(By.xpath("//*[contains(text(),'" + prod + "']"));
		return new VerificationHelper(driver).isDisplayed(product);
	}

	public void deleteProductFromShoppingCart() throws InterruptedException {
		log.info("Deleting all the Product from shopping cart...");
		List<WebElement> deletes = quantity_delete;
		Iterator<WebElement> itr = deletes.iterator();
		while (itr.hasNext()) {
			itr.next().click();
			Thread.sleep(3000);
		}

	}

	public boolean verifyShoppingCartMessage() {
		return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMessage);
	}

}
