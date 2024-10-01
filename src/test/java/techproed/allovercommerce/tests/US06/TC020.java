package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC020 extends PreConditionAccessTheWebsite{


    @Test(description = "TC020 - Kullanıcı Sign In olmadan Ürünleri satınalabilmek için fartura adres bilgileri  boş olmalı.")
    public void testBillingDetailsAreNotVisibleWithoutSignIn() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("bag");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        WebElement selectedProduct = mainPages.productPage.selectedProduct(0);

        ActionsUtils.hoverOver(selectedProduct);
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPages.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPages.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'CHECKOUT' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPages.cartPage.checkoutButton);

        Assert.assertTrue(mainPages.checkOutPage.billingDetailsList.stream().allMatch(t->t.getAttribute("value").isEmpty()));
    }
}
