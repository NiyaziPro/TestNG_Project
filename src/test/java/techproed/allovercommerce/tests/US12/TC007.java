package techproed.allovercommerce.tests.US12;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC007 extends PreConditionVendorLogged {

    @Test(description = "TC007 - Kullanıcı Vendor Billing Address (Fatura Adresi) kısmında zorunlu alanları sadece SPACE ( bosluk ) karakterini girerek Save yapamamalı.")
    public void testEditBillingAddressDetails() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Addresses\" butonuna tıklar.");
        mainPage.myAccountPage.adressesLink.click();
        ExtentReportUtils.extentTestInfo("\"EDIT YOUR BILLING ADDRESS ->\" bağlantısına tıklar.");
        mainPage.vendorAddressesPage.editYourBillingAddress.click();

        WaitUtils.waitFor(3);

        ExtentReportUtils.extentTestInfo("\"First name\" kutusuna Space karakterini girer.");
        mainPage.vendorAddressesPage.firstNameBox.clear();
        mainPage.vendorAddressesPage.firstNameBox.sendKeys(" ");
        ExtentReportUtils.extentTestInfo("\"Last name\" kutusuna Space karakterini girer.");
        mainPage.vendorAddressesPage.lastNameBox.clear();
        mainPage.vendorAddressesPage.lastNameBox.sendKeys(" ");
        ExtentReportUtils.extentTestInfo("\"Country / Region\" kutusundan bir veri secmez.");
        ExtentReportUtils.extentTestInfo("\"Street address\" kutusuna Space karakterini girer.");
        mainPage.vendorAddressesPage.streetAddressBox.clear();
        mainPage.vendorAddressesPage.streetAddressBox.sendKeys(" ");
        ExtentReportUtils.extentTestInfo("\"Town / City\" kutusuna Space karakterini girer.");
        mainPage.vendorAddressesPage.townCityBox.clear();
        mainPage.vendorAddressesPage.townCityBox.sendKeys(" ");
        ExtentReportUtils.extentTestInfo("\"Postcode / ZIP\" kutusuna Space karakterini girer.");
        mainPage.vendorAddressesPage.postZipCodeBox.clear();
        mainPage.vendorAddressesPage.postZipCodeBox.sendKeys(" ");
        ExtentReportUtils.extentTestInfo("\"Phone\" kutusuna Space karakterini girer.");
        mainPage.vendorAddressesPage.phoneBox.clear();
        mainPage.vendorAddressesPage.phoneBox.sendKeys(" ");
        ExtentReportUtils.extentTestInfo("Email kutusuna Space karakterini girer.");
        mainPage.vendorAddressesPage.emailAddressBox.clear();
        mainPage.vendorAddressesPage.emailAddressBox.sendKeys(" ");


        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(3);

        ExtentReportUtils.extentTestInfo("\"SAVE ADDRESS\" butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.vendorAddressesPage.saveAddressButton);

        ExtentReportUtils.extentTestInfo("Hata mesajları aldıgını doğrular.");
        for (WebElement w : mainPage.vendorAddressesPage.alertMessageList) {
            System.err.println("Alert : " + w.getText());
            Assert.assertTrue(w.isDisplayed());
        }
        ExtentReportUtils.extentTestPass("Vendor Billing Address kısmında zorunlu alanları sadece SPACE  karakterini girerek Save yapılamadığı doğrulandı.");


    }
}
