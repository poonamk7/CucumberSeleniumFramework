package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class RemoveProductsfromCartSteps extends BaseClass {
	
	
	@When("I remove all products from cart")
	public void i_remove_all_products_from_cart() {
		productsPage = new ProductsPage(driver);
		productsPage.removeAllProductsFromCart();
	}
	
	@When("I remove specific products from cart")
	public void i_remove_specific_products_from_cart(DataTable table) {
		productsPage = new ProductsPage(driver);
		List<Map<String,String>> map =table.asMaps(String.class, String.class);
		for(Map<String,String> list :map) {
			String product =list.get("products");
			productsPage.removeSpecificProductToCart(product);
		}
	}
	
	@When("I remove specific products from Your Cart page")
	public void i_remove_specific_products_from_yourCart_page(DataTable table) {
		cartPage = new YourCartPage(driver);
		List<Map<String,String>> map =table.asMaps(String.class, String.class);
		for(Map<String,String> list :map) {
			String product =list.get("products");
		cartPage.removeSpecificProductFromCart(product);
		}
	}
	
	@When("I remove all products from Your Cart page")
	public void i_remoe_all_products_from_yourCart_page() {
		cartPage = new YourCartPage(driver);
		cartPage.removeAllProducts();
	}
	
	@Then("I see total {int} items are present in the cart")
	public void totalItemsPresentInCart(int expCount) {
		cartPage = new YourCartPage(driver);
		int actCount =cartPage.getListOfProductsAdded();
		Assert.assertEquals(expCount, actCount);
	}

}
