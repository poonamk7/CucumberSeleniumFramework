package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.pageComponents.HamburgerMenuComponent;

public class YourCartPage {
	
	private WebDriver driver;
	private HamburgerMenuComponent hamburgerMenuComponent;
	
	private static final Logger logger = LogManager.getLogger(YourCartPage.class);
	
	public YourCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		hamburgerMenuComponent = new HamburgerMenuComponent(driver);
	}
	
	@FindBy(css = "div.cart_item_label")
	@CacheLookup
	List<WebElement> LBL_LISTOFPRODUCTS;
	
	@FindBy(id = "checkout")
	@CacheLookup
	WebElement BTN_CHECKOUT;
	
	@FindBy(id = "continue-shopping")
	@CacheLookup
	WebElement BTN_CONTINUESHOPPING;
	
	@FindBy(xpath = "//button[text()='Remove']")
	@CacheLookup
	WebElement BTN_REMOVE;
	
	@FindBy(xpath = "//button[text()='Remove']")
	@CacheLookup
	List<WebElement> REMOVE_ALL;
	
	@FindBy(css = "span.shopping_cart_badge")
	@CacheLookup
	WebElement LBL_CARTBADGE;
	
	@FindBy(id = "react-burger-menu-btn")
	@CacheLookup
	WebElement LNK_HAMBURGERMENU;
	
	//Action Methods
	
	public void clickCheckout() {
		BTN_CHECKOUT.click();
		logger.info("Clicked on Checkout buton");
	}
	
	public void clickContinueShopping() {
		BTN_CONTINUESHOPPING.click();
		logger.info("Clicked on Continue Shopping button");
	}
	
	public void clickRemove() {
		BTN_REMOVE.click();
		logger.info("Clicked on Remove Button");
	}
	
	public void removeAllProducts() {
		for(WebElement button: REMOVE_ALL) {
			button.click();
		}
		
		logger.info("Removed all products from cart");
	}
	
	public int getListOfProductsAdded() {
		logger.info("Fetched list of products present on Your Cart page");
		return LBL_LISTOFPRODUCTS.size();
	}
	
	public void removeSpecificProductFromCart(String product) {
		driver.findElement(By.xpath("//div[@class='cart_item_label']/a/div[text()='"+product+"']/../following-sibling::div[2]/button")).click();
		logger.info("Removed "+product+" from cart");
	}
	
	public int getCountOfProductsAdded() {
		String count =LBL_CARTBADGE.getText();
		logger.info(count+" products present in cart");
		return Integer.parseInt(count);
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
