package pageRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.CommonUtilities;

public class DashboardPage extends CommonUtilities
{
//	WebDriver driver;
//	
//	public DashboardPage(WebDriver driver)
//	{
//		this.driver=driver;
//	}
	

	private By dashboardDropdown = By.xpath("//div[@class='toggle-btn unselectable usr-user-dropdown']");
	private By dropdownOptionAdmin = By.linkText("Admin page");
	
	public WebElement getDashboardDropdown()
	{
		return findElementMethod(dashboardDropdown);
	}
	
	public WebElement getDropdownOptionAdmin()
	{
		return findElementMethod(dropdownOptionAdmin);
	}
	
	public void clickOnDashboardDropdown()
	{
		clickMethod(dashboardDropdown);
	}
	
	public void clickOnDropdownOptionAdmin()
	{
		clickMethod(dashboardDropdown);
		clickMethod(dropdownOptionAdmin);
	}
	
	public void automateVideoSessions() throws InterruptedException
	{
		
		driver.get("https://edulence.knowledgelink.tv/session/videonew/course/uatnew");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@ng-click='play()'])[2]")).click();
//		JavascriptExecutor execute= (JavascriptExecutor)driver;
//		execute.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//div[@ng-click='play()'])[2]")));
		
		String totalTime = driver.findElement(By.xpath("//div[@ng-show='showControl']/table/tbody/tr/td[3]/span[3]")).getText();
		String progressTime = driver.findElement(By.xpath("//div[@ng-show='showControl']/table/tbody/tr/td[3]/span[1]")).getText();
		
//		while(!totalTime.equals(progressTime))
//		{
//			String progress = driver.findElement(By.xpath("//div[@class='progress-container']/span")).getText();
//			if(progress.contains("100% complete"))
//			{
//				Assert.fail();//Assert Failed
//			}
//			else
//			{
//				Assert.assertTrue(true); //Assert Passed
//			}
//			progressTime = driver.findElement(By.xpath("//div[@ng-show='showControl']/table/tbody/tr/td[3]/span[1]")).getText();
//		}
//		
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='progress-container']/span")).getText(), "100% complete");
	}
	
	
}
