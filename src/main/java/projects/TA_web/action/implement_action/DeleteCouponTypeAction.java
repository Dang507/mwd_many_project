package projects.TA_web.action.implement_action;

import common.Constant;
import common.ISSOUtilA;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projects.TA_web.action.IDeleteCouponTypeAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

import java.util.List;

public class DeleteCouponTypeAction implements IDeleteCouponTypeAction {

    @Override
    public void verifyUIItemsDeleteDialog(ManageCouponTypePO manageCouponTypePO, CouponType couponType) {
        IGeneralAction generalA = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();

        LogReport.logSubStep("<b>Verify the dialog title</b>");
        String titleExpected = dataTestTAWeb.h2TitleDeleteDialogCouponType + couponType.getName() + "?";
        generalA.verifyTextDisplay(titleExpected, manageCouponTypePO.h2DialogTitle, false);

        LogReport.logSubStep("<b>Verify all button name: 'Delete', 'Cancel'</b>");
        generalA.verifyTextDisplay(dataTestTAWeb.btnCancel.toUpperCase(), manageCouponTypePO.btnCancel, false);
        generalA.verifyTextDisplay(dataTestTAWeb.btnDelete.toUpperCase(), manageCouponTypePO.btnDelete, false);
    }


    @Override
    public void verifyDeleteCouponType(ManageCouponTypePO manageCouponTypePO, WebDriver webDriver, CouponType couponType) {
        IGeneralAction generalAction = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        clickDeleteIconOfACouponType(webDriver, couponType);
        manageCouponTypePO.btnDelete.click();
        generalAction.verifyTextDisplay(dataTestTAWeb.success_msg_delete_coupon_type,
                manageCouponTypePO.divSuccessMessage, false);
        generalAction.verifyElementHidden(manageCouponTypePO.h2DialogTitleBy, Constant.webDriver, "The dialog 'Delete coupon type'");
    }

    @Override
    public void clickDeleteIconOfACouponType(WebDriver webDriver, CouponType couponType) {
        webDriver.findElement(By.xpath("//td[contains(text(),'" + couponType.getName()
                + "')]//following-sibling::td//*[name()='svg' and @data-testid='DeleteOutlineIcon']")).click();
    }

//    @Override
//    public void verifyDeleteManyCouponType(WebDriver webDriver, int number, CouponType couponType) throws InterruptedException {
//        INavigateAction navigateAction = new NavigateAction();
//        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(Constant.webDriver);
//        IGeneralAction generalAction = new GeneralAction();
//        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
//        String successfulMsg = dataTestTAWeb.success_msg_delete_coupon_type;
//        ISSOUtilA utilA = new SSOUtilImpA();
//        List<WebElement> couponTypeDeleteIcons= navigateAction.selectExpectedCouponTypeToDelete(webDriver, couponType);
//        couponTypeDeleteIcons.forEach(webElement -> System.out.println(webElement.getAttribute("data-testid")));
//        System.out.println(couponTypeDeleteIcons.size());
////        for (int i = 0; i < number; i++){
////            couponTypeDeleteIcons.get(i).click();
////            manageCouponTypePO.btnDelete.click();
////            generalAction.verifyTextDisplay(successfulMsg, manageCouponTypePO.divSuccessMessage, false);
////            utilA.setThreadSleep(8000);
////        }
//    }



}
