package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class MedunnaPage {


    public MedunnaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenuDropDown;


    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//span[.='Admin Batch210']")
    public WebElement loginVerify;

    @FindBy(id = "login-item")
    public WebElement loginButton;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;

    @FindBy(id = "ssn")
    public WebElement ssnTextBox;

    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "username")
    public WebElement userNameTextBox;


    @FindBy(id = "email")
    public WebElement emailTextBox;


    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextBox;

    @FindBy(id = "secondPassword")
    public WebElement secondPasswordTextBox;

    @FindBy(id = "register-submit")
    public WebElement registerSubmitButton;

    @FindBy(xpath = "//*[.='Registration Saved']")
    public WebElement registrationSavedText;




}
