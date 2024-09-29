package techproed.allovercommerce.tests.us06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC008 extends PreConditionAccessTheWebsite{
    @Test(description = "TC008 - Kullanıcı Sign In olmadan da aradığı ürünü sepete ekleyebilmeli (ADD TO CART)")
    public void testProductAddToCartWithoutSignIn() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        ActionsUtils.hoverOver(mainPages.productPage.selectedProduct(2));
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPages.shoppingPage.bagIcon(), 6).click();
        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        WaitUtils.waitForVisibility(mainPages.shoppingPage.hasBeenAddedToCartMsg, 5);
        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        Assert.assertTrue(mainPages.shoppingPage.hasBeenAddedToCartMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının Sign In olmadan aradığı ürünü sepete ekleyebildiği doğrulandı.");


    }
}
