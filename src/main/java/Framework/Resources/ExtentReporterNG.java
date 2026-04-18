package Framework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		String reportPath = System.getProperty("user.dir") + "\\ExtentReports\\";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
		extentSparkReporter.config().setReportName("Web Automation Results");
		extentSparkReporter.config().setDocumentTitle("Test Results");

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Syed Yakhub");
		return extentReports;
	}
}
