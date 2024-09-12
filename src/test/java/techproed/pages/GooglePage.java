package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class GooglePage {

    public GooglePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(id = "APjFqb")
    public WebElement searchBox;

    @FindBy(id = "W0wltc")
    public WebElement cookiesHandle;

    public void handleCookies() {
        try {
            ReusableMethods.click(cookiesHandle);
        } catch (Exception e) {
            // cookie'nin çıkmaması durumunda, alacağımız exception'ı, burayı boş bırakarak ignore etmiş oluruz
        }
    }







}
