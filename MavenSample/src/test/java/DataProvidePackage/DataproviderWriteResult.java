package DataProvidePackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ReadExcel;

public class DataproviderWriteResult {
public WebDriver driver;
	
	@BeforeMethod
	public void open()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver=new ChromeDriver();		
		driver.get("https://curie-doctor.firebaseapp.com/#/app/login");
		driver.manage().window().maximize();			
	}
	
	
	@Test(dataProvider="prodlogin")
	public void login(String rowno,String username,String password,String actresult) throws IOException
	{
		
		    System.out.println("Value from dataprovider:"+username +"," + password);
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    // driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			
			driver.findElement(By.id("signin")).click();		
			
		    String	title= driver.getTitle();		     
		    System.out.println(title);	    
		    BigDecimal bd = new BigDecimal(rowno);
		    int rowno1 = bd.intValue();	
		    
		    if(!title.equalsIgnoreCase("curie"))
		    {
		    	System.out.println("Result of Execution is :FAIL");
		    	writeexcelresult(rowno1,"FAIL");
		    }
		    else 
		    {    		
		    	
		    	WebElement set=driver.findElement(By.id("setschedule"));
		    	System.out.println(set.isDisplayed());
		    	System.out.println("Result of Execution is :PASS");		    	
		    	writeexcelresult(rowno1,"PASS");
		    }
					}
	
	@DataProvider(name="prodlogin")
	public Object[][] getdata() throws Exception
	{
		 Object[][] data = ReadExcel.getdata("P:\\Curie_Automation\\MavenSample\\DataproviderTestdata\\TestData.xlsx","Sheet3");
		 return (data); 
		
	}
	
	private void writeexcelresult(int rowno1,String actresult) throws IOException
	  {        
	      ReadExcel datatowrite = new ReadExcel();
	      datatowrite.writexl("P:\\Curie_Automation\\MavenSample\\DataproviderTestdata\\TestData.xlsx","Sheet3", rowno1, actresult);
	     	  }


	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	
}




