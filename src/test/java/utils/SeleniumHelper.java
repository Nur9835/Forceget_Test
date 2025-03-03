package utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SeleniumHelper {

    //öğenin sayfada var olmasını bekler
    public static void waitForElementToExist(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementToExist2(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    //Bu metod, öğenin görünür olmasını bekler.
    public static void waitForElementToBeVisible(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    //Bu metod, öğelerin sayısının sıfırdan fazla olmasını bekle
    public static void waitForNotToEmptyList(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(driver1 -> driver.findElements(locator).size() > 0);
    }

    public static void wait_second(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Bu metod, öğenin tıklanabilir olmasını bekler.
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
    }

    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void scroll_pixel(int scrollSize) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, " + scrollSize + ");");
    }

    public static void screenshot() {
        byte[] screen = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screen));
    }

    //scroll sonuna

    public static void scrollToBottom(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long lastHeight = (long) jsExecutor.executeScript("return arguments[0].scrollHeight", element);
        while (true) {
            jsExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", element);

            long newHeight = (long) jsExecutor.executeScript("return arguments[0].scrollHeight", element);

            // Eğer yeni yükseklik eski yüksekliğe eşitse, sonuna gelindi demektir
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Panelin sonuna gelindi");
    }

    //100 pixel olacak şekilde scroll sonuna
    public static List<String> scrollAndCollectItems(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<String> allItems = new ArrayList<>();
        long lastHeight = (long) jsExecutor.executeScript("return arguments[0].scrollHeight", element);
        long currentScroll = (long) jsExecutor.executeScript("return arguments[0].scrollTop;", element);

        while (true) {
            // Şu an görünen öğeleri al
            List<WebElement> elements = driver.findElements(By.xpath("//nz-option-item//descendant::span[contains(@class,'truncate')]"));

            for (WebElement el : elements) {
                allItems.add(el.getText()); // itemları listeye ekle
            }

            // 100px aşağı kaydır
            jsExecutor.executeScript("arguments[0].scrollTop += 100;", element);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Yeni kaydırma yüksekliğini al
            long newScroll = (long) jsExecutor.executeScript("return arguments[0].scrollTop;", element);

            // Eğer scroll değişmiyorsa, yani en aşağıdaysa, döngüden çık
            if (newScroll == currentScroll) {
                break;
            }

            currentScroll = newScroll; // Yeni scroll değerini güncelle
        }

        System.out.println("Toplam öğe sayısı: " + allItems.size());
        return allItems;
    }

    //benzersiz liste
    public static List<String> removeDuplicatesAndKeepOrder(List<String> items) {
        Set<String> uniqueItems = new LinkedHashSet<>(items);
        List<String> finalList = new ArrayList<>(uniqueItems);
        return finalList;
    }




}