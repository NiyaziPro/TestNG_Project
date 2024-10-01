package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P15_VendorAddressesPage {
    public P15_VendorAddressesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='woocommerce-Address'])[1]/a")
    public WebElement billingAddressADDButton;

    @FindBy(xpath = "//*[text()='Edit Your Billing Address']")
    public WebElement editYourBillingAddress;

    @FindBy(xpath = "//div[@class='woocommerce-address-fields']/div/p")
    public List<WebElement> billingAddressDetailsList;

    @FindBy(xpath = "//div[@class='woocommerce-address-fields']/div/p/span/input")
    public List<WebElement> billingAddressInputBoxesList;

    @FindBy(id = "billing_first_name")
    public WebElement firstNameBox;

    @FindBy(id = "billing_last_name")
    public WebElement lastNameBox;

    @FindBy(id = "billing_company")
    public WebElement companyNameBox;

    @FindBy(id = "select2-billing_country-container")
    public WebElement countryRegionBox;

    @FindBy(xpath = "(//*[@class='select2-selection__arrow'])[1]")
    public WebElement openCountryDropDown;

    @FindBy(xpath = "(//*[@class='select2-selection__arrow'])[2]")
    public WebElement openStateDropDown;

    @FindBy(className = "select2-search__field")
    public WebElement inputForDropDownBox;

    @FindBy(id = "billing_address_1")
    public WebElement streetAddressBox;

    @FindBy(id = "billing_address_2")
    public WebElement streetAddressSecondBox;

    @FindBy(id = "billing_city")
    public WebElement townCityBox;

    @FindBy(id = "billing_postcode")
    public WebElement postZipCodeBox;

    @FindBy(id = "billing_phone")
    public WebElement phoneBox;

    @FindBy(name = "billing_email")
    public WebElement emailAddressBox;

    @FindBy(xpath = "//button[text()='Save address']")
    public WebElement saveAddressButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public List<WebElement> alertMessageList;

    @FindBy(xpath = "//*[text()='Address changed successfully.']")
    public WebElement addressChangedSuccessfullyMsg;



}
