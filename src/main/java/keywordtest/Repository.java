package keywordtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    public static WebElement SingleInputFieldInputField (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("user-message")));
    }

    public static WebElement SubmitSingleInputMessage (WebDriver driver) {
        return Util.wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Show Message']")));
    }

    public static WebElement SingleInputMessageConfirmation (WebDriver driver, String input) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='" + input + "']")));
    }

    public static WebElement twoInputFieldsA (WebDriver driver) {
        return Util.wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("sum1")));
    }

    public static WebElement twoInputFieldsB (WebDriver driver) {
        return Util.wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("sum2")));
    }

    public static WebElement twoInputFieldsSubmit (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Get Total']")));
    }

    public static WebElement twoInputFieldsResult (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("displayvalue")));
    }

    public static WebElement multiCheckboxLabels (WebDriver driver, int number) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(.,'Option " + number + "')]")));
    }

    public static WebElement multiCheckBoxButton (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("check1")));
    }

    public static WebElement multiCheckBoxInput (WebDriver driver, int number) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(.,'Option " + number + "')]/input")));
    }

    public static WebElement checkBoxLabel (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[.//input[@id='isAgeSelected']]")));
    }

    public static WebElement checkBoxInput (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("isAgeSelected")));
    }

    public static Select daySelect (WebDriver driver) {
        return new Select(Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("select-demo"))));
    }

    public static WebElement daySelectorOption (WebDriver driver, String name) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[.='" + name + "']")));
    }

    public static WebElement radioButtonByValueandName (WebDriver driver, String value, String name) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[.//input[@name='" + name + "' and @value='" + value + "']]")));
    }

    public static WebElement groupRadioSubmit (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Get values']")));
    }

    public static WebElement groupRadioValidation (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='groupradiobutton']")));
    }



}

