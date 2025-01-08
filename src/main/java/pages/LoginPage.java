package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.time.Duration;



public class LoginPage {
    private AppiumDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    private By usernameFieldLocator = AppiumBy.accessibilityId("test-Username");
    private By passwordFieldLocator = AppiumBy.accessibilityId("test-Password");
    private By loginButtonLocator = AppiumBy.accessibilityId("test-LOGIN");
    private By homeScreenLocator = AppiumBy.id("com.swaglabsmobileapp:id/action_bar_root");
    private By errorMessageLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Username and password do not match any user in this service.\")");
    private By errorMessageLocatorwithemptyfields = AppiumBy.androidUIAutomator("new UiSelector().text(\"Username is required\")");
    private By errorMessageLocatorLocked = AppiumBy.androidUIAutomator("new UiSelector().text(\"Sorry, this user has been locked out.\")");

    public LoginPage(AppiumDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameFieldLocator).sendKeys(username);}

    public void enterPassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);}

    public void tapLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public boolean isHomeScreenDisplayed() {
        logger.info("Home screen displayed");
        return driver.findElement(homeScreenLocator).isDisplayed();
    }

    public String getErrorMessage() {
        logger.info("Getting message error");
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(errorMessageLocator).isDisplayed());
        return driver.findElement(errorMessageLocator).getText();
    }

    public String getErrorMessageEmptyFields() {
        logger.info("Getting message error");
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(errorMessageLocatorwithemptyfields).isDisplayed());
        return driver.findElement(errorMessageLocatorwithemptyfields).getText();
    }

    public String getErrorMessageLockOutUser() {
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(errorMessageLocatorLocked).isDisplayed());
        return driver.findElement(errorMessageLocatorLocked).getText();
    }

    public void clearUsernameField() {
        driver.findElement(usernameFieldLocator).clear();
    }

    public void clearPasswordField() {
        driver.findElement(passwordFieldLocator).clear();
    }

}
