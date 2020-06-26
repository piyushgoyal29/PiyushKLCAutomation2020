package utils;

import java.io.File;

public class DownloadedFilesVerification 
{
	public boolean isFileDownloaded(String downloadPath, String fileNameWithExtension) 
	{
		boolean flag = false;
	    File file = new File(downloadPath);
	    File[] directoryFiles = file.listFiles();
	    System.out.println(directoryFiles.length);
	  	    
	    for (int i = 0; i < directoryFiles.length; i++) 
	    {
	    	System.out.println(directoryFiles[i].getName());
	        if (directoryFiles[i].getName().equals(fileNameWithExtension))
	        {
	        	flag=true;
	        	break;
	        }            
	    }
	    System.out.println(flag);
	    return flag;
	}
}
