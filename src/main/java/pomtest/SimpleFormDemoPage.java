package pomtest;

import keywordtest.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static keywordtest.Keyword.*;

public class SimpleFormDemoPage {

    private WebElement singleInputFieldInputField (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("user-message")));
    }

    private WebElement submitSingleInputMessage (WebDriver driver) {
        return Util.wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Show Message']")));
    }

    private WebElement singleInputMessageConfirmation (WebDriver driver, String input) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='" + input + "']")));
    }

    private WebElement twoInputFieldsA (WebDriver driver) {
        return Util.wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("sum1")));
    }

    private WebElement twoInputFieldsB (WebDriver driver) {
        return Util.wait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("sum2")));
    }

    private WebElement twoInputFieldsSubmit (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Get Total']")));
    }

    private WebElement twoInputFieldsResult (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("displayvalue")));
    }

    public void sendSingleInput(WebDriver driver, String input) {

        openPage("https://www.seleniumeasy.com/test/basic-first-form-demo.html", driver);

        writeText(singleInputFieldInputField(driver), input);
        clickElement(submitSingleInputMessage(driver));
    }

    public boolean validateSingleInput (WebDriver driver, String input) {
        return input.equals(innerText(singleInputMessageConfirmation(driver, input)));
    }

    public void sendTwoInputs(WebDriver driver, String inputA, String inputB, String result) {

        openPage("https://www.seleniumeasy.com/test/basic-first-form-demo.html", driver);

        writeText(twoInputFieldsA(driver), inputA);
        writeText(twoInputFieldsB(driver), inputB);
        clickElement(twoInputFieldsSubmit(driver));
    }

    public boolean validateTwoInputFieldsResult (WebDriver driver, String result) {
        return result.equals(innerText(twoInputFieldsResult(driver)));
    }
}
