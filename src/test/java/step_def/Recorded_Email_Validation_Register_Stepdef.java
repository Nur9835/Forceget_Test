package step_def;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.RegisterPage;
import utils.Driver;
import static utils.SeleniumHelper.wait_second;

public class Recorded_Email_Validation_Register_Stepdef {
    RegisterPage registerPage=new RegisterPage(Driver.getDriver());


    @Then("Bu e-posta zaten bir hesapla ilişkilendirilmiş. uyarısını vermeli")
    public void buEPostaZatenBirHesaplaIlişkilendirilmişUyarısınıVermeli() {
        wait_second(1);
        Assert.assertTrue( registerPage.getRecordedEmail().isDisplayed());

    }
}
