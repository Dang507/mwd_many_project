package projects.TA_web.page_object.user_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiveUsFeedbackPO {
    /* ****  Locator & Element **** */
    @FindBy(css = "h5[id='tableTitle']")
    public WebElement h5Title;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(xpath = "//label[text()='Question/ Comment']")
    public WebElement labelQuestionAndComment;
    @FindBy(xpath = "//label[@for='name']//following-sibling::div//textarea[@aria-label='minimum height']")
    public WebElement textareaQuestionAndComment;
    @FindBy(xpath = "//label[@for='contained-button-file']")
    public WebElement labelAttachFile;
    @FindBy(css = "button[type='Submit']")
    public WebElement btnSendMsg;
    @FindBy(css = "div[id='tableTitle']")
    public WebElement divTableTitle;
    @FindBy(xpath = "//div[@id='tableTitle']//following-sibling::div//table//span[text()='Date']")
    public WebElement spanTableHeaderDate;
    @FindBy(xpath = "//div[@id='tableTitle']//following-sibling::div//table//span[text()='Message']")
    public WebElement spanTableHeaderMessage;
    @FindBy(xpath = "//div[@id='tableTitle']//following-sibling::div//table//span[text()='Status']")
    public WebElement spanTableHeaderStatus;

    // Error message and icon 'Warning'
    @FindBy(xpath = "//button[@title='Close']//parent::div//preceding-sibling::div[normalize-space(text())]")
    public WebElement divConfirmMsg;

    // pagination
    @FindBy(xpath = "//nav[@aria-label='pagination navigation']")
    public WebElement navPaginationArea;

    /* ****  Constructor  **** */
    public GiveUsFeedbackPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
