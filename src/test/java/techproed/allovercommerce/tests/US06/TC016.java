package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC016 extends PreConditionLogged {

    @Test(description = "TC016 - Kullanıcı sepete eklediği ürünlerin miktarını  azaltabilmeli.")
    public void testReduceTheAmountOfProductsToTheCart() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPage.shoppingPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında ürün miktarını girer.");
        mainPage.cartPage.quantityNumber().clear();
        mainPage.cartPage.quantityNumber().sendKeys("5");

        ExtentReportUtils.extentTestInfo("'ADD TO CART' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.productPage.addToCartButton);
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.viewCartButton);

        ActionsUtils.scrollToElementUsingActions(mainPage.cartPage.updateCartButton);
        int quantity = Integer.parseInt(mainPage.cartPage.quantityNumber().getAttribute("value"));

        ExtentReportUtils.extentTestInfo("\"Quantity\" kısmında minus(-) butonuna tıklar.");
        mainPage.cartPage.quantityMinusButton().click();

        ExtentReportUtils.extentTestInfo("\"Update Cart\" butonuna tıklar.");
        mainPage.cartPage.updateCartButton.click();

        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("Ürünün miktarının azaldıgını dogrular.");
        int updateQuantity = Integer.parseInt(mainPage.cartPage.quantityNumber().getAttribute("value"));

        Assert.assertEquals(updateQuantity, quantity - 1);
        ExtentReportUtils.extentTestPass("Kullanıcının sepete eklediği ürünlerin miktarını azaltabildiği doğrulandı.");


    }
}
