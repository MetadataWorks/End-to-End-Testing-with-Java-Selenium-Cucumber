package works.metadata.qa.pages.metadataExchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    // Page Locators:
    private static By mdxLogo = By.cssSelector("img[class='mdx-logo']");
    private static By pageHeader = By.cssSelector("h1");
    private static By navBarButton = By.cssSelector("button[data-testid='nav-menu-button'][type='button']");

    // Getters:
    public static String getPageUrl(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.urlContains("welcome"));
        return webDriver.getCurrentUrl();
    }

    public static WebElement getMdxLogo(WebDriver webDriver) {
        return webDriver.findElement(mdxLogo);
    }

    public static String getPageHeader(WebDriver webDriver) {
        return webDriver.findElement(pageHeader).getText();
    }

    public static WebElement getNavBarButton(WebDriver webDriver) {
        return webDriver.findElement(navBarButton);
    }

}
