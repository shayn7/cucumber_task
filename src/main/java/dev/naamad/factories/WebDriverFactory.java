package dev.naamad.factories;

import dev.naamad.enums.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    private static WebDriver driver;

    public static synchronized WebDriver getDriver(Environment environment, MutableCapabilities options) {
        if (driver == null) {
            if (environment == Environment.LOCAL_CHROME) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = (ChromeOptions) options;
                driver = new ChromeDriver(chromeOptions);
            } else {
                throw new IllegalArgumentException("Unsupported environment: " + environment);
            }
        }
        return driver;
    }

    public static synchronized WebDriver getRemoteDriver(String remoteUrl, MutableCapabilities options) throws MalformedURLException {
        URL url = new URL(remoteUrl);
        return new RemoteWebDriver(url, options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
