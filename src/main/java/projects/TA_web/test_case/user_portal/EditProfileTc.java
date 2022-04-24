package projects.TA_web.test_case.user_portal;

import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IEditProfileAction;
import projects.TA_web.action.ILoginAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.EditProfileAction;
import projects.TA_web.action.implement_action.LoginAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.user_portal.EditProfilePO;
import projects.TA_web.page_object.user_portal.LoginOn23ServerPO;
import projects.TA_web.page_object.user_portal.UserPortalPO;

public class EditProfileTc extends BaseTest {


    /**
     * Test case 1: Verify GUI after load page successfully
     *
     *
     *
     *
     * */
    @Test(priority = 1,enabled = false,
            testName = "Verify GUI after load page successfully",
            description = "Verify GUI after load page successfully"
            )
    public void TC_1_Verify_GUI(){
        System.out.println("Test case 1: Verify GUI after load page successfully");
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IEditProfileAction editProfileAction = new EditProfileAction();
        EditProfilePO editProfilePO = new EditProfilePO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        try {
            System.out.println("Test case 01: Verify the UI items on the page 'Edit Profile'");
            LogReport.logMainStep("1. Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid user account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

            LogReport.logMainStep("3. Go to the page 'Edit Profile User Page'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'My Profile'");
            LogReport.logSubStep("Click button Edit Profile in My Profile Page'");
            navigateAction.goToEditProfileUserPage(Constant.webDriver,userPortalPO);
            LogReport.logMainStep("4. Verify UI items on the form 'Edit Profile'");
            LogReport.logSubStep("The form label and all input fields");
            editProfileAction.checkAllFieldsDisplayed(generalAction,editProfilePO);

           /* LogReport.logSubStep("Verify all error message and icon 'Warning' are hidden");
            changePwA.verifyAllErrorMessageHidden(generalA, Constant.webDriver, changePwPO);*/


        }
        catch (Exception exception){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }


    }
    @Test(priority = 2,dataProviderClass = DataTestSSO.class,enabled = false,
    dataProvider = "getDataForFieldNameUpdateProfilePage",
    testName = "Verify Error message on field first name and last name",
    description = "Verify Error message on field first name and last name")
    public  void TC_2_Verify_Error_Message_On_Fields_FirstName_LastName(String textName,String textDisplay, String errorMsg){
        System.out.println("Test case 02: Verify validation on first name and last name field required");
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IEditProfileAction editProfileAction = new EditProfileAction();
        EditProfilePO editProfilePO = new EditProfilePO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();

    try {
        System.out.println("Test case 02: Verify validation on first name and last name field required'");
        LogReport.logMainStep("1. Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode");
        LogReport.logSubStep("Open the web browser");
        LogReport.logSubStep("Enter the above URL to the address bar on the browser");
        LogReport.logSubStep("Press the key 'Enter' on the keyboard");
        navigateAction.goToLoginPage(Constant.webDriver);

        LogReport.logMainStep("2. Login with valid user account");
        LogReport.logSubStep("Enter user account to the field 'Email', eg: ");
        LogReport.logSubStep("Enter password to the field 'Password'");
        LogReport.logSubStep("Select the button 'Login'");
        loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

        LogReport.logMainStep("3. Go to the page 'Edit Profile User Page'");
        LogReport.logSubStep("Select the account menu");
        LogReport.logSubStep("Select the tab 'My Profile'");
        LogReport.logSubStep("Click button Edit Profile in My Profile Page'");
        navigateAction.goToEditProfileUserPage(Constant.webDriver, userPortalPO);

        LogReport.logMainStep("5. Input data on the page 'Edit Profile User Page'");
        LogReport.logSubStep("Input values"+ textName);
        editProfileAction.UpdateFields(editProfilePO,textName);

        LogReport.logMainStep("6. Verify the error message display appropriate");
        if (errorMsg.equals("")){
            generalAction.verifyTextDisplay(textDisplay,editProfilePO.inputFirstName,true);
            generalAction.verifyTextDisplay(textDisplay,editProfilePO.inputLastName,true);
        }else {
            generalAction.verifyTextDisplay(errorMsg,editProfilePO.labelErrorMsgFirstName,false);
            generalAction.verifyTextDisplay(errorMsg,editProfilePO.labelErrorMsgLastName,false);

        }

    }
    catch (Exception exception){
        LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                Constant.webDriver.getCurrentUrl(), exception);
                exception.printStackTrace();
        }
    }

    @Test(priority = 3,
            testName = "Verify upload avatar",
            description = "Verify upload avatar")
    public void TC_3_Verify_UploadAvatar(){
        System.out.println("Test case 03: Verify upload avatar");
        NavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IEditProfileAction editProfileAction = new EditProfileAction();
        EditProfilePO editProfilePO = new EditProfilePO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();

        try{
            LogReport.logMainStep("1. Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid user account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: ");
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

            LogReport.logMainStep("3. Go to the page 'Edit Profile User Page'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'My Profile'");
            LogReport.logSubStep("Click button Edit Profile in My Profile Page'");
            navigateAction.goToEditProfileUserPage(Constant.webDriver, userPortalPO);
            LogReport.logMainStep("Verify invalid image type ");
            editProfileAction.UploadAvatar(editProfilePO,false);
            LogReport.logMainStep("Verify valid image type");
            editProfileAction.UploadAvatar(editProfilePO,true);

        }
        catch (Exception exception){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
                    exception.printStackTrace();
        }

   }

    @Test(priority = 4,enabled = false,
            testName = "Verify error message on phone field",
            description = "Verify error message on phone field",
            dataProvider = "getDataForFieldPhone",dataProviderClass =DataTestSSO.class )
    public void TC_4_Verify_Error_Message_On_Phone_Field(UserAccount userAccount, String phone, String errorMsg){
        System.out.println("Test case 04: Verify error message on phone field");
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginOn23ServerPO loginOn23ServerPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IEditProfileAction editProfileAction = new EditProfileAction();
        EditProfilePO editProfilePO = new EditProfilePO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();

        try{
            System.out.println("Test case 02: Verify validation on first name and last name field required'");
            LogReport.logMainStep("1. Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid user account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: ");
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginOn23ServerPO, dataTestTAWeb.account_test_edit_profile);

            LogReport.logMainStep("3. Go to the page 'Edit Profile User Page'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'My Profile'");
            LogReport.logSubStep("Click button Edit Profile in My Profile Page'");
            navigateAction.goToEditProfileUserPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("4. Input phone number on the page 'Edit Profile User Page'");
            LogReport.logSubStep("Input values" + phone);

            editProfilePO.inputPhone.sendKeys(phone);
            editProfilePO.labelCompany.click();
            if (!errorMsg.equals("")){
                generalAction.verifyTextDisplay(errorMsg,editProfilePO.labelErrorMsgPhone,false);
            }

        }
        catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }

    }
}
