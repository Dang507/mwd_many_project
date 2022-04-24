package general_action.implement;

import common.*;
import general_action.IGeneralAction;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GeneralAction implements IGeneralAction {
    /**
     * 1. Purpose: Verify a text message content on the page as the designed, and the result is logged to a particular step on
     * report.
     */
    @Override
    public void verifyTextDisplay(String expectedText, WebElement webElement, boolean isInputField) {
        if (isInputField) {
            verifyTextEqual(expectedText, webElement.getAttribute("value"));
        } else {
            verifyTextEqual(expectedText, webElement.getText());
        }
    }

    @Override
    public void verifyTextEqual(String expectedText, String actualText){
        if (expectedText.equals(actualText) || actualText.matches(expectedText)) {
            System.out.println("Test passed");
            ExtentReportManager.subStep.log(Status.PASS, MarkupHelper.createLabel("Expected result: " + expectedText + "<br>" +
                    "Actual result: " + actualText, ExtentColor.GREEN));
            LogReport.logImage64ToReport(true);
        } else {
            System.out.println("Test failed");
            ExtentReportManager.subStep.log(Status.FAIL, MarkupHelper.createLabel("Expected result: " + expectedText + "<br>" +
                    "Actual result: " + actualText, ExtentColor.ORANGE));
            LogReport.logImage64ToReport(false);
        }
    }

    @Override
    public void verifyAttributeText(String expectedText, WebElement webElement, String attribute) {
        verifyTextEqual(expectedText, webElement.getAttribute(attribute));
    }

    @Override
    public void verifyElementEnable(WebElement webElement, String elementName) {
        if (webElement.isEnabled()) {
            ExtentReportManager.subStep.log(Status.PASS, MarkupHelper.createLabel(elementName + " enable",
                    ExtentColor.GREEN));
            LogReport.logImage64ToReport(true);
        } else {
            ExtentReportManager.subStep.log(Status.FAIL, MarkupHelper.createLabel(elementName + " does not enable",
                    ExtentColor.ORANGE));
            LogReport.logImage64ToReport(false);
        }
    }

    @Override
    public void verifyElementDisplayed(WebElement webElement, String elementName) {
        if (webElement.isDisplayed()) {
            ExtentReportManager.subStep.log(Status.PASS, MarkupHelper.createLabel(elementName + " displays",
                    ExtentColor.GREEN));
            LogReport.logImage64ToReport(true);
        } else {
            ExtentReportManager.subStep.log(Status.FAIL, MarkupHelper.createLabel(elementName + " hide",
                    ExtentColor.ORANGE));
            LogReport.logImage64ToReport(false);
        }
    }

    @Override
    public void verifyElementHidden(By by, WebDriver webDriver, String elementName) {
        if (webDriver.findElements(by).isEmpty()){
            ExtentReportManager.subStep.log(Status.PASS, MarkupHelper.createLabel(elementName + " hide",
                    ExtentColor.GREEN));
            LogReport.logImage64ToReport(true);
        }else {
            ExtentReportManager.subStep.log(Status.FAIL, MarkupHelper.createLabel(elementName + " still displays",
                    ExtentColor.ORANGE));
            LogReport.logImage64ToReport(true);
        }
    }

    @Override
    public void openNewTabAndCloseCurrentTab(WebDriver webDriver) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.open()");
        ArrayList<String> available_tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(available_tabs.get(0)).close();
        webDriver.switchTo().window(available_tabs.get(1));
    }

    @Override
    public void setupWebdriverTimeOut(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Override
    public void waitElementInteraction(WebDriver webDriver, WebElement webElement, int timeOut){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeOut);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Override
    public void enterValueOneField(WebElement inputElement, String value, WebElement subElement) {
        if (!(subElement ==null)) {
            Actions actions = new Actions(Constant.webDriver);
            inputElement.clear();
            inputElement.sendKeys(value);
           actions.moveToElement(subElement).click().perform();
           subElement.click();

        }
        inputElement.clear();
        inputElement.sendKeys(value);

    }

    @Override
    public void enterValueAFieldByTyping(WebElement inputElement, String value, WebElement subElement) {
        inputElement.clear();
        String Oneletter;
        StringBuilder tempText = new StringBuilder();
        for (int i = 0; i < value.length(); i++){
            Oneletter = value.charAt(i) + "";
            inputElement.sendKeys(Oneletter);
        }
        subElement.click();
    }


}
