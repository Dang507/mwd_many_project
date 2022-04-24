package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCouponTypePO extends AddCouponTypePO{

    public EditCouponTypePO(WebDriver webDriver){
        PageFactory.initElements(webDriver, AddCouponTypePO.class);
        PageFactory.initElements(webDriver, this);
    }

}



/*

    @FindBy(css = "label[for='name']")
    public WebElement labelName;
    @FindBy(css = "label[for='limit']")
    public WebElement labelLimit;
    @FindBy(css = "label[for='status']")
    public WebElement labelStatus;
    @FindBy(id = "name")
    public WebElement inputName;
    @FindBy(id = "limit")
    public WebElement inputLimit;
    @FindBy(id = "demo-simple-select")
    public WebElement divSelectStatus;
    @FindBy(css = "button[type='submit']")
    public WebElement btnSave;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement btnCancel;

    // Error messages and icon 'Warning'
    @FindBy(xpath = "//label[@for='name']//following-sibling::div//label")
    public WebElement labelErrorMsgForName;
    @FindBy(xpath = "//input[@id='name']//following-sibling::*[name()='svg']")
    public WebElement svgIconWarningForName;
    @FindBy(xpath = "//label[@for='limit']//following-sibling::div//label")
    public WebElement labelErrorMsgForLimit;
    @FindBy(xpath = "//input[@id='limit']//following-sibling::*[name()='svg']")
    public WebElement svgIconWarningForLimit;

    // success message
    @FindBy(xpath = "//div[text()='The Coupon Type has been updated successfully.']")
    public WebElement divSuccessMessage;
 */