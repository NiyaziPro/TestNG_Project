package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC010 extends PreConditionLogged{

    @Test(description = "TC010 - Kullanıcı Sepete (Cart) eklediği ürünleri görebilmeli")
    public void testProductsAreVisibleInTheCart() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("headphone");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        WebElement selectedProduct = mainPage.shoppingPage.selectedProduct(0);
        String productText = selectedProduct.getText();
        selectedProduct.click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.productPage.addToCartButton);
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();


        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.viewCartButton);

        WaitUtils.waitFor(2);
        ExtentReportUtils.extentTestInfo("Ürünü sepette görebildiğini doğrular.");
        Assert.assertTrue(mainPage.cartPage.doesListContainText(productText));
        Assert.assertFalse(mainPage.cartPage.cartProductsList.isEmpty());
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü sepette görebildiği doğrulandı.");
    }
}
