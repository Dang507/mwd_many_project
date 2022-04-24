package SSO_project.test_case;

import SSO_project.action.IForgotPwAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.implement_action.ForgotPasswordAction;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.page_object.ForgotPwPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import org.testng.annotations.Test;

public class ForgotPwTc extends BaseTest {

    /**
     * Test case 01: Verify GUI ForgetPassword page on TA site
     *
     * 1. Go to the page 'Login'
     *      + Navigate to https://stage1.testarchitect.com/
     *      + Select the button 'Login' at the navigation bar
     *      + Select the hyperlink 'Forget password?'
     * 2. Verify the 'Forget password' page GUI
     */
    @Test(priority = 1,
            testName = "Test case 01: Verify GUI the page 'Forget password' of the SSO web pages",
            description = "Verify the GUI the page 'Forget password' of the SSO web pages")
    public void TC01_Verify_GUI_the_page_Forget_Password_of_the_SSO_web_pages() {
        System.out.println("Test case 01: Verify GUI the page 'Forget password' of the SSO web pages");
        INavigateAction navigateA = new NavigateAction();
        IForgotPwAction forgotPwA = new ForgotPasswordAction();
        ForgotPwPO forgotPwPO = new ForgotPwPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        try {
            LogReport.logMainStep("Step 1: Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Click Login on header");
            LogReport.logSubStep("Select the hyper link 'Forgot password?'");
            navigateA.goToForgotPasswordPage(testArchitectPO, loginPO);

            LogReport.logMainStep("Step 2: Verify the 'Forget password' page GUI");
            forgotPwA.checkForgotPwPageGUI(forgotPwPO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02: Verifying the error messages display proper after entering the invalid emails
     *
     * 1. Go to the page 'Login'
     *      + Navigate to https://stage1.testarchitect.com/
     *      + Select the button 'Login' at the navigation bar
     *      + Select the hyperlink 'Forget password?'
     * 2. Input the invalid emails, then press the key 'Enter'
     * 3. Verifying the error message display proper below the field 'Email'
     */
    @Test(priority = 2,
            testName = "Test case 02: Verifying the error messages display proper after entering an email",
            description = "Description: Verifying the error messages display proper with each emails",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckFieldEmail")
    public void TC02_Verifying_the_error_messages_display_after_entering_the_invalid_emails
    (String email, String errorMessage) {
        System.out.println("Test case 02: Verifying the error messages display proper after entering the invalid emails");
        INavigateAction navigateA = new NavigateAction();
        IForgotPwAction forgotPwA = new ForgotPasswordAction();
        IGeneralAction generalA = new GeneralAction();
        ForgotPwPO forgotPwPO = new ForgotPwPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Click Login on header");
            LogReport.logSubStep("Select the hyper link 'Forgot password?'");
            navigateA.goToForgotPasswordPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Input the invalid emails, then press the key 'Enter', eg: " + email);
            if (email.equals("")){
                LogReport.logSubStep("Enter an empty text to the field 'Email'");
            }else {
                LogReport.logSubStep("Enter an invalid email to the field 'Email', eg: " + email);
            }
            forgotPwA.submitRequestGetPassword(forgotPwPO, email);

            LogReport.logMainStep("Step 3: Verifying the error message display below the field 'Email'");
            generalA.verifyTextDisplay(errorMessage, forgotPwPO.labelErrorEmail, false);
            if(email.startsWith(" ")){
                generalA.verifyTextDisplay(email.trim(), forgotPwPO.inputEmail, true);
                generalA.verifyElementHidden(forgotPwPO.svgIconWarningEmailBy, Constant.webDriver, "The icon 'Warning'");
            }else {
                generalA.verifyElementDisplayed(forgotPwPO.svgIconWarningEmail, "The icon 'Warning'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 03: Verify submitting new request in order to reset password successful
     *
     * 1. Go to the page 'Login'
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login' at the navigation bar
     *  + Select the hyperlink 'Forget password?'
     * 2. Submit request with a valid email successful
     *  + Enter an registered email to the field 'Email'
     *  + Select the button 'Submit'
     * 3. Verify the successful message display
     */
    @Test(priority = 3,
            testName = "Test case 03: Verify submitting new request in order to reset password successful",
            description = "Description: Verify the successful message display after submitting request successful")
    public void TC03_Verify_submitting_new_request_in_order_to_reset_password_successful() {
        System.out.println("Test case 03: Verify submitting new request in order to reset password successful");
        INavigateAction navigateA = new NavigateAction();
        DataTestSSO dataTest = new DataTestSSO();
        IForgotPwAction forgotPwA = new ForgotPasswordAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        ForgotPwPO forgotPwPO = new ForgotPwPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Click Login on header");
            LogReport.logSubStep("Select the hyper link 'Forgot password?'");
            navigateA.goToForgotPasswordPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Submit request with a valid email successful");
            LogReport.logSubStep("Enter an registered email to the field 'Email', eg: "
                    + dataTest.inactivated_SSO_account.getEmail());
            LogReport.logSubStep("Select the button 'Submit'");
            forgotPwA.submitRequestGetPassword(forgotPwPO, dataTest.inactivated_SSO_account.getEmail());

            LogReport.logMainStep("3. Verify the successful message display");
            generalA.verifyElementDisplayed(forgotPwPO.pSuccess, "The successful text");

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }
}
