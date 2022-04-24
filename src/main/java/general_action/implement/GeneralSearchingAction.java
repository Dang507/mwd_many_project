package general_action.implement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import common.*;
import general_action.IGeneralSearchingAction;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeneralSearchingAction implements IGeneralSearchingAction {
    @Override
    public void verifyListResultsContainText(String textQuery, List<WebElement> listElement, boolean isCheckAllElements) {
        ISSOUtilA ssoUtilA = new SSOUtilImpA();
        int count = 0;
        textQuery = textQuery.toLowerCase();
        for (WebElement webElement :
                listElement) {
            if (webElement.getText().toLowerCase().contains(textQuery)) {
                count++;
                if (!isCheckAllElements) {
                    ExtentReportManager.subStep.log(Status.PASS,
                            MarkupHelper.createLabel("The result contains the text query: " + textQuery,
                                    ExtentColor.GREEN));
                    LogReport.logImage64ToReport(true);
                    ssoUtilA.scrollViewToElement(Constant.webDriver, webElement);
                    break;
                }
            }
        }
        ssoUtilA.scrollViewToElement(Constant.webDriver, listElement.get(listElement.size() / 2));
        if (count > 0 && isCheckAllElements) {
            ExtentReportManager.subStep.log(Status.PASS, MarkupHelper.createLabel(
                    "There are " + count + " results that contains the text query",
                    ExtentColor.GREEN));
            LogReport.logImage64ToReport(true);
        } else if (count <= 0) {
            ExtentReportManager.subStep.log(Status.FAIL,
                    MarkupHelper.createLabel("Results do not contain the text query",
                            ExtentColor.ORANGE));
            LogReport.logImage64ToReport(false);
        }
    }
}
