package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.pageComponents.HamburgerMenuComponent;

public class CheckoutCompletePage {
	
	private WebDriver driver;
	private HamburgerMenuComponent hamburgerMenuComponent;
	
	private static final Logger logger = LogManager.getLogger(CheckoutCompletePage.class);
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		hamburgerMenuComponent = new HamburgerMenuComponent(driver); // composite concept
	}
	
	@FindBy(id = "back-to-products")
	@CacheLookup
	WebElement BTN_BACKHOME;
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	@CacheLookup
	WebElement LBL_MESSAGE;
	
	@FindBy(xpath = "//h2[@class='complete-header']/../div[@class='complete-text']")
	@CacheLookup
	WebElement LBL_SUBMESSAGE;
	
	@FindBy(id = "react-burger-menu-btn")
	@CacheLookup
	WebElement LNK_HAMBURGERMENU;
	
	//Action message
	
	public void clickBackHome() {
		BTN_BACKHOME.click();
		logger.info("Clicked on Back Home button");
	}
	
	public String getOrderMessage() {
		logger.info("Order message displayed on screen");
		return LBL_MESSAGE.getText();
	}
	
	public String getOrderSubMessage() {
		logger.info("Order submessage displayed on screen");
		return LBL_SUBMESSAGE.getText();
	}
	
	public void clickHamBurgerMenu() {
		LNK_HAMBURGERMENU.click();
		logger.info("Clicked on Hamburger menu");
	}

	public void clickLogout() {
		hamburgerMenuComponent.clickLogout();
	}
	
	public void clickAllItems() {
		hamburgerMenuComponent.clickAllItems();
	}
	
	public void clickAbout() {
		hamburgerMenuComponent.clickAbout();
	}
	
	public void clickResetAppState() {
		hamburgerMenuComponent.clickResetAppState();
	}
}
