package dev.naamad.pages;

import dev.naamad.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {
    @FindBy(linkText = "Phones")
    private WebElement phonesCategory;
    @FindBy(linkText = "Laptops")
    private WebElement laptopsCategory;
    @FindBy(linkText = "Monitors")
    private WebElement monitorsCategory;


    public NavigationPage(BaseSteps steps) {
        super(steps);
    }

    public void navigateToPhones() {
        steps.clickOnElement(phonesCategory);
    }

    public void navigateToLaptops() {
        steps.clickOnElement(laptopsCategory);
    }

    public void navigateToMonitors() {
        steps.clickOnElement(monitorsCategory);
    }

    @Override
    public boolean verifyPage() {
        return steps.isElementDisplayed(phonesCategory);
    }
}

