package projects.TA_web.test_case.user_portal;

import SSO_project.action.ILoginAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.entity.UserAccount;

import SSO_project.page_object.LoginPO;
import base_test.BaseTest;
import common.*;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IChangePasswordAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.ChangePasswordAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.user_portal.ChangePasswordPO;
import projects.TA_web.page_object.user_portal.UserPortalPO;

public class ChangePasswordTc extends BaseTest {

    /**
     * Test case 01: Verify the UI items on the page 'Change password'
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Verify UI items on the form 'Change password'
     *  + The form title and all label fields: Password, New password, Confirm password
     *  + All buttons: Submit, Cancel
     */
    @Test(priority = 1, enabled = false,
            testName = "Test case 01: Verify the UI items on the page 'Change password'",
            description = "Verify all UI item's text show on the page")
    public void TC01_Verify_the_UI_items_on_the_page_Change_password(){
        INavigateAction navigateA = new NavigateAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        ILoginAction loginA = new LoginAction();
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        IGeneralAction generalA = new GeneralAction();
        ChangePasswordPO changePwPO = new ChangePasswordPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.inactivated_SSO_account_portal_staging;

        try {
            System.out.println("Test case 01: Verify the UI items on the page 'Change password'");

            LogReport.logMainStep("1. Navigate to URL: stage1.testarchitect.com");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with a valid account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Manage my account'");
            LogReport.logSubStep("Select the menu 'Account'");
            LogReport.logSubStep("Select the option 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("4. Verify UI items on the form 'Change password'");
            LogReport.logSubStep("<b>Verify the form title and all label fields: Password, New password, Confirm password<b>");
            changePwA.verifyTextLabelsDisplay(generalA, changePwPO, dataTestTAWeb);
            LogReport.logSubStep("<b>Verify all buttons: Submit, Cancel<b>");
            changePwA.verifyButtonName(generalA, changePwPO, dataTestTAWeb);
            LogReport.logSubStep("<b>Verify the placeholder texts from all input fields<b>");
            changePwA.verifyPlaceHolderTextDisplay(generalA, changePwPO, dataTestTAWeb);
            LogReport.logSubStep("<b>Verify all error messages and icons 'Warning' are hidden<b>");
            changePwA.verifyAllErrorMessageHidden(generalA, Constant.webDriver, changePwPO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02 : Verify error messages display when submitting without entering values
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Enter nothing to all fields on the page 'Change Password'
     *  + Enter nothing to all fields
     *  + Select the button 'Submit'
     * 5. Verify error messages and icons 'Warning' display on 3 fields 'Password', 'New password', 'Confirm password'
     */
    @Test(priority = 2, enabled = false,
            testName = "Test case 02 : Verify error messages display when submitting without entering values",
            description = "Description: Verify the error messages and icon 'Warning' appear when update password without values",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckChangePwPageForAllEmptyField")
    public void TC02_Verify_error_messages_display_when_without_entering_values(UserAccount user) {
        System.out.println("Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalA = new GeneralAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);

        try {
            LogReport.logMainStep("1. Navigate to URL: " + URL.stage1TAURL);
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with a valid account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Manage my account'");
            LogReport.logSubStep("Select the menu 'Account'");
            LogReport.logSubStep("Select the option 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter nothing to all fields on the page 'Change Password'");
            LogReport.logSubStep("Enter nothing to all fields");
            LogReport.logSubStep("Select the button 'Submit'");
            changePasswordPO.btnSubmit.click();

            LogReport.logMainStep("4. Verify error messages and icons 'Warning' display on 3 fields 'Password', 'New password', 'Confirm password'");
            changePwA.verifyAllErrorMessageForEmptyFields(generalA, changePasswordPO, dataTestTAWeb);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 03 : Verify error messages for the field 'New password' display without submitting
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Enter invalid values to the field 'New password'
     *  + Enter current password to the field 'Password'
     *  + Enter invalid values to the field 'New password'
     *  + Enter value to the field 'Confirm password' same to the field 'New password'
     *  + Click to any points on the page, eg: title page
     * 5. Verify the error message display proper for the field 'New password'
     * 6. Repeat the step 3, 4 with these values:
     *  + only number for 'Password' and 'confirm password'
     *      Expected:
     *          - Only the error message and icon 'Warning' of the field 'New password' shows on
     *          - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + only letter values for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + short strings for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + only special letters for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + having white space letters between other letters for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     */
    @Test(priority = 3,
            testName = "Test case 03 : Verify error messages for the field 'New password' display without submitting",
            description = "Description: Verify the error messages and icon 'Warning' for field 'New password' display " +
                    "and in contrast with the field 'Confirm Password', and values to both fields 'New password' and 'Confirm password' are same",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldPassword")
    public void TC03_Verify_error_messages_for_the_field_New_password_display_without_submitting
    (UserAccount user, String newPw, String errorMsgExpected) {
        System.out.println("Test case 03 : Verify error messages for the field 'New password' display without submitting");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);

        try {
            LogReport.logMainStep("1. Navigate to URL: " + URL.stage1TAURL);
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with a valid account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Manage my account'");
            LogReport.logSubStep("Select the menu 'Account'");
            LogReport.logSubStep("Select the option 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("4. Enter invalid values to the field 'New password'");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Enter invalid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter value to the field 'Confirm password' same to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Click to any points on the page, eg: title page");
            changePwA.enterValueToCheckErrorMessage(changePasswordPO, user, newPw, newPw);

            LogReport.logMainStep("5. Verify the error message display proper for the field 'New password'");
            changePwA.verifyErrorMessageForPasswordDisplay(changePasswordPO, user.getPassword(), newPw, errorMsgExpected);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 04 : Verify the error messages appear after submitting with valid values
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Enter valid values to all fields, then verify the error message display properly
     *  + Enter valid values to the field 'Password'
     *  + Enter valid values to the field 'New password'
     *  + Enter valid value to the field 'Confirm password' same to the field 'New password'
     *  + Click the button 'Submit'
     * 5. Repeat the step 3 with these values:
     *  + Enter the current password to all fields
     *      - Expected:
     *      The error message appear inform the current and new password are same
     *      All error message for all field still hide
     *  + Enter the current password to the field 'New password','Confirm new password' and enter an other password to the field 'Password'
     *      - Expected:
     *      The error message appear inform the current password are wrong
     *      All error message for all field still hide
     */
    @Test(priority = 4, enabled = false,
            testName = "Test case 04 : Verify error messages appear after submitting with valid values",
            description = "Description: The corresponding error message appear when submitting with 3 fields are same or current password is wrong",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckErrorMsgWhenSubmittingValidValue")
    public void TC04_Verify_error_messages_appear_after_submitting_with_valid_values
    (UserAccount user, String newPw, String errorMsgExpected) {
        System.out.println("Test case 04 : Verify error messages appear after submitting with valid values");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);

        try {
            LogReport.logMainStep("1. Navigate to URL: " + URL.stage1TAURL);
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with a valid account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Manage my account'");
            LogReport.logSubStep("Select the menu 'Account'");
            LogReport.logSubStep("Select the option 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("4. Enter invalid values to the field 'New password', then verify error messages display properly");
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Enter invalid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter value to the field 'Confirm password' same to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Select the button 'Submit'");
            LogReport.logSubStep("Verify the error message for particular fields are hidden, and the error message display inform to user");
            changePwA.verifyErrorMessageAfterSubmitValidValues(changePasswordPO, user, newPw, errorMsgExpected);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 05 : Verify error messages do not display when entering valid values to all fields
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Enter valid values to the field 'New password'
     *  + Enter current password to the field 'Password'
     *  + Enter valid values to the field 'New password'
     *  + Enter valid to the field 'Confirm password' same to the field 'New password'
     *  + Click to any points on the page, eg: title page
     * 5. Verify the error message display proper for the field 'New password'
     * 6. Repeat the step 4, 5 with these values:
     *  + Enter valid values to to all fields,
     *      - Expected: No error messages and icons 'Warning' appear
     */
    @Test(priority = 5, enabled = false,
            testName = "Test case 05 : Verify error messages do not display when entering valid values to all fields",
            description = "Description: No error message and icon 'Warning' display when entering valid values to all fields",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckErrorMsgNoDisplayWhenEnteringValidValues")
    public void TC05_Verify_error_messages_do_not_display_when_entering_valid_values_to_all_fields
    (UserAccount user, String newPw) {
        System.out.println("Test case 05 : Verify error messages do not display when entering valid values to all fields");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();

        try {
            LogReport.logMainStep("1. Navigate to URL: " + URL.stage1TAURL);
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with a valid account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Manage my account'");
            LogReport.logSubStep("Select the menu 'Account'");
            LogReport.logSubStep("Select the option 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter valid values to the field 'New password'");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Enter valid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter value to the field 'Confirm password' same to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Click to any points on the page, eg: title page");
            changePwA.enterValueToCheckErrorMessage(changePasswordPO, user, newPw, newPw);

            LogReport.logMainStep("4. Verify error messages and icons 'Warning' do not display");
            changePwA.verifyAllErrorMessageHidden(generalA, Constant.webDriver, changePasswordPO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 06 : Verify error message for the field 'Confirm new password' display when values for both fields 'New password', 'Confirm new password' difference
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Enter valid values to all field
     *  + Enter current password to the field 'Password'
     *  + Enter valid values to the field 'New password'
     *  + Enter other valid value to the field 'Confirm password'
     *  + Click to any points on the page, eg: title page
     * 5. Verify the error message display for the field 'Confirm new password'
     * 6. Repeat the step 4, 5 with these values:
     *  + Enter valid values to to all fields,
     *      - Expected: No error messages and icons 'Warning' appear
     */
    @Test(priority = 6, enabled = false,
            testName = "Test case 06 : Verify error message for the field 'Confirm new password' display when values for both fields 'New password', 'Confirm new password' difference",
            description = "Description: No error message and icon 'Warning' display when entering valid values to all fields",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldConfirmPassword")
    public void TC06_Verify_error_messages_do_not_display_when_entering_valid_values_to_all_fields
    (UserAccount user, String newPw, String confirmPw, String errorMsgExpected) {
        System.out.println("Test case 05 : Verify error messages do not display when entering valid values to all fields");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();

        try {
            LogReport.logMainStep("1. Navigate to URL: " + URL.stage1TAURL);
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with a valid account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Manage my account'");
            LogReport.logSubStep("Select the menu 'Account'");
            LogReport.logSubStep("Select the option 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("4. Enter valid values to all field");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Enter valid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter other valid value to the field 'Confirm password', eg: " + confirmPw);
            LogReport.logSubStep("Click to any points on the page, eg: title page");
            changePwA.enterValueToCheckErrorMessage(changePasswordPO, user, newPw, confirmPw);

            LogReport.logMainStep("5. Verify error messages and icons 'Warning' display for field 'Confirm new password'");
            changePwA.verifyErrorMessageWhenNewPwAndConfirmPwDifferences(generalA, changePasswordPO, errorMsgExpected);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 07 : Verify successful message display when change password successful
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Enter valid values to all fields
     *  + Enter current password to the field 'Password'
     *  + Enter valid values to the field 'New password', 'Confirm new password' that they are as the same
     * 5. Verify the success message display after updating password successfully
     */
    @Test(priority = 7, enabled = false,
            testName = "Test case 07 : Verify successful message display when change password successful",
            description = "Description: The successful message display after changing password successful with valid values",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckErrorMsgNoDisplayWhenEnteringValidValues")
    public void TC07_Verify_successful_message_display_when_change_password_successful
    (UserAccount user, String newPw) {
        System.out.println("Test case 07 : Verify successful message display when change password successful");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();

        try {
            LogReport.logMainStep("1. Navigate to URL: " + URL.stage1TAURL);
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with a valid account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Manage my account'");
            LogReport.logSubStep("Select the menu 'Account'");
            LogReport.logSubStep("Select the option 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter values to all fields");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + user.getPassword());
            LogReport.logSubStep("Enter valid value to the field 'New password', eg: " + dataTestTAWeb.pw_valid_strong);
            LogReport.logSubStep("Enter the same value to the field 'Confirm password', eg: " + dataTestTAWeb.pw_valid_strong);
            LogReport.logSubStep("Select the button 'Submit'");
            changePwA.changePassword(changePasswordPO, user, newPw, newPw);

            LogReport.logMainStep("4. Verify the success message displaying");
            generalA.verifyTextDisplay(dataTestTAWeb.success_msg_change_pw, changePasswordPO.divAlertMessage, false);

            // update the new password to the previous password, no logs to report
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);
            String currentPw = user.getPassword();
            user.setPassword(newPw);
            changePwA.changePassword(changePasswordPO, user, currentPw, currentPw);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }




}


//
//    /**
//     * Test case 02 : Verify error messages show on proper when entering invalid values to the field 'Password'
//     *
//     * 1. Go to the page Login
//     *  + Open the web browser
//     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
//     *  + Press the key 'Enter' on the keyboard
//     *  + Select the button 'Login'
//     * 2. Login with valid account
//     *  + Enter the email
//     *  + Enter the password
//     *  + Select the button 'Login'
//     * 3. Go to the page 'Change password'
//     *  + Select the account menu
//     *  + Select the tab 'Manage my account'
//     *  + Select the menu 'Account'
//     *  + Select the option 'Change password'
//     * 4. Enter values to all fields on the page 'Change Password', then verify error messages and icon 'Warning' display proper
//     *  + Enter value to the field 'New Password'
//     *  + Enter value to the field 'Confirm Password'
//     *  + Click any points on the screen, except the button 'Submit'
//     *  + Verify error messages and icon 'Warning'
//     * 5. Repeat step 4 with these values:
//     *  + new empty password for 'Password' and 'confirm password'
//     *      Expected:  Error messages and icons 'Warning' of both 2 fields show on
//     *  + only number for 'Password' and 'confirm password'
//     *      Expected:
//     *          - Only the error message and icon 'Warning' of the field 'New password' shows on
//     *          - the error message and icon 'Warning' of the field 'Confirm password' hide
//     *  + only letter values for 'Password' and 'confirm password'
//     *      Expected:
//     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
//     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
//     *  + short strings for 'Password' and 'confirm password'
//     *      Expected:
//     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
//     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
//     *  + only special letters for 'Password' and 'confirm password'
//     *      Expected:
//     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
//     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
//     *  + having white space letters between other letters for 'Password' and 'confirm password'
//     *      Expected:
//     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
//     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
//     *  + valid value for 'Password' and 'confirm password', eg: #F123%Test$/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~
//     *      Expected:
//     *      - The error messages and icons 'Warning' of both 2 fields hide
//     *  + new password, confirm password are same as the current password
//     *      Expected:
//     *      - The error messages and icons 'Warning' of both 2 fields hide
//     *  + the text to 'Password' field is over 128 letters
//     *      Expected:
//     *      - The error messages and icons 'Warning' of both 2 fields hide
//     *  + Values of fields 'Password' and 'Confirm password' difference
//     *      Expected:
//     *          - the error message and icon 'Warning' of the field 'New password' hide
//     *          - the error message and icon 'Warning' of the field 'Confirm password' show on
//     *
//     */
//    @Test(priority = 2, enabled = false,
//            testName = "Test case 02 : Verify error messages show on proper when entering invalid values to the field 'Password'",
//            description = "Description: Verify the error messages appear when changing password with invalid values",
//            dataProviderClass = DataTestSSO.class,
//            dataProvider = "getDataToCheckChangePw")
//    public void TC1000_Verify_error_messages_show_on_proper_when_entering_invalid_values_to_the_field_Password
//    (UserAccount user, String newPw, String confirmPw, String errorMsgExpected) {
//        System.out.println("Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'");
//
//        INavigateAction navigateA = new NavigateAction();
//        ILoginAction loginA = new LoginAction();
//        LoginPO loginPO = new LoginPO(Constant.webDriver);
//        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
//        IChangePasswordAction changePwA = new ChangePasswordAction();
//
//        try {
//            LogReport.logMainStep("1. Navigate to URL: stage1.testarchitect.com");
//            LogReport.logSubStep("Open the web browser");
//            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
//            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
//            LogReport.logSubStep("Select the button 'Login'");
//            navigateA.goToLoginPage(Constant.webDriver);
//
//            LogReport.logMainStep("2. Login with a valid account");
//            LogReport.logSubStep("Enter user account to the field 'Email', eg: " + user.getEmail() );
//            LogReport.logSubStep("Enter password to the field 'Password', eg: " + user.getPassword());
//            LogReport.logSubStep("Select the button 'Login'");
//            loginA.loginSSO(loginPO, user);
//
//            LogReport.logMainStep("3. Go to the page 'Change password'");
//            LogReport.logSubStep("Select the account menu");
//            LogReport.logSubStep("Select the tab 'Manage my account'");
//            LogReport.logSubStep("Select the menu 'Account'");
//            LogReport.logSubStep("Select the option 'Change password'");
//            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);
//
//            LogReport.logMainStep("4. Enter values to all fields on the page 'Change Password', then verify error messages and icon 'Warning' display proper when entering values to change password");
//            LogReport.logSubStep("Enter values to the field 'Password*', eg: " + user.getPassword());
//            LogReport.logSubStep("Enter values to the field 'New Password*', eg: " + newPw);
//            LogReport.logSubStep("Enter values to the field 'Confirm Password* ', eg: " + confirmPw);
//
//
//            changePwA.verifyErrorMessageDisplayProper(user, newPw, confirmPw, errorMsgExpected);
//
//        } catch (Exception exception) {
//            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
//                    Constant.webDriver.getCurrentUrl(), exception);
//            exception.printStackTrace();
//        }
//    }