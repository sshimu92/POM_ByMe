package pageFactoryModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableCode;

public class LoginPage {

	private WebDriver driver;
	ReusableCode rc;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		this.rc = new ReusableCode(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickloginbutton;
	
	
	public void inputUserName(String Uname) {
		
		rc.sendKeys(username, Uname);
		
	}

	public void inputPassword(String pwd) {
		
		rc.sendKeys(password, pwd);
	}

	public void clickOnLoginButton() {
		
		rc.click(clickloginbutton);
	}
}
