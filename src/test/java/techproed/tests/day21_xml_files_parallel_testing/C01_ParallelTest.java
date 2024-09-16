package techproed.tests.day21_xml_files_parallel_testing;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_ParallelTest {


    @Test
    public void testParallel1() {

        Driver.getDriver().get(ConfigReader.getProperties("techproUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        Driver.closeDriver();

    }
    @Test
    public void testParallel2() {

        Driver.getDriver().get(ConfigReader.getProperties("techproUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        Driver.closeDriver();

    }

    @Test
    public void testParallel3() {

        Driver.getDriver().get(ConfigReader.getProperties("techproUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        Driver.closeDriver();

    }
    @Test
    public void testParallel4() {

        Driver.getDriver().get(ConfigReader.getProperties("techproUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        Driver.closeDriver();

    }
    @Test
    public void testParallel5() {

        Driver.getDriver().get(ConfigReader.getProperties("techproUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        Driver.closeDriver();

    }
    @Test
    public void testParallel6() {

        Driver.getDriver().get(ConfigReader.getProperties("techproUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperties("googleUrl"));
        Driver.closeDriver();

    }

}
