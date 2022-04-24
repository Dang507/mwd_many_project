package SSO_project.action.implement_action;

import SSO_project.action.IForgotPwAction;

import SSO_project.page_object.ForgotPwPO;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;

public class ForgotPasswordAction implements IForgotPwAction {
    @Override
    public void checkForgotPwPageGUI(ForgotPwPO forgotPwPO) {
        IGeneralAction generalA = new GeneralAction();
        generalA.verifyElementDisplayed(forgotPwPO.imgLogoLogiGear, "The logo image 'LogiGear'");
        generalA.verifyElementDisplayed(forgotPwPO.h1Title, "The title of page 'Forgot password'");
        generalA.verifyElementDisplayed(forgotPwPO.labelEmail, "The label 'Email'");
        generalA.verifyElementEnable(forgotPwPO.inputEmail, "The field 'Email' ");
        generalA.verifyElementDisplayed(forgotPwPO.btnSubmit, "The button 'Submit' ");
        generalA.verifyElementDisplayed(forgotPwPO.lnkSignIn, "The link 'Sign in' ");
    }

    @Override
    public void submitRequestGetPassword(ForgotPwPO forgotPwPO, String email) {
        forgotPwPO.inputEmail.clear();
        forgotPwPO.inputEmail.sendKeys(email);
        forgotPwPO.btnSubmit.click();
    }
}
