package library;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	static String workingDirectory =  System.getProperty("user.dir");
	
	//Function to capture a Screenshot and store in project's "Screenshot" folder
	
	public static String captureScreenshot(WebDriver driver, String screenshotName)
	{
		try {
			TakesScreenshot screens = (TakesScreenshot) driver;
			File source = screens.getScreenshotAs(OutputType.FILE);
			
			String destFilePath = workingDirectory+"\\Screenshots\\"+screenshotName+DateAndTimeStamp()+".png";	
						
			File destination = new File(destFilePath);
			FileUtils.copyFile(source, destination);
			
			return destFilePath;
			
		} catch (Exception e) {
			
			 return e.getMessage();
		} 
	
	
	}
	
	//Convert Date and time to string and append underscore"_"
	
	public static String DateAndTimeStamp()
	{
	 	    // (1) get today's date
	    Date today = Calendar.getInstance().getTime();

	    // (2) create a date "formatter" (the date format we want)
	    SimpleDateFormat formatter = new SimpleDateFormat("_MM_dd_yyyy_hh_mm_ss");

	    // (3) create a new String using the date format we want
	    String folderName = formatter.format(today);
	    
	    // Return the name of folder
		return folderName;
	  }
	
	
	
	
	
	//Function to select dropdown menu item
	
	public static void selectDropDown(WebElement selectDropDown, String valueToSelect)
	{
		
		Select dropDown =  new Select(selectDropDown);
		List<WebElement> Options = dropDown.getOptions();
		for(WebElement option:Options)
		{
		  if(option.getText().equals(valueToSelect))
		  {
		       option.click();  
		  }
		}
	}
	
}
