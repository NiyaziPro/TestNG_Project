package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC013 extends PreConditionLogged {
    @Test(description = "TC013 - Kullanıcı sepete eklediği ürünlerin miktarını artırabilmeli ")
    public void testIncreaseTheAmountOfProductsToCart() {

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

        int quantity = Integer.parseInt(mainPages.cartPage.quantityNumber.getAttribute("value"));

        WaitUtils.waitForPageToLoad(10);

        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında plus(+) butonuna tıklar.");
        mainPages.cartPage.quantityPlusButton.click();

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        WaitUtils.waitForClickablility(mainPages.cartPage.updateCartButton, 5).click();

        WaitUtils.waitForPageToLoad(10);
        ExtentReportUtils.extentTestInfo("Ürünün miktarının arttığını doğrular.");
        int updateQuantity = Integer.parseInt(mainPages.cartPage.quantityNumber.getAttribute("value"));

        Assert.assertEquals(updateQuantity, quantity + 1);
        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarını artırabildiği doğrulandı.");


    }
}
