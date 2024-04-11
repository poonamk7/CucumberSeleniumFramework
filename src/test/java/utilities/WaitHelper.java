package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.WaitType;

public class WaitHelper {
	
	public static void waitUntil(WebDriver driver,WebElement element, long timeOutInSeconds, WaitType waitType) {
		if(waitType == WaitType.CLICAKBLE) {
			WaitHelper.waitForElementToBeClickable(driver, element, timeOutInSeconds).click();;
		}
		
		else if(waitType == WaitType.VISIBLE) {
			WaitHelper.waitForElementToBeVisible(driver, element, timeOutInSeconds).click();
		}
		
	}
	
	
	public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	public static WebElement waitForElementToBeVisible(WebDriver driver,WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));		
	}

}
