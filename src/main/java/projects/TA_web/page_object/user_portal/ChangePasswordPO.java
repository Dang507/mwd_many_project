package projects.TA_web.page_object.user_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPO {
    @FindBy(xpath = "//main//h1[text()='Change Password']")
    public WebElement h1Title;
    @FindBy(css = "label[for='oldPassword']")
    public WebElement labelPw;
    @FindBy(id = "oldPassword")
    public WebElement inputPw;
    @FindBy(xpath = "//label[@for='oldPassword']//following-sibling::div//button[@type='button']")
    public WebElement btnShowPw;
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
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement btnCancel;

    @FindBy(xpath = "//label[@for='oldPassword']//following-sibling::label")
    public WebElement labelErrorMessagePw;
    @FindBy(xpath = "//input[@id='oldPassword']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningPw;
    @FindBy(xpath = "//label[@for='password']//following-sibling::label")
    public WebElement labelErrorMessageNewPw;
    @FindBy(xpath = "//input[@id='password']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningNewPw;
    @FindBy(xpath = "//label[@for='confirm']//following-sibling::label")
    public WebElement labelErrorConfirmPw;
    @FindBy(xpath = "//input[@id='confirm']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningConfirmPw;

    public By labelErrorMessagePwBy = By.xpath("//label[@for='oldPassword']//following-sibling::label");
    public By svgIconWarningPwBy = By.xpath("//input[@id='oldPassword']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By labelErrorMessageNewPwBy = By.xpath("//label[@for='password']//following-sibling::label");
    public By svgIconWarningNewPwBy = By.xpath("//input[@id='password']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");
    public By labelErrorConfirmPwBy = By.xpath("//label[@for='confirm']//following-sibling::label");
    public By svgIconWarningConfirmPwBy = By.xpath("//input[@id='confirm']//following-sibling::*[name()='svg' and @data-icon='exclamation-triangle']");

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement divAlertMessage;

    public ChangePasswordPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
