package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.*;

public class TC023 extends PreConditionLogged{

    @Test(description = "TC023 - Kullanıcı Ödeme seçeneklerini seçebilmeli.")
    public void testSelectPaymentsOptions() {
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
        ActionsUtils.scrollToElementUsingActions(mainPage.checkOutPage.payAtTheDoorRadioButton);
        WaitUtils.waitFor(3);

        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan \"Pay at the door\"  seçer.");
        if (!mainPage.checkOutPage.payAtTheDoorRadioButton.isSelected()){
            mainPage.checkOutPage.payAtTheDoorRadioButton.click();
        }
        
        ExtentReportUtils.extentTestInfo("\"\"Pay at the door\"  seçebildiğini doğrular.");
        Assert.assertTrue(mainPage.checkOutPage.payAtTheDoorRadioButton.isSelected());
        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerinden bir tanesini seçebildiği doğrulandı.");
    }
}
