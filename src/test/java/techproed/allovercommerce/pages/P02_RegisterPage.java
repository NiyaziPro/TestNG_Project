package techproed.allovercommerce.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class P02_RegisterPage {
    public P02_RegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "reg_username")
    public WebElement usernameBox;

    @FindBy(id = "reg_email")
    public WebElement emailBox;

    @FindBy(id = "reg_password")
    public WebElement passwordBox;

    @FindBy(className = "register_as_vendor")
    public WebElement signUpAsAVendorLink;

    @FindBy(id = "register-policy")
    public WebElement iAgreetoCheckBox;

    @FindBy(xpath = "//*[@name='register']")
    public WebElement signUpButton;

    @FindBy(partialLinkText = "Become a Vendor")
    public WebElement becomeAVendorLink;






}
