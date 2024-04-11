package pageObjects.pageComponents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenuComponent {
	
	private WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(HamburgerMenuComponent.class);
	
	public HamburgerMenuComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "inventory_sidebar_link")
	@CacheLookup
	WebElement LNK_ALLI_TEMS;
	
	@FindBy(id = "about_sidebar_link")
	@CacheLookup
	WebElement LNK_ABOUT;
	
	@FindBy(id = "logout_sidebar_link")
	@CacheLookup
	WebElement LNK_LOGOUT;
	
	@FindBy(id = "reset_sidebar_link")
	@CacheLookup
	WebElement LNK_RESET_APP_STATE;
	
	//Action methods
	
	public void clickAllItems() {
		LNK_ALLI_TEMS.click();
		logger.info("Clicked on All Items link");
	}
	
	public void clickAbout() {
		LNK_ABOUT.click();
		logger.info("Clicked on About link");
	}
	
	public void clickLogout() {
		LNK_LOGOUT.click();
		logger.info("Clicked on Logout link");
	}
	
	public void clickResetAppState() {
		LNK_RESET_APP_STATE.click();
		logger.info("Clicked on Reset App State link");
	}
	

}
