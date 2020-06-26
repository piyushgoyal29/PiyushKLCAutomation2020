package testCases;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageRepository.Admin_SettingsPage;
import pageRepository.Admin_UserPage;
import pageRepository.DashboardPage;
import pageRepository.LoginPage;
import utils.CommonUtilities;
import utils.ReadExcelSheet;
import utils.ReadPropertiesFile;

public class Admin_UserPageTest {
//	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();
	Admin_UserPage adminUsersPage = new Admin_UserPage();
	
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
	 * createNewUsers method is used to-
	 * Create new users and validate if they are created successfully
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@Test(description = "Creating new users in the system", dataProvider = "getData")
	public void createNewUsers(String firstNameData, String lastNameData, String emailData, 
			String passwordData, String retypePasswordData, 
			String uAT1Data, String uAT2Data, String uAT3Data, String uAT4Data, String uAT5Data, String uAT6Data, 
			String uAT7Data, String uAT8Data, String uAT9Data, String uAT10Data, String expirationDate, 
			String mediaGroupData, String enterpriseData, String roleData) throws IOException, InterruptedException
	{
		adminUsersPage.addNewUsers(firstNameData, lastNameData, emailData, passwordData, retypePasswordData,
				uAT1Data, uAT2Data, uAT3Data, uAT4Data, uAT5Data, uAT6Data, uAT7Data, uAT8Data, uAT9Data, uAT10Data, expirationDate,
				mediaGroupData, enterpriseData, roleData);
		
		HashMap<String, String> userDetails = adminUsersPage.validateDetailsOfNewCreatedUsers(emailData);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(userDetails.get("users_Name").toLowerCase().trim(), firstNameData.toLowerCase().trim()+" "+lastNameData.toLowerCase().trim(), "Validating users FirstName and LastName");
		softAssert.assertEquals(userDetails.get("user_MediaGroup").toLowerCase().trim(), mediaGroupData.toLowerCase().trim(), "Validating users Media Group");
		softAssert.assertAll();
	}
	
	/**
	 * getData method is used to-
	 * 	- Read the excel sheet
	 * 	- Store the data inside the Object array
	 * @throws IOException 
	 * returns Object
	 */
	@DataProvider
	public Object[][] getData() throws IOException
	{
		ReadExcelSheet readExcelSheet = new ReadExcelSheet();
		Object[][] data =readExcelSheet.getCellData(ReadPropertiesFile.getPropertyValue("excelFilePathDD"), ReadPropertiesFile.getPropertyValue("excelSheetNameDD"));
		return data;
	}

	/**
	 * verifyIfUserExistsInTheSystem() method is used to verify if the user exists in the system
	 */
	@Test
	public void verifyIfUserExistsInTheSystem() throws InterruptedException
	{
		adminUsersPage.verifyIfUserIsPresent(ReadPropertiesFile.getPropertyValue("username"));
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
