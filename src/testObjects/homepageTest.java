package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flowObjects.homepageFlow;
import pageObjects.homepagePage;

public class homepageTest {
	
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
		
		homepageFlow.logIn(driver, username, password);
		
		Assert.assertTrue(homepagePage.loggedIn(driver).isDisplayed());
		
		//Close the Window
		driver.quit();
		
	}
	

}
