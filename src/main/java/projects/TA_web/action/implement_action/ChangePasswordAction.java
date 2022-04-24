package projects.TA_web.action.implement_action;

import SSO_project.entity.UserAccount;
import common.Constant;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.WebDriver;
import projects.TA_web.action.IChangePasswordAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.user_portal.ChangePasswordPO;

public class ChangePasswordAction implements IChangePasswordAction {
    @Override
    public void enterValueToCheckErrorMessage(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw) {
        changePwPO.inputPw.sendKeys(userAccount.getPassword());
        changePwPO.inputNewPw.sendKeys(newPw);
        changePwPO.inputConfirmPw.sendKeys(confirmPw);
        changePwPO.btnShowPw.click();
        changePwPO.btnShowNewPw.click();
        changePwPO.btnShowConfirmPw.click();
        changePwPO.h1Title.click();
    }

    @Override
    public void changePassword(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw) {
        changePwPO.inputPw.clear();
        changePwPO.inputNewPw.clear();
        changePwPO.inputConfirmPw.clear();
        changePwPO.inputPw.sendKeys(userAccount.getPassword());
        changePwPO.inputNewPw.sendKeys(newPw);
        changePwPO.inputConfirmPw.sendKeys(confirmPw);
        changePwPO.btnShowPw.click();
        changePwPO.btnShowNewPw.click();
        changePwPO.btnShowConfirmPw.click();
        changePwPO.btnSubmit.click();
    }

    @Override
    public void verifyTextLabelsDisplay(IGeneralAction generalAction, ChangePasswordPO changePasswordPO,
                                        DataTestTAWeb dataTest) {
        generalAction.verifyTextDisplay(dataTest.h1TitleChangePassword, changePasswordPO.h1Title, false);
        generalAction.verifyTextDisplay(dataTest.labelPassword, changePasswordPO.labelPw, false);
        generalAction.verifyTextDisplay(dataTest.labelNewPassword, changePasswordPO.labelNewPw, false);
        generalAction.verifyTextDisplay(dataTest.labelConfirmPw, changePasswordPO.labelConfirmPw, false);
    }

    @Override
    public void verifyButtonName(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, DataTestTAWeb dataTest) {
        generalAction.verifyTextDisplay(dataTest.btnSubmit, changePasswordPO.btnSubmit, false);
        generalAction.verifyTextDisplay(dataTest.btnCancel, changePasswordPO.btnCancel, false);
    }

    @Override
    public void verifyPlaceHolderTextDisplay(IGeneralAction generalAction, ChangePasswordPO changePasswordPO,
                                             DataTestTAWeb dataTest) {
        generalAction.verifyAttributeText(dataTest.placeholderTextForPw, changePasswordPO.inputPw, "placeholder");
        generalAction.verifyAttributeText(dataTest.placeholderTextForNewPw, changePasswordPO.inputNewPw, "placeholder");
        generalAction.verifyAttributeText(dataTest.placeholderTextForConfirmPw, changePasswordPO.inputConfirmPw, "placeholder");
    }

    @Override
    public void verifyAllErrorMessageHidden(IGeneralAction generalAction, WebDriver webDriver, ChangePasswordPO changePasswordPO) {
        generalAction.verifyElementHidden(changePasswordPO.labelErrorMessagePwBy, webDriver, "The error message for the field 'Password'");
        generalAction.verifyElementHidden(changePasswordPO.svgIconWarningPwBy, webDriver, "The icon 'Warning' for the field 'Password'");
        generalAction.verifyElementHidden(changePasswordPO.labelErrorMessageNewPwBy, webDriver, "The error message for the field 'New password'");
        generalAction.verifyElementHidden(changePasswordPO.svgIconWarningNewPwBy, webDriver, "The icon 'Warning' for the field 'New password'");
        generalAction.verifyElementHidden(changePasswordPO.labelErrorConfirmPwBy, webDriver, "The error message for the field 'Confirm password'");
        generalAction.verifyElementHidden(changePasswordPO.svgIconWarningConfirmPwBy, webDriver, "The icon 'Warning' for the field 'Confirm password'");
    }

