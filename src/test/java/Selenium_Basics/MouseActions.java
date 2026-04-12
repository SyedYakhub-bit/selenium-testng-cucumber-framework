package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
        Thread.sleep(1200);
        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
        Thread.sleep(1300);
        actions.moveToElement(driver.findElement(By.id("nav-search-submit-button"))).contextClick().perform();
        Thread.sleep(1090);
        driver.quit();


    }
}
