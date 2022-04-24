package SSO_project.action;

import SSO_project.page_object.ResetPasswordPO;

public interface IResetPasswordAction {
    void checkValueToResetPassword(ResetPasswordPO resetPasswordPO, String newPw, String confirmPw);
    void resetPassword(ResetPasswordPO resetPasswordPO, String newPw, String confirmPw);
    void checkUIPageResetPassword();

}
