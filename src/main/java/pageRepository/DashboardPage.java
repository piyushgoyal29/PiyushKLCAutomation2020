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
	
	/**
	 * automateVideoSessions() method is created to just have a idea of how the KLC video sessions could be automated using selenium webdriver.
	 * Note: Since KLC is not completely accurate in terms of displaying video progress, so I have commented this code.
	 * But the logic of automating KLC video sessions using webdriver, works like below-
	 * 	1. Navigate to the video session.
	 * 	2. Validate that the progress is yet-to-start
	 * 	3. Fetch actual time duration of the video.
	 * 	4. Start the video.
	 * 	5. Validate that the status got changed to in-progress.
	 * 	6. Validate that the status changes to complete only when the 'progress time duration' matches the 'actual time duration'.
	 */
//	public void automateVideoSessions() throws InterruptedException
//	{
//		
//		getMethod("https://edulence.knowledgelink.tv/session/videonew/course/uatnew");
//		Thread.sleep(10000);
//		findElementMethod(By.xpath("(//div[@ng-click='play()'])[2]")).click();
//		
//		String totalTime = findElementMethod(By.xpath("//div[@ng-show='showControl']/table/tbody/tr/td[3]/span[3]")).getText();
//		String progressTime = findElementMethod(By.xpath("//div[@ng-show='showControl']/table/tbody/tr/td[3]/span[1]")).getText();
//		
//		while(!totalTime.equals(progressTime))
//		{
//			String progress = findElementMethod(By.xpath("//div[@class='progress-container']/span")).getText();
//			if(progress.contains("100% complete"))
//			{
//				Assert.fail();//Assert Failed
//			}
//			progressTime = findElementMethod(By.xpath("//div[@ng-show='showControl']/table/tbody/tr/td[3]/span[1]")).getText();
//		}
//		
//		Assert.assertEquals(findElementMethod(By.xpath("//div[@class='progress-container']/span")).getText(), "100% complete");
//	}
}
