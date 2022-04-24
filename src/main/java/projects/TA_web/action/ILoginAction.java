package projects.TA_web.action;

import SSO_project.entity.UserAccount;
import projects.TA_web.page_object.user_portal.LoginOn23ServerPO;

public interface ILoginAction {
    void loginSSO(LoginOn23ServerPO loginPO, UserAccount userAccount);
}
