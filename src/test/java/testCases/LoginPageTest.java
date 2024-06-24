package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BrowserConfiguration;
import base.ReusableCode;
import pageFactoryModel.LoginPage;

public class LoginPageTest {

	private WebDriver driver;
	private ReusableCode reusablecode;
	private LoginPage lg;
	private static final Logger logger = LogManager.getLogger(LoginPageTest.class);


	@BeforeTest
	public void browserConfig() {
		
		logger.info("Setting up browser");
		driver = ReusableCode.invokeDriver();
		reusablecode = new ReusableCode(driver);
		lg = new LoginPage(driver);
		logger.info("Opening browser");
		reusablecode.openWebsite("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void login() {
		
		lg.inputUserName("Admin");
		logger.info("Entered Username");
		lg.inputPassword("admin123");
		logger.info("Entered Password");
		lg.clickOnLoginButton();
		logger.info("Clicked on Login button");
		reusablecode.takeScreenShot("C:\\Users\\shimu\\eclipse-workspace\\PageObjectModel\\screenshots.png");
	}

	@AfterTest
	public void tearDown() {
		logger.info("Closing Browser");
		reusablecode.closeBrowser();
		
	}
}
