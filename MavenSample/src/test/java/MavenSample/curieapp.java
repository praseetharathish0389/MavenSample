package MavenSample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Utility.Utils;
import Utility.util2;

public class curieapp {
	
	WebDriver driver;
  
 
@Test
  public void curie() throws Exception {
	  
	  Utils util=new Utils(driver);	  
	  //util2 u=new util2(driver);
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
      driver=new ChromeDriver();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("disable-infobars");
      options.addArguments("start-maximized");
     
      driver.manage().window().maximize();
      driver.get("https://curie.health");
      
      //util2.takeScreenshot(driver,"PraveenLogin");
      
      util.capturescreenshots("Curie_Health", "Loginpage", driver); 
      
      driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/a")).click();


      driver.findElement(By.id("username")).sendKeys("praveen@gmail.com");
      
    /* String username="praveen@gmail.com";
     WebElement ele =driver.findElement(By.id("username"));
     Actions builder = new Actions(driver);
	 Action seriesOfActions =builder.moveToElement(ele).click().sendKeys(username,Keys.SHIFT).build();
	 seriesOfActions.perform() ;
     
      util.capturescreenshots("Curie_Health", "UsernameData", driver);*/
      
      driver.findElement(By.id("password")).sendKeys("praveen");
      Thread.sleep(2000);
      driver.findElement(By.id("signin")).click();
      
      
  }
}
