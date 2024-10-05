package techproed.allovercommerce.tests.US06;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.ExtentReportUtils;


public class TC009 extends PreConditionLogged{

    @Test(description = "TC009 - Kullanıcı aradığı ürünü stock'ta olmadığında sepete ekleyememeli (ADD TO CART)")
    public void testAddToCartProductIfItIsNotInStock() {
        MainPage mainPage = new MainPage();

        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPage.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Sitede stockta olmayan bir ürün ismi girer.");
        mainPage.homePage.searchbox.sendKeys("kitap");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPage.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden stock'ta olmayana tıklar.");
        mainPage.shoppingPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Sepete ekle butonunun görünmediği kontrol edilir.");

        Assert.assertFalse(mainPage.productPage.isAddToCartButtonVisible(), "Sepete ekle butonu görünüyor.");
        ExtentReportUtils.extentTestPass("Kullanıcının aradığı ürünü stock'ta olmadığında sepete ekleyemediği doğrulandı.");
    }
}
