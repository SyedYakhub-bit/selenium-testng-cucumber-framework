package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        WebElement fromLocation=driver.findElement(By.xpath("//a[@value='BLR']"));
        System.out.println("From Location is "+fromLocation.getText());
        Thread.sleep(1500);
        //driver.findElement(By.xpath("(//a[text()=' Chennai (MAA)'])[2]")).click();
        WebElement toLocation=driver.findElement(By.xpath("(//a[text()=' Chennai (MAA)'])[2]"));
        System.out.println("To Location is "+toLocation.getText());
        /* The below line gives us the Xpath of Parent to Child transverse */
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(800);
        driver.quit();
    }
}
