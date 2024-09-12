package techproed.tests.day20_dataprovider;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtilities;
import techproed.utilities.Driver;

public class C04_HomeWork {

    @Test(dataProvider = "positiveTestData",dataProviderClass = DataProviderUtilities.class)
    public void testAgeBoxVerifyPositive(String age) {

        DataProviderPage dataProviderPage = new DataProviderPage();

        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        dataProviderPage.ageBox.sendKeys(age);
        dataProviderPage.yasiDogrulaButton.click();

        Assert.assertEquals(dataProviderPage.resultText.getText(),"Yaş doğrulandı!");

        Driver.closeDriver();
    }

    @Test(dataProvider = "negativeTestData",dataProviderClass = DataProviderUtilities.class)
    public void testAgeBoxVerifyNegative(String age) {

        DataProviderPage dataProviderPage = new DataProviderPage();

        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        dataProviderPage.ageBox.sendKeys(age);
        dataProviderPage.yasiDogrulaButton.click();

        Assert.assertEquals(dataProviderPage.resultText.getText(),"Yaş 18 ile 100 arasında olmalıdır.");

        Driver.closeDriver();
    }

    @Test(dataProvider = "invalidTestData",dataProviderClass = DataProviderUtilities.class)
    public void testAgeBoxVerifyInvalidData(String age) {

        DataProviderPage dataProviderPage = new DataProviderPage();

        Driver.getDriver().get(ConfigReader.getProperties("dataProviderUrl"));

        dataProviderPage.ageBox.sendKeys(age);
        dataProviderPage.yasiDogrulaButton.click();

        Assert.assertEquals(dataProviderPage.resultText.getText(),"Geçersiz yaş!");

        Driver.closeDriver();
    }
}
