package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPortalPO {

    @FindBy(xpath = "//nav//span[text()='Manage Client']")
    public WebElement spanManageClient;
    @FindBy(xpath = "//nav//span[text()='Manage Client']//parent::div//preceding-sibling::*[@data-testid='TableChartIcon']")
    public WebElement svgManageClient;
    @FindBy(xpath = "//nav//span[text()='Manage Feedback']")
    public WebElement spanManageFeedback;
    @FindBy(xpath = "//nav//span[text()='Manage Feedback']//parent::div//preceding-sibling::*[@data-testid='ListAltIcon']")
    public WebElement svgManageFeedback;
    @FindBy(xpath = "//nav//span[text()='Manage Coupon Type']")
    public WebElement spanManageCouponType;
    @FindBy(xpath = "//nav//span[text()='Manage Coupon Type']//parent::div//preceding-sibling::*[@data-testid='ListAltIcon']")
    public WebElement svgManageCouponType;
    @FindBy(xpath = "//nav//span[text()='Manage Coupon']")
    public WebElement spanManageCoupon;
    @FindBy(xpath = "//nav//span[text()='Manage Coupon']//parent::div//preceding-sibling::*[@data-testid='TableChartIcon']")
    public WebElement svgManageCoupon;

    @FindBy(xpath = "//button//*[name()='svg' and @data-testid='ArrowDropDownIcon']")
    public WebElement btnMenuAccount;

    public AdminPortalPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
