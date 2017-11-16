package testObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flowObjects.BasketFlow;
import flowObjects.HomepageFlow;
import pageObjects.BasketPage;

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
		HomepageFlow.logIn(driver, username, password);
		BasketFlow.emptyBskt(driver);
	}
	
	@Test
	public void addAllToBskt() {
		String itemID = "1394698";
		driver.get("http://www.thesimsresource.com/downloads/" + itemID);
		List<String> itemSets = BasketFlow.itemSets(driver);
		BasketFlow.addToBskt(driver);
		HashMap<String, String> getItemsInBskt = BasketFlow.getItemsInBskt(driver);
		
		for (int i = 0; i < itemSets.size(); i++) {
			Assert.assertTrue(getItemsInBskt.containsKey(itemSets.get(i)));
		}
	}
	
	@Test
	public void addOneToBskt() {
		String itemID = "1285493";
		driver.get("http://www.thesimsresource.com/downloads/" + itemID);
		BasketFlow.addToBskt(driver);
		BasketPage.basketBtn(driver).click();
		Assert.assertTrue(BasketPage.itemInBasket(driver, itemID).isDisplayed());	
	}

	

}
