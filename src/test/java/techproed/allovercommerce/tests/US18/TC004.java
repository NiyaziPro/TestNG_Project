package techproed.allovercommerce.tests.US18;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ExtentReportUtils;

public class TC004 extends PreCondVendorLogged {

    @Test(description = "TC004 - Vendor olarak Coupons oluşturmada Discount Type, Fixed Product Discount olarak seçebilmeli.")
    public void testToSelectDiscountTypeToCreateCouponsAsAVendor() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Discount Type\" kısmında \"Fixed Product Discount\" seçer.");
        BrowserUtils.dropdownSelectByValue(mainPage.vendorCouponsPage.discountTypeDropDown,"fixed_product");

        ExtentReportUtils.extentTestInfo("\"Fixed Product Discount\" seçebildigini doğrular.");

        Assert.assertEquals(mainPage.vendorCouponsPage.discountTypeDropDown.getAttribute("value"),"fixed_product");
        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Discount Type, Fixed Product Discount seçebildigi doğrulandı.");
    }
}
