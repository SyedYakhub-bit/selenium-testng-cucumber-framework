package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;



public class FluentWaits {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.cssSelector("div button")).click();
        //Fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) // Total timeout
                .pollingEvery(Duration.ofSeconds(2)) // Check every 2 seconds
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException

        WebElement finishElement = fluentWait.until(driver1 -> {
            WebElement element = driver1.findElement(By.cssSelector("div[id='finish'] h4"));
            if (element.isDisplayed()) {
                return element; // Return the element when it becomes visible
            }
            return null; // Continue waiting if not visible
        });
        System.out.println(finishElement.getText());
        System.out.println("Code executed successfully");
        driver.quit();
    }
}

