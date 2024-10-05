package techproed.allovercommerce.tests.experiment;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPage;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;


public class Test01 {

    @Test
    public void test01() {
        MainPage mainPage = new MainPage();
        Faker faker = new Faker();

        Driver.getDriver().get("https://www.allovercommerce.com/");
        mainPage.homePage.register.click();
        WaitUtils.waitFor(3);

        String username = faker.name().username();
        System.out.println("Username : " + username);
        mainPage.registerPage.usernameBox.sendKeys(username);

        String email = faker.internet().emailAddress(username);
        System.out.println("Email : " + email);
        mainPage.registerPage.emailBox.sendKeys(email);

        String password = faker.internet().password(8, 12, true, true, true);
        System.out.println("Password : " + password);
        mainPage.registerPage.passwordBox.sendKeys(password);

        mainPage.registerPage.iAgreetoCheckBox.click();


    }

    @Test
    public void testName() {
        MainPage mainPage = new MainPage();
        Driver.getDriver().get("https://www.allovercommerce.com/");
        mainPage.homePage.searchbox.sendKeys("iphone", Keys.ENTER);
        mainPage.shoppingPage.selectedProduct(1).click();
        mainPage.productPage.addToCartButton.click();
        mainPage.homePage.cart.click();
        WaitUtils.waitForClickablility(mainPage.cartPage.viewCartButton, 10);
        JSUtils.JSclickWithTimeout(mainPage.cartPage.viewCartButton);

    }

}
