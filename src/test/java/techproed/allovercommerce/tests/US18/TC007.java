package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;

public class TC007 extends PreCondVendorLogged {

    @Test(description = "TC007 - Vendor olarak Coupons oluşturmada Coupon Amount kutusuna özel karakter girememeli.")
    public void testSpecialCharactersInTheCouponAmount() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna özel karakter girer.");
        mainPage.vendorCouponsPage.couponAmountBox.sendKeys("#", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna  özel karakter giremedigini doğrular");

        Assert.assertEquals(mainPage.vendorCouponsPage.couponAmountBox.getAttribute("value"),"0");
        Assert.assertNotEquals(mainPage.vendorCouponsPage.couponAmountBox.getAttribute("value"),"#");

        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Coupon Amount özel karakter giremedigi doğrulandı.");


    }
}
