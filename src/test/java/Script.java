import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.chrome.ChromeDriver;
import sracok.Repository;
import sracok.Util;

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
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void singleInputField(String input) {

        openPage("https://www.seleniumeasy.com/test/basic-first-form-demo.html", driver);

        writeText(SingleInputFieldInputField(driver), input);
        clickButton(SubmitSingleInputMessage(driver));

        assertEquals(input, innnerText(SingleInputMessageConfirmation(driver, input)));
    }
}
