package SSO_project.action.implement_action;

import SSO_project.action.IResetPasswordAction;
import SSO_project.page_object.ResetPasswordPO;

public class ResetPasswordAction implements IResetPasswordAction {
    @Override
    public void checkValueToResetPassword(ResetPasswordPO resetPasswordPO, String newPw, String confirmPw) {
        resetPasswordPO.inputPw.sendKeys(newPw);
        resetPasswordPO.btnShowPw.click();
        resetPasswordPO.inputConfirmPw.sendKeys(confirmPw);
        resetPasswordPO.btnShowConfirmPw.click();
        resetPasswordPO.h1Title.click();
    }

    @Override
    public void resetPassword(ResetPasswordPO resetPasswordPO, String newPw, String confirmPw) {
        resetPasswordPO.inputPw.sendKeys(newPw);
        resetPasswordPO.btnShowPw.click();
        resetPasswordPO.inputConfirmPw.sendKeys(confirmPw);
        resetPasswordPO.btnShowConfirmPw.click();
        resetPasswordPO.btnSubmit.click();
    }

    @Override
    public void checkUIPageResetPassword() {

    }
}
