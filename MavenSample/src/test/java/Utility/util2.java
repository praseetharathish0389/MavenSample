package Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class util2 {
	WebDriver driver;
	
	public util2(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;		
	  }
	

	public static String takeScreenshot(WebDriver driver, String filename) throws Exception{
		 
		 try{
		 TakesScreenshot ts=(TakesScreenshot)driver;	
		 File source=ts.getScreenshotAs(OutputType.FILE);
						
			 //Screenshot path set with the timestamp
			String dest ="P:\\Curie_Automation\\MavenSample\\curie_Screenshots\\"+filename+".png";				
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken for ===== >>> "+ filename);			

		return dest;
			}
		catch(Exception e)
			{
			 System.out.println("exception while taking"+e.getMessage());
			 return e.getMessage();
			 
			 
			}
		}
}
