package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Driver;
import static utils.SeleniumHelper.wait_second;
import org.testng.asserts.SoftAssert;

public class Redirect_to_Sign_In_Page_After_Clicking_Sign_In_Button_On_Register_Page_Stepdef {

    RegisterPage registerPage=new RegisterPage(Driver.getDriver());
    LoginPage loginPage= new LoginPage(Driver.getDriver());

    String expectedUrl = "https://app.forceget.com/system/account/login";
    String expectedTitle = "Sign In";
    String actualTitle="";
    String actualUrl = "";

    @And("Sign In linkine tıklanır")
    public void signInLinkineTıklanır() {
        registerPage.getLoginLink().click();
        wait_second(5);
    }

    @Then("Giriş yap sayfasına yönlendirildiği kanıtlanır")
    public void girişYapSayfasınaYönlendirildiğiKanıtlanır() {
        wait_second(3);

        actualTitle=loginPage.getpageTitle().getText();
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
