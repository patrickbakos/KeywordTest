import org.junit.jupiter.api.*;
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

    @Test
    public void singleInputField() {

        openPage("https://www.seleniumeasy.com/test/basic-first-form-demo.html", driver);

        writeText(SingleInputFieldInputField(driver), "Lobab");
        clickButton(SubmitSingleInputMessage(driver));

        assertEquals("Lobab", innnerText(SingleInputMessageConfirmation(driver)));
    }
}
