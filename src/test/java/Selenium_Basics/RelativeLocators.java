package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.cssSelector(".form-group input[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());
        WebElement dateOfBirth=driver.findElement(By.xpath("//label[text()='Date of Birth']"));
        WebElement dateValue=driver.findElement(with(By.cssSelector("input[name='bday']")).below(dateOfBirth));
        Thread.sleep(2000);
        dateValue.clear();
        Thread.sleep(1200);
        dateValue.sendKeys("23-12-2018");
        Thread.sleep(1700);
        driver.findElement(with(By.cssSelector("input[type='submit']"))).click();
        Thread.sleep(2000);
        WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        Thread.sleep(1200);
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
        Thread.sleep(1200);
        WebElement rdb = driver.findElement(By.id("inlineRadio1"));
        Thread.sleep(1200);
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
        driver.quit();
    }
}
