package TestClasses;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidation extends BaseTest {
    @Test
    public void submitOrder() {
        landingPage.loginApplication("rahulshettyacademysyed@gmail.com", "Syed#200");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
    }
}
