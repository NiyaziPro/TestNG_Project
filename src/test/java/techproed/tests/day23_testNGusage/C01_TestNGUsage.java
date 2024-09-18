package techproed.tests.day23_testNGusage;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.pages.PracticePage;
import techproed.utilities.*;

import java.util.List;

@Listeners(techproed.utilities.ExtentReportsListener.class)

public class C01_TestNGUsage {


    // Go to https://practicesoftwaretesting.com/#/
    //test if the page title contains "Software Testing"
    //test if the page url contains the word "practice"
    //test that the number of products displayed on the page is 9
    // test whether each product is displayed on the page
    // print the products displayed on the page to the console
    //test that the number of products containing "hammer" displayed on the page is 4


    //  https://practicesoftwaretesting.com/#/ sayfasina gidin
    //  sayfa basliginin "Software Testing" icerdigini test edin
    //  sayfa url'nin "practice" kelimesini icerdigini test edin
    //  sayfada görüntülenen ürün sayisinin 9 oldugunu test edin
    //  her bir ürününün sayfada görüntülendigini test edin
    //  sayfada görüntülenen ürünleri konsol a yazdirin
    //  sayfada görüntülenen ürünlerden "hammer" iceren ürün sayisinin 4 oldugunu test edin


    @Test(description = "US2_TC001 - User verifies the product.")
    public void testProductVisibility() {

        //  https://practicesoftwaretesting.com/#/ sayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperties("softwareTestingUrl"));
        ExtentReportUtils.extentTestInfo("Kullanici verilen adrese gider");

        //  sayfa basliginin "Software Testing" icerdigini test edin
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Software Testing"));
        ExtentReportUtils.extentTestPass("Sayfa basligi 'Software Testing' icerdigi dogrulandi.");

        //  sayfa url'nin "practice" kelimesini icerdigini test edin
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("practice"));
        ExtentReportUtils.extentTestPass("Sayfa url'nin 'practice' kelimesini icerdigi dogrulandi");

        //  sayfada görüntülenen ürün sayisinin 9 oldugunu test edin

        PracticePage practicePage = new PracticePage();
        List<WebElement> products = practicePage.products;
        Assert.assertEquals(products.size(), 9);
        ExtentReportUtils.extentTestPass("Sayfada görüntülenen ürün sayisinin 9 oldugu dogrulandi");

        //  her bir ürününün sayfada görüntülendigini test edin

        WaitUtils.waitForPageToLoad(5);

        for (WebElement w : products) {
            Assert.assertTrue(w.isDisplayed());
        }
        ExtentReportUtils.extentTestPass("Sayfada her bir ürününün  görüntülendigi dogrulandi");

        WaitUtils.waitForPageToLoad(5);

        //  sayfada görüntülenen ürünleri konsol a yazdirin

        for (WebElement w : products) {
            System.out.println(w.getText());
        }

        System.out.println("=====================================");

        products.forEach(t -> System.out.println(t.getText()));



        //  sayfada görüntülenen ürünlerden "hammer" iceren ürün sayisinin 4 oldugunu test edin


        WaitUtils.waitForPageToLoad(5);

        int counter = 0;
        for (WebElement w : products) {
            if (w.getText().contains("hammer")) {
                counter++;
            }
        }


        Assert.assertEquals(counter, 4);
        ExtentReportUtils.extentTestFail("Sayfada görüntülenen ürünlerden 'hammer' iceren ürün sayisinin 4 olmadigi dogrulandi");
        ExtentReportUtils.addScreenShotToReport();

        Driver.getDriver().close();




    }
}
