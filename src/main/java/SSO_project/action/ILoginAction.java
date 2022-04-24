package SSO_project.action;

import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import org.openqa.selenium.WebDriver;

public interface ILoginAction {
    void checkLoginPageGUI(LoginPO loginPO);
    void loginSSO(LoginPO loginPO, UserAccount userAccount);
    void loginWithInvalidAccounts(LoginPO loginPO, String email, String password);
    void loginWithRememberMe(WebDriver webDriver, UserAccount userAccount);
    void loginAgainByRememberMe(WebDriver webDriver);
}
