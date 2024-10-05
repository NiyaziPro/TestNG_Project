package techproed.allovercommerce.tests.US20;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

import java.util.List;

public class TC008 extends PC_VendorLogged {

    @Test(description = "TC008 - My Account -Orders yapılan alışverişin ayrıntıları görülebilmeli.")

    public void testVisibilityOFCompletedOrders() {
        ExtentReportUtils.extentTestInfo(" Kullanıcı \"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Orders\"  butonuna tıklar.");
        mainPage.myAccountPage.ordersLink.click();
        ExtentReportUtils.extentTestInfo("\"Go Shop\"  butonuna tıklar.");
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
        ExtentReportUtils.extentTestInfo("Place Order' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.checkOutPage.placeOrderButton);
        WaitUtils.waitForVisibility(mainPage.orderCompletePage.orderCompletedMsg,8);
        ExtentReportUtils.extentTestInfo("Alışveriş tamamlanır .");
        ExtentReportUtils.extentTestInfo("\"Sign out\"  butonuna tıklar.");
        mainPage.homePage.signOutButton.click();
        ExtentReportUtils.extentTestInfo("\"Orders\"  butonuna tıklar.");
        mainPage.myAccountPage.ordersLink.click();
        List<WebElement> orders =  mainPage.ordersPage.ordersList;

        for (int i = 0; i < orders.size(); i++) {
            if (i==0){
                orders.get(i).click();
            }
        }

        ExtentReportUtils.extentTestInfo("Yapılan alışverişin ayrıntıları görülebildigini dogrular.");
        Assert.assertTrue(mainPage.ordersPage.orderDetails.isDisplayed());
        ExtentReportUtils.extentTestPass("Vendor olarak yapılan alışverişin ayrıntıları görülebildigi doğrulandı.");
    }
}
