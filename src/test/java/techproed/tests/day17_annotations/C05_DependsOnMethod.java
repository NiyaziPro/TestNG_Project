package techproed.tests.day17_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependsOnMethod {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Macbook Pro", Keys.ENTER);
        Thread.sleep(3000);

        Assert.assertTrue(false);

    }

    @Test (dependsOnMethods = "test01")
    public void test02() {

        //sonuc yazisini Macbook Pro icerdigini test edelim

        String resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        System.out.println("Result Text : "+resultText);

        Assert.assertTrue(resultText.contains("Macbook Pro"));

    }
}
