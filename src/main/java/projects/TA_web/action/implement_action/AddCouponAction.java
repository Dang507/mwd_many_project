package projects.TA_web.action.implement_action;

import common.Constant;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import projects.TA_web.action.IAddCouponAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.Coupon;
import projects.TA_web.page_object.admin_portal.AddCouponPO;
import projects.TA_web.page_object.admin_portal.EditCouponPO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddCouponAction implements IAddCouponAction {

    @Override
    public void verifyAllLabelsOnFormCoupon(AddCouponPO addCouponPO, IGeneralAction generalAction) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.labelName, addCouponPO.labelName, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelType, addCouponPO.labelType, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelValue, addCouponPO.labelValue, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelUnitFirst, addCouponPO.labelUnitFirst, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelPoint, addCouponPO.labelPoint, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelDuration, addCouponPO.labelDuration, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelUnitFirst, addCouponPO.labelUnitDuration, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelStatus, addCouponPO.labelStatus, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelPresentee, addCouponPO.labelPresentee, false);
    }

    @Override
    public void verifyAllFieldsOnFormCoupon(AddCouponPO addCouponPO, IGeneralAction generalAction) {
        generalAction.verifyElementDisplayed(addCouponPO.inputName, "The input field 'Name'");
        generalAction.verifyElementDisplayed(addCouponPO.inputDuration,"The input field 'Duration'");
        generalAction.verifyElementDisplayed(addCouponPO.inputPoint,"The input field 'Point'");
        generalAction.verifyElementDisplayed(addCouponPO.inputValue,"The input field 'Value'");
        generalAction.verifyElementDisplayed(addCouponPO.inputRadioBtnNo,"The input radio button 'No'");
        generalAction.verifyElementDisplayed(addCouponPO.inputRadioBtnYes,"The input radio button 'Yes'");

    }

    @Override
    public void ClearFields(AddCouponPO addCouponPO) {
        addCouponPO.inputDuration.clear();
        addCouponPO.inputName.clear();
        addCouponPO.inputPoint.clear();
        addCouponPO.inputValue.clear();
    }

    @Override
    public void verifyAllButtonsNames(AddCouponPO addCouponPO, IGeneralAction generalAction) {
        generalAction.verifyTextDisplay("Save",addCouponPO.btnSave,false);
        generalAction.verifyTextDisplay("Cancel",addCouponPO.btnCancel,false);

    }

    @Override
    public void verifyAllErrorMsgForEmptyFields(IGeneralAction generalAction, AddCouponPO addCouponPO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.error_msg_empty_field,addCouponPO.labelErrorMsgForName,false);
    }

    @Override
    public void verifyAllErrorMsgFields(AddCouponPO addCouponPO, String expectedText, String errorMsg) {
        IGeneralAction generalAction = new GeneralAction();
        if (!errorMsg.equals("")){
            generalAction.verifyTextDisplay(errorMsg, addCouponPO.labelErrorMsgForName, false);
        }else {
            generalAction.verifyAttributeText(expectedText, addCouponPO.inputName, "value");
        }
    }

    @Override
    public void AddCoupon(AddCouponPO addCouponPO, Coupon coupon, Coupon coupon2) throws InterruptedException {
        String CouponType = coupon2.getCuoponType();
        String CouponStatus = coupon2.getStatus();
        String UnitName = coupon2.getUnitName();
        String UnitNameTimes = coupon2.getUnitNameTimes();
        SSOUtilImpA ssoUtilImpA = new SSOUtilImpA();
        Actions actions = new Actions(Constant.webDriver);
        addCouponPO.inputValue.clear();
        addCouponPO.inputDuration.clear();
        addCouponPO.inputPoint.clear();
        addCouponPO.inputDuration.sendKeys(coupon.getDuration());
        addCouponPO.inputPoint.sendKeys(coupon.getPoint());
        addCouponPO.inputValue.sendKeys(coupon.getValue());


        addCouponPO.divSelectCouponType.click();
        addCouponPO.divList.stream().filter(e->e.getText().equals(CouponType)).forEach(WebElement::click);
        ssoUtilImpA.setThreadSleep(3000);

        addCouponPO.divSelectStatus.click();
        addCouponPO.divList.stream().filter(e->e.getText().equals(CouponStatus)).forEach(WebElement::click);
        ssoUtilImpA.setThreadSleep(3000);

        addCouponPO.divSelectUnit.click();
        addCouponPO.divList.stream().filter(e->e.getText().equals(UnitName)).forEach(WebElement::click);
        ssoUtilImpA.setThreadSleep(3000);

        addCouponPO.divSelectUnitDuration.click();
        addCouponPO.divList.stream().filter(e->e.getText().equals(UnitNameTimes)).forEach(WebElement::click);
        ssoUtilImpA.setThreadSleep(3000);

        addCouponPO.btnSave.click();

    }

}

