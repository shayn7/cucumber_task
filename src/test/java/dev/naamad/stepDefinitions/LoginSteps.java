package dev.naamad.stepDefinitions;

import dev.naamad.pages.HomePage;
import dev.naamad.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import dev.naamad.pages.LoginPage;
import dev.naamad.steps.BaseSteps;

import java.net.MalformedURLException;

import static dev.naamad.enums.Page.HOME_PAGE;
import static dev.naamad.enums.Page.LOGIN_PAGE;

public class LoginSteps {
    private final BaseSteps baseSteps;
    private LoginPage loginPage;
    private HomePage homePage;

    @Autowired
    public LoginSteps(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }


    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws MalformedURLException {
        String baseUrl = ConfigReader.getProperty("base_url");
        baseSteps.startSession();
        baseSteps.navigateToUrl(baseUrl);
        baseSteps.iShouldBeOnPage(HOME_PAGE);
        homePage = baseSteps.getExpectedPage();
        homePage.clickOnLoginButton();
        baseSteps.iShouldBeOnPage(LOGIN_PAGE);
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage = baseSteps.getExpectedPage();
        loginPage.login("shay", "naamad");
    }

    @Then("I should see the home page")
    public void i_should_see_the_home_page() {
        Assert.assertTrue(baseSteps.getDriver().getCurrentUrl().contains("index.html"), "Home page not loaded");
    }
}
