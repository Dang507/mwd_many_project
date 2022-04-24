package SSO_admin_portal.action;

import SSO_admin_portal.page_object.UserManagementPO;
import SSO_project.entity.UserAccount;

public interface IAddUserAction {
    void enterValuesToAddNewUser(UserManagementPO userManagement, UserAccount userAccount);


}
