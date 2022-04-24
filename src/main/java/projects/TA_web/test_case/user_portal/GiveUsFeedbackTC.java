package projects.TA_web.test_case.user_portal;

import base_test.BaseTest;

public class GiveUsFeedbackTC extends BaseTest {
    /**
     * Test case 01: Verify UI items on the page 'Leave a message'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Give us feedback'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Verify UI items
     *  + Title: Give Us Feedback, Message History
     *  + Label: Question/ Comment
     *  + Buttons: Attached Files, Send Message
     *  + Table headers: Date, Message, Status
     *  + Pagination section
     */

    /**
     * Test case 02: Verify the error messages appear properly when selecting attached unfit images filetypes
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Give us feedback'
     *  + Select the account menu
     *  + Select the tab 'Manage my account'
     *  + Select the menu 'Account'
     *  + Select the option 'Change password'
     * 4. Attach a few unfit images filetypes, then verify the error messages appear
     *  + Select a text file, eg: file .docs
     *  + Verify the error message that it is 'The file must be a file of type: jpeg, jpg, png'
     *  + Select an image file with giant size, eg: 10mb
     *  + Verify the error message display that it is 'File size must be < 5MB.'
     *  + Select an appropriate image, eg: file size is <5mb, and file type is jpeg
     *  + Verify the error message does not display
     */



//
//    /**
//     * Test case 01: Verify the UI of the page 'Leave a message'
//     * 1. Go to the page 'Leave a message'
//     *  + Open and enter the url http://frontend.taportal.com:8080/user to the browser address
//     *  + Press the key 'Enter'
//     *  + Select the tab 'Leave a message'
//     * 2. Verify the UI items on the form 'Leave a message'
//     *  + The form title
//     *  + All label fields: First name, Last name, Email, Phone, Question/Comment
//     *  + All input fields: First name, Last name, Email, Phone, Question/Comment
//     *  + All button: Attach file, Send message
//     *  + All error messages and icon 'Warning' are hide
//     * 3. Verify the UI items on the table 'History message', including:
//     *  + The table title
//     *  + All table headers fields: Date, message, Status
//     *  + Pagination area
//     * 4. Verify icons 'Warning' and error messages for fields: 'First name, Last name, Email, Phone' appear fully
//     *  + Enter nothing to all fields, and select the button 'Send message'
//     *  + Verify icons 'Warning' and error messages for fields: 'First name, Last name, Email, Phone' appear fully
//     */
//    @Test(priority = 1,
//            testName = "Test case 01: Verify the UI of the page 'Leave a message'",
//            description = "Verify All main UI items display fully on the page 'Leave a message'")
//    public void TC01_Verify_the_UI_of_the_page_Leave_a_message() {
//        System.out.println("Test case 01: Verify the UI of the page 'Leave a message'");
//        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
//        LeaveAMessagePO leaveAMsgPO = new LeaveAMessagePO(Constant.webDriver);
//        INavigateAction navigateA = new NavigateAction();
//        GeneralAction generalA = new GeneralAction();
//        DataTestTAWeb dataTest = new DataTestTAWeb();
//
//        try {
//            LogReport.logMainStep("1. Go to the page 'Leave a message'");
//            LogReport.logSubStep("Open and enter the url http://frontend.taportal.com:8080/user to the browser address");
//            LogReport.logSubStep("Press the key 'Enter'");
//            LogReport.logSubStep("Select the tab 'Leave a message'");
//            navigateA.goToLeaveAMessagePage(Constant.webDriver, userPortalPO);
//
//            LogReport.logMainStep("2. Verify the UI items on the form 'Leave a message'");
//            LogReport.logSubStep("Verify label texts of all fields and button on the form are shows as the design");
//            generalA.verifyTextDisplay(dataTest.h5LeaveAMsg, leaveAMsgPO.h5Title, false);
//            generalA.verifyTextDisplay(dataTest.labelFirstName, leaveAMsgPO.labelFirstName, false);
//            generalA.verifyTextDisplay(dataTest.labelLastName, leaveAMsgPO.labelLastName, false);
//            generalA.verifyTextDisplay(dataTest.labelEmail, leaveAMsgPO.labelEmail, false);
//            generalA.verifyTextDisplay(dataTest.labelPhone, leaveAMsgPO.labelPhone, false);
//            generalA.verifyTextDisplay(dataTest.labelQuestion, leaveAMsgPO.labelQuestionAndComment, false);
//            generalA.verifyTextDisplay(dataTest.btnSendMsg, leaveAMsgPO.btnSendMsg, false);
//            generalA.verifyTextDisplay(dataTest.inputAttachFile, leaveAMsgPO.labelAttachFile, false);
//
//            LogReport.logSubStep("Verify all input fields display fully on the form");
//            generalA.verifyElementDisplayed(leaveAMsgPO.inputFirstName, "The input field 'First name'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.inputLastName, "The input field 'Last name'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.inputEmail, "The input field 'Email'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.inputPhone, "The input field 'Phone'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.textareaQuestionAndComment, "The text are Question/Comment");
//
//            LogReport.logSubStep("All error messages and icon 'Warning' are hide");
//            generalA.verifyElementHidden(leaveAMsgPO.labelErrorMsgFirstNameBy, Constant.webDriver, "The error message for the field 'First name'");
//            generalA.verifyElementHidden(leaveAMsgPO.svgIconWarningFirstNameBy, Constant.webDriver, "The icon 'Warning' for the field 'First name'");
//            generalA.verifyElementHidden(leaveAMsgPO.labelErrorMsgLastNameBy, Constant.webDriver, "The error message for the field 'Last name'");
//            generalA.verifyElementHidden(leaveAMsgPO.svgIconWarningLastNameBy, Constant.webDriver, "The icon 'Warning' for the field 'Last name'");
//            generalA.verifyElementHidden(leaveAMsgPO.labelErrorMsgEmailBy, Constant.webDriver, "The error message for the field 'Email'");
//            generalA.verifyElementHidden(leaveAMsgPO.svgIconWarningEmailBy, Constant.webDriver, "The icon 'Warning' for the field 'Last name'");
//            generalA.verifyElementHidden(leaveAMsgPO.labelErrorMsgPhoneBy, Constant.webDriver, "The error message for the field 'Phone'");
//
//            LogReport.logMainStep("3. Verify the UI items on the table 'History message'");
//            generalA.verifyTextDisplay(dataTest.divTableTitle, leaveAMsgPO.divTableTitle, false);
//            generalA.verifyTextDisplay(dataTest.thDate, leaveAMsgPO.spanTableHeaderDate, false);
//            generalA.verifyTextDisplay(dataTest.thMessage, leaveAMsgPO.spanTableHeaderMessage, false);
//            generalA.verifyTextDisplay(dataTest.thStatus, leaveAMsgPO.spanTableHeaderStatus, false);
//            generalA.verifyElementDisplayed(leaveAMsgPO.navPaginationArea, "The pagination section");
//
//            LogReport.logMainStep("4. Verify icons 'Warning' and error messages for fields: 'First name, Last name, Email, Phone' appear fully");
//            LogReport.logSubStep("Enter nothing to all fields, and select the button 'Send message'");
//            LogReport.logSubStep("Verify icons 'Warning' and error messages for fields: 'First name, Last name, Email, Phone' appear fully");
//            leaveAMsgPO.btnSendMsg.click();
//            generalA.verifyElementDisplayed(leaveAMsgPO.labelErrorMsgFirstName, "The error message for the field 'First name'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.svgIconWarningFirstName, "The icon 'Warning' for the field 'First name'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.labelErrorMsgLastName, "The error message for the field 'Last name'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.svgIconWarningLastName, "The icon 'Warning' for the field 'Last name'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.labelErrorMsgEmail, "The error message for the field 'Email'");
//            generalA.verifyElementDisplayed(leaveAMsgPO.svgIconWarningEmail, "The icon 'Warning' for the field 'Last name'");
//            generalA.verifyElementHidden(leaveAMsgPO.labelErrorMsgPhoneBy, Constant.webDriver, "The error message for the field 'Phone'");
//
//        } catch (Exception exception) {
//            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
//                    Constant.webDriver.getCurrentUrl(), exception);
//            exception.printStackTrace();
//        }
//    }
//
//    /**
//     * Test case 02: Verify the error messages appear proper for both fields 'First name*' and 'Last name*'
//     * 1. Go to the page 'Leave a message'
//     *  + Open and enter the url http://frontend.taportal.com:8080/user to the browser address
//     *  + Press the key 'Enter'
//     *  + Select the tab 'Leave a message'
//     * 2. Verify texts and error messages show on proper after entering some texts to the field 'First name*', 'Last name*'
//     * + Enter long texts to these field that is greater than 200 characters, then click any points on the screen
//     * -> Verify texts display on these fields are 200 letters
//     * + Enter texts consist white space letters at the beginning and ending places, eg: "  TEst    ", then click any points on the screen
//     * -> Verify texts displaying on these fields are trimmed
//     * + Enter Unicode text to these fields, eg: Khánh らが 123, then click any points on the screen
//     * -> Verify texts displaying on these fields are unchanged
//     * + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter, then click any points on the screen
//     * -> Expected result: The error message: 'Please remove special characters.' displays
//     */
//    @Test(priority = 2,
//            testName = "Test case 02: Verify the error messages appear proper for both fields 'First name*' and 'Last name*'",
//            description = "Verify the error messages display proper on the page",
//            dataProviderClass = DataTestSSO.class,
//            dataProvider = "getDataForFieldName")
//    public void TC02_Verify_the_UI_of_the_page_Leave_a_message(String textName, String textDisplay, String errorMsg) {
//        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
//        LeaveAMessagePO leaveAMsgPO = new LeaveAMessagePO(Constant.webDriver);
//        INavigateAction navigateA = new NavigateAction();
//        GeneralAction generalA = new GeneralAction();
//
//        try {
//            LogReport.logMainStep("1. Go to the page 'Leave a message'");
//            LogReport.logSubStep("Open and enter the url http://frontend.taportal.com:8080/user to the browser address");
//            LogReport.logSubStep("Press the key 'Enter'");
//            LogReport.logSubStep("Select the tab 'Leave a message'");
//            navigateA.goToLeaveAMessagePage(Constant.webDriver, userPortalPO);
//
//            LogReport.logMainStep("2. Verify texts or error messages, icon 'Warning' show on proper after entering some texts to the field 'First name*', 'Last name*'");
//            LogReport.logSubStep("Enter texts to these fields: 'First name', 'Last name'");
//            LogReport.logSubStep("click any points on the screen");
//            leaveAMsgPO.inputFirstName.sendKeys(textName);
//            leaveAMsgPO.inputLastName.sendKeys(textName);
//            leaveAMsgPO.h5Title.click();
//
//            if (errorMsg.equals("")) {
//                generalA.verifyTextDisplay(textDisplay, leaveAMsgPO.inputFirstName, true);
//                generalA.verifyTextDisplay(textDisplay, leaveAMsgPO.inputLastName, true);
//            } else {
//                generalA.verifyTextDisplay(errorMsg, leaveAMsgPO.labelErrorMsgFirstName, false);
//                generalA.verifyTextDisplay(errorMsg, leaveAMsgPO.labelErrorMsgLastName, false);
//            }
//
//        } catch (Exception exception) {
//            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
//                    Constant.webDriver.getCurrentUrl(), exception);
//            exception.printStackTrace();
//        }
//    }
//
//    /**
//     * Test case 03: Verify the error message displays appropriate or hides that is belong to the email value
//     * 1. Go to the page 'Leave a message'
//     *  + Open and enter the url http://frontend.taportal.com:8080/user to the browser address
//     *  + Press the key 'Enter'
//     *  + Select the tab 'Leave a message'
//     * 2. Enter an email value to the field 'Email'
//     * + Enter an email value
//     * + Click any points on the screen, except the button 'Next', eg: Click the title page
//     * 3. Verify the error message of the field 'email' displays proper
//     * 4. Repeat step 2, 3 with these email values
//     "testlogigear#logigear.com";
//     "testlogigear@";
//     "@testlogigear.com";
//     "test@test@logigear.com";
//     "logigear.com";
//     "logigear@.com";
//     "activated.account@gyumail";
//     "activated gondola@gmail.com";
//     "activated.gondola@g mail.com";
//     "emailNoExistingInDatabase@gmail.com";
//     */
//    @Test(priority = 3,
//            testName = "Test case 03: Verify the error message displays appropriate or hides that is belong to the email value",
//            description = "Verify the error messages and icon 'Warning' display proper for the field 'Email'",
//            dataProviderClass = DataTestSSO.class,
//            dataProvider = "getDataToCheckFieldEmail")
//    public void TC03_Verify_the_error_message_displays_appropriate_or_hides_that_is_belong_to_the_email_value
//    (String email, String errorMsg) {
//        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
//        LeaveAMessagePO leaveAMsgPO = new LeaveAMessagePO(Constant.webDriver);
//        INavigateAction navigateA = new NavigateAction();
//        GeneralAction generalA = new GeneralAction();
//
//        try {
//            LogReport.logMainStep("1. Go to the page 'Leave a message'");
//            LogReport.logSubStep("Open and enter the url http://frontend.taportal.com:8080/user to the browser address");
//            LogReport.logSubStep("Press the key 'Enter'");
//            LogReport.logSubStep("Select the tab 'Leave a message'");
//            navigateA.goToLeaveAMessagePage(Constant.webDriver, userPortalPO);
//
//            LogReport.logMainStep("2. Enter an email value to the field 'Email'");
//            LogReport.logSubStep("Enter the email value, eg: " + email);
//            LogReport.logSubStep("Click any points on the screen, except the button 'Next', eg: Click the title page");
//            leaveAMsgPO.inputEmail.sendKeys(email);
//            leaveAMsgPO.h5Title.click();
//
//            LogReport.logMainStep("3. Verify the error message shows on the field 'Email'");
//            if (!errorMsg.equals("")) {
//                generalA.verifyTextDisplay(errorMsg, leaveAMsgPO.labelErrorMsgEmail, false);
//                generalA.verifyElementDisplayed(leaveAMsgPO.svgIconWarningEmail, "The icon 'Warning' for the field email");
//            } else {
//                generalA.verifyElementHidden(leaveAMsgPO.labelErrorMsgEmailBy, Constant.webDriver, "The error message for the field email");
//                generalA.verifyElementHidden(leaveAMsgPO.svgIconWarningEmailBy, Constant.webDriver, "The icon 'Warning' for the field email");
//            }
//
//        } catch (Exception exception) {
//            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
//                    Constant.webDriver.getCurrentUrl(), exception);
//            exception.printStackTrace();
//        }
//    }
//
//    /**
//     * Test case 04: Verify the error message displays proper that is belong to the phone value
//     * 1. Go to the page 'Leave a message'
//     *  + Open and enter the url http://frontend.taportal.com:8080/user to the browser address
//     *  + Press the key 'Enter'
//     *  + Select the tab 'Leave a message'
//     * 2. Enter a text value to the field 'Phone'
//     * + Enter a text value to the field 'Phone'
//     * + Click any points on the screen, eg: Click the title page
//     * 3. Verify the error message of the field 'email' displays proper
//     * 4. Repeat step 2, 3 with these phone values
//     * + it is empty values
//     * + it has 10-15 letters, however that consists a/ some letters
//     * -> Expected: The error message displays: Please enter a valid phone number
//     * + it has 10-15 letters, however that consists a/ a few special letters,
//     * -> Expected: The error message displays: Please enter a valid phone number
//     * + less than 10 characters
//     * -> Expected: The error message displays: Phone numbers must be from 10 to 15 characters.
//     * + greater than 15 characters
//     * -> Expected: The error message displays: Phone numbers must be from 10 to 15 characters.
//     * + it has 10-15 numbers, however, it does not has the letter '+' at the beginning
//     * -> Expected: The error message does not appear
//     * + it has 10-15 numbers, and also has the letter '+' at the beginning
//     * -> Expected: The error message does not appear
//     */
//    @Test(priority = 4,
//            testName = "Test case 04: Verify the error message displays proper that is belong to the phone value",
//            description = "Verify the error messages and icon 'Warning' display proper for the field 'Phone'",
//            dataProviderClass = DataTestTAWeb.class,
//            dataProvider = "getDataForFieldPhone")
//    public void TC04_Verify_the_error_message_displays_proper_that_is_belong_to_the_phone_value
//    (String phone, String errorMsgExpected) {
//        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
//        LeaveAMessagePO leaveAMsgPO = new LeaveAMessagePO(Constant.webDriver);
//        INavigateAction navigateA = new NavigateAction();
//        GeneralAction generalA = new GeneralAction();
//
//        try {
//            LogReport.logMainStep("1. Go to the page 'Leave a message'");
//            LogReport.logSubStep("Open and enter the url http://frontend.taportal.com:8080/user to the browser address");
//            LogReport.logSubStep("Press the key 'Enter'");
//            LogReport.logSubStep("Select the tab 'Leave a message'");
//            navigateA.goToLeaveAMessagePage(Constant.webDriver, userPortalPO);
//
//            LogReport.logMainStep("2. Enter a value to the field 'Phone'");
//            LogReport.logSubStep("Enter a value to the field 'Phone', eg: " + phone);
//            LogReport.logSubStep("Click to any point on the screen, eg: Click the title page");
//            leaveAMsgPO.inputPhone.sendKeys(phone);
//            leaveAMsgPO.h5Title.click();
//
//            LogReport.logMainStep("3. Verify the error message for the field 'email' displays proper");
//            if (!errorMsgExpected.equals("")) {
//                generalA.verifyTextDisplay(errorMsgExpected, leaveAMsgPO.labelErrorMsgPhone, false);
//            } else {
//                generalA.verifyElementHidden(leaveAMsgPO.labelErrorMsgPhoneBy, Constant.webDriver,
//                        "The error message of the field 'Phone'");
//            }
//
//        } catch (Exception exception) {
//            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
//                    Constant.webDriver.getCurrentUrl(), exception);
//            exception.printStackTrace();
//        }
//    }

//    /**
//     * Test case 05: Verify the error message displays proper after selecting the attached file
//     * 1. Go to the page 'Leave a message'
//     *  + Open and enter the url http://frontend.taportal.com:8080/user to the browser address
//     *  + Press the key 'Enter'
//     *  + Select the tab 'Leave a message'
//     *
//     *
//     *
//     *
//     * 2. Enter a text value to the field 'Phone'
//     * + Enter a text value to the field 'Phone'
//     * + Click any points on the screen, eg: Click the title page
//     * 3. Verify the error message of the field 'email' displays proper
//     * 4. Repeat step 2, 3 with these phone values
//     * + it is empty values
//     * + it has 10-15 letters, however that consists a/ some letters
//     * -> Expected: The error message displays: Please enter a valid phone number
//     * + it has 10-15 letters, however that consists a/ a few special letters,
//     * -> Expected: The error message displays: Please enter a valid phone number
//     * + less than 10 characters
//     * -> Expected: The error message displays: Phone numbers must be from 10 to 15 characters.
//     * + greater than 15 characters
//     * -> Expected: The error message displays: Phone numbers must be from 10 to 15 characters.
//     * + it has 10-15 numbers, however, it does not has the letter '+' at the beginning
//     * -> Expected: The error message does not appear
//     * + it has 10-15 numbers, and also has the letter '+' at the beginning
//     * -> Expected: The error message does not appear
//     */




}
