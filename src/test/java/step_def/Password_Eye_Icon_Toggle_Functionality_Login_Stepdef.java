package step_def;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import utils.Driver;

import static utils.SeleniumHelper.wait_second;

public class Password_Eye_Icon_Toggle_Functionality_Login_Stepdef {
    LoginPage loginPage= new LoginPage(Driver.getDriver());
    String passwordType;


    @Then("giriş yap sayfasında password alanında buulunan eye icon tıklandığında kullanıcının girdiği passwordu görünür şekilde göstermeli")
    public void giriş_yap_sayfasında_password_alanında_buulunan_eye_icon_tıklandığında_kullanıcının_girdiği_passwordu_görünür_şekilde_göstermeli() {
        loginPage.getPasswordEyeIconButton().click();
        wait_second(2);
        passwordType = loginPage.getLoginPasswordInput().getAttribute("type");
        //Şifrenin görünür olduğu kanıtlanır
        Assert.assertEquals("text", passwordType);

    }
    @Then("giriş yap sayfasında password alanında buulunan eye icon {int}.kez tıklandığında kullanıcının girdiği passwordu maskeli şekilde göstermeli")
    public void giriş_yap_sayfasında_password_alanında_buulunan_eye_icon_kez_tıklandığında_kullanıcının_girdiği_passwordu_maskeli_şekilde_göstermeli(Integer int1) {
        wait_second(2);
        loginPage.getPasswordEyeIconButton().click();
        wait_second(2);
        passwordType = loginPage.getLoginPasswordInput().getAttribute("type");
        //Şifrenin maskeli olduğu kanıtlanır
        Assert.assertEquals("password", passwordType);
    }
}
