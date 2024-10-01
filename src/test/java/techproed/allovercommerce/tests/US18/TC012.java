package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC012 extends PreCondVendorLogged {

    @Test(description = "TC012 - Vendor olarak Coupons oluşturabilmeli\n" +
            "(My Account >Store Manager > Coupons > Add New)")
    public void testCreateCoupon() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Code\" kutusuna bir data girer.");
        mainPage.vendorCouponsPage.codeBox.sendKeys("Welcome20");
        ExtentReportUtils.extentTestInfo("\"Description\" kutusuna bir data girer.");
        mainPage.vendorCouponsPage.descriptionBox.sendKeys("This is a 20% Discount Coupon");
        ExtentReportUtils.extentTestInfo("\"Coupon Amount\" kutusuna indirim miktarını girer.");
        mainPage.vendorCouponsPage.couponAmountBox.sendKeys("20");
        ExtentReportUtils.extentTestInfo("\"Coupon expiry date\" kısmında kuponun geçerlilik tarihini  girer.");
        mainPage.vendorCouponsPage.expiryDatetBox.sendKeys("2024-10-30");
        JSUtils.JSscrollIntoView(mainPage.vendorCouponsPage.allowFreeShippingCheckBox);
        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("\"Allow free shipping\" checkbox'una tıklar.");
        mainPage.vendorCouponsPage.allowFreeShippingCheckBox.click();
        ExtentReportUtils.extentTestInfo("\"Show on store\" checkbox'una tıklar.");
        mainPage.vendorCouponsPage.showOnStoreCheckBox.click();

        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(3);
        ExtentReportUtils.extentTestInfo("\"Submit\" butonuna tıklar.");
        mainPage.vendorCouponsPage.submitButton.click();

        JSUtils.JSscrollAllTheWayUp();
        WaitUtils.waitFor(3);
        mainPage.vendorStoreManagerPage.couponsLink.click();
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitForPageToLoad(5);
        ExtentReportUtils.extentTestInfo("Vendor olarak indirim kuponu oluşturabildigini doğrular.");

        Assert.assertEquals(mainPage.vendorCouponsPage.couponsList.get(0).getText(),"Welcome20");

        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Allow free shipping, Show on store seçebildigi doğrulandı.");


    }
}
