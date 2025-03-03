package step_def;

import io.cucumber.java.en.Then;
import pages.RegisterPage;
import org.testng.Assert;

import static utils.Driver.getDriver;

public class Validate_Numeric_Mobile_Number_in_Register_Stepdef {

    RegisterPage registerPage=new RegisterPage(getDriver());
    String expected="";
    String actual="";

    @Then("{string} alanında sadece sayısal değerin olduğu kanıtlanır")
    public void alanındaSadeceSayısalDeğerinOlduğuKanıtlanır(String arg0) {
        expected =arg0;
        registerPage.getPhoneNumberInput().sendKeys(arg0);
        actual=registerPage.getPhoneNumberInput().getText();
        Assert.assertNotEquals( expected, actual);


    }



}
