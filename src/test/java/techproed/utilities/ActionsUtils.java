package techproed.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsUtils {
    private static Actions actions = new Actions(Driver.getDriver());

    /**
     * Belirtilen element üzerinde sağ tıklama (context click) işlemi yapar.
     *
     * @param element Sağ tıklama yapılacak WebElement.
     */
    public static void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    /**
     * Belirtilen element üzerinde çift tıklama işlemi yapar.
     *
     * @param element Çift tıklama yapılacak WebElement.
     */
    public static void doubleClick(WebElement element) {
        actions.doubleClick(element).build().perform();
    }

    /**
     * Belirtilen element üzerinde fare ile üzerine gelme (hover) işlemi yapar.
     *
     * @param element Üzerine gelinmesi istenen WebElement.
     */
    public static void hoverOver(WebElement element) {
        actions.moveToElement(element).perform();
    }

    /**
     * Sayfayı PAGE_DOWN tuşu ile aşağı kaydırır.
     */
    public static void scrollDown() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    /**
     * Sayfayı PAGE_UP tuşu ile yukarı kaydırır.
     */
    public static void scrollUp() {
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    /**
     * Sayfayı ARROW_RIGHT tuşu ile sağa kaydırır.
     */
    public static void scrollRight() {
        actions.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
    }

    /**
     * Sayfayı ARROW_LEFT tuşu ile sola kaydırır.
     */
    public static void scrollLeft() {
        actions.sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT).perform();
    }

    /**
     * Sayfayı HOME tuşu ile en üste kaydırır.
     */
    public static void scrollHome() {
        actions.sendKeys(Keys.HOME).perform();
    }

    /**
     * Sayfayı END tuşu ile en alta kaydırır.
     */
    public static void scrollEnd() {
        actions.sendKeys(Keys.END).perform();
    }

    /**
     * Kaynak elementi hedef elemente sürükleyip bırakır.
     *
     * @param source Sürüklenmek istenen WebElement.
     * @param target Bırakılmak istenen WebElement.
     */
    public static void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    /**
     * Kaynak elementi belirtilen mesafe kadar yatay (x) ve dikey (y) yönde sürükler.
     *
     * @param source  Sürüklenmek istenen WebElement.
     * @param xOffset Yatay eksende sürüklenme mesafesi (pozitif sağa, negatif sola).
     * @param yOffset Dikey eksende sürüklenme mesafesi (pozitif aşağı, negatif yukarı).
     */
    public static void dragAndDropBy(WebElement source, int xOffset, int yOffset) {
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }

    /**
     * TAB tuşuna basarak elementler arası geçiş yapmayı sağlar.
     */
    public static void pressTab() {
        actions.sendKeys(Keys.TAB).build().perform();
    }

    public static void hoverOverAndWait(WebElement element, int timeoutInSeconds) {
        try {
            // Actions sınıfı ile elementin üzerine git (hover)
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(element).perform();

            // Elementin tıklanabilir olmasını bekle
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds( timeoutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new RuntimeException("Element is not interactable or hover failed within the timeout: "
                    + timeoutInSeconds + " seconds", e);
        }
    }

    /**
     * Belirtilen elemente kaydırma yapar.
     * @param element Kaydırma yapılacak WebElement.
     */
    public static void scrollToElementUsingActions(WebElement element) {
        try {
            // Actions sınıfını kullanarak elemente kadar kaydır
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            throw new RuntimeException("Failed to scroll to element: " + element, e);
        }
    }


    /**
     * Belirtilen WebElement'in görünür olmasını bekler ve görünür hale geldiğinde tıklar.
     * @param element Tıklanacak WebElement.
     * @param timeoutInSeconds Bekleme süresi (saniye).
     */
    public static void waitForElementToBeVisibleAndClick(WebElement element, int timeoutInSeconds) {
        try {
            // Elementin görünür olmasını bekle
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds( timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));

            // Element görünür olduğunda, Actions ile tıkla
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on the element after waiting for visibility: " + element, e);
        }
    }
}
