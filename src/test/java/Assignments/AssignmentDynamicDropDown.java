package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AssignmentDynamicDropDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        Thread.sleep(2000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        driver.quit();

    }
}
