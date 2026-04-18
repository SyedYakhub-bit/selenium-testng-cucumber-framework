package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.List;

public class CalendarDynamic {
	public static void main(String[] args) {
		String year = "2024";
		String month = "10";
		String date = "15";
		String[] expectedList = {month, date, year};
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("[class*='calendar-button_']")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(month) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i = 0; i < actualList.size(); i++) {
			System.out.println(actualList.get(i).getDomAttribute(("value")));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
		}
		driver.quit();
	}
}
