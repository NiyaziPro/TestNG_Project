package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalCarPage {

    public BlueRentalCarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = " //a[.=' Login']")
    public WebElement loginButton;

    @FindBy(id = "formBasicEmail")
    public WebElement emailBox;

    @FindBy(id = "formBasicPassword")
    public WebElement passwordBox;

    @FindBy(id = "dropdown-basic-button")
    public WebElement dropDownMenu;

    @FindBy(xpath = "//*[contains(text(), 'not found')]")
    public WebElement negativeLoginVerify;

    @FindBy(tagName = "em")
    public WebElement emailVerify;

    @FindBy(xpath = "//*[.='Profile']")
    public WebElement profileLink;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//*[.='OK']")
    public WebElement oKButton;

}
