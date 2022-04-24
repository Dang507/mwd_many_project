package SSO_project.action.implement_action;

import SSO_project.action.ISignUpAction;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.SignUpPO;
import common.SSOUtilImpA;
import common.ISSOUtilA;
import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;

public class SignUpAction implements ISignUpAction {

    @Override
    public void createSSOAccount(SignUpPO signUpPO, UserAccount userAccount){
        enterValuesToFirstForm(signUpPO, userAccount);
        signUpPO.btnNext.click();
        enterValuesToFinalForm(signUpPO, userAccount);
        signUpPO.btnCreateAccount.click();
    }

    @Override
    public void checkAllFieldsDisplayOnFirstForm(IGeneralAction generalA, SignUpPO signUpPO){
        generalA.verifyElementDisplayed(signUpPO.imgLogoLogiGear, "The logo image 'LogiGear'");
        generalA.verifyElementDisplayed(signUpPO.h1Title, "The title of page 'Sign up'");
        generalA.verifyElementDisplayed(signUpPO.labelFirstName, "The label 'First name*'");
        generalA.verifyElementEnable(signUpPO.inputFirstName, "The input field 'First name' ");
        generalA.verifyElementDisplayed(signUpPO.labelLastName, "The label 'Last name*'");
        generalA.verifyElementEnable(signUpPO.inputLastName, "The input field 'Last name' ");
        generalA.verifyElementDisplayed(signUpPO.labelEmail, "The label 'Email*'");
        generalA.verifyElementEnable(signUpPO.inputEmail, "The input field 'Email' ");
        generalA.verifyElementDisplayed(signUpPO.labelPw, "The label 'Password*'");
        generalA.verifyElementEnable(signUpPO.inputPassword, "The input field 'Password' ");
        generalA.verifyElementDisplayed(signUpPO.labelConfirmPw, "The label 'Confirm password*'");
        generalA.verifyElementEnable(signUpPO.inputConfirmPW, "The input field 'Confirm password' ");
        generalA.verifyElementDisplayed(signUpPO.btnNext, "The button 'Next' ");
        generalA.verifyElementDisplayed(signUpPO.aSignInHere, "The link 'Sign in here' ");
        generalA.verifyElementDisplayed(signUpPO.imgLogoTrust, "The logo image 'Trust' ");
        generalA.verifyElementDisplayed(signUpPO.btnShowPw, "The button 'Show password'");
        generalA.verifyElementDisplayed(signUpPO.btnShowConfirmPw, "The button 'Show confirmed password'");
    }

    @Override
    public void checkAllErrorMsgAndIconsHideOnFirstForm(WebDriver webDriver, IGeneralAction generalA, SignUpPO signUpPO){
        generalA.verifyElementHidden(signUpPO.labelErrorFirstNameBy, webDriver, "The error message of the field 'First name'");
        generalA.verifyElementHidden(signUpPO.labelErrorLastNameBy, webDriver, "The error message of the field 'Last name'");
        generalA.verifyElementHidden(signUpPO.labelErrorEmailBy, webDriver, "The error message of the field 'Email'");
        generalA.verifyElementHidden(signUpPO.labelErrorPwBy, webDriver, "The error message of the field 'Password'");
        generalA.verifyElementHidden(signUpPO.labelErrorConfirmedPwBy, webDriver, "The error message of the field 'Confirm Password'");
        generalA.verifyElementHidden(signUpPO.svgIconWarningFirstNameBy, webDriver, "The icon 'Warning' of the field 'First name'");
        generalA.verifyElementHidden(signUpPO.svgIconWarningLastNameBy, webDriver, "The icon 'Warning' of the field 'Last name'");
        generalA.verifyElementHidden(signUpPO.svgIconWarningEmailBy, webDriver, "The icon 'Warning' of the field 'Email'");
        generalA.verifyElementHidden(signUpPO.svgIconWarningPwBy, webDriver, "The icon 'Warning' of the field 'Password'");
        generalA.verifyElementHidden(signUpPO.svgIconWarningConfirmPwBy, webDriver, "The icon 'Warning' of the field 'Confirm Password'");
    }

