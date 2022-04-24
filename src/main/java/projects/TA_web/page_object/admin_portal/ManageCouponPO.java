package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCouponPO {
    @FindBy(id = "tableTitle")
    public WebElement h5TitlePage;
    @FindBy(xpath = "//button[text()= 'Add']")
    public WebElement btnAdd;
    @FindBy(xpath = "//span[text()= 'Name']")
    public WebElement spanColumnName;
    @FindBy(xpath = "//span[text()= 'Type']")
    public WebElement spanColumnType;
    @FindBy(xpath = "//span[text()= 'Value']")
    public WebElement spanColumnValue;
    @FindBy(xpath = "//span[text() = 'Point']//parent::th//preceding-sibling::th//span[text()='Unit Name']")
    public WebElement spanColumnUnitFirst;
    @FindBy(xpath = "//span[text() = 'Point']")
    public WebElement spanColumnPoint;
    @FindBy(xpath = "//span[text()='Duration']")
    public WebElement spanColumnDuration;
    @FindBy(xpath = "//span[text() = 'Point']//parent::th//following-sibling::th//span[text()='Unit Name']")
    public WebElement spanColumnUnitSecond;
    @FindBy(xpath = "//span[text() = 'Status']")
    public WebElement spanColumnStatus;
    @FindBy(xpath = "//span[text() = 'Presentee']")
    public WebElement spanColumnPresentee;

    // dialog 'Delete coupon'
    @FindBy(id = "h2[id='modal-modal-title']")
    public WebElement h2TitleDialog;
    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement btnDeleteCoupon;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement btnCancelDialog;
    /* absolute xpath of items on table in page Manage Coupon*/
    @FindBy(xpath = "//td[text()='Increase Test Case']//following-sibling::td//div//button[2]")
    public  WebElement editIcon;

    public ManageCouponPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
