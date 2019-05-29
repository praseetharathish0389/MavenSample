package Simple1POM; 
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;

	public class SimplePOMLogin {
		
		WebDriver driver;
		
		@FindBy(id="username")WebElement usernamebox;
		
		@FindBy(how=How.ID,using="password")WebElement passwordbox;
		
		@FindBy(how=How.ID,using="signin")WebElement loginbutton;
		

		public void login_Pharmacy(String username, String password){
			
			usernamebox.sendKeys(username);
			passwordbox.sendKeys(password);
				
			
		}
		

	}



