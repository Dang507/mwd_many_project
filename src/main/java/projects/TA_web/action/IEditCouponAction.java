package projects.TA_web.action;

import general_action.IGeneralAction;
import projects.TA_web.entity.Coupon;
import projects.TA_web.page_object.admin_portal.EditCouponPO;
import projects.TA_web.page_object.admin_portal.EditCouponTypePO;

public interface IEditCouponAction {
    void ClearFields(EditCouponPO editCouponPO) throws InterruptedException;
    void DynamicData (EditCouponPO editCouponPO,String text);
    void checkAllFieldsDisplayed(IGeneralAction generalAction, EditCouponPO editCouponPO) throws InterruptedException;
    void verifyAllErrorMsgForEmptyFields(IGeneralAction generalAction, EditCouponPO editCouponPO);

    void verifyAllErrorMsgFields(EditCouponPO editCouponPO,String expectedText, String errorMsg);
}
