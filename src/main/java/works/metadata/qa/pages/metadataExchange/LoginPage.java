package works.metadata.qa.pages.metadataExchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    // Page locators:
    private static final By mdxLogo = By.cssSelector("img[class='mdx-logo']");
    private static final By pageHeader = By.cssSelector("h4");
    private static final By username = By.name("email");
    private static final By password = By.name("password");
    private static final By loginButton = By.xpath("//button[text()='Log In']");
    private static final By unauthorisedAccessErrorMessage = By.xpath("//span[text()='Unauthorised access.']");
    private static final By forgotPasswordLink = By.linkText("Forgot Password?");

    //Getters:
    public static WebElement getMdxLogo(WebDriver webDriver) {
        return webDriver.findElement(mdxLogo);
    }

    public static WebElement getUsername(WebDriver webDriver) {
        return webDriver.findElement(username);
    }

    public static WebElement getPassword(WebDriver webDriver) {
        return webDriver.findElement(password);
    }

    public static WebElement getLoginButton(WebDriver webDriver) { return webDriver.findElement(loginButton); }

    public static WebElement getForgotPasswordLink(WebDriver webDriver) {
        return webDriver.findElement(forgotPasswordLink);
    }

    // Actions:
    public static String getPageUrl(WebDriver webDriver){ return webDriver.getCurrentUrl(); }

    public static String getLoginPageTitle(WebDriver webDriver) { return webDriver.getTitle(); }

    public static String getPageHeader(WebDriver webDriver){ return webDriver.findElement(pageHeader).getText(); }

    public static Boolean validateMDXLogo(WebDriver webDriver) {
        return getMdxLogo(webDriver).isDisplayed();
    }

    public static void enterUsername(WebDriver webDriver, String username) {
        getUsername(webDriver).sendKeys(username);
    }

    public static void enterPassword(WebDriver webDriver, String password) {
        getPassword(webDriver).sendKeys(password);
    }

    public static void clickOnLoginButton(WebDriver webDriver) {
        getLoginButton(webDriver).click();
    }

    public static void enterNullCredentials(WebDriver webDriver) {
        getUsername(webDriver).sendKeys("");
        getPassword(webDriver).sendKeys("");
    }

    public static Boolean unauthorisedAccessErrorMessageIsDisplayed (WebDriver webDriver) {
        return webDriver.findElement(unauthorisedAccessErrorMessage).isDisplayed();
    }

    public static void clickOnForgotPasswordLink(WebDriver webDriver){
        getForgotPasswordLink(webDriver).click();
    }
}
