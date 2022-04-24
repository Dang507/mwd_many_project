package SSO_admin_portal.action.implement_action;

import SSO_admin_portal.action.IAddUserAction;
import SSO_admin_portal.page_object.UserManagementPO;
import SSO_project.entity.UserAccount;
import common.ISSOUtilA;
import common.SSOUtilImpA;

public class AddUserImpA implements IAddUserAction {

    @Override
    public void enterValuesToAddNewUser(UserManagementPO userManagement, UserAccount userAccount) {
        ISSOUtilA ssoUtilA = new SSOUtilImpA();
        userManagement.inputFirstName.sendKeys(userAccount.getFirstName());
        ssoUtilA.selectOptionByText(userManagement.selectCountry, userAccount.getCountry());
        userManagement.inputLastName.sendKeys(userAccount.getLastName());
        userManagement.inputEmail.sendKeys(userAccount.getEmail());
        userManagement.inputPw.sendKeys(userAccount.getPassword());
        userManagement.inputConfirmpw.sendKeys(userAccount.getConfirmPw());
        userManagement.inputTitle.sendKeys(userAccount.getTitle());
        userManagement.inputCompany.sendKeys(userAccount.getCompany());
        userManagement.inputPhone.sendKeys(userAccount.getPhone());
        ssoUtilA.selectOptionByText(userManagement.selectState, userAccount.getState());
    }

    // dang implement o day
}
