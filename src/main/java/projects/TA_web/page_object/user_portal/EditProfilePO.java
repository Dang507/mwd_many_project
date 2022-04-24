package projects.TA_web.page_object.user_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePO {

    @FindBy(xpath = "//input[@id='firstName']")
    public  WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='lastName']")
    public  WebElement inputLastName;
    @FindBy(xpath = "//input[@id='title']")
    public  WebElement inputTitle;
    @FindBy(xpath = "//input[@id='company']")
    public  WebElement inputComany;
    @FindBy(xpath = "//select[@name='rcrs-country']")
    public  WebElement selectCountry;
    @FindBy(xpath = "//select[@name='rcrs-region']")
    public  WebElement selectRegion;
    @FindBy(xpath = "//input[@id='phone']")
    public  WebElement inputPhone;

    @FindBy(xpath="//label[.='First Name*']")
    public WebElement labelFirstName;
    @FindBy (xpath = "//label[.='Last Name*']")
    public  WebElement labelLastName;
    @FindBy (xpath = "//label[.='Title']")
    public  WebElement labelTitle;
    @FindBy(xpath = "//label[contains(text(),'Company')]")
    public  WebElement labelCompany;
    @FindBy (xpath = "//label[.='Country']")
    public  WebElement labelCountry;
    @FindBy (xpath = "//label[.='State']")
    public  WebElement labelState;
    @FindBy (xpath = "//select[@name='rcrs-region']")
    public  WebElement inputState;
    @FindBy(xpath="//label[.='Phone']")
    public  WebElement labelPhone;

    @FindBy(xpath = "//label[.='First Name*']/following-sibling::div//label[@class='sc-pfmka2-0 gTWVky']")
    public  WebElement labelErrorMsgFirstName;
    @FindBy(xpath = "//label[.='Last Name*']/following-sibling::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorMsgLastName;
    @FindBy(xpath="//label[text()='Phone']/following-sibling::div//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement labelErrorMsgPhone;
    @FindBy(xpath = "//label[@class='sc-pfmka2-0 gTWVky']")
    public  WebElement labelErrorMsgUploadImg;
    @FindBy (xpath = "//button[text()='Save']")
    public WebElement btnSave;
    @FindBy (xpath = "//button[text()='Cancel']")
    public WebElement btnCancelEditProfile;
    @FindBy(xpath = "//input[@id='uploadAvatar']")
    public WebElement uploadAvatar;
    @FindBy (xpath = "//div[text()='Your profile has been updated successfully.']")
    public  WebElement divSuccessgUploadAvatar;
    public  EditProfilePO(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

}
