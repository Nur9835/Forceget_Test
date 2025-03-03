package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPassword;
import utils.Driver;

import static utils.SeleniumHelper.wait_second;
import org.testng.Assert;
import utils.SeleniumHelper;

public class Unregistered_Email_Forgot_Password_Panel_Stepdef {
    ForgotPassword forgotPassword= new ForgotPassword(Driver.getDriver());

    @When("şifremi unuttum sayfasinda email bolumune {string} girilir")
    public void şifremiUnuttumSayfasindaEmailBolumuneGirilir(String arg0) {
        forgotPassword.getEmailButton().sendKeys(arg0);
        SeleniumHelper.screenshot();
    }

    @And("Send password reset link butonuna tıklanır")
    public void sendPasswordResetLinkButonunaTıklanır() {
        wait_second(3);
        forgotPassword.getSendPasswordButton().click();
        wait_second(3);
        SeleniumHelper.screenshot();
    }

    @Then("A password reset link has been sent to your email address. uyarısının olmadığı doğrulanır")
    public void aPasswordResetLinkHasBeenSentToYourEmailAddressUyarısınınOlmadığıDoğrulanır() {

        //Kayıtlı e-mail olmadığı halde "E-posta adresinize bir şifre sıfırlama bağlantısı gönderildi." mesajı görünmemeli
        // onun yerine "kayıtlı hesap bulunamadı" uyarısı olmalı

        Assert.assertFalse(forgotPassword.getSendPasswordMessage().isDisplayed());
    }


}
