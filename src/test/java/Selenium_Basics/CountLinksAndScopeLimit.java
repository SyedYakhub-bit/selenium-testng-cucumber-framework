package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinksAndScopeLimit {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// Gives us the Count of total links present in a page
		System.out.println("Number of Links present in Whole page is :" + driver.findElements(By.tagName("a")).size());
		// Gives the Count of Links present in the footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out
				.println("Number of Links present in footer are " + footerDriver.findElements(By.tagName("a")).size());
		driver.quit();

	}
}
