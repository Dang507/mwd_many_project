package projects.TA_web.action;

import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.WebElement;
import projects.TA_web.entity.Coupon;
import projects.TA_web.page_object.admin_portal.AddCouponPO;
import projects.TA_web.page_object.admin_portal.EditCouponPO;

import java.util.function.Function;

public interface IAddCouponAction {

    void verifyAllLabelsOnFormCoupon(AddCouponPO addCouponPO, IGeneralAction generalAction);

    void verifyAllFieldsOnFormCoupon(AddCouponPO addCouponPO, IGeneralAction generalAction);

    void ClearFields(AddCouponPO addCouponPO);

    void verifyAllButtonsNames(AddCouponPO addCouponPO, IGeneralAction generalAction);

    void verifyAllErrorMsgForEmptyFields(IGeneralAction generalAction,AddCouponPO addCouponPO);

    void verifyAllErrorMsgFields(AddCouponPO addCouponPO, String expectedText, String errorMsg);

    void AddCoupon (AddCouponPO addCouponPO, Coupon coupon,Coupon coupon2) throws InterruptedException;




}
