package actions.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    WebDriver driver;

    public WebDriver openMultiBrowser(String browser) {
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", Constants.PATH_SYSTEM + "\\src\\main\\resources\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", Constants.PATH_SYSTEM + "\\src\\main\\resources\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", Constants.PATH_SYSTEM + "\\src\\main\\resources\\driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.get(Constants.URL_TEST);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }

    public void closeBrowser() {
        driver.close();
    }

    public void verifyTitlePage(String titleExpect) {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals(titleExpect));
    }



    public Integer format_string_to_int(String str_num) {
        String str_num_temp = String.format("%.0f", Double.parseDouble(str_num));
        Integer num_int = Integer.parseInt(str_num_temp);
        return num_int;
    }

}
