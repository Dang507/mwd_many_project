package projects.TA_web.page_object.admin_portal;

import common.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddCouponPO {
    @FindBy(id = "tableTitle")
    public WebElement h5Title;
    @FindBy(xpath = "//label[.='Name*']")
    public WebElement labelName;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement inputName;
    @FindBy(css = "label[for='type']")
    public WebElement labelType;
    @FindBy(xpath = "//label[@for='type']//following-sibling::div//div[@id='durationUnit-select']")
    public WebElement divSelectCouponType;
    @FindBy(xpath = "//ul[@role='listbox']//li")
    public List<WebElement> divList;
    @FindBy(xpath = "//div[@id='menu-couponType']//li[1]")
    public WebElement liFirstCouponType;
    @FindBy(xpath = "//div[@id='menu-couponType']//li[2]")
    public WebElement liSecondCouponType;
    @FindBy(xpath = "//label[@for='value' and text() ='Value']")
    public WebElement labelValue;
    @FindBy(id = "value")
    public WebElement inputValue;
    @FindBy(css = "label[for='valueUnit']")
    public WebElement labelUnitFirst;
    @FindBy(xpath = "//div[@id='valueUnit']")
    public WebElement divSelectUnit;
    @FindBy(xpath = "//div[@id='menu-valueUnit']//li[1]")
    public WebElement liValueUnitOption1;
    @FindBy(xpath = "//div[@id='menu-valueUnit']//li[2]")
    public WebElement liValueUnitOption2;
    @FindBy(xpath = "//div[@id='menu-valueUnit']//li[3]")
    public WebElement liValueUnitOption3;
    @FindBy(css = "label[for='point']")
    public WebElement labelPoint;
    @FindBy(id = "point")
    public WebElement inputPoint;
    @FindBy(css = "label[for='duration']")
    public WebElement labelDuration;
    @FindBy(id = "duration")
    public WebElement inputDuration;
    @FindBy(css = "label[for='unitDuration']")
    public WebElement labelUnitDuration;
    @FindBy(xpath = "//label[@for='unitDuration']//following-sibling::div//div[@id='durationUnit-select']")
    public WebElement divSelectUnitDuration;
    @FindBy(css = "label[for='status']")
    public WebElement labelStatus;
    @FindBy(id = "status-select")
    public WebElement divSelectStatus;
    @FindBy(css = "label[for='presentee']")
    public WebElement labelPresentee;
    @FindBy(xpath = "//label[.='Presentee']//following-sibling::div//div//input[@aria-label='B' and @type='radio']//following-sibling::span//*[name()='svg']")
    public WebElement inputRadioBtnYes;
    @FindBy(xpath = "//label[.='Presentee']//following-sibling::div//div//input[@aria-label='A' and @type='radio']//following-sibling::span//*[name()='svg']")
    public WebElement inputRadioBtnNo;
    @FindBy(xpath = "//label[@for='presentee']//following-sibling::div//b[text()='Yes']")
    public WebElement bYes;
    @FindBy(xpath = "//label[@for='presentee']//following-sibling::div//b[text()='No']")
    public WebElement bNo;
    @FindBy(xpath = "//button[@type='submit' and text()='Save']")
    public WebElement btnSave;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement btnCancel;

    @FindBy(xpath = "//label[@for='name']//following-sibling::div//label")
    public WebElement labelErrorMsgName;
    @FindBy(xpath = "//input[@id='name']//following-sibling::*[name()= 'svg']")
    public WebElement svgIconWarningForName;
    @FindBy(xpath = "//label[@for='type']//following-sibling::div//label")
    public WebElement labelErrorMsgType;
    @FindBy(xpath = "//input[@id='type']//following-sibling::*[name()= 'svg' and @data-icon='exclamation-triangle']]")
    public WebElement svgIconWarningForType;
    @FindBy(xpath = "//label[@for='value']//following-sibling::div//label")
    public WebElement labelErrorMsgValue;
    @FindBy(xpath = "//input[@id='value']//following-sibling::*[name()= 'svg']")
    public WebElement svgIconWarningForValue;
    @FindBy(xpath = "//label[@for='valueUnit']//following-sibling::div//label")
    public WebElement labelErrorMsgUnitFirst;
    @FindBy(xpath = "//div[@id='valueUnit']//following-sibling::*[name()= 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningForUnitFirst;
    @FindBy(xpath = "//label[@for='point']//following-sibling::div//label")
    public WebElement labelErrorMsgPoint;
    @FindBy(xpath = "//input[@id='point']//following-sibling::*[name()= 'svg']")
    public WebElement svgIconWarningForPoint;
    @FindBy(xpath = "//label[@for='duration']//following-sibling::div//label")
    public WebElement labelErrorMsgDuration;
    @FindBy(xpath = "//input[@id='duration']//following-sibling::*[name()= 'svg']")
    public WebElement svgIconWarningForDuration;
    @FindBy(xpath = "//label[@for='unitDuration']//following-sibling::div//label")
    public WebElement labelErrorMsgUnitDuration;
    @FindBy(xpath = "//label[@for='unitDuration']//following-sibling::div//div[@id='durationUnit-select']//following-sibling::*[name()= 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningForUnitDuration;
    @FindBy(xpath = "//label[@for='name']//following-sibling::div//label")
    public WebElement labelErrorMsgForName;

    public AddCouponPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public AddCouponPO() {

    }
}
