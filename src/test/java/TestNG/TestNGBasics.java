package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestNGBasics {

    @Test
    public void runUsingTestNG() {
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/guide/relative-locators-in-selenium");
        driver.quit();

    }
    @Test
    public void secondTest(){

        System.out.println("Sample Second Test case for Checking");
    }
}
