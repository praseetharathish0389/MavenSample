package Simple1POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SimplePOMPharma {	
	
	@Test
	public void CheckUser(){
		
		//WebDriver driver=BrowserFactory.StartBrowser("Chrome", "https://appserver-77df3.firebaseapp.com/#/app/pharmalogin");
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
		driver.get("https://appserver-77df3.firebaseapp.com/#/app/pharmalogin");
		SimplePOMLogin l1=PageFactory.initElements(driver, SimplePOMLogin.class);
		l1.login_Pharmacy("thangam@gmail.com", "thangam");
	    l1.loginbutton.click();	
		
		
	}

}



