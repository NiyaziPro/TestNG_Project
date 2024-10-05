package techproed.allovercommerce.tests.US18;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;


public class TC013 extends PreCondVendorLogged {

    @Test(description = "TC013 - Vendor olarak Coupons oluşturmada alanlar bos bırakılarak Coupon oluşturulamamalı")
    public void testCreateCouponWithBlank() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Code\" kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"Description\"  kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\"  kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"Coupon expiry date\"  kutusunu boş bırakır.");
        JSUtils.JSscrollIntoView(mainPage.vendorCouponsPage.allowFreeShippingCheckBox);
        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("\"Allow free shipping\" checkbox'una tıklamaz.");
        ExtentReportUtils.extentTestInfo("\"Show on store\" checkbox'una tıklamaz.");

        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("\"Submit\" butonuna tıklar.");
        mainPage.vendorCouponsPage.submitButton.click();
        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("Alanları bos bırakılarak Coupon  oluşturamadıgını doğrular.");
        Assert.assertTrue(mainPage.vendorCouponsPage.cancelledMessage.isDisplayed());
        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada alanlar bos bırakılarak Coupon  oluşturamadıgı doğrulandı.");


    }
}
