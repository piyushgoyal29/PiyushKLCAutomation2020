package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageRepository.LoginPage;
import utils.CommonUtilities;
import utils.ReadPropertiesFile;

public class LoginPageTest 
{
//	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	LoginPage loginPage;
	
	
	
	/**
	 * testSetUp method is used to invoke the browser.
	 * This method will be invoked before executing each @Test method of this class. 
	 */
	@BeforeMethod
	public void testSetUp()
	{
		commonUtilities.invokeBrowser();
		loginPage = new LoginPage();
	}
	
	/**
	 * validateUserLoginElementsAreDisplayed method is used to-
	 * validate the elements of the Login Page.
	 */
	@Test(description="Verify login page elements are displayed", priority=0)
	public void validateUserLoginElementsAreDisplayed()
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(loginPage.getEmailAddress().isDisplayed(), "UserName field is displayed");
		softAssert.assertTrue(loginPage.getPassword().isDisplayed(), "Password field is displayed");
		softAssert.assertAll();
	}
	
	/**
	 * validateUserLogin method is used to-
	 * validate that user logs into the application with-
	 * correct credentials.
	 */
	@Test(description="Verify login functionality", priority=1)
	public void validateUserLogin()
	{
		loginPage.login(ReadPropertiesFile.getPropertyValue("username"), ReadPropertiesFile.getPropertyValue("password"));
		String actualURL = commonUtilities.verifyURLMethod();
		Assert.assertEquals(actualURL, ReadPropertiesFile.getPropertyValue("loginPageUrl"), "Validating URL after login");
	}
	
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