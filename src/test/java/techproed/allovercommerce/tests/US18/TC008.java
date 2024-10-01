package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC008 extends PreCondVendorLogged {

    @Test(description = "TC008 - Vendor olarak Coupons oluşturmada Coupon Amount kutusuna negatif sayı girememeli.")
    public void testNegativeNumberEnterInTheCouponAmount() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna negatif sayı girer.");
        mainPage.vendorCouponsPage.couponAmountBox.clear();
        mainPage.vendorCouponsPage.couponAmountBox.sendKeys("-15", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna  negatif sayı giremedigini doğrular");

        WaitUtils.waitFor(5);

        Assert.assertEquals(mainPage.vendorCouponsPage.couponAmountBox.getAttribute("value"),"0");//!!!!!!!!!!


        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Coupon Amount negatif sayı giremedigi doğrulandı.");


    }
}
