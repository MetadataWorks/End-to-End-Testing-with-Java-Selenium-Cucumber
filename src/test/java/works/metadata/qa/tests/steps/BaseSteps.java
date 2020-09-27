package works.metadata.qa.tests.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import works.metadata.qa.tests.TestConfigurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver webDriver;
    public static Properties properties;
    private static String browserName;
    private static String browserHeadlessMode;

    public static WebDriver initialisation() {

        configureProperties();
        createWebDriverInstance();
        configureWebDriver();
        return webDriver;
    }

    private static void configureProperties() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config/testConfiguration.properties");
            properties.load(fileInputStream);
            browserName = properties.getProperty("browser");
            browserHeadlessMode = properties.getProperty("browserHeadlessMode");
        } catch (IOException e) {
            System.out.println("An error occurred while trying to load the properties.");
            System.out.println(e.getMessage());
        }
    }

    private static void createWebDriverInstance() {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/webDrivers/chromedriver.exe");
            if (browserHeadlessMode.equals("true")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                webDriver = new ChromeDriver(chromeOptions);
            } else {
                webDriver = new ChromeDriver();
            }
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/webDrivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
        }
    }

    private static void configureWebDriver(){

        // WebDriver Configurations
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(TestConfigurations.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TestConfigurations.IMPLICIT_WAIT, TimeUnit.SECONDS);

        // Navigating to the base URL
        if (properties.getProperty("navigateToBaseUrl").equals("true")) {
            webDriver.get(properties.getProperty("baseUrl"));
        }
    }
}
