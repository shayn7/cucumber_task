package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{


    @FindBy(css = "a.btn.btn-success.btn-lg")
    private WebElement addToCartButton;

    @FindBy(id = "cartur")
    private WebElement cartPageButton;


    public ProductPage(BaseSteps steps) {
        super(steps);
    }

    @Override
    public boolean verifyPage() {
        return steps.isElementDisplayed(addToCartButton);
    }

    public void clickOnAddToCartButton(){
        steps.clickOnElement(addToCartButton);
        WebDriverWait wait = new WebDriverWait(steps.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        steps.acceptAlertIfPresent();
    }

    public void goToCartPage(){
        steps.clickOnElement(cartPageButton);
    }

}
