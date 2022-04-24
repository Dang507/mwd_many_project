package SSO_project.action.implement_action;

import SSO_project.action.IUpdateProfileAction;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.UpdateProfilePO;
import common.Constant;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateProfileAction implements IUpdateProfileAction {


    @Override
    // update pdf and image absolute file path corresponding to your PC
    public void UploadAvatar(UpdateProfilePO updateProfilePO, boolean isImage) {
        IGeneralAction generalAction = new GeneralAction();
        if (!isImage){
            updateProfilePO.uploadAvatar.sendKeys("D:\\mwd_many_project\\src\\main\\java\\SSO_project\\data_test\\Dashboard exercises 1.pdf");
            generalAction.verifyElementDisplayed(updateProfilePO.labelErrorMsgUploadImg,"Error message upload image");
        } else {
            updateProfilePO.uploadAvatar.sendKeys("D:\\mwd_many_project\\src\\main\\java\\SSO_project\\data_test\\superman.jpg  ");
            updateProfilePO.btnSubmit.click();

        }
    }

    @Override
    public void UpdateFields(UpdateProfilePO updateProfilePO, String textInput) {
        updateProfilePO.inputFirstName.clear();
        updateProfilePO.inputLastName.clear();
        updateProfilePO.inputFirstName.sendKeys(textInput);
        updateProfilePO.inputLastName.sendKeys(textInput);
        /**click any point on screen**/
        updateProfilePO.labelCompany.click();
    }


    @Override
    public  void checkAllFieldsDisplayed(IGeneralAction generalAction, UpdateProfilePO updateProfilePO){
        generalAction.verifyElementDisplayed(updateProfilePO.labelFirstName,"Label of field First Name");
        generalAction.verifyElementDisplayed(updateProfilePO.inputFirstName, "Input filed First Name");
        generalAction.verifyElementDisplayed(updateProfilePO.labelLastName, "Label of field Last Name");
        generalAction.verifyElementDisplayed(updateProfilePO.inputLastName,"Input field Last Name ");
        generalAction.verifyElementDisplayed(updateProfilePO.labelTitle, "Label of field Title");
        generalAction.verifyElementDisplayed(updateProfilePO.labelCompany,"Label of field Company");
        generalAction.verifyElementDisplayed(updateProfilePO.labelCountry,"Label of field Country");
        generalAction.verifyElementDisplayed(updateProfilePO.labelState,"Label of field State");
        generalAction.verifyElementDisplayed(updateProfilePO.labelPhone,"label of field Phone");
    }

    @Override
    public void checkAllErrorMsg(IGeneralAction generalAction,WebDriver webDriver, UpdateProfilePO updateProfilePO){
        generalAction.verifyElementHidden((By) updateProfilePO.labelErrorMsgFirstName, webDriver, "Error message on field First Name");
        generalAction.verifyElementHidden((By) updateProfilePO.labelErrorMsgLastName, webDriver, "Error message on field Last Name");
        generalAction.verifyElementHidden((By) updateProfilePO.labelErrorMsgPhone, webDriver, "Error message on field Phone");

    }

}
