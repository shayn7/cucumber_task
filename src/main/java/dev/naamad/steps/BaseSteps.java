package dev.naamad.steps;

import dev.naamad.enums.Environment;
import dev.naamad.enums.Page;
import dev.naamad.factories.WebDriverFactory;
import dev.naamad.pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.time.Duration;

public abstract class BaseSteps {
    private static final Logger LOGGER = LogManager.getLogger(BaseSteps.class);
    private final Environment environment;
    private WebDriver driver;
    private BasePage expectedPage;

    protected BaseSteps(Environment environment) {
        this.environment = environment;
    }

    protected WebDriver createWebDriver(Environment environment, MutableCapabilities options) throws MalformedURLException {
        return (environment == Environment.REMOTE_CHROME) ? WebDriverFactory.getRemoteDriver(System.getProperty("hub"), options)
                : WebDriverFactory.getDriver(environment, options);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void startSession() throws MalformedURLException {
        MutableCapabilities options = initCapabilities();
        driver = createWebDriver(environment, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void iShouldBeOnPage(Page page) {
        expectedPage = page.getPage(this);
        logToConsoleAndReporter("Page URL: " + driver.getCurrentUrl());
        Assert.assertTrue(expectedPage.verifyPage(), "Actual page is not " + page);
        logToConsoleAndReporter("We are on page: " + page);
    }

    public <T extends BasePage> T getExpectedPage() {
        return (T) expectedPage;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        logToConsoleAndReporter("Navigated to URL: " + url);
    }

    public void setText(WebElement element, String text) {
        if (isElementDisplayed(element)) {
            element.clear();
            element.sendKeys(text);
            logToConsoleAndReporter("Entered text: " + text);
        }
    }

    public String getText(WebElement element) {
        return isElementDisplayed(element) ? element.getText() : "";
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickOnElement(WebElement element) {
        if (isElementDisplayed(element)) {
            element.click();
            logToConsoleAndReporter("Clicked on element " + element);
        } else {
            logToConsoleAndReporter("Unable to click on element " + element);
        }
    }

    public WebElement findElementBy(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementDisabled(WebElement element) {
        return Boolean.TRUE.equals(((JavascriptExecutor) driver).executeScript(
                "return arguments[0].hasAttribute('disabled');", element));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    private void logToConsoleAndReporter(String message) {
        LOGGER.info(message);
        saveTextLog(message);
    }

    public void acceptAlertIfPresent() {
            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (Exception e) {
                System.out.println("No alert is present.");
            }
        }


    private String saveTextLog(String text) {
        return text;
    }

    protected abstract MutableCapabilities initCapabilities();


}
