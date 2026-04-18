package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ECommerce {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Input: Items to add to the cart
		String[] itemsNeeded = {"Cucumber", "Carrot", "Beetroot", "Tomato"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.quit();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
		int j = 0;
		// Convert an array to List for easy lookup
		List<String> itemsNeededList = Arrays.asList(itemsNeeded);
		for (int i = 0; i < products.size(); i++) {
			// Extract product name and format it
			String productName = products.get(i).getText().split("-")[0].trim();
			if (itemsNeededList.contains(productName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == itemsNeededList.size()) {
					break;
				}
			}
		}
		System.out.println(itemsNeededList.size() + " number of items are added to the list");
	}
}
