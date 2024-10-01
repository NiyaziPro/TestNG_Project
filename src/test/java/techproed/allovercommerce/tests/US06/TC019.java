package techproed.allovercommerce.tests.US06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ExtentReportUtils;
import techproed.utilities.JSUtils;

public class TC019 extends PreConditionLogged {

    @Test(description = "TC019 - Kullanıcı Ürünleri satınalabilmek için fartura adresini görebilmeli")
    public void testVisibilityOfBillingAddress() {
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Istediği bir ürün ismi girer.");
        mainPages.homePage.searchbox.sendKeys("bag");
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();
        ExtentReportUtils.extentTestInfo("Cikan ürünlerden istedigine tıklar.");
        mainPages.productPage.selectedProduct(0).click();

        ExtentReportUtils.extentTestInfo("Urün detay sayfasında 'ADD TO CART' butonuna tıklar.");
        mainPages.productPage.addToCartButton.click();
        ExtentReportUtils.extentTestInfo("Cart' ikonuna tıklar.");
        mainPages.homePage.cart.click();

        ExtentReportUtils.extentTestInfo("Açılan sekmede 'Checkout' butonuna tıklar.");
        JSUtils.JSclickWithTimeout(mainPages.cartPage.checkoutButton);

        ExtentReportUtils.extentTestInfo("\"Billing details\" görüldüğünü doğrular.");
        Assert.assertTrue(mainPages.checkOutPage.firstNameBox.isDisplayed());
        Assert.assertFalse(mainPages.checkOutPage.firstNameBox.getAttribute("value").isEmpty());

        ExtentReportUtils.extentTestPass("Kullanıcının Ürünleri satınalabilmek için fartura adresini görebildiği doğrulandı.");
    }


    /*
        for (WebElement w : mainPages.checkOutPage.billingDetailsList) {
            if (mainPages.checkOutPage.billingDetailsTitleList.stream().allMatch(t->t.getText().contains("*"))) {
                try {
                    System.out.println("Yildiz icerenler buraya girmeli");
                    Assert.assertFalse(w.getAttribute("value").isEmpty());

                } catch (NullPointerException e) {
                    System.out.println("NullPointerException = " + w.getText());
                }

            }else {
                System.out.println("Yildiz icermeyenler : "+w.getText());
            }
        }

        // Başlıklar ve input alanlarını kontrol eder
        for (int i = 0; i < mainPages.checkOutPage.billingDetailsTitleList.size(); i++) {
            WebElement titleElement = mainPages.checkOutPage.billingDetailsTitleList.get(i); // Başlık elementi
            WebElement inputElement = mainPages.checkOutPage.billingDetailsList.get(i);      // Input alanı

            // Başlık yıldız içeriyorsa, input alanının boş olmadığını kontrol et
            if (titleElement.getText().contains("*")) {
                try {
                    System.out.println("Zorunlu alan: " + titleElement.getText());
                    Assert.assertFalse(inputElement.getAttribute("value").isEmpty(), "Zorunlu alan boş olamaz: " + titleElement.getText());
                } catch (NullPointerException e) {
                    System.out.println("NullPointerException: " + titleElement.getText());
                }
            } else {
                System.out.println("Zorunlu olmayan alan: " + titleElement.getText());
            }
        }*/


}
