package DataProvidePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderclass {
	
	
	public WebDriver driver;
	

	@BeforeMethod
	public void before()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:\\curie.health");		
	}
	
	
	
	@Test(dataProvider="logindata")
	public void Dpdatalogin(String username,String password)
	{
		
	    driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("signin")).click();				
	}
	
	
	@DataProvider(name="logindata")
	public  Object[][] getdata()
	{		
		Object[][] data=new Object[3][2];
		data[0][0]="praveen@gmail.com";
		data[0][1]="praveen";
		data[1][0]="amit@gmail.com";
		data[1][1]="amit123";
		data[2][0]="ellora@gmail.com";
		data[2][1]="ellorasystems";
		return data;		
	}
	
	
	@AfterMethod
	public void after()
	{
		driver.quit();
	}
	
	
	
}
