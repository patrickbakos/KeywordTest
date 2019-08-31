package sracok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static sracok.Keyword.*;

public class Repository {

    public static WebElement AllExamplesMenu (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='All Examples']")));
    }

    public static WebElement InputFormsMenu (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Input Forms']")));
    }

    public static WebElement SimpleFormDemoMenu (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='treemenu']//a[.='Simple Form Demo']")));
    }

    public static void waitForPageToLoad (WebDriver driver, String url) {
        Util.wait(driver, 10).until(ExpectedConditions.urlToBe("https://www.seleniumeasy.com/test/basic-first-form-demo.html"));
    }

    public static WebElement SingleInputFieldInputField (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("user-message")));
    }

    public static WebElement SubmitSingleInputMessage (WebDriver driver) {
        return Util.wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Show Message']")));
    }

    public static WebElement SingleInputMessageConfirmation (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='Lobab']")));
    }

}
