package SSO_project.action;

import SSO_project.entity.UserAccount;
import SSO_project.page_object.SignUpPO;
import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;

public interface ISignUpAction {
    void createSSOAccount(SignUpPO signUpPO, UserAccount userAccount) throws InterruptedException;
    void checkAllFieldsDisplayOnFirstForm(IGeneralAction generalA, SignUpPO signUpPO);
    void checkAllErrorMsgAndIconsHideOnFirstForm(WebDriver webDriver, IGeneralAction generalA, SignUpPO signUpPO);
    void checkAllErrorMsgAndIconsDisplayOnFirstForm(IGeneralAction generalA, SignUpPO signUpPO);
    void checkAllFieldsDisplayOnFinalForm(IGeneralAction generalA, SignUpPO signUpPO);
    void checkAllErrorMsgAndIconsHideOnFinalForm(WebDriver webDriver, IGeneralAction generalA, SignUpPO signUpPO);
    void checkAllErrorMsgAndIconsDisplayOnFinalForm(IGeneralAction generalA, SignUpPO signUpPO, String invalidPhone);
    void goToFinalForm(SignUpPO signUpPO, UserAccount userAccount);
    void enterValuesToFirstForm(SignUpPO signUpPO, UserAccount userAccount);
    void enterValuesToFinalForm(SignUpPO signUpPO, UserAccount userAccount) throws InterruptedException;
}
