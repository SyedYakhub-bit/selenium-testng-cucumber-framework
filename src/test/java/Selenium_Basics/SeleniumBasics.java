package Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumBasics {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/"));
        driver.manage().window().maximize();
        // Fetch browser console logs
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logs) {
            System.out.println("Log Level: " + log.getLevel());
            System.out.println("Message: " + log.getMessage());
        }
        Thread.sleep(2000);
        System.out.println("The title of the website is "+driver.getTitle());
        System.out.println("The URL of the website is "+driver.getCurrentUrl());
        driver.quit();

    }
}
