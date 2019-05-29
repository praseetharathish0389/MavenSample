package DataProvidePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ReadExcel;

public class DataProviderExcelData2 {
public WebDriver driver;
	
	@BeforeMethod
	public void open()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver=new ChromeDriver();		
		driver.get("https://appserver-77df3.firebaseapp.com/#/app/login");
		driver.manage().window().maximize();			
	}
	
	
	@Test(dataProvider="stglogin")
	public void login(String username,String password)
	{
		
		    System.out.println("Value from dataprovider:"+username +"," + password);
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    // driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("signin")).click();				
		}
	
	@DataProvider(name="stglogin")
	public Object[][] getdata() throws Exception
	{
		 Object[][] data = ReadExcel.getdata("P:\\Curie_Automation\\MavenSample\\DataproviderTestdata\\TestData.xlsx","Sheet2");
		 return (data); 
		
	}		


	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	
}



