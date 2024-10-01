package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC007 extends PreConditionLogged{

    @Test(description = "TC007 - Kullanıcı aradığı ürünü Urün detay sayfasına gitmeden'de sepete ekleyebilmeli (ADD TO CART)")
    public void testAddToCartWithBagIcon() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();

        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer ve Entere tıklar.");
        mainPages.homePage.searchbox.sendKeys("Bag", Keys.ENTER);
        WaitUtils.waitFor(5);

        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        ActionsUtils.hoverOver(mainPages.productPage.selectedProduct(4));

        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPages.shoppingPage.bagIcon(), 6).click();

        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        WaitUtils.waitForVisibility(mainPages.shoppingPage.hasBeenAddedToCartMsg, 5);
        Assert.assertTrue(mainPages.shoppingPage.hasBeenAddedToCartMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü sepete ekleyebildiği doğrulandı.");


    }
}
