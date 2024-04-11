package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.pageComponents.HamburgerMenuComponent;

public class CheckoutOverviewPage {
	
	private WebDriver driver;
	private HamburgerMenuComponent hamburgerMenuComponent;
	
	private static final Logger logger = LogManager.getLogger(CheckoutOverviewPage.class);
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		hamburgerMenuComponent = new HamburgerMenuComponent(driver);
	}
	@FindBy(id = "finish")
	@CacheLookup
	WebElement BTN_FINISH;
	
	@FindBy(id = "cancel")
	@CacheLookup
	WebElement BTN_CANCEL;
	
	@FindBy(css = "span.title")
	@CacheLookup
	WebElement LBL_HEADER;
	
	@FindBy(id = "react-burger-menu-btn")
	@CacheLookup
	WebElement LNK_HAMBURGERMENU;
	
	//Action methods
	
	public void clickFinish() {
		BTN_FINISH.click();
		logger.info("Clicked on Finish button");
	}
	
	public void clickCancel() {
		BTN_CANCEL.click();
		logger.info("Clicked on Cancel button");
	}
	
	public String getPageHeader() {
		logger.info("Title header is fetched");
		return LBL_HEADER.getText();
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
