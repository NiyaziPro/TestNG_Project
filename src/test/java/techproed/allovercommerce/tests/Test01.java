package techproed.allovercommerce.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

import java.util.Locale;

public class Test01 {

    @Test
    public void test01() {
        MainPages mainPages = new MainPages();
        Faker faker = new Faker(Locale.of("tr", "tr"));

        Driver.getDriver().get("https://www.allovercommerce.com/");
        mainPages.homePage.register.click();
        WaitUtils.waitFor(3);

        String username = faker.name().username();
        System.out.println("Username : " + username);
        mainPages.registerPage.usernameBox.sendKeys(username);

        String email = faker.internet().emailAddress(username);
        System.out.println("Email : "+email);
        mainPages.registerPage.emailBox.sendKeys(email);

        String password = faker.internet().password(8,12,true,true,true);
        System.out.println("Password : " + password);
        mainPages.registerPage.passwordBox.sendKeys(password);

        mainPages.registerPage.iAgreetoCheckBox.click();



    }

    @Test
    public void testName() {
        MainPages mainPages = new MainPages();
        Driver.getDriver().get("https://www.allovercommerce.com/");
        mainPages.homePage.searchbox.sendKeys("iphone", Keys.ENTER);
        mainPages.productPage.selectedProduct(1).click();
        mainPages.productPage.addToCartButton.click();
        mainPages.homePage.cart.click();
        WaitUtils.waitForClickablility(mainPages.cartPage.viewCartButton, 10);
        JSUtils.JSclickWithTimeout(mainPages.cartPage.viewCartButton);

    }
}
