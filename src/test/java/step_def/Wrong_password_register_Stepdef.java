package step_def;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pages.RegisterPage;
import utils.Driver;

public class Wrong_password_register_Stepdef {
    RegisterPage registerPage=new RegisterPage(Driver.getDriver());

    @Then("Password is not strong enough uyarısı vermeli")
    public void passwordIsNotStrongEnoughUyarısıVermeli() {
      Assert.assertEquals("Password is not strong enough", registerPage.getWrongPasswordText().getText());

    }



}
