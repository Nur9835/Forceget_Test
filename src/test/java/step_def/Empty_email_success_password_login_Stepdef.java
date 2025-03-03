package step_def;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.Driver;

public class Empty_email_success_password_login_Stepdef {
    LoginPage loginPage= new LoginPage(Driver.getDriver());
    String expectedWarning="Please fill the required fields!";
    String actualWarning;

    @Then("Lütfen gerekli alanları doldurun! uyarısı verilmeli")
    public void lütfenGerekliAlanlarıDoldurunUyarısıVerilmeli() {
        actualWarning=loginPage.getWarningRequiredFields().getText();
        //Lütfen gerekli alanları doldurun! uyarısı verildiği doğrulanır
        Assert.assertEquals(expectedWarning, actualWarning);


    }
}
