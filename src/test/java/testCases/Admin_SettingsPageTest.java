package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageRepository.Admin_SettingsPage;
import pageRepository.DashboardPage;
import pageRepository.LoginPage;
import utils.CommonUtilities;
import utils.ReadPropertiesFile;


public class Admin_SettingsPageTest 
{
//	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();
	Admin_SettingsPage adminSettingsPage = new Admin_SettingsPage();
	
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
		dashboardPage.clickOnDropdownOptionAdmin();
	}
	
	
	/**
	 * createNewMediaGroups method is used to-
	 * Create a new media group, only if it is not already present.
	 */
	@Test(description = "Creating a new Media Group")
	public void createNewMediaGroups()
	{
		boolean flag= adminSettingsPage.getListOfExistingMediaGroups(ReadPropertiesFile.getPropertyValue("newMediaGroupName"));
		if(flag)
		{
			System.out.println("Media Group Exists");
		}
		else
		{
			System.out.println("We have to create a media group");
			boolean newMediaGroupFlag = adminSettingsPage.createNewMediaGroup(ReadPropertiesFile.getPropertyValue("newMediaGroupName"),ReadPropertiesFile.getPropertyValue("newMediaGroupAbbreviation"));
			Assert.assertTrue(newMediaGroupFlag, "New Media Group Created Successfully");
		}
	}
}
