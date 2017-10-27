package flowObjects;

import org.openqa.selenium.WebDriver;

import pageObjects.homepagePage;

public class homepageFlow {
	
	public static void logIn(WebDriver driver, String username, String password) {
		
		homepagePage.homeLogInBtn(driver).click();
		homepagePage.emailInputField(driver).sendKeys(username);
		homepagePage.passwordInputField(driver).sendKeys(password);
		homepagePage.clickHereLogIn(driver).click();	
	}
	
	

}
