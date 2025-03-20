package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "loginusername")
    private WebElement userNameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(id = "nameofuser")
    private WebElement welcomeMessage;

    public LoginPage(BaseSteps steps) {
        super(steps);
    }

    public void login(String user, String pass) {
        steps.setText(userNameField, user);
        steps.setText(passwordField, pass);
        steps.clickOnElement(loginButton);
    }

    public boolean isLoginSuccessful() {
        return steps.isElementDisplayed(welcomeMessage);
    }

    @Override
    public boolean verifyPage() {
        return steps.isElementDisplayed(loginButton);
    }
}
