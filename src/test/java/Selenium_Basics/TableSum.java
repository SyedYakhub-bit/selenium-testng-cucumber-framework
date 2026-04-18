package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class TableSum {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		int sum = 0;
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for (WebElement value : values) {
			int amountValue = Integer.parseInt(value.getText());
			sum = sum + amountValue;
		}
		String amountText = driver.findElement(By.xpath("//div[text()=' Total Amount Collected: 296 ']")).getText();
		int actualAmount = Integer.parseInt(amountText.split(" ")[3].trim());
		Assert.assertEquals(sum, actualAmount);
		System.out.println("Calculated amount is: " + sum + " and actual amount is: " + sum);
		driver.quit();

	}
}
