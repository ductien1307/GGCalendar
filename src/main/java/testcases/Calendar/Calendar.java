package testcases.Calendar;

import actions.commons.Constants;
import actions.pageObjects.Calendar.CalendarPO;
import actions.pageObjects.User.Login2PO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actions.commons.AbstractTest;

public class Calendar extends AbstractTest {

    private WebDriver driver;
    private Login2PO login2PO;
    private CalendarPO calendarPO;

    @BeforeTest()
    public void beforeTest() {
        driver = openMultiBrowser("chrome");
    }

    @AfterTest()
    public void afterTest() {
        closeBrowser();
    }

    @Test(priority = 1)
    public void verifyUserCanLoginSuccessfull() {
        login2PO = new Login2PO(driver);
        driver = login2PO.login(Constants.USER_NAME, Constants.USER_PASS);
    }

    @Test(dataProvider = "AddNewProvider", priority = 2)
    public void verifyUserCanCreateAppointmentSuccessfull(String title, String locator){
        calendarPO = new CalendarPO(driver);
        calendarPO.clickToCreateButton();
        calendarPO.inputToTitleTextbox(title);
        calendarPO.clickToSaveButton();
        calendarPO.verifyCreateEventSuccessfull(locator);
    }

    @DataProvider(name = "AddNewProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]{
             {"hi ZAMO, my name is Tien","//span[contains(text(),'hi ZAMO, my name is Tien')]"}
        };
    }

}
