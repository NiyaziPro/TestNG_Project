package techproed.allovercommerce.tests.US20;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.*;

public class TC006 extends PC_VendorLogged {

    @Test(description = "TC006 - Vendor olarak Pay at the door seçenegi seçilebilmeli")

    public void testSelectPaymentsOptions() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Orders\"  butonuna tıklar.");
        mainPage.myAccountPage.ordersLink.click();
        ExtentReportUtils.extentTestInfo("\"Go Shop\"  butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.ordersPage.goShopButton);
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("iphone");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        ActionsUtils.hoverOver(mainPage.shoppingPage.selectedProduct(1));
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPage.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'CHECKOUT' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.checkoutButton);

        ExtentReportUtils.extentTestInfo("Pay at the door  seçenegini seçebildigini dogrular.");
        WebElement payAtTheDoor = mainPage.checkOutPage.payAtTheDoorRadioButton;
        if (!payAtTheDoor.isSelected()){
            JSUtils.JSclickWithTimeout(payAtTheDoor);
        }
        WaitUtils.waitFor(2);
        Assert.assertTrue(payAtTheDoor.isSelected());
        ExtentReportUtils.extentTestPass("Vendor olarak Pay at the door  seçenegi seçilebildigi doğrulandı.");
    }
}
