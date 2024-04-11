package hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepdefinitions.BaseClass;

public class Hooks extends BaseClass {
	
	@Before
	public void setUp() {
		
		threadLocal = new ThreadLocal<WebDriver>();
		
		properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String browser = properties.getProperty("browser");
		if(browser.equals("chrome"))
			driver = new ChromeDriver();
		else if(browser.equals("edge"))
			driver = new EdgeDriver();
		else if(browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			throw new IllegalArgumentException("Please provide valid browser name!");
		
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(properties.getProperty("timeout"))));	
		
		threadLocal.set(driver);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
