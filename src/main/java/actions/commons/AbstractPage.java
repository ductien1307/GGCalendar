package actions.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {


    protected void openAnyUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getTitlePage(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected void back(WebDriver driver) {
        driver.navigate().back();
    }

    protected void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void forward(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void clickToElement(WebDriver driver, String locator) {
        waitForElementClickable(driver, locator);
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String value) {
        waitForElementVisiable(driver, locator);
        WebElement element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(value);
    }

    protected void selectItemInDropdown(WebDriver driver, String locator, String value) {
        Select select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByVisibleText(value);
    }

    protected String getFirstItemSelected(WebDriver driver, String locator) {
        Select select = new Select(driver.findElement(By.xpath(locator)));
        return select.getFirstSelectedOption().getText();
    }

    protected String getAttributeValue(WebDriver driver, String locator, String attribute) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getAttribute(attribute);
    }

    protected String getTextInElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    protected int getSizeElement(WebDriver driver, String locator) {
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        return elements.size();
    }

    protected void checkTheCheckbox(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void unCheckTheCheckbox(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        if (element.isSelected()) {
            element.click();
        }
    }

    protected boolean isControlDisplayed(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    protected boolean isControlEnabled(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isEnabled();
    }

    protected boolean isControlSelected(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    protected void waitForElementVisiable(WebDriver driver, String locator) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    protected void waitForElementClickable(WebDriver driver, String locator) {
        By by = By.xpath(locator);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean verifyElementPresent(WebDriver driver, String locator) {
        waitForElementVisiable(driver, locator);
        Boolean flag = false;
        if (driver.findElements(By.xpath(locator)).size() != 0) {
            flag = true;
        }
        return flag;
    }

}
