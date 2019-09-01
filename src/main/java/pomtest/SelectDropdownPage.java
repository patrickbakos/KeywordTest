package pomtest;

import keywordtest.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static keywordtest.Keyword.*;

public class SelectDropdownPage {

    private Select daySelect (WebDriver driver) {
        return new Select(Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("select-demo"))));
    }

    private WebElement daySelectorOption (WebDriver driver, String name) {
        return Util.wait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[.='" + name + "']")));
    }

    public boolean dropdownValidation (WebDriver driver, String day) {

        openPage("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html", driver);

        selectFromSelectTag(daySelect(driver), day);
        return isSelected(daySelectorOption(driver, day));
    }

}
