package techproed.tests.medunnaproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenuDropDown;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;


    @FindBy(id = "ssn")
    public WebElement ssnBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnInvalidMessage;

    @FindBy(id = "firstName")
    public WebElement firstNameBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement firstNameInvalidMessage;

    @FindBy(id = "lastName")
    public WebElement lastNameBox;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[3]")
    public WebElement lastNameInvalidMessage;


}
