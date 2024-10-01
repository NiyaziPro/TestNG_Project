package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC012 extends PreConditionAccessTheWebsite {
    @Test(description = "TC012 - Kullanıcı Sign In olmadan Sepete (Cart) eklediği ürünleri görebilmeli")
    public void testProductsAddedToTheCartWithoutSignIn() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("Leather shoes");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Aradığı ürünün üzerine gider.");
        WebElement selectedProduct = mainPages.productPage.selectedProduct(0);
        String productText = selectedProduct.getText();
        ActionsUtils.hoverOver(selectedProduct);
        ExtentReportUtils.extentTestInfo("Bag \uD83D\uDC5Cikonu görülünceye kadar bekler ve görülünce ona tiklar.");
        WaitUtils.waitForClickablility(mainPages.shoppingPage.bagIcon(), 5).click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPages.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'View Cart' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPages.cartPage.viewCartButton);

        WaitUtils.waitFor(5);

        ExtentReportUtils.extentTestInfo("Ürünü sepette görebildiğini doğrular.");
        Assert.assertTrue(mainPages.cartPage.doesListContainText(productText));
    }
}
