package TestNG;

import org.testng.annotations.*;

public class TestNGMultipleTests {
	@Test
	public void printName() {
		System.out.println("My name is Syed Yakhub");
	}
	@Test
	public void printAge() {
		System.out.println("My age is 24");
	}
	@Test
	public void printWeight() {
		System.out.println("My Weight varies");
	}
	@Test
	public void printHeight() {
		System.out.println("My height is around 5.7 feet");
	}
	@Test
	public void printAddress() {
		System.out.println("My home is in Tumkur");
	}
	@Test
	public void notForPrint() {
		System.out.println("Shouldn't include this.");
	}
}
