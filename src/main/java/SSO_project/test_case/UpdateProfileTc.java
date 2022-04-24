package SSO_project.test_case;

import SSO_project.action.ILoginAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.IUpdateProfileAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.action.implement_action.UpdateProfileAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import SSO_project.page_object.UpdateProfilePO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;

public class UpdateProfileTc extends BaseTest {
    /**
    * Test case 1: Verify GUI after load page successfully
    *
    *
    *
    *
    * */
    @Test(priority = 1,
            testName = "Verify GUI after load page successfully",
            description = "Verify GUI after load page successfully",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckUIUpdateProfilePage")
    public void TC_1_Verify_GUI(UserAccount userAccount){
        System.out.println("Test case 1: Verify GUI after load page successfully");
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        UpdateProfilePO updateProfilePO = new UpdateProfilePO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        IUpdateProfileAction updateProfileAction = new UpdateProfileAction();
        IGeneralAction generalAction = new GeneralAction();
        ILoginAction loginAction = new LoginAction();
        try {
            LogReport.logMainStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select options 'Manage My Profile' on the navigation bar");
                navigateAction.goToLoginPage(testArchitectPO);
                loginAction.loginSSO(loginPO,userAccount);
                navigateAction.goToUpdateProfilePage(Constant.webDriver,testArchitectPO);
            LogReport.logMainStep("Verify UI items ");
            LogReport.logSubStep("Verify all fields");
                updateProfileAction.checkAllFieldsDisplayed(generalAction,updateProfilePO);
                updateProfileAction.checkAllErrorMsg(generalAction,Constant.webDriver,updateProfilePO);
        }
        catch (Exception exception){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }


    }
    /** Test case 2: Verify error message on field first name, last name
    *
    *
    *
    *
    * */
    @Test(priority = 2,
            testName = "Verify error message on field first name, last name ",
            description = "Verify error message on field first name, last name",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataForFieldNameUpdateProfilePage")
    public  void TC_2_Verify_Error_Message_On_Fields_FirstName_LastName(String textName,String textDisplay, String errorMsg){
        System.out.println("Test case 02: Verify validate on field required");
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UpdateProfilePO updateProfilePO = new UpdateProfilePO(Constant.webDriver);
        IGeneralAction generalAction = new GeneralAction();
        ILoginAction loginAction = new LoginAction();
        DataTestSSO dataTestSSO = new DataTestSSO();
        UpdateProfileAction updateProfileAction = new UpdateProfileAction();
        try{
            LogReport.logMainStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select options 'Manage My Profile' on the navigation bar");
            navigateAction.goToLoginPage(testArchitectPO);
            loginAction.loginSSO(loginPO,dataTestSSO.valid_account_update_profile);
            navigateAction.goToUpdateProfilePage(Constant.webDriver,testArchitectPO);
            LogReport.logMainStep("Verify input validate ");
            LogReport.logSubStep("Input values"+ textName);
            updateProfileAction.UpdateFields(updateProfilePO,textName);

            LogReport.logMainStep("4. Verify the error message display appropriate");
            if (errorMsg.equals("")){
                generalAction.verifyTextDisplay(textDisplay,updateProfilePO.inputFirstName,true);
                generalAction.verifyTextDisplay(textDisplay,updateProfilePO.inputLastName,true);


            }else {
                generalAction.verifyTextDisplay(errorMsg,updateProfilePO.labelErrorMsgFirstName,false);
                generalAction.verifyTextDisplay(errorMsg,updateProfilePO.labelErrorMsgLastName,false);

            }

        }
        catch (Exception exception){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

   /** Test case 3: Verify upload avatar
   *
   *
   *
   *
    **/
    @Test(priority = 3,
            testName = "Verify upload avatar",
            description = "Verify upload avatar",
            dataProviderClass = DataTestSSO.class
             )
    public void TC_3_Verify_UploadAvatar(){
        System.out.println("Test case 03: Verify upload avatar");
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        UpdateProfilePO updateProfilePO = new UpdateProfilePO(Constant.webDriver);
        IGeneralAction generalAction = new GeneralAction();
        ILoginAction loginAction = new LoginAction();
        DataTestSSO dataTestSSO = new DataTestSSO();
        UpdateProfileAction updateProfileAction = new UpdateProfileAction();
        try{
            LogReport.logMainStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select options 'Manage My Profile' on the navigation bar");
            navigateAction.goToLoginPage(testArchitectPO);
            loginAction.loginSSO(loginPO,dataTestSSO.valid_account_update_profile);
            navigateAction.goToUpdateProfilePage(Constant.webDriver,testArchitectPO);
            LogReport.logMainStep("Verify upload right image type");
            updateProfileAction.UploadAvatar(updateProfilePO,true);
            LogReport.logMainStep("Verify upload not image type ");
            updateProfileAction.UploadAvatar(updateProfilePO,false);



        }
        catch (Exception exception){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }

    }


}
