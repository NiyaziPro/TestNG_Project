package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC007 extends PreConditionLogged{

    @Test(description = "TC007 - Kullanıcı aradığı ürünü Urün detay sayfasına gitmeden'de sepete ekleyebilmeli (ADD TO CART)")
    public void testAddToCartWithBagIcon() {
        MainPage mainPage = new MainPage();

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();

        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer ve Entere tıklar.");
        mainPage.homePage.searchbox.sendKeys("Bag", Keys.ENTER);
        WaitUtils.waitFor(5);

        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        ActionsUtils.hoverOver(mainPage.shoppingPage.selectedProduct(4));

        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPage.shoppingPage.bagIcon(), 6).click();

        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        WaitUtils.waitForVisibility(mainPage.shoppingPage.hasBeenAddedToCartMsg, 5);
        Assert.assertTrue(mainPage.shoppingPage.hasBeenAddedToCartMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü sepete ekleyebildiği doğrulandı.");


    }
}
