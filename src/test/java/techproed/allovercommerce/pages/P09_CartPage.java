package techproed.allovercommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P09_CartPage {
    public P09_CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[text()='View cart']")
    public WebElement viewCartButton;

//    @FindBy(xpath = "//tbody[1]/tr")
//    public List<WebElement> cartProductsList;

    @FindBy(xpath = "//*[@class='widget_shopping_cart_content']/ul")
    public List<WebElement> cartProductsList;

    @FindBy(className = "cart-count")
    public WebElement cartCount;


}
