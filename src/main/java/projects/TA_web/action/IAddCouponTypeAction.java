package projects.TA_web.action;

import general_action.IGeneralAction;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public interface IAddCouponTypeAction {
    void verifyAllLabelsAndTitle(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO);
    void verifyAllInputFields(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO);
    void verifyAllButton(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO);
    void verifyThumbnailImage(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO);
    void verifyErrorMsgFieldName(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg);
    void verifyErrorMsgFieldLimit(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg);
    void addNewCouponType(AddCouponTypePO addCouponTypePO, CouponType couponType) throws InterruptedException;
    void addNewCouponTypeWithImage(AddCouponTypePO addCouponTypePO, CouponType couponType) throws InterruptedException;
    void verifyAddNewCouponTypeSuccess(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO);
    void verifyAllErrorMsgForEmptyFields(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO);
    void verifyAllPlaceholderTexts(AddCouponTypePO addCouponTypePO);
    void addManyCouponTypes(ManageCouponTypePO manageCouponTypePO, AddCouponTypePO addCouponTypePO, int number, CouponType couponType) throws InterruptedException;


}
