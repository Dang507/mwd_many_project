package SSO_project.action;

import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import org.openqa.selenium.WebDriver;

public interface INavigateAction {
    void goToLoginPage(TestArchitectPO testArchitectPO);
    void goToForgotPasswordPage(TestArchitectPO testArchitectPO, LoginPO loginPO);
    void goToRegisterPage(TestArchitectPO testArchitectPO, LoginPO loginPO);
    void gotoTAPage();
    void gotoChangePwPageAfterLogin(WebDriver webDriver, TestArchitectPO testArchitectPO);
    void goToResetPasswordPage();
}
