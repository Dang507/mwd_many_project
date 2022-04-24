package projects.TA_web.action.implement_action;

import common.Constant;
import common.ISSOUtilA;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.WebElement;
import projects.TA_web.action.IAddCouponTypeAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public class AddCouponTypeAction implements IAddCouponTypeAction {

    @Override
    public void verifyAllLabelsAndTitle(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.labelName, addCouponTypePO.labelName, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelLimit, addCouponTypePO.labelLimit, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelStatus, addCouponTypePO.labelStatus, false);
    }

    @Override
    public void verifyAllInputFields(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO) {
        generalAction.verifyElementDisplayed(addCouponTypePO.inputName, "The input field 'Name'");
        generalAction.verifyElementDisplayed(addCouponTypePO.inputLimit, "The input field 'Limit'");
        generalAction.verifyElementDisplayed(addCouponTypePO.divSelectStatus, "The selection field 'Status'");
        generalAction.verifyElementDisplayed(addCouponTypePO.labelBtnUploadImage, "The button 'Upload image'");
    }

    @Override
    public void verifyAllButton(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.btnSave, addCouponTypePO.btnSave, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.btnCancel, addCouponTypePO.btnCancel, false);
    }

    @Override
    public void verifyThumbnailImage(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO) {
        generalAction.verifyElementDisplayed(addCouponTypePO.imgImageDisplay, "The thumbnail image of the coupon type");
    }

    @Override
    public void verifyErrorMsgFieldName(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg) {
        IGeneralAction generalAction = new GeneralAction();
        if (!errorMsg.equals("")){
            generalAction.verifyTextDisplay(errorMsg, addCouponTypePO.labelErrorMsgForName, false);
            generalAction.verifyElementDisplayed(addCouponTypePO.svgIconWarningForName, "The icon 'Warning' for the field 'Name'");
        }else {
            generalAction.verifyAttributeText(expectedText, addCouponTypePO.inputName, "value");
            generalAction.verifyElementHidden(addCouponTypePO.svgIconWarningForNameBy, Constant.webDriver, "The icon 'Warning' for the field 'Name'");
            generalAction.verifyElementHidden(addCouponTypePO.labelErrorMsgForNameBy, Constant.webDriver, "The error message for the field 'Name'");
        }
    }

    @Override
    public void verifyErrorMsgFieldLimit(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg) {
        IGeneralAction generalAction = new GeneralAction();
        if (!errorMsg.equals("")){
            generalAction.verifyTextDisplay(errorMsg, addCouponTypePO.labelErrorMsgForLimit, false);
            generalAction.verifyElementDisplayed(addCouponTypePO.svgIconWarningForLimit, "The icon 'Warning' for the field 'Limit'");
        }else {
            generalAction.verifyAttributeText(expectedText, addCouponTypePO.inputLimit, "value");
            generalAction.verifyElementHidden(addCouponTypePO.getSvgIconWarningForLimitBy, Constant.webDriver, "The icon 'Warning' for the field 'Limit'");
            generalAction.verifyElementHidden(addCouponTypePO.labelErrorMsgForLimitBy, Constant.webDriver, "The error message for the field 'Limit'");
        }
    }

    @Override
    public void addNewCouponType(AddCouponTypePO addCouponTypePO, CouponType couponType) {
        String couponStatus = couponType.getStatus();
        addCouponTypePO.inputName.clear();
        addCouponTypePO.inputLimit.clear();
        addCouponTypePO.inputName.sendKeys(couponType.getName());
        addCouponTypePO.inputLimit.sendKeys(couponType.getLimit());
        addCouponTypePO.divSelectStatus.click();
        for (WebElement element : addCouponTypePO.liStatusOptions) {
            if(couponStatus.equals(element.getText())){
                element.click();
                break;
            }
        }
        addCouponTypePO.btnSave.click();
    }

    @Override
    public void addNewCouponTypeWithImage(AddCouponTypePO addCouponTypePO, CouponType couponType) throws InterruptedException {
        ISSOUtilA utilA = new SSOUtilImpA();
        addCouponTypePO.inputUploadImage.sendKeys(couponType.getImageLink());
        addCouponTypePO.inputName.clear();
        addCouponTypePO.inputLimit.clear();
        addCouponTypePO.inputName.sendKeys(couponType.getName());
        addCouponTypePO.inputLimit.sendKeys(couponType.getLimit());
        addCouponTypePO.divSelectStatus.click();
        utilA.setThreadSleep(5000);
        String couponStatus = couponType.getStatus();
        for (WebElement element : addCouponTypePO.liStatusOptions) {
            if(couponStatus.equals(element.getText())){
                element.click();
            }
        }
        addCouponTypePO.btnSave.click();
    }

    @Override
    public void verifyAddNewCouponTypeSuccess(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyElementDisplayed(addCouponTypePO.imgImageDisplay, "The image thumbnail");
        generalAction.verifyTextDisplay(dataTestTAWeb.success_msg_add_coupon_type, addCouponTypePO.divAlertMessage
                , false);
    }

    @Override
    public void verifyAllErrorMsgForEmptyFields(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_field, addCouponTypePO.labelErrorMsgForName, false);
        generalAction.verifyElementDisplayed(addCouponTypePO.svgIconWarningForName, "The icon 'Warning' for the field 'Name'");
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_field, addCouponTypePO.labelErrorMsgForLimit, false);
        generalAction.verifyElementDisplayed(addCouponTypePO.svgIconWarningForLimit, "The icon 'Warning' for the field 'Limit'");
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_image_field, addCouponTypePO.labelErrorMsgImage, false);
    }

    @Override
    public void verifyAllPlaceholderTexts(AddCouponTypePO addCouponTypePO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalAction = new GeneralAction();
        generalAction.verifyAttributeText(dataTestTAWeb.placeholderTextForName, addCouponTypePO.inputName, "placeholder");
    }

    @Override
    public void addManyCouponTypes(ManageCouponTypePO manageCouponTypePO, AddCouponTypePO addCouponTypePO, int number, CouponType couponType)
            throws InterruptedException {
        ISSOUtilA utilA = new SSOUtilImpA();
        for (int i = 0; i < number; i++){
            couponType.setName(couponType.getName() + utilA.createRandomIntegerNumber(100));
            couponType.setLimit(couponType.getLimit() + utilA.createRandomIntegerNumber(100));
            if(couponType.getStatus().equals("Active")){
                couponType.setStatus("In-Active");
            }else {
                couponType.setStatus("Active");
            }
            utilA.setThreadSleep(5000);
            manageCouponTypePO.btnAdd.click();
            addNewCouponTypeWithImage(addCouponTypePO, couponType);
        }
    }

}
