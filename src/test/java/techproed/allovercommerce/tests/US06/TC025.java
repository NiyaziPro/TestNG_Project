package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC025 extends PreConditionLogged{
    @Test(description = "TC025 - Kullanıcı alışverişini tamamlayabilmeli")
    public void testCompleteShopping() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("notebook");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPage.shoppingPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.productPage.addToCartButton);
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'Checkout' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.checkoutButton);


        ActionsUtils.scrollToElementUsingActions(mainPage.checkOutPage.placeOrderButton);
        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan \"Wire transfer/EFT\"  seçer.");
        if (!mainPage.checkOutPage.wireTransferEftRadioButton.isSelected()){
           mainPage.checkOutPage.wireTransferEftRadioButton.click();
        }
        ExtentReportUtils.extentTestInfo("Place Order' butonuna tıklar.");
        mainPage.checkOutPage.placeOrderButton.click();

        WaitUtils.waitFor(2);
        ExtentReportUtils.extentTestInfo("Alışveriş tamamlayabildigini dogrular.");
        Assert.assertTrue(mainPage.orderCompletePage.orderCompletedMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının alışverişi yapabildigi doğrulandı.");

    }
}
