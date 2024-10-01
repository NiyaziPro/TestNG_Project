package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC010 extends PreCondVendorLogged {
    @Test(description = "TC010 - Vendor olarak Coupons oluşturmada Coupon expiry date kutusuna  özel karakter/ harf girilememeli")
    public void testspecialCharactersLettersEnterInTheCouponExpiryDate() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Coupon expiry date\" kutusuna özel karakter girer.");
        mainPage.vendorCouponsPage.expiryDatetBox.sendKeys("####-@@-%%", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Coupon expiry date\" kutusuna özel karakter giremedigini doğrular.");
        Assert.assertNotEquals(mainPage.vendorCouponsPage.expiryDatetBox.getAttribute("value"), "####-@@-%%");
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        WaitUtils.waitFor(3);

        mainPage.vendorCouponsPage.expiryDatetBox.sendKeys("abcD-Ba-dx", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Coupon expiry date\" kutusuna harf girer.");
        Assert.assertNotEquals(mainPage.vendorCouponsPage.expiryDatetBox.getAttribute("value"), "abcD-Ba-dx");

        ExtentReportUtils.extentTestInfo("Coupon expiry date kutusuna  özel karakter/ harf giremedigini doğrular.");


        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Coupon expiry date kutusuna  özel karakter/ harf girilemedigi doğrulandı.");

    }

}
