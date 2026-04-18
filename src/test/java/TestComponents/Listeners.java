package TestComponents;

import Framework.Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener {

	// Single shared report instance — one report file for all threads
	private static ExtentReports extentReports;

	// ThreadLocal — each thread gets its OWN ExtentTest node
	private final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

	// REMOVED - extentTest field — was causing race condition

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReporterNG.getReportObject();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTestThreadLocal.set(extentReports.createTest(result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTestThreadLocal.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTestThreadLocal.get().fail(result.getThrowable());

		WebDriver localDriver = ((BaseTest) result.getInstance()).driver;

		try {
			String screenshotPath = getScreenshot(result.getMethod().getMethodName(), localDriver);
			extentTestThreadLocal.get().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTestThreadLocal.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		extentTestThreadLocal.remove(); // clean up ThreadLocal to prevent memory leak
	}
}
