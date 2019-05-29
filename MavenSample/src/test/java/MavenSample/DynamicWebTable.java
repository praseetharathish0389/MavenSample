package MavenSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DynamicWebTable {
	
	WebDriver driver;
	
	@Test
	public void dynamic()
	{
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	       driver=new ChromeDriver();
	       ChromeOptions options = new ChromeOptions();
	       options.addArguments("disable-infobars");
	       options.addArguments("start-maximized");
	      
	      // driver.manage().window().maximize();
	       driver.get("http://demo.guru99.com/test/web-table-element.php");
	       
	       WebElement tdata=driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr/th[2]"));
	       
	        if(tdata.getText().isEmpty())
	        {
	        	System.out.println("No data Available");
	        }
	        else 
	        {
	        	System.out.println("table data is :" +    tdata.getText());
	        }
	       
	       
	       
	       
	       
		
	}
	

}
