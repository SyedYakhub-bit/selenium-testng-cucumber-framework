package TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("This gets executed on test start " + result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("This gets executed on test success");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("This gets executed on test failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("This gets executed on test skipped");
	}

}
