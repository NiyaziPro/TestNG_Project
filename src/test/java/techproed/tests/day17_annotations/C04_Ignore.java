package techproed.tests.day17_annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_Ignore {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test (enabled = false)
    public void test01() {
        driver.get("https://www.youtube.com");
    }

    @Test@Ignore
    public void test02() {
        driver.get("https://www.google.com");
    }

    @Test
    public void test03() {
        driver.get("https://www.linkedin.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }












}
