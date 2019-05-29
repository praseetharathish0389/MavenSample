package DataProvidePackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ReadExcel;


public class DataproviderExcelData {
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public void open()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver=new ChromeDriver();		
		driver.get("https:\\curie.health");
		driver.manage().window().maximize();			
	}
	
	
	@Test(dataProvider = "login")
	public void login(String rowno,String username,String password,String actresult) throws IOException
	{	
		
		  System.out.println("Value from dataprovider:"+username +"," + password);
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("signin")).click();
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    
		    actresult= driver.getTitle();		     
		    System.out.println(actresult);		    
		    BigDecimal bd = new BigDecimal(rowno);
		    int rowno1 = bd.intValue();		    
			writeexcelresult(rowno1,actresult);		
			
		}
	
	@DataProvider(name = "login")
	public Object[][] getdata() throws Exception
	{
		 Object[][] data = ReadExcel.getdata("P:\\Curie_Automation\\MavenSample\\DataproviderTestdata\\TestData.xlsx","Sheet1"); 
         return (data); 
		
	}	
	
	private void writeexcelresult(int rowno1,String actresult) throws IOException
	  {        
	      ReadExcel datatowrite = new ReadExcel();
	      datatowrite.writexl("P:\\Curie_Automation\\MavenSample\\DataproviderTestdata\\TestData.xlsx","Sheet1", rowno1, actresult);
	     	  }
		 
	
		     
	   
	
	
	
	


	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	
}
