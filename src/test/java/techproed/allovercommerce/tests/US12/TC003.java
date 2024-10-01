package techproed.allovercommerce.tests.US12;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC003 extends PreConditionVendorLogged{

    @Test(description = "TC003 - Kullanıcı Vendor Billing Address (Fatura Adresi) zorunlu alanlar boş bırakılamamalı")
    public void testBillingAddressDetailsCannotBeLeftBlank() {
        ExtentReportUtils.extentTestInfo("Kullanıcı  \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Addresses\" butonuna tıklar.");
        mainPage.myAccountPage.adressesLink.click();
        ExtentReportUtils.extentTestInfo("\"Billing Address\" bağlantısının altında \"Add ->\" bağlantısına tıklar.");
        mainPage.vendorAddressesPage.billingAddressADDButton.click();
        WaitUtils.waitFor(5);
        ExtentReportUtils.extentTestInfo("\"First name\" kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"Last name\" kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"Country / Region\"  kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"Street address\"   kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"Town / City\" kutusunu boş bırakır.");
        ExtentReportUtils.extentTestInfo("\"ZIP Code\"  kutusunu boş  bırakır.");
        ExtentReportUtils.extentTestInfo("\"Phone\" kutusunu boş  bırakır.");

        ActionsUtils.scrollEnd();
        WaitUtils.waitFor(5);


        ExtentReportUtils.extentTestInfo("\"SAVE ADDRESS\" butonuna tıklar.");
        mainPage.vendorAddressesPage.saveAddressButton.click();

        ExtentReportUtils.extentTestInfo("Zorunlu alanların boş bırakılamadıgını doğrular.");
        for (WebElement w : mainPage.vendorAddressesPage.alertMessageList){
            System.out.println("Alert : " + w.getText());
            Assert.assertTrue(w.isDisplayed());
        }
        ExtentReportUtils.extentTestPass("Vendor Billing Address  zorunlu alanlar boş bırakılamadığı doğrulandı.");
    }
}
