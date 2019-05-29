package MavenSample;




import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class POMAmazonMoueseOver {
	
	
	WebDriver driver;
	static Logger log = Logger.getLogger(POMAmazonMoueseOver.class);
	
	@Test
	public void amazon()
	{
		
	
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    
    PropertyConfigurator.configure("P:\\Curie_Automation\\MavenSample\\src\\test\\java\\log4j.Properties");
    //Logger Log = Logger.getLogger(amazon.class.getName()); 
    
    driver.get("https://www.amazon.com/");    
    System.out.println("Amazon web site has been launced");
    log.info("Amazon site launched");
    
    //To click departments
   WebElement link_test= driver.findElement(By.xpath("//*[@id='nav-shop']/a/span[2]"));
   System.out.println(link_test.getText());
   
   
   //To clck mousehouver element:
   
   Actions builder = new Actions(driver);
   Action mouseOverHome = builder.moveToElement(link_test).build();
   mouseOverHome.perform();
   System.out.println("Items got list over");
   
   //To click book from list 
   WebElement clickElement=driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/a[9]/span"));
   
   //clickElement.click();
    builder.moveToElement(clickElement).click().perform();   
    System.out.println("Element got clicked");
    
    
    /*driver.close();    
    log.info("driver has closed successfully");*/
        
	}
	

}
