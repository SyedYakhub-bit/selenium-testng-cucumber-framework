package TestClasses;

import Framework.PageObjects.CartPage;
import Framework.PageObjects.CheckOutPage;
import Framework.PageObjects.ConfirmMessage;
import Framework.PageObjects.ProductCatalogue;
import Framework.Utilities.DataReader;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderJSONTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException {

		// input.get("email") and input.get("password") come from the JSON file
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Assert.assertTrue(cartPage.verifyCartProducts(productName));

		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("India");
		ConfirmMessage confirmMessage = checkOutPage.submitOrder();

		Assert.assertTrue(confirmMessage.getConfirmMessageText().equalsIgnoreCase("Thankyou for the order."));
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		// Step 1: Create DataReader instance
		DataReader dataReader = new DataReader();

		// Step 2: Read JSON → gives List of HashMap and Each HashMap = one row = {
		// "email": "...", "password": "..." }
		List<HashMap<String, String>> data = dataReader
				.getJsonData("\\src\\main\\java\\Framework\\Resources\\submitOrder.json");

		// Step 3: Convert List into Object[][] that TestNG DataProvider expects
		Object[][] obj = new Object[data.size()][1];
		for (int i = 0; i < data.size(); i++) {
			obj[i][0] = data.get(i); // each row gets one HashMap object
		}
		return obj;
	}
}
