package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.time.Duration;

public class ShoppingPage {
    private AppiumDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(ShoppingPage.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By productCatalogLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)");
    private By addToCartButtonLocator1 = AppiumBy.androidUIAutomator("new UiSelector().description(\"test-ADD TO CART\").instance(0)");
    private By addToCartButtonLocator2 = AppiumBy.androidUIAutomator("new UiSelector().description(\"test-ADD TO CART\").instance(1)");
    private By cartIconLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
    private By checkoutButtonLocator = AppiumBy.accessibilityId("test-CHECKOUT");
    private By informationFirstName = AppiumBy.accessibilityId("test-First Name");
    private By informationLastName = AppiumBy.accessibilityId("test-Last Name");
    private By informationPostalCode = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private By informationContinueBtn = AppiumBy.accessibilityId("test-CONTINUE");
    private By checkoutFinishBtn = AppiumBy.accessibilityId("test-FINISH");
    private By cancelBTN = AppiumBy.accessibilityId("test-CANCEL");
    private By confirmationMessageLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"THANK YOU FOR YOU ORDER\")");
    private By typeViewProductsBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");
    private By addToCartPlusButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"+\").instance(0)");
    private By removeButtonLocator = AppiumBy.accessibilityId("test-REMOVE");
    private By continueShoppingButtonLocator = AppiumBy.accessibilityId("test-CONTINUE SHOPPING");
    private By filterButtonLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)");
    private By filterNameAToZLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Name (A to Z)\")");
    private By filterNameZToALocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Name (Z to A)\")");
    private By filterPriceLowToHighLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Price (low to high)\")");
    private By filterPriceHighToLowLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Price (high to low)\")");
    private By filterCancelLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Cancel\")");
    private By backHomeButton = AppiumBy.accessibilityId("test-BACK HOME");
    private By backToProductsButton = AppiumBy.accessibilityId("test-BACK TO PRODUCTS");


    public ShoppingPage(AppiumDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        this.driver = driver;
    }


    public void browseCatalog() {
        // Wait for the product catalog to be visible
        logger.info("Waiting for the product catalog to be visible");
        driver.findElement(productCatalogLocator).isDisplayed();
    }

    public void selectProduct(String productName) {
        // Scroll to the product and select it
        By productNameLocator = By.xpath("//android.widget.TextView[@content-desc='test-Item title' and @text='" + productName + "']");
        logger.info("Log to depuration");
        System.out.println("XPath gerado: //android.widget.TextView[@content-desc='test-Item title' and @text='" + productName + "']");
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(productNameLocator).isDisplayed());
        driver.findElement(productNameLocator).click();

    }

    public void tapTypeViewButton() {
        // Taps the "Type View" button to change the product view type.
        driver.findElement(typeViewProductsBtn).click();
    }

    public void tapRemoveButton() {
        logger.info("Clicking on the remove button");
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(removeButtonLocator).isDisplayed());
        driver.findElement(removeButtonLocator).click();
    }

    public void tapContinueShoppingButton() {
        logger.info("Clicking on the continue shopping button...");
        driver.findElement(continueShoppingButtonLocator).click();
    }

    public void tapBackHomeButton() {
        // Taps the "Back Home" button to navigate back to the home screen.
        driver.findElement(backHomeButton).click();
    }

    public void tapBackToProductsButton() {
        // Taps the "Back to Products" button to return to the product list.
        driver.findElement(backToProductsButton).click();
    }

    public void addToCart() {
        // Click on the "Add to Cart" button
        logger.info("Scrolling the screen...");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));
        logger.info("Clicking on the Add to Cart button...");
        driver.findElement(addToCartButtonLocator1).click();
    }

    public void addProductToCartForPlusButton() {
        // Adds a product to the cart by clicking the "Plus" button.
        driver.findElement(addToCartPlusButton).click();
    }

    public void addAllProductsToCartFromHomeScreenButton() {
        // Adds all products to the cart from the home screen.
        logger.info("Adding product to cart");
        driver.findElement(addToCartButtonLocator2).click();
        driver.findElement(addToCartButtonLocator1).click();
        logger.info("Scrolling the screen...");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));
        driver.findElement(addToCartButtonLocator2).click();
        driver.findElement(addToCartButtonLocator1).click();
        logger.info("Scrolling the screen...");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));
        driver.findElement(addToCartButtonLocator2).click();
        driver.findElement(addToCartButtonLocator1).click();
    }

    public void isInCart() {
        // Open the cart and verify if the product is present
        driver.findElement(cartIconLocator).click();
    }

    public Boolean isProductInCart() {
        // Open the cart and verify if the product is present
        logger.info("Opening the cart and verify if the product is present...");
        driver.findElement(cartIconLocator).click();
        return driver.findElement(cartIconLocator).isDisplayed();
    }

    public void proceedToCheckout() {
        // Click on the checkout button
        logger.info("Clicking the checkout button...");
        driver.findElement(checkoutButtonLocator).click();
    }

    public void enterShippingInformation() {
        // Fill out the shipping information form
        logger.info("Fill out the shipping information form...");
        driver.findElement(informationFirstName).sendKeys("TestWill");
        driver.findElement(informationLastName).sendKeys("Sonic");
        driver.findElement(informationPostalCode).sendKeys("12345678");
        driver.findElement(informationContinueBtn).click();
    }

    public void confirmPurchase() {
        // Click on the confirm purchase button
        logger.info("Scrolling the screen until you find the element to finish button...");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        logger.info("Clicking the finish button...");
        driver.findElement(checkoutFinishBtn).click();

    }

    public String getConfirmationMessage() {
        // Retrieve the confirmation message
        return driver.findElement(confirmationMessageLocator).getText();
    }

    public void cancelPurchase () {
        //Cancels the purchase process by scrolling to the "Cancel My Purchase" button and clicking it.
        logger.info("Scrolling the screen until you find the element...");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        logger.info("Clicking the button 'cancel my purchase'...");
        driver.findElement(cancelBTN).click();
    }

    public void cancelCheckout () {
        // Cancels the checkout process by clicking the "Cancel Checkout" button.
        logger.info("Clicking the button 'cancel checkout'...");
        driver.findElement(cancelBTN).click();
    }

    public void usingFilters () {
        // Applies various filters to the product list and cancels the filter selection.
        logger.info("Clicking the button and using 'Filters'...");
        driver.findElement(filterButtonLocator).click();
        driver.findElement(filterNameAToZLocator).click();
        driver.findElement(filterButtonLocator).click();
        driver.findElement(filterNameZToALocator).click();
        driver.findElement(filterButtonLocator).click();
        driver.findElement(filterPriceLowToHighLocator).click();
        driver.findElement(filterButtonLocator).click();
        driver.findElement(filterPriceHighToLowLocator).click();
        driver.findElement(filterButtonLocator).click();
        driver.findElement(filterCancelLocator).click();

    }

}
