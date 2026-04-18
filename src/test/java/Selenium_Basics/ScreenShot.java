package Selenium_Basics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/guide/how-to-handle-cookies-in-selenium");
		File fullScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// the below will add time stamp to screenshots, so we don't want to name it
		// each time
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		FileUtils.copyFile(fullScreenshot,
				new File("C:\\Users\\syed.yakhub\\Pictures\\Saved Pictures\\full_screenshot_" + timeStamp + ".png"));
		WebElement element = driver.findElement(By.cssSelector(".b-lazy.aligncenter"));
		// Use JavaScript Executor to scroll to the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementScreenshot,
				new File("C:\\Users\\syed.yakhub\\Pictures\\Saved Pictures\\element_screenshot_" + timeStamp + ".png"));
		System.out.println(
				"Screenshots are taken successfully and saved in location C:\\Users\\syed.yakhub\\Pictures\\Saved Pictures");
		driver.quit();

	}
}
