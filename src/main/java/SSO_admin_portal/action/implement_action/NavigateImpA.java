package SSO_admin_portal.action.implement_action;

import SSO_admin_portal.action.INavigateAction;
import SSO_admin_portal.page_object.GeneralPO;
import common.URL;
import org.openqa.selenium.WebDriver;

public class NavigateImpA implements INavigateAction {

    @Override
    public void goToPopUpAddUser(WebDriver webDriver, GeneralPO generalPO) {
        webDriver.navigate().to(URL.adminPortalURL);
        generalPO.spanUserManagement.click();
        generalPO.btnAdd.click();
    }
}
