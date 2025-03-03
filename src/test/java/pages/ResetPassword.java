package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPassword {
    private WebDriver driver;

    public ResetPassword(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//input[@autocomplete='new-password']")
    private WebElement resetpasswordInput;

    @FindBy(xpath = "//input[@placeholder='Password confirm']")
    private WebElement resetpasswordConfirmInput;

    @FindBy(xpath = "//button[span[contains(text(), 'Reset password')]]")
    private WebElement resetPaswordButton;

    public WebElement getResetPasswordInput() {return resetpasswordInput;}
    public WebElement getResetPasswordConfirmInput() {return resetpasswordConfirmInput;}
    public WebElement getResetPaswordButton() {return resetPaswordButton;}


}
