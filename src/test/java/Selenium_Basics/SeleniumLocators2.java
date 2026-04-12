package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumLocators2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        /* this line helps in waiting for 5 seconds until
        the web elements are loaded so that selenium doesn't fail with unable to locate element */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        String password=getPassword(driver);
        System.out.println(password);
        driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        driver.findElement(By.id("inputUsername")).sendKeys("syedyakhub11102000@gmail.com");
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(1500);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.quit();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
        String passwordString=driver.findElement(By.cssSelector("p.infoMsg")).getText();
        String[] passwordArray= passwordString.split("'");
        return passwordArray[1].split("'")[0];

    }
}
