package Framework.PageObjects;

import TestClasses.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;
    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getProductList() {
        waitForElementToBeVisible(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return getProductList().stream().filter(p -> p.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void addProductToCart(String productName) throws InterruptedException {
        WebElement product = getProductByName(productName);
        product.findElement(addToCart).click();
        scrollToBottomOfThePage();
        waitForElementToBeVisible(toastMessage);
        Thread.sleep(1200);
    }
}
