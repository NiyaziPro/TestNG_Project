package techproed.allovercommerce.tests.US18;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;

public class TC001 extends PreCondVendorLogged {

    @Test(description = "TC001 - Vendor olarak Coupons oluşturmada Code yazabilmeli")
    public void testToWriteCodeToCreateCouponsAsAVendor() {

        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Store Manager\"e tıklar.");
        mainPage.myAccountPage.storeManagerLink.click();
        ExtentReportUtils.extentTestInfo("\"Coupons\"a tıklar.");
        mainPage.vendorStoreManagerPage.couponsLink.click();
        ExtentReportUtils.extentTestInfo("\"Add New\" butonuna tıklar.");
        mainPage.vendorCouponsPage.addNewButton.click();
        ExtentReportUtils.extentTestInfo("\"Code\" kutusuna bir data girer.");
        mainPage.vendorCouponsPage.codeBox.sendKeys("Welcome20", Keys.TAB);
        ExtentReportUtils.extentTestInfo("\"Code\" kutusuna bir kod yazabildigini doğrular.");

        Assert.assertEquals(mainPage.vendorCouponsPage.codeBox.getAttribute("value"),"Welcome20");
        ExtentReportUtils.extentTestPass("Kullanıcının Vendor olarak Coupons oluşturmada Code yazabildigi doğrulandı.");
    }
}
