package SSO_project.test_case;

import SSO_project.action.IActiveAccountAction;
import SSO_project.action.ILoginAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.implement_action.ActiveAccountAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.ActiveAccountPO;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;

public class ActiveCodeTc extends BaseTest {

    /**
     * Test case 01: Verify UI items on the page 'Activated account'
     *
     * 1. Login with an inactivated account
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     *  + Enter the email of the inactivated account
     *  + Enter the password of the inactivated account
     *  + Select the button 'Login'
     * 2. Go to the page 'Active code'
     *  + Select the button 'Active your account' on the notification bar
     * 3. Verify the UI items
     *  + These element show on normally, include: The input field 'Security code', the button 'Activate your account'
     *      , the link 'here', the logo image 'Trust'
     *  + These element hide, include: The error text and the icon 'Warning' of the input field 'Security code'
     *      , the error text for the invalid active code
     * 4. Verify the UI item shows on after entering invalid active code
     *  + Enter an invalid active code
     *  + Select the button 'Activate your account'
     *  + Verify these element display, include: The error text and the icon 'Warning' of the input field 'Security code'
     *      , or the error text for the invalid active code
     */
    @Test(priority = 1, enabled = false,
            testName = "Test case 01: Verify UI items on the page 'Activated account'",
            description = "Verify the UI items shows on proper on the page 'Activated account'",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckUIActivePage")
    public void TC01_Verify_UI_items_on_the_page_Activated_account(UserAccount userAccount, String invalidCode
            , String errorMsgOfField, String errorMsgForInvalidCode) {
        System.out.println("Test case 01: Verify UI items on the page 'Activated account'");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        IGeneralAction generalA = new GeneralAction();
        ActiveAccountPO activeAccountPO = new ActiveAccountPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        IActiveAccountAction activeAccountA = new ActiveAccountAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login'");
            LogReport.logSubStep("Enter the email of the inactivated account, eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter the password of the inactivated account, eg: " + userAccount.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Active code'");
            LogReport.logSubStep("Select the button 'Active your account' on the notification bar");
            testArchitectPO.btnActiveAccount.click();

            LogReport.logMainStep("3. Verify the UI items");
            LogReport.logSubStep("These element show on normally, include: The input field 'Security code', " +
                    "the button 'Activate your account', the link 'here', the logo image 'Trust'");
            LogReport.logSubStep("These element hide, include: The error text and the icon 'Warning' of the input " +
                    "field 'Security code', the error text for the invalid active code");
            activeAccountA.checkUIActiveAccountPage(Constant.webDriver, activeAccountPO);

            LogReport.logMainStep("4. Verify the UI item shows on after entering an invalid active code");
            LogReport.logSubStep("Enter an invalid active code");
            LogReport.logSubStep("Select the button 'Activate your account' or press the key 'Enter'");
            LogReport.logSubStep("Verify these element display, include: The error text and the icon 'Warning' of the " +
                    "input field 'Security code', and the error text for the invalid active code");
            activeAccountA.submitActiveCode(activeAccountPO, invalidCode);
            if (invalidCode.equals("")){
                generalA.verifyTextDisplay(errorMsgOfField, activeAccountPO.labelErrorActiveCode, false);
                generalA.verifyElementDisplayed(activeAccountPO.svgIconWarningActiveCode, "The icon 'Warning'");
            }else {
                generalA.verifyTextDisplay(errorMsgForInvalidCode, activeAccountPO.divErrorInvalidCode, false);
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02: Verify the error message appears clearly after submitting an invalid active code
     *
     * 1. Login with an inactivated account
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     *  + Enter the email of the inactivated account
     *  + Enter the password of the inactivated account
     *  + Select the button 'Login'
     * 2. Go to the page 'Active code'
     *  + Select the button 'Active your account' on the notification bar
     * 3. Verify the error message display
     *  + Enter an invalid code to the input field 'Security code'
     *  + Verify the error message appears proper with each of invalid active code
     */
    @Test(priority = 2,
            testName = "Test case 02: Verify the error message appears clearly after submitting an invalid active code",
            description = "Verify error messages display proper corresponding each of invalid active code",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckInvalidCode")
    public void TC02_Verify_the_error_message_appears_clearly_after_submitting_an_invalid_active_code(UserAccount userAccount, String invalidCode
            , String errorMsgOfField, String errorMsgForInvalidCode) {
        System.out.println("Test case 02: Verify the error message appears clearly after submitting an invalid active code");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        IGeneralAction generalA = new GeneralAction();
        ActiveAccountPO activeAccountPO = new ActiveAccountPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        IActiveAccountAction activeAccountA = new ActiveAccountAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. 1. Login with an inactivated account");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login'");
            LogReport.logSubStep("Enter the email of the inactivated account, eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter the password of the inactivated account, eg: " + userAccount.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Active code'");
            LogReport.logSubStep("Select the button 'Active your account' on the notification bar");
            testArchitectPO.btnActiveAccount.click();

            LogReport.logMainStep("3. Verify the error message display");
            LogReport.logSubStep("Enter an invalid code to the input field 'Security code', eg: " + invalidCode);
            LogReport.logSubStep("Verify the error message appears proper with each of invalid active codes");
            activeAccountA.submitActiveCode(activeAccountPO, invalidCode);
            if (!invalidCode.equals("")){
                generalA.verifyTextDisplay(errorMsgForInvalidCode, activeAccountPO.divErrorInvalidCode, false);
            }else {
                generalA.verifyTextDisplay(errorMsgOfField, activeAccountPO.labelErrorActiveCode, false);
                generalA.verifyElementDisplayed(activeAccountPO.svgIconWarningActiveCode, "The icon 'Warning'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

}
