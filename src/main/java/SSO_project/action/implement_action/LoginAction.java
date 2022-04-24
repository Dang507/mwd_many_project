package SSO_project.action.implement_action;

import SSO_project.action.INavigateAction;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import SSO_project.action.ILoginAction;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import common.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginAction implements ILoginAction {

    @Override
    public void checkLoginPageGUI(LoginPO loginPO) {
        IGeneralAction generalA = new GeneralAction();
        generalA.verifyElementDisplayed(loginPO.imgLogoLogiGear, "The logo image 'LogiGear'");
        generalA.verifyElementDisplayed(loginPO.h1Title, "The title 'Welcome to LogiGear'");
        generalA.verifyElementDisplayed(loginPO.labelEmail, "The label 'Email*'");
        generalA.verifyElementEnable(loginPO.inputEmail, "The field 'Email' ");
        generalA.verifyElementDisplayed(loginPO.labelPw, "The label 'Password*'");
        generalA.verifyElementEnable(loginPO.inputPassword, "The field 'Password' ");
        generalA.verifyElementDisplayed(loginPO.btnLogin, "The button 'Login' ");
        generalA.verifyElementDisplayed(loginPO.linkSignUp, "The link 'Sign up here'");
        generalA.verifyElementDisplayed(loginPO.linkForgotPw, "The link 'Forgot password?'");
    }

    @Override
    public void loginSSO(LoginPO loginPO, UserAccount userAccount) {
        loginPO.inputPassword.sendKeys(userAccount.getPassword());
        loginPO.inputEmail.sendKeys(userAccount.getEmail());
        loginPO.btnShowPw.click();
        loginPO.btnLogin.click();
    }

    @Override
    public void loginWithInvalidAccounts(LoginPO loginPO, String email, String password) {
        loginPO.inputEmail.sendKeys(email);
        loginPO.inputPassword.sendKeys(password);
        loginPO.inputPassword.sendKeys(Keys.ENTER);
    }

    @Override
    public void loginWithRememberMe(WebDriver webDriver, UserAccount userAccount) {
        TestArchitectPO testArchitectPO = new TestArchitectPO(webDriver);
        LoginPO loginPO = new LoginPO(webDriver);
        IGeneralAction generalA = new GeneralAction();

        // go to the page 'Login'
        webDriver.manage().window().maximize();
        webDriver.navigate().to(URL.taURL);
        testArchitectPO.btnLogin.click();

        // login successfully with the option 'Remember me?'
        loginPO.inputEmail.sendKeys(userAccount.getEmail());
        loginPO.inputPassword.sendKeys(userAccount.getPassword());
        loginPO.inputRememberMe.click();
        loginPO.btnLogin.click();

        // verify the account name display on the navigation bar
        generalA.verifyTextDisplay(userAccount.getFirstName() + " " + userAccount.getLastName(),
                testArchitectPO.accountName, false);

        // close the current window
        webDriver.close();
    }

    @Override
    public void loginAgainByRememberMe(WebDriver webDriver) {
        webDriver = new ChromeDriver();
        INavigateAction navigateA = new NavigateAction();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        navigateA.gotoTAPage();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        testArchitectPO.btnLogin.click();
    }
}
