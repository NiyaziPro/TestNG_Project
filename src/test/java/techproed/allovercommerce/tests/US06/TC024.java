package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC024 extends PreConditionLogged{

    @Test(description = "TC024 - Kullanıcı Ödeme seçeneklerini  hepsini aynı anda seçememeli.")
    public void testSelectPaymentsOptions() {
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("bag");
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

        WebElement payAtTheDoor = mainPages.checkOutPage.payAtTheDoorRadioButton;
        WebElement wireTransferEft = mainPages.checkOutPage.wireTransferEftRadioButton;

        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan seçeneklerin hepsini seçmeye çalışır.");
        if (!payAtTheDoor.isSelected() ){
            mainPages.checkOutPage.payAtTheDoorRadioButton.click();
        }
        
        ExtentReportUtils.extentTestInfo("Ödeme seçeneklerini  hepsini aynı anda seçemediğini doğrular.");
        Assert.assertTrue(payAtTheDoor.isSelected());
        Assert.assertFalse(wireTransferEft.isSelected());
        wireTransferEft.click();
        Assert.assertFalse(payAtTheDoor.isSelected());
        Assert.assertTrue(wireTransferEft.isSelected());
        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerinden bir tanesini seçebildiği doğrulandı.");
    }
}
