package techproed.allovercommerce.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class P01_HomePage {
    public P01_HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Sign In")
    public WebElement signIn;

    @FindBy(partialLinkText = "Register")
    public WebElement register;

    @FindBy(className = "w-icon-heart")
    public WebElement wishlist;

    @FindBy(className = "cart-label")
    public  WebElement cart;

    @FindBy(xpath = "(//input[@type='search'])[1]")
    public WebElement searchbox;


    @FindBy(xpath = "//button[@aria-label='Search Button']")
    public WebElement searchboxButton;

    @FindBy(partialLinkText = "Sign Out")
    public WebElement signOutButton;

}
