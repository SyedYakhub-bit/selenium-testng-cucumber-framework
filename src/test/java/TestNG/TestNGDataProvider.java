package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDataProvider {

    @DataProvider(name = "searchData")
    public Object[][] searchKeywords() {
        return new Object[][]{
                {"laptop","https://example1.com"},
                {"mobile","https://example2.com"},
                {"headphones","https://example3.com"}
        };
    }

    @Test(dataProvider = "searchData")
    @Parameters({"baseURL","actualURL"})
    public void testSearch(String keyword, String baseURL) {
        System.out.println("Searching for: " + keyword + " on " + baseURL);
    }
}
