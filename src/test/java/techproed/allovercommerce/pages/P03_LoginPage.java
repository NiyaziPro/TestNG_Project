package techproed.allovercommerce.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class P03_LoginPage {
    public P03_LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "rememberme")
    public WebElement remembermeCheckBox;

    @FindBy(partialLinkText = "Lost your password?")
    public WebElement lostYourPasswordLink;

    @FindBy(name = "login")
    public WebElement signInButton;


}
