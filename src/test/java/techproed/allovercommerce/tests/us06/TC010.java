package techproed.allovercommerce.tests.us06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC010 extends PreConditionLogged{

    @Test(description = "TC010 - Kullanıcı Sepete (Cart) eklediği ürünleri görebilmeli")
    public void testProductsAreVisibleInTheCart() {
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("headphone");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPages.productPage.selectedProduct(0).click();
        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        mainPages.productPage.addToCartButton.click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPages.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPages.cartPage.viewCartButton);

        WaitUtils.waitForPageToLoad(10);
        ExtentReportUtils.extentTestInfo("Ürünü sepette görebildiğini doğrular.");
        Assert.assertFalse(mainPages.cartPage.cartProductsList.isEmpty());
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü sepette görebildiği doğrulandı.");
    }
}
