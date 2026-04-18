package Selenium_Basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// The below code uses JavascriptExecutor to scroll down on page based on given
		// value here(0,500)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(2000);
		// The Below line of code is used to scroll down within a table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		driver.quit();
	}
}
