package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC016 extends PreConditionLogged {

    @Test(description = "Kullanıcı sepete eklediği ürünlerin miktarını  azaltabilmeli.")
    public void testReduceTheAmountOfProductsToTheCart() {
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPages.productPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında ürün miktarını girer.");
        mainPages.cartPage.quantityNumber.clear();
        mainPages.cartPage.quantityNumber.sendKeys("5");

        ExtentReportUtils.extentTestInfo("'ADD TO CART' butonuna tıklar.");
        mainPages.productPage.addToCartButton.click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPages.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPages.cartPage.viewCartButton);
        int quantity = Integer.parseInt(mainPages.cartPage.quantityNumber.getAttribute("value"));

        WaitUtils.waitForPageToLoad(10);

        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında minus(-) butonuna tıklar.");
        mainPages.cartPage.quantityMinusButton.click();

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        WaitUtils.waitForClickablility(mainPages.cartPage.updateCartButton, 5).click();

        WaitUtils.waitForPageToLoad(10);
        ExtentReportUtils.extentTestInfo("Ürünün miktarının azaldıgını dogrular.");
        int updateQuantity = Integer.parseInt(mainPages.cartPage.quantityNumber.getAttribute("value"));

        Assert.assertEquals(updateQuantity, quantity - 1);
        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarını azaltabildiği doğrulandı.");


    }
}
