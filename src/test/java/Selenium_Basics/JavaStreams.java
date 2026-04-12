package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(1200);
        driver.findElement(By.cssSelector("th[role='columnheader'] .sort-icon.sort-descending")).click();
        Thread.sleep(800);
        /* Here the below lines of code extracts the web elements using the xpath the using java
        streams it gets the web elements text and stores in List then it is sorted*/

        List<WebElement> actualList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = actualList.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(originalList.equals(sortedList));
        softAssert.assertAll();
        List<String> price;

        // scan the name column with getText ->Beans->print the price of the Rice
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(JavaStreams::getPriceVeggie).collect(Collectors.toList());
            price.forEach(System.out::println);
            if (price.isEmpty()) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }

        } while (price.isEmpty());
    }

    private static String getPriceVeggie(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
