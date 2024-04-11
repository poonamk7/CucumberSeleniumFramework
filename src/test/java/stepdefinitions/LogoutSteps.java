package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutCompletePage;
import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutYourInformationPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class LogoutSteps extends BaseClass {
	
	@When("I click on Hamburger menu from Products page")
	public void i_click_on_Hamburger_menu_from_Products_page() {
		productsPage = new ProductsPage(driver);
		productsPage.clickHamBurgerMenu();
	}
	
	@When("I click on Logout link")
	public void i_click_on_logout_link() {
		productsPage = new ProductsPage(driver);
		productsPage.clickLogout();
	}
	
	@When("I click on Hamburger menu from Your Cart page")
	public void i_click_on_hamburger_menu_from_yourcart_page() {
		cartPage = new YourCartPage(driver);
		cartPage.clickHamBurgerMenu();
	}
	
	@When("I click on Hamburger menu from Checkout Your Information page")
	public void i_click_on_hamburger_menu_from_checkoutYourInformation_page() {
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutYourInformationPage.clickHamBurgerMenu();
	}
	
	@When("I click on Hamburger menu from Checkout Overview page")
	public void i_click_on_hamburger_menu_from_checkoutOverview_page() {
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutOverviewPage.clickHamBurgerMenu();
	}
	
	@When("I click on Hamburger menu from Checkout Complete page")
	public void i_click_on_hamburger_menu_from_checkoutComplete_page() {
		checkoutCompletePage = new CheckoutCompletePage(driver);
		checkoutCompletePage.clickHamBurgerMenu();
	}
	
	@When("I click on Logout link from Your Cart page")
	public void i_click_on_logout_link_from_yourcart_page() {
		cartPage = new YourCartPage(driver);
		cartPage.clickLogout();
	}
	
	@When("I click on Logout link from Checkout Your Information page")
	public void i_click_on_logout_link_from_checkoutYourInformation_page() {
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutYourInformationPage.clickLogout();
	}
	
	@When("I click on Logout link from Checkout Overview page")
	public void i_click_on_logout_link_from_checkoutOverview_page() {
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutOverviewPage.clickLogout();
	}
	
	@When("I click on Logout link from Checkout Complete page")
	public void i_click_on_logout_link_from_checkoutComplete_page() {
		checkoutCompletePage = new CheckoutCompletePage(driver);
		checkoutCompletePage.clickLogout();
	}
	
	@Then("I am logged out of Sauce Demo page")
	public void i_am_logged_out_of_saucedemo_page() {
		loginPage = new LoginPage(driver);
		String actPageHeader =loginPage.getPageHeader();
		Assert.assertEquals("Swag Labs", actPageHeader);
		
	}

	
}
