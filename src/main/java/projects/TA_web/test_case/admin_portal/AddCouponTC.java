package projects.TA_web.test_case.admin_portal;

import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IAddCouponAction;
import projects.TA_web.action.IEditCouponAction;
import projects.TA_web.action.ILoginAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.AddCouponAction;
import projects.TA_web.action.implement_action.EditCouponAction;
import projects.TA_web.action.implement_action.LoginAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.Coupon;
import projects.TA_web.page_object.admin_portal.AddCouponPO;
import projects.TA_web.page_object.admin_portal.EditCouponPO;
import projects.TA_web.page_object.user_portal.LoginOn23ServerPO;
import projects.TA_web.page_object.user_portal.UserPortalPO;

public class AddCouponTC extends BaseTest {

    /** Test case 1: Verify the UI items on the page 'Add coupon'
     * 1. Go to the page 'Add coupon'
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     *  + Enter the admin email
     *  + Enter the admin password
     *  + Select the button 'Login'
     *  + Select the link 'Go to Admin Page'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 2. Verify UI items display, include:
     *  + Verify the title text and all label names: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee
     *  + Verify all input fields, selection fields: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee
     *  + Verify all button names: Save, Cancel
     */
    @Test(priority = 1,enabled = false,
            testName = "Test case 1: Verify the UI items on the page 'Add coupon'",
            description = "Description: Verify the UI items display fully on the page 'Add coupon'")
    public void TC01_Verify_GUI(){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        AddCouponPO addCouponPO = new AddCouponPO(Constant.webDriver);
        IAddCouponAction addCouponAction = new AddCouponAction();

        try {
            System.out.println("Test case 1: Verify the UI items on the page 'Add coupon'");

            LogReport.logMainStep("1. Go to the page 'Add coupon'");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser: stage1.testarchitect.com");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logSubStep("Enter the email to the field 'Email', eg: " + dataTestTAWeb.account_test_edit_profile);
            LogReport.logSubStep("Enter the password to the field 'Password', eg: " + dataTestTAWeb.account_test_edit_profile);
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

            LogReport.logSubStep("Select the link 'Go to Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon'");
            LogReport.logSubStep("Select the button 'Add'");
            navigateAction.goToAddCoupon(Constant.webDriver);

            LogReport.logMainStep("2. Verify UI items display on the page 'Add coupon'");
            LogReport.logSubStep("<b>Verify the title text and all label names as the design: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee</b>");
            addCouponAction.verifyAllLabelsOnFormCoupon(addCouponPO,generalAction);

            LogReport.logSubStep("<b>Verify all input fields, selection fields display fully: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee</b>");
            LogReport.logSubStep("<b>Verify all button names: Save, Cancel</b>");
            addCouponAction.verifyAllFieldsOnFormCoupon(addCouponPO,generalAction);
            LogReport.logSubStep("<b>Verify all input fields, selection fields display fully: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee</b>");
            addCouponAction.verifyAllButtonsNames(addCouponPO,generalAction);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 2: Verify the error messages for empty fields appear fully after creating a new coupon without any values
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
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Enter nothing value to all fields
     *  + Clear all values on all fields
     *  + Select the button 'Save'
     * 5. Verify the error messages and icon 'Warning' for an empty field appears fully on all required fields
     */

    @Test(priority = 2,enabled = false,
            testName = "Verify the error messages for empty fields appear fully after " +
            "creating a new coupon without any values",
            description = "erify the error messages for empty fields appear fully after creating " +
            "a new coupon without any values")
    public void Verify_Error_Message_For_Empty_Fields(){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        IAddCouponAction addCouponAction = new AddCouponAction();
        AddCouponPO addCouponPO = new AddCouponPO(Constant.webDriver);
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
            addCouponAction.ClearFields(addCouponPO);
            LogReport.logMainStep("5. Verify All error messages for empty fields display fully");
            addCouponAction.verifyAllErrorMsgForEmptyFields(generalAction,addCouponPO);


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
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Enter value to field 'Name'
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
        IAddCouponAction addCouponAction = new AddCouponAction();
        AddCouponPO addCouponPO = new AddCouponPO(Constant.webDriver);
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
            navigateAction.goToAddCoupon(Constant.webDriver);

            LogReport.logMainStep("4. Verify the error messages for empty fields appear after the user updates a coupon with empty value'");
            LogReport.logSubStep("Clear the current value on the field 'Name'");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + valueForName);

            generalAction.enterValueOneField(addCouponPO.inputName, valueForName,addCouponPO.labelName);


            LogReport.logMainStep("5. Verify All error messages");
            addCouponAction.verifyAllErrorMsgFields(addCouponPO, expectedText, errorMsg);


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
    @Test (priority = 4,
            testName = "Verify the error message appears, if the user updates the current coupon" +
                    " that it is the same name to another coupon",
            description = "Verify the error message appears, if the user updates the current coupon" +
                    " that it is the same name to another coupon"
    )
    public void Verify_Error_Message_If_Coupon_Has_Been_Existed()  {
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        IAddCouponAction addCouponAction = new AddCouponAction();
        AddCouponPO addCouponPO= new AddCouponPO(Constant.webDriver);
        Coupon coupon = new Coupon("20","30","45");
        Coupon coupon2=  new Coupon("Active","Test Cases","Hours","Repository");

        System.out.println("Test case 4:Verify the error message appears," +
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
            navigateAction.goToAddCoupon(Constant.webDriver);

            LogReport.logMainStep("4. Verify the error messages when input the coupon name has been existed'");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + dataTestTAWeb.value_existed);
            generalAction.enterValueOneField(addCouponPO.inputName, dataTestTAWeb.value_test_case_existed,addCouponPO.labelName);
            addCouponAction.AddCoupon(addCouponPO,coupon,coupon2);

            LogReport.logMainStep("5. Verify All error messages");
            addCouponAction.verifyAllErrorMsgFields(addCouponPO, dataTestTAWeb.error_msg_existed_page_AddCoupon, dataTestTAWeb.error_msg_existed_page_AddCoupon);

        }
        catch (Exception e){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), e);
            e.printStackTrace();
        }
    }




    /** Notes: This case is tested manual testing
     * Test case 11: Verify the coupon status is updated 'in-active' automatically after the coupon out of duration time
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
     * 3. Add new coupon
     *  + Enter valid values to all fields
     *  + Select any duration time, eg: 1-2 hours/days/months
     * 4. Verify the coupon's status to be updated 'in-active' automatically after the coupon out of the duration time
     */





}
