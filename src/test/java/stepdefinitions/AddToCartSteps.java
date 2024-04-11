package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductsPage;

public class AddToCartSteps extends BaseClass{
	
	@When("I add all products to cart")
	public void i_add_all_products_to_cart() {
		productsPage = new ProductsPage(driver);
		productsPage.addAllProductsToCart();
	}
	
	@When("I add specific products to cart")
	public void i_add_specific_products_to_cart(DataTable table) {
		productsPage = new ProductsPage(driver);
		List<Map<String,String>> map =table.asMaps(String.class, String.class);
		for(Map<String, String> header : map) {
			String product =header.get("products");
			productsPage.addSpecificProductToCart(product);
		}
	}
	
	
	@Then("I see total {int} items are added to cart")
	public void i_see_total_6_items_are_added_to_cart(int total) {
		int count =productsPage.getNoOfProductsAddedToCart();
		Assert.assertEquals(count, total);
	}


}
