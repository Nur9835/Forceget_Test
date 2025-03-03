package step_def;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ForgotPassword;
import pages.LoginPage;
import utils.Driver;
import utils.SeleniumHelper;

import static utils.SeleniumHelper.wait_second;

public class Disable_send_email_button_when_Empty_email_format_Forgot_Password_Panel_Stepdef {
    LoginPage loginPage= new LoginPage(Driver.getDriver());
    ForgotPassword forgotPassword= new ForgotPassword(Driver.getDriver());

    String expectedUrl = "https://app.forceget.com/system/account/forgot-password";
    String actualUrl = "";

    @And("Forgot password link butonuna tıklanır")
    public void forgotPasswordLinkButonunaTıklanır() {
        wait_second(3);
        loginPage.getForgotPasswordLink().click();
        wait_second(3);
    }


    @Then("Şifremi unuttum sayfasına yönlendirildiği doğrulanır")
    public void şifremiUnuttumSayfasınaYönlendirildiğiDoğrulanır() {
        actualUrl=Driver.getDriver().getCurrentUrl();
        SeleniumHelper.screenshot();
        Assert.assertEquals( expectedUrl, actualUrl);
        wait_second(3);

    }

    @Then("Send password reset link butonunun disable olduğu doğrulanır")
    public void sendPasswordResetLinkButonununDisableOlduğuDoğrulanır() {
        String disabledAttribute= forgotPassword.getSendPasswordButton().getAttribute("disabled");
        SeleniumHelper.screenshot();
        Assert.assertNotNull("Buton disabled değil!", disabledAttribute);
    }
}
