package TestClasses.AbstractComponents;

import Framework.PageObjects.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartButton;


    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToTopOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }
}
