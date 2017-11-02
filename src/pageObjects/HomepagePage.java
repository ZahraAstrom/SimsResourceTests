package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePage {
		
	private static WebElement waitToClick(WebDriver driver, By locator) {
		return new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement homeLogInBtn(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("div#nav-wrap a.md-trigger.loginBtn"));
	}
	
	public static WebElement emailInputField(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("input#loginEmail.text-field"));
	}
	
	public static WebElement passwordInputField(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("input#fldPasswordL.text-field"));
	}
	
	public static WebElement clickHereLogIn(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("input#loginbtn.loginbtn.input-button.button-300"));
	}
	
	public static WebElement loggedIn(WebDriver driver) {
		return waitToClick(driver, By.cssSelector("li.account.logged-in-account"));
	}
		

}
