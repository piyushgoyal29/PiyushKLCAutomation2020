package utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliClass 
{
	static Screen s = new Screen();
	
	public static void clickMethod(String image) throws FindFailed, InterruptedException
	{
		Pattern pattern = new Pattern("/SikuliImages/"+image);
		s.click(pattern);
	}
	
	public static void doubleClickMethod(String image) throws FindFailed, InterruptedException
	{
		Pattern pattern = new Pattern("/SikuliImages/"+image);
		s.doubleClick(pattern);
	}
	
	public static void typeMethodToEnterText(String image, String textToEnter) throws FindFailed, InterruptedException
	{
		Pattern pattern = new Pattern("/SikuliImages/"+image);
		s.type(pattern, textToEnter);
	}
}
