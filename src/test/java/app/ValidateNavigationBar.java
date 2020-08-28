package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LandingPage;

import java.io.IOException;

public class ValidateNavigationBar extends Base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(props.getProperty("url"));
        log.info("Navigate to Homepage");
    }

    @Test
    public void basePageNavigation() {
        LandingPage landPage = new LandingPage(driver);
        Assert.assertTrue(landPage.getNavBar().isDisplayed());
        log.info("Navigate to Homepage");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
