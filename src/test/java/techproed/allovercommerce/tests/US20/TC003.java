package techproed.allovercommerce.tests.US20;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC003 extends PC_VendorLogged {

    @Test(description = "TC003 - Vendor olarak Fatura ayrıntıları (BILLING DETAILS) otomatik olarak gelmeli.")

    public void testVisibilityOfBillingDetails() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Orders\"  butonuna tıklar.");
        mainPage.myAccountPage.ordersLink.click();
        ExtentReportUtils.extentTestInfo("\"Go Shop\"  butonuna tıklar.");
        JSUtils.JSscrollAllTheWayDown();
        JSUtils.JSclickWithTimeout(mainPage.ordersPage.goShopButton);
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("headphone");
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

        ExtentReportUtils.extentTestInfo("Fatura ayrıntıları  otomatik olarak geldigini dogrular.");

        Assert.assertFalse(mainPage.checkOutPage.billingDetailsList.stream().allMatch(t->t.getAttribute("value").isEmpty()));
        ExtentReportUtils.extentTestPass("Fatura ayrıntıları  otomatik olarak geldigi doğrulandı.");
    }
}
