package techproed.allovercommerce.tests.us06;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;

public class TC005  extends PreConditionAccessTheWebsite{


    @Test(description = "Kullanıcı  search'box kutusunu boş bırakarak arama yapamamalı.")
    public void testSearchByLeavingTheSearchBoxBlank() {
        String beginTitle = Driver.getDriver().getTitle();
        ExtentReportUtils.extentTestInfo("Search box'a  tıklar ve  boş bırakır.");
        mainPages.homePage.searchbox.click();
        ExtentReportUtils.extentTestInfo("Search \uD83D\uDD0D ikonuna tıklar.");
        mainPages.homePage.searchboxButton.click();

        ExtentReportUtils.extentTestInfo("Arama yapamadığını dogrular.");
        Assert.assertEquals(Driver.getDriver().getTitle(),beginTitle);
        ExtentReportUtils.extentTestPass("Kullanıcının search'box kutusunu boş bırakarak arama yapamadığı doğrulandı.");
    }
}
