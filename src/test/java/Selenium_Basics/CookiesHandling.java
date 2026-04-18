package Selenium_Basics;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class CookiesHandling {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		// Below line of code hides the info "Chrome is being automated"
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://automated-intelligence.com/site-pages/cookies/");
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println("Cookie Name: " + cookie.getName());
			System.out.println("Cookie Value: " + cookie.getValue());
		}
		driver.manage().deleteAllCookies();
		driver.quit();

	}
}
