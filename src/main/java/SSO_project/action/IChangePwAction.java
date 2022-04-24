package SSO_project.action;

import SSO_project.entity.UserAccount;
import SSO_project.page_object.ChangePwPO;

public interface IChangePwAction {
    void checkErrorMsgOfChangePwPage(ChangePwPO changePwPO, UserAccount userAccount, String newPw, String confirmPw);
    void changePw(ChangePwPO changePwPO, UserAccount userAccount, String newPw, String confirmPw);

}
