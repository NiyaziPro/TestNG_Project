package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;


public class TC022 extends PreConditionLogged{

    @Test(description = "TC022 - Kullanıcı Ödeme seçeneklerini seçebilmeli.")
    public void testSelectPaymentsOptions() {
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

        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan \"Wire transfer/EFT\"  seçer.");
        if (!mainPage.checkOutPage.wireTransferEftRadioButton.isSelected()){
            mainPage.checkOutPage.wireTransferEftRadioButton.click();
        }

        ExtentReportUtils.extentTestInfo("\"Wire transfer/EFT\"  seçebildiğini doğrular.");
        Assert.assertTrue(mainPage.checkOutPage.wireTransferEftRadioButton.isSelected());
        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerinden bir tanesini seçebildiği doğrulandı.");
    }
}
