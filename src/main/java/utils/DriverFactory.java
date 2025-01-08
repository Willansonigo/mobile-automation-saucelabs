package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class DriverFactory {
    private static AppiumDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);


    public static synchronized AppiumDriver getDriver() {
        //AppiumDriver driver = null;
        if (driver == null) {
            try {
                // Driver Configuration
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appium:deviceName", "RQCX506WGKX");
                capabilities.setCapability("appium:app", "C://Users///willa//OneDrive//Documentos//Estudo//Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
                capabilities.setCapability("appium:appActivity", "MainActivity");


                // Starting driver
                URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
                driver = new AndroidDriver(appiumServerUrl, capabilities);
                logger.info("Driver initialized successfully.");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error in initializing the appium driver", e);
            }
        }
            return driver;
        }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Driver closed.");
        }
    }
}
