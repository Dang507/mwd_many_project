package SSO_admin_portal.test_case;

import SSO_admin_portal.action.IAddUserAction;
import SSO_admin_portal.action.INavigateAction;
import SSO_admin_portal.action.implement_action.AddUserImpA;
import SSO_admin_portal.action.implement_action.NavigateImpA;
import SSO_admin_portal.page_object.GeneralPO;
import SSO_admin_portal.page_object.UserManagementPO;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import base_test.BaseTest;
import common.*;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;

public class AddUserTc extends BaseTest {
    /**
     * Test case 01: Verify the error message display when add new user with an email already in use
     * <p>
     * 1. Open the pop up 'Add new user'
     * + Launch the web browser
     * + Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management
     * + Select the tab 'User Management'
     * + Select the button 'Add'
     * 2. Enter valid values of a registered account to all field
     * + Enter values to all the fields 'Required'
     * + Enter values to all the fields 'Optional'
     * + Select the button 'Save'
     * 3. Verify the error message shows on below the field 'Email'
     * + Scroll up to the field 'Email*'
     * + Verify the error message just appears below the field 'Email*'
     */
    @Test(priority = 1, enabled = false,
            testName = "Test case 01: Verify the error message display when adding new user with an email already in use",
            description = "Description: Verify the error message appears below the field 'Email' when email is already in use")
    public void TC01_Verify_the_error_message_display_when_add_new_user_with_an_email_already_in_use() {
        System.out.println("Test case 01: Verify the error message display when adding new user with an email already in use");
        INavigateAction navigateA = new NavigateImpA();
        IAddUserAction addUserA = new AddUserImpA();
        GeneralPO generalPO = new GeneralPO(Constant.webDriver);
        UserManagementPO userManagementPO = new UserManagementPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        DataTestSSO dataTestSSO = new DataTestSSO();
        UserAccount userAccount = dataTestSSO.inactivated_SSO_account;
        ISSOUtilA utilA = new SSOUtilImpA();
        try {
            LogReport.logMainStep("1. Open the pop up 'Add new user'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management");
            LogReport.logSubStep("Select the tab 'User Management'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateA.goToPopUpAddUser(Constant.webDriver, generalPO);

            LogReport.logMainStep("2. Enter valid values of a registered account to all field");
            LogReport.logSubStep("Enter a valid value to the field 'First name*', eg: " + userAccount.getFirstName());
            LogReport.logSubStep("Enter a valid value to the field 'Last name*', eg: " + userAccount.getLastName());
            LogReport.logSubStep("Enter a valid value to the field 'Email*', eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter a valid value to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter a valid value to the field 'Confirm password*', eg: " + userAccount.getConfirmPw());
            LogReport.logSubStep("Enter a valid value to the field 'Title', eg: " + userAccount.getTitle());
            LogReport.logSubStep("Enter a valid value to the field 'Company', eg: " + userAccount.getCompany());
            LogReport.logSubStep("Select an option of the field 'Country', eg: " + userAccount.getCountry());
            LogReport.logSubStep("Select an option of the field 'State', eg: " + userAccount.getState());
            LogReport.logSubStep("Enter a valid value to the field 'Work Phone*', eg: " + userAccount.getPhone());
            LogReport.logSubStep("Select the button 'Save'");
            addUserA.enterValuesToAddNewUser(userManagementPO, userAccount);
            userManagementPO.btnSave.click();

            LogReport.logMainStep("3. Verify the error message shows on below the field 'Email*'");
            LogReport.logSubStep("Scroll up to the field 'Email*'");
            LogReport.logSubStep("Verify the error message just appears below the field 'Email*'");
            utilA.scrollViewToElement(Constant.webDriver, userManagementPO.inputEmail);
            generalA.verifyTextDisplay(dataTestSSO.error_msg_existed_email, userManagementPO.labelErrorEmail, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02: Verify the error message displays proper that is belong to email values
     * <p>
     * 1. Open the pop up 'Add new user'
     *  + Launch the web browser
     *  + Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management
     *  + Select the tab 'User Management'
     *  + Select the button 'Add'
     * 2. Verify the error message of the field 'email' displays proper
     *  + Enter an email value to the field 'Email'
     *  + Click to any point on the form, except buttons 'Save', 'Cancel'
     *  + Verify the error message of the field 'email' displays proper
     *  + If email is an valid values, the error message should hide
     *  + If email has white space letters at first and the end, they should be trimmed after leaving this field
     * 3. Repeat step 2 with these email values:
     *  + testlogigear#logigear.com
     *  + testlogigear@
     *  + @testlogigear.com
     *  + test@test@logigear.com
     *  + logigear.com
     *  + logigear@.com
     *  + activated.account@gyumail
     *  + activated gondola@gmail.com
     *  + activated.gondola@g mail.com
     *  + emailNoExisting#InDatabase@gmail.com
     */
    @Test(priority = 2, enabled = false,
            testName = "Test case 02: Verify the error message displays proper that is belong to email values",
            description = "Description: Verify the error message appears appropriate to each of email values",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckFieldEmail")
    public void TC02_Verify_the_error_message_display_appropriate_or_hide_that_is_belong_to_the_email_value
    (String email, String errorMsgExpected) {
        System.out.println("Test case 02: Verify the error message displays proper that is belong to email values");
        INavigateAction navigateA = new NavigateImpA();
        GeneralPO generalPO = new GeneralPO(Constant.webDriver);
        UserManagementPO userPO = new UserManagementPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        ISSOUtilA utilA = new SSOUtilImpA();
        try {
            LogReport.logMainStep("1. Open the pop up 'Add new user'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management");
            LogReport.logSubStep("Select the tab 'User Management'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateA.goToPopUpAddUser(Constant.webDriver, generalPO);

            LogReport.logMainStep("2. Verify the error message of the field 'email' displays proper");
            LogReport.logSubStep("Enter an email value to the field 'Email', eg: " + email);
            LogReport.logSubStep("Click to any point on the form, except buttons 'Save', 'Cancel'");
            LogReport.logSubStep("Verify the error message of the field 'email' displays");
            userPO.inputEmail.sendKeys(email);
            userPO.h1TitlePopupAdd.click();
            if (!errorMsgExpected.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, userPO.labelErrorEmail, false);
            } else if (email.startsWith(" ")){
                utilA.highlightAllTextOfInPutField(Constant.webDriver, userPO.inputEmail);
                generalA.verifyTextDisplay(email.trim(), userPO.inputEmail, true);
            }else {
                generalA.verifyElementHidden(userPO.labelErrorEmailBy, Constant.webDriver, "The error message");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 03 : Verify the error message shows on proper with each of password values on the field 'Password'
     * <p>
     * 1. Open the pop up 'Add new user'
     *  + Launch the web browser
     *  + Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management
     *  + Select the tab 'User Management'
     *  + Select the button 'Add'
     * 2. Verify the error message displays when entering a text value to the field 'Password*'
     *  + Enter a text to the field 'Password', eg: 24682468
     *  + Select the button 'Show password'
     *  + Click any points on the form, except the button 'Cancel', 'Save'
     *  + Verify the error message shows on below the field 'Password*'
     * 3. Repeated step 2 with these password values:
     *  + 24682468
     *  + StringPassword
     *  + 12#$/|().<>,
     *  + #Fex123     ;Test-
     *  + #Fex123
     *  + over 100 letters, eg: pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345p
     *  + pass-02468
     *  + #Fex123%Test
     *  + #F123%Test$@/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~
     */
    @Test(priority = 3, enabled = false,
            testName = "Test case 03 : Verify the error message shows on proper with each of password values on the field 'Password'",
            description = "Description: Verify the error message display or hide corresponding with an invalid/ valid password",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckFieldPassword")
    public void TC03_Verify_the_error_message_shows_on_appropriate_after_entering_an_invalid_password_to_the_field_Password
    (String password, String errorMsgExpected) {
        System.out.println("Test case 03 : Verify the error message shows on proper with each of password values on the field 'Password'");
        INavigateAction navigateA = new NavigateImpA();
        GeneralPO generalPO = new GeneralPO(Constant.webDriver);
        UserManagementPO userPO = new UserManagementPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        ISSOUtilA utilA = new SSOUtilImpA();

        try {
            LogReport.logMainStep("1. Open the pop up 'Add new user'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management");
            LogReport.logSubStep("Select the tab 'User Management'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateA.goToPopUpAddUser(Constant.webDriver, generalPO);

            LogReport.logMainStep("2. Verify the error message displays when entering a text value to the field 'Password*'");
            LogReport.logSubStep("Enter the invalid password value, eg: " + password);
            LogReport.logSubStep("Select the button 'Show password'");
            LogReport.logSubStep("Click any points on the form, except the button 'Cancel', 'Save'");
            LogReport.logSubStep("Verify the error message shows on below the field 'Password*'");
            userPO.inputPw.sendKeys(password);
            userPO.btnShowPw.click();
            userPO.h1TitlePopupAdd.click();
            utilA.scrollViewToElement(Constant.webDriver, userPO.inputPw);
            if (!errorMsgExpected.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, userPO.labelErrorPw, false);
            } else {
                generalA.verifyElementHidden(userPO.svgIconWarningPwBy, Constant.webDriver, "The icon 'Warning' for the field 'Password'");
                generalA.verifyElementHidden(userPO.labelErrorPwBy, Constant.webDriver, "The error message for the field 'Password'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }


    /**
     * Test case 04 : Verify the error message shows on proper when entering the value to the field 'Confirm password'
     * <p>
     * 1. Open the pop up 'Add new user'
     *  + Launch the web browser
     *  + Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management
     *  + Select the tab 'User Management'
     *  + Select the button 'Add'
     * 2. Enter an value to the field 'Password'
     * + Enter a value to the field 'Password'
     * + Press the button 'Show password'
     * 3. Enter an value to the field 'Confirm Password'
     * + Enter a value to the field 'Confirm Password'
     * + Press the button 'Show confirm password'
     * + Click any points on the form, except the button 'Save', 'Cancel'
     * 4. Verify the error message of the field 'Confirm password' display proper
     * 5. Repeat step 3 and 4 with each of these cases:
     *  + 'Password' is #F123%Test$@/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~ , 'Confirm password' is empty value
     *  + 'Password' and 'Confirm password' are empty values
     *  + 'Password' is empty value, 'Confirm password' is #F123%Test$@/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~
     *  + 'Password' is pass-2468, 'Confirm password' is #F123%Test$@/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~
     *  + 'Password' is #Fex123, 'Confirm password' is #Fex123
     *  + 'Password' and 'Confirm password' are StringPassword
     *  + 'Password' and 'Confirm password' are pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345p
     *  + 'Password' and 'Confirm password' are 24682468
     */
    @Test(priority = 4,
            testName = "Test case 04 : Verify the error message shows on proper when entering the value to the field 'Confirm password'",
            description = "Description: Verify the error message displays corresponding each values of the field 'Confirm password'",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataForFieldConfirmPw")
    public void TC04_Verify_the_error_message_shows_on_proper_when_entering_the_value_to_the_field_Confirm_password
    (String password, String confirmPw, String errorMsgExpected) {
        System.out.println("Test case 04 : Verify the error message shows on proper when entering the value to the field 'Confirm password'");
        INavigateAction navigateA = new NavigateImpA();
        GeneralPO generalPO = new GeneralPO(Constant.webDriver);
        UserManagementPO userPO = new UserManagementPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();

        try {
            LogReport.logMainStep("1. Open the pop up 'Add new user'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://sso-stage1.logigear.com/reactjs/admin/user-management");
            LogReport.logSubStep("Select the tab 'User Management'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateA.goToPopUpAddUser(Constant.webDriver, generalPO);

            LogReport.logMainStep("2. Enter an value to the field 'Password'");
            LogReport.logSubStep("Enter a value to the field 'Password', eg: " + password);
            LogReport.logSubStep("Press the button 'Show password'");
            userPO.inputPw.sendKeys(password);
            userPO.btnShowPw.click();

            LogReport.logMainStep("3. Enter an value to the field 'Confirm Password'");
            LogReport.logSubStep("Enter a value to the field 'Confirm Password'");
            LogReport.logSubStep("Press the button 'Show confirm password'");
            LogReport.logSubStep("Click any points on the form, except the button 'Save', 'Cancel'");
            userPO.inputConfirmpw.sendKeys(confirmPw);
            userPO.btnShowConfirmPw.click();
            userPO.h1TitlePopupAdd.click();

            LogReport.logMainStep("4. Verify the error message of the field 'Confirm password' display proper");
            if (!errorMsgExpected.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, userPO.labelErrorConfirmPw, false);
            } else {
                generalA.verifyElementHidden(userPO.svgIconWarningConrifmPwBy, Constant.webDriver,
                        "The icon warning of the field 'Confirm password'");
                generalA.verifyElementHidden(userPO.labelErrorConfirmPwBy, Constant.webDriver,
                        "The error message of the field 'Confirm password'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }




}
