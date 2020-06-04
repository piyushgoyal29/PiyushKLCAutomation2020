package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerClass implements IRetryAnalyzer
{
	int counter = 0;
	int retryLimit = 3; //Numbers to attempts we have to re-try.
	
	public boolean retry(ITestResult result) 
	{
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}
	
}
