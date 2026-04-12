package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DisablePopUps {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://webcamtests.com/check");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("webcam-launcher")));
        driver.findElement(By.id("webcam-launcher")).click();
        Thread.sleep(2500);
        driver.quit();
    }
}
