package Framework.PageObjects;

import TestClasses.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    By myCart = By.xpath("//h1[text()='My Cart']");


    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkOutElement;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCartProducts(String productName) {
        waitForElementToBeVisible(myCart);
        return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckOutPage goToCheckOut() {
        checkOutElement.click();
        return new CheckOutPage(driver);
    }
}
