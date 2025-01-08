package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ShoppingPage;
import utils.DriverFactory;


public class ShoppingSteps {
    private ShoppingPage shoppingPage;


    public ShoppingSteps() {
        // Initialize the page with the Appium driver
        this.shoppingPage = new ShoppingPage(DriverFactory.getDriver());
    }

    @Given("I have items in my cart")
    public void iTheProductInTheCart() {
        shoppingPage.isInCart();
    }

    @When("I browse the product catalog")
    public void iBrowseTheProductCatalog() {
        shoppingPage.browseCatalog();
    }

    @And("I tap on the Type View Products button")
    public void iTapOnTheTypeViewProductsButton() {
        shoppingPage.tapTypeViewButton();
    }

    @When("I select a product {string}")
    public void iSelectAProduct(String productName) {
        shoppingPage.selectProduct(productName);
    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        shoppingPage.addToCart();
    }

    @And("I add the product to the cart using plus button")
    public void iAddTheProductToTheCartPlusButton() {
        shoppingPage.addProductToCartForPlusButton();
    }

    @And("I add all the products to the cart")
    public void iAddAllTheProductsToTheCart() {
        shoppingPage.addAllProductsToCartFromHomeScreenButton();
    }

    @Then("I should see the product in the cart")
    public void iShouldSeeTheProductInTheCart() {
        Assert.assertTrue("The product is not in the cart", shoppingPage.isProductInCart());
    }

    @And("I tap in remove product")
    public void iRemoveTheProductFromTheCart() {
        shoppingPage.tapRemoveButton();
    }

    @When("I tap in continue shopping")
    public void iClickInContinueShopping() {
        shoppingPage.tapContinueShoppingButton();
    }

    @And("I tap in back home button")
    public void iClickInBackHome() {
        shoppingPage.tapBackHomeButton();
    }

    @And("I tap in back to products button")
    public void iClickInBackToProducts() {
        shoppingPage.tapBackToProductsButton();
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        shoppingPage.proceedToCheckout();
    }

    @And("I enter my shipping information")
    public void iEnterMyShippingInformation() {
        shoppingPage.enterShippingInformation();
    }

    @When("I confirm the purchase")
    public void iConfirmThePurchase() {
        shoppingPage.confirmPurchase();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expectedMessage) {
        String actualMessage = shoppingPage.getConfirmationMessage();
        Assert.assertEquals("Confirmation message does not match", expectedMessage, actualMessage);
    }

    @When("I cancel the purchase")
    public void iCancelThePurchase() {
        shoppingPage.cancelPurchase();
    }

    @When("I cancel checkout")
    public void iCancelCheckout() {
        shoppingPage.cancelCheckout();
    }

    @When("I using filters to search for products")
    public void iUsingFilters() {
        shoppingPage.usingFilters();
    }

}
