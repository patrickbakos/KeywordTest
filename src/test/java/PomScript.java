import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.chrome.ChromeDriver;
import keywordtest.Util;
import pomtest.*;

import static keywordtest.Repository.*;
import static org.junit.jupiter.api.Assertions.*;
import static keywordtest.Keyword.*;

public class PomScript {

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

        BasePage basePage = new BasePage();

        basePage.navigateToSimpleFormDemo(driver);
        assertEquals("https://www.seleniumeasy.com/test/basic-first-form-demo.html", currentUrl(driver));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/singleinput.csv", numLinesToSkip = 1)
    public void singleInputField(String input) {

        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

        simpleFormDemoPage.sendSingleInput(driver, input);
        assertTrue(simpleFormDemoPage.validateSingleInput(driver, input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/twofieldsoutput.csv", numLinesToSkip = 1)
    public void twoFieldsOutput(String inputA, String inputB, String result) {

        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();

        simpleFormDemoPage.sendTwoInputs(driver, inputA, inputB, result);
        assertTrue(simpleFormDemoPage.validateTwoInputFieldsResult(driver, result));
    }

    @Test
    public void checkBoxButton () {

        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage();

        assertTrue(checkBoxDemoPage.simpleCheckBoxValidation(driver));
    }

    @Test
    public void multiCheckboxButton () {

        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage();

        assertTrue(checkBoxDemoPage.multiCheckBoxButtonCheck(driver));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/checkbox.csv", delimiter = '\n')
    public void checkbox(String lineOfData) {

        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage();

        assertTrue(checkBoxDemoPage.multiCheckBoxVariations(driver, lineOfData));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/daySelector.csv")
    public void selectDropdown (String day) {

        SelectDropdownPage selectDropdownPage = new SelectDropdownPage();

        assertTrue(selectDropdownPage.dropdownValidation(driver, day));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/radiobuttons.csv", numLinesToSkip = 1)
    public void radioButtons(String sex, String age) {

        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage();

        assertTrue(radioButtonsDemoPage.checkRadioVariation(driver, sex, age));
    }
}
