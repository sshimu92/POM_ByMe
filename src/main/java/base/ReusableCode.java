package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;

public class ReusableCode {

	private static WebDriver driver;
//	private WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(ReusableCode.class);
	
	public ReusableCode(WebDriver driver) {
		
		this.driver = driver;
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
	}
	
	public static WebDriver invokeDriver() {
		
		return driver = DriverSetup.invokeBrowser();
		
	}
	
	public void openWebsite(String url) {
		
		driver.get(url);
		ReusableCode.takeScreenShot(url);
	}
	
	public void sendKeys(WebElement ele, String txt) {
		
		ele.clear();
		
		try{
			ele.sendKeys(txt);
		
		}catch(Exception e) {
		
			ReusableCode.takeScreenShot(txt);
		    logger.error(e.getMessage());
		}
	}
	
	public void click(WebElement ele) {
		
		try{ 
			
			ele.click();
		
		}catch(Exception e) {
		
		ReusableCode.takeScreenShot(null);
		 logger.error(e.getMessage());
		
		}
	}
	
	public void selectDropdown(WebElement ele, String sd) {
		
		Select sc = new Select(ele);
		sc.selectByVisibleText(sd);	
		
	}
	
	public  String getText(WebElement ele, String txt) {
		
		return ele.getText();
	}
	
	public void closeBrowser() {
		
		driver.quit();
	}
	
	
	 public static void takeScreenShot(String filePath) {
		
		 TakesScreenshot screenshot = (TakesScreenshot) driver;
		 File src = screenshot.getScreenshotAs(OutputType.FILE);
		 
		 try {
			FileUtils.copyFile(src, new File("screenshots"+filePath+".png"));
		
		 } catch (IOException e) {
			
			 logger.error(e.getMessage());
		}
	}
	
}
