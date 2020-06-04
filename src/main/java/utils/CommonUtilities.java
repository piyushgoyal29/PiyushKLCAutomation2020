package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class CommonUtilities 
{
	public static WebDriver driver;
	public Logger log = Logger.getLogger(CommonUtilities.class);
	public Actions actions;
	public static WebDriverEventListenerClass webDriverListener;
	public static EventFiringWebDriver eventFiringDriver;
//	public static ExtentTest extentTest;
	
	public void invokeBrowser() 
	{			
		String browserName = ReadPropertiesFile.getPropertyValue("browser");
		
		if(browserName.contains("chrome"))
		{
//			extentTest.log(LogStatus.INFO, "Start: Trying to invoke Chrome Browser");
			log.info("Start: Trying to invoke Chrome Browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Finish: Successfully invoked Chrome Browser");
//			extentTest.log(LogStatus.INFO, "Finish: Successfully invoked Chrome Browser");
		}
		
		else if(browserName.contains("firefox"))
		{
//			extentTest.log(LogStatus.INFO, "Start: Trying to invoke Firefox Browser");
			log.info("Start: Trying to invoke Firefox Browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Finish: Successfully invoked Firefox Browser");
//			extentTest.log(LogStatus.INFO, "Finish: Successfully invoked Firefox Browser");
		}
		
		else if(browserName.contains("internet"))
		{
//			extentTest.log(LogStatus.INFO, "Start: Trying to invoke IE Browser");
			log.info("Start: Trying to invoke IE Browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("Finish: Successfully invoked IE Browser");
//			extentTest.log(LogStatus.INFO, "Finish: Successfully invoked IE Browser");
		}
		
		try
		{
//			extentTest.log(LogStatus.INFO, "Start: Trying to maximize browser");
			log.info("Start: Trying to maximize browser");
			driver.manage().window().maximize();
			log.info("End: Successfully maximized browser window");
//			extentTest.log(LogStatus.INFO, "End: Successfully maximized browser window");
		}
		catch(Exception e)
		{
//			extentTest.log(LogStatus.INFO, "End: Browser was already maximized");
			log.info("End: Browser was already maximized");
			//Browser is already maximized
		}
		
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

	public WebDriver getDriver() {
		return driver;
	}

	
	public WebElement findElementMethod(By locatorValue)
	{
		log.info("	Start: Trying to locate element- "+locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorValue));
		WebElement element = driver.findElement(locatorValue);
		log.info("	End: Successfully located element- "+locatorValue);
		return element;
	}
	
	public List<WebElement> findElementsMethod(By locatorValue)
	{
		log.info("	Start: Trying to locate elements- "+locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorValue));
		List<WebElement> elements = driver.findElements(locatorValue);
		log.info("	End: Successfully located elements- "+locatorValue);
		return elements;
	}
	
	public void sendKeysMethod(By locatorValue, String data)
	{
		log.info("Start: Trying to insert data- "+data +" in field - "+locatorValue);
//		findElementMethod(locatorValue).clear();
		findElementMethod(locatorValue).sendKeys(data);
		log.info("End: Successfully inserted data- "+data +" in field - "+locatorValue);
	}
	
	public void clickMethod(By locatorValue)
	{
		log.info("Start: Trying to click element- "+locatorValue);
		findElementMethod(locatorValue).click();
		log.info("End: Successfully clicked on element- "+locatorValue);
	}

	
	public void selectMethod(By locatorValue, String text)
	{
		Select select = new Select(findElementMethod(locatorValue));
		select.selectByVisibleText(text);
				
	}
	
	public Actions createActionsClassObject()
	{
		return actions = new Actions(driver);
	}
	
	public void moveToElementMethod(By locatorValue)
	{
		log.info("Start: Trying to move to element- "+locatorValue);
		createActionsClassObject().moveToElement(findElementMethod(locatorValue)).click().build().perform();
		log.info("End: Successfully moved to element- "+locatorValue);
	}
	
	public void moveToElementAndSendKeysMethod(By locatorValue, String data)
	{
		log.info("Trying to insert data- "+data +" in field - "+locatorValue);
		createActionsClassObject().moveToElement(findElementMethod(locatorValue)).click().sendKeys(data+Keys.ENTER).build().perform();
		log.info("End: Successfully inserted data- "+data +" in field - "+locatorValue);
	}
	
	public void dragAndDropMethod(By source, By destination)
	{
		log.info("Start: Trying to drag from element - " +source +" to element- "+destination);
		createActionsClassObject().dragAndDrop(findElementMethod(source), findElementMethod(destination)).build().perform();
		log.info("End: Successfully moved from element - " +source +" to element- "+destination);
	}
	
	public String verifyTitleMethod()
	{
		log.info("Fetching the title of the webpage");
		return driver.getTitle();
	}
	
	public String verifyURLMethod()
	{
		log.info("Fetching the URL of the webpage");
		return driver.getCurrentUrl();
	}
	
	public void quitBrowserMethod()
	{
		log.info("Start: Trying to close browser");
		driver.quit();
		log.info("End: Successfully closed browser");
	}
}
