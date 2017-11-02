package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
	
	private static WebElement waitToClick(WebDriver driver, By locator) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement addToBasketBtn(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("a.button.button-green.bsk.bskon"));
	}
	
	public static WebElement basketBtn(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("li.has-basket"));
	}
		
	public static WebElement tempusHair(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("div#basketitem_1393202"));
	}
	
	public static WebElement removeAllBtn(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("form#basketFormDownloadRemoveAll"));
	}
	
	public static WebElement basket(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("div.md-body#md-content"));
	}
	
	public static WebElement closeBasketX(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("div.md-modal.md-effect-1.md-show a.icon-close.md-close"));
	}
	
	public static WebElement basketCount(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("span#basketnr"));
	}
	
	public static Alert alertPresent(WebDriver driver) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.alertIsPresent());
	}
}
