package projects.TA_web.test_case.admin_portal;


import SSO_project.action.ILoginAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import base_test.BaseTest;
import common.*;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IAddCouponTypeAction;
import projects.TA_web.action.IDeleteCouponTypeAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.AddCouponTypeAction;
import projects.TA_web.action.implement_action.DeleteCouponTypeAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public class DeleteCouponTypeTc extends BaseTest {

    /** Test case 01: Verify UI items on the 'Delete' dialog
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Manage coupon type'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon type'
     * 4. Open the 'Delete' dialog
     *  + Select the 'Trash' symbol at random on the data table
     * 5. Verify UI items on the dialog, including:
     *  + The dialog title
     *  + All button: 'Delete', 'Cancel'
     * 6. Verify the button 'Cancel' that works normally
     *  + Select the button 'Cancel' on the dialog
     *  + Verify the dialog disappear
     */
    @Test(priority = 1, enabled = false,
            testName = "Test case 1: Verify UI items on the 'Delete' dialog",
            description = "Description: Verify all UI item show on the dialog 'Delete'")
    public void TC01_UI_items_on_the_Delete_dialog(){
        INavigateAction navigateAction = new NavigateAction();
        ManageCouponTypePO couponTypePO = new ManageCouponTypePO(Constant.webDriver);
        IDeleteCouponTypeAction deleteCouponTypeA = new DeleteCouponTypeAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.admin_SSO_account_portal_staging;
        CouponType couponType = dataTestTAWeb.coupon_type_already_in_use;
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        ILoginAction loginAction = new LoginAction();
        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(Constant.webDriver);
        IGeneralAction generalAction = new GeneralAction();

        try {
            System.out.println("Test case 1: Verify UI items on the 'Delete' dialog");
            LogReport.logMainStep("1. Go to the page Login:");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser: stage1.testarchitect.com");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Manage coupon type'");
            LogReport.logSubStep("Select the link 'Go To Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon type'");
            navigateAction.goToManageCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Open the 'Delete' dialog");
            LogReport.logSubStep("Select the 'Trash' symbol at random, eg at row 10");
            couponTypePO.svgIconDeleteRow1.click();

            LogReport.logMainStep("5. Verify UI items on the dialog");
            deleteCouponTypeA.verifyUIItemsDeleteDialog(manageCouponTypePO, couponType);

            LogReport.logMainStep("6. Verify the button 'Cancel' that works normally");
            LogReport.logSubStep("Select the button 'Cancel' on the dialog");
            LogReport.logSubStep("Verify the dialog disappear");
            manageCouponTypePO.btnCancel.click();
            generalAction.verifyElementHidden(manageCouponTypePO.h2DialogTitleBy, Constant.webDriver, "The 'Delete' dialog");

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 02: Verify the success message appears after selecting the button 'Delete'
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
     * 3. Go to the page 'Manage coupon type'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon type'
     * 4. Add 3 new coupon types
     *  + Select the button 'Add'
     *  + Create new coupon types that their name start with 'coupon for testing'
     * 5. Verify the user can deletes coupon types one by one at step 4 successful
     *  + Select the 'Trash can' symbols of a coupon types at step 4
     *  + Select the button 'Delete'
     *  + Verify the successful message that displays
     */
    @Test(priority = 2, enabled = true,
            testName = "Test case 02: Verify the success message appears after selecting the button 'Delete'",
            description = "Description: Verify the success message appears after selecting the button 'Delete'")
    public void TC03_Verify_the_success_message_appears_after_selecting_the_button_Delete(){
        ILoginAction loginAction = new LoginAction();
        INavigateAction navigateA = new NavigateAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.admin_SSO_account_portal_staging;
        CouponType couponType = dataTestTAWeb.coupon_type_has_image_png;
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        IDeleteCouponTypeAction deleteCouponTypeAction = new DeleteCouponTypeAction();
        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(Constant.webDriver);

        try {
            System.out.println("Test case 1: Verify UI items on the 'Delete' dialog");

            LogReport.logMainStep("1. Go to the page Login:");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser:");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Manage coupon type'");
            LogReport.logSubStep("Select the link 'Go To Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon type'");
            navigateA.goToManageCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Add 3 new coupon types");
            LogReport.logSubStep("Select the button 'Add'");
            LogReport.logSubStep("Create new coupon types that their name start with 'coupon for testing'");
            addCouponTypeAction.addManyCouponTypes(manageCouponTypePO, addCouponTypePO, 1, couponType);

            LogReport.logMainStep("5. Verify the user that is able to deletes coupon types from step 4  one by one successful");
            LogReport.logSubStep("Select the 'Trash can' symbols of a coupon types at step 4");
            LogReport.logSubStep("Select the button 'Delete'");
            LogReport.logSubStep("Verify the successful message that displays");
            deleteCouponTypeAction.verifyDeleteCouponType(manageCouponTypePO, Constant.webDriver, couponType);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

}
