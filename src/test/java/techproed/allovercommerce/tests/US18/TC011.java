package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC011 extends PreCondVendorLogged {

    @Test(description = "TC011 - Vendor olarak Coupons oluşturmada Allow free shipping, Show on store seçilebilmeli")
    public void testSelectCheckBoxes() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        JSUtils.JSscrollIntoView(mainPage.vendorCouponsPage.allowFreeShippingCheckBox);
        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("\"Allow free shipping\" checkbox'una tıklar.");
        mainPage.vendorCouponsPage.allowFreeShippingCheckBox.click();
        ExtentReportUtils.extentTestInfo("\"Allow free shipping\" checkbox'una tıklayabildigini dogrular.");
        Assert.assertTrue(mainPage.vendorCouponsPage.allowFreeShippingCheckBox.isSelected());

        WaitUtils.waitFor(5);
        ExtentReportUtils.extentTestInfo("\"Show on store\" checkbox'una tıklar.");
        mainPage.vendorCouponsPage.showOnStoreCheckBox.click();
        ExtentReportUtils.extentTestInfo("\"Show on store\" checkbox'una tıklayabildigini dogrular.");
        Assert.assertTrue(mainPage.vendorCouponsPage.showOnStoreCheckBox.isSelected());

        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Allow free shipping, Show on store seçebildigi doğrulandı.");


    }
}
