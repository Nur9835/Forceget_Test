package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                System.err.println("❌ config.properties DOSYASI BULUNAMADI!");
            } else {
                properties.load(input);
                System.out.println("✅ config.properties dosyası başarıyla yüklendi!");
            }
        } catch (IOException e) {
            System.err.println("❌ config.properties yüklenemedi! Hata: " + e.getMessage());
        }

    }


    public static String getProperty(String Key){

        return properties.getProperty(Key);
    }

    public static String getBrowser() {
        String browser = System.getenv("BROWSER");
        System.out.println("Environment variable BROWSER: " + browser);

        if (browser == null || browser.isEmpty()) {
            browser = properties.getProperty("browser");
            System.out.println("Fallback to config.properties: " + browser);
        }

        return browser;
    }

    // Remote Debugging modunu kontrol ediyoruz
    public static boolean useRemoteDebugging() {
        String debugValue = properties.getProperty("remoteDebug", "true"); // Varsayılan olarak "true" al
        System.out.println("🔍 useRemoteDebugging() sonucu: " + debugValue);
        return Boolean.parseBoolean(debugValue);
    }


}

