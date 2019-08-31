package sracok;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

    public static WebDriverWait wait (WebDriver driver, long timeout) {
        return new WebDriverWait(driver, timeout);
    }
}
