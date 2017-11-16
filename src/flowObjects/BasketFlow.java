package flowObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	//Adds item or item set to basket
	public static void addToBskt (WebDriver driver) {
		BasketPage.addShortToBasketBtn(driver).click();
	}
	
	public static List<String> itemSets (WebDriver driver) {
		BasketPage.setCreationsTab(driver).click();
		
		List<String> itemIDList = new ArrayList<String>();
		List<WebElement> setItems = BasketPage.setItems(driver);
		
		//Iterating over web elements in setItems, pulling the ID numbers and adding them to the itemIDList string list
		for (int i = 0; i < setItems.size(); i++) {
			Pattern findID = Pattern.compile("\\d*(?=/$)", Pattern.MULTILINE);
			Matcher iD = findID.matcher(setItems.get(i).getAttribute("href"));
			iD.find();
			itemIDList.add(iD.group());
		}
		return itemIDList;
	}
	
	public static HashMap<String, String> getItemsInBskt (WebDriver driver) {
		BasketPage.basketBtn(driver).click();
		HashMap<String, String> itemsInBsktMap = new HashMap<String, String>();
		List<WebElement> itemsInBskt = BasketPage.itemsInBskt(driver);
		
		for (int i = 0; i < itemsInBskt.size(); i++) {
			Pattern findID = Pattern.compile("\\d*$", Pattern.MULTILINE);
			Matcher iD = findID.matcher(itemsInBskt.get(i).getAttribute("id"));
			iD.find();
			itemsInBsktMap.put(iD.group(), "");
		}
		return itemsInBsktMap;
	}

}
