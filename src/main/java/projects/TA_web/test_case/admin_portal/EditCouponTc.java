package projects.TA_web.test_case.admin_portal;

import base_test.BaseTest;
import common.*;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.ILoginAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.*;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.admin_portal.EditCouponPO;
import projects.TA_web.page_object.user_portal.LoginOn23ServerPO;
import projects.TA_web.page_object.user_portal.UserPortalPO;


public class EditCouponTc extends BaseTest {

    /** Test case 1: Verify the UI items on the page 'Edit coupon'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Edit coupon'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon'
     *  + Select icon 'Edit' at random from the data table
     * 4. Verify UI items display, include:
     *  + Verify the title text and all label names: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee
     *  + Verify all button names: Save, Cancel
     * 5. Verify all values that they are displaying on all fields of the coupon at step 3
     */
@Test(priority = 1,enabled = false,
        testName = "Verify the UI items on the page 'Edit coupon",
        description = "Verify GUI after load page successfully"

        )
    public void Verify_GUI(){
    INavigateAction navigateAction = new NavigateAction();
    ILoginAction loginAction = new LoginAction();
    LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
    UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
    DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
    IGeneralAction generalAction = new GeneralAction();
    EditCouponAction editCouponAction = new EditCouponAction();
    EditCouponPO editCouponPO= new EditCouponPO(Constant.webDriver);

    try {
        System.out.println("Test case 1:Verify the UI items on the page 'Edit coupon");

        LogReport.logMainStep("1. Go to the page Login");
        LogReport.logSubStep("Open the web browser");
        LogReport.logSubStep("Enter the above URL to the address bar on the browser");
        LogReport.logSubStep("Press the key 'Enter' on the keyboard");
        LogReport.logSubStep("Select the button 'Login'");
        navigateAction.goToLoginPage(Constant.webDriver);

        LogReport.logMainStep("2. Log in");
        LogReport.logSubStep("Go to the page 'Login'");
        LogReport.logSubStep("Enter the email, eg: " );
        LogReport.logSubStep("Enter the password, eg: ");
        LogReport.logSubStep("Select the button 'Login'");
        loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

        LogReport.logMainStep("3. Go to the page 'Edit coupon type'");
        LogReport.logSubStep("Select the link 'Go to Admin Page'");
        LogReport.logSubStep("Select the Edit icons in record has been selected in Manage Coupon page");
        navigateAction.goToEditCoupon(Constant.webDriver);

        LogReport.logMainStep("4. Verify UI items on the form 'Edit Coupon'");
        LogReport.logSubStep("The form label and all input fields");
        editCouponAction.checkAllFieldsDisplayed(generalAction,editCouponPO);


    }
    catch (Exception e){
        LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                Constant.webDriver.getCurrentUrl(), e);
        e.printStackTrace();
    }

}
    /** Test case 2: Verify the error messages for empty fields appear after the user updates a coupon with empty value
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Edit coupon'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon'
     *  + Select icon 'Edit' at random from the data table
     * 4. Update the coupon with empty value for all input fields
     *  + Clear all values on all input fields
     *  + Select the button 'Save'
     * 5. Verify the error messages and icon 'Warning' for an empty field appears fully on all required input fields
     */
    @Test(priority = 2,
            testName = "Verify the error messages for empty fields appear after the user updates a coupon with empty value",
            description = "Verify the error messages for empty fields appear after the user updates a coupon with empty value"   )

    public void Verify_Error_Message_For_Empty_Fields (){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        EditCouponAction editCouponAction = new EditCouponAction();
        EditCouponPO editCouponPO= new EditCouponPO(Constant.webDriver);

        try {
            System.out.println("Verify the error messages for empty fields appear after the user updates" +
                    " a coupon with empty value");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Log in");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " );
            LogReport.logSubStep("Enter the password, eg: ");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the Edit icons in record has been selected in Manage Coupon page");
            navigateAction.goToEditCoupon(Constant.webDriver);

            LogReport.logMainStep("4. Verify the error messages for empty fields appear after the user updates a coupon with empty value'");
            LogReport.logSubStep("clear value in all fields");
            editCouponAction.ClearFields(editCouponPO);
            LogReport.logMainStep("5. Verify All error messages for empty fields display fully");
            editCouponAction.verifyAllErrorMsgForEmptyFields(generalAction,editCouponPO);


        }
        catch (Exception e){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), e);
            e.printStackTrace();
        }

    }

    /** Test case 3: Verify the error message displays appropriate on the field 'Name*'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Edit coupon'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon'
     *  + Select icon 'Edit' at random from the data table
     * 4. Enter value to field 'Name'
     *  + Clear the field 'Name'
     *  + Enter an invalid value / a valid value to the field 'Name'
     *  + Click any points on the screen, eg: The title page
     * 5. Verify the error messages display or not
     * 6. Repeat the steps 4, 5 with these values:
     *  + Enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      -> Expected result: The error message: 'Please remove special characters.' displays
     *  + Enter extensive texts
     *      - Verify texts display on these fields are 200 first letters
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  TEst    "
     *      - Verify texts displaying on these fields are trimmed
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter Unicode text to these fields
     *      - Verify texts displaying on these fields are unchanged
     *      - Verify the error message and icon 'Warning' for this field  still hide
     */
    @Test(priority = 3,enabled = false,
            testName = "Verify the error message displays appropriate on the field 'Name*",
            description = "Verify the error message displays appropriate on the field 'Name*",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldNameOfCoupon")

    public void Verify_Error_Message_For_Field_Name(String valueForName, String expectedText , String errorMsg){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        EditCouponAction editCouponAction = new EditCouponAction();
        EditCouponPO editCouponPO= new EditCouponPO(Constant.webDriver);

        try {
            System.out.println("Verify the error message displays appropriate on the field 'Name*");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Log in");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " );
            LogReport.logSubStep("Enter the password, eg: ");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the Edit icons in record has been selected in Manage Coupon page");
            navigateAction.goToEditCoupon(Constant.webDriver);

            LogReport.logMainStep("4. Verify the error messages for empty fields appear after the user updates a coupon with empty value'");
            LogReport.logSubStep("Clear the current value on the field 'Name'");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + valueForName);
            generalAction.enterValueOneField(editCouponPO.inputName, valueForName,editCouponPO.labelName);


            LogReport.logMainStep("5. Verify All error messages");
            editCouponAction.verifyAllErrorMsgFields(editCouponPO, expectedText, errorMsg);


        }
        catch (Exception e){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), e);
            e.printStackTrace();
        }
    }
    /** Test case 4: Verify the error message appears, if the user updates the current coupon that it is the same to another coupon
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Edit coupon'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon'
     *  + Select icon 'Edit' at random from the data table
     * 4. Update the coupon that it has been selected is the same to any coupons on the data table 'Manage coupon'
     *  + Enter all valid values to all fields, and they are similar another coupon that it is already use
     *  + Select the button 'Save'
     * 5. Verify the error message that it appears to reminder the coupon is existed
     */
    @Test (priority = 4,enabled = false,
            testName = "Verify the error message appears, if the user updates the current coupon that it is the same to another coupon",
            description = "Verify the error message appears, if the user updates the current coupon that it is the same to another coupon"
            )
    public void Verify_Error_Message_If_Coupon_Has_Been_Existed()  {
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        EditCouponAction editCouponAction = new EditCouponAction();
        EditCouponPO editCouponPO= new EditCouponPO(Constant.webDriver);

        System.out.println("Test case 1:Verify the error message appears," +
                " if the user updates the current coupon that it is the same to another coupon");
        try {
            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Log in");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: ");
            LogReport.logSubStep("Enter the password, eg: ");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type'");
            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the Edit icons in record has been selected in Manage Coupon page");
            navigateAction.goToEditCoupon(Constant.webDriver);

            LogReport.logMainStep("4. Verify the error messages when input the coupon name has been existed'");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + dataTestTAWeb.value_existed);
            editCouponPO.inputName.clear();
            generalAction.enterValueOneField(editCouponPO.inputName, dataTestTAWeb.value_existed, editCouponPO.btnSave);
            LogReport.logMainStep("5. Verify All error messages");
            editCouponAction.verifyAllErrorMsgFields(editCouponPO, dataTestTAWeb.value_existed, dataTestTAWeb.error_msg_existed);

        }
        catch (Exception e){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), e);
            e.printStackTrace();
        }
    }



}
