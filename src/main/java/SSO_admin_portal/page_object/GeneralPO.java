package SSO_admin_portal.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralPO {
    @FindBy(xpath = "//nav//span[contains(text(), 'User Management')]")
    public WebElement spanUserManagement;
    @FindBy(xpath = "//nav//span[contains(text(), 'Client Management')]")
    public WebElement spanClientManagement;
    @FindBy(xpath = "//nav//span[contains(text(), 'Pemission Management')]")
    public WebElement spanPermissionManagement;

    @FindBy(id = "mui-18-label")
    public WebElement labelFromDate;
    @FindBy(id = "mui-18")
    public WebElement inputFromDate;
    @FindBy(id = "mui-19-label")
    public WebElement labelToDate;
    @FindBy(id = "mui-19")
    public WebElement inputToDate;
    @FindBy(id = "outlined-name-label")
    public WebElement labelSearch;
    @FindBy(id = "outlined-name")
    public WebElement inputSearch;
    @FindBy(xpath = "//button//child::*[name() = 'svg' and @data-testid='SearchIcon']")
    public WebElement btnSearch;

    @FindBy(xpath = "//button[contains(text(), 'Add')]")
    public WebElement btnAdd;
    @FindBy(xpath = "//button[contains(text(), 'Export')]")
    public WebElement btnExport;
    @FindBy(xpath = "//button[contains(text(), 'Clear')]")
    public WebElement btnClear;

    public GeneralPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }



}
