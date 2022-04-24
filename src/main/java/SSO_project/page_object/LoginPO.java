package SSO_project.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {

    /* ****  Locator & Web Element  **** */

    @FindBy(xpath = "//h1[contains(text(), 'Welcome to LogiGear')]")
    public WebElement h1Title;
    @FindBy(xpath = "//h1[contains(text(), 'Welcome to LogiGear')]/preceding-sibling::img[@alt='testarchitect']")
    public WebElement imgLogoLogiGear;

    @FindBy(css = "label[for='email']")
    public WebElement labelEmail;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(css = "label[for='password']")
    public WebElement labelPw;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(css = "button[type='submit']")
    public WebElement btnLogin;
    @FindBy(id = "FreshdeskUser_isRememberMe")
    public WebElement inputRememberMe;
    @FindBy(xpath = "//form//div[text()='Incorrect email or password. Please try again!']")
    public WebElement divIncorrectInfo;
    @FindBy(xpath = "//a[text()='Sign up here']")
    public WebElement linkSignUp;
    @FindBy(xpath = "//a[text()='Forgot password?']")
    public WebElement linkForgotPw;
    @FindBy(xpath = "//label[@for='email']/following-sibling::label")
    public WebElement labelEmailErrorMsg;
    @FindBy(xpath = "//label[@for='password']/following-sibling::label")
    public WebElement labelPwErrorMsg;
    @FindBy(xpath = "//label[@for='password']//following-sibling::div//button[@type='button']")
    public WebElement btnShowPw;

    public By labelEmailErrorMsgBy = By.xpath("//label[@for='email']/following-sibling::label");

    /* ****  Constructor  **** */
    public LoginPO(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    /* ****  Method  **** */
}
