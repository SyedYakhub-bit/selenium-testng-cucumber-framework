package TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        String productName = "ZARA COAT 3";
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("prefs", Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("userEmail")).sendKeys("rahulshettyacademysyed@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Syed#2000");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        Thread.sleep(2000);
        WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".card-body button:last-of-type")));
        assert prod != null;
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        Thread.sleep(1200);
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(1200);
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Select Country']")), "India").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

        driver.quit();
    }
}
