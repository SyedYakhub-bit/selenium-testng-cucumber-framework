package TestClasses;

import Framework.PageObjects.CartPage;
import Framework.PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.RetryFailedCases;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ErrorValidationTest extends BaseTest {
	@Test(retryAnalyzer = RetryFailedCases.class)
	public void loginErrorValidation() {
		landingPage.loginApplication("rahulshettyacademysyed@gmail.com", "Syed#200");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
	}

	@Test(groups = {"ErrorHandling"})
	public void productNameErrorValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshettyacademysyed@gmail.com",
				"Syed#2000");
		List<WebElement> products = productCatalogue.getProductList();
		System.out.println(products);
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyCartProducts(productName);
		Assert.assertTrue(match);
	}
}
