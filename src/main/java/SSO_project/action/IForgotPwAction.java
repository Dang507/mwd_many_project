package SSO_project.action;

import SSO_project.page_object.ForgotPwPO;

public interface IForgotPwAction {
    void checkForgotPwPageGUI(ForgotPwPO forgotPwPO);
    void submitRequestGetPassword(ForgotPwPO forgotPwPO, String email);
}
