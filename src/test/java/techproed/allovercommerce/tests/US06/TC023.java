package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.*;

public class TC023 extends PreConditionLogged{

    @Test(description = "Kullanıcı Ödeme seçeneklerini seçebilmeli.")
    public void testSelectPaymentsOptions() {
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
        ActionsUtils.scrollDown();
        WaitUtils.waitFor(5);

        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan \"Pay at the door\"  seçer.");
        if (!mainPages.checkOutPage.payAtTheDoorRadioButton.isSelected()){
            mainPages.checkOutPage.payAtTheDoorRadioButton.click();
        }
        
        ExtentReportUtils.extentTestInfo("\"\"Pay at the door\"  seçebildiğini doğrular.");
        Assert.assertTrue(mainPages.checkOutPage.payAtTheDoorRadioButton.isSelected());
        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerinden bir tanesini seçebildiği doğrulandı.");
    }
}
