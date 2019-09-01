package pomtest;

import keywordtest.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static keywordtest.Keyword.*;

public class RadioButtonsDemoPage {

    private WebElement radioButtonByValueandName (WebDriver driver, String value, String name) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[.//input[@name='" + name + "' and @value='" + value + "']]")));
    }

    private WebElement groupRadioSubmit (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Get values']")));
    }

    private WebElement groupRadioValidation (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='groupradiobutton']")));
    }

    public boolean checkRadioVariation (WebDriver driver, String sex, String age) {

        openPage("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html", driver);

        clickElement(radioButtonByValueandName(driver,sex, "gender"));
        clickElement(radioButtonByValueandName(driver, age, "ageGroup"));
        clickElement(groupRadioSubmit(driver));
        String validationText = groupRadioValidation(driver).getText();
        return validationText.contains(sex) && validationText.contains(age);
    }
}
