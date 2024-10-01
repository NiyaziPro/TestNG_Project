package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P10_CheckOutPage {
    public P10_CheckOutPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//label")
    public List<WebElement> billingDetailsTitleList;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input")
    public List<WebElement> billingDetailsList;

    @FindBy(id = "billing_first_name")
    public WebElement firstNameBox;

    @FindBy(id = "billing_last_name")
    public WebElement lastNameBox;

    @FindBy(id = "billing_company")
    public WebElement companyNameBox;

    @FindBy(id = "select2-billing_country-container")
    public WebElement countryRegionBox;

    @FindBy(id = "billing_address_1")
    public WebElement streetAddressBox;

    @FindBy(id = "billing_address_2")
    public WebElement streetAddressSecondBox;

    @FindBy(id = "billing_city")
    public WebElement townCityBox;

    @FindBy(id = "select2-billing_state-container")
    public WebElement stateBox;

    @FindBy(id = "billing_postcode")
    public WebElement postZipCodeBox;

    @FindBy(id = "billing_phone")
    public WebElement phoneBox;

    @FindBy(id = "billing_email_field")
    public WebElement emailAddressBox;

    @FindBy(id = "createaccount")
    public WebElement createAccountCheckBox;

    @FindBy(id = "ship-to-different-address-checkbox")
    public WebElement shipToDifferentAddressCheckBox;

    @FindBy(id = "order_comments")
    public WebElement orderNotesBox;

    @FindBy(id = "payment_method_bacs")
    public WebElement wireTransferEftRadioButton;

    @FindBy(id = "payment_method_cod")
    public WebElement payAtTheDoorRadioButton;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;


}
