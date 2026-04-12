package Selenium_Basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EightyEightFortunesStatic {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://ogs-gcm-eu-dev.nyxop.net/gcm-lobby/launch.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("sessionid")).clear();
        driver.findElement(By.id("sessionid")).sendKeys("Test_Syed3");
        driver.findElement(By.id("gamename")).clear();
        driver.findElement(By.id("gamename")).sendKeys("500109");
        driver.findElement(By.id("opid")).clear();
        driver.findElement(By.id("opid")).sendKeys("59");
        WebElement gameMode = driver.findElement(By.id("gamemode"));
        Select gameModeDropDown = new Select(gameMode);
        gameModeDropDown.selectByVisibleText("Real");
        WebElement device = driver.findElement(By.id("device"));
        Select deviceDropDown = new Select(device);
        deviceDropDown.selectByValue("desktop");
        WebElement currencyDropDown = driver.findElement(By.id("currency"));
        Select currency = new Select(currencyDropDown);
        currency.selectByValue("USD");
        WebElement environmentDropDown = driver.findElement(By.id("environment"));
        Select environment = new Select(environmentDropDown);
        environment.selectByVisibleText("OGS RGS QA");
        driver.findElement(By.id("launchGameButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("gameIFrame")));
        WebElement canvas = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("canvas.game-canvas")));
        Thread.sleep(8000);
        Actions actions = new Actions(driver);
        actions.moveToElement(canvas, 0, 224).click().perform();
        Thread.sleep(2000);
       // driver.quit();
    }
}
