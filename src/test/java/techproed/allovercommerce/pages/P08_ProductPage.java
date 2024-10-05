package techproed.allovercommerce.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P08_ProductPage {
    public P08_ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement addToCartButton;


    public boolean isAddToCartButtonVisible() {
        try {
            return addToCartButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;

        }
    }

    @FindBy(xpath = "//li[contains(text(),'Search results for')]")
    public WebElement searchResultsFor;

    @FindBy(xpath = "//*[text()='No products were found matching your selection.']")
    public WebElement noProductWereFoundMsg;


}
