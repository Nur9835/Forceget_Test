package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//forceget-country-dropdown//nz-select")
    private WebElement countryDropdown;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(id = "companyName")
    private WebElement companyNameInput;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//nz-select[@formcontrolname='jobTitle']")
    private WebElement jobTitleDropdown;

    @FindBy(xpath = "//nz-select[@formcontrolname='jobTitle']//descendant::input")
    private WebElement jobTitleDropdownText;


    @FindBy(xpath = "//forceget-country-dropdown//descendant::input")
    private WebElement countryDropdownText;


    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@formcontrolname='passwordConfirm']")
    private WebElement passwordConfirmInput;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement kvkk;

    @FindBy(xpath = "//button[span[contains(text(), 'Accept')]]")
    private WebElement kvkkAccept;

    @FindBy(xpath = "//button[span[contains(text(), 'Agree & Sign-Up')]]")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@href='/account/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[text()=\"Password is not strong enough\"]")
    private WebElement wrongPasswordText;

    @FindBy(xpath = "//h1")
    private WebElement pageTitle;

    @FindBy(xpath = "(//i[contains(@class, 'anticon-eye')])[1]")
    private WebElement passwordEyeIconButton;

    @FindBy(xpath = "(//i[contains(@class, 'anticon-eye')])[2]")
    private WebElement confirmPasswordEyeIconButton;

    @FindBy(xpath = "//nz-select-arrow[contains(@class,'ant-select-arrow ng-tns-c364634890-7')]")
    private WebElement titleDownButton;


    @FindBy(xpath = "//nz-select-arrow[contains(@class,'ant-select-arrow ng-tns-c364634890-11 ')]")
    private WebElement countryDownButton;


    @FindBy(xpath = "//nz-option-item")
    private List<WebElement> allOptions;


    @FindBy(xpath = "//cdk-virtual-scroll-viewport")
    private WebElement scrollCountry;



    @FindBy(xpath = "//div[contains(text(), 'This email is already associated with an account. Please use a different email or login')]")
    private WebElement recordedEmail;



    public WebElement getNameInput() {return firstNameInput;}
    public WebElement getlastNameInput() {return lastNameInput;}
    public WebElement getCountryDropdown() {return countryDropdown;}
    public WebElement getCountryDropdownText() {return countryDropdownText;}
    public WebElement getPhoneNumberInput() {return phoneNumberInput;}
    public WebElement getCompanyNameInput() {return companyNameInput;}
    public WebElement getEmailInput() {return emailInput;}
    public WebElement getJobTitleDropdown() {return jobTitleDropdown;}
    public WebElement getJobTitleDropdownText() {return jobTitleDropdownText;}
    public WebElement getPasswordInput() {return passwordInput;}
    public WebElement getPasswordConfirmInput() {return passwordConfirmInput;}
    public WebElement getKvkk() {return kvkk;}
    public WebElement getKvkkAccept() {return kvkkAccept;}
    public WebElement getRegisterButton() {return registerButton;}
    public WebElement getLoginLink() {return loginLink;}
    public WebElement getWrongPasswordText() {return wrongPasswordText;}
    public WebElement getPageTitle() {return pageTitle;}
    public WebElement getPasswordEyeIconButton() {return passwordEyeIconButton;}
    public WebElement getConfirmPasswordEyeIconButton() {return confirmPasswordEyeIconButton;}
    public WebElement getTitleDownButton() {return titleDownButton;}
    public WebElement getCountryDownButton() {return countryDownButton;}



    public WebElement getRecordedEmail() {return recordedEmail;}

    public List<String> getAllOptionTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement option : allOptions) {
            titles.add(option.getAttribute("title"));
        }
        return titles;
    }



    public WebElement getScrollCountry() {return scrollCountry;}






    public LoginPage registerButtonClick() {
        registerButton.click();
        return new LoginPage(driver);
    }



}
