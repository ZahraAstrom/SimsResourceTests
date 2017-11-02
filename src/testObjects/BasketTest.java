package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flowObjects.BasketFlow;
import flowObjects.HomepageFlow;

public class BasketTest {
	

	WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser", "username", "password"})
	public void setUp(String browser, String username, String password ) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			//Create a new instance of the Chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zee\\Documents\\Selenium Projects\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Browser is not correct.");
		}
		
		driver.get("https://www.thesimsresource.com");
		System.out.println("Before login method");
		HomepageFlow.logIn(driver, username, password);
		BasketFlow.emptyBskt(driver);
	}
	
	@Test
	public void doesNothing() {
		
	}
	

}
