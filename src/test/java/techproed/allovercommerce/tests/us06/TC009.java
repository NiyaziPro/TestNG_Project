package techproed.allovercommerce.tests.us06;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;


public class TC009 extends PreConditionLogged{

    @Test(description = "TC009 - Kullanıcı aradığı ürünü stock'ta olmadığında sepete ekleyememeli (ADD TO CART)")
    public void testAddToCartProductIfItIsNotInStock() {

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Sitede stockta olmayan bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("kitap");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden stock'ta olmayana tıklar.");
        mainPages.productPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Sepete ekle butonunun görünmediği kontrol edilir.");

        Assert.assertFalse(mainPages.productPage.isAddToCartButtonVisible(), "Sepete ekle butonu görünüyor.");
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü stock'ta olmadığında sepete ekleyemediği doğrulandı.");
    }
}
