package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P20_VendorCouponsPage {

    public P20_VendorCouponsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNewButton;

    @FindBy(css = "#title")
    public WebElement codeBox;

    @FindBy(css = "#description")
    public WebElement descriptionBox;

    @FindBy(css = "#discount_type")
    public WebElement discountTypeDropDown;

    @FindBy(css = "#coupon_amount")
    public WebElement couponAmountBox;

    @FindBy(css = "#expiry_date")
    public WebElement expiryDatetBox;

    @FindBy(css = "#free_shipping")
    public WebElement allowFreeShippingCheckBox;

    @FindBy(css = "#show_on_store")
    public WebElement showOnStoreCheckBox;

    @FindBy(css = "#wcfm_coupon_manager_submit_button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='wcfm_dashboard_item_title']")
    public List<WebElement> couponsList;

    @FindBy(css = ".wcicon-status-cancelled")
    public WebElement cancelledMessage;


}
