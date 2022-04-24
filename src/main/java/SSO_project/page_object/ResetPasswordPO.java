package SSO_project.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPO {
    @FindBy(xpath = "//h1[contains(text(), 'Hi')]/preceding-sibling::img[@alt='testarchitect']")
    public WebElement imgLogoLogiGear;
    @FindBy(xpath = "//h1[contains(text(), 'Hi')]")
    public WebElement h1Title;
    @FindBy(xpath = "//h1[contains(text(), 'Hi')]//following-sibling::p[contains(text(), 'Please input your password')]")
    public WebElement pSubtextPrompt;

    @FindBy(css = "label[for='confirm']")
    public WebElement labelPassword;
    @FindBy(id = "confirm")
    public WebElement inputPw;
    @FindBy(xpath = "//label[@for='password']//following-sibling::div//button[@type='button']")
    public WebElement btnShowPw;
    @FindBy(xpath = "//input[@id='password']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningPw;
    @FindBy(xpath = "//label[@for='password']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorMsgPw;

    @FindBy(css = "label[for='confirm']")
    public WebElement labelConfirmPw;
    @FindBy(id = "confirm")
    public WebElement inputConfirmPw;
    @FindBy(xpath = "//label[@for='confirm']//following-sibling::div//button[@type='button']")
    public WebElement btnShowConfirmPw;
    @FindBy(xpath = "//input[@id='confirm']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningConfirmPw;
    @FindBy(xpath = "//label[@for='confirm']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorMsgConfirmPw;
    @FindBy(css = "button[type='submit']")
    public WebElement btnSubmit;
    @FindBy(xpath = "//div[@id='logo-trust']//child::img[@src='https://www.positivessl.com/images/seals/positivessl_trust_seal_lg_222x54.png']")
    public WebElement imgLogoTrust;

    public By svgIconWarningPwBy = By.xpath("//input[@id='password']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By labelErrorMsgPwBy = By.xpath("//label[@for='password']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningConfirmPwBy = By.xpath("//input[@id='confirm']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By labelErrorMsgConfirmPwBy = By.xpath("//label[@for='confirm']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']");



    public ResetPasswordPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
