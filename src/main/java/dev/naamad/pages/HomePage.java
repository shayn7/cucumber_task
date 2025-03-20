package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "login2")
    private WebElement loginButton;


    public HomePage(BaseSteps steps) {
        super(steps);
    }

    public void clickOnLoginButton(){
        steps.clickOnElement(loginButton);
    }

    @Override
    public boolean verifyPage() {
        return steps.getPageTitle().equals("STORE");
    }
}
