package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[type='email']")
    private WebElement loginEmailInput;

    @FindBy(css = "[formcontrolname='password']")
    private WebElement loginPasswordInput;

    @FindBy(xpath = "//button[span[contains(text(), 'Sign In')]]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/account/forgot-password']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[contains(text(), ' Sign-up')]")
    private WebElement registerPageLink;

    @FindBy(xpath = "//button[span[contains(text(), 'Continue with Google')]]")
    private WebElement googleAccountLink;

    @FindBy(xpath = "//h2")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Please fill the required fields!']")
    private WebElement warningRequiredFields;


    @FindBy(xpath = "//div[@role='alert']")
    private WebElement warningRequiredPassword;

    @FindBy(xpath = "//div[text()='Incorrect email or password. Please check your information and try again']")
    private WebElement ıncorrectEmail;

    @FindBy(xpath = "//div[contains(text(), 'Password verification failed')]")
    private WebElement ıncorrectPassword;


    @FindBy(xpath = "//i[contains(@class, 'anticon-eye')]")
    private WebElement passwordEyeIconButton;

    public WebElement getpageTitle() {return pageTitle;}
    public WebElement getLoginEmailInput() {return loginEmailInput;}
    public WebElement getLoginPasswordInput() {return loginPasswordInput;}
    public WebElement getLoginButton() {return loginButton;}
    public WebElement getWarningRequiredFields(){ return  warningRequiredFields;}
    public WebElement getWarningRequiredPassword(){ return  warningRequiredPassword;}
    public WebElement getIncorrectEmail(){ return  ıncorrectEmail;}
    public WebElement getIncorrectPassword(){ return  ıncorrectPassword;}
    public WebElement getRegisterPageLink(){ return  registerPageLink;}
    public WebElement getForgotPasswordLink(){ return  forgotPasswordLink;}
    public WebElement getPasswordEyeIconButton() {return passwordEyeIconButton;}

    public void fillLogin(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }

    public LoggedHomePage fillCorrectLogin(String email, String password) {
        fillLogin(email, password);
        return new LoggedHomePage(driver);
    }

}
