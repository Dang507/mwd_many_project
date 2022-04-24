package SSO_project.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePO {
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement inputFirstName;
    @FindBy (xpath = "//input[@id='lastName']")
    public  WebElement inputLastName;
    @FindBy(xpath = "//input[@id='title']")
    public  WebElement inputTitle;
    @FindBy (xpath = "//select[@name='rcrs-country']")
    public WebElement selectCountry;
    @FindBy (xpath = "//select[@name='rcrs-region']")
    public  WebElement selectState;
    @FindBy (xpath = "//input[@id='phone']")
    public  WebElement inputPhone;
    @FindBy (xpath = "//button[@class='sc-qaw5yv-0 kcwIQg']")
    public WebElement btnSubmit;
    @FindBy(xpath = "//input[@id='uploadAvatar']")
    public WebElement uploadAvatar;

    @FindBy(xpath="//label[@for='firstName']")
    public WebElement labelFirstName;
    @FindBy (xpath = "//label[@for='lastName']")
    public  WebElement labelLastName;
    @FindBy (xpath = "//label[.='Title']")
    public  WebElement labelTitle;
    @FindBy(xpath = "//label[contains(text(),'Company')]")
    public  WebElement labelCompany;
    @FindBy (xpath = "//label[.='Country']")
    public  WebElement labelCountry;
    @FindBy (xpath = "//label[.='State']")
    public  WebElement labelState;
    @FindBy(xpath="//label[@for='phone']")
    public  WebElement labelPhone;

    @FindBy(xpath = "//label[@for='firstName']/following-sibling::div//label[@class='sc-pfmka2-0 gTWVky']")
    public  WebElement labelErrorMsgFirstName;
    @FindBy(xpath = "//label[@for='lastName']/following-sibling::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorMsgLastName;
    @FindBy(xpath="//label[@for='phone']/following-sibling::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorMsgPhone;
    @FindBy(xpath = "//div[@class='MuiAlert-message css-1w0ym84']")
    public  WebElement labelErrorMsgUploadImg;

    public  UpdateProfilePO(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}