    @Override
    public void checkAllErrorMsgAndIconsDisplayOnFirstForm(IGeneralAction generalA, SignUpPO signUpPO){
        generalA.verifyElementDisplayed(signUpPO.labelErrorFirstName, "The label error of the field 'First name' ");
        generalA.verifyElementDisplayed(signUpPO.labelErrorLastName, "The label error of the field 'Last name' ");
        generalA.verifyElementDisplayed(signUpPO.labelErrorEmail, "The label error of the field 'Email' ");
        generalA.verifyElementDisplayed(signUpPO.labelErrorPw, "The label error of the field 'Password' ");
        generalA.verifyElementDisplayed(signUpPO.labelErrorConfirmedPw, "The label error of the field 'Confirm password' ");
        generalA.verifyElementDisplayed(signUpPO.svgIconWarningFirstName, "The icon 'Warning' of the field 'First name' ");
        generalA.verifyElementDisplayed(signUpPO.svgIconWarningLastName, "The icon 'Warning' of the field 'Last name' ");
        generalA.verifyElementDisplayed(signUpPO.svgIconWarningEmail, "The icon 'Warning' of the field 'Last name' ");
        generalA.verifyElementDisplayed(signUpPO.svgIconWarningPw, "The icon 'Warning' of the field 'Password' ");
        generalA.verifyElementDisplayed(signUpPO.svgIconWarningConfirmPw, "The icon 'Warning' of the field 'Confirm password' ");
    }

    @Override
    public void checkAllFieldsDisplayOnFinalForm(IGeneralAction generalA, SignUpPO signUpPO){
        generalA.verifyElementDisplayed(signUpPO.h1TitleFinalForm, "The title of the final form");
        generalA.verifyElementDisplayed(signUpPO.labelTitle, "The label 'Title'");
        generalA.verifyElementEnable(signUpPO.inputTitle, "The input field 'Title' ");
        generalA.verifyElementDisplayed(signUpPO.labelCompany, "The label 'Company'");
        generalA.verifyElementEnable(signUpPO.inputCompany, "The input field 'Company' ");
        generalA.verifyElementDisplayed(signUpPO.labelCountry, "The label 'Country'");
        generalA.verifyElementEnable(signUpPO.selectCountry, "The selection field 'Country' ");
        generalA.verifyElementDisplayed(signUpPO.labelState, "The label 'State'");
        generalA.verifyElementEnable(signUpPO.selectState, "The selection field 'State' ");
        generalA.verifyElementDisplayed(signUpPO.labelPhone, "The label 'Phone'");
        generalA.verifyElementEnable(signUpPO.inputPhone, "The input field 'Phone' ");
        generalA.verifyElementDisplayed(signUpPO.btnCreateAccount, "The button 'Create free account' ");
        generalA.verifyElementDisplayed(signUpPO.divBack, "The button 'Back' ");
    }

    @Override
    public void checkAllErrorMsgAndIconsHideOnFinalForm(WebDriver webDriver, IGeneralAction generalA, SignUpPO signUpPO) {
        generalA.verifyElementHidden(signUpPO.labelErrorPhoneBy, webDriver, "The error message for the field 'Phone'");
    }

    @Override
    public void checkAllErrorMsgAndIconsDisplayOnFinalForm(IGeneralAction generalA, SignUpPO signUpPO, String invalidPhone){
        signUpPO.inputPhone.sendKeys(invalidPhone);
        signUpPO.inputTitle.click();
        generalA.verifyElementDisplayed(signUpPO.labelErrorPhone, "The label error of the input field 'Phone' ");
    }

    @Override
    public void goToFinalForm(SignUpPO signUpPO, UserAccount userAccount) {
        signUpPO.inputPassword.sendKeys(userAccount.getPassword());
        signUpPO.inputConfirmPW.sendKeys(userAccount.getConfirmPw());
        signUpPO.inputFirstName.sendKeys(userAccount.getFirstName());
        signUpPO.inputLastName.sendKeys(userAccount.getLastName());
        signUpPO.inputEmail.sendKeys(userAccount.getEmail());
        signUpPO.btnShowPw.click();
        signUpPO.btnShowConfirmPw.click();
        signUpPO.btnNext.click();
    }

    @Override
    public void enterValuesToFirstForm(SignUpPO signUpPO, UserAccount userAccount) {
        signUpPO.inputFirstName.sendKeys(userAccount.getFirstName());
        signUpPO.inputPassword.sendKeys(userAccount.getPassword());
        signUpPO.inputConfirmPW.sendKeys(userAccount.getConfirmPw());
        signUpPO.inputLastName.sendKeys(userAccount.getLastName());
        signUpPO.inputEmail.sendKeys(userAccount.getEmail());
        signUpPO.btnShowPw.click();
        signUpPO.btnShowConfirmPw.click();
    }

    @Override
    public void enterValuesToFinalForm(SignUpPO signUpPO, UserAccount userAccount){
        ISSOUtilA ssoUtilA = new SSOUtilImpA();
        ssoUtilA.selectOptionByText(signUpPO.selectCountry, userAccount.getCountry());
        signUpPO.inputTitle.sendKeys(userAccount.getTitle());
        signUpPO.inputCompany.sendKeys(userAccount.getCompany());
        signUpPO.inputPhone.sendKeys(userAccount.getPhone());
        ssoUtilA.selectOptionByText(signUpPO.selectState, userAccount.getState());
    }

}

