package stepdefinitions;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CheckoutCompletePage;
import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutYourInformationPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class BaseClass {
	
	protected static WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	YourCartPage cartPage;
	CheckoutYourInformationPage checkoutYourInformationPage;
	CheckoutOverviewPage checkoutOverviewPage;
	CheckoutCompletePage checkoutCompletePage;
	static Logger logger;
	protected Properties properties;
	protected static ThreadLocal<WebDriver> threadLocal;
}
