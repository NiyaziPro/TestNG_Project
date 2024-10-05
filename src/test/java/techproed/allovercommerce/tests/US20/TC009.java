package techproed.allovercommerce.tests.US20;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

import java.util.List;

public class TC009 extends PC_VendorLogged {

    @Test(description = "TC009 - Oluşturulan Coupon ile Vendor olarak alışveriş yapılabilmeli")

    public void testCouponUsage() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Orders\"  butonuna tıklar.");
        mainPage.myAccountPage.ordersLink.click();
        ExtentReportUtils.extentTestInfo("\"Go Shop\"  butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.ordersPage.goShopButton);
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("bag");
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

        ExtentReportUtils.extentTestInfo("\"Enter Your Code\" linkine tıklar.");
        mainPage.checkOutPage.enterYourCouponCode.click();
        ExtentReportUtils.extentTestInfo("Açılan kutuya oluşturulan Coupon kodunu girer.");
        mainPage.checkOutPage.inputCouponCode.sendKeys("Welcome20");
        ExtentReportUtils.extentTestInfo("\"Apply Coupon\" butonuna tıklar.");
        mainPage.checkOutPage.applyCouponButton.click();
        ExtentReportUtils.extentTestInfo("Indirimin gerçekleştiğini doğrular.");
        ExtentReportUtils.addScreenShotToReport();
        Assert.assertTrue(mainPage.checkOutPage.alertCouponMsg.isDisplayed());
        ExtentReportUtils.extentTestFail("Oluşturulan Coupon ile Vendor olarak alışveriş yapabildigi doğrulanamadı.");


    }
}
