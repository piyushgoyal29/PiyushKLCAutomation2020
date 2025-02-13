package pageRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonUtilities;
import utils.ReadExcelSheet;
import utils.ReadPropertiesFile;

public class Admin_UserPage extends CommonUtilities{
//	WebDriver driver;
//	
//	public Admin_UserPage(WebDriver driver)
//	{
//		this.driver = driver;
//	}
	
	private By users = By.xpath("//a[@href='/admin/users']");
	private By addNewUserDropdown = By.xpath("//button[@class='btn btn-edulence submit dropdown-toggle']");
	private By addNewUserDropdown_Option_AddUser = By.linkText("Add user");
	private By newUserFirstName = By.name("first_name");
	private By newUserLastName = By.name("last_name");
	private By newUserEmail = By.name("email");
	private By newUserPassword = By.xpath("//input[@ng-model='newPassword']");
	private By newUserReTypePassword = By.xpath("//input[@ng-model='newPasswordRepeat']");
	private By newUserUAT1 = By.name("UAT1");
	private By newUserUAT2 = By.name("UAT2");
	private By newUserUAT3 = By.name("UAT3");
	private By newUserUAT4 = By.name("UAT4");
	private By newUserUAT5 = By.name("UAT5");
	private By newUserUAT6 = By.name("UAT6");
	private By newUserUAT7 = By.name("UAT7");
	private By newUserUAT8 = By.name("UAT8");
	private By newUserUAT9 = By.name("UAT9");
	private By newUserUAT10 = By.name("UAT10");
	private By newUserMediaGroup = By.xpath("(//input[@ng-model='$select.search'])[3]");
	private By newUserEnterprise = By.xpath("(//span[@class='btn btn-default form-control ui-select-toggle'])[2]");
	private By newUserRole = By.xpath("//select[@ng-model='role']");
	private By newUserAddNewButton = By.xpath("//button[@class='btn btn-edulence submit ng-scope']");
	private By usersTableRowCount = By.xpath("//*[@id='page_users']/table/tbody/tr");
	private By usersTableColumnCount = By.xpath("//*[@id='page_users']/table/tbody/tr[1]/th");

	/*
	 * addNewUsers() method is used to create new users in the system.
	 */
	public void addNewUsers(String firstNameData, String lastNameData, String emailData, 
			String passwordData, String retypePasswordData, 
			String uAT1Data, String uAT2Data, String uAT3Data, String uAT4Data, String uAT5Data, String uAT6Data, 
			String uAT7Data, String uAT8Data, String uAT9Data, String uAT10Data, String expirationDate,
			String mediaGroupData, String enterpriseData, String roleData) throws IOException
	{
		clickMethod(users);
		clickMethod(addNewUserDropdown);
		clickMethod(addNewUserDropdown_Option_AddUser);
		sendKeysMethod(newUserFirstName, firstNameData);
		sendKeysMethod(newUserLastName, lastNameData);
		sendKeysMethod(newUserEmail, emailData);
		sendKeysMethod(newUserPassword, passwordData);
		sendKeysMethod(newUserReTypePassword, retypePasswordData);
		sendKeysMethod(newUserUAT1, uAT1Data);
		sendKeysMethod(newUserUAT2, uAT2Data);
		sendKeysMethod(newUserUAT3, uAT3Data);
		sendKeysMethod(newUserUAT4, uAT4Data);
		sendKeysMethod(newUserUAT5, uAT5Data);
		sendKeysMethod(newUserUAT6, uAT6Data);
		sendKeysMethod(newUserUAT7, uAT7Data);
		sendKeysMethod(newUserUAT8, uAT8Data);
		sendKeysMethod(newUserUAT9, uAT9Data);
		sendKeysMethod(newUserUAT10, uAT10Data);
		moveToElementAndSendKeysMethod(newUserMediaGroup , mediaGroupData);
		moveToElementAndSendKeysMethod(newUserEnterprise, enterpriseData);
		selectMethod(newUserRole, roleData);
		clickMethod(newUserAddNewButton);
	}
	
	//To get the count of Rows
	public int getRowsCount() throws InterruptedException
	{
	        List<WebElement> rows = findElementsMethod(usersTableRowCount);
	        Thread.sleep(5000);
	        int rowsCount = rows.size();
	        return rowsCount;
	}
	
	//To get the count of Columns
	List<WebElement> columns;
	public int getColumnsCount()
	{
	        columns = findElementsMethod(usersTableColumnCount);
	        int columnsCount = columns.size();
	        return columnsCount;
	}
	
	//To get the position of the columns
		int nameColumnPosition = 0; 
		int emailColumnPosition = 0; 
		int mediaGroupColumnPosition = 0;
		int statusColumnPosition = 0;
		public void getColumnPositions()
		{
			int columnsCount = getColumnsCount();
		    for(int i=0; i<columnsCount; i++)
		    {   
		        String columnName = columns.get(i).getText();
		        if(columnName.contains("Name"))
		        {
		        	nameColumnPosition = i+1;
		        }
		        else if(columnName.contains("Email"))
		        {
		        	emailColumnPosition = i+1;
		        }
		        else if(columnName.contains("Media Group"))
		        {
		        	mediaGroupColumnPosition = i+1;
		        }
		        else if(columnName.contains("Status"))
		        {
		        	statusColumnPosition = i+1;
		        }
		    }    
		}
		
		public int getUserPosition(String userEmailId) throws InterruptedException
		{
			int userPositioninTable = 0;
		    int rowsCount = getRowsCount();
		    for(int j=2;j<rowsCount;j++)
		    {
		        String email = findElementMethod(By.xpath("//*[@id='page_users']/table/tbody/tr["+j+"]/td["+emailColumnPosition+"]")).getText();
		        if(email.toLowerCase().contains(userEmailId.toLowerCase()))
		        {
		        	userPositioninTable=j;
		            break;
		        }  
		    }
		    return userPositioninTable;
		}
		

	/*
	 * validateDetailsOfNewCreatedUsers() method is used to validate details of the user.
	 */
	public HashMap<String, String> validateDetailsOfNewCreatedUsers(String userEmailId) throws InterruptedException
	{
	    HashMap<String, String> userDetails = new HashMap<String, String>();
		getColumnPositions();
		int userPositioninTable = getUserPosition(userEmailId);
	    userDetails.put("users_Name", findElementMethod(By.xpath("//*[@id='page_users']/table/tbody/tr["+userPositioninTable+"]/td["+nameColumnPosition+"]")).getText());
	    userDetails.put("user_MediaGroup", findElementMethod(By.xpath("//*[@id='page_users']/table/tbody/tr["+userPositioninTable+"]/td["+mediaGroupColumnPosition+"]/span[1]")).getText());

	    return userDetails;
	}
	
	/*
	 * verifyIfUserIsPresent() method is used to validate if user is present in the system.
	 */
	public void verifyIfUserIsPresent(String userEmailId) throws InterruptedException
	{
		clickMethod(users);
		List<WebElement> numberOfPages = findElementsMethod(By.xpath("//ul[@ng-model='pagn.currentPage']//a[@ng-click='selectPage(page.number)']"));
		
		for(int i=0; i<numberOfPages.size();i++)
		{
			numberOfPages.get(i).click();
			
			int rowsCount = getRowsCount();
			getColumnPositions();
			for(int j=2; j<rowsCount; j++)
			{
				String email = findElementMethod(By.xpath("//*[@id='page_users']/table/tbody/tr["+j+"]/td["+emailColumnPosition+"]")).getText();
		        if(email.toLowerCase().contains(userEmailId.toLowerCase()))
		        {
		        	int userPresentOnPage = i+1;
		        	int userPositionOnPage = j-1;
		        	System.out.println("User is present on page "+userPresentOnPage+" at postion "+userPositionOnPage);
		            break;
		        }
			}
			
		}
	}
}
