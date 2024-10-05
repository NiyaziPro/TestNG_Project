package techproed.allovercommerce.pages;

import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='widget_shopping_cart_content']/ul")
    public List<WebElement> cartProductsList;

    @FindBy(className = "cart-count")
    public WebElement cartCount;

    @FindBy(xpath = "(//table/tbody)[1]/tr")
    public List<WebElement> productsList;

    public boolean doesListContainText(String textToFind) {
        for (WebElement w : productsList) {
            if (w.getText().contains(textToFind)) {
                return true;
            }
        }
        return false;
    }

    @FindBy(xpath = "//input[@type='number']")
    public List<WebElement> quantityNumberList;

    public WebElement quantityNumber() {
        if (quantityNumberList != null && !quantityNumberList.isEmpty()) {
            return quantityNumberList.get(quantityNumberList.size() - 1);
        } else {
            return null;
        }
    }


    @FindBy(xpath = "//button[@title='Plus']")
    public List<WebElement> quantityPlusButtonList;

    public WebElement quantityPlusButton() {
        if (quantityPlusButtonList != null && !quantityPlusButtonList.isEmpty()) {
            return quantityPlusButtonList.get(quantityPlusButtonList.size() - 1);
        } else {
            throw new NoSuchElementException("quantityPlusButtonList is either null or empty.");
        }
    }

    @FindBy(xpath = "//button[@title='Minus']")
    public List<WebElement> quantityMinusButtonList;

    public WebElement quantityMinusButton() {
        if (quantityMinusButtonList != null && !quantityMinusButtonList.isEmpty()) {
            return quantityMinusButtonList.get(quantityMinusButtonList.size() - 1);
        } else {
            throw new NoSuchElementException("quantityPlusButtonList is either null or empty.");
        }
    }

    @FindBy(name = "update_cart")
    public WebElement updateCartButton;


}
