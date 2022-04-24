package projects.TA_web.action;

import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public interface IDeleteCouponTypeAction {
    void verifyUIItemsDeleteDialog(ManageCouponTypePO manageCouponTypePO, CouponType couponType);
    void verifyDeleteCouponType(ManageCouponTypePO manageCouponTypePO, WebDriver webDriver, CouponType couponType);
    void clickDeleteIconOfACouponType(WebDriver webDriver, CouponType couponType);
}

//    void verifyDeleteManyCouponType(WebDriver webDriver, int number, CouponType couponType) throws InterruptedException;
