package TestClasses;

import Framework.PageObjects.*;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class HashMapTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		System.out.println(products);
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyCartProducts(productName);
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("India");
		ConfirmMessage confirmMessage = checkOutPage.submitOrder();
		String confirmationMessage = confirmMessage.getConfirmMessageText();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshettyacademysyed@gmail.com",
				"Syed#2000");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> hashMap1 = new HashMap<>();
		hashMap1.put("email", "rahulshettyacademysyed@gmail.com");
		hashMap1.put("password", "Syed#2000");

		HashMap<String, String> hashMap2 = new HashMap<>();
		hashMap2.put("email", "yakhub.1si19ee057@gmail.com");
		hashMap2.put("password", "Yakhub@12345");
		return new Object[][]{{hashMap1}, {hashMap2}};
	}
}
