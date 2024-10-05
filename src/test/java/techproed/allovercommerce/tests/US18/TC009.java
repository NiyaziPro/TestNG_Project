package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC009 extends PreCondVendorLogged {

    @Test(description = "TC009 - Vendor olarak Coupons oluşturmada Coupon expiry date girilebilmeli.")
    public void testCouponExpiryDateBox() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Coupon expiry date\" kısmında kuponun geçerlilik tarihini  girer.");
        mainPage.vendorCouponsPage.expiryDatetBox.sendKeys("2024-10-30", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Coupon expiry date\" kısmında kuponun geçerlilik tarihini  girebildigini doğrular.");

        WaitUtils.waitFor(5);

        Assert.assertEquals(mainPage.vendorCouponsPage.expiryDatetBox.getAttribute("value"),"2024-10-30");


        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Coupon expiry date girilebildigi doğrulandı.");


    }
}
