package works.metadata.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver webDriver;
    public static Properties properties;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/java/works/metadata/" +
                    "config/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e){
            e.getMessage();
        }
    }
    public static void initialisation(){
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avanish\\Documents\\Repositories\\Testing\\webdrivers\\chromedriver\\chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Avanish\\Documents\\Repositories\\Testing\\webdrivers\\geckodriver\\geckodriver.exe");
            webDriver = new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        webDriver.get(properties.getProperty("baseUrl"));
    }
}
