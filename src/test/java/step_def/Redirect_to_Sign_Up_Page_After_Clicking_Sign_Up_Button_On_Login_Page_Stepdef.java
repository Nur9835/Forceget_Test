package step_def;

import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Driver;

import static utils.SeleniumHelper.wait_second;

public class Redirect_to_Sign_Up_Page_After_Clicking_Sign_Up_Button_On_Login_Page_Stepdef {

    LoginPage loginPage= new LoginPage(Driver.getDriver());
    RegisterPage registerPage= new RegisterPage(Driver.getDriver());

    String expectedUrl = "https://app.forceget.com/system/account/register";
    String expectedTitle = "Sign Up";
    String actualTitle="";
    String actualUrl = "";


    @Then("Sign-up linkine tıklanır ve Kayıt ol sayfasına yönlendirildiği kanıtlanır")
    public void signUpLinkineTıklanırVeKayıtOlSayfasınaYönlendirildiğiKanıtlanır() {
        wait_second(5);
        loginPage.getRegisterPageLink().click();
        wait_second(5);


        actualTitle=registerPage.getPageTitle().getText();
        actualUrl=Driver.getDriver().getCurrentUrl();

        //2 assert durumu olduğu için SoftAssert kullanıldı
        SoftAssert softAssert = new SoftAssert();

        //Başlık kontrol edilir
        softAssert.assertEquals( expectedTitle, actualTitle);

        //url kontrol edilir
        softAssert.assertEquals( expectedUrl, actualUrl);
        softAssert.assertAll();


    }
}
