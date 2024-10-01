package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;

public class TC021 extends PreConditionLogged{

    @Test(description = "TC021 - Kullanıcı Ödeme seçeneklerini görebilmeli.")
    public void testVisibilityOfPaymentsOptions() {

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

        ExtentReportUtils.extentTestInfo("\" Ödeme seçenekleri\" görüldüğünü doğrular.");
        Assert.assertTrue(mainPages.checkOutPage.wireTransferEftRadioButton.isDisplayed());
        Assert.assertTrue(mainPages.checkOutPage.payAtTheDoorRadioButton.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerini görebildiği doğrulandı.");
    }
}
