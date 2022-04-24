package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SSOUtilImpA implements ISSOUtilA {
    public static String stepName = "";

    // Scroll page down until get xpath element
    public void scrollViewToElement(WebDriver webDriver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    // Select by visible text
    public void selectOptionByText(WebElement webElement, String textValue) {
        Select select = new Select(webElement);
        select.selectByVisibleText(textValue);
    }

    // Select option element by method, return WebElement expectedElement
    public WebElement selectOptionByValue(WebElement webElement, String textValue){
        Select select = new Select(webElement);
        List<WebElement> webElementList = select.getOptions();
        WebElement expectedElement = null;
        for (WebElement element: webElementList){
            if (textValue.equals(element.getText())){
                expectedElement = element;
                break;
            }
        }
        return expectedElement;
    }

    /**
     * 1. Level: Low level
     * 2. Purpose: Checking an element actually exist on web page
     * @param elementXpath: The element locator
     * @return : true if yes, false if no
     */
    public static boolean checkElementExist(By elementXpath) {
        return Constant.webDriver.findElements(elementXpath).size() > 0;
    }

    /**
     * 1. Level: Low level
     * 2. Purpose: Using this method to wait the web app load data to element complete
     * @param timeMilliSecond: The period time to stop all thread
     */
    public void setThreadSleep(long timeMilliSecond) throws InterruptedException {
            Thread.sleep(timeMilliSecond);

    }

    public void hoverMenuAndClickItem(WebDriver webDriver, WebElement menuElement, WebElement itemToClick){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(menuElement).click().build().perform();
        itemToClick.click();
    }

    public void waitElementInteraction(WebDriver webDriver, WebElement webElement, int timeOut){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOut);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Override
    public void highlightAllTextOfInPutField(WebDriver webDriver, WebElement webElement) {
        webElement.click();
        Actions actions = new Actions(webDriver);
        // go to the beginning of input
        actions.sendKeys(Keys.HOME).build().perform();
        actions.keyDown(Keys.LEFT_SHIFT);
        actions.sendKeys(Keys.END).build().perform();
        actions.keyUp(Keys.LEFT_SHIFT);
    }

    @Override
    public int createRandomIntegerNumber(int limit) {
        return (int) (Math.random()*limit);
    }

}
