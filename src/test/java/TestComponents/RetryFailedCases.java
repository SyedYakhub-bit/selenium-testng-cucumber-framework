package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedCases implements IRetryAnalyzer {

	int count = 0;
	int maxRetry = 1; // retries 1 more time before final FAIL

	@Override
	public boolean retry(ITestResult result) {
		if (count < maxRetry) {
			count++; // increment retry count
			return true; // true = rerun the test
		}
		return false; // false = stop retrying, mark as FAILED
	}
}
