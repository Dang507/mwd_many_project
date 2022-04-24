package common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogReport{

    /**
     * 1. Level: Low.
     * 2. Purpose: Capture the screen when error happens
     * 3. Scope: Put it inside method logErrorAndCaptureBase64
     */
    // Capture screen when error/ failed
    public static String captureScreenBase64() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Constant.webDriver;
        String image64 = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        return image64;
    }

    /**
     * 1. Level: High.
     * 2. Purpose: Capture the screen when error happens, then log error text and image to sub step in report
     * 3. Scope: Put it in the catch block of 'try - catch' block
     * @param extentTest: The ExtentTest object is used to log step to the report
     * @param stepName: The text step is executing
     * @param urlPage: The url web page is displaying when capturing screen
     * @param exception: The exception is catch, it is has error info
     */
    public static void logErrorAndCaptureBase64(ExtentTest extentTest, String stepName, String urlPage
            , Exception exception){
        try {
            extentTest.log(Status.INFO, stepName);
            extentTest.log(Status.INFO, "The Page url: " + urlPage);
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exception.printStackTrace(printWriter);
            String stackTraceString = stringWriter.toString();
            extentTest.log(Status.ERROR, MarkupHelper.createLabel(stackTraceString, ExtentColor.ORANGE));
            String image64 = captureScreenBase64();
            extentTest.error("The issue happens, please click the 'base64-img' button to see fully picture",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(image64).build());
        }catch (IOException ioException){
            logStatusError(ioException.getMessage());
            ioException.printStackTrace();
        }
    }

    /**
     * 1. Level: Low.
     * 2. Purpose: Log testing result to sub step when an exception happens.
     * 3. Scope: Use it when log the text description cause of error to sub step.
     * @param errorTextDetail: The printStackTrace text of exception
     */
    public static void logStatusError(String errorTextDetail){
        ExtentReportManager.extentTest.log(Status.ERROR, MarkupHelper.createLabel(errorTextDetail, ExtentColor.ORANGE));
    }

    /**
     * 1. Level: Low
     * 2. Purpose: Use it to create the image captured screen when testing result is failed or error
     * 3. Scope: Use it when test case is failed or exception happening
     */
    public static void logImage64ToReport(boolean isPassed){
        try {
            String image64 = captureScreenBase64();
            if(isPassed){
                ExtentReportManager.subStep.pass("Please tapping the 'base64-img' button to see full picture ",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(image64).build());
            }else {
                ExtentReportManager.subStep.fail("Please tapping the 'base64-img' button to see full picture ",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(image64).build());
            }
        }catch (IOException ioException){
            logStatusError(ioException.getMessage());
        }
    }

    /**
     * 1. Level: Low
     * 2. Purpose: Using this method when need to log a MAIN step in extent report
     * @param mainStepText: The text value of MAIN step
     */
    public static void logMainStep(String mainStepText){
        ExtentReportManager.subStep = ExtentReportManager.extentTest.createNode(mainStepText);
        SSOUtilImpA.stepName = mainStepText;
    }

    /**
     * 1. Level: Low
     * 2. Purpose: Using this method when need to log a SUB step in extent report
     * @param subStep: The text value of SUB step
     */
    public static void logSubStep(String subStep){
        ExtentReportManager.subStep.log(Status.INFO, subStep);
    }
}


//    /**
//     * 1. Level: Low
//     * 2. Purpose: Log testing result as a sub step after checking the expected and actual texts same value
//     * 3. Scope: Use it when only log verifying result to sub step. It is useful
//     * @param expectedMsg: The expected text
//     * @param actualMsg: The expected text displays on the web page
//     */
//    public static void logResultOfVerifyText(String expectedMsg, String actualMsg){
//        if (expectedMsg.equals(actualMsg)){
//            System.out.println("Test passed");
//            ExtentReportManager.subStep.log(Status.PASS, MarkupHelper.createLabel("Expected result: "+ expectedMsg + "<br>" +
//                    "Actual result: " + actualMsg, ExtentColor.GREEN));
//        }else {
//            System.out.println("Test failed");
//            ExtentReportManager.subStep.log(Status.FAIL, MarkupHelper.createLabel("Expected result: "+ expectedMsg + "<br>" +
//                    "Actual result: " + actualMsg, ExtentColor.ORANGE));
//            logImage64ForFailCase(ExtentReportManager.subStep);
//        }
//    }

//    /**
//     * 1. Level: Low
//     * 2. Purpose: Verify the element is actually exist and display or not, and log result
//     * 3. Scope: Use it when only log verifying result to sub step. It is useful
//     * @param webElement: The element locator is check
//     * @param elementName: The name of element is logged to extent report
//     */
//    public static void logVerifyElementDisplayed(WebElement webElement, String elementName){
//        if(webElement.isDisplayed()){
//            ExtentReportManager.subStep.log(Status.PASS, MarkupHelper.createLabel(elementName + " display",
//                    ExtentColor.GREEN));
//        }else {
//            ExtentReportManager.subStep.log(Status.FAIL, MarkupHelper.createLabel(elementName + " does not display",
//                    ExtentColor.ORANGE));
//            logImage64ForFailCase(ExtentReportManager.subStep);
//        }
//    }