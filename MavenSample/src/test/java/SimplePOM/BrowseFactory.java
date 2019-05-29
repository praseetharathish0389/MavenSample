package SimplePOM;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class BrowseFactory {
		
		static WebDriver driver;
		

	public static WebDriver StartBrowser(String Browsername, String URL){
		
		if(Browsername.equals("Chrome")){
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		      driver=new ChromeDriver();
			driver.get(URL);
				
		}
				
		return driver;
		
		
	}
		


}
