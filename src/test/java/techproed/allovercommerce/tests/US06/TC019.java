package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;

import java.util.List;

public class TC019 extends PreConditionLogged {

    @Test(description = "TC019 - Kullanıcı Ürünleri satınalabilmek için fartura adresini görebilmeli")
    public void testVisibilityOfBillingAddress() {
        MainPage mainPage = new MainPage();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("bag");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPage.shoppingPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.productPage.addToCartButton);
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPage.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'Checkout' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPage.cartPage.checkoutButton);

        ExtentReportUtils.extentTestInfo("\"Billing details\" görüldüğünü doğrular.");

        Assert.assertTrue(areAllElementsDisplayed(mainPage.checkOutPage.billingDetailsList));

        ExtentReportUtils.extentTestPass("Kullanıcının Ürünleri satınalabilmek için fartura adresini görebildiği doğrulandı.");
    }

    public static boolean areAllElementsDisplayed(List<WebElement> elements) {
        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                return false;  // Eğer bir element görünmüyorsa false döner
            }
        }
        return true;  // Tüm elementler görünürse true döner
    }


}
