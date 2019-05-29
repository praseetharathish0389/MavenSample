package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utils
{
 WebDriver driver;
	
	public Utils(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;		
	}
		
	
	public String capturescreenshots(String filepath,String filename,WebDriver driver) throws IOException
	   {
		try
		{
			   			
				TakesScreenshot ts=(TakesScreenshot)driver;	
				File source=ts.getScreenshotAs(OutputType.FILE);
				// File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
				 // Create object of SimpleDateFormat class and decide the format
				 DateFormat dateFormat = new SimpleDateFormat("MMddyyyy HH:mm");
							 
				 //get current date time with Date()
				 Date date = new Date();
				 
				 // Now format the date
				 String date1= dateFormat.format(date);
				 String date2 = date1.replaceAll(" ","_");
				 String fdate = date2.replaceAll(":", "_");
				 
				 //FileUtils.copyFile(source, new File("P:\\Curie_Automation\\MavenSample\\screenshot.png"));
	
				 //Screenshot path set with the timestamp
				String dest =System.getProperty("user.dir")+"\\Screenshots\\"+filepath+"\\"+fdate+"\\"+filename+".png";				
				File destination = new File(dest);
				FileUtils.copyFile(source, destination);
				System.out.println("Screenshot taken for ===== >>> "+ filepath);
				
				
				//Deleting the folder with screenshots when exists more than 10
				File filedelete = new File(System.getProperty("user.dir")+"\\Screenshots\\"+filepath);		
				File[] files = filedelete.listFiles();
				if(files.length > 2)
				{
					for(File f:files)
					{
					String foldername = f.getName();				
					for(int i = 1;i <= 5; i++)
					{
					 File filedelete1 = new File(System.getProperty("user.dir")+"\\Screenshots\\"+filepath+"\\"+foldername);	
					 //Calling the function deleteFolder to delete the files in the folder and then the folder 
					 deleteFolder(filedelete1);
					}
				}
			}
		
				return dest;
	   }

			catch(Exception e)
				{
				 System.out.println("exception while taking"+e.getMessage());
				 return e.getMessage();
				}
		}


	private void deleteFolder(File folder) {
		
		File[] files = folder.listFiles();
		if(files!=null)
			{
			
			//some JVMs return null for empty dirs
				for(File f: files)
				{
					if(f.isDirectory())
						{
						deleteFolder(f);
						}
					else 
						{
						f.delete();
						}
				}
			}
				folder.delete();
		}
		
		
	}



	    


