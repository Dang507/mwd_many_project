package SSO_project.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveAccountPO {
    /* ****  Locator & Element **** */
    @FindBy(id = "securityCode")
    public WebElement inputActiveCode;
    @FindBy(css = "button[type='submit']")
    public WebElement btnActiveAccount;
    @FindBy(xpath = "//a[text()='here']")
    public WebElement aHere;
    @FindBy(xpath = "//div[@id='logo-trust']//child::img[@src='https://www.positivessl.com/images/seals/positivessl_trust_seal_lg_222x54.png']")
    public WebElement imgLogoTrust;

    @FindBy(css = "label[class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorActiveCode;
    @FindBy(xpath = "//input[@id='securityCode']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningActiveCode;
    @FindBy(xpath = "//div[text()='Invalid activate code.']")
    public WebElement divErrorInvalidCode;

    public By labelErrorActiveCodeBy = By.cssSelector("label[class='sc-pfmka2-0 gTWVky']");
    public By svgIconWarningActiveCodeBy = By.xpath("//input[@id='securityCode']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By divErrorInvalidCodeBy = By.xpath("//div[text()='Invalid activate code.']");

    /* ****  Constructor  **** */
    public ActiveAccountPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
