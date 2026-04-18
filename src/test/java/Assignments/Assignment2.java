package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.name("name")).sendKeys("Syed Yakhub");
		driver.findElement(By.name("email")).sendKeys("syedyakhub11102000@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password");
		driver.findElement(By.id("exampleCheck1")).click();
		System.out.println(driver.findElement(By.id("exampleCheck1")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(genderDropdown);
		gender.selectByVisibleText("Female");
		driver.findElement(By.xpath("//div[@class='form-check form-check-inline'] //input[@id='inlineRadio1']"))
				.click();
		driver.findElement(By.name("bday")).sendKeys("12-01-2025");
		Thread.sleep(3700);
		driver.findElement(By.cssSelector(".btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		driver.quit();
	}
}
