package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTables {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		WebElement subDriver = driver.findElement(By.id("product"));
		System.out.println("The number of rows are: " + subDriver.findElements(By.tagName("tr")).size());
		System.out
				.println("The number of columns are: " + subDriver.findElements(By.cssSelector("tbody tr th")).size());
		System.out.println("The Content of second row is: "
				+ subDriver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		driver.quit();
	}
}
