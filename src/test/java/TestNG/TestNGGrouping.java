package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGGrouping {
	@AfterTest(groups = {"Smoke"})
	public void testNGAnnotation1() {
		System.out.println("This test case is Failed Intentionally, Don't Worry");
		Assert.fail();
	}

	@Test(groups = {"Smoke"})
	public void testNGAnnotation2() {
		System.out.println("This is first test case");
	}

	@Test(groups = {"Smoke"})
	public void testNGAnnotation3() {
		System.out.println("This is second test case");
	}

	@Test(dependsOnMethods = {"testNGAnnotation5"})
	public void testNGAnnotation4() {
		System.out.println("This is three test case");
	}

	@Parameters("URL")
	@Test()
	public void testNGAnnotation5(@Optional("http://example.com") String urlValue) {
		System.out.println("This is Four test case");
		System.out.println(urlValue);
	}

	@Test(timeOut = 2000)
	public void testNGAnnotation6() {
		System.out.println("This is five test case");

	}

	@Test(enabled = false)
	public void testNGAnnotation7() {
		System.out.println("This is six test case");
	}

	@Test(dependsOnMethods = "testNGAnnotation9")
	public void testNGAnnotation8() {
		System.out.println("This is seven test case");
	}

	@Test()
	public void testNGAnnotation9() {
		System.out.println("This is eight test case");
	}
}
