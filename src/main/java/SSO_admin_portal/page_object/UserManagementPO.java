package SSO_admin_portal.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPO {
    /* ****  Locator & Web Element  **** */
    @FindBy(id = "tableTitle")
    public WebElement divTitlePage;

    @FindBy(xpath = "//th[contains(text(), 'ID')]")
    public WebElement thID;
    @FindBy(xpath = "//th[contains(text(), 'FIRST NAME')]")
    public WebElement thFirstName;
    @FindBy(xpath = "//th[contains(text(), 'LAST NAME')]")
    public WebElement thLastName;
    @FindBy(xpath = "//th[contains(text(), 'EMAIL')]")
    public WebElement thEmail;
    @FindBy(xpath = "//th[contains(text(), 'WORK PHONE')]")
    public WebElement thPhone;
    @FindBy(xpath = "//th[contains(text(), 'ACTIVE')]")
    public WebElement thActive;

    @FindBy(css = "button[aria-label='Go to previous page']")
    public WebElement btnGoToPreviousPage;
    @FindBy(css = "button[aria-label='Go to next page']")
    public WebElement btnGoToNextPage;
    @FindBy(css = "button[aria-label='Go to page 3']")
    public WebElement btnGoToPage3;

    // pop up add new user
    @FindBy(xpath = "//h1[contains(text(), 'Add new user')]")
    public WebElement h1TitlePopupAdd;
    @FindBy(xpath = "//h1[contains(text(), 'Add new user')]//preceding-sibling::button[@type='button']//*[name()='svg' and @data-testid='ClearIcon']")
    public WebElement btnClosePopup;

    @FindBy(css = "label[for='firstName']")
    public WebElement labelFirstName;
    @FindBy(id = "firstName")
    public WebElement inputFirstName;
    @FindBy(xpath = "//label[@for='firstName']//following::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorFirstName;
    @FindBy(xpath = "//label[@for='firstName']//following-sibling::div//*[name()= 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningFirstName;

    @FindBy(css = "label[for='lastName']")
    public WebElement labelLastName;
    @FindBy(id = "lastName")
    public WebElement inputLastName;
    @FindBy(xpath = "//label[@for='lastName']//following::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorLastName;
    @FindBy(xpath = "//label[@for='lastName']//following-sibling::div//*[name()= 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningLastName;

    @FindBy(css = "label[for='email']")
    public WebElement labelEmail;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(xpath = "//label[@for='email']//following::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorEmail;
    @FindBy(xpath = "//label[@for='email']//following-sibling::div//*[name()= 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningEmail;

    public By labelErrorEmailBy = By.xpath("//label[@for='email']//following::div//label[@class='sc-pfmka2-0 gTWVky']");

    @FindBy(css = "label[for='password']")
    public WebElement labelPw;
    @FindBy(id = "password")
    public WebElement inputPw;
    @FindBy(xpath = "//input[@id='password']//parent::div//following-sibling::button//*[name()='svg' and @data-icon='eye-slash']")
    public WebElement btnShowPw;
    @FindBy(xpath = "//label[@for='password']//following::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorPw;
    @FindBy(xpath = "//label[@for='password']//following-sibling::div//*[name()= 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningPw;

    public By labelErrorPwBy = By.xpath("//label[@for='password']//following::div//label[@class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningPwBy = By.xpath("//label[@for='password']//following-sibling::div//*[name()= 'svg' and @data-icon='exclamation-triangle']");

    @FindBy(css = "label[for='confirmPassword']")
    public WebElement labelConfirmPw;
    @FindBy(id = "confirmPassword")
    public WebElement inputConfirmpw;
    @FindBy(xpath = "//input[@id='confirmPassword']//parent::div//following-sibling::button//*[name()='svg' and @data-icon='eye-slash']")
    public WebElement btnShowConfirmPw;
    @FindBy(xpath = "//label[@for='confirmPassword']//following::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorConfirmPw;
    @FindBy(xpath = "//label[@for='confirmPassword']//following-sibling::div//*[name()= 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningConrifmPw;

    public By labelErrorConfirmPwBy = By.xpath("//label[@for='confirmPassword']//following::div//label[@class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningConrifmPwBy = By.xpath("//label[@for='confirmPassword']//following-sibling::div//*[name()= 'svg' and @data-icon='exclamation-triangle']");



    @FindBy(css = "label[for='title']")
    public WebElement labelTitle;
    @FindBy(id = "title")
    public WebElement inputTitle;

    @FindBy(css = "label[for='company']")
    public WebElement labelCompany;
    @FindBy(id = "company")
    public WebElement inputCompany;
    @FindBy(css = "label[for='country']")
    public WebElement labelCountry;
    @FindBy(css = "select[name='rcrs-country']")
    public WebElement selectCountry;

    @FindBy(css = "label[for='state']")
    public WebElement labelState;
    @FindBy(css = "select[name='rcrs-region']")
    public WebElement selectState;
    @FindBy(css = "label[for='active']")

    public WebElement labelActive;
    @FindBy(css = "input[name='active']")
    public WebElement inputActive;
    @FindBy(css = "label[for='phone']")

    public WebElement labelPhone;
    @FindBy(id = "phone")
    public WebElement inputPhone;
    @FindBy(xpath = "//label[@for='phone']//following::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorPhone;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    public WebElement btnCancel;
    @FindBy(css = "button[type='Submit']")
    public WebElement btnSave;

    public UserManagementPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
