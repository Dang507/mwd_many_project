package projects.TA_web.action.implement_action;

import common.ISSOUtilA;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.WebElement;
import projects.TA_web.action.IEditCouponTypeAction;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.EditCouponTypePO;

public class EditCouponTypeAction implements IEditCouponTypeAction {
    @Override
    public void verifyValueCouponTypeExisted(EditCouponTypePO editCouponTypePO, CouponType couponType) {
        IGeneralAction generalAction = new GeneralAction();
        generalAction.verifyTextDisplay(couponType.getName(), editCouponTypePO.inputName, true);
        generalAction.verifyTextDisplay(couponType.getLimit(), editCouponTypePO.inputLimit, true);
        generalAction.verifyTextDisplay(couponType.getStatus(), editCouponTypePO.divSelectStatus, false);
    }

    @Override
    public void updateCouponType(EditCouponTypePO editCouponTypePO, CouponType couponType) {
        String couponStatus = couponType.getStatus();
        editCouponTypePO.inputName.clear();
        editCouponTypePO.inputLimit.clear();
        editCouponTypePO.inputName.sendKeys(couponType.getName());
        editCouponTypePO.inputLimit.sendKeys(couponType.getLimit());
        editCouponTypePO.divSelectStatus.click();
        for (WebElement element : editCouponTypePO.liStatusOptions) {
            if(couponStatus.equals(element.getText())){
                element.click();
                break;
            }
        }
        editCouponTypePO.inputUploadImage.sendKeys(couponType.getImageLink());
        editCouponTypePO.btnSave.click();
    }
}
