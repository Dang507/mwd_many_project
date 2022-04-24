package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCouponPO{
    @FindBy(id = "tableTitle")
    public WebElement couponTitle;
    @FindBy (xpath = "//label[.='Name*']")
    public  WebElement labelName;
    @FindBy(xpath = "//label[.='Type*']")
    public  WebElement labelType;
    @FindBy(xpath = "//label[.='Value*']")
    public WebElement labelValue;
    @FindBy(css = "[for='valueUnit']")
    public WebElement labelUnitName;
    @FindBy (xpath = "//label[.='Point*']")
    public  WebElement labelPoint;
    @FindBy (xpath = "//label[.='Duration*']")
    public WebElement labelDuration;
    @FindBy(css = "[for='unitDuration']")
    public  WebElement labelUnitDuration;
    @FindBy (xpath = "//label[.='Status*']")
    public WebElement labelStatus;
    @FindBy(xpath = "//label[.='Presentee']")
    public  WebElement labelPresentee;
    @FindBy(xpath = " //div[@id='durationUnit-select' and @aria-labelledby='durationUnit-select durationUnit-select']")
    public WebElement typeCouponOpts;

    @FindBy(xpath = "//input[@id='name']")
    public  WebElement inputName;
    @FindBy (xpath = "//input[@id='value']")
    public WebElement inputValue;
    @FindBy (xpath = "//div[@id='valueUnit']")
    public WebElement unitName;
    @FindBy (xpath = "//input[@id='point']")
    public  WebElement inputPoint;
    @FindBy (xpath = "//input[@id='duration']")
    public WebElement  inputDuration;
    @FindBy(xpath="//div[@id='durationUnit-select' and @aria-labelledby='durationUnit-select']")
    public  WebElement inputUnitTimes;
    @FindBy(xpath = "//div[@id='status-select']")
    public WebElement inputStatus;
    @FindBy (xpath = "//label[.='Presentee']//following-sibling::div//div//input[@aria-label='B' and @type='radio']//following-sibling::span//*[name()='svg']")
    public WebElement btnPresenteeYes;
        @FindBy(xpath = "//label[.='Presentee']//following-sibling::div//div//input[@aria-label='A' and @type='radio']//following-sibling::span//*[name()='svg']")
    public WebElement btnPresenteeNo;


    /* xpath for select options in all element displays on Edit Coupon page*/
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//child::li[1]")
    public WebElement selectOpts1;
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//child::li[2]")
    public WebElement selectOpts2;
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//child::li[3]")
    public WebElement selectOpts3;

    @FindBy (xpath = "//button[text()='Save']")
    public WebElement btnSave;
    @FindBy (xpath = "//button[text()='Cancel']")
    public WebElement btnCancel;

    @FindBy(xpath = "//label[@for='name']//following-sibling::div//label")
    public WebElement labelErrorMsgForName;

    public EditCouponPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, AddCouponPO.class);
        PageFactory.initElements(webDriver, this);
    }
}
