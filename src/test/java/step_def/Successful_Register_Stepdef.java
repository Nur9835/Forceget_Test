package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RegisterPage;
import utils.Driver;
import utils.SeleniumHelper;

import static utils.SeleniumHelper.wait_second;

public class Successful_Register_Stepdef {
    RegisterPage  registerPage=new RegisterPage(Driver.getDriver());


    @Given("Kayıt ol sayfasına gidilir")
    public void kayıt_ol_sayfasına_gidilir() {
        wait_second(5);
        SeleniumHelper.screenshot();
    }

    @And("Agree&Sign-Up butonu tıkla")
    public void agreeSignUpButonuTıkla() {
        SeleniumHelper.screenshot();
       registerPage.getRegisterButton().click();
        wait_second(3);

    }



}
