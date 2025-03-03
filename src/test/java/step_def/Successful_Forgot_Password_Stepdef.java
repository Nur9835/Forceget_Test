package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ForgotPassword;
import pages.ResetPassword;
import utils.Driver;
import static utils.SeleniumHelper.wait_second;

import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class Successful_Forgot_Password_Stepdef {
    ForgotPassword forgotPassword= new ForgotPassword(Driver.getDriver());
    ResetPassword resetPassword= new ResetPassword(Driver.getDriver());
    WebDriver driver;
    String email ="testnur9@gmail.com" ;
    String password ="TestNur3300.";

    String expectedUrl = "https://app.forceget.com/system/account/forgot-password";
    String actualUrl ;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Then("A password reset link has been sent to your email address. uyarısının olduğu doğrulanır")
    public void aPasswordResetLinkHasBeenSentToYourEmailAddressUyarısınınOlduğuDoğrulanır() {
        wait_second(2);
        Assert.assertTrue(forgotPassword.getSendPasswordMessage().isDisplayed());
    }



    @And("Kullanıcı Google hesabına giriş yapar")
    public void kullanıcıGoogleHesabınaGirişYapar() {
        driver = new ChromeDriver();
        SeleniumHelper.screenshot();
        driver.get("https://mail.google.com");
        SeleniumHelper.screenshot();
        // Gmail login işlemi
        SeleniumHelper.screenshot();
        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.sendKeys(email);
        SeleniumHelper.screenshot();
        driver.findElement(By.id("identifierNext")).click();
        wait_second(5);
        SeleniumHelper.screenshot();
        // Şifreyi giriyoruz
        WebElement passwordInput = driver.findElement(By.name("Passwd"));
        passwordInput.sendKeys(password);
        SeleniumHelper.screenshot();
        wait_second(2);
        driver.findElement(By.id("passwordNext")).click();


    }

    @And("Gelen e-postada {string} başlığı içeren e-posta bulunur")
    public void gelenEPostadaBaşlığıIçerenEPostaBulunur(String arg0) {
        wait_second(5);
        SeleniumHelper.screenshot();
        driver.get("https://mail.google.com/mail/u/0/#spam");
        SeleniumHelper.screenshot();
        wait_second(5);
        // "Forget Password Reset" başlığını içeren e-postayı buluyoruz
        WebElement emailLink = driver.findElement(By.xpath("(//span[contains(text(), 'Forceget Password Reset')])[2]"));
        SeleniumHelper.screenshot();
        emailLink.click();
        wait_second(5);// E-postayı açıyoruz
    }


    @And("E-posta içeriğindeki {string} butonuna tıklanır")
    public void ePostaIçeriğindekiButonunaTıklanır(String arg0) {

        WebElement resetButton = driver.findElement(By.xpath("//a[contains(@href, 'forceget.com/account/forgot-password')]"));
        SeleniumHelper.screenshot();
        resetButton.click();
        SeleniumHelper.screenshot();
        wait_second(3);
        //google onaylama
        WebElement openAnywayButton = driver.findElement(By.xpath("//button[.//span[text()='Open anyway']]"));
        SeleniumHelper.screenshot();
        openAnywayButton.click();
        wait_second(3);

    }


    @When("şifre değiştirme sayfasinda password bolumune kurallara uygun {string} girilir")
    public void şifreDeğiştirmeSayfasindaPasswordBolumuneKurallaraUygunGirilir(String arg0) {
        SeleniumHelper.screenshot();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@autocomplete='new-password']")));
//
//        if (element.isDisplayed()) {
//            element.sendKeys("your_password_here");
//        } else {
//            System.out.println("Öğe görünür değil!");
//        }
//
//    resetPassword.getResetPasswordInput().sendKeys(arg0);
//    wait_second(3);

    }

    @And("şifre değiştirme sayfasinda confirm password bolumune kurallara uygun {string} girilir")
    public void şifreDeğiştirmeSayfasindaConfirmPasswordBolumuneKurallaraUygunGirilir(String arg0) {
//        resetPassword.getResetPasswordConfirmInput().sendKeys(arg0);
//        wait_second(3);
//

    }

    @And("Reset password butonu tıklanır")
    public void resetPasswordButonuTıklanır() {
//        resetPassword.getResetPaswordButton().click();
//        wait_second(3);

    }

}
