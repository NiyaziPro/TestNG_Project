package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class PracticePage {
    public PracticePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(tagName = "h5")
    public List<WebElement> products;













}
