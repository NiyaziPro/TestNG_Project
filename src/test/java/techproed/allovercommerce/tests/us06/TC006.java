package techproed.allovercommerce.tests.us06;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.WaitUtils;

public class TC006 extends PreConditionLogged {

    @Test(description = "TC006 - Kullanıcı aradığı ürünü sepete ekleyebilmeli (ADD TO CART)")
    public void testAddToCart() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();

        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer ve Entere tıklar.");
        mainPages.homePage.searchbox.sendKeys("Iphone", Keys.ENTER);
        WaitUtils.waitFor(5);

        WebElement product = mainPages.productPage.selectedProduct(1);
        int cartCount = Integer.parseInt(mainPages.cartPage.cartCount.getText());

        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        product.click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        mainPages.productPage.addToCartButton.click();
        WaitUtils.waitFor(5);
        int updateCartCount = Integer.parseInt(mainPages.cartPage.cartCount.getText());

        ExtentReportUtils.extentTestInfo("Ürünün sepete eklendiğini dogrular.");
        Assert.assertEquals(updateCartCount, cartCount + 1);
        Assert.assertTrue(updateCartCount > cartCount);
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü sepete ekleyebildiği doğrulandı.");


    }
}
