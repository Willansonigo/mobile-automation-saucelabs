package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;
import pages.LoginPage;
import utils.DriverFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class Hooks {
    private AppiumDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        Assert.assertNotNull("Driver is not initialized in Before", driver);
        logger.info("Driver setUp in @Before");

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        logger.info("Driver closed in @After");
    }
}
