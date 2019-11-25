package com.uiFrameworkk.pentland.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class NavigationMenu {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tshirtsMenu;

	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(womenMenu, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("Navigation Menu Object created");
		new TestBase().getNavigationScreen(driver);
	}

	public void mouseHover(String data) {
		log.info("Doing mouse hover on " + data);
		TestBase.logExtentReport("Doing mouse hover on ");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"))).build().perform();
	}

	public ProductCategoryPage clickOnItem(String data) {
		log.info("Clickin on :" + data);
		TestBase.logExtentReport("Clickin on :" + data);
		driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]")).click();
		return new ProductCategoryPage(driver);

	}

	public ProductCategoryPage clickOnMenu(WebElement element) {
		log.info("Clickin on :" + element.getText());
		TestBase.logExtentReport("Clickin on :" + element.getText());
		element.click();
		return new ProductCategoryPage(driver);

	}

}
