package techproed.tests.day18_pageobjectmodel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C01_SoftAssertion {






    @Test(groups = "smoke")
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(3,2);
        System.out.println("test calismaya devam etti....");
        softAssert.assertNotEquals(3,3);
        System.out.println("test calismaya devam etti....");
        softAssert.assertTrue(3>4);
        System.out.println("test calismaya devam etti....");
        softAssert.assertFalse(4>3);
        System.out.println("test calismaya devam etti....");

        softAssert.assertAll();

        System.out.println("test calismaya devam etmedi....");

    }
}