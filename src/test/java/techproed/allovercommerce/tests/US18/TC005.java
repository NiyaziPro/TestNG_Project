package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;

public class TC005 extends PreCondVendorLogged {

    @Test(description = "TC005 - Vendor olarak Coupons oluşturmada Coupon Amount yazılabilmeli")
    public void testToWriteCouponAmountToCreateCouponsAsAVendor() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna indirim miktarını girer.");
        mainPage.vendorCouponsPage.codeBox.sendKeys("20", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna indirim miktarı yazabildigini doğrular");

        Assert.assertEquals(mainPage.vendorCouponsPage.codeBox.getAttribute("value"),"20");
        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Coupon Amount yazılabildigi doğrulandı.");
    }
}
