package sracok.keywordtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Keyword {

    public static void openPage (String url, WebDriver driver) {
        driver.get(url);
    }

    public static String currentUrl (WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static void clickElement (WebElement webElement) {
        webElement.click();
    }

    public static boolean isDisplayed (WebElement webElement) {
        return webElement.isDisplayed();
    }

    public static void writeText (WebElement webElement, String text) { webElement.sendKeys(text); }

    public static String innerText (WebElement webElement) { return webElement.getText(); }

    public static boolean isSelected (WebElement webElement) { return webElement.isSelected(); }

    public static void selectFromSelectTag (Select select, String value) { select.selectByVisibleText(value);}
}
