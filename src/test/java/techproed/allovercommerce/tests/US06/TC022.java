package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;

public class TC022 extends PreConditionLogged{

    @Test(description = "Kullanıcı Ödeme seçeneklerini seçebilmeli.")
    public void testSelectPaymentsOptions() {
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

        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan \"Wire transfer/EFT\"  seçer.");
        if (!mainPages.checkOutPage.wireTransferEftRadioButton.isSelected()){
            mainPages.checkOutPage.wireTransferEftRadioButton.click();
        }

        ExtentReportUtils.extentTestInfo("\"Wire transfer/EFT\"  seçebildiğini doğrular.");
        Assert.assertTrue(mainPages.checkOutPage.wireTransferEftRadioButton.isSelected());
        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerinden bir tanesini seçebildiği doğrulandı.");
    }
}
