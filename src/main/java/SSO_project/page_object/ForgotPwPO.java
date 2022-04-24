package SSO_project.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPwPO {
    /* ****  Locator & Element **** */
    @FindBy(xpath = "//h1[contains(text(), 'Reset your password here')]/preceding-sibling::img[@alt='testarchitect']")
    public WebElement imgLogoLogiGear;
    @FindBy(xpath = "//h1[contains(text(), 'Reset your password here')]")
    public WebElement h1Title;
    @FindBy(css = "label[for='email']")
    public WebElement labelEmail;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(css = "button[type='submit']")
    public WebElement btnSubmit;
    @FindBy(css = "a[class='sc-8l9kt4-0 feKVCC']")
    public WebElement lnkSignIn;
    @FindBy(css = "label[class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorEmail;
    @FindBy(xpath = "//input[@id='email']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningEmail;
    @FindBy(xpath = "//p[contains(text(), 'An reset password link has been sent to you via email.')]")
    public WebElement pSuccess;

    public By labelErrorEmailBy = By.cssSelector("label[class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningEmailBy = By.xpath("//input[@id='email']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");

    /* ****  Constructor  **** */
    public ForgotPwPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    /* ****  Method -> They are implemented into interface TAForgotPwA  **** */
}
