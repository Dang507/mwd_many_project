package projects.TA_web.action;

import SSO_project.entity.UserAccount;
import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.user_portal.ChangePasswordPO;

public interface IChangePasswordAction {
    void enterValueToCheckErrorMessage(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw);
    void changePassword(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw);
    void verifyTextLabelsDisplay(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, DataTestTAWeb dataTest);
    void verifyButtonName(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, DataTestTAWeb dataTest);
    void verifyPlaceHolderTextDisplay(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, DataTestTAWeb dataTest);
    void verifyAllErrorMessageHidden(IGeneralAction generalAction, WebDriver webDriver, ChangePasswordPO changePasswordPO);
    void verifyAllErrorMessageForEmptyFields(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, DataTestTAWeb dataTestTAWeb);
    void verifyErrorMessageForPasswordDisplay(ChangePasswordPO changePwPO, String currentPw, String newPw, String errorMsgExpected);
    void verifyErrorMessageDisplayProper(UserAccount userAccount, String newPw, String confirmPw, String errorMsgExpected);
    void verifyErrorMessageAfterSubmitValidValues(ChangePasswordPO changePasswordPO, UserAccount userAccount, String newPw, String errorMsgExpected);
    void verifyErrorMessageWhenNewPwAndConfirmPwDifferences(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, String errorMsgExpected);

}
