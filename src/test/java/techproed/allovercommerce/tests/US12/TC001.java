package techproed.allovercommerce.tests.US12;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC001 extends PreConditionVendorLogged {

    @Test(description = "TC001 - Vendor Billing Address (Fatura Adresi)  İlk eklemede sadece mail adresi otomatik olarak gelmeli.")
    public void testEmailComeAutomatically() {
        ExtentReportUtils.extentTestInfo("Kullanıcı  \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Addresses\" butonuna tıklar.");
        mainPage.myAccountPage.adressesLink.click();
        ExtentReportUtils.extentTestInfo("\"Billing Address\" bağlantısının altında \"Add ->\" bağlantısına tıklar.");
        mainPage.vendorAddressesPage.billingAddressADDButton.click();
        ActionsUtils.scrollDown();
        WaitUtils.waitFor(5);
        ExtentReportUtils.extentTestInfo("Email  adresi otomatik olarak  geldigini doğrular.");
        Assert.assertNotNull(mainPage.vendorAddressesPage.emailAddressBox.getAttribute("value"));
        ExtentReportUtils.extentTestPass("Vendor Billing Address  ilk eklemede Email  adresi otomatik olarak  geldiği doğrulandı.");


    }
}
