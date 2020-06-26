package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.ReadPropertiesFile;

/**
 * @author Piyush
 *
 */
public class CommonUtilities 
{
	public static WebDriver driver;
	public Logger log = Logger.getLogger(CommonUtilities.class);
	public Actions actions;
	public static WebDriverEventListenerClass webDriverListener;
	public static EventFiringWebDriver eventFiringDriver;
	
	
	/**
	 * invokeBrowser() method is used to invoke the specific browser, 
	 * based on the browser value received from the Properties file.
	 */
	public void invokeBrowser() 
	{			
		String browserName = ReadPropertiesFile.getPropertyValue("browser");
		
		if(browserName.contains("chrome"))
		{
			log.info("Start: Trying to invoke Chrome Browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false); //To disable the Chrome Automation Extension
			options.addArguments("--disable-extensions"); //To disable the general Chrome Extensions			
			driver = new ChromeDriver(options);
			
			log.info("Finish: Successfully invoked Chrome Browser");
		}
		
		else if(browserName.contains("firefox"))
		{
			log.info("Start: Trying to invoke Firefox Browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Finish: Successfully invoked Firefox Browser");
		}
		
		else if(browserName.contains("internet"))
		{
			log.info("Start: Trying to invoke IE Browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("Finish: Successfully invoked IE Browser");
		}
		
		try
		{
			log.info("Start: Trying to maximize browser");
			driver.manage().window().maximize();
			log.info("End: Successfully maximized browser window");
		}
		catch(Exception e)
		{
			log.info("End: Browser was already maximized");
			//Browser is already maximized
		}
		
		/*
		 * Below code is used to implement WebDriverEventListener,
		 * so that we could perform pre and post conditions before any desired webdriver activity.
		 * WebDriverEventListener is used used for logging all the webdriver activities.
		 */
//		webDriverListener = new WebDriverEventListenerClass();
//		eventFiringDriver = new EventFiringWebDriver(driver);
//		eventFiringDriver.register(webDriverListener);
//		driver = eventFiringDriver;
		
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url = ReadPropertiesFile.getPropertyValue("url");
		log.info("Start: Trying to navigate to URL- "+url);
		driver.get(url);
		log.info("End: Successfully navigated to URL- "+url);
//		return driver;
	}

//	public WebDriver getDriver() {
//		return driver;
//	}

	/**
	 * getMethod() is used to navigate to the URL.
	 */
	public void getMethod(String url)
	{
		log.info("Start: Trying to navigate to URL- "+url);
		driver.get(url);
		log.info("End: Successfully navigated to URL- "+url);
	}
	
	/**
	 * findElementMethod() is used to identify the webelement based on the received locator value.
	 * @param locatorValue
	 * @return WebElement
	 */
	public WebElement findElementMethod(By locatorValue)
	{
		log.info("	Start: Trying to locate element- "+locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorValue));
		WebElement element = driver.findElement(locatorValue);
		log.info("	End: Successfully located element- "+locatorValue);
		return element;
	}
	
	/**
	 * findElementsMethod() is used to identify the webelements based on the received locator value.
	 * @param locatorValue
	 * @return List<WebElement>
	 */
	public List<WebElement> findElementsMethod(By locatorValue)
	{
		log.info("	Start: Trying to locate elements- "+locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorValue));
		List<WebElement> elements = driver.findElements(locatorValue);
		log.info("	End: Successfully located elements- "+locatorValue);
		return elements;
	}
	
	/**
	 * sendKeysMethod() is used to enter the received text in the received target webelement.
	 * @param locatorValue
	 * @param data
	 */
	public void sendKeysMethod(By locatorValue, String data)
	{
		log.info("Start: Trying to insert data- "+data +" in field - "+locatorValue);
//		findElementMethod(locatorValue).clear();
		findElementMethod(locatorValue).sendKeys(data);
		log.info("End: Successfully inserted data- "+data +" in field - "+locatorValue);
	}
	
	/**
	 * clickMethod() is used to click on the received target webelement.
	 * @param locatorValue
	 */
	public void clickMethod(By locatorValue)
	{
		log.info("Start: Trying to click element- "+locatorValue);
		findElementMethod(locatorValue).click();
		log.info("End: Successfully clicked on element- "+locatorValue);
	}

	/**
	 * selectMethod() is used to select the received target webelement.
	 * @param locatorValue
	 */
	public void selectMethod(By locatorValue, String text)
	{
		Select select = new Select(findElementMethod(locatorValue));
		select.selectByVisibleText(text);
				
	}
	
	
	/**
	 * createActionsClassObject() is used to create and return an object of the Actions Class.
	 * @return Actions
	 */
	public Actions createActionsClassObject()
	{
		return actions = new Actions(driver);
	}
	
	/**
	 * moveToElementMethod() is used to move to the received target webelement.
	 * @param locatorValue
	 */
	public void moveToElementMethod(By locatorValue)
	{
		log.info("Start: Trying to move to element- "+locatorValue);
		createActionsClassObject().moveToElement(findElementMethod(locatorValue)).click().build().perform();
		log.info("End: Successfully moved to element- "+locatorValue);
	}
	
	/**
	 * moveToElementAndSendKeysMethod() is used to move to the received target webelement
	 * and also enter the received text.
	 * @param locatorValue
	 * @param data
	 */ 
	public void moveToElementAndSendKeysMethod(By locatorValue, String data)
	{
		log.info("Trying to insert data- "+data +" in field - "+locatorValue);
		createActionsClassObject().moveToElement(findElementMethod(locatorValue)).click().sendKeys(data+Keys.ENTER).build().perform();
		log.info("End: Successfully inserted data- "+data +" in field - "+locatorValue);
	}
	
	/**
	 * dragAndDropMethod() is used to move the element from source to destination webelement.
	 * and also enter the received text.
	 * @param source
	 * @param destination
	 */ 
	public void dragAndDropMethod(By source, By destination)
	{
		log.info("Start: Trying to drag from element - " +source +" to element- "+destination);
		createActionsClassObject().dragAndDrop(findElementMethod(source), findElementMethod(destination)).build().perform();
		log.info("End: Successfully moved from element - " +source +" to element- "+destination);
	}
	
	
	/**
	 * verifyTitleMethod() method is use to fetch the title of the current webpage.
	 * @return String
	 */
	public String verifyTitleMethod()
	{
		log.info("Fetching the title of the webpage");
		return driver.getTitle();
	}
	
	/**
	 * verifyURLMethod() method is use to fetch the URL of the current webpage.
	 * @return String
	 */
	public String verifyURLMethod()
	{
		log.info("Fetching the URL of the webpage");
		return driver.getCurrentUrl();
	}
	
	/**
	 * quitBrowserMethod() method is use to close all the browser windows opened by the webdriver.
	 */
	public void quitBrowserMethod()
	{
		log.info("Start: Trying to close browser");
		driver.quit();
		log.info("End: Successfully closed browser");
	}
}
