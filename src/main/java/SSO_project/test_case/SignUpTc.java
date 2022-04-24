package SSO_project.test_case;

import SSO_project.action.INavigateAction;
import SSO_project.action.ISignUpAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.action.implement_action.SignUpAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.SignUpPO;
import SSO_project.page_object.TestArchitectPO;
import SSO_project.page_object.ThankYouPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SignUpTc extends BaseTest {
    /**
     * Test case 01: Verify the error message display when signing up new account with an email already in use
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Enter valid values of a registered account to all field
     * + Enter values to all the fields 'Required'
     * + Select the button 'Next'
     * + Enter values to all the fields 'Optional'
     * + Select the button 'Create free account'
     * 3. Verify the error message shows on the field 'Email'
     */
    @Test(priority = 1, enabled = false,
            testName = "Test case 01: Verify the error message displays when signing up new account with an email already in use",
            description = "Description: Verify the error message appears below the field 'Email' when signing up new account with an email already in use")
    public void TC01_Verify_the_error_message_displays_when_signing_up_new_account_with_an_email_already_in_use() {
        System.out.println("Test case 01: Verify the error message displays when signing up new account with an email already in use");
        INavigateAction navigateA = new NavigateAction();
        ISignUpAction signUpA = new SignUpAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        DataTestSSO dataTest = new DataTestSSO();
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Enter values of an account already in use to all field");
            LogReport.logSubStep("Enter values to all the fields 'Required'");
            LogReport.logSubStep("Select the button 'Next'");
            LogReport.logSubStep("Enter values to all the fields 'Optional'");
            LogReport.logSubStep("Select the button 'Create free account'");
            signUpA.createSSOAccount(signUpPO, dataTest.activated_SSO_account);

            LogReport.logMainStep("3. Verify the error message shows on the field 'Email'");
            generalA.verifyTextDisplay(dataTest.error_msg_existed_email, signUpPO.labelErrorEmail, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02: Verify the error message displays appropriate or hides that is belong to the email value
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Enter an email value to the field 'Email'
     * + Enter the email value
     * + Click any points on the screen, except the button 'Next', eg: Click the title page
     * 3. Verify the error message of the field 'email' displays proper
     */
    @Test(priority = 2, enabled = false,
            testName = "Test case 02: Verify the error message displays or hides that is belong to the email values",
            description = "Description: Verify the error message display appropriate with the email values",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckFieldEmail")
    public void TC02_Verify_the_error_message_display_appropriate_or_hide_that_is_belong_to_the_email_value
    (String email, String errorMsgExpected) {
        System.out.println("Test case 02: Verify the error message display or hide that is belong to the email values");
        INavigateAction navigateA = new NavigateAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Enter an email value to the field 'Email'");
            LogReport.logSubStep("Enter the email value, eg: " + email);
            LogReport.logSubStep("Click any points on the screen, except the button 'Next', eg: Click the title page");
            signUpPO.inputEmail.sendKeys(email);
            signUpPO.h1Title.click();

            LogReport.logMainStep("3. Verify the error message shows on the field 'Email'");
            if (!errorMsgExpected.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, signUpPO.labelErrorEmail, false);
            } else {
                generalA.verifyElementHidden(signUpPO.labelErrorEmailBy, Constant.webDriver, "The error message");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 03 : Verify the error message shows on appropriate after entering an invalid/ valid password to the field 'Password'
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Enter a text to the field 'Password'
     * 3. Verify the error message displays appropriate
     */
    @Test(priority = 3, enabled = false,
            testName = "Test case 03 : Verify the error message shows on appropriate after entering an invalid/ valid password to the field 'Password'",
            description = "Description: Verify the error message display appropriate with an invalid password",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckFieldPassword")
    public void TC03_Verify_the_error_message_shows_on_appropriate_after_entering_an_invalid_password_to_the_field_Password
    (String invalidPw, String errorMsgExpected) {
        System.out.println("Test case 03 : Verify the error message appears after entering an invalid password to the field 'Password'");
        INavigateAction navigateA = new NavigateAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Enter an invalid password to the field 'Password'");
            LogReport.logSubStep("Enter the invalid password value, eg: " + invalidPw);
            LogReport.logSubStep("Press the key 'Enter'");
            LogReport.logSubStep("Press the button 'Show password'");
            signUpPO.inputPassword.sendKeys(invalidPw);
            signUpPO.inputPassword.sendKeys(Keys.ENTER);
            signUpPO.btnShowPw.click();

            LogReport.logMainStep("3. Verify the error message shows below the field 'Password'");
            if (!errorMsgExpected.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, signUpPO.labelErrorPw, false);
            } else {
                generalA.verifyElementHidden(signUpPO.labelErrorPwBy, Constant.webDriver, "The error message");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 04 : Verify the error message shows on appropriate when the value of the field 'Confirm password' and 'Password' are different
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Enter an value to the field 'Password'
     * + Enter a value to the field 'Password'
     * + Press the button 'Show password'
     * 3. Enter an value to the field 'Confirm Password'
     * + Enter a value to the field 'Confirm Password'
     * + Press the button 'Show confirm password'
     * + Press the key 'Enter'
     * 4. Verify the error message of the field 'Confirm password' display appropriate
     */
    @Test(priority = 4, enabled = false,
            testName = "Test case 04 : Verify the error message shows on appropriate when the value of the field 'Confirm password' and 'Password' are different",
            description = "Description: Verify the error message displays corresponding each values of the field 'Confirm password'",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataForFieldConfirmPw")
    public void TC04_Verify_the_error_message_shows_on_appropriate_when_the_value_of_the_field_Confirm_password_and_Password_are_different
    (String password, String confirmPw, String errorMsgExpected) {
        System.out.println("Test case 04 : Verify the error message shows on appropriate when the value of the field 'Confirm password' and 'Password' are different");
        INavigateAction navigateA = new NavigateAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Enter an value to the field 'Password'");
            LogReport.logSubStep("Enter a value to the field 'Password', eg: " + password);
            LogReport.logSubStep("Press the button 'Show password'");
            signUpPO.inputPassword.sendKeys(password);
            signUpPO.btnShowPw.click();

            LogReport.logMainStep("3. Enter an value to the field 'Confirm Password'");
            LogReport.logSubStep("Enter a value to the field 'Confirm Password', eg: " + confirmPw);
            LogReport.logSubStep("Press the button 'Show confirm password'");
            LogReport.logSubStep("Press the key 'Enter'");
            signUpPO.inputConfirmPW.sendKeys(confirmPw);
            signUpPO.btnShowConfirmPw.click();
            signUpPO.inputConfirmPW.sendKeys(Keys.ENTER);

            LogReport.logMainStep("3. Verify the error message shows below the field 'Password'");
            if (!errorMsgExpected.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, signUpPO.labelErrorConfirmedPw, false);
            } else {
                generalA.verifyElementHidden(signUpPO.labelErrorConfirmedPwBy, Constant.webDriver,
                        "The error message of the field 'Confirm password'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 05: Verify the error message display appropriate when entering any values to the field 'Phone'
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Fill valid values to all essential fields, except the field 'Phone'
     * + Enter valid values to all fields has the symbol asterisk
     * 3. Enter a value to the field 'Phone'
     * + Enter a value to the field 'Phone'
     * + Click to any point on the screen, except the button 'Create free account'
     * 4. Verify the error message display proper, include:
     * + it is empty values
     * + it has 10-15 letters, however that consists a/ some letters
     * -> Expected: The error message displays: Please enter a valid phone number
     * + it has 10-15 letters, however that consists a/ a few special letters,
     * -> Expected: The error message displays: Please enter a valid phone number
     * + less than 10 characters
     * -> Expected: The error message displays: Phone numbers must be from 10 to 15 characters.
     * + greater than 15 characters
     * -> Expected: The error message displays: Phone numbers must be from 10 to 15 characters.
     * + it has 10-15 numbers, however, it does not has the letter '+' at the beginning
     * -> Expected: The error message does not appear
     * + it has 10-15 numbers, and also has the letter '+' at the beginning
     * -> Expected: The error message does not appear
     */
    @Test(priority = 5, enabled = false,
            testName = "Test case 05: Verify the error message displays appropriate when entering any values to the field 'Phone'",
            description = "Description: Verify the error message displays corresponding each values of the field 'Phone'",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataForFieldPhone")
    public void TC05_Verify_the_error_message_displays_appropriate_when_entering_any_values_to_the_field__Phone
    (UserAccount userAccount, String phone, String errorMsgExpected) {
        System.out.println("Test case 05: Verify the error message displays appropriate when entering any values to the field 'Phone'");
        INavigateAction navigateA = new NavigateAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        ISignUpAction signUpA = new SignUpAction();
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Fill valid values to all essential fields, except the field 'Phone'");
            LogReport.logSubStep("Enter the value to the field 'First name*': " + userAccount.getFirstName());
            LogReport.logSubStep("Enter the value to the field 'Last name*': " + userAccount.getLastName());
            LogReport.logSubStep("Enter the value to the field 'Email*': " + userAccount.getEmail());
            LogReport.logSubStep("Enter the value to the field 'Password*': " + userAccount.getPassword());
            LogReport.logSubStep("Enter the value to the field 'Confirm Password*': " + userAccount.getConfirmPw());
            LogReport.logSubStep("Select the button 'Next'");
            signUpA.goToFinalForm(signUpPO, userAccount);

            LogReport.logMainStep("3. Enter a value to the field 'Phone'");
            LogReport.logSubStep("Enter a value to the field 'Phone', eg: " + phone);
            LogReport.logSubStep("Click to any point on the screen, except the button 'Create free account'");
            signUpPO.inputPhone.sendKeys(phone);
            signUpPO.inputTitle.click();

            LogReport.logMainStep("4. Verify the error message display appropriate");
            if (!errorMsgExpected.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, signUpPO.labelErrorPhone, false);
            } else {
                generalA.verifyElementHidden(signUpPO.labelErrorPhoneBy, Constant.webDriver,
                        "The error message of the field 'Phone'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 06: Verify GUI for the 'Sign up' page
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Verify UI items on the 'Create Free Account' form
     * + All input fields shows on fully, include: 'First name', 'Last name', 'Email', 'Password', 'Confirm password'
     * + All remaining fields, include: The button 'Next', the logo image 'Trust', the button 'Show password',
     * the button 'Show confirm password', the link 'Sign in here'
     * 3. Verify all error messages and icons 'Warning' on the 'Create Free Account' form
     * + Select the button 'Next'
     * + Verify all error messages and icons 'Warning' for all input fields: 'First name', 'Last name', 'Email'
     * 'Password', 'Confirm password'
     * 4. Go to the final form
     * + Enter all valid values to all fields on the form 'Create Free Account'
     * + Select the button 'Next'
     * 5. Verify UI items on the 'One last step' form
     * + All fields shows on fully, include: 'Title', 'Company', 'Country', 'State', 'Phone'
     * + All the remaining fields, include: The button 'Back'
     * 6. Verify the error message for the field 'Phone' shows on when entering an invalid value to the field 'Phone'
     * + Enter a invalid value to the field 'Phone'
     * + Verify the error message of the field 'Phone' displays clearly
     */
    @Test(priority = 6,
            testName = "Test case 06: Verify GUI for the 'Sign up' page",
            description = "Description: Verify the UI items of the page 'Sign up'",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckUISignUpPage")
    public void TC06_Verify_GUI_for_the_Sign_up_page(UserAccount userAccount, String invalidPhone) {
        System.out.println("Test case 06: Verify GUI for the 'Sign up' page");
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        ISignUpAction signUpA = new SignUpAction();
        IGeneralAction generalA = new GeneralAction();
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Verify UI items on the 'Create Free Account' form");
            LogReport.logSubStep("Verify all input fields shows on fully, include: 'First name', 'Last name', 'Email', 'Password', 'Confirm password'");
            LogReport.logSubStep("Verify all remaining fields display, include: The button 'Next', the logo image 'Trust', " +
                    "the button 'Show password', the button 'Show confirm password', the link 'Sign in here'");
            signUpA.checkAllFieldsDisplayOnFirstForm(generalA, signUpPO);
            signUpA.checkAllErrorMsgAndIconsHideOnFirstForm(Constant.webDriver, generalA, signUpPO);

            LogReport.logMainStep("3. Verify all error messages and icons 'Warning' on the 'Create Free Account' form");
            LogReport.logSubStep("Select the button 'Next'");
            LogReport.logSubStep("Verify all error messages and icons 'Warning' for all input fields display: 'First name', 'Last name', 'Email'");
            signUpPO.btnNext.click();
            signUpA.checkAllErrorMsgAndIconsDisplayOnFirstForm(generalA, signUpPO);

            LogReport.logMainStep("4. Go to the final form");
            LogReport.logSubStep("Enter all valid values to all fields on the form 'Create Free Account'");
            LogReport.logSubStep("Select the button 'Next'");
            signUpA.goToFinalForm(signUpPO, userAccount);

            LogReport.logMainStep("5. Verify UI items on the 'One last step' form");
            LogReport.logSubStep("Verify all fields shows on fully, include: 'Title', 'Company', 'Country', 'State', 'Phone'");
            LogReport.logSubStep("Verify all the remaining fields display, include: The button 'Back'");
            LogReport.logSubStep("Verify the error message of the field phone does not display");
            signUpA.checkAllFieldsDisplayOnFinalForm(generalA, signUpPO);
            signUpA.checkAllErrorMsgAndIconsHideOnFinalForm(Constant.webDriver, generalA, signUpPO);

            LogReport.logMainStep("6. Verify the error message for the field 'Phone' shows on when entering an invalid value");
            LogReport.logSubStep("Enter a invalid value to the field 'Phone'");
            LogReport.logSubStep("Verify the error message of the field 'Phone' displays clearly");
            signUpA.checkAllErrorMsgAndIconsDisplayOnFinalForm(generalA, signUpPO, invalidPhone);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 07: Verify the error message display appropriate when entering values to the field 'First name', 'Last name'
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Verify texts and error message display appropriate when enter some texts to the field 'First name*', 'Last name*'
     * + Enter long texts to these field, eg: "Our codeless automation tool allows you to rapidly scale and maintain tests saving you valuable time Test are easily viewed in spreadsheet like editor"
     * -> Verify texts display on these fields are 64 letters
     * + Enter texts consist white space letters at the beginning and ending places, eg: "  TEst    "
     * -> Verify texts displaying on these fields are trimmed
     * + Enter Unicode text to these fields
     * -> Verify texts displaying on these fields are unchanged
     * + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     * -> Expected result: The error message: 'Please remove special characters.' displays
     */
    @Test(priority = 7, enabled = false,
            testName = "Test case 07: Verify the error message display appropriate when entering values to the field 'First name', 'Last name'",
            description = "Description: Verify the UI error message display appropriate corresponding with each of text that is entered ",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataForFieldName")
    public void TC07_Verify_GUI_for_the_Sign_up_page(String textName, String textDisplay, String errorMsg) {
        System.out.println("Test case 07: Verify the error message display appropriate when entering values to the field 'First name', 'Last name'");
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Verify texts and error message display appropriate when enter some texts to the field 'First name*', 'Last name*'");
            LogReport.logSubStep("Enter long texts to these field, eg: " + textName);
            LogReport.logSubStep("Click any points on the screen");
            signUpPO.inputFirstName.sendKeys(textName);
            signUpPO.inputLastName.sendKeys(textName);
            signUpPO.inputEmail.click();
            if (errorMsg.equals("")) {
                generalA.verifyTextDisplay(textDisplay, signUpPO.inputFirstName, true);
                generalA.verifyTextDisplay(textDisplay, signUpPO.inputLastName, true);
            } else {
                generalA.verifyTextDisplay(errorMsg, signUpPO.labelErrorFirstName, false);
                generalA.verifyTextDisplay(errorMsg, signUpPO.labelErrorLastName, false);
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 08: Verify these texts display proper on fields 'Title', 'Company' when entering a few extensive texts
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Go to the final form
     * + Enter a valid value to the field 'First name*'
     * + Enter a valid value to the field 'Last name*'
     * + Enter a valid value to the field 'Email*'
     * + Enter a valid value to the field 'Password*'
     * + Enter a valid value to the field 'Confirm password*'
     * + Select the button 'Next'
     * 3. Enter a few extensive texts to the field 'Title', 'Company'
     * + Enter an extensive text to the field 'Title'
     * + Enter an extensive text to the field 'Company'
     * + Click any points on the screen, except the button 'Create free account'
     * 4. Verify texts on the field 'Title', 'Company' shows on proper
     * + The text on the field 'Title' displays only 50 letters
     * + The text on the field 'Company' displays only 100 letters
     */
    @Test(priority = 8, enabled = false,
            testName = "Test case 08: Verify all texts display proper on fields 'Title', 'Company' when entering a few extensive texts",
            description = "Description: Verify number of letters displays on field 'Title', 'Company' has limits",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataForFieldTitleCompany")
    public void TC08_Verify_all_texts_display_proper_on_fields_Title_Company_when_entering_a_few_extensive_texts
    (UserAccount userAccount, String extensiveText) {
        System.out.println("Test case 08: Verify all texts display proper on fields 'Title', 'Company' when entering a few extensive texts");
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        ISignUpAction signUpA = new SignUpAction();
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Go to the final form");
            LogReport.logSubStep("Enter a valid value to the field 'First name*', eg: " + userAccount.getFirstName());
            LogReport.logSubStep("Enter a valid value to the field 'Last name*', eg: " + userAccount.getLastName());
            LogReport.logSubStep("Enter a valid value to the field 'Email*', eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter a valid value to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter a valid value to the field 'Confirm password*', eg: " + userAccount.getConfirmPw());
            LogReport.logSubStep("Select the button 'Next'");
            signUpA.goToFinalForm(signUpPO, userAccount);

            LogReport.logMainStep("3. Enter a few extensive texts to the field 'Title', 'Company'");
            LogReport.logSubStep("Enter an extensive text over 50 letters to the field 'Title', eg: " + extensiveText);
            LogReport.logSubStep("Enter an extensive text over 100 letters to the field 'Company', eg: " + extensiveText);
            signUpPO.inputTitle.sendKeys(extensiveText);
            signUpPO.inputCompany.sendKeys(extensiveText);
            signUpPO.inputTitle.click();

            LogReport.logMainStep("4. Verify texts on the field 'Title', 'Company' shows on proper");
            LogReport.logSubStep("The text on the field 'Title' displays only 50 first letters");
            generalA.verifyTextDisplay(extensiveText.substring(0, 50), signUpPO.inputTitle, true);
            LogReport.logSubStep("The text on the field 'Company' displays only 50 first letters");
            generalA.verifyTextDisplay(extensiveText.substring(0, 50), signUpPO.inputCompany, true);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 09: Verify the page 'Thank you' shows on after signing up successful
     *
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Enter valid values to all required fields
     * + Enter a valid value to the field 'First name*'
     * + Enter a valid value to the field 'Last name*'
     * + Enter a valid value to the field 'Email*'
     * + Enter a valid value to the field 'Password*'
     * + Enter a valid value to the field 'Confirm password*'
     * + Select the button 'Next'
     * 3. At this time, handle two cases:
     * + Case 1: Enter valid values to all optional fields
     * - Enter a valid value to the field 'Title'
     * - Enter a valid value to the field 'Company'
     * - Enter a valid value to the field 'Country'
     * - Enter a valid value to the field 'State'
     * - Enter a valid value to the field 'Phone'
     * + Case 2: No enter values to all optional fields
     * + Select the button 'Back'
     * + Select the button 'Next'
     * + Select the button 'Create free account'
     * 4. Verify the page 'Thanks you' displays
     */
    @Test(priority = 9, enabled = false,
            testName = "Test case 09: Verify the page 'Thank you' shows on after signing up successful",
            description = "Description: Verify the page 'Thank you' shows on after signing up successful",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCreateNewAccountSuccessful")
    public void TC09_Verify_the_page_Thank_you_shows_on_after_signing_up_successful(UserAccount userAccount, String titlePage) {
        System.out.println("Test case 09: Verify the page 'Thank you' shows on after signing up successful");
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        ThankYouPO thankYouPO = new ThankYouPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        ISignUpAction signUpA = new SignUpAction();
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Create new account by entering valid values to all fields");
            LogReport.logSubStep("Enter a valid value to the field 'First name*', eg: " + userAccount.getFirstName());
            LogReport.logSubStep("Enter a valid value to the field 'Last name*', eg: " + userAccount.getLastName());
            LogReport.logSubStep("Enter a valid value to the field 'Email*', eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter a valid value to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter a valid value to the field 'Confirm password*', eg: " + userAccount.getConfirmPw());
            LogReport.logSubStep("Select the button 'Next'");
            signUpA.enterValuesToFirstForm(signUpPO, userAccount);
            signUpPO.btnNext.click();

            if (userAccount.getTitle().isEmpty()) {
                LogReport.logMainStep("3. No enter values to all optional fields");
            } else {
                LogReport.logMainStep("3. Enter valid values to all optional fields");
                LogReport.logSubStep("Enter a valid value to the field 'Title'");
                LogReport.logSubStep("Enter a valid value to the field 'Company'");
                LogReport.logSubStep("Enter a valid value to the field 'Country'");
                LogReport.logSubStep("Enter a valid value to the field 'State'");
                LogReport.logSubStep("Enter a valid value to the field 'Phone'");
                signUpA.enterValuesToFinalForm(signUpPO, userAccount);
            }
            LogReport.logSubStep("Select the button 'Back'");
            LogReport.logSubStep("Select the button 'Next'");
            LogReport.logSubStep("Select the button 'Create free account'");
            signUpPO.divBack.click();
            signUpPO.btnNext.click();
            signUpPO.btnCreateAccount.click();

            LogReport.logMainStep("4. Verify the page 'Thanks you' displays");
            generalA.verifyTextDisplay(titlePage, thankYouPO.divThankYou, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 10: Verify all values on the final form still display after backing the first form
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Enter valid values to all required fields
     * + Enter a valid value to the field 'First name*'
     * + Enter a valid value to the field 'Last name*'
     * + Enter a valid value to the field 'Email*'
     * + Enter a valid value to the field 'Password*'
     * + Enter a valid value to the field 'Confirm password*'
     * + Select the button 'Next'
     * 3. Enter valid values to all optional fields
     * + Enter a valid value to the field 'Title'
     * + Enter a valid value to the field 'Company'
     * + Enter a valid value to the field 'Country'
     * + Enter a valid value to the field 'State'
     * + Enter a valid value to the field 'Phone'
     * 4. Back to the first form
     * + Select the button 'Back'
     * 5. Go to the final form
     * + Select the button 'Next'
     * 6. Verify all values on the final form still display, include:
     * + The text on the field 'Title'
     * + The text on the field 'Company'
     * + The option on the field 'Country'
     * + The option on the field 'State'
     * + The text on the field 'Phone'
     */
    @Test(priority = 10, enabled = false,
            testName = "Test case 10: Verify all values on the final form still display after backing the first form",
            description = "Description: Verify all values on the final form still display after backing the first form " +
                    "then go to the final form",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckTextOnFinalForm")
    public void TC10_Verify_all_values_on_the_final_form_still_display_after_backing_the_first_form(UserAccount userAccount, String titlePage) {
        System.out.println("Test case 10: Verify all values on the final form still display after backing the first form");
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        ISignUpAction signUpA = new SignUpAction();
        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Create new account by entering valid values to all fields");
            LogReport.logSubStep("Enter a valid value to the field 'First name*', eg: " + userAccount.getFirstName());
            LogReport.logSubStep("Enter a valid value to the field 'Last name*', eg: " + userAccount.getLastName());
            LogReport.logSubStep("Enter a valid value to the field 'Email*', eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter a valid value to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter a valid value to the field 'Confirm password*', eg: " + userAccount.getConfirmPw());
            LogReport.logSubStep("Select the button 'Next'");
            signUpA.enterValuesToFirstForm(signUpPO, userAccount);
            signUpPO.btnNext.click();

            LogReport.logMainStep("3. Enter valid values to all optional fields");
            LogReport.logSubStep("Enter a valid value to the field 'Title', eg: " + userAccount.getTitle());
            LogReport.logSubStep("Enter a valid value to the field 'Company', eg: " + userAccount.getCompany());
            LogReport.logSubStep("Select an option of the field 'Country', eg: " + userAccount.getCountry());
            LogReport.logSubStep("Select an option of the field 'State', eg: " + userAccount.getState());
            LogReport.logSubStep("Enter a valid value to the field 'Phone', eg: " + userAccount.getPhone());
            signUpA.enterValuesToFinalForm(signUpPO, userAccount);

            LogReport.logMainStep("4. Back to the first form");
            LogReport.logSubStep("Select the button 'Back'");
            signUpPO.divBack.click();

            LogReport.logMainStep("5. Go to the final form");
            LogReport.logSubStep("Select the button 'Next'");
            signUpPO.btnNext.click();

            LogReport.logMainStep("6. Verify all values on the final form still display clearly and fully, include: ");
            LogReport.logSubStep("The text on the field 'Title'");
            generalA.verifyTextDisplay(userAccount.getTitle(), signUpPO.inputTitle, true);
            LogReport.logSubStep("The text on the field 'Company'");
            generalA.verifyTextDisplay(userAccount.getCompany(), signUpPO.inputCompany, true);
            LogReport.logSubStep("The option on the field 'Country'");
            generalA.verifyTextDisplay(userAccount.getCountry(), new Select(signUpPO.selectCountry).getFirstSelectedOption()
                    , false);
            LogReport.logSubStep("The option on the field 'Stage'");
            generalA.verifyTextDisplay(userAccount.getState(), new Select(signUpPO.selectState).getFirstSelectedOption()
                    , false);
            LogReport.logSubStep("The text on the field 'Phone'");
            generalA.verifyTextDisplay(userAccount.getPhone(), signUpPO.inputPhone, true);
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 11: Verify white space letters at first and the end of texts are trimmed after entering values to fields
     * <p>
     * 1. Go to the page 'Register'
     * + Launch the web browser
     * + Navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login' on the navigation bar
     * + Select the link 'Sign up here'
     * 2. Enter valid values to all required fields
     * + Enter a valid value consist white space letters at first and the end to the field 'First name*'
     * + Enter a valid value consist white space letters at first and the end  to the field 'Last name*'
     * + Enter a valid value consist white space letters at first and the end  to the field 'Email*'
     * + Enter a valid value to the field 'Password*'
     * + Enter a valid value to the field 'Confirm password*'
     * 3. Verify texts on fields 'First name*', 'Last name*', 'Email*' on first form were trimmed white space letters
     * 4. Select the button 'Next'
     * 5. Enter valid values to all optional fields
     * + Enter a valid value consist white space letters at first and the end  to the field 'Title'
     * + Enter a valid value consist white space letters at first and the end  to the field 'Company'
     * + Click any points on the screen, except the button 'Create Free Account'
     * 6. Verify texts on fields 'Title', 'Company' on last form were trimmed white space letters
     */
    @Test(priority = 11, enabled = false,
            testName = "Test case 11: Verify white space letters at first and the end of texts are trimmed " +
                    "after entering values to fields",
            description = "Description: Verify all texts on fields 'First name*', 'Last name*', 'Email*', 'Title', 'Company' " +
                    "were trimmed white space letters after they are entered",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckTrimWhiteSpaceLettersOfText")
    public void TC11_Verify_white_space_letters_at_first_and_the_end_of_texts_are_trimmed_after_entering_values_to_fields
    (UserAccount userAccount) {
        System.out.println("Test case 11: Verify white space letters at first and the end of texts are trimmed after entering values to fields");
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        SignUpPO signUpPO = new SignUpPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        ISignUpAction signUpA = new SignUpAction();

        try {
            LogReport.logMainStep("1. Go to the page 'Register'");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Select the link 'Sign up here'");
            navigateA.goToRegisterPage(testArchitectPO, loginPO);

            LogReport.logMainStep("2. Create new account by entering valid values to all fields");
            LogReport.logSubStep("Enter a valid value consist white space letters at first and the end to the field 'First name*'" +
                    ", eg: " + userAccount.getFirstName());
            LogReport.logSubStep("Enter a valid value consist white space letters at first and the end  to the field 'Last name*'" +
                    ", eg: " + userAccount.getLastName());
            LogReport.logSubStep("Enter a valid value consist white space letters at first and the end  to the field 'Email*'" +
                    ", eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter a valid value to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter a valid value to the field 'Confirm password*', eg: " + userAccount.getConfirmPw());
            signUpA.enterValuesToFirstForm(signUpPO, userAccount);

            LogReport.logMainStep("3. Verify texts on fields 'First name*', 'Last name*', 'Email*' on first " +
                    "form were trimmed white space letters");
            generalA.verifyTextDisplay(userAccount.getFirstName().trim(), signUpPO.inputFirstName, true);
            generalA.verifyTextDisplay(userAccount.getLastName().trim(), signUpPO.inputLastName, true);
            generalA.verifyTextDisplay(userAccount.getEmail().trim(), signUpPO.inputEmail, true);

            LogReport.logMainStep("4. Select the button 'Next'");
            signUpPO.btnNext.click();

            LogReport.logMainStep("5. Enter valid values to all optional fields");
            LogReport.logSubStep("Enter a valid value consist white space letters at first and the end  to " +
                    "the field 'Title', eg: " + userAccount.getTitle());
            LogReport.logSubStep("Enter a valid value consist white space letters at first and the end  to " +
                    "the field 'Company', eg: " + userAccount.getCompany());
            LogReport.logSubStep("Select an option of the field 'Country', eg: " + userAccount.getCountry());
            LogReport.logSubStep("Select an option of the field 'State', eg: " + userAccount.getState());
            LogReport.logSubStep("Enter a valid value to the field 'Phone', eg: " + userAccount.getPhone());
            signUpA.enterValuesToFinalForm(signUpPO, userAccount);

            LogReport.logMainStep("6. Verify texts on fields 'Title', 'Company' on last form were trimmed white space letters");
            generalA.verifyTextDisplay(userAccount.getTitle().trim(), signUpPO.inputTitle, true);
            generalA.verifyTextDisplay(userAccount.getCompany().trim(), signUpPO.inputCompany, true);
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }




    // verify the email or other values are trimmed the white space letters at the beginning and ending after entering the values to the corresponding field

    // verify the quantity of letters of the field 'Password' displays maximum is 128 letters

    // verify the maximum of
}
