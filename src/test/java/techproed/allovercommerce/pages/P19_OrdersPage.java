package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P19_OrdersPage {
    public P19_OrdersPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[text()='Go Shop']")
    public WebElement goShopButton;

    @FindBy(xpath = "//tbody//a")
    public List<WebElement> ordersList;

    @FindBy(xpath = "//*[text()='Order details']")
    public WebElement orderDetails;

}
