package SSO_project.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestArchitectPO {

    /* ****  Locator & Web Element  **** */
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement btnLogin;
    @FindBy(xpath = "//span[@id='manage-account']/following-sibling::a[@class='sf-with-ul']")
    public WebElement accountName;
    @FindBy(xpath = "//a[contains(text(),'Activate account')]")
    public WebElement btnActiveAccount;
    @FindBy(xpath = "//a[text()='Change Password']")
    public WebElement optChangePw;
    @FindBy(xpath = "//a[text()='Manage My Profile']")
    public WebElement optManageMyProfile;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement optLogout;

    @FindBy(xpath = "//a[contains(text(),'Manage My Profile')]")
    public WebElement optUpdateProfile;

    public TestArchitectPO(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
