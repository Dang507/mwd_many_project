package SSO_admin_portal.action;

import SSO_admin_portal.page_object.GeneralPO;
import org.openqa.selenium.WebDriver;

public interface INavigateAction {
    void goToPopUpAddUser(WebDriver webDriver, GeneralPO generalPO);
}
