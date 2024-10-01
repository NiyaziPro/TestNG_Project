package techproed.allovercommerce.tests.US12;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC004 extends PreConditionVendorLogged{
    @Test(description = "TC004 -  Vendor Billing Address (Fatura Adresi) ekleyebilmeli.")
    public void testAddBillingAddress() {
        ExtentReportUtils.extentTestInfo("Kullanıcı  \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Addresses\" butonuna tıklar.");
        mainPage.myAccountPage.adressesLink.click();
        ExtentReportUtils.extentTestInfo("\"Billing Address\" bağlantısının altında \"Add ->\" bağlantısına tıklar.");
        mainPage.vendorAddressesPage.billingAddressADDButton.click();
        WaitUtils.waitFor(5);
        ExtentReportUtils.extentTestInfo("\"First name\" kutusuna geçerli  bir veri girer");
        mainPage.vendorAddressesPage.firstNameBox.sendKeys("Allover");
        ExtentReportUtils.extentTestInfo("\"Last name\" kutusuna geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.lastNameBox.sendKeys("Vendor");
        ExtentReportUtils.extentTestInfo("\"Country / Region\" kutusunda  bir ülke seçer.");
        mainPage.vendorAddressesPage.openCountryDropDown.click();
        mainPage.vendorAddressesPage.inputForDropDownBox.sendKeys("Germany", Keys.ENTER);
        ExtentReportUtils.extentTestInfo("\"Street address\"   kutusuna geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.streetAddressBox.sendKeys("Hansestrasse");
        ExtentReportUtils.extentTestInfo("\"Town / City\" kutusuna  geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.townCityBox.sendKeys("Hamburg");
        ExtentReportUtils.extentTestInfo("\"ZIP Code\" kutusuna geçerli bir veri girer.");
        mainPage.vendorAddressesPage.postZipCodeBox.sendKeys("22222");
        ExtentReportUtils.extentTestInfo("\"Phone\" kutusuna geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.phoneBox.sendKeys("15112332112");



        WaitUtils.waitFor(5);

        ActionsUtils.scrollDown();

        ExtentReportUtils.extentTestInfo("\"SAVE ADDRESS\" butonuna tıklar.");
        mainPage.vendorAddressesPage.saveAddressButton.click();

        ExtentReportUtils.extentTestInfo("\"Address changed successfully.\" metni görüldügünü dogrular.");
        Assert.assertTrue(mainPage.vendorAddressesPage.addressChangedSuccessfullyMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Vendor Billing Address  eklenebildiği doğrulandı.");
    }
}
