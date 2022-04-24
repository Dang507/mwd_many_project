package base_test;

import com.aventstack.extentreports.Status;
import common.Constant;
import common.ExtentReportManager;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    private static String browserName;

    @BeforeSuite
    public void setBeforeSuite() {
        System.out.println("setBeforeSuite");
    }

    @BeforeTest
    @Parameters({"myBrowser"})
    public void setBeforeTest(Method method, String myBrowser) {
        System.out.println("setBeforeTest");
        BaseTest.browserName = myBrowser;
        try {
            switch (myBrowser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    break;
                default:
                    throw new Exception("Browser name is not suitable, please re-check file testNG.xml");
            }
            // Create file html to save report
            ExtentReportManager.createExtentReport();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    @BeforeClass
    public void setBeforeClass() {
        System.out.println("setBeforeClass");
    }

    @BeforeMethod
    public void setBeforeMethod(Method method) {
        switch (BaseTest.browserName) {
            case "chrome":
                Constant.webDriver = new ChromeDriver();
                break;
            case "firefox":
                Constant.webDriver = new FirefoxDriver();
                break;
            case "edge":
                Constant.webDriver = new EdgeDriver();
                break;
        }
        IGeneralAction generalA = new GeneralAction();
        generalA.setupWebdriverTimeOut(Constant.webDriver);
        Constant.webDriver.manage().window().maximize();

        System.out.println("setBeforeMethod");
        System.out.println("method name: " + method.getName());
        String testNameFromTestAnnotation = method.getAnnotation(Test.class).testName();
        ExtentReportManager.generalTestResult = ExtentReportManager.extentReports.createTest(testNameFromTestAnnotation);
        String testDescription = method.getAnnotation(Test.class).description();
        ExtentReportManager.extentTest = ExtentReportManager.generalTestResult.createNode(testDescription);
        ExtentReportManager.extentTest.assignCategory("Regression");
        ExtentReportManager.extentTest.log(Status.INFO, "Run on " + Platform.getCurrent());
    }

    @AfterMethod
    public void setAfterMethod(ITestResult result, ITestContext testContext) {
        System.out.println("setAfterMethod");
        ExtentReportManager.extentTest.log(Status.INFO, "Closed browser and released device");
        if (result.getStatus() == ITestResult.SKIP) {
            ExtentReportManager.extentTest.log(Status.SKIP, "Test skipped " + result.getThrowable());
        }
        ExtentReportManager.extentReports.flush();
        Constant.webDriver.close();
    }

    @AfterClass
    public void setAfterClass() {
        System.out.println("setAfterClass");
//        ExtentReportManager.extentReports.flush();
    }

    @AfterTest
    public void setAfterTest() {
        System.out.println("setAfterTest");
        ExtentReportManager.extentReports.removeTest(ExtentReportManager.extentTest);
    }

    @AfterSuite
    public void setAfterSuite() {
        System.out.println("setAfterSuite");
        if (!BaseTest.browserName.equals("firefox")) {
            Constant.webDriver.quit();
        }
//        Constant.webDriver.manage().deleteAllCookies();
    }

}
