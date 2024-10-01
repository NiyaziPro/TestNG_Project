package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class P16_VendorStoreManagerPage {
    public P16_VendorStoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[contains(text(),'Coupons')]")
    public WebElement couponsLink;


}
