package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Driver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Driver zaten başlatılmışsa, yeni bir tane başlatma
        if (Driver.getDriver() == null) {
            initializeDriver();
        }

        driver = Driver.getDriver();

        // Eğer birden fazla pencere varsa, ilk pencereye geç
        if (driver.getWindowHandles().size() > 1) {
            // Tüm pencereleri al
            String currentWindowHandle = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(currentWindowHandle)) {
                    // İkinci pencereyi kapat
                    driver.switchTo().window(handle).close();
                }
            }
            // İlk pencereye geri dön
            driver.switchTo().window(currentWindowHandle);
        }

        // URL'yi açmadan önce, sadece 1 pencere olduğundan emin olun
        if (driver.getWindowHandles().size() == 1) {
            String url = ConfigReader.getProperty("url");
            System.out.println("🔗 Açılacak URL: " + url); // Konsolda görmek için
            driver.get(url);
        } else {
            System.out.println("Yeni pencere açılmadı, mevcut pencereyi kullanılıyor.");
        }

        // **Bot algılanmasını önlemek için JavaScript kullan**
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        // **Bazı Cloudflare korumalarını bypass etmek için ekleme**
        js.executeScript(
                "window.navigator.chrome = { runtime: {} }; " +
                        "Object.defineProperty(navigator, 'languages', { get: () => ['en-US', 'en'] }); " +
                        "Object.defineProperty(navigator, 'plugins', { get: () => [1, 2, 3, 4, 5] });"
        );
    }

    private void initializeDriver() {
        String browser = ConfigReader.getBrowser();
        if (browser == null) {
            throw new IllegalStateException("Browser is not initialized. Check configuration.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                Driver.threadBrowserSet("chrome");
                break;
            case "firefox":
                Driver.threadBrowserSet("firefox");
                break;
            default:
                throw new IllegalArgumentException("Desteklenmeyen tarayıcı: " + browser);
        }
    }

    @After
    public void tearDown() {
        WebDriver driver = Driver.getDriver();
        if (driver != null) {
       //     driver.quit();
        }
      //  Driver.quitDriver();
    }

    public static WebDriver getDriver() {
        return Driver.getDriver();
    }
}
