package sracok;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keyword {

    private static ChromeDriver driver = new ChromeDriver();

    public static ChromeDriver getDriver() {
        return driver;
    }

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


}
