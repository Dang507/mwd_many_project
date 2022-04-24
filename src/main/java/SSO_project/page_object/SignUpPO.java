package SSO_project.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPO {

    /* ****  Locator & Element  **** */
    @FindBy(xpath = "//h1[contains(text(), 'Create your free account')]/preceding-sibling::img[@alt='testarchitect']")
    public WebElement imgLogoLogiGear;
    @FindBy(xpath = "//h1[contains(text(), 'Create your free account')]")
    public WebElement h1Title;
    @FindBy(css = "label[for='first_name']")
    public WebElement labelFirstName;
    @FindBy(id = "first_name")
    public WebElement inputFirstName;
    @FindBy(css = "label[for='last_name']")
    public WebElement labelLastName;
    @FindBy(id = "last_name")
    public WebElement inputLastName;
    @FindBy(css = "label[for='email']")
    public WebElement labelEmail;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(css = "label[for='new_password']")
    public WebElement labelPw;
    @FindBy(id = "new_password")
    public WebElement inputPassword;
    @FindBy(css = "label[for='new_password_repeat']")
    public WebElement labelConfirmPw;
    @FindBy(id = "new_password_repeat")
    public WebElement inputConfirmPW;
    @FindBy(css = "button[type = 'submit']")
    public WebElement btnNext;
    @FindBy(xpath = "//a[text() = 'Sign in here']")
    public WebElement aSignInHere;
    @FindBy(xpath = "//div[@id='logo-trust']//child::img[@src='https://www.positivessl.com/images/seals/positivessl_trust_seal_lg_222x54.png']")
    public WebElement imgLogoTrust;

    @FindBy(xpath = "//label[@for='first_name']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorFirstName;
    @FindBy(xpath = "//label[@for='last_name']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorLastName;
    @FindBy(xpath = "//label[@for='email']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorEmail;
    @FindBy(xpath = "//label[@for='new_password']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorPw;
    @FindBy(xpath = "//label[@for='new_password_repeat']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorConfirmedPw;
    @FindBy(xpath = "//label[@for='new_password']//following-sibling::div//button[@type='button']")
    public WebElement btnShowPw;
    @FindBy(xpath = "//label[@for='new_password_repeat']//following-sibling::div//button[@type='button']")
    public WebElement btnShowConfirmPw;

    @FindBy(xpath = "//input[@id='first_name']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningFirstName;
    @FindBy(xpath = "//input[@id='last_name']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningLastName;
    @FindBy(xpath = "//input[@id='email']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningEmail;
    @FindBy(xpath = "//input[@id='new_password']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningPw;
    @FindBy(xpath = "//input[@id='new_password_repeat']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningConfirmPw;

    public By labelErrorFirstNameBy = By.xpath("//label[@for='first_name']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By labelErrorLastNameBy = By.xpath("//label[@for='last_name']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By labelErrorEmailBy = By.xpath("//label[@for='email']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By labelErrorPwBy = By.xpath("//label[@for='new_password_repeat']/following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By labelErrorConfirmedPwBy = By.xpath("//label[@for='new_password']//parent::div[@class='sc-rs2qxh-5 mHTWN']//child::button[@type='button']");

    public By svgIconWarningFirstNameBy = By.xpath("//input[@id='first_name']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");
    public By svgIconWarningLastNameBy = By.xpath("//input[@id='last_name']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");
    public By svgIconWarningEmailBy = By.xpath("//input[@id='email']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");
    public By svgIconWarningPwBy = By.xpath("//input[@id='new_password']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");
    public By svgIconWarningConfirmPwBy = By.xpath("//input[@id='new_password_repeat']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");

    // One last step page
    @FindBy(xpath = "//h1[contains(text(), 'One last step')]")
    public WebElement h1TitleFinalForm;
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
    @FindBy(css = "label[for='phone']")
    public WebElement labelPhone;
    @FindBy(id = "phone")
    public WebElement inputPhone;
    @FindBy(css = "button[type='submit']")
    public WebElement btnCreateAccount;
    @FindBy(xpath = "//div[text()='Back']")
    public WebElement divBack;
    @FindBy(xpath = "//label[@for='phone']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorPhone;

    public By labelErrorPhoneBy = By.xpath("//label[@for='phone']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']");

    /* ****  Constructor  **** */
    public SignUpPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
