package techproed.allovercommerce.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P07_ShoppingPage {
    public P07_ShoppingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[text()='Add to cart']")
    public List<WebElement> bagIconList;

    public  WebElement bagIcon() {
        for (WebElement icon : bagIconList){
            if (icon.isDisplayed()){
                return icon;
            }
        }
        throw new NoSuchElementException("Görünür sepet simgesi bulunamadı!");

    }


    @FindBy(xpath = "//*[text()='has been added to cart']")
    public WebElement hasBeenAddedToCartMsg;

    @FindBy(xpath = "//div[@class='product-archive']/ul/li//h3")
    public List<WebElement> productsList;

    public WebElement selectedProduct(int productIndex) {
        if (productIndex >= productsList.size()) {
            return productsList.get(productsList.size() - 1);
        } else {
            return productsList.get(productIndex);
        }

    }


}
