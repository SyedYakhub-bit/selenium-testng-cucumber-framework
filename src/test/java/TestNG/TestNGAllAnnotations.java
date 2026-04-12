package TestNG;

import org.testng.annotations.*;

public class TestNGAllAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @Test(priority=1)
    public void test1(){
        System.out.println("I am Test case1");
    }
    @Test(priority=2)
    public void test2(){
        System.out.println("I am Test case2");
    }
    @Test(priority=3)
    public void test3(){
        System.out.println("I am Test case3");
    }
    @Test(priority =3)
    public void test4(){
        System.out.println("I am Test case4");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am After suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am After test");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }

}