    @Override
    public void verifyAllErrorMessageForEmptyFields(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, DataTestTAWeb dataTestTAWeb) {
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_field, changePasswordPO.labelErrorMessagePw, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_field, changePasswordPO.labelErrorMessageNewPw, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_field, changePasswordPO.labelErrorConfirmPw, false);
        generalAction.verifyElementDisplayed(changePasswordPO.svgIconWarningPw, "The icon 'Warning' for the field 'Password'");
        generalAction.verifyElementDisplayed(changePasswordPO.svgIconWarningNewPw, "The icon 'Warning' for the field 'New password'");
        generalAction.verifyElementDisplayed(changePasswordPO.svgIconWarningConfirmPw, "The icon 'Warning' for the field 'Confirm password'");
    }

    @Override
    public void verifyErrorMessageForPasswordDisplay(ChangePasswordPO changePwPO, String currentPw, String newPw, String errorMsgExpected) {
        IGeneralAction generalA = new GeneralAction();
        if (newPw.length() > 100){
            generalA.verifyTextDisplay(newPw.substring(0, 100), changePwPO.inputNewPw, true);
            generalA.verifyTextDisplay(newPw.substring(0, 100), changePwPO.inputConfirmPw, true);
        }else {
            generalA.verifyTextDisplay(errorMsgExpected, changePwPO.labelErrorMessageNewPw, false);
            generalA.verifyElementDisplayed(changePwPO.svgIconWarningNewPw, "The icon 'Warning' of the field 'New password'");
            generalA.verifyElementHidden(changePwPO.labelErrorConfirmPwBy, Constant.webDriver, "The error message for the field 'Confirm password'");
            generalA.verifyElementHidden(changePwPO.svgIconWarningConfirmPwBy, Constant.webDriver, "The icon 'Warning' for the field 'Confirm password'");
        }
    }

    @Override
    public void verifyErrorMessageDisplayProper(UserAccount userAccount, String newPw, String confirmPw, String errorMsgExpected) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalA = new GeneralAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);
        ChangePasswordAction changePasswordA = new ChangePasswordAction();

        if(errorMsgExpected.equals(dataTestTAWeb.error_msg_current_pw_wrong)){
            userAccount.setPassword(dataTestTAWeb.pw_activated_strong);
        }
        changePasswordA.enterValueToCheckErrorMessage(changePasswordPO, userAccount, newPw, confirmPw);

        for (int i = 0; i < 1; i++) {
            // 'New password', 'Confirm password' are empty
            if (newPw.equals("") && confirmPw.equals("")) {
                generalA.verifyTextDisplay(errorMsgExpected, changePasswordPO.labelErrorMessageNewPw, false);
                generalA.verifyElementDisplayed(changePasswordPO.svgIconWarningNewPw, "The icon 'Warning' of the field 'New password'");
                generalA.verifyTextDisplay(errorMsgExpected, changePasswordPO.labelErrorConfirmPw, false);
                generalA.verifyElementDisplayed(changePasswordPO.svgIconWarningConfirmPw, "The icon 'Warning' of the field 'Confirm password'");
            }
            // 'New password', 'Confirm password' are at the same
            else if (newPw.equals(confirmPw)) {
                // case 1: 'New password', 'Confirm password' and current password are at the same
                // case 2: 'New password', 'Confirm password' are at the same, and the current password is wrong
                // case 3: New pw length is greater than 100 letters
                // case 4: 'New password', 'Confirm password' are at the same and invalid
                if (newPw.equals(userAccount.getPassword()) || errorMsgExpected.equals(dataTestTAWeb.error_msg_current_pw_wrong)) {
                    changePasswordPO.btnSubmit.click();
//                    generalA.verifyTextDisplay(errorMsgExpected, changePasswordPO.divErrorMsgCurrentPw, false);
                } else if (newPw.length() > 100) {
                    generalA.verifyTextDisplay(newPw.substring(0, 100), changePasswordPO.inputNewPw, true);
                    generalA.verifyTextDisplay(newPw.substring(0, 100), changePasswordPO.inputConfirmPw, true);
                } else if (!errorMsgExpected.equals("")) {
                    generalA.verifyTextDisplay(errorMsgExpected, changePasswordPO.labelErrorMessageNewPw, false);
                    generalA.verifyElementDisplayed(changePasswordPO.svgIconWarningNewPw, "The icon 'Warning' of the field 'New password'");
                    generalA.verifyElementHidden(changePasswordPO.labelErrorConfirmPwBy, Constant.webDriver, "The error message for the field 'Confirm password'");
                    generalA.verifyElementHidden(changePasswordPO.svgIconWarningConfirmPwBy, Constant.webDriver, "The icon 'Warning' for the field 'Confirm password'");
                    continue;
                }
                generalA.verifyElementHidden(changePasswordPO.labelErrorMessageNewPwBy, Constant.webDriver, "The error message for the field 'New password'");
                generalA.verifyElementHidden(changePasswordPO.svgIconWarningNewPwBy, Constant.webDriver, "The icon 'Warning' for the field 'New password'");
                generalA.verifyElementHidden(changePasswordPO.labelErrorConfirmPwBy, Constant.webDriver, "The error message for the field 'Confirm password'");
                generalA.verifyElementHidden(changePasswordPO.svgIconWarningConfirmPwBy, Constant.webDriver, "The icon 'Warning' for the field 'Confirm password'");
            }
            // 'New password' and 'Confirm password' difference
            else {
                generalA.verifyElementHidden(changePasswordPO.labelErrorMessageNewPwBy, Constant.webDriver, "The error message for the field 'New password'");
                generalA.verifyElementHidden(changePasswordPO.svgIconWarningNewPwBy, Constant.webDriver, "The icon 'Warning' for the field 'New password'");
                generalA.verifyTextDisplay(errorMsgExpected, changePasswordPO.labelErrorConfirmPw, false);
                generalA.verifyElementDisplayed(changePasswordPO.svgIconWarningConfirmPw, "The icon 'Warning' of the field 'Confirm password'");
            }
        }
    }

    @Override
    public void verifyErrorMessageAfterSubmitValidValues
            (ChangePasswordPO changePasswordPO, UserAccount userAccount, String newPw, String errorMsgExpected) {
        IChangePasswordAction changePasswordA = new ChangePasswordAction();
        IGeneralAction generalA = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        if(errorMsgExpected.equals(dataTestTAWeb.error_msg_current_pw_wrong)){
            userAccount.setPassword(dataTestTAWeb.pw_activated_strong);
        }
        changePasswordA.changePassword(changePasswordPO, userAccount, newPw, newPw);
        generalA.verifyTextDisplay(errorMsgExpected, changePasswordPO.divAlertMessage, false);
        verifyAllErrorMessageHidden(generalA, Constant.webDriver, changePasswordPO);
    }

    @Override
    public void verifyErrorMessageWhenNewPwAndConfirmPwDifferences(IGeneralAction generalAction, ChangePasswordPO changePasswordPO, String errorMsgExpected) {
        generalAction.verifyTextDisplay(errorMsgExpected, changePasswordPO.labelErrorConfirmPw, false);
        generalAction.verifyElementDisplayed(changePasswordPO.svgIconWarningConfirmPw, "The icon 'Warning' for the field 'Confirm password'");
    }
}
