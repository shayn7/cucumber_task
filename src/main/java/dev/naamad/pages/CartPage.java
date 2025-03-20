package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    public CartPage(BaseSteps steps) {
        super(steps);
    }

    public void addItemToCart() {
        steps.clickOnElement(addToCartButton);
    }

    public void goToCart() {
        steps.clickOnElement(cartLink);
    }

    public boolean isCheckoutAvailable() {
        return steps.isElementDisplayed(placeOrderButton);
    }

    @Override
    public boolean verifyPage() {
        return steps.isElementDisplayed(cartLink);
    }
}
