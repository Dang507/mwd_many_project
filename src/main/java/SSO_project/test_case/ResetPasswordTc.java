package SSO_project.test_case;

import SSO_project.action.INavigateAction;
import SSO_project.action.IResetPasswordAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.action.implement_action.ResetPasswordAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.page_object.ResetPasswordPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;

public class ResetPasswordTc extends BaseTest {

    /**
     * Test case 01 : Verify error messages show on proper when entering values on the page 'Reset password'
     * <p>
     * 1. Navigate to the page 'Reset password'
     *  + Open the page reset password by clicking the link from email
     * 2. Enter values to all fields
     *  + Enter values to the field 'New password'
     *  + Enter values to the field 'Confirm password'
     *  + Click any points on the form
     * 3. Verify the error message display proper below both fields 'New password', 'Confirm password'
     * 4. Repeat the step 3, 4 with these values:
     *  + only letters
     *  + empty text
     *  + value only numbers
     *  + text only special letters
     *  + text length is less than 8 letters
     *  + white space letters between other letters
     *  + the text is over 100 letters
     *  + Text of fields 'Password' and 'Confirm password' difference
     *  + The values for both fields 'Password', 'Confirm password' are the same invalid
     *  + complicated valid values for both fields 'Password', 'Confirm password', eg: #F123%Test$/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~
     *

     */
    @Test(priority = 1,
            testName = "Test case 01 : Verify error messages show on proper when entering values on the page 'Reset password'",
            description = "Description: Verify the error messages show on proper below all fields after entering values",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckResetPassword")
    public void TC01_Verify_error_messages_show_on_proper_when_entering_values_on_the_page_Reset_password
    (String newPw, String confirmPw, String errorMsgExpected) {
        System.out.println("Test case 01 : Verify error messages show on proper when entering values on the page 'Reset password'");
        INavigateAction navigateA = new NavigateAction();
        IGeneralAction generalA = new GeneralAction();
        DataTestSSO dataTestSSO = new DataTestSSO();
        IResetPasswordAction resetPwA = new ResetPasswordAction();
        ResetPasswordPO resetPwPO = new ResetPasswordPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Navigate to the page 'Reset password'");
            LogReport.logSubStep("Open the page reset password by clicking the link from email");
            navigateA.goToResetPasswordPage();

            LogReport.logMainStep("2. Enter values to all fields");
            LogReport.logSubStep("Enter values to the field 'New password'");
            LogReport.logSubStep("Enter values to the field 'Confirm password'");
            LogReport.logSubStep("Click any points on the form");
            resetPwA.checkValueToResetPassword(resetPwPO, newPw, confirmPw);

            LogReport.logMainStep("3. Verify the error message display proper below both fields 'New password', 'Confirm password'");
            if(newPw.equals("")){
                generalA.verifyTextDisplay(errorMsgExpected, resetPwPO.labelErrorMsgPw, false);
                generalA.verifyElementDisplayed(resetPwPO.svgIconWarningPw
                        , "The icon 'Warning' of the field 'Password'");
                generalA.verifyTextDisplay(errorMsgExpected, resetPwPO.labelErrorMsgConfirmPw, false);
                generalA.verifyElementDisplayed(resetPwPO.svgIconWarningConfirmPw
                        , "The icon 'Warning' of the field 'Confirm Password'");
            }else if(newPw.length() > 100){
                generalA.verifyTextDisplay(newPw.substring(0,99), resetPwPO.inputPw, true);
                generalA.verifyTextDisplay(errorMsgExpected, resetPwPO.labelErrorMsgConfirmPw, false);
                generalA.verifyElementDisplayed(resetPwPO.svgIconWarningConfirmPw
                        , "The icon 'Warning' of the field 'Confirm Password'");
            }else if(!newPw.equals(confirmPw)){
                generalA.verifyTextDisplay(errorMsgExpected, resetPwPO.labelErrorMsgConfirmPw, false);
                generalA.verifyElementDisplayed(resetPwPO.svgIconWarningConfirmPw
                        , "The icon 'Warning' of the field 'Confirm Password'");
            }else if(newPw.equals(dataTestSSO.pw_valid_strong)){
                generalA.verifyElementHidden(resetPwPO.labelErrorMsgPwBy, Constant.webDriver
                        , "The label error of the field 'Password'");
                generalA.verifyElementHidden(resetPwPO.svgIconWarningPwBy, Constant.webDriver
                        , "The icon 'Warning' of the field 'Password'");
                generalA.verifyElementHidden(resetPwPO.labelErrorMsgConfirmPwBy, Constant.webDriver
                        , "The label error of the field 'Confirm Password'");
                generalA.verifyElementHidden(resetPwPO.svgIconWarningConfirmPwBy, Constant.webDriver
                        , "The icon 'Warning' of the field 'Confirm Password'");
            }
            else {
                generalA.verifyTextDisplay(errorMsgExpected, resetPwPO.labelErrorMsgPw, false);
                generalA.verifyElementDisplayed(resetPwPO.svgIconWarningPw, "The icon 'Warning' of the field 'Password'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    // xong case negative, làm tiếp case reset password successful

}
