package step_def;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Driver.getDriver;
import static utils.SeleniumHelper.wait_second;

public class Empty_Field_Register_Stepdef {


    @Then("İlgili inputun border colour kırmızı  olmalı ve kayıt işlemi gerçekleşmemeli")
    public void ilgiliInputunBorderColourKırmızıOlmalıVeKayıtIşlemiGerçekleşmemeli() {

        WebElement emailInput = getDriver().findElement(By.xpath("//input[contains(@class, 'ant-input-status-error')]"));
        wait_second(2);
        Assert.assertNotNull( emailInput);

    }
}
