package actions.pageObjects.Calendar;

import actions.commons.AbstractPage;
import interfaces.Calendar.CalendarUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CalendarPO extends AbstractPage {
    WebDriver driver;

    public CalendarPO(WebDriver driver_) {
        this.driver = driver_;
    }

    public void clickToCreateButton() {
        clickToElement(driver, CalendarUI.BTN_CREATE);
    }

    public void clickToSaveButton() {
        clickToElement(driver, CalendarUI.BTN_SAVE);
    }

    public void inputToTitleTextbox(String strSearch) {
        sendKeyToElement(driver, CalendarUI.TXT_TITLE, strSearch);
    }

    public void verifyCreateEventSuccessfull(String locator) {
        Boolean flag;
        flag = verifyElementPresent(driver, locator);
        Assert.assertTrue(flag);
    }

}
