package dev.naamad.stepDefinitions;

import dev.naamad.pages.CartPage;
import dev.naamad.pages.HomePage;
import dev.naamad.pages.ProductPage;
import dev.naamad.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import dev.naamad.steps.BaseSteps;
import java.net.MalformedURLException;

import static dev.naamad.enums.Page.*;

public class CartSteps {
    private final BaseSteps baseSteps;
    private ProductPage productPage;
    private CartPage cartPage;
    private HomePage homePage;


    @Autowired
    public CartSteps(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @Given("I am on a product page")
    public void i_am_on_a_product_page() throws MalformedURLException {
        String baseUrl = ConfigReader.getProperty("base_url");
        baseSteps.startSession();
        baseSteps.navigateToUrl(baseUrl);
        baseSteps.iShouldBeOnPage(HOME_PAGE);
        homePage = baseSteps.getExpectedPage();
        homePage.clickOnItem("Samsung galaxy s6");
        baseSteps.iShouldBeOnPage(PRODUCT_PAGE);
        productPage = baseSteps.getExpectedPage();
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        productPage.clickOnAddToCartButton();
    }

    @When("I navigate to the cart")
    public void i_navigate_to_the_cart() {
        productPage.goToCartPage();
        baseSteps.iShouldBeOnPage(CART_PAGE);
        cartPage = baseSteps.getExpectedPage();
    }

    @Then("I should be able to proceed to checkout")
    public void i_should_be_able_to_proceed_to_checkout() {
        cartPage.clickOnPlaceOrderButton();
        Assert.assertTrue(cartPage.isFormDisplayed(), "form is not visible");
    }




}
