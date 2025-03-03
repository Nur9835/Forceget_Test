package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.Driver;
import utils.SeleniumHelper;

import static utils.SeleniumHelper.wait_second;

public class Login_Success_Stepdef {
    LoginPage loginPage= new LoginPage(Driver.getDriver());
    String expectedUrl = "https://app.forceget.com/reporting/customer-dashboard";
    String actualUrl ;


    @When("giriş yap sayfasinda email bolumune {string} girilir")
    public void girişYapSayfasindaEmailBolumuneGirilir(String arg0) {
        loginPage.getLoginEmailInput().sendKeys(arg0);
        SeleniumHelper.screenshot();
        wait_second(1);
    }


    @And("giriş yap sayfasinda password bolumune {string} girilir")
    public void girişYapSayfasindaPasswordBolumuneGirilir(String arg0) {
        loginPage.getLoginPasswordInput().sendKeys(arg0);
        SeleniumHelper.screenshot();
        wait_second(1);
    }

    @And("Sign In butonu tıklanır")
    public void signInButonuTıklanır() {
        SeleniumHelper.screenshot();
        loginPage.getLoginButton().click();


    }

    @Then("Başarılı bir şekilde giriş yapıldığı doğrulanır")
    public void başarılıBirŞekildeGirişYapıldığıDoğrulanır() {
        wait_second(8);
        SeleniumHelper.screenshot();
        actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }


}
