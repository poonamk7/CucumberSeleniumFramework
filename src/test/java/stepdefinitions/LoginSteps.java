package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps extends BaseClass{

	
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("I click on Login button")
	public void i_click_on_login_button() {
		loginPage.clickLogin();
	}

	@Then("I am logged in successfully and page title should be {string}")
	public void i_am_logged_in_successfully(String title) {

		Assert.assertEquals(driver.getTitle(), title);
		driver.quit();
	}

}
