package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class P04_MyAccountPage {
    public P04_MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Addresses")
    public WebElement adressesLink;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerLink;

    @FindBy(linkText = "Orders")
    public WebElement ordersLink;






}
