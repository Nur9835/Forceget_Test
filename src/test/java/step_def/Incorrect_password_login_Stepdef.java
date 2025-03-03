package step_def;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import utils.Driver;

import static utils.SeleniumHelper.wait_second;

public class Incorrect_password_login_Stepdef {
    LoginPage loginPage= new LoginPage(Driver.getDriver());

    String expectedError="Password verification failed";

    String actualError;


    @Then("Yanlış e-mail veya passsword uyarısı alınmalı")
    public void yanlışEMailVeyaPassswordUyarısıAlınmalı() {
      //  actualError=loginPage.getIncorrectEmailOrPassword().getText();
      //  Assert.assertEquals(expectedError, actualError);
        wait_second(1);

        Assert.assertTrue( loginPage.getIncorrectEmail().isDisplayed());
    }


    @Then("Parola doğrulama başarısız oldu uyarısı alınmalı")
    public void parolaDoğrulamaBaşarısızOlduUyarısıAlınmalı() {
        wait_second(1);

        Assert.assertTrue( loginPage.getIncorrectPassword().isDisplayed());

//        actualError=.getText();
//        Assert.assertEquals(expectedError, actualError);
    }
}
