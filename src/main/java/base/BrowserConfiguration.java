package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserConfiguration {

	private static WebDriver driver;
	
	public static WebDriver getdriver(String browser) {
		
	  switch(browser.toLowerCase()) {
		
		 case ("chrome"):
			 
			 driver = new ChromeDriver();
		     break;
		  
         case ("firefox"):
			 
			 driver = new FirefoxDriver();
		     break;
		     
		     
         case ("safari"):
	 
	         driver = new SafariDriver();
             break;
             
         case ("edge"):
			 
			 driver = new EdgeDriver();
		     break;
		     
		 default:
			 
			 System.out.println("Browser "+browser+ "not suported");
		
		}
	
	     return driver;	
	}

	public void closeDriver() {
		
		if(driver != null) {
			
			driver.quit();
		}
	}
}
