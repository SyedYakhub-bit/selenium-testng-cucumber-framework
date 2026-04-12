package Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPCertificateErrors {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.quit();

}
}
