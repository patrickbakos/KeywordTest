package pomtest;

import keywordtest.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static keywordtest.Keyword.*;

public class CheckBoxDemoPage {

    private WebElement multiCheckboxLabels (WebDriver driver, int number) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(.,'Option " + number + "')]")));
    }

    private WebElement multiCheckBoxButton (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("check1")));
    }

    private WebElement multiCheckBoxInput (WebDriver driver, int number) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(.,'Option " + number + "')]/input")));
    }

    private WebElement checkBoxLabel (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[.//input[@id='isAgeSelected']]")));
    }

    private WebElement checkBoxInput (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("isAgeSelected")));
    }

    public boolean simpleCheckBoxValidation (WebDriver driver) {

        openPage("https://www.seleniumeasy.com/test/basic-checkbox-demo.html", driver);

        clickElement(checkBoxLabel(driver));
        return isSelected(checkBoxInput(driver));
    }

    public boolean multiCheckBoxButtonCheck (WebDriver driver) {

        openPage("https://www.seleniumeasy.com/test/basic-checkbox-demo.html", driver);

        clickElement(multiCheckBoxButton(driver));
        return isSelected(multiCheckBoxInput(driver, 1));
    }

    public boolean multiCheckBoxVariations (WebDriver driver, String lineOfData) {

        String[] dataArray = lineOfData.split(",");

        openPage("https://www.seleniumeasy.com/test/basic-checkbox-demo.html", driver);

        String message = "Uncheck All";
        boolean allConditionsMet = true;

        for (int i = 1; i <= dataArray.length; i++) {
            if (dataArray[i-1] == "1") {
                clickElement(multiCheckboxLabels(driver, i));
            } else message = "Check All";
        }

        if (!message.equals(multiCheckBoxButton(driver).getAttribute("value"))) allConditionsMet = false;
        clickElement(multiCheckBoxButton(driver));


        for (int i = 1; i <= dataArray.length; i++) {
            if (!isSelected(multiCheckBoxInput(driver, i))) allConditionsMet = false;
        }
        return allConditionsMet;
    }
}
