package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ExtentTest subStep;
    public static ExtentTest generalTestResult;

    /**
     * 1. Level: High
     * 2. Purpose: This method creates the file extent report html
     * 3. Description method:
     * + extentHtmlReporter: It is create file html
     * + extentReports: It is write info to the reported file
     */
    public static void createExtentReport() {
        String filePath = System.getProperty("user.dir") + "\\test_report\\"
                + TimeUtil.getSystemTimeHMS("yyyy_MM_dd-HH_mm_ss") + "_MWD.html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //configuration items to change the look and feel
        extentHtmlReporter.config().setEncoding("UTF-8");
        extentHtmlReporter.config().setDocumentTitle("Mowede");
        extentHtmlReporter.config().setReportName("Mowede");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setProtocol(Protocol.HTTPS);
        extentHtmlReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss a");

        //To add system or environment info by using the setSystemInfo method.
        extentReports.setSystemInfo("OS", "Win 10 pro");
        extentReports.setSystemInfo("User", "QA");
        extentReports.setSystemInfo("Browse", "Chrome");
    }
}
