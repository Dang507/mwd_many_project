package projects.TA_web.action;

import org.openqa.selenium.WebDriver;
import projects.TA_web.page_object.user_portal.LeaveAMessagePO;
import projects.TA_web.page_object.user_portal.UserPortalPO;

public interface INavigateAction {
    void goToLeaveAMessagePage(WebDriver webDriver, UserPortalPO userPortalPO) ;

}