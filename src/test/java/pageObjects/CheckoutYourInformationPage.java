package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import pageObjects.pageComponents.HamburgerMenuComponent;

public class CheckoutYourInformationPage {

	private WebDriver driver;
	private Faker faker;
	private HamburgerMenuComponent hamburgerMenuComponent;

	private static final Logger logger = LogManager.getLogger(CheckoutYourInformationPage.class);

	public CheckoutYourInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		hamburgerMenuComponent = new HamburgerMenuComponent(driver);
	}

	@FindBy(id = "first-name")
	@CacheLookup
	WebElement TXT_FIRSTNAME;

	@FindBy(id = "last-name")
	@CacheLookup
	WebElement TXT_LASTNAME;

	@FindBy(id = "postal-code")
	@CacheLookup
	WebElement TXT_POSTALCODE;

	@FindBy(id = "continue")
	@CacheLookup
	WebElement BTN_CONTINUE;

	@FindBy(id = "cancel")
	@CacheLookup
	WebElement BTN_CANCEL;

	@FindBy(xpath = "//div[contains(@class,'error-message')]/h3")
	@CacheLookup
	WebElement LBL_ERRORMESSAGE;

	@FindBy(xpath = "//div[contains(@class,'error-message')]/h3/button")
	@CacheLookup
	WebElement BTN_ERROR;
	
	@FindBy(id = "react-burger-menu-btn")
	@CacheLookup
	WebElement LNK_HAMBURGERMENU;

	// Action methods

	public void enterFirstname() {
		faker = new Faker();
		String firstname = faker.name().firstName();
		TXT_FIRSTNAME.clear();
		TXT_FIRSTNAME.sendKeys(firstname);
		logger.info("Entered firstname " + firstname);
	}

	public void enterLastname() {
		faker = new Faker();
		String lastname = faker.name().lastName();
		TXT_LASTNAME.clear();
		TXT_LASTNAME.sendKeys(lastname);
		logger.info("Entered lastname " + lastname);
	}

	public void enterPostalCode() {
		faker = new Faker();
		String postalCode = faker.address().zipCode();
		TXT_POSTALCODE.clear();
		TXT_POSTALCODE.sendKeys(postalCode);
		logger.info("Entered postal code " + postalCode);
	}
	
	public void clickContinue() {
		BTN_CONTINUE.click();
		logger.info("Clicked on Continue button");
	}
	
	public void clickCancel() {
		BTN_CANCEL.click();
		logger.info("Clicked on Cancel button");
	}
	
	public String getErrorMessage() {
		logger.info("Error message displayed");
		return LBL_ERRORMESSAGE.getText();
	}
	
	public void clickErrorCrossButton() {
		BTN_ERROR.click();
		logger.info("Cross button for Error message is clicked");
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
