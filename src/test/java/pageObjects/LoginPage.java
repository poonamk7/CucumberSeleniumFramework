package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import enums.WaitType;
import utilities.WaitHelper;

public class LoginPage {
	
	private WebDriver driver;
	private static final Logger logger =LogManager.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id = "user-name")
	@CacheLookup
	WebElement TXT_USERNAME;
	
	@FindBy(id = "password")
	@CacheLookup
	WebElement TXT_PASSWORD;
	
	@FindBy(id = "login-button")
	@CacheLookup
	WebElement BTN_LOGIN;
	
	@FindBy(xpath = "//div[contains(@class,'error-message')]/h3")
	@CacheLookup
	WebElement LBL_ERROR;
	
	@FindBy(css = "div.login_logo")
	@CacheLookup
	WebElement LBL_PAGEHEADER;
	
	
	public void enterUsername(String username) {
		TXT_USERNAME.clear();
		TXT_USERNAME.sendKeys(username);
		logger.info("Username "+username+" is entered");
	}
	
	public void enterPassword(String password) {
		TXT_PASSWORD.clear();
		TXT_PASSWORD.sendKeys(password);
		logger.info("Password "+password+" is entered");
	}
	
	public void clickLogin() {
		WaitHelper.waitUntil(driver, BTN_LOGIN, 3, WaitType.CLICAKBLE);
		logger.info("Login button is clicked");
	}
	
	public String getErrorMessage() {
		logger.info("Error message is displayed");
		return LBL_ERROR.getText();
	}
	
	public void performLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
		logger.info("Login is performed");
	}
	
	public String getPageHeader() {
		logger.info("Page header is captured");
		return LBL_PAGEHEADER.getText();
	}
	

}
