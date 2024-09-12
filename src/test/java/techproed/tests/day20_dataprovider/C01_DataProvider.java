package techproed.tests.day20_dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.util.Objects;

public class C01_DataProvider {

    /**
     * Dataprovider bircok veriyi test caslerde loop kullanmadan aktarmak icin
     * testng den gelen bir özelliktir
     * 2 boyutlu object array return eder,
     * Dataprovideri kullanabilmek icin @Test notasyonundan sonra
     * parametre olarak dataprovider yazip asagidaki örnekte oldugu gibi bir isim veririz.
     * Bu verileri kullanabilmek icin test methodunada data tipine uygun parametre ekleriz
     * inttelijden dataprovideri olusturmasi icin yardim alabiliriz,
     * sari uyarinin üzerinde bekledigimizde create ... seklinde cikan uyariya tiklamamiz yeterli olacaktir
     * bizim data provedirda belirttigimiz data adedince ilgili test methodumuz tekrar tekrar calistirilir
     * bunu arka planda testng kendisi otomatik olarak yapar
     */


    @DataProvider
    public static Object[][] names() {
        return new Object[][]{
                {"alican@gmail.com", "password", 17, true},
                {"velican@can.com", "veli1234", 20, false},
                {"ayse@yahoo.com", "1234Ayse", 25, false},
                {"fatme@abc.com", "fatma0000", 33, true}
        };
    }

    @Test(dataProvider = "names")
    public void testData(String email, String password, int age, boolean isValid) {

        System.out.println("Email : " + email + " /Password : " + password + " /Age : " + age + " /Is Valid : " + isValid);


    }
}
