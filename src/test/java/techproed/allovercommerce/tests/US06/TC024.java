package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC024 extends PreConditionLogged{

    @Test(description = "TC024 - Kullanıcı Ödeme seçeneklerini  hepsini aynı anda seçememeli.")
    public void testSelectPaymentsOptions() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("bag");
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
        WaitUtils.waitFor(3);

        WebElement payAtTheDoor = mainPage.checkOutPage.payAtTheDoorRadioButton;
        WebElement wireTransferEft = mainPage.checkOutPage.wireTransferEftRadioButton;

        ExtentReportUtils.extentTestInfo("\" Payment Methods\"dan seçeneklerin hepsini seçmeye çalışır.");
        if (!payAtTheDoor.isSelected() ){
            ActionsUtils.waitForElementToBeVisibleAndClick(payAtTheDoor,5);
        }
        
        ExtentReportUtils.extentTestInfo("Ödeme seçeneklerini  hepsini aynı anda seçemediğini doğrular.");
        Assert.assertTrue(payAtTheDoor.isSelected());
        Assert.assertFalse(wireTransferEft.isSelected());
        ActionsUtils.waitForElementToBeVisibleAndClick(wireTransferEft,5);
        Assert.assertFalse(payAtTheDoor.isSelected());
        Assert.assertTrue(wireTransferEft.isSelected());
        ExtentReportUtils.extentTestPass("Kullanıcının Ödeme seçeneklerinden bir tanesini seçebildiği doğrulandı.");
    }
}
