package step_def;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import utils.Driver;

public class Empty_password_login_Stepdef {
    LoginPage loginPage= new LoginPage(Driver.getDriver());
    String expectedWarning="Please input your Password!";
    String actualWarning;

    @Then("Lütfen Şifrenizi girin! uyarısı verilmeli")
    public void lütfenŞifreniziGirinUyarısıVerilmeli() {
        actualWarning=loginPage.getWarningRequiredPassword().getText();
        Assert.assertEquals(expectedWarning, actualWarning);


    }



}
