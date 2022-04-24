package SSO_project.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePwPO {
    /* ****  Locator & Web Element  **** */
    @FindBy(xpath = "//h1[contains(text(), 'Hi ')]/preceding-sibling::img[@alt='testarchitect']")
    public WebElement imgLogoLogiGear;
    @FindBy(xpath = "//h1[contains(text(), 'Hi ')]")
    public WebElement h1Title;
    @FindBy(xpath = "//h1[contains(text(), 'Hi ')]/following-sibling::p[contains(text(), 'Please input your password')]")
    public WebElement pInfo;
    @FindBy(css = "label[for='oldPassword']")
    public WebElement labelOldPw;
    @FindBy(id = "oldPassword")
    public WebElement inputOldPw;
    @FindBy(xpath = "//label[@for='oldPassword']//following-sibling::div//button[@type='button']")
    public WebElement btnShowOldPw;
    @FindBy(css = "label[for='password']")
    public WebElement labelNewPw;
    @FindBy(id = "password")
    public WebElement inputNewPw;
    @FindBy(xpath = "//label[@for='password']//following-sibling::div//button[@type='button']")
    public WebElement btnShowNewPw;
    @FindBy(css = "label[for='confirm']")
    public WebElement labelConfirmPw;
    @FindBy(id = "confirm")
    public WebElement inputConfirmPw;
    @FindBy(xpath = "//label[@for='confirm']//following-sibling::div//button[@type='button']")
    public WebElement btnShowConfirmPw;
    @FindBy(css = "button[type='submit']")
    public WebElement btnSubmit;
    @FindBy(xpath = "//div[@id='logo-trust']//child::img[@src='https://www.positivessl.com/images/seals/positivessl_trust_seal_lg_222x54.png']")
    public WebElement imgLogoTrust;

    @FindBy(xpath = "//label[@for='oldPassword']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorCurrentPw;
    @FindBy(xpath = "//input[@id='oldPassword']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningCurrentPw;
    @FindBy(xpath = "//label[@for='password']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorNewPw;
    @FindBy(xpath = "//input[@id='password']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningNewPw;
    @FindBy(xpath = "//label[@for='confirm']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorConfirmPw;
    @FindBy(xpath = "//input[@id='confirm']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningConfirmPw;
    @FindBy(xpath = "//h1[contains(text(), 'Success!')]")
    public WebElement h1SuccessText;

    @FindBy(xpath = "//form//div[@class='sc-1xeoqy7-0 hHCElS']//div")
    public WebElement divErrorMsgCurrentPw;

    public By labelErrorCurrentPwBy = By.xpath("//label[@for='oldPassword']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningCurrentPwBy = By.xpath("//input[@id='oldPassword']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By labelErrorNewPwBy = By.xpath("//label[@for='password']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningNewPwBy = By.xpath("//input[@id='password']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By labelErrorConfirmPwBy = By.xpath("//label[@for='confirm']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningConfirmPwBy = By.xpath("//input[@id='confirm']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");

    public ChangePwPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    // xong page object change pw page
}
