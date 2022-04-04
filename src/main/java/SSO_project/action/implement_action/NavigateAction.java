package SSO_project.action.implement_action;

import SSO_project.action.INavigateAction;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import common.Constant;
import common.ISSOUtilA;
import common.SSOUtilImpA;
import common.URL;
import org.openqa.selenium.WebDriver;

public class NavigateAction implements INavigateAction {

    @Override
    public void gotoTAPage() {
        Constant.webDriver.get(URL.taURL);
    }

    @Override
    public void goToLoginPage(TestArchitectPO testArchitectPO) {
        Constant.webDriver.navigate().to(URL.taURL);
        testArchitectPO.btnLogin.click();
    }

    @Override
    public void goToForgotPasswordPage(TestArchitectPO testArchitectPO, LoginPO loginPO) {
        Constant.webDriver.navigate().to(URL.taURL);
        testArchitectPO.btnLogin.click();
        loginPO.linkForgotPw.click();
    }

    @Override
    public void goToRegisterPage(TestArchitectPO testArchitectPO, LoginPO loginPO) {
        Constant.webDriver.navigate().to(URL.taURL);
        testArchitectPO.btnLogin.click();
        loginPO.linkSignUp.click();
    }

    @Override
    public void gotoChangePwPageAfterLogin(WebDriver webDriver, TestArchitectPO testArchitectPO) {
        ISSOUtilA ssoUtilA = new SSOUtilImpA();
        ssoUtilA.waitElementInteraction(webDriver, testArchitectPO.accountName, 50);
        ssoUtilA.hoverMenuAndClickItem(webDriver, testArchitectPO.accountName, testArchitectPO.optChangePw);
    }

    @Override
    public void goToResetPasswordPage() {
        Constant.webDriver.navigate().to(URL.resetPwSSOUrl);
    }
}
