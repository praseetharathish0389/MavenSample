package MavenSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass {

	
	
	public WebDriver driver;
	
	@Test
	public void actiontest()
	{
		String baseurl = "http://demo.guru99.com/test/newtours/";
	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    
	    driver.get(baseurl);
	    
	    WebElement link_Home=driver.findElement(By.linkText("Home"));
	    WebElement td_Home = driver.findElement(By.xpath("//html/body/div" + "/table/tbody/tr/td"+ "/table/tbody/tr/td"+ "/table/tbody/tr/td" + "/table/tbody/tr"));    
         
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(link_Home).build();
        
        String bgcolor=td_Home.getCssValue("background_color");
        
        System.out.println("Before hover"+ bgcolor);
        
        mouseOverHome.perform();
        
        System.out.println("After hover"+ bgcolor);
        	    
	
	}
}
