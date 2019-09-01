package pomtest;

import keywordtest.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static keywordtest.Keyword.clickElement;
import static keywordtest.Keyword.isDisplayed;

public class BasePage {

    private WebElement AllExamplesMenu (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='All Examples']")));
    }

    private WebElement InputFormsMenu (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Input Forms']")));
    }

    private WebElement SimpleFormDemoMenu (WebDriver driver) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='treemenu']//a[.='Simple Form Demo']")));
    }

    public void navigateToSimpleFormDemo (WebDriver driver) {

        if (isDisplayed(SimpleFormDemoMenu(driver))){
            clickElement(SimpleFormDemoMenu(driver));
        } else if (isDisplayed(InputFormsMenu(driver))) {
            clickElement(InputFormsMenu(driver));
            clickElement(SimpleFormDemoMenu(driver));
        } else {
            clickElement(AllExamplesMenu(driver));
            clickElement(InputFormsMenu(driver));
            clickElement(SimpleFormDemoMenu(driver));
        }
    }

}
