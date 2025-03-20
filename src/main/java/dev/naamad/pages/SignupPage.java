package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {
    @FindBy(id = "sign-username")
    private WebElement username;

    @FindBy(id = "sign-password")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement signupButton;

    public SignupPage(BaseSteps steps) {
        super(steps);
    }

    public void signup(String user, String pass) {
        steps.setText(username, user);
        steps.setText(password, pass);
        steps.clickOnElement(signupButton);
    }

    @Override
    public boolean verifyPage() {
        return steps.isElementDisplayed(signupButton);
    }
}
