package sracok;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

    private static ChromeDriver driver;

    public static ChromeDriver getDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriverWait wait (WebDriver driver, long timeout) {
        return new WebDriverWait(driver, timeout);
    }
}
