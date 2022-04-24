package base_test;

import com.aventstack.extentreports.Status;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import java.net.InetAddress;

public class InitialSetup extends BaseTest{
    @Test(testName = "Initial Setup", description = "Setup info")
    public void Initial_Setup(){
        System.out.println("Initial Setup");
        try {
            String reportFolder = "Report folder: \\test_report\\";
            ExtentReportManager.extentTest.log(Status.INFO, reportFolder);
            ExtentReportManager.extentTest.log(Status.INFO, "Testing Type: Regression");
            ExtentReportManager.extentTest.log(Status.INFO, "Environment: QA");
            String systemName = InetAddress.getLocalHost().getHostName();
            ExtentReportManager.extentTest.log(Status.INFO, "Device name: " + systemName);
            ExtentReportManager.extentTest.log(Status.INFO, "Browser name: Chrome");
            ExtentReportManager.extentTest.log(Status.INFO, "OS name: " + Platform.getCurrent());
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }
}
