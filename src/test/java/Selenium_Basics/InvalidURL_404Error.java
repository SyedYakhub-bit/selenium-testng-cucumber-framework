package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class InvalidURL_404Error {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement links : footerLinks) {
            String url = links.getAttribute("href");
            //Below code is to get the status code of the apis
            assert url != null;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            softAssert.assertTrue(responseCode <= 400, "There is broken link: " + url + " with response code as " + responseCode);
        }
        softAssert.assertAll();
        driver.quit();
    }
}
