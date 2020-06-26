package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorClass extends CommonUtilities
{
	/**
	 * highlightElementMethod() method is used to highlight a WebElement in different colors.
	 * 
	 */
	public static void highlightElementMethod(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        //Below code is to fetch the original background color of the WebElement.
        String bgcolor  = element.getCssValue("backgroundColor");
        
        //We are using for loop so that we can highlight the element by toggle WebElement Background Color. 
        for (int i = 0; i < 10; i++) {
            //Below code is to set GREEN background color to the WebElement.
        	changeBackGroundColorMethod("rgb(0,200,0)", element,driver);//1
        	 //Below code is to set default background color of the WebElement.
        	changeBackGroundColorMethod(bgcolor, element,driver);//2
        }
    }
    public static void changeBackGroundColorMethod(String color, WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);
        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }
	
	/**
	 * createBorderMethod() method is used to draw a border across the element.
	 * This feature is very helpful while capturing a screenshot.
	 * Before capturing the screenshot, we would create a border across the element,
	 * So that while reviewing screenshot it would be easier to understand which element is having a issue.
	 */
    public static void createBorderMethod(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	//Below code is used to create a red color border of 3px width
    	js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
	/**
	 * generateCustomizedAlertMethod() method is used to create customized alerts on the webpage.
	 * This method will accept the String argument which will hold the message we want to display on the screen.
	 * Note: After hitting below method, we would have to handle this customized alert using Alert Class. 
	 */
    public static void generateCustomizedAlertMethod(WebDriver driver, String message){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("alert('"+message+"')");

    }
    
	/**
	 * clickOnElementMethod() method is used to click on any element of the webpage. 
	 */
    public static void clickOnElementMethod(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);
    	
    }
	
	/**
	 * refreshBrowserMethod() method is used to refresh the webpage.
	 */
    public static void refreshBrowserMethod(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("history.go(0)");
    }
    
	/**
	 * getTitleMethod() method is used to fetch the tile of the Webpage.
	 */
    public static String getTitleMethod(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String title = js.executeScript("return document.title;").toString();
    	return title;
    }
    
	/**
	 * getCompleteInnerTextOfTheWebPageMethod() method is used to fetch inner text of all the elements present on the webpage.
	 */
    public static String getCompleteInnerTextOfTheWebPageMethod(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
    	return pageText;
    }
    
	/**
	 * scrollToBottomMethod() method is used to scroll directly till the bottom of the webpage.
	 */
    public static void scrollToBottomMethod(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    
	/**
	 * scrollIntoViewMethod() method is used to scroll till the mentioned element.
	 */
    public static void scrollIntoViewMethod(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
