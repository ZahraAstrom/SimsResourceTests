package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flowObjects.HomepageFlow;
import pageObjects.HomepagePage;

public class HomepageTest {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			//Create a new instance of the Chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zee\\Documents\\Selenium Projects\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Browser is not correct.");
		}
	}
	
	@Parameters({"username", "password"})
	@Test
	public void logIn(String username, String password) {
		
		//Launch the site
		driver.get("https://www.thesimsresource.com");
		
		HomepageFlow.logIn(driver, username, password);
		
		Assert.assertTrue(HomepagePage.loggedIn(driver).isDisplayed());
		
		//Close the Window
		driver.quit();
		
	}
	

}
