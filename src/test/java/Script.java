import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sracok.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static sracok.Keyword.*;
import static sracok.Repository.*;

public class Script {

    private static ChromeDriver driver;

    @BeforeAll
    static void driver() {
        driver = getDriver();
    }

    @AfterEach
    void closePage() {
        getDriver().close();
    }

    @Test
    public void openSeleniumPage () {

        openPage("https://www.seleniumeasy.com/test/", driver);
        assertEquals("https://www.seleniumeasy.com/test/", currentUrl(driver));
    }

    @Test
    public void clickSimpleDemoFromMenu() {

        openPage("https://www.seleniumeasy.com/test/", driver);

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
}
