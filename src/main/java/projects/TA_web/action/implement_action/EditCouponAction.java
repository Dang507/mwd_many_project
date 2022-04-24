package projects.TA_web.action.implement_action;

import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.By;
import projects.TA_web.action.IEditCouponAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.admin_portal.EditCouponPO;

public class EditCouponAction implements IEditCouponAction {
    @Override
    public void ClearFields(EditCouponPO editCouponPO) throws InterruptedException {
        editCouponPO.inputDuration.clear();
        editCouponPO.inputName.clear();
        editCouponPO.inputPoint.clear();
        editCouponPO.inputValue.clear();
    }

    @Override
    public void DynamicData(EditCouponPO editCouponPO, String text) {

        editCouponPO.typeCouponOpts.findElements(By.xpath(text));
    }

    @Override
    public void checkAllFieldsDisplayed(IGeneralAction generalAction, EditCouponPO editCouponPO) throws InterruptedException {

        generalAction.verifyElementDisplayed(editCouponPO.couponTitle,"Coupon title is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelDuration,"label Duration is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelName,"label Name is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelPoint,"label Point is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelPresentee,"label Presentee is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelStatus,"label Status is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelType,"label Type is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelUnitDuration,"label Unit Duration is ");
        generalAction.verifyElementDisplayed(editCouponPO.labelValue,"label Value is ");
        generalAction.verifyElementDisplayed(editCouponPO.inputDuration,"Duration input field is ");
        generalAction.verifyElementDisplayed(editCouponPO.inputName,"Name input field is ");
        generalAction.verifyElementDisplayed(editCouponPO.inputPoint,"Point input field is ");
        generalAction.verifyElementDisplayed(editCouponPO.inputValue,"Value input field is ");
        generalAction.verifyElementDisplayed(editCouponPO.inputUnitTimes,"Unit times options field is ");
        generalAction.verifyElementDisplayed(editCouponPO.typeCouponOpts,"Type of coupon  field is ");
        generalAction.verifyElementDisplayed(editCouponPO.btnPresenteeNo,"No radio button is ");
        generalAction.verifyElementDisplayed(editCouponPO.btnPresenteeYes,"Yes radio button is ");
        generalAction.verifyElementDisplayed(editCouponPO.btnSave,"Button Save is ");
        generalAction.verifyElementDisplayed(editCouponPO.btnCancel,"Button Cancel is ");

    }

    @Override
    public void verifyAllErrorMsgForEmptyFields(IGeneralAction generalAction, EditCouponPO editCouponPO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_field,editCouponPO.labelErrorMsgForName,false);
    }



    @Override
    public void verifyAllErrorMsgFields(EditCouponPO editCouponPO, String expectedText, String errorMsg) {
         IGeneralAction generalAction = new GeneralAction();
        if (!errorMsg.equals("")){
            generalAction.verifyTextDisplay(errorMsg, editCouponPO.labelErrorMsgForName, false);
        }else {
            generalAction.verifyAttributeText(expectedText, editCouponPO.inputName, "value");
        }

    }
}
