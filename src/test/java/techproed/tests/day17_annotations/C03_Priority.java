package techproed.tests.day17_annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test//(priority = 0) ->default
    public void test01() {
        driver.get("https://www.youtube.com");
    }

    @Test(priority = 2)
    public void test02() {
        driver.get("https://www.google.com");
    }

    @Test(priority = -1)
    public void test03() {
        driver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
