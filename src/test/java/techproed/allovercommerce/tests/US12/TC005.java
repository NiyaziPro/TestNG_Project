package techproed.allovercommerce.tests.US12;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;

public class TC005 extends PreConditionVendorLogged{

    @Test(description = "TC005 - Vendor Billing Address güncellemede First name, Last name ve Email addresi otomatik olarak gelmeli")
    public void testUpdatingBillingAddress() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Addresses\" butonuna tıklar.");
        mainPage.myAccountPage.adressesLink.click();
        ExtentReportUtils.extentTestInfo("\"EDIT YOUR BILLING ADDRESS ->\" bağlantısına tıklar.");
        mainPage.vendorAddressesPage.editYourBillingAddress.click();

        ExtentReportUtils.extentTestInfo("First name ,Last name ve Email adresi otomatik olarak geldiğini doğrular.");
        Assert.assertNotNull(mainPage.vendorAddressesPage.firstNameBox.getAttribute("value"));
        Assert.assertNotNull(mainPage.vendorAddressesPage.lastNameBox.getAttribute("value"));
        Assert.assertNotNull(mainPage.vendorAddressesPage.emailAddressBox.getAttribute("value"));
        ExtentReportUtils.extentTestPass("Güncellemede First name, Last name ve Email addresi otomatik olarak geldiği doğrulandı.");
    }
}
