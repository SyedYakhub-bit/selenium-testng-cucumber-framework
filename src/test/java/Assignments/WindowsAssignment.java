package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsAssignment {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Multiple Windows']")));
		driver.findElement(By.partialLinkText("Windows")).click();
		driver.findElement(By.partialLinkText("Click")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentId = iterator.next();
		String childId = iterator.next();
		driver.switchTo().window(childId);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.quit();
	}
}
