package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddCouponTypePO {
    @FindBy(css = "label[for='name']")
    public WebElement labelName;
    @FindBy(id = "name")
    public WebElement inputName;
    @FindBy(css = "label[for='limit']")
    public WebElement labelLimit;
    @FindBy(id = "limit")
    public WebElement inputLimit;
    @FindBy(css = "label[for='status']")
    public WebElement labelStatus;
    @FindBy(id = "demo-simple-select")
    public WebElement divSelectStatus;
    @FindBy(xpath = "//ul[@role='listbox']//li")
    public List<WebElement> liStatusOptions;
    @FindBy(css = "label[for='image']")
    public WebElement labelBtnUploadImage;
    @FindBy(id = "image")
    public WebElement inputUploadImage;
    @FindBy(xpath = "//img[@alt='coupon icon']")
    public WebElement imgImageDisplay;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement btnSave;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement btnCancel;

    // Error messages and icons 'Warning'
    @FindBy(xpath = "//label[@for='name']//following-sibling::div//label")
    public WebElement labelErrorMsgForName;
    @FindBy(xpath = "//input[@id='name']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningForName;
    @FindBy(xpath = "//label[@for='limit']//following-sibling::div//label")
    public WebElement labelErrorMsgForLimit;
    @FindBy(xpath = "//input[@id='limit']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningForLimit;
    @FindBy(xpath = "//label[@for='image']//following-sibling::label")
    public WebElement labelErrorMsgImage;

    public By labelErrorMsgForNameBy = By.xpath("//label[@for='name']//following-sibling::div//label");
    public By svgIconWarningForNameBy = By.xpath("//input[@id='name']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By labelErrorMsgForLimitBy  = By.xpath("//label[@for='limit']//following-sibling::div//label");
    public By getSvgIconWarningForLimitBy = By.xpath("//input[@id='limit']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");

    // success message
    @FindBy(css = "div[role='alert']")
    public WebElement divAlertMessage;

    public AddCouponTypePO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public AddCouponTypePO() {
    }
}
