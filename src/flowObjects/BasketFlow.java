package flowObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.BasketPage;

public class BasketFlow {
	
	//This will be called before each basket test so we start with an empty basket
	public static void emptyBskt (WebDriver driver) {
		
		BasketPage.basketBtn(driver).click();
		if (!BasketPage.basket(driver).getText().contains("Your Download Basket is empty!")) {
			BasketPage.removeAllBtn(driver).click();
			BasketPage.alertPresent(driver);
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();	
		}
		
		BasketPage.closeBasketX(driver).click();
		Assert.assertTrue(BasketPage.basketCount(driver).getText().contains("0"));
	}
	
	
	

}
