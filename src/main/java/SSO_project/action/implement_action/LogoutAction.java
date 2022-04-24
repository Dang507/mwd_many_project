package SSO_project.action.implement_action;

import SSO_project.action.ILogoutAction;
import SSO_project.page_object.TestArchitectPO;

public class LogoutAction implements ILogoutAction {
    @Override
    public void logoutCurrentAccount(TestArchitectPO testArchitectPO) {
        testArchitectPO.accountName.click();
        testArchitectPO.optLogout.click();
    }
}
