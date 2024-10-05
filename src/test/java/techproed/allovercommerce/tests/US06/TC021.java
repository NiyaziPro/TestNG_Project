package techproed.allovercommerce.tests.US06;

import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;

public class TC021 extends PreConditionLogged{

    @Test(description = "TC021 - Kullanıcı Ödeme seçeneklerini görebilmeli.")
    public void testVisibilityOfPaymentsOptions() {
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

        ExtentReportUtils.extentTestInfo("\" Ödeme seçenekleri\" görüldüğünü doğrular.");
        BrowserUtils.verifyElementDisplayed(mainPage.checkOutPage.wireTransferEftRadioButton);
        BrowserUtils.verifyElementDisplayed(mainPage.checkOutPage.payAtTheDoorRadioButton);

        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerini görebildiği doğrulandı.");
    }
}
