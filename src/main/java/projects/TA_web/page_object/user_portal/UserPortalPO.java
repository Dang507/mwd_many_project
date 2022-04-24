package projects.TA_web.page_object.user_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPortalPO {
    /* ****  Locator & Element **** */
    @FindBy(xpath = "//nav//img[@alt='TestArchitect Logo']")
    public WebElement imgLogoTA;
    @FindBy(xpath = "//nav//span[text()='Dashboard']")
    public WebElement spanDashboard;
    @FindBy(xpath = "//nav//span[text()='Dashboard']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='BadgeIcon']")
    public WebElement svgIconDashboard;
    @FindBy(xpath = "//nav//span[text()='Refer and Earn']")
    public WebElement spanReferAndEarn;
    @FindBy(xpath = "//nav//span[text()='Refer and Earn']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='PeopleAltOutlinedIcon']")
    public WebElement svgIconReferAndEarn;
    @FindBy(xpath = "//nav//span[text()='Redeem']")
    public WebElement spanRedeem;
    @FindBy(xpath = "//nav//span[text()='Redeem']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='CardGiftcardIcon']")
    public WebElement svgIconRedeem;
    // update tiep o day
    @FindBy(xpath = "//nav//span[text()='Give Us Feedback']")
    public WebElement spanLeaveAMessage;
    @FindBy(xpath = "//nav//span[text()='Give Us Feedback']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='ChatOutlinedIcon']")
    public WebElement svgIconLeaveAMessage;
    @FindBy(xpath = "//nav//span[text()='Go To Admin Page']")
    public WebElement spanGoToAdminPage;
    @FindBy(xpath = "//header//button//*[name()='svg' and @data-testid='ArrowDropDownIcon']")
    public WebElement svgAccountMenu;
    @FindBy(xpath = "//a[text()='Change Password']")
    public WebElement aChangePw;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement aLogout;
    @FindBy(xpath = "//a//li[text()='My Profile']")
    public WebElement aMyProfile;
    @FindBy (xpath = "//button[text() = 'Edit Profile']")
    public WebElement btnEditProfile;
    public UserPortalPO (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }








}
