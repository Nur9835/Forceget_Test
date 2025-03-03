package step_def;

import io.cucumber.java.en.Then;
import pages.RegisterPage;
import utils.Driver;
import org.testng.Assert;
import static utils.SeleniumHelper.wait_second;

public class Password_and_Confirm_Password_Eye_Icon_Toggle_Functionality_Stepdef {

    RegisterPage registerPage=new RegisterPage(Driver.getDriver());
    String passwordType;
    String confirmPasswordType;

    @Then("uyelik sayfasında password alanında buulunan eye icon tıklandığında kullanıcının girdiği passwordu görünür şekilde göstermeli")
    public void uyelik_sayfasında_password_alanında_buulunan_eye_icon_tıklandığında_kullanıcının_girdiği_passwordu_görünür_şekilde_göstermeli() {
        registerPage.getPasswordEyeIconButton().click();
        wait_second(2);
        passwordType = registerPage.getPasswordInput().getAttribute("type");
        //Şifrenin görünür olduğu kanıtlanır
        Assert.assertEquals("text", passwordType);

    }

    @Then("uyelik sayfasında confirmpassword alanında bulunan eye icon tıklandığında kullanıcının girdiği passwordu görünür şekilde göstermeli")
    public void uyelik_sayfasında_confirmpassword_alanında_bulunan_eye_icon_tıklandığında_kullanıcının_girdiği_passwordu_görünür_şekilde_göstermeli() {
        registerPage.getConfirmPasswordEyeIconButton().click();
        wait_second(2);
        confirmPasswordType = registerPage.getPasswordConfirmInput().getAttribute("type");
        // Yinelenen şifrenin görünür olduğu kanıtlanır
        Assert.assertEquals("text", confirmPasswordType);
    }

    @Then("uyelik sayfasında password alanında buulunan eye icon {int}.kez tıklandığında kullanıcının girdiği passwordu maskeli şekilde göstermeli")
    public void uyelik_sayfasında_password_alanında_buulunan_eye_icon_kez_tıklandığında_kullanıcının_girdiği_passwordu_maskeli_şekilde_göstermeli(Integer int1) {
        registerPage.getPasswordEyeIconButton().click();
        wait_second(2);
        passwordType = registerPage.getPasswordInput().getAttribute("type");
        //Şifrenin maskeli olduğu kanıtlanır
        Assert.assertEquals("password", passwordType);
    }

    @Then("uyelik sayfasında confirmpassword alanında bulunan eye icon {int}.kez tıklandığında kullanıcının girdiği passwordu maskeli şekilde göstermeli")
    public void uyelik_sayfasında_confirmpassword_alanında_bulunan_eye_icon_kez_tıklandığında_kullanıcının_girdiği_passwordu_maskeli_şekilde_göstermeli(Integer int1) {
        registerPage.getConfirmPasswordEyeIconButton().click();
        wait_second(2);
        confirmPasswordType = registerPage.getPasswordConfirmInput().getAttribute("type");
        //Yinelenen şifrenin maskeli olduğu kanıtlanır
        Assert.assertEquals("password", confirmPasswordType);

    }




}
