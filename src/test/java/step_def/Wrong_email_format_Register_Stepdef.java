package step_def;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.RegisterPage;
import org.testng.Assert;
import utils.SeleniumHelper;

import static utils.Driver.getDriver;
import static utils.SeleniumHelper.*;

public class Wrong_email_format_Register_Stepdef {

    RegisterPage  registerPage=new RegisterPage(getDriver());

    @Given("uyelik sayfasinda firstName bolumune {string} girilir")
    public void uyelik_sayfasinda_first_name_bolumune_girilir(String string) {
        wait_second(5);
        registerPage.getNameInput().sendKeys(string);
        SeleniumHelper.screenshot();
        wait_second(1);

    }

    @Given("uyelik sayfasinda lastName bolumune {string} girilir")
    public void uyelik_sayfasinda_last_name_bolumune_girilir(String string) {
        registerPage.getlastNameInput().sendKeys(string);
        SeleniumHelper.screenshot();
        wait_second(1);
    }

    @Given("uyelik metni icin {string} checkbox secilir")
    public void uyelik_metni_icin_checkbox_secilir(String string) {

    }

    @Given("uyelik sayfasinda mobileNumber bolumune {string} girilir")
    public void uyelik_sayfasinda_mobile_number_bolumune_girilir(String string) {
        registerPage.getPhoneNumberInput().sendKeys(string);
        SeleniumHelper.screenshot();
        wait_second(1);
    }

    @Given("uyelik sayfasinda company bolumune {string} girilir")
    public void uyelik_sayfasinda_company_bolumune_girilir(String string) {

        registerPage.getCompanyNameInput().sendKeys(string);
        SeleniumHelper.screenshot();
        wait_second(1);
    }

    @Given("uyelik sayfasinda password bolumune {string} girilir")
    public void uyelik_sayfasinda_password_bolumune_girilir(String string) {
        registerPage.getPasswordInput().sendKeys(string);
        SeleniumHelper.screenshot();
        wait_second(1);
    }

    @Given("uyelik sayfasinda confirmPassword bolumune {string} girilir")
    public void uyelik_sayfasinda_confirm_password_bolumune_girilir(String string) {
        registerPage.getPasswordConfirmInput().sendKeys(string);
        SeleniumHelper.screenshot();
        wait_second(1);
    }

    @Given("KVKK onaylanmalı")
    public void kvkk_onaylanmalı() {
        wait_second(2);
        clickElementByJS(getDriver(),registerPage.getKvkk());
        SeleniumHelper.screenshot();
        wait_second(5);
        waitForElementToExist2(getDriver(),registerPage.getKvkkAccept());
        SeleniumHelper.screenshot();
        registerPage.getKvkkAccept().click();
        wait_second(5);

    }

    @Then("Agree&Sign-Up butonu tıklanabilir olmamalı")
    public void agree_sign_up_butonu_tıklanabilir_olmamalı() {
        wait_second(5);
        //buton görünmemeli
        Assert.assertFalse(registerPage.getRegisterButton().isDisplayed());

    }

    @And("uyelik sayfasında country bolumune {string} checkbox secilir")
    public void uyelikSayfasındaCountryBolumuneCheckboxSecilir(String string) {
        registerPage.getCountryDropdownText().sendKeys(string);
        SeleniumHelper.screenshot();
        wait_second(2);
        getDriver().findElement(By.xpath("//nz-option-item")).click();

    }

    @And("uyelik sayfasinda title bolumune {string} checkbox secilir")
    public void uyelikSayfasindaTitleBolumuneCheckboxSecilir(String string) {
        registerPage.getJobTitleDropdownText().sendKeys(string);
        wait_second(2);
        SeleniumHelper.screenshot();
        getDriver().findElement(By.xpath("//nz-option-item")).click();

    }

    @And("uyelik sayfasinda email bolumune {string} girilir")
    public void uyelikSayfasindaEmailBolumuneGirilir(String string) {
        registerPage.getEmailInput().sendKeys(string);
        SeleniumHelper.screenshot();
    }




    @Then("uyelik sayfasinda E-mail input border colour kırmızı olmalı ve kayıt işlemi gerçekleşmemeli")
    public void uyelikSayfasindaEMailInputBorderColourKırmızıOlmalıVeKayıtIşlemiGerçekleşmemeli() {
        WebElement emailInput = getDriver().findElement(By.xpath("//input[contains(@class, 'ant-input-status-error')]"));
        wait_second(2);
        SeleniumHelper.screenshot();
        Assert.assertNotNull( emailInput);

    }
}
