package techproed.tests.day22_listeners;


import org.testng.Assert;

import org.testng.annotations.*;
import techproed.pages.DataProviderPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtilities;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReport;


public class C03_HomeWorkTests {
    DataProviderPage dataProviderPage;

    @BeforeClass
    public void beforeClass() {
        ExtentReport.createExtentReport("Extent Report Tests", "Niyazi Junior");
    }

    @BeforeMethod
    public void setUp() {
        dataProviderPage = new DataProviderPage();
        ExtentReport.getExtentTest().info("Kullanici Data Provider sitesine gider");
        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));
    }

    @Test(dataProvider = "positiveTestData", dataProviderClass = DataProviderUtilities.class,
            description = "US01_TC001 - Kullanici gecerli data'lar ile giris yapabilmeli")
    public void testAgeBoxVerifyPositive(String age) {

        dataProviderPage.ageBox.sendKeys(age);
        ExtentReport.getExtentTest().info("Kullanici 'Yas' kutusuna gecerli data girer");

        dataProviderPage.yasiDogrulaButton.click();
        ExtentReport.getExtentTest().info("Kullanici 'Yasi Dogrula' buttonuna tiklar");

        ExtentReport.getExtentTest().info("Beklenilen ve gelen sonuclar karsilastirilir");
        Assert.assertEquals(dataProviderPage.resultText.getText(), "Yaş doğrulandı!");
        ExtentReport.getExtentTest().pass("Kullanici gecerli bilgiler ile giris yapti");


    }

    @Test(dataProvider = "negativeTestData", dataProviderClass = DataProviderUtilities.class,
            description = "US01_TC002 - Kullanici gecersiz data'lar ile giris yapamamali")
    public void testAgeBoxVerifyNegative(String age) {

        dataProviderPage.ageBox.sendKeys(age);
        ExtentReport.getExtentTest().info("Kullanici 'Yas' kutusuna gecersiz data girer");

        dataProviderPage.yasiDogrulaButton.click();
        ExtentReport.getExtentTest().info("Kullanici 'Yasi Dogrula' buttonuna tiklar");

        ExtentReport.getExtentTest().info("Beklenilen ve gelen sonuclar karsilastirilir");
        Assert.assertEquals(dataProviderPage.resultText.getText(), "Yaş 18 ile 100 arasında olmalıdır.");
        ExtentReport.getExtentTest().pass("Kullanici gecersiz bilgiler ile giris yapamadi");


    }

    @Test(dataProvider = "invalidTestData", dataProviderClass = DataProviderUtilities.class, description = "US01_TC003 - Kullanici fake data'lar ile giris yapamamali")
    public void testAgeBoxVerifyInvalidData(String age) {


        dataProviderPage.ageBox.sendKeys(age);
        ExtentReport.getExtentTest().info("Kullanici 'Yas' kutusuna gecersiz data girer");

        dataProviderPage.yasiDogrulaButton.click();
        ExtentReport.getExtentTest().info("Kullanici 'Yasi Dogrula' buttonuna tiklar");

        Assert.assertEquals(dataProviderPage.resultText.getText(), "Geçersiz yaş!");


    }

    @AfterMethod
    public void tearDown() {
        ExtentReport.getExtentTest().info("Sayfa kapatilir");
        Driver.closeDriver();
    }

    @AfterClass
    public void afterClass() {
        ExtentReport.getExtentReports().flush();
    }
}
