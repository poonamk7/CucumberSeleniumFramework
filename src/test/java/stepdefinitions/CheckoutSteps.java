package stepdefinitions;

import org.junit.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutCompletePage;
import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutYourInformationPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class CheckoutSteps extends BaseClass{
	
	@When("I click on cart icon")
	public void i_click_on_cart_icon() {
		productsPage = new ProductsPage(driver);
		productsPage.clickOnCart();
	}
	
	@When("I click on Checkout button")
	public void i_click_on_Checkout_button() {
		cartPage = new YourCartPage(driver);
		cartPage.clickCheckout();
	}
	
	@When("I provide details on Your Information page")
	public void i_provide_details_on_your_information_page_and_click_on_Continue_button() {
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutYourInformationPage.enterFirstname();
		checkoutYourInformationPage.enterLastname();
		checkoutYourInformationPage.enterPostalCode();
		
	}
	
	
	@When("I click on Continue button")
	public void i_click_on_continue_button() {
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutYourInformationPage.clickContinue();
	}
	
	@When("I click Finish button on Overview screen")
	public void i_click_finish_button_on_overview_screen() {
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutOverviewPage.clickFinish();
	}
	
	@When("I provide First name")
	public void i_provide_firstname() {
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutYourInformationPage.enterFirstname();
	}
	
	@When("I provide Last name")
	public void i_provide_lastname() {
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutYourInformationPage.enterLastname();
	}
	
	@When("I provide Postal code")
	public void i_provide_postal_code() {
		checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
		checkoutYourInformationPage.enterPostalCode();
	}
	
	@Then("I see successful order message on page")
	public void i_see_successful_order_message_on_page() {
		checkoutCompletePage = new CheckoutCompletePage(driver);
		String message =checkoutCompletePage.getOrderMessage();
		Assert.assertEquals(message, "Thank you for your order!");
	}
	
	@Then("I see validation message {string}")
	public void i_see_validation_message(String expErrorrMsg) {
		String actErrorMessage=checkoutYourInformationPage.getErrorMessage();
		Assert.assertEquals(expErrorrMsg, actErrorMessage);
	}
	
	@Then("I am navigated to {string} page")
	public void i_am_navigated_to_page(String expHeader) {
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		String actHeader =checkoutOverviewPage.getPageHeader();
		Assert.assertEquals(expHeader, actHeader);
	}

}
