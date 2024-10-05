package techproed.allovercommerce.tests.US20;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC007 extends PC_VendorLogged {

    @Test(description = "TC007 - Vendor olarak Place Order'a tıklanarak alışverişin tamamlandığı görülebilmeli")

    public void testCompleteOrder() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Orders\"  butonuna tıklar.");
        mainPage.myAccountPage.ordersLink.click();
        ExtentReportUtils.extentTestInfo("\"Go Shop\"  butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.ordersPage.goShopButton);
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        ActionsUtils.hoverOver(mainPage.shoppingPage.selectedProduct(0));
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPage.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'CHECKOUT' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.checkoutButton);

        ExtentReportUtils.extentTestInfo("Pay at the door  seçenegini seçebildigini dogrular.");
        WebElement payAtTheDoor = mainPage.checkOutPage.payAtTheDoorRadioButton;
        if (!payAtTheDoor.isSelected()){
            JSUtils.JSclickWithTimeout(payAtTheDoor);
        }
        WaitUtils.waitFor(2);
        ExtentReportUtils.extentTestInfo("Place Order' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.checkOutPage.placeOrderButton);
        WaitUtils.waitForVisibility(mainPage.orderCompletePage.orderCompletedMsg,8);
        ExtentReportUtils.extentTestInfo("Alışveriş tamamlandığını dogrular.");
        Assert.assertTrue(mainPage.orderCompletePage.orderCompletedMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Vendor olarak Place Order'a tıklanarak alışverişin tamamlandığı doğrulandı.");
    }
}
