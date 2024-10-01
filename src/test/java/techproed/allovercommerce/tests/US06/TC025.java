package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC025 extends PreConditionLogged{
    @Test(description = "TC025 - Kullanıcı alışverişini tamamlayabilmeli")
    public void testCompleteShopping() {
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("notebook");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPages.productPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        mainPages.productPage.addToCartButton.click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPages.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'Checkout' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPages.cartPage.checkoutButton);
        ActionsUtils.scrollDown();

        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan \"Wire transfer/EFT\"  seçer.");
        if (!mainPages.checkOutPage.wireTransferEftRadioButton.isSelected()){
            mainPages.checkOutPage.wireTransferEftRadioButton.click();
        }
        ExtentReportUtils.extentTestInfo("Place Order' butonuna tıklar.");
        mainPages.checkOutPage.placeOrderButton.click();

        WaitUtils.waitForPageToLoad(5);
        ExtentReportUtils.extentTestInfo("Alışveriş tamamlayabildigini dogrular.");
        Assert.assertTrue(mainPages.orderCompletePage.orderCompletedMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının alışverişi yapabildigi doğrulandı.");

    }
}
