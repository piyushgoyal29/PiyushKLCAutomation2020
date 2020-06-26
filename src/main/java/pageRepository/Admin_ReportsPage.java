package pageRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonUtilities;

public class Admin_ReportsPage extends CommonUtilities
{
	private By startDatePicker = By.xpath("//input[@ng-model='report.dates.startDate']");
	private By endDatePicker = By .xpath("//input[@ng-model='report.dates.endDate']");
	private By yearSelector = By.xpath("(//button[@role='heading'])[1]");

	
	public void selectDate(String expectedDate)
	{
		String [] date = expectedDate.split("-");
		String expectedDay = date[0];
		String expectedMonth = date[1];
		String expectedYear = date[2];
		
		
		clickMethod(startDatePicker);
		clickMethod(yearSelector);
		clickMethod(yearSelector);
		List<WebElement> yearRows = findElementsMethod(By.xpath("//table[@ng-switch-when='year']/tbody/tr"));
		List<WebElement> yearColumns = findElementsMethod(By.xpath("//table[@ng-switch-when='year']/tbody/tr[1]/td"));
		
		yearSearch:
		for(int i=1;i<=yearRows.size();i++)
		{
			for(int j=1;j<=yearColumns.size();j++)
			{
				String value = findElementMethod(By.xpath("//table[@ng-switch-when='year']/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(value.equals(expectedYear))
				{
					findElementMethod(By.xpath("//table[@ng-switch-when='year']/tbody/tr["+i+"]/td["+j+"]")).click();
					break yearSearch;
				}
			}
		}
		
		List<WebElement> monthRows = findElementsMethod(By.xpath("//table[@ng-switch-when='month']/tbody/tr"));
		List<WebElement> monthColumns = findElementsMethod(By.xpath("//table[@ng-switch-when='month']/tbody/tr[1]/td"));
		
		monthSearch:
		for(int i=1;i<=monthRows.size();i++)
		{
			for(int j=1;j<=monthColumns.size();j++)
			{
				String value = findElementMethod(By.xpath("//table[@ng-switch-when='month']/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(value.toLowerCase().trim().equals(expectedMonth.toLowerCase().trim()))
				{
					findElementMethod(By.xpath("//table[@ng-switch-when='month']/tbody/tr["+i+"]/td["+j+"]")).click();
					break monthSearch;
				}
			}
		}
		
		List<WebElement> dayRows = findElementsMethod(By.xpath("(//table[@ng-switch-when='day']/tbody)[1]/tr"));
		List<WebElement> dayColumns = findElementsMethod(By.xpath("(//table[@ng-switch-when='day']/tbody)[1]/tr[1]/td"));
		
		daySearch:
		for(int i=1;i<=dayRows.size();i++)
		{
			for(int j=1;j<=dayColumns.size();j++)
			{
				String value="0";
				try{
					value = findElementMethod(By.xpath("(//table[@ng-switch-when='day']/tbody)[1]/tr["+i+"]/td["+j+"]//span[@class='ng-binding']")).getText();			
				}
				catch(Exception e){
					//
				}
				if(value.equals(expectedDay))
				{
					findElementMethod(By.xpath("(//table[@ng-switch-when='day']/tbody)[1]/tr["+i+"]/td["+j+"]")).click();
					break daySearch;
				}
			}
		}
	}
}
