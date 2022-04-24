package SSO_project;

import SSO_project.action.IChangePwAction;
import SSO_project.action.ILoginAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.implement_action.ChangePasswordAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.ChangePwPO;
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

public class temp extends BaseTest {

    @Test(priority = 1,
    testName = "Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'",
    description = "Description: Verify the error messages appear when changing password with invalid values")
    public void TC01_Verify_error_messages_show_on_proper_when_entering_invalid_values_to_the_field_Password() {
        System.out.println("Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        ChangePwPO changePwPO = new ChangePwPO(Constant.webDriver);
        IChangePwAction changePwA = new ChangePasswordAction();
        IGeneralAction generalA = new GeneralAction();
        DataTestSSO dataTestSSO = new DataTestSSO();
        UserAccount userAccount = dataTestSSO.inactivated_SSO_account;
        String newPw = dataTestSSO.pw_is_over_100_letters;
        String confirmPw = dataTestSSO.pw_is_over_100_letters;

        try {
            LogReport.logMainStep("1. Login with an inactivated account");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Enter the email of the activated/ inactivated account, eg: ");
            LogReport.logSubStep("Enter the password, eg: ");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Hover the tab 'account name' on the nav bar");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.gotoChangePwPageAfterLogin(Constant.webDriver, testArchitectPO);

            LogReport.logMainStep("3. Enter values to all fields on the page 'Change Password'");
            LogReport.logSubStep("Enter values to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter values to the field 'New Password*', eg: " + newPw);
            LogReport.logSubStep("Enter values to the field 'Confirm Password* ', eg: " + confirmPw);
            changePwA.checkErrorMsgOfChangePwPage(changePwPO, userAccount, newPw, confirmPw);

            LogReport.logMainStep("4. Verify error messages and icon 'Warning' display proper when entering values to change password");

            generalA.verifyElementHidden(changePwPO.labelErrorNewPwBy, Constant.webDriver
                    , "The error message for the field 'New password'");
            generalA.verifyElementHidden(changePwPO.svgIconWarningNewPwBy, Constant.webDriver,
                    "The icon 'Warning' for the field 'New password'");
            generalA.verifyElementHidden(changePwPO.labelErrorConfirmPwBy, Constant.webDriver
                    , "The error message for the field 'Confirm password'");
            generalA.verifyElementHidden(changePwPO.svgIconWarningConfirmPwBy, Constant.webDriver,
                    "The icon 'Warning' for the field 'Confirm password'");

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

}
