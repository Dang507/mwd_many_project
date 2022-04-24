package SSO_project.action.implement_action;

import SSO_project.action.IChangePwAction;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.ChangePwPO;

public class ChangePasswordAction implements IChangePwAction {
    @Override
    public void checkErrorMsgOfChangePwPage(ChangePwPO changePwPO, UserAccount userAccount, String newPw, String confirmPw) {
        changePwPO.inputOldPw.sendKeys(userAccount.getPassword());
        changePwPO.inputNewPw.sendKeys(newPw);
        changePwPO.inputConfirmPw.sendKeys(confirmPw);
        changePwPO.btnShowOldPw.click();
        changePwPO.btnShowNewPw.click();
        changePwPO.btnShowConfirmPw.click();
        changePwPO.h1Title.click();
    }

    @Override
    public void changePw(ChangePwPO changePwPO, UserAccount userAccount, String newPw, String confirmPw) {
        changePwPO.inputOldPw.sendKeys(userAccount.getPassword());
        changePwPO.btnShowOldPw.click();
        changePwPO.inputNewPw.sendKeys(newPw);
        changePwPO.btnShowNewPw.click();
        changePwPO.inputConfirmPw.sendKeys(confirmPw);
        changePwPO.btnShowConfirmPw.click();
        changePwPO.btnSubmit.click();
    }


}
