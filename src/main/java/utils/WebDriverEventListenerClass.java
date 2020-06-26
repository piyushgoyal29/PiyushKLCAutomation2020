package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverEventListenerClass extends CommonUtilities implements WebDriverEventListener
{	
	public void afterAlertAccept(WebDriver driver) {
		log.info("Alert Accepted");
	}

	public void afterAlertDismiss(WebDriver driver) {
		log.info("Alert Dismissed");		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("The value of element "+element+" changed to : "+keysToSend[0]);		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("Successfully clicked on WebElement : "+element.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Successfully located WebElement : "+element.toString());		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub	
	}

	public void afterGetText(WebElement element, WebDriver driver, String arg2) {
		log.info("Successfully retrieved text from WebElement : "+element.toString());	
	}

	public void afterNavigateBack(WebDriver driver) {
		log.info("Navigating back to URL : "+driver.getCurrentUrl());	
	}

	public void afterNavigateForward(WebDriver driver) {
		 log.info("Navigating forward to URL : "+driver.getCurrentUrl());
	}

	public void afterNavigateRefresh(WebDriver driver) {
		 log.info("URL after refreshing the web page: "+driver.getCurrentUrl());
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		 log.info("Navigating to URL : "+url);
	}

	public void afterScript(String arg0, WebDriver driver) {
		log.info("Executed javascript : "+arg0);
	}

	public void afterSwitchToWindow(String arg0, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeAlertAccept(WebDriver driver) {
		log.info("Before accepting alert");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		log.info("Before dismissing alert");		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//		log.info("The value in element "+element+" before change is : "+keysToSend[0]);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
//		log.info("Trying to click on: " + element.toString());
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//		log.info("Trying to find Element By : " + element.toString());
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
//		log.info("Before retrieving text of WebElement : "+element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		log.info("URL before navigating back : "+driver.getCurrentUrl());
	}

	public void beforeNavigateForward(WebDriver driver) {
		log.info("URL before navigating forward : "+driver.getCurrentUrl());
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		 log.info("URL before refreshing the web page : "+driver.getCurrentUrl());
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Before navigating to : " + url);
	}

	public void beforeScript(String arg0, WebDriver driver) {
		log.info("Before Executing javascript : " +arg0);
	}

	public void beforeSwitchToWindow(String arg0, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver driver) {
		log.info("Exception occurred :");
		log.info("Throwable : " +error.toString());
		//log.info("Exception thrown : "+arg0.getMessage());
		log.info("WebDriver : " +driver.toString());
	}
}