package pageRepository;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonUtilities;

public class Admin_SettingsPage extends CommonUtilities{

//	WebDriver driver;
//	
//	public Admin_SettingsPage(WebDriver driver){
//		this.driver = driver;
//	}
	
	By settings = By.xpath("//a[@href='/admin/settings/account']");
	By mediaGroupSection = By.xpath("//a[@href='/admin/settings/mediagroup']");
	By existingMediaGroups = By.xpath("//ul[@class='group-list']//li/div/p");
	By newMediaGroupName= By.xpath("//input[@ng-model='newName']");
	By newMediaGroupAbbreviation = By.xpath("//input[@ng-model='newAlias']");
	By newMediaGroupButton = By.xpath("(//button[@class='btn btn-primary'])[1]");
	
	public void clickOnSettingsOption()
	{
		clickMethod(settings);
	}
	
	public void clickOnMediaGroupSection()
	{
		clickMethod(mediaGroupSection);
	}
	
	public boolean getListOfExistingMediaGroups(String mediaGroup)
	{
		clickMethod(settings);
		clickMethod(mediaGroupSection);
		List<WebElement> listOfMediaGroups= findElementsMethod(existingMediaGroups);
		
		boolean flag = false;
		for(WebElement list : listOfMediaGroups)
		{
			if(mediaGroup.equals(list.getText()))
			{
				flag= true;
				break;
			}
			flag= false;
		}
		
		return flag;
	}
	
	public boolean createNewMediaGroup(String Name, String Abbreviation)
	{
		sendKeysMethod(newMediaGroupName, Name);
		sendKeysMethod(newMediaGroupAbbreviation, Abbreviation);
		clickMethod(newMediaGroupButton);
		
		List<WebElement> listOfMediaGroups= findElementsMethod(existingMediaGroups);
		
		boolean flag = false;
		for(WebElement list : listOfMediaGroups)
		{
			if(Name.equals(list.getText()))
			{
				flag= true;
				break;
			}
			flag= false;
		}
		
		return flag;
	}
}
