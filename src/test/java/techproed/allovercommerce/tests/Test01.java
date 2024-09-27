package techproed.allovercommerce.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.allovercommerce.pages.MainPages;
import techproed.utilities.Driver;
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
}
