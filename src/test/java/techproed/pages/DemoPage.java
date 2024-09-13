package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class DemoPage {

    public DemoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailBox;


    @FindBy(id = "imagesrc")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement phoneBox;

    @FindBy(xpath = "//input[@value='Male']")
    public WebElement genderRadioButton;

    @FindBy(id = "checkbox3")
    public WebElement checkBox3;

    @FindBy(id = "checkbox2")
    public WebElement checkBox2;

    @FindBy(id = "checkbox1")
    public WebElement checkBox1;

    @FindBy(tagName = "multi-select")
    public WebElement languageDropDownBox;

    @FindBy(xpath = "//*[.='Turkish']")
    public WebElement optionLanguageTurkish;

    @FindBy(id = "Skills")
    public WebElement skillsDropDownBox;

    @FindBy(id = "countries")
    public WebElement countriesDropDownBox;

    @FindBy(id = "country")
    public WebElement selectCountryDropDownBox;

    @FindBy(id = "yearbox")
    public WebElement yearDropDownBox;

    @FindBy(xpath = "//*[@ng-model='monthbox']")
    public WebElement monthDropDownBox;

    @FindBy(id = "daybox")
    public WebElement dayDropDownBox;

    @FindBy(id = "firstpassword")
    public WebElement firstPasswordBox;

    @FindBy(id = "secondpassword")
    public WebElement confirmPasswordBox;

    @FindBy(id = "submitbtn")
    public WebElement submitButton;

    @FindBy(id = "Button1")
    public WebElement refreshButton;



 /*
--------------- fake mail sitesi-------------------
  */

    //fake email sitesine ait zamandan kazanmak icin burada olusturduk
    @FindBy(id = "email")
    public WebElement fakeEmail;

}


