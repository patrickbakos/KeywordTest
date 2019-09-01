import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeDriver;
import sracok.Repository;
import sracok.Util;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static sracok.Keyword.*;
import static sracok.Repository.*;

public class Script {

    private static ChromeDriver driver;

    @BeforeEach
    void driver() {
        driver = Util.getDriver();
    }

    @BeforeEach
    void startingSite() {
        openPage("https://www.seleniumeasy.com/test/", driver);
    }

    @AfterEach
    void closePage() {
        driver.quit();
    }


    @Test
    public void simpleDemoFromMenu() {

        if (isDisplayed(SimpleFormDemoMenu(driver))) {
            clickElement(SimpleFormDemoMenu(driver));
        } else if (isDisplayed(InputFormsMenu(driver))) {
            clickElement(InputFormsMenu(driver));
            clickElement(SimpleFormDemoMenu(driver));
        } else {
            clickElement(AllExamplesMenu(driver));
            clickElement(InputFormsMenu(driver));
            clickElement(SimpleFormDemoMenu(driver));
        }
        assertEquals("https://www.seleniumeasy.com/test/basic-first-form-demo.html", currentUrl(driver));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/singleinput.csv", numLinesToSkip = 1)
    public void singleInputField(String input) {

        openPage("https://www.seleniumeasy.com/test/basic-first-form-demo.html", driver);

        writeText(SingleInputFieldInputField(driver), input);
        clickElement(SubmitSingleInputMessage(driver));

        assertEquals(input, innerText(SingleInputMessageConfirmation(driver, input)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/twofieldsoutput.csv", numLinesToSkip = 1)
    public void twoFieldsOutput(String inputA, String inputB, String result) {

        openPage("https://www.seleniumeasy.com/test/basic-first-form-demo.html", driver);

        writeText(twoInputFieldsA(driver), inputA);
        writeText(twoInputFieldsB(driver), inputB);
        clickElement(twoInputFieldsSubmit(driver));

        assertEquals(result, innerText(twoInputFieldsResult(driver)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/checkbox.csv", delimiter = '\n')
    public void checkbox(String lineOfData) {

        String[] dataArray = lineOfData.split(",");

        openPage("https://www.seleniumeasy.com/test/basic-checkbox-demo.html", driver);

        String message = "Uncheck All";
        for (int i = 1; i <= dataArray.length; i++) {
            if (dataArray[i-1] == "1") {
                clickElement(multiCheckboxLabels(driver, i));
            } else message = "Check All";
        }

        clickElement(multiCheckBoxButton(driver));

        boolean allConditionsMet = true;

        for (int i = 1; i <= dataArray.length; i++) {
            if (!isSelected(multiCheckBoxInput(driver, i))) allConditionsMet = false;
        }

        assertTrue(allConditionsMet);
    }

    @Test
    public void multiCheckboxButton () {

        openPage("https://www.seleniumeasy.com/test/basic-checkbox-demo.html", driver);

        clickElement(multiCheckBoxButton(driver));
        assertTrue(multiCheckBoxInput(driver, 1).isSelected());
    }

    @Test
    public void checkBoxButton () {

        openPage("https://www.seleniumeasy.com/test/basic-checkbox-demo.html", driver);

        clickElement(checkBoxLabel(driver));
        assertTrue(isSelected(checkBoxInput(driver)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/daySelector.csv")
    public void selectDropdown (String day) {

        openPage("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html", driver);

        selectFromSelectTag(daySelect(driver), day);
        assertTrue(isSelected(daySelectorOption(driver, day)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/radiobuttons.csv", numLinesToSkip = 1)
    public void radioButtons(String sex, String age) {

        openPage("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html", driver);

        clickElement(radioButtonByValueandName(driver,sex, "gender"));
        clickElement(radioButtonByValueandName(driver, age, "ageGroup"));
        clickElement(groupRadioSubmit(driver));
        String validationText = groupRadioValidation(driver).getText();
        assertTrue(validationText.contains(sex) && validationText.contains(age));
    }
}
