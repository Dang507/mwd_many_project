package SSO_project.test_case;

import SSO_project.action.ILoginAction;
import SSO_project.action.INavigateAction;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTc extends BaseTest {

    /**
     * Test case 01: Verify some UI items on the page 'Login'
     *
     * 1. Go to the page 'Login'
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     * 2. Verify the UI items on the page 'Login', include the fields:
     *  + 'Email', 'Password', button 'Login' , link 'Forgot password?', link 'Sign up here'
     */
    @Test(priority = 1,
            testName = "Test case 01: Verify some UI items on the page 'Login'",
            description = "Verify some UI items on the page 'Login', include the fields: 'Email', 'Password', " +
                    "button 'Login' , link 'Forgot password?', link 'Sign up here'")
    public void TC01_Verify_some_UI_items_on_the_page_Login() {
        System.out.println("Test case 01: Verify some UI items on the page 'Login'");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Verify the UI items on the page 'Login', " +
                    "include the fields: 'Email', 'Password', button 'Login' , link 'Forgot password?', " +
                    "link 'Sign up here'");
            loginA.checkLoginPageGUI(loginPO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02: Verify the error messages display when signing by an invalid account
     *
     * 1. Go to the page 'Login'
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     * 2. Login with invalid accounts, eg: invalid emails, or wrong email/password
     * 3. Verify the error messages display
     */
    @Test(priority = 2,
            testName = "Test case 02: Verify the error messages display when signing in by an invalid account",
            description = "Verify the error messages display when login with invalid accounts",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToTestLoginPage")
    public void TC02_Verify_the_error_messages_display_when_signing_in_by_an_invalid_account
    (String email, String password, String errorMsgExpected) {
        System.out.println("Test case 02: Verify the error messages display when signing in by an invalid account");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        IGeneralAction generalA = new GeneralAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        DataTestSSO dataTest = new DataTestSSO();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with invalid accounts, eg: invalid emails, or wrong email/password");
            LogReport.logSubStep("Enter the email: " + email);
            LogReport.logSubStep("Enter the password: " + password);
            loginA.loginWithInvalidAccounts(loginPO, email, password);

            LogReport.logMainStep("3. Verify the error messages display");
            if (email.equals("")){
                generalA.verifyTextDisplay(errorMsgExpected, loginPO.labelEmailErrorMsg, false);
                generalA.verifyTextDisplay(errorMsgExpected, loginPO.labelPwErrorMsg, false);
            }else if (email.equals(dataTest.email_never_register_before)){
                generalA.verifyTextDisplay(errorMsgExpected, loginPO.divIncorrectInfo, false);
            }else if (email.startsWith(" ")){
                generalA.verifyElementHidden(loginPO.labelEmailErrorMsgBy, Constant.webDriver
                        , "The label error of the field 'Email'");
                generalA.verifyTextDisplay(email.trim(), loginPO.inputEmail, true);
            }else {
                generalA.verifyTextDisplay(errorMsgExpected, loginPO.labelEmailErrorMsg, false);
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 03: Verify login successful with an account already in use
     *
     * 1. Go to the page 'Login'
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     * 2. Login successful with an account already in use
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Verify the account name shows on the navigation bar
     */
    @Test(priority = 3,
            testName = "Test case 03: Verify login successful with an account already in use",
            description = "Verify the account name shows on the navigation bar after logging successful",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToLoginSuccessful")
    public void TC03_Verify_login_successful_with_an_account_already_in_use(UserAccount userAccount) {
        System.out.println("Test case 03: Verify login successful with an account already in use");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login successful with an account already in use");
            LogReport.logSubStep("Enter the email: " + userAccount.getEmail());
            LogReport.logSubStep("Enter the password: " + userAccount.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("3. Verify the account name shows on the navigation bar");
            generalA.verifyTextDisplay(userAccount.getFirstName() + " " + userAccount.getLastName(),
                    testArchitectPO.accountName, false);
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 04: Verify the account name still displays after re-open page 'Home' on the new tab without login again
     *
     * 1. Go to the page 'Login'
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     * 2. Login successful with an account already in use without choosing the option 'Remember me'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Verify the account name shows on the navigation bar
     * 4. Open the new tab, then close the current tab
     *  + Open the new tab
     *  + Close the current tab
     * 5. At the new tab, navigate to the URL: stage1.testarchitect.com
     * 6. Verify the account name still displays on the navigation bar
     */
    @Test(priority = 4,
            testName = "Test case 04: Verify the account name still displays after re-open page 'Home' on the new tab without login again",
            description = "Verify the account name still shows on the navigation bar after re-opening page 'Home' without signing in again",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToLoginSuccessful")
    public void TC04_Verify_the_account_is_still_login_reopening_page_Home_on_the_new_tab(UserAccount userAccount) {
        System.out.println("Test case 04: Verify the account is still 'login' after re-opening page 'Home' on the new tab");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        try {
            LogReport.logMainStep("1. Go to the page 'Login'");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login successful with an account already in use");
            LogReport.logSubStep("Enter the email: " + userAccount.getEmail());
            LogReport.logSubStep("Enter the password: " + userAccount.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("3. Verify the account name shows on the navigation bar");
            generalA.verifyTextDisplay(userAccount.getFirstName() + " " + userAccount.getLastName(),
                    testArchitectPO.accountName, false);

            LogReport.logMainStep("4. Open the new tab, then close the current tab");
            LogReport.logSubStep("Open the new tab");
            LogReport.logSubStep("Close the current tab");
            generalA.openNewTabAndCloseCurrentTab(Constant.webDriver);

            LogReport.logMainStep("5. Navigate to the URL: https://stage1.testarchitect.com/ at the new tab" );
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            navigateA.gotoTAPage();

            LogReport.logMainStep("6. Verify the account name still display on the navigation bar");
            generalA.verifyTextDisplay(userAccount.getFirstName() + " " + userAccount.getLastName(),
                    testArchitectPO.accountName, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * This source code should be reference, owing to the featured log in with option 'Remember me' does not affective with auto
     * Test case 05: Verify the account name displays in the new window after login with option 'Remember me'
     * <p>
     * 1. Login successfully, then close this window
     * + Open the web browser, navigate to https://stage1.testarchitect.com/
     * + Select the button 'Login'
     * + Enter the email
     * + Enter the password
     * + Choose the option 'Remember me'
     * + Select the button 'Login'
     * + Verify the account name displays on the navigation bar
     * + Close the new window
     * 2. Go to the page 'Home' again, then select the button 'Login'
     *  + Re-launching the web browser
     *  + Navigate to the URL: https://stage1.testarchitect.com/
     *  + Click the button 'Login'
     * 3. Verify the account name still displays on the navigation bar
     */
    @Test(priority = 5, enabled = false,
            testName = "Test case 05: Verify the account name displays in the new window after login with option 'Remember me'",
            description = "Verify the account name displays after opening the new window without signing in again",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToLoginSuccessful")
    public void TC05_Verify_the_account_name_displays_in_the_new_window_after_login_with_option_Remember_me(UserAccount userAccount) {
        System.out.println("Test case 05: Verify the account name displays in the new window after login with option 'Remember me'");
        INavigateAction navigateA = new NavigateAction();
        IGeneralAction generalA = new GeneralAction();
        ILoginAction loginA = new LoginAction();
        try {
            LogReport.logMainStep("1. Login successfully, then close this window");
            LogReport.logSubStep("Open the web browser, navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login'");
            LogReport.logSubStep("Enter the email");
            LogReport.logSubStep("Enter the password");
            LogReport.logSubStep("Choose the option 'Remember me'");
            LogReport.logSubStep("Select the button 'Login'");
            LogReport.logSubStep("Verify the account name displays on the navigation bar");
            LogReport.logSubStep("Close the current window");
            loginA.loginWithRememberMe(Constant.webDriver, userAccount);

            LogReport.logMainStep("2. Go to the page 'Home' again, then select the button 'Login'");
            LogReport.logSubStep("Re-launching the web browser");
            LogReport.logSubStep("Navigate to the URL: https://stage1.testarchitect.com/");
            LogReport.logSubStep("Click the button 'Login'");
            // The step 2 is not convert to a function to clean code although i tried hard to do that, eg: function 'loginAgainByRememberMe(WebDriver webDriver)'
            // When i tried it, as soon as the webDriver is interrupt  and the webpage is closed
            // Thereby, I write script step detail within this test case. Please ignore for this inconvenient
            TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
            Constant.webDriver = new ChromeDriver();
            generalA.setupWebdriverTimeOut(Constant.webDriver);
            Constant.webDriver.manage().window().maximize();
            navigateA.gotoTAPage();
            testArchitectPO.btnLogin.click();

            LogReport.logMainStep("3. Verify the account name still display on the navigation bar");
            generalA.verifyTextDisplay(userAccount.getFirstName() + " " + userAccount.getLastName(),
                    testArchitectPO.accountName, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

}

//    private void loginAgainByRememberMe(WebDriver webDriver) {
//        webDriver = new ChromeDriver();
//        NavigateA navigateA = new NavigateImpA();
//        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
//        webDriver.manage().window().maximize();
//        navigateA.gotoTAPage();
//        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
//        testArchitectPO.btnLogin.click();
//    }