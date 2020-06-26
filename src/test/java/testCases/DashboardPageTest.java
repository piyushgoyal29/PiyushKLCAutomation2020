package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageRepository.DashboardPage;
import pageRepository.LoginPage;
import utils.CommonUtilities;
import utils.ReadPdfFile;
import utils.ReadPropertiesFile;
import utils.SikuliClass;

public class DashboardPageTest extends CommonUtilities
{
//	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();
	
	/**
	 * testSetUp method is used to -
	 * 	1. invoke the browser.
	 * 	2. Login into the application with valid credentials.
	 * This method will be invoked before executing each @Test method of this class. 
	 */
	@BeforeMethod
	public void testSetUp()
	{
		commonUtilities.invokeBrowser();
		loginPage.login(ReadPropertiesFile.getPropertyValue("username"), ReadPropertiesFile.getPropertyValue("password"));
	}
	
	/**
	 * navigateToAdminPage method is used to -
	 * navigate to the admin page.
	 * @throws InterruptedException 
	 */
	@Test
	public void navigateToAdminPage() throws InterruptedException
	{
		dashboardPage.clickOnDropdownOptionAdmin();
		Thread.sleep(5000);
		/*
		 * Sleep because selenium does not wait until the webpage is loaded and URL is changed,
		 * Instead it fetches the URL as soon as the command is hit.
		 */
		String actualURL = commonUtilities.verifyURLMethod();
		Assert.assertEquals(actualURL, ReadPropertiesFile.getPropertyValue("reportsPageUrl"), "Validating Admin Page URL");
	}

	/*
	 * Note that below @Test automateVideoSessions() method was created for understanding purpose.
	 * But actual code is not implemented due to inconsistency of KLC.
	 * So I have commented the code. 
	 */
//	@Test
//	public void automateVideoSessions() throws InterruptedException
//	{
//		dashboardPage.automateVideoSessions();
//	}
	
	/*
	 * Note that below @Test automateVideoSessionsUsingSikuli() method was created to understand SIKULI tool.
	 * But actual code is not implemented due to inconsistency of KLC.
	 * So I have commented the code. 
	 */
//	@Test
//	public void automateVideoSessionsUsingSikuli() throws InterruptedException, FindFailed
//	{
//		driver.get("https://edulence.knowledgelink.tv/session/videonew/course/uatnew");
//		Thread.sleep(10000);
//		SikuliClass.clickMethod("start.png");
//		SikuliClass.clickMethod("pause.jpg");
//		SikuliClass.clickMethod("mute.jpg");
//		SikuliClass.clickMethod("settings.jpg");
//		SikuliClass.clickMethod("newSpeed.jpg");
//		SikuliClass.clickMethod("newSpeed.jpg");	
//	}
	
	/*
	 * Note that below @Test automatePdfSessions() method was created to understand PDF Comparison.
	 * But the code is not behaving as expected.
	 * So I have commented the code. 
	 */
//	@Test
//	public void automatePdfSessions() throws InterruptedException, IOException
//	{
//		ReadPdfFile.comparePdfsAndGenerateResultPdf("file:///C:/Users/Piyush/Desktop/Resume/pdf/Piyush1.pdf", "file:///C:/Users/Piyush/Desktop/Resume/pdf/Piyush2.pdf", "C:\\Users\\Piyush\\Desktop\\Resume\\pdf\\Result");
//	}
	
	
	/**
	 * tearDown method is used to close the browser.
	 * This method will be invoked after executing each @Test method of this class. 
	 */
	@AfterMethod
	public void tearDown()
	{
		commonUtilities.quitBrowserMethod();
	}
	
}
