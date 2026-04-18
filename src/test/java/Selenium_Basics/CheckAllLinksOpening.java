package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Set;

public class CheckAllLinksOpening {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
		System.out.println("Number of Links present in footer are " + footerLinks.size());
		for (WebElement footerLink : footerLinks) {
			// open each tab in new Chrome tab
			String newTabOpening = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerLink.sendKeys(newTabOpening);
			Thread.sleep(5000);
		}
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}
}
