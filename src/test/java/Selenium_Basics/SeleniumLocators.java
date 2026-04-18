package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		/*
		 * this line helps in waiting for 5 seconds until the web elements are loaded so
		 * that selenium doesn't fail with unable to locate element
		 */
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys("syedyakhub11102000@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("abc123");
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Syed");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("6383892992");
		driver.findElement(By.cssSelector("div button:nth-of-type(2)")).click();
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("syedyakhub11102000@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1500);
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']")).getText());
		driver.quit();

	}
}
