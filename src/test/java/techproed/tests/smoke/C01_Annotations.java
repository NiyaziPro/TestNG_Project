package techproed.tests.smoke;

import org.testng.annotations.*;

public class C01_Annotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Her seyden once @BeforeSuite notasyonuna sahip method bir kez calisir.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Her seyden sonra @AfterSuite notasyonuna sahip method bir kez calisir.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Testlerden once @BeforeTest notasyonuna sahip method bir kez calisir.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Testlerden sonra @afterTest notasyonuna sahip method bir kez calisir.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her classtan once @beforeClass notasyonuna sahip method bir kez calisir.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Her classtan sonra @afterClass notasyonuna sahip method bir kez calisir.");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Her test methodundan once @beforeMethod notasyonuna sahip method bir kez calisir.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Her test methodundan sonra @AfterMethod notasyonuna sahip method bir kez calisir.");
    }

    @Test
    public void test01() {
        System.out.println("Test01");
    }

    @Test
    public void test02() {
        System.out.println("Test02");
    }

    @Test
    public void test03() {
        System.out.println("Test03");
    }
}
