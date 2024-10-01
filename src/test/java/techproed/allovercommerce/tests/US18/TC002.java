package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;

public class TC002 extends PreCondVendorLogged {

    @Test(description = "TC002 - Vendor olarak Coupons oluşturmada Description yazılabilmeli")
    public void testToWriteDescriptionToCreateCouponsAsAVendor() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Description\" kutusuna bir data girer.");
        mainPage.vendorCouponsPage.codeBox.sendKeys("This is a 20% Discount Coupon", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Description\" kutusuna bir description yazabildigini doğrular.");

        Assert.assertEquals(mainPage.vendorCouponsPage.codeBox.getAttribute("value"),"This is a 20% Discount Coupon");
        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Description yazabildigi doğrulandı.");
    }
}
