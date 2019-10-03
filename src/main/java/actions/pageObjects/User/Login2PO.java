package actions.pageObjects.User;

import actions.commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import interfaces.User.Login2UI;

public class Login2PO extends AbstractPage {

    WebDriver driver;
    private LoginPO loginPO;

    public Login2PO(WebDriver driver_) {
        this.driver = driver_;
    }

    public void inputToPassWordTextbox(String strSearch) {
        sendKeyToElement(driver, Login2UI.TXT_PASSWORD, strSearch);
    }

    public void clickToSubmitButton() {
        clickToElement(driver, Login2UI.BTN_LOGIN);
    }

    public WebDriver login(String username, String password){
        loginPO = new LoginPO(driver);
        loginPO.inputToUserNameTextbox(username);
        loginPO.clickToNextButton();
        inputToPassWordTextbox(password);
        clickToSubmitButton();
        return driver;
    }

}
