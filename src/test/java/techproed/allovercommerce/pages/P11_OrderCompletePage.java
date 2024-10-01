package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P11_OrderCompletePage {
    public P11_OrderCompletePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='woocommerce-order']/p")
    public WebElement orderCompletedMsg;


}
