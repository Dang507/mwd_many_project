package SSO_project.action.implement_action;

import SSO_project.action.IActiveAccountAction;
import SSO_project.page_object.ActiveAccountPO;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.WebDriver;

public class ActiveAccountAction implements IActiveAccountAction {

    @Override
    public void checkUIActiveAccountPage(WebDriver webDriver, ActiveAccountPO activeAccount) {
        IGeneralAction generalA = new GeneralAction();
        generalA.verifyElementEnable(activeAccount.inputActiveCode, "The input field 'Active code'");
        generalA.verifyElementEnable(activeAccount.btnActiveAccount, "The button 'Activate your account'");
        generalA.verifyElementEnable(activeAccount.aHere, "The link 'here'");
        generalA.verifyElementDisplayed(activeAccount.imgLogoTrust, "The logo image 'Trust'");
        generalA.verifyElementHidden(activeAccount.labelErrorActiveCodeBy, webDriver
                , "The label error of the field 'Active code'");
        generalA.verifyElementHidden(activeAccount.svgIconWarningActiveCodeBy, webDriver
                , "The icon 'Warning' of the field 'Active code'");
        generalA.verifyElementHidden(activeAccount.divErrorInvalidCodeBy, webDriver,
                "The error text for the invalid active code");
    }

    @Override
    public void submitActiveCode(ActiveAccountPO activeAccount, String invalidActiveCode) {
        activeAccount.inputActiveCode.sendKeys(invalidActiveCode);
        activeAccount.btnActiveAccount.click();
    }
}
