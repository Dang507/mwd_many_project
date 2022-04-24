package projects.TA_web.action;

import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;
import projects.TA_web.page_object.user_portal.EditProfilePO;

public interface IEditProfileAction {

    void UploadAvatar (EditProfilePO editProfilePO,boolean isImage) throws InterruptedException;
    void UpdateFields (EditProfilePO editProfilePO, String textInput);
    void checkAllFieldsDisplayed(IGeneralAction generalAction, EditProfilePO editProfilePO);
    void checkAllErrorMsg(IGeneralAction generalAction, WebDriver webDriver,EditProfilePO editProfilePO );
}
