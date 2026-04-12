package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ParentChildWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/documents-request']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        String text = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
        System.out.println(text);
        String[] parts = text.split("at");
        String email = parts[1].trim().split(" ")[0];
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
        driver.quit();


    }
}
