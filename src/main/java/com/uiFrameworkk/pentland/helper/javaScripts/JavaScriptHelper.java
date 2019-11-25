package com.uiFrameworkk.pentland.helper.javaScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFrameworkk.pentland.helper.logger.LoggerHelper;

public class JavaScriptHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("Java Script Helper has been initilaized");
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	public void scrollToElement(WebElement element) {
		log.info("Scroll to WebElement...");
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}

	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("Element is Clicked" + element.toString());
	}

	public void scrollIntoView(WebElement element) {
		log.info("Scroll tillWeb Element");
		executeScript("arguments[0].scrollIntoView()", element);
	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("Element is Clicked" + element.toString());
	}

	public void scrollDownVertically() {
		log.info("Scrolling Down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		log.info("Scrolling Up Vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

//	This method will Scroll till given pixel(E.G.1500)
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBY(0," + pixel + ")");
	}

//	This method will Scroll up till given pixel
	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBY(0,-" + pixel + ")");
	}

//	This method will Zoom screen by 100%
	public void zoomInBy100Percent() {
		executeScript("document.body.style.zoom='100%'");
	}

//	This method will Zoom screen by 40%
	public void zoomInBy60Percent() {
		executeScript("document.body.style.zoom='40%'");
	}

//	This method will click on the element
	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();", element);
	}

}
