package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ISSOUtilA {
    void scrollViewToElement(WebDriver webDriver, WebElement webElement);
    void selectOptionByText(WebElement webElement, String textValue);
    WebElement selectOptionByValue(WebElement webElement, String textValue);
    void setThreadSleep(long timeMilliSecond) throws InterruptedException;
    void hoverMenuAndClickItem(WebDriver webDriver, WebElement menuElement, WebElement itemToClick);
    void waitElementInteraction(WebDriver webDriver, WebElement webElement, int timeOut);
    void highlightAllTextOfInPutField(WebDriver webDriver, WebElement webElement);
    int createRandomIntegerNumber(int limit);
}
