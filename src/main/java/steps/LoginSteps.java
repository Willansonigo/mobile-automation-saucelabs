package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import utils.DriverFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LoginSteps {
    private LoginPage loginPage;
    private AppiumDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);


    @Given("the app is launched")
    public void theAppIsLaunched() {
        driver = DriverFactory.getDriver();
        Assert.assertNotNull("Driver is not initialized", driver);
        loginPage = new LoginPage(driver);
        logger.info("the aplication is launched successfully.");
    }

    @When("I enter a valid username {string}")
    public void iEnterAValidUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter a valid password {string}")
    public void iEnterAValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I enter an invalid username {string}")
    public void iEnterAnInvalidUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter an invalid password {string}")
    public void iEnterAnInvalidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I leave the username field empty")
    public void iLeaveTheUsernameFieldEmpty()  {
        loginPage.clearUsernameField();
    }

    @When("I leave the password field empty")
    public void iLeaveThePasswordFieldEmpty() {
        loginPage.clearPasswordField();
    }

    @When("I tap on the login button")
    public void iTapOnTheLoginButton() {
        loginPage.tapLoginButton();
    }

    @Then("I should see the home screen")
    public void iShouldSeeTheHomeScreen() {
        Assert.assertTrue("Home screen is not displayed", loginPage.isHomeScreenDisplayed());
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        Assert.assertEquals("Error message does not match", expectedMessage, loginPage.getErrorMessage());
    }

    @Then("I should see an error message for locked user {string}")
    public void iShouldSeeAnErrorMessageLockOutUser(String expectedMessage) {
        Assert.assertEquals("Error message does not match", expectedMessage, loginPage.getErrorMessageLockOutUser());
    }

    @Then("I should see an error message with empty fields {string}")
    public void iShouldSeeAnErrorMessageEmptyFields(String expectedMessage) {
        Assert.assertEquals("Error message does not match", expectedMessage, loginPage.getErrorMessageEmptyFields());
    }
}