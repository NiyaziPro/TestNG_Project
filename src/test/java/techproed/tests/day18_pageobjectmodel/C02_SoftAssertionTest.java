package techproed.tests.day18_pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02_SoftAssertionTest {


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();

        // 1- amazon anasayfaya gidin https://amazon.com
        driver.get("https://amazon.com");

        // 2- title'in Amazon icerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"title Amazon icermiyor");

        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        softAssert.assertTrue(searchBox.isEnabled());

        // 4- arama kutusuna selenium yazip aratin
        searchBox.sendKeys("selenium", Keys.ENTER);

        // 5- arama yapildigini test edin
        WebElement actualResultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        softAssert.assertTrue(actualResultText.isDisplayed());

        // 6- arama sonucunun selenium icerdigini test edin

        softAssert.assertTrue(actualResultText.getText().contains("selenium"), "Arama sonucu selenium icermiyor");

        softAssert.assertAll();


    }
}
