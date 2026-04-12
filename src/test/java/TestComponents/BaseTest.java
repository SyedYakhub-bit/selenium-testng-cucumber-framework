package TestComponents;

import Framework.PageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    Properties properties = new Properties();

    public WebDriver driverInitializer() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Framework//Resources//global.properties");
        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("prefs", Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("edge")) {

            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            edgeOptions.setExperimentalOption("prefs", Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));
            driver = new EdgeDriver(edgeOptions);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;


    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        driver = driverInitializer();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

public void tearDown(){
    driver.quit();
}
}
