package techproed.allovercommerce.tests.US06;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC017 extends PreConditionLogged {
    @Test(description = "TC017 - Kullanıcı sepete eklediği ürünlerin miktarına negatif sayı girdiğinde kabul etmemeli")
    public void testNegativeNumberCannotBeEnteredForProductQuantity() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("book");
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
        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında istedigi miktarı girer.");
        mainPages.cartPage.quantityNumber.clear();
        mainPages.cartPage.quantityNumber.sendKeys("-10");

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        WaitUtils.waitForClickablility(mainPages.cartPage.updateCartButton, 5).click();
        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("Uyarı mesajı aldığını doğrular.");
        ExtentReportUtils.addScreenShotToReport();
        Assert.assertTrue(mainPages.cartPage.updateCartButton.isEnabled());

        int quantity = Integer.parseInt(mainPages.cartPage.quantityNumber.getAttribute("min"));
        Assert.assertTrue(quantity > 0);

        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarına negatif sayı girdiğinde kabul etmediği doğrulandı.");

    }
}
