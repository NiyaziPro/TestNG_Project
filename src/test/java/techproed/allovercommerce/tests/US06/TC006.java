package techproed.allovercommerce.tests.US06;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC006 extends PreConditionLogged {

    @Test(description = "TC006 - Kullanıcı aradığı ürünü sepete ekleyebilmeli (ADD TO CART)")
    public void testAddToCart() {
        MainPage mainPage = new MainPage();

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();

        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer ve Entere tıklar.");
        mainPage.homePage.searchbox.sendKeys("Iphone", Keys.ENTER);
        WaitUtils.waitFor(5);

        WebElement product = mainPage.shoppingPage.selectedProduct(1);
        int cartCount = Integer.parseInt(mainPage.cartPage.cartCount.getText());

        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        product.click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        mainPage.productPage.addToCartButton.click();
        WaitUtils.waitFor(5);
        int updateCartCount = Integer.parseInt(mainPage.cartPage.cartCount.getText());

        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        Assert.assertEquals(updateCartCount, cartCount + 1);
        Assert.assertTrue(updateCartCount > cartCount);
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü sepete ekleyebildiği doğrulandı.");


    }
}
