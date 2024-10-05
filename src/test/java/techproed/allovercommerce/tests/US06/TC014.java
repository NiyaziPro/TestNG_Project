package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC014 extends PreConditionLogged {

    @Test(description = "TC014 - Kullanıcı sepete eklediği ürünlerin miktarına pozitif sayı girebilmeli.")
    public void testEnterAPositiveNumberForTheQuantity() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPage.shoppingPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.productPage.addToCartButton);
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.viewCartButton);

        ActionsUtils.scrollToElementUsingActions(mainPage.cartPage.updateCartButton);
        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında istedigi miktarı girer.");
        mainPage.cartPage.quantityNumber().clear();
        mainPage.cartPage.quantityNumber().sendKeys("10");

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        mainPage.cartPage.updateCartButton.click();
        WaitUtils.waitFor(3);

        int quantity = Integer.parseInt(mainPage.cartPage.quantityNumber().getAttribute("value"));

        ExtentReportUtils.extentTestInfo("Ürünün miktarının arttığını doğrular.");
        Assert.assertEquals(quantity, 10);
        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarını artırabildiği doğrulandı.");

    }
}
