package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageRepository.Admin_ReportsPage;
import pageRepository.Admin_SettingsPage;
import pageRepository.DashboardPage;
import pageRepository.LoginPage;
import utils.CommonUtilities;
import utils.ReadPropertiesFile;

public class Admin_ReportsPageTest 
{
	CommonUtilities commonUtilities = new CommonUtilities();
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();
	Admin_ReportsPage adminReportsPage = new Admin_ReportsPage();
	
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
	
	@Test
	public void selectDate(){
		adminReportsPage.selectDate(ReadPropertiesFile.getPropertyValue("reportsExpectedStartDate"));
	}
	
}
