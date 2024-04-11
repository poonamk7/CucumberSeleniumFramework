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
import org.openqa.selenium.support.ui.Select;

import enums.WaitType;
import pageObjects.pageComponents.HamburgerMenuComponent;
import utilities.WaitHelper;

public class ProductsPage  {

	private WebDriver driver;
	private HamburgerMenuComponent hamburgerMenuComponent;
	
	private static final Logger logger = LogManager.getLogger(ProductsPage.class);
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		hamburgerMenuComponent = new HamburgerMenuComponent(driver); // composite concept
	}
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	@CacheLookup
	WebElement BTN_ADDTOCART;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	@CacheLookup
	List<WebElement> BTN_ALLITEMS;
	
	@FindBy(xpath = "//button[text()='Remove']")
	@CacheLookup
	WebElement BTN_REMOVE;
	
	@FindBy(xpath = "//button[text()='Remove']")
	@CacheLookup
	List<WebElement> BTN_REMOVEALLITEMS;
	
	@FindBy(css = "a.shopping_cart_link")
	@CacheLookup
	WebElement LBL_CART;
	
	@FindBy(css = "span.shopping_cart_badge")
	@CacheLookup
	WebElement LBL_CARTBADGE;
	
	@FindBy(css = "select.product_sort_container")
	@CacheLookup
	WebElement DRPDWN_SORT;
	
	@FindBy(id = "react-burger-menu-btn")
	@CacheLookup
	WebElement LNK_HAMBURGERMENU;
	
	//action methods
	
	public void addAllProductsToCart() {
		for(WebElement button : BTN_ALLITEMS) {
			WaitHelper.waitUntil(driver, button, 3, WaitType.CLICAKBLE);
			button.click();
		}
		logger.info("Added all products to cart");
	}
	
	public void removeAllProductsFromCart() {
		for(WebElement button : BTN_REMOVEALLITEMS) {
			button.click();
		}
		logger.info("Removed all products to cart");
	}
	
	public void addProductToCart() {
//		BTN_ADDTOCART.click();
		logger.info("Clicked on Add to cart button");
	}
	
	public void removeProductFromCart() {
		BTN_REMOVE.click();
		logger.info("Clicked on Remove button");
	}
	
	public void clickOnCart() {
//		WaitHelper.waitUntil(driver, LBL_CART, 3, WaitType.CLICAKBLE);
		LBL_CART.click();
		logger.info("Clicked on Cart icon");
	}
	
	public int getNoOfProductsAddedToCart() {
		String count =LBL_CARTBADGE.getText();
		logger.info("Fetched count of products added to the cart");
		return Integer.parseInt(count);
	}
	
	public void sortProducts(String option) {
			Select select = new Select(DRPDWN_SORT);
			select.deselectByVisibleText(option);
			logger.info("Sorted products available on Products page");
	}
	
	public void addSpecificProductToCart(String productName) {
		driver.findElement(By.xpath("//div[@class='inventory_item_description']/div/a/div[text()='"+productName+"']/../../following-sibling::div/button[text()='Add to cart']")).click();
		logger.info("Added "+productName+" to cart");
	}
	
	public void removeSpecificProductToCart(String productName) {
		driver.findElement(By.xpath("//div[@class='inventory_item_description']/div/a/div[text()='"+productName+"']/../../following-sibling::div/button[text()='Remove']")).click();
		logger.info("Removed "+productName+" from cart");
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
