package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

    private Driver() {
    }

    static WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static final ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        // İlk kez driver başlatılacaksa, aşağıdaki işlemleri yapıyoruz.
        if (threadDriver.get() == null) {
            initializeDriver();
        }

        return threadDriver.get();
    }

    private static void initializeDriver() {
        String browser = threadBrowserName.get() == null ? "chrome" : threadBrowserName.get();
        switch (browser) {
            case "edge":
                threadDriver.set(new EdgeDriver());
                break;
            case "firefox":
                threadDriver.set(new FirefoxDriver());
                break;
            case "safari":
                threadDriver.set(new SafariDriver());
                break;
            default:
                threadDriver.set(new ChromeDriver());
                break;
        }

        // Driver penceresini maximize et
        threadDriver.get().manage().window().maximize();
    }

    public static void quitDriver() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove(); // Driver'ı ThreadLocal'dan temizle
        }
    }

    public static void goBack() {
        if (threadDriver.get() != null) {
            threadDriver.get().navigate().back();
        } else {
            throw new IllegalStateException("Driver is not initialized!");
        }
    }

    public static void threadBrowserSet(String browser) {
        threadBrowserName.set(browser);
    }
}
