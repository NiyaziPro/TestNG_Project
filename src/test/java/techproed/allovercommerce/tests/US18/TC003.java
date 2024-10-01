package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;

public class TC003 extends PreCondVendorLogged {

    @Test(description = "TC003 - Vendor olarak Coupons oluşturmada Discount Type, Percentage discount  olarak seçebilmeli.")
    public void testToSelectDiscountTypeToCreateCouponsAsAVendor() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Discount Type\" kısmında \"Percentage discount\" seçer.");
        BrowserUtils.dropdownSelectByValue(mainPage.vendorCouponsPage.discountTypeDropDown,"percent");

        ExtentReportUtils.extentTestInfo("\"Percentage discount\" seçebildigini doğrular.");

        Assert.assertEquals(mainPage.vendorCouponsPage.discountTypeDropDown.getAttribute("value"),"percent");
        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Discount Type, Percentage discount  seçebildigi doğrulandı.");
    }
}
