package techproed.allovercommerce.tests.US12;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC002 extends PreConditionVendorLogged {

    @Test(description = "TC002 -  Vendor Billing Address Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilmeli")
    public void testEmailComeAutomatically() {
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
        ExtentReportUtils.extentTestInfo("\"First name\" kutusuna geçerli  bir veri girebildigini doğrular.");
        System.out.println("First Name value : " + mainPage.vendorAddressesPage.firstNameBox.getAttribute("value"));
        Assert.assertEquals(mainPage.vendorAddressesPage.firstNameBox.getAttribute("value"),"Allover");

        ExtentReportUtils.extentTestInfo("\"Last name\" kutusuna geçerli  bir veri girebildigini doğrular.");
        System.out.println("Last Name value : " + mainPage.vendorAddressesPage.lastNameBox.getAttribute("value"));
        Assert.assertEquals(mainPage.vendorAddressesPage.lastNameBox.getAttribute("value"),"Vendor");

        ExtentReportUtils.extentTestInfo("\"Country / Region\" kutusuna  bir ülke seçebildigini doğrular.");
        System.out.println("Country  value : " + mainPage.vendorAddressesPage.countryRegionBox.getText());
        Assert.assertEquals(mainPage.vendorAddressesPage.countryRegionBox.getText(),"Germany");

        ExtentReportUtils.extentTestInfo("\"Street address\"   kutusuna  bir veri girebildigini doğrular.");
        System.out.println("Street value : " + mainPage.vendorAddressesPage.streetAddressBox.getAttribute("value"));
        Assert.assertEquals(mainPage.vendorAddressesPage.streetAddressBox.getAttribute("value"),"Hansestrasse");

        ExtentReportUtils.extentTestInfo("\"Town / City\"   kutusuna  bir veri girebildigini doğrular.");
        System.out.println("First Name value : " + mainPage.vendorAddressesPage.townCityBox.getAttribute("value"));
        Assert.assertEquals(mainPage.vendorAddressesPage.townCityBox.getAttribute("value"),"Hamburg");

        ExtentReportUtils.extentTestInfo("\"ZIP Code\"  kutusuna  bir veri girebildigini doğrular.");
        System.out.println("First Name value : " + mainPage.vendorAddressesPage.postZipCodeBox.getAttribute("value"));
        Assert.assertEquals(mainPage.vendorAddressesPage.postZipCodeBox.getAttribute("value"),"22222");

        ExtentReportUtils.extentTestInfo("\"Phone\"   kutusuna  bir veri girebildigini doğrular.");
        System.out.println("First Name value : " + mainPage.vendorAddressesPage.phoneBox.getAttribute("value"));
        Assert.assertEquals(mainPage.vendorAddressesPage.phoneBox.getAttribute("value"),"15112332112");

        ExtentReportUtils.extentTestPass(" Vendor Billing Address Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilebildiği doğrulandı.");



    }
}
