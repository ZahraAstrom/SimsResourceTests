package flowObjects;

import org.openqa.selenium.WebDriver;

import pageObjects.HomepagePage;

public class HomepageFlow {
	
	public static void logIn(WebDriver driver, String username, String password) {
		
		System.out.println("We're here...");
		HomepagePage.homeLogInBtn(driver).click();
		HomepagePage.emailInputField(driver).sendKeys(username);
		HomepagePage.passwordInputField(driver).sendKeys(password);
		HomepagePage.clickHereLogIn(driver).click();	
	}
	
	

}
