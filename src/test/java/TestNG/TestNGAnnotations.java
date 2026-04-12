package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    @AfterTest
    public void testNGAnnotation1(){
        System.out.println("This is after test case");
    }

    @Test
    public void testNGAnnotation2(){
        System.out.println("This is first test case");
    }

    @Test
    public void testNGAnnotation3(){
        System.out.println("This is second test case");
    }

    @Test
    public void testNGAnnotation4(){
        System.out.println("This is three test case");
    }

    @BeforeTest
    public void testNGAnnotation5(){
        System.out.println("This is before test case");
    }
}
