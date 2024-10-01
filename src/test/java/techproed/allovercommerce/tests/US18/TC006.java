package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC006 extends PreCondVendorLogged {

    @Test(description = "TC006 - Vendor olarak Coupons oluşturmada Coupon Amount kutusuna harf girememeli.")
    public void testLettersInTheCouponAmount() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna harf girer.");
        mainPage.vendorCouponsPage.couponAmountBox.sendKeys("aBc", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna harf giremedigini doğrular.");

        Assert.assertEquals(mainPage.vendorCouponsPage.couponAmountBox.getAttribute("value"),"0");

        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Coupon Amount harf giremedigi doğrulandı.");


    }
}
