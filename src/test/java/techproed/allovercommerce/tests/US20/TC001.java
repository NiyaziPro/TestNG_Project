package techproed.allovercommerce.tests.US20;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.*;


public class TC001 extends PC_VendorLogged {

    @Test(description = "TC001 - Vendor olarak Ürün ve ürünler seçilip sepete eklenebilmeli.")
    public void testAddProductToCartAsAVendor() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Orders\"  butonuna tıklar.");
        mainPage.myAccountPage.ordersLink.click();
        ExtentReportUtils.extentTestInfo("\"Go Shop\"  butonuna tıklar.");
        JSUtils.JSscrollAllTheWayDown();
        JSUtils.JSclickWithTimeout(mainPage.ordersPage.goShopButton);
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("book");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        ActionsUtils.hoverOver(mainPage.shoppingPage.selectedProduct(0));
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPage.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        WebElement addedMsg = mainPage.shoppingPage.hasBeenAddedToCartMsg;
        WaitUtils.waitForVisibility(addedMsg,5);
        Assert.assertTrue(addedMsg.isDisplayed());
        ExtentReportUtils.extentTestPass("Vendor olarak ürün ve ürünler seçilip sepete eklenebildigi doğrulandı.");
    }
}
