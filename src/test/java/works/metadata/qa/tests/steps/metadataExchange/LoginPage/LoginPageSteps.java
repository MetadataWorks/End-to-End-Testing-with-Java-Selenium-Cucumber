package works.metadata.qa.tests.steps.metadataExchange.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import works.metadata.qa.pages.metadataExchange.LoginPage;
import works.metadata.qa.pages.metadataExchange.WelcomePage;
import works.metadata.qa.tests.steps.BaseSteps;

public class LoginPageSteps {

    WebDriver webDriver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        webDriver = BaseSteps.initialisation();
    }

    @Given("The browser window is open")
    public void the_browser_window_is_open() {
        Assert.assertFalse(webDriver.toString().contains("null"));
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String loginPageUrl = LoginPage.getPageUrl(webDriver);
        Assert.assertEquals("http://localhost:8080/view/login", loginPageUrl);
    }

    @Given("Login page header is displayed")
    public void login_page_header_is_displayed() {
        String loginPageHeader = LoginPage.getPageHeader(webDriver);
        Assert.assertEquals("Log into your account", loginPageHeader);
    }

    @When("I enter valid username")
    public void i_enter_valid_username() {
        LoginPage.enterUsername(webDriver, BaseSteps.properties.getProperty("username"));
    }

    @When("I enter valid password")
    public void i_enter_valid_password() {
        LoginPage.enterPassword(webDriver, BaseSteps.properties.getProperty("password"));
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        LoginPage.clickOnLoginButton(webDriver);
    }

    @Then("I am logged into the application")
    public void i_am_logged_into_the_application() {
        String welcomePageUrl = WelcomePage.getPageUrl(webDriver);
        Assert.assertEquals("http://localhost:8080/view/dashboard/welcome", welcomePageUrl);
    }

    @Then("The Welcome Page is displayed")
    public void the_welcome_page_is_displayed() {
        String welcomePageHeader = WelcomePage.getPageHeader(webDriver);
        Assert.assertEquals("Welcome to MetaDataworks", welcomePageHeader);
    }

    @When("I enter invalid username")
    public void i_enter_invalid_username() {
        LoginPage.enterUsername(webDriver, "invalidUsername@test.org");
    }

    @When("I enter invalid password")
    public void i_enter_invalid_password() {
        LoginPage.enterPassword(webDriver, "invalidPassword");
    }

    @Then("Unauthorised Access error message is displayed")
    public void unauthorised_access_error_message_is_displayed() {
        Assert.assertTrue(LoginPage.unauthorisedAccessErrorMessageIsDisplayed(webDriver));
    }

    @After
    public void teardown(){
        webDriver.quit();
    }
}
