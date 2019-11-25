package com.uiFrameworkk.pentland.pageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.uiFrameworkk.pentland.helper.browserConfigration.config.ObjectReader;
import com.uiFrameworkk.pentland.helper.javaScripts.JavaScriptHelper;
import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;
import com.uiFrameworkk.pentland.helper.select.DropDownHelper;
import com.uiFrameworkk.pentland.helper.wait.WaitHelper;
import com.uiFrameworkk.pentland.testbase.TestBase;

public class ProductCategoryPage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	WaitHelper waitHelper;
	
	
	@FindBy(xpath="//*[@id='layered_block_left']/p")
	public WebElement catalogTextObj;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2")
	public WebElement productAddedSuccessfully;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	public WebElement addToCart;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	public WebElement proceedToCheckout;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li")
	List <WebElement> totalProducts;
	
	@FindBy(xpath="//*[@id='selectProductSort']")
	public WebElement sortBy;
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[2]/div/span[1]")
	List <WebElement> allpriceElements;


	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(catalogTextObj, ObjectReader.reader.getExplicitWait());	
		TestBase.logExtentReport("ProductCategoryPage object Created...");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void mouseOverOnProduct(int number) {
		String fpart = "//*[@id='center_column']/ul/li[";
		String spart = "]div/div[2]/h5/a";
		Actions action = new Actions(driver);
		log.info("doing mouse hover on.." + number + "..Product");
		action.moveToElement(driver.findElement(By.xpath(fpart+number+spart))).build().perform();
	}
	
	public void clickOnAddToCart() {
		log.info("Click on Add To Cart");
		addToCart.click();
	}
	
	public void clickOnProceedTocheckOut() {
		log.info("Clicking on :" + proceedToCheckout.getText());
	}
	
	public void selectColor(String data) {
		new JavaScriptHelper(driver).scrollIntoView(driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")));
		driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")).click();
		try {
			Thread.sleep(7000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectSmallSize() {
		log.info("Selecting Small Size...");
		driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
	}
	
	public void selectMediumSize() {
		log.info("Selecting Medium Size...");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']")).isSelected();
			if(!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2']")).click();
				log.info("CheckBox is Checked");
			}
		}catch(Exception e) {
			log.info("CheckBOx is already checked...");
		}
		
	}
	
	public void selectLSize() {
		log.info("Selecting Large Size...");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).isSelected();
			if(!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3']")).click();
				log.info("CheckBox is Checked");
			}
		}catch(Exception e) {
			log.info("CheckBOx is already checked...");
		}
		
	}
	
	public void selectFirstProduct() {
		Actions obj = new Actions(driver);
		log.info("Performing the mouse hover on the first product..");
		TestBase.logExtentReport("Performing the mouse hover on the first product..");
		obj.moveToElement(totalProducts.get(0)).build().perform();
		log.info("Clicking on add to basket...");
		TestBase.logExtentReport("Clicking on add to basket...");
		addToCart.click();
	}
	
	public int getTotalProducts() {
		return totalProducts.size();
	}
	
	public List<WebElement> getAllProductPrice(){
		return allpriceElements;
	}
	
	public void selectSortByFilter(String dataToSelect) {
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.selectUsingVisibleText(sortBy, dataToSelect);
	}
	
	public boolean verifyArrayHasAscendingData(ArrayList<Integer> array) {
		for(int i=0 ; i< array.size()-1;i++) {
//			this condition will check all next price should be smaller than previous one.
//			next price can be greater and equal
			if(array.get(i)<=array.get(i)+1) {
				log.info("Obh.get(i):- " + array.get(i));
				log.info("Obh.get(i+1):- " + array.get(i+1));
			}else {
				log.info("Price filter is not working");
				return false;
			}
			}
		return true;
		}
	
	public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr){
		ArrayList<Integer> array = new ArrayList<Integer>();
		while(itr.hasNext()) {
			String p = itr.next().getText();
			if(p.contains("$")) {
				String actualData = p.substring(1);
				log.info(actualData);
				double p1 = Double.parseDouble(actualData);
				int productPrice = (int) (p1);
				array.add(productPrice);
			}
			
		}
		return array;
	}
	
	
	}
	
	

