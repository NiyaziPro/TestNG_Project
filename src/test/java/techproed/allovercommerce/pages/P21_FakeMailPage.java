package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class P21_FakeMailPage {
    public P21_FakeMailPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[@class='select2-selection__arrow'])[1]")
    public WebElement openCountryDropDown;

    @FindBy(partialLinkText = "Addresses")
    public WebElement adresses;

    @FindBy(xpath = "//a[text()='Edit Your Shipping Address']")
    public WebElement shippingAdresses;

    @FindBy(className = "select2-search__field")
    public WebElement inputCountryRegion;

}
