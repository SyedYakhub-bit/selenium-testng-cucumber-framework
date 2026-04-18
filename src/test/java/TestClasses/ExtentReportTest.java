package TestClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class ExtentReportTest {
	WebDriver driver = new ChromeDriver();
	ExtentReports extentReports;

	@BeforeTest
	public void getConfig() {
		String reportPath = System.getProperty("user.dir") + "\\ExtentReports\\";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
		extentSparkReporter.config().setReportName("Web Automation Results");
		extentSparkReporter.config().setDocumentTitle("Test Results");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Syed Yakhub");
	}

	@Test
	public void driverInitialization() {
		extentReports.createTest("Initialise the driver").info("Starting the driver");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.setExperimentalOption("prefs",
				Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		Assert.assertEquals(driver.getTitle(), "Let's Shop");
		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void driverClose() {
		driver.quit();
		extentReports.flush();
	}
}
