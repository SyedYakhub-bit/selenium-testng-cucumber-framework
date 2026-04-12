package TestClasses;

import TestComponents.BaseTest;
import Framework.PageObjects.CartPage;
import Framework.PageObjects.CheckOutPage;
import Framework.PageObjects.ConfirmMessage;
import Framework.PageObjects.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SubmitOrderTest extends BaseTest {
    @Test
    public void submitOrder() throws InterruptedException{
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshettyacademysyed@gmail.com", "Syed#2000");
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
        tearDown();

    }
}
