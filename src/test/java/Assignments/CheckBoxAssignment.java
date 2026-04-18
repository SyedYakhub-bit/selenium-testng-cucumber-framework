package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxAssignment {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption1")).click(); // Check
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click(); // Uncheck
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		System.out.println("There are " + driver.findElements(By.cssSelector("input[id*='checkBoxOption']")).size()
				+ " Checkboxes");
		driver.quit();

	}
}
