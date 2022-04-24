package SSO_project.action;

import SSO_project.page_object.ActiveAccountPO;
import org.openqa.selenium.WebDriver;

public interface IActiveAccountAction {
    void checkUIActiveAccountPage(WebDriver webDriver, ActiveAccountPO activeAccount);
    void submitActiveCode(ActiveAccountPO activeAccount, String invalidActiveCode);
}
