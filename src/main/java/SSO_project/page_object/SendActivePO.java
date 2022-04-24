package SSO_project.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendActivePO {
    /* ****  Locator & Element **** */
    @FindBy(css = "//h1[contains(text(), 'Resend the activation email')]//preceding-sibling::img[@alt='testarchitect']")
    public WebElement imgLogoLogiGear;
    @FindBy(css = "//h1[contains(text(), 'Resend the activation email')]")
    public WebElement h1TitlePage;
    @FindBy(css = "label[for='email']")
    public WebElement labelEmail;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(css = "button[type='submit']")
    public WebElement btnResendActiveCode;
    @FindBy(xpath = "//a[contains(text(), 'activation page')]")
    public WebElement aActivationPage;
    @FindBy(xpath = "//div[@id='logo-trust']//child::img[@src='https://www.positivessl.com/images/seals/positivessl_trust_seal_lg_222x54.png']")
    public WebElement imgLogoTrust;

    @FindBy(xpath = "//input[@id='email']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningEmail;
    @FindBy(xpath = "//label[@for='email']//following-sibling::label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorForEmail;

    /* ****  Constructor  **** */
    public SendActivePO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
