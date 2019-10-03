package actions.pageObjects.User;

import actions.commons.AbstractPage;
import interfaces.User.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginPO extends AbstractPage {

    WebDriver driver;

    public LoginPO(WebDriver driver_) {
        this.driver = driver_;
    }

    public void inputToUserNameTextbox(String strSearch) {
        sendKeyToElement(driver, LoginUI.TXT_USERNAME, strSearch);
    }

    public void clickToNextButton() {
        clickToElement(driver, LoginUI.BTN_NEXT);
    }

}
