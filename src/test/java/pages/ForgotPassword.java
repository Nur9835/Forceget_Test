package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

    private WebDriver driver;

    public ForgotPassword(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[span[contains(text(), 'Send password reset link')]]")
    private WebElement sendPasswordButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailButton;



    @FindBy(xpath = "//p[contains(text(), ' A password reset link has been sent to your email address. Please check your inbox (and spam/junk folder) and follow the instructions. ')]")
    private WebElement sendPasswordMessage;

    public WebElement getSendPasswordButton() {return sendPasswordButton;}
    public WebElement getEmailButton() {return emailButton;}
    public WebElement getSendPasswordMessage() {return sendPasswordMessage;}

}
