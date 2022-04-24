package SSO_project.action;

import SSO_project.page_object.UpdateProfilePO;
import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;

public interface IUpdateProfileAction {

    void UploadAvatar (UpdateProfilePO updateProfilePO,boolean isImage);
    void UpdateFields(UpdateProfilePO updateProfilePO,String textInput);
    void checkAllFieldsDisplayed(IGeneralAction generalAction, UpdateProfilePO updateProfilePO);
    void checkAllErrorMsg(IGeneralAction generalAction, WebDriver webDriver, UpdateProfilePO updateProfilePO);
}
