package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i = 0;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int j = 0; j <= 2; j++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(1350);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
