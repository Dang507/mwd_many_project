package projects.TA_web.test_case.admin_portal;

import SSO_project.action.ILoginAction;
import SSO_project.action.implement_action.LoginAction;

import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;

import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import projects.TA_web.action.IAddCouponTypeAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.AddCouponTypeAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;

public class AddCouponTypeTC extends BaseTest {

    /** Test case 1: Verify all UI items display fully on the form 'Add '
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage Coupon Type'
     *  + Select the button 'Add'
     * 4. Verify all UI items on form 'Add' display fully, including:
     *  + All labels and title: 'Add coupon', 'Name', 'Limit', 'Status'
     *  + All input and select fields: 'Name', 'Limit', 'Status', 'Upload image'
     *  + All button: 'Save', 'Cancel'
     */
    @Test(priority = 1, enabled = false,
            testName = "Test case 1: Verify all UI items display fully on the form 'Add '",
            description = "Description: Verify all UI item show on the form 'Add'")
    public void TC01_Verify_all_UI_items_display_fully_on_the_form_Add(){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account_portal_staging;
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        try {
            System.out.println("Test case 1: Verify all UI items display fully on the form 'Add '");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage Coupon Type'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Verify all UI items on form 'Add' display fully");
            LogReport.logSubStep("<b>Verify all labels names and the title text: 'Name', 'Limit', 'Status', 'Add coupon type'</b>");
            addCouponTypeAction.verifyAllLabelsAndTitle(generalAction, addCouponTypePO);
            LogReport.logSubStep("<b>Verify all input fields and selection fields display fully: 'Name', 'Limit', 'Status'</b>");
            addCouponTypeAction.verifyAllInputFields(generalAction, addCouponTypePO);
            LogReport.logSubStep("<b>Verify all names of buttons display as the design: 'Save', 'Cancel'</b>");
            addCouponTypeAction.verifyAllButton(generalAction, addCouponTypePO);
            LogReport.logSubStep("<b>Verify all placeholder texts on the form: 'Name'</b>");
            addCouponTypeAction.verifyAllPlaceholderTexts(addCouponTypePO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 2: Verify error message display proper for the field 'Name'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage Coupon Type'
     *  + Select the button 'Add'
     * 4. Enter invalid values to the field 'Name' then click any points on the screen
     *  + Enter value to the field 'Name'
     *  + Click the label 'Limit'
     * 5. Verify all error messages and icon 'Warning' for the field 'Name' appear fully
     * 6. Repeat the step 4,5 with these values:
     *  + Enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      -> Expected result: The error message: 'Please remove special characters.' displays
     *  + Enter extensive texts
     *      - Verify texts display on these fields are 200 first letters
     *      - Verify the error message and icon 'Warning' for this field does not display
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  TEst    "
     *      - Verify texts displaying on these fields are trimmed
     *      - Verify the error message and icon 'Warning' for this field does not display
     *  + Enter Unicode text to these fields
     *      - Verify texts displaying on these fields are unchanged
     *      - Verify the error message and icon 'Warning' for this field does not display
     */
    @Test(priority = 2, enabled = false,
            testName = "Test case 2: Verify error message display proper for the field 'Name'",
            description = "Description: Verify the error message and icon 'Warning' for the field 'Name' appear inappropriate",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldNameOfCouponType")
    public void TC02_Verify_error_message_display_proper_for_the_field_Name
    (UserAccount user, String valueForName, String expectedText , String errorMsg){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();
        try {
            System.out.println("Test case 2: Verify error message display proper for the field 'Name'");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage Coupon Type'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter invalid values to the field 'Name' then click any points on the screen");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + valueForName);
            LogReport.logSubStep("Click the label 'Limit'");
            generalAction.enterValueOneField(addCouponTypePO.inputName, valueForName, addCouponTypePO.labelLimit);

            LogReport.logMainStep("5. Verify all error messages and icon 'Warning' for the field 'Name' appear properly");
            addCouponTypeAction.verifyErrorMsgFieldName(addCouponTypePO, expectedText, errorMsg);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 3: Verify error message display properly for the field 'Limit'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage Coupon Type'
     *  + Select the button 'Add'
     * 4. Enter values to the field 'Limit' then click any points on the screen
     *  + Enter value to the field 'Limit'
     *  + Click the title form
     * 5. Verify all error messages and icon 'Warning' for the field 'Limit' appear fully
     * 6. Repeat the step 4,5 with these values:
     *  + Clear the field and enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     *  + Clear the field and enter a text that it contains special letters (no consist numbers)
     *      - verify no letters display
     *      - verify the error message and icon 'Warning' disappear
     *  + Clear the field and enter a unicode text
     *      - Verify only numbers display
     *      - verify the error message and icon 'Warning' disappear
     *  + Enter a text that it consist numbers and white space letters at the beginning and ending places
     *      - Verify white space letters are trimmed
     *      - verify the error message and icon 'Warning' disappear
     +  + Enter a extensive text that it is mixed of letters and numbers
     *      - Verify only numbers display
     *      - verify the error message and icon 'Warning' disappear
     */
    @Test(priority = 3, enabled = false,
            testName = "Test case 3: Verify error message display proper for the field 'Limit'",
            description = "Description: Verify the error message and icon 'Warning' for the field 'Limit' appear appropriate",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldLimitOfCouponType")
    public void TC03_Verify_error_message_display_proper_for_the_field_Limit
    (UserAccount user, String valueForLimit, String expectedText, String errorMsg){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();

        try {
            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage Coupon Type'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter values to the field 'Limit' then click any points on the screen");
            LogReport.logSubStep("Enter value to the field 'Limit', eg: " + valueForLimit);
            LogReport.logSubStep("Click the label 'Name'");
            generalAction.enterValueOneField(addCouponTypePO.inputLimit, valueForLimit, addCouponTypePO.labelName);

            LogReport.logMainStep("5. Verify all error messages and icon 'Warning' for the field 'Limit' appear properly");
            addCouponTypeAction.verifyErrorMsgFieldLimit(addCouponTypePO, expectedText, errorMsg);



        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 4: Verify error message display when submitting the name being already in use
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage Coupon Type'
     *  + Select the button 'Add'
     * 4. Enter valid values all field
     *  + Enter value already in use to the field 'Name'
     *  + Enter value to the field 'Limit'
     *  + Select value on the field 'Status'
     *  + Select the button 'Save'
     * 5. Verify the error message display
     */
    @Test(priority = 4, enabled = false,
            testName = "Test case 4: Verify error message display when submitting the name being already in use",
            description = "Description: Verify the error message display when submitting the name being already in use")
    public void TC04_Verify_error_message_display_when_submitting_the_name_being_already_in_use(){
        INavigateAction navigateAction = new NavigateAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.admin_SSO_account_portal_staging;
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        CouponType couponType = dataTestTAWeb.coupon_type_already_in_use;
        String errorMsgExpected = dataTestTAWeb.error_msg_value_existed;
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        IGeneralAction generalAction = new GeneralAction();
        try {
            System.out.println("Test case 4: Verify error message display when submitting the name being already in use");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage Coupon Type'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter valid values all fields");
            LogReport.logSubStep("Enter value already in use to the field 'Name', eg: " + couponType.getName());
            LogReport.logSubStep("Enter value to the field 'Limit', eg: " + couponType.getLimit());
            LogReport.logSubStep("Select value on the field 'Status', eg: " + couponType.getStatus());
            LogReport.logSubStep("Select the image to upload from the path:, eg: " + couponType.getImageLink());
            LogReport.logSubStep("Select the button 'Save'");
            addCouponTypeAction.addNewCouponTypeWithImage(addCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify the error message display");
            generalAction.verifyTextDisplay(errorMsgExpected, addCouponTypePO.labelErrorMsgForName, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 5: Verify the successful message display after submitting successful
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage Coupon Type'
     *  + Select the button 'Add'
     * 4. Enter valid values all field
     *  + Enter value to the field 'Name'
     *  + Enter value to the field 'Limit'
     *  + Select value on the field 'Status'
     *  + Select the button 'Save'
     * 5. Verify the success message display
     */
    @Test(priority = 5, enabled = false,
            testName = "Test case 5: Verify the successful message display after submitting successful",
            description = "Description: Verify the successful message display after submitting successful",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCreateNewCouponTypeSuccessfully")
    public void TC05_Verify_the_successful_message_display_after_submitting_successful
    (UserAccount user, CouponType couponType, String successMsg){
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();

        try {
            System.out.println("Test case 5: Verify the successful message display after submitting successful");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage Coupon Type'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter valid values all field");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + couponType.getName());
            LogReport.logSubStep("Enter value to the field 'Limit', eg: " + couponType.getLimit());
            LogReport.logSubStep("Select value on the field 'Status' eg: " + couponType.getStatus());
            LogReport.logSubStep("Select image, eg: " + couponType.getImageLink());
            LogReport.logSubStep("Select the button 'Save'");
            addCouponTypeAction.addNewCouponTypeWithImage(addCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify the successful message displays");
            generalAction.verifyTextDisplay(successMsg, addCouponTypePO.divAlertMessage, false);
            LogReport.logMainStep("6. Verify the coupon name display on the data table");
            generalAction.verifyElementDisplayed
                    (Constant.webDriver.findElement(By.xpath("//tbody//*[text()='"+ couponType.getName() +"']")),
                            "The coupon " + couponType.getName());

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 6: Verify the error messages displays when the user enters nothing values to all fields
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage Coupon Type'
     *  + Select the button 'Add'
     * 4. Enter nothing to all field
     *  + Clear all fields
     *  + Enter nothing to all fields
     *  + Select the button 'Save'
     * 5. Verify all error messages and icon 'Warning' for empty fields display
     */
    @Test(priority = 6, enabled = false,
            testName = "Test case 6: Verify the error messages displays when the user enters nothing values to all fields",
            description = "Description: Verify the error messages display under all required fields after selecting the button 'Save'")
    public void TC06_Verify_the_error_messages_displays_when_the_user_enters_nothing_values_to_all_fields(){
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        INavigateAction navigateAction = new NavigateAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.admin_SSO_account_portal_staging;
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        CouponType couponType = dataTestTAWeb.coupon_type_empty_field;
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();

        try {
            System.out.println("Test case 6: Verify the error messages displays when the user enters nothing values to all fields");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage Coupon Type'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter nothing to all field");
            LogReport.logSubStep("Clear all fields");
            LogReport.logSubStep("Enter nothing to all fields");
            LogReport.logSubStep("Select the button 'Save'");
            addCouponTypeAction.addNewCouponType(addCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify All error messages for empty fields display fully");
            addCouponTypeAction.verifyAllErrorMsgForEmptyFields(generalAction, addCouponTypePO);
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 7: Verify the error message for the image that it appears appropriate
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage Coupon Type'
     *  + Select the button 'Add'
     * 4. Upload an image, and its size is greater than 5mbs
     *  + Select the button 'Upload image'
     *  + Select images from the pop up then selecting the button 'Ok'
     * 5. Verify error message displays appropriate
     *  + Verify the error message display
     */
    @Test(priority = 7, enabled = true,
            testName = "Test case 7: Verify the error message for the image appears appropriate",
            description = "Description: Verify the error message for the field 'Upload image' that it displays appropriate")
    public void TC07_Verify_the_error_message_for_the_image_appears_appropriate(){
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.admin_SSO_account_portal_staging;
        CouponType couponType = dataTestTAWeb.coupon_type_has_huge_image;

        try {
            System.out.println("Test case 7: Verify the error message for the image appears appropriate");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage Coupon Type'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter valid values all field");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + couponType.getName());
            LogReport.logSubStep("Enter value to the field 'Limit', eg: " + couponType.getLimit());
            LogReport.logSubStep("Select value on the field 'Status' eg: " + couponType.getStatus());
            LogReport.logSubStep("Select image, eg: " + couponType.getImageLink());
            LogReport.logSubStep("Select the button 'Save'");
            addCouponTypeAction.addNewCouponTypeWithImage(addCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify the error message for the field 'Upload image' displays appropriate");
            generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_huge_size, addCouponTypePO.divAlertMessage, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }



}
