package SimplePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


	public class POMpharmacy {		
		
		@Test
		public void CheckUser(){
			
			WebDriver driver=BrowseFactory.StartBrowser("Chrome", "https://appserver-77df3.firebaseapp.com/#/app/pharmalogin");
			
			POMLogin l1=PageFactory.initElements(driver, POMLogin.class);
//			l1.usernamebox.sendKeys("thangam@gmail.com");
//			l1.passwordbox.sendKeys("thangam");
			
			l1.login_Pharmacy("thangam@gmail.com", "thangam");
			
			//l1.loginbutton.click();
			
			
			
		}

	}



