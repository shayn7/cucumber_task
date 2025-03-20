package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected BaseSteps steps;

    public BasePage(BaseSteps steps) {
        this.steps = steps;
        this.driver = steps.getDriver();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean verifyPage();
}
