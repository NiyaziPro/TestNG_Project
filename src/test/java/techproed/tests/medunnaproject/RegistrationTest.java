package techproed.tests.medunnaproject;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.utilities.*;

public class RegistrationTest{

    /*
US001: Registration should be available using SSN, Firstname and Lastname
    AC001: There should be a valid SSN respecting the "-" after 3rd and 5th digits, it should be 9 digits long
        AC001TC01: User enters the ssn 22255-5432, there should be "Your SSN is invalid" message
        AC001TC02: User enters the ssn 222-555432, there should be "Your SSN is invalid" message
        AC001TC03: User enters the ssn 222-55-543, there should be "Your SSN is invalid" message
        AC001TC04: User enters the ssn 222-55-543a, there should be "Your SSN is invalid" message
        AC001TC05: User enters the ssn 222-55-5432, there should not be any error message
    AC002: SSN cannot be left blank
        AC002TC01: User leaves the ssn blank, there should be "Your SSN is required." message
        AC002TC02: User enters the ssn only space, there should be "Your SSN is required." message
        AC002TC03: User enters the ssn 222-55-5432, there should not be any error message
    AC003: There should be a valid name that contains any chars and cannot be blank
        AC003TC01: User leaves the FirstName blank, there should be "Your FirstName is required." message
        AC003TC02: User enters the FirstName only space, there should be "Your FirstName is required." message
        AC003TC03: User enters the name that contains any chars, there should not be any error message
    AC004: There should be a valid lastname that contains any chars and it is a required field
        AC004TC01: User leaves the lastname blank, there should be "Your LastName is required." message
        AC004TC02: User enters the lastname only space, there should be "Your LastName is required." message
        AC004TC03: User enters the lastname that contains any chars, there should not be any error message
 */

   /*
     US001: SSN, Ad ve Soyad kullanılarak kayıt yapılabilmelidir

     AC001: 3. ve 5. rakamlardan sonra "-" işaretine uyarak geçerli bir SSN olmalıdır, 9 rakam uzunluğunda olmalıdır
         AC001-TC01: Kullanıcı ssn 22255-5432'yi girer, "SSN'niz geçersiz" mesajı olmalıdır
         AC001TC02: Kullanıcı 222-555432 numaralı SSN'yi girer, "SSN'niz geçersiz" mesajı olmalı
         AC001TC03: Kullanıcı 222-55-543 numaralı SSN'yi girer, "SSN'niz geçersiz" mesajı olmalıdır
         AC001TC04: Kullanıcı 222-55-543a ssn'sini girdiğinde "SSN'niz geçersiz" mesajı çıkmalıdır
         AC001TC05: Kullanıcı 222-55-5432 numaralı ssn'yi girer, herhangi bir hata mesajı olmamalıdır

     AC002: SSN boş bırakılamaz
         AC002TC01: Kullanıcı ssn'yi boş bırakır, "SSN'niz gereklidir" mesajı olmalıdır.
         AC002TC02: Kullanıcı yalnızca ssn alanını girer, "SSN'niz gereklidir" mesajı olmamalıdır.
         AC002TC03: Kullanıcı 222-55-5432 numaralı ssn'yi girer, herhangi bir hata mesajı olmamalıdır

     AC003: Herhangi bir karakter içeren ve boş olamayacak geçerli bir ad olmalıdır
         AC003TC01: Kullanıcı İlk Adı boş bırakır, "İlk Adınız gereklidir." mesajı olmalıdır.
         AC003TC02: Kullanıcı yalnızca İlkAd alanını girer, "İlkAdınız gereklidir." mesajı olmalıdır.
         AC003TC03: Kullanıcı herhangi bir karakter içeren bir ad girdiğinde, herhangi bir hata mesajı olmamalıdır

     AC004: Herhangi bir karakter içeren geçerli bir soyadı olmalıdır ve bu zorunlu bir alandır
         AC004TC01: Kullanıcı soyadını boş bırakır, "Soyadınız gereklidir." mesajı olmalıdır.
         AC004TC02: Kullanıcı soyadını yalnızca boşluk bırakarak girer, "Soyadınız gereklidir." mesajı olmalıdır.
         AC004TC03: Kullanıcı herhangi bir karakter içeren soyadı girer, herhangi bir hata mesajı olmamalıdır
  */
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperties("medunnaUrl"));
        ExtentReportUtils.extentTestInfo("Kullanici belirtilen siteye (https://www.medunna.com/) gider");
        ExtentReportUtils.extentTestInfo("Kullanici Ana sayfaya gider"); // User is on Medunna Home Page
        homePage.accountMenuDropDown.click();
        ExtentReportUtils.extentTestPass("Kullanici insan sembolune tiklar");
        homePage.registerButton.click();
        ExtentReportUtils.extentTestPass("Kullanici Register butonuna tiklar");

    }

    @Test(description = "US001_AC001 - Kullanıcı ssn 22255-5432'yi girer, \"SSN'niz geçersiz\" mesajı olmalıdır")
    public void ssnTest() {

        //AC001-TC01: Kullanıcı ssn 22255-5432'yi girer, "SSN'niz geçersiz" mesajı olmalıdır
        registrationPage.ssnBox.sendKeys("22255-5432", Keys.TAB);
        //ExtentReportUtils.addScreenShotToReport();
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);

        //AC001TC02: Kullanıcı 222-555432 numaralı SSN'yi girer, "SSN'niz geçersiz" mesajı olmalı
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-555432",Keys.TAB);
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);

        //AC001TC03: Kullanıcı 222-55-543 numaralı SSN'yi girer, "SSN'niz geçersiz" mesajı olmalıdır
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-55-543",Keys.TAB);
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);

        //AC001TC04: Kullanıcı 222-55-543a ssn'sini girdiğinde "SSN'niz geçersiz" mesajı çıkmalıdır
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-55-543a",Keys.TAB);
        //ExtentReportUtils.addScreenShotToReport();
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);

        //AC001TC05: Kullanıcı 222-55-5432 numaralı ssn'yi girer, herhangi bir hata mesajı olmamalıdır
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-55-5432",Keys.TAB);

        BrowserUtils.verifyElementNotDisplayed(registrationPage.ssnRequiredTextMsg);




    }


































}
