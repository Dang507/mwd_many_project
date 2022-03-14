package projects.TA_web.action.implement_action;

import SSO_project.entity.UserAccount;
import projects.TA_web.action.ILoginAction;
import projects.TA_web.page_object.user_portal.LoginPO;

public class LoginAction implements ILoginAction {

    @Override
    public void loginSSO(LoginPO loginPO, UserAccount userAccount) {
        loginPO.inputEmail.sendKeys(userAccount.getEmail());
        loginPO.inputPassword.sendKeys(userAccount.getPassword());
        loginPO.btnLogin.click();
    }
}
