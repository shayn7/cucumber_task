package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;
    @FindBy(css = "#orderModalLabel")
    private WebElement placeOrderForm;

    public CartPage(BaseSteps steps) {
        super(steps);
    }


    @Override
    public boolean verifyPage() {
        return steps.isElementDisplayed(placeOrderButton);
    }

    public void clickOnPlaceOrderButton(){
        steps.clickOnElement(placeOrderButton);
    }

    public boolean isFormDisplayed() {
        return steps.isElementDisplayed(placeOrderForm);
    }
}
