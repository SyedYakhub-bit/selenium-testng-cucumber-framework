package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AssignmentWaits {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("label.customradio input[value='user'] +span[class='checkmark']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement userType = driver.findElement(By.cssSelector("select.form-control"));
		Select dropDown = new Select(userType);
		dropDown.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> numberOfElements = driver.findElements(By.xpath("//button[contains(@class,'btn-info')]"));
		for (int i = 0; i < numberOfElements.size(); i++) {
			driver.findElements(By.xpath("//button[contains(@class,'btn-info')]")).get(i).click();

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class*='btn-primary']")));
		driver.findElement(By.cssSelector("a[class*='btn-primary']")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class*='dismissible']")).getText());
		driver.quit();
	}
}
