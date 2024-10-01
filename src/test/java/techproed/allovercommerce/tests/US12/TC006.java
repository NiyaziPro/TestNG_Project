package techproed.allovercommerce.tests.US12;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC006 extends PreConditionVendorLogged{

    @Test(description = "TC006 - Eklenen kullanıcı Vendor Fatura bilgileri  güncellenebilmeli.")
    public void testEditBillingAddressDetails() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Addresses\" butonuna tıklar.");
        mainPage.myAccountPage.adressesLink.click();
        ExtentReportUtils.extentTestInfo("\"EDIT YOUR BILLING ADDRESS ->\" bağlantısına tıklar.");
        mainPage.vendorAddressesPage.editYourBillingAddress.click();

        WaitUtils.waitFor(3);

        ExtentReportUtils.extentTestInfo("\"First name\" kutusuna yeni geçerli  bir veri girer");
        mainPage.vendorAddressesPage.firstNameBox.clear();
        mainPage.vendorAddressesPage.firstNameBox.sendKeys("Allover2");
        ExtentReportUtils.extentTestInfo("\"Last name\" kutusuna yeni geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.lastNameBox.clear();
        mainPage.vendorAddressesPage.lastNameBox.sendKeys("Vendor2");
        ExtentReportUtils.extentTestInfo("\"Country / Region\" kutusunda  bir ülke seçer.");
        mainPage.vendorAddressesPage.openCountryDropDown.click();
        mainPage.vendorAddressesPage.inputForDropDownBox.sendKeys("Norway", Keys.ENTER);
        ExtentReportUtils.extentTestInfo("\"Street address\"   kutusuna yeni geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.streetAddressBox.clear();
        mainPage.vendorAddressesPage.streetAddressBox.sendKeys("Doet straat 21 27 dallas");
        ExtentReportUtils.extentTestInfo("\"Town / City\" kutusuna yeni geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.townCityBox.clear();
        mainPage.vendorAddressesPage.townCityBox.sendKeys("Oslo");
        ExtentReportUtils.extentTestInfo("\"ZIP Code\" kutusuna yeni geçerli bir veri girer.");
        mainPage.vendorAddressesPage.postZipCodeBox.clear();
        mainPage.vendorAddressesPage.postZipCodeBox.sendKeys("4410PG");
        ExtentReportUtils.extentTestInfo("\"Phone\" kutusuna yeni geçerli  bir veri girer.");
        mainPage.vendorAddressesPage.phoneBox.clear();
        mainPage.vendorAddressesPage.phoneBox.sendKeys("1234567890");


        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(3);

        ExtentReportUtils.extentTestInfo("\"SAVE ADDRESS\" butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.vendorAddressesPage.saveAddressButton);

        ExtentReportUtils.extentTestInfo("\"Address changed successfully.\" metni görüldügünü dogrular.");
        Assert.assertTrue(mainPage.vendorAddressesPage.addressChangedSuccessfullyMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Fatura bilgileri güncellendiği doğrulandı.");

    }
}
