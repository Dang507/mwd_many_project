package SSO_project.data_test;

import SSO_project.entity.UserAccount;
import common.TimeUtil;
import org.testng.annotations.DataProvider;

public class DataTestSSO {
    // invalid email keyword
    public String email_missing_symbol = "testlogigear#logigear.com";
    public String email_missing_domainName = "testlogigear@";
    public String email_username_is_missing = "@testlogigear.com";
    public String email_many_symbol = "test@test@logigear.com";
    public String email_miss_username_and_symbol = "logigear.com";
    public String emailDomain_only_has_dotcom = "logigear@.com";
    public String email_miss_dot_com = "activated.account@gyumail";
    public String emailName_contain_white_space = "activated gondola@gmail.com";
    public String emailDomain_contain_white_space = "activated.gondola@g mail.com";
    public String email_never_register_before = "emailNoExistingInDatabase@gmail.com";

    // invalid password keyword
    public String pw_only_number = "24682468";
    public String pw_only_string = "StringPassword";
    public String pw_contain_special_char = "12#$/|().<>,";
    public String pw_has_whitespace = "#Fex123    ;Test-";
    public String pw_not_enough_length = "#Fex123";
    public String pw_is_over_100_letters = "pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345p";
    public String pw_is_over_128_letters = "pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345pass-12345";

    // valid password keyword
    public String pw_activated_1 = "pass-2468";
    public String pw_activated_strong = "#Fex123%Test";
    public String pw_valid_strong = "#F123%Test$@/[~<;`/*-+,./;'[]\\-=_+{}|:<>?`~";

    // invalid phone number keyword
    public String phone_contain_special_char = "(+44)-7911.1234$@/[~<;`/*-+,./;'[]\\-=_+{}|:<>?`~#%";
    public String phone_contain_text_char = "re3456789&:";
    public String phone_invalid_format = "44 +79111234";
    public String phone_less_than_10_number = "079522446";
    public String phone_greater_than_15_numbers = "0909999990123456";

    // invalid active code
    public String active_code_short = "c8144eb9bffaf70fe62d5";
    public String active_code_extensive = "c8144eb9bffaf70fe62d5c8144eb9bffaf70fe62d5be14cc0121clgcms61dd35238fd62";
    public String active_code_outdated = "c8144eb9bffaf70fe62d5be14cc0121clgcms6203607405dff";

    // valid active code, every times running test case, need to change this code to proper with testing account
    public String active_code_valid = "";

    // valid phone number keyword
    public String valid_phone_1 = "0909999990";
    public String valid_phone_2 = "+84 0905 231118";
    public String phone_has_space_at_beginning_ending = " 0905 231 118 ";

    // valid first name keyword
    public String name_by_unicode_text = "Khánh らが 123";
    public String name_contain_special_char = "Test $@/[~<;`/*-+,./;'[]\\-=_+{}|:<>?`~#%";
    public String name_extensive_text = "Our codeless automation tool allows you to rapidly scale and maintain tests saving you valuable time Test are easily viewed in spreadsheet like editorOur codeless automation tool allows you to rapidly scale and maintain tests saving you valuable time Test are easily viewed in spreadsheet like editor";
    public String name_long_text_display = "Our codeless automation tool allows you to rapidly scale and mai";

    public String text_white_space_at_begining_ending = "  TEst    ";

    public UserAccount activated_SSO_account = new UserAccount("internal testing only",
            "please ignored", "qatesting64@yopmail.com", "pass-02468",
            "pass-02468", "Logigear Test", "Logigear", "Uganda", "Abim", "0909999990");

    public UserAccount inactivated_SSO_account = new UserAccount("internal testing only", "please ignored",
            "qatesting113@yopmail.com", "pass-02468", "pass-02468", "Logigear Test",
            "Logigear Test", "Uganda", "Abim", "0909999990");

    // phone number error message
    public String error_msg_phone_short_or_too_long = "Phone numbers must be from 10 to 15 characters.";
    public String error_msg_phone_invalid_number = "Please enter a valid phone number.";

    // valid account, however it is an never register account
    public UserAccount valid_account_all_fields_available = new UserAccount("internal testing only", "please ignored",
            "qatestinglogigear" + TimeUtil.getSystemTimeHMS("yyyyMMddHHmmss") + "@gmail.com",
            "pass-02468", "pass-2468", "Logigear Test", "Logigear",
            "Germany", "Berlin", "0795232226");

    public UserAccount valid_account_empty_optional_fields = new UserAccount("internal testing only", "please ignored",
            "qatestinglogigear" + TimeUtil.getSystemTimeHMS("yyyyMMddHHmmss") + "@gmail.com",
            "pass-02468", "pass-2468", "", "",
            "", "", "");

    // error message for the empty field
    public String error_msg_empty_field = "This field is required.";

    // empty text
    public String empty_text = "";

    // title web page
    public String text_on_page_thank_you = "Thank you for your registration!";

    // Change password page, register page, error and success message:
    public String error_msg_message_pw = "Please choose a stronger password. Try a mix of letters, numbers, and symbols.";
    public String error_msg_short_Pw = "Use 8 characters or more for your password.";
    public String error_msg_extensive_pw = "xxxxxxxx";
    public String error_msg_same_pw = "Your new password is same as your old password. Please use another password.";
    public String success_msg = "Success!";
    public String error_msg_confirm_pw = "Confirm password value must be the same password.";
    public String error_msg_current_pw_wrong = "Your current password cannot match";

    // Reminder page
    public String textContent = "To verify your identity, a security code has been sent to you. Please check the link in the email or coppy and pass the security code here:";

    // Resend email page
    public String warning_msg_active_Code = "Active code has been sent 3 times this date.";
    public String error_msg_invalid_active_code = "Invalid activate code.";

    // existed email for https://stage1.testarchitect.com/
    public String activated_SSO_email = "qatesting82@yopmail.com";
    public String inactivated_SSO_email = "qatesting85@yopmail.com";

    // valid email keyword on the json file
    public String valid_email_1 = "testlogigear@logigear.com";
    public String valid_email_2 = "activated.qatesting@gmail.com";
    public String email_white_space_at_begining_and_ending = "      activated.qatesting@gmail.com      ";

    // email error message
    public String error_msg_existed_email = "Email existed in database";
    public String error_msg_invalid_email = "Please enter a valid email.";
    public String error_msg_email_no_existing_in_database = "Email not existing in database.";

    // Register page, the first / last name
    public String error_msg_special_letters_for_name = "Please remove special characters.";
    public String error_msg_long_string = "Please enter no more than 100 characters.";

    // Login page
    public String error_msg_wrong_email_or_pw = "Incorrect email or password. Please try again!";

    // extensive text
    public String text_284_characters = "Are you looking for a Test Automation tool that can bring all of your team members into a collaborative Automation production process? If so, TestArchitect is a great fit. With TestArchitect, you can leverage a smaller programming staff to support a much larger non-programming staff.";

    public DataTestSSO() {
    }

    @DataProvider
    public Object[][] getDataToCheckFieldEmail() {
        Object[][] data = new Object[11][2];
        // row 1, letter '#' instead of '@'
        data[0][0] = email_missing_symbol;
        data[0][1] = error_msg_invalid_email;
        // row 2, email without domain name
        data[1][0] = email_missing_domainName;
        data[1][1] = error_msg_invalid_email;
        // row 3, email without user name
        data[2][0] = email_username_is_missing;
        data[2][1] = error_msg_invalid_email;
        // row 4, email has many letter '@'
        data[3][0] = email_many_symbol;
        data[3][1] = error_msg_invalid_email;
        // row 5, email without user name and letter '@'
        data[4][0] = email_miss_username_and_symbol;
        data[4][1] = error_msg_invalid_email;
        // row 6, email without organization name
        data[5][0] = emailDomain_only_has_dotcom;
        data[5][1] = error_msg_invalid_email;
        // row 7, email without letter '.' and other behind letters
        data[6][0] = email_miss_dot_com;
        data[6][1] = error_msg_invalid_email;
        // row 8, email has letter white space into user name
        data[7][0] = emailName_contain_white_space;
        data[7][1] = error_msg_invalid_email;
        // row 9, email has letter white space into domain name
        data[8][0] = emailDomain_contain_white_space;
        data[8][1] = error_msg_invalid_email;
        // row 10, email is empty
        data[9][0] = empty_text;
        data[9][1] = error_msg_empty_field;
        // row 11, email is a valid value, nevertheless, it has never registered before
        data[10][0] = email_white_space_at_begining_and_ending;
        data[10][1] = error_msg_email_no_existing_in_database;
        return data;
    }

    @DataProvider
    public Object[][] getDataToTestLoginPage() {
        Object[][] data = new Object[12][3];
        // row 1, letter '#' instead of '@'
        data[0][0] = email_missing_symbol;
        data[0][1] = pw_activated_1;
        data[0][2] = error_msg_invalid_email;
        // row 2, email without domain name
        data[1][0] = email_missing_domainName;
        data[1][1] = pw_activated_1;
        data[1][2] = error_msg_invalid_email;
        // row 3, email without user name
        data[2][0] = email_username_is_missing;
        data[2][1] = pw_activated_1;
        data[2][2] = error_msg_invalid_email;
        // row 4, email has many letter '@'
        data[3][0] = email_many_symbol;
        data[3][1] = pw_activated_1;
        data[3][2] = error_msg_invalid_email;
        // row 5, email without user name and letter '@'
        data[4][0] = email_miss_username_and_symbol;
        data[4][1] = pw_activated_1;
        data[4][2] = error_msg_invalid_email;
        // row 6, email without organization name
        data[5][0] = emailDomain_only_has_dotcom;
        data[5][1] = pw_activated_1;
        data[5][2] = error_msg_invalid_email;
        // row 7, email without letter '.' and other behind letters
        data[6][0] = email_miss_dot_com;
        data[6][1] = pw_activated_1;
        data[6][2] = error_msg_invalid_email;
        // row 8, email has letter white space into user name
        data[7][0] = emailName_contain_white_space;
        data[7][1] = pw_activated_1;
        data[7][2] = error_msg_invalid_email;
        // row 9, email has letter white space into domain name
        data[8][0] = emailDomain_contain_white_space;
        data[8][1] = pw_activated_1;
        data[8][2] = error_msg_invalid_email;
        // row 10, email is empty
        data[9][0] = empty_text;
        data[9][1] = empty_text;
        data[9][2] = error_msg_empty_field;
        // row 11, email is empty
        data[10][0] = email_never_register_before;
        data[10][1] = pw_activated_1;
        data[10][2] = error_msg_wrong_email_or_pw;
        // row 12, email has white space letters at first and the end
        data[11][0] = email_white_space_at_begining_and_ending;
        data[11][1] = pw_activated_1;
        data[11][2] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToLoginSuccessful() {
        Object[] data = new Object[2];
        data[0] = inactivated_SSO_account;
        data[1] = activated_SSO_account;
        return data;
    }

    @DataProvider
    public Object[] getDataForEmailFieldToSignUp() {
        Object[][] data = getDataToCheckFieldEmail();
        // row 11, email is valid email
        data[10][0] = valid_email_1;
        data[10][1] = "";
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckFieldPassword() {
        Object[][] data = new Object[12][2];
        // row 1, the password text is only letters
        data[0][0] = pw_only_string;
        data[0][1] = error_msg_message_pw;
        // row 2, the password text is empty
        data[1][0] = empty_text;
        data[1][1] = error_msg_empty_field;
        // row 3, the password text is only number
        data[2][0] = pw_only_number;
        data[2][1] = error_msg_message_pw;
        // row 4, the password text is only number
        data[3][0] = pw_contain_special_char;
        data[3][1] = error_msg_message_pw;
        // row 5, the password text is less than 8 characters
        data[4][0] = pw_not_enough_length;
        data[4][1] = error_msg_short_Pw;
        // row 6, the password text consists a/a few white space letters between other letters
        data[5][0] = pw_has_whitespace;
        data[5][1] = error_msg_message_pw;
        // row 7, the password text is valid and it consist a large number of special letters
        data[6][0] = pw_valid_strong;
        data[6][1] = "";
        // row 8, the password text is valid and it consist a few special letters
        data[7][0] = pw_activated_strong;
        data[7][1] = "";
        // row 9, the password text is over 100 letters
        data[8][0] = pw_is_over_100_letters;
        data[8][1] = error_msg_extensive_pw;
        // row 9, the password text is valid
        data[9][0] = pw_activated_1;
        data[9][1] = empty_text;
        // row 9, the password text is over 100 letters
        data[10][0] = pw_valid_strong;
        data[10][1] = empty_text;
        // row 9, the password text is over 100 letters
        data[11][0] = pw_activated_strong;
        data[11][1] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataForFieldConfirmPw() {
        Object[][] data = new Object[8][3];
        // row 1, the password text is a valid value,
        data[0][0] = pw_valid_strong;
        data[0][1] = empty_text;
        data[0][2] = error_msg_empty_field;
        // row 2, the value of the field 'Password' and 'Confirm Password' are empty
        data[1][0] = empty_text;
        data[1][1] = empty_text;
        data[1][2] = error_msg_empty_field;
        // row 3, the password text is empty, the value of the field 'Confirm password' is a valid text
        data[2][0] = empty_text;
        data[2][1] = pw_valid_strong;
        data[2][2] = error_msg_confirm_pw;
        // row 4, Values of the field 'Password' and 'Confirm password' are different
        data[3][0] = pw_activated_1;
        data[3][1] = pw_valid_strong;
        data[3][2] = error_msg_confirm_pw;
        // row 5, the password text is less than 8 characters
        data[4][0] = pw_not_enough_length;
        data[4][1] = data[4][0];
        data[4][2] = "";
        // row 6, the password text is only numbers
        data[5][0] = pw_only_number;
        data[5][1] = data[5][0];
        data[5][2] = "";
        // row 7, the password text is over 100 letters
        data[6][0] = pw_is_over_100_letters;
        data[6][1] = data[6][0];
        data[6][2] = "";
        // row 8, the password text is valid and it consist a few special letters
        data[7][0] = pw_only_string;
        data[7][1] = data[7][0];
        data[7][2] = "";
        return data;
    }

    @DataProvider
    public Object[] getDataForFieldPhone() {
        Object[][] data = new Object[9][3];
        // row 1, the phone text is a empty text
        data[0][0] = valid_account_all_fields_available;
        data[0][1] = empty_text;
        data[0][2] = "";
        // row 2, the phone text has some letters
        data[1][0] = data[0][0];
        data[1][1] = phone_contain_text_char;
        data[1][2] = error_msg_phone_invalid_number;
        // row 3, the phone text has some special letters
        data[2][0] = data[0][0];
        data[2][1] = phone_contain_special_char;
        data[2][2] = error_msg_phone_invalid_number;
        // row 4, the phone text is less than 10 numbers
        data[3][0] = data[0][0];
        data[3][1] = phone_less_than_10_number;
        data[3][2] = error_msg_phone_short_or_too_long;
        // row 5, the phone text is greater than 15 numbers
        data[4][0] = data[0][0];
        data[4][1] = phone_greater_than_15_numbers;
        data[4][2] = error_msg_phone_short_or_too_long;
        // row 6, the phone text is mistake format
        data[5][0] = data[0][0];
        data[5][1] = phone_invalid_format;
        data[5][2] = error_msg_phone_invalid_number;
        // row 7, the phone text is valid numbers
        data[6][0] = data[0][0];
        data[6][1] = valid_phone_1;
        data[6][2] = "";
        // row 8, the phone text is valid numbers
        data[7][0] = data[0][0];
        data[7][1] = valid_phone_2;
        data[7][2] = "";
        // row 8, the phone text is valid numbers
        data[8][0] = data[0][0];
        data[8][1] = phone_has_space_at_beginning_ending;
        data[8][2] = "";
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckUISignUpPage() {
        Object[][] data = new Object[1][2];
        data[0][0] = valid_account_all_fields_available;
        data[0][1] = phone_less_than_10_number;
        return data;
    }

    @DataProvider
    public Object[] getDataForFieldName() {
        Object[][] data = new Object[4][3];
        // row 1, the texts are long
        data[0][0] = text_284_characters;
        data[0][1] = text_284_characters.substring(0, 200);
        data[0][2] = "";
        // row 2, the texts consist white space letters at the beginning and ending places
        data[1][0] = text_white_space_at_begining_ending;
        data[1][1] = text_white_space_at_begining_ending.trim();
        data[1][2] = "";
        // row 3, the texts consist a few unicode letters
        data[2][0] = name_by_unicode_text;
        data[2][1] = name_by_unicode_text;
        data[2][2] = "";
        // row 4, the texts consist a few special letters
        data[3][0] = name_contain_special_char;
        data[3][1] = name_contain_special_char;
        data[3][2] = error_msg_special_letters_for_name;
        return data;
    }

    @DataProvider
    public Object[] getDataForFieldTitleCompany() {
        Object[][] data = new Object[1][2];
        // row 1, the texts are long
        data[0][0] = valid_account_all_fields_available;
        data[0][1] = name_extensive_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToCreateNewAccountSuccessful() {
        Object[][] data = new Object[2][2];
        // row 1, all values of account is valid
        data[0][0] = valid_account_all_fields_available;
        data[0][1] = text_on_page_thank_you;
        // row 2, all values of required fields are valid, however, values for optional fields are empty
        valid_account_empty_optional_fields.setEmail("qatestinglogigear" + TimeUtil.getSystemTimeHMS("yyyyMMddHHmmss") + "@gmail.com" + "fortest");
        data[1][0] = valid_account_empty_optional_fields;
        data[1][1] = text_on_page_thank_you;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckTextOnFinalForm() {
        Object[][] data = new Object[1][2];
        // row 1, all values of account is valid
        data[0][0] = valid_account_all_fields_available;
        data[0][1] = text_on_page_thank_you;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckTrimWhiteSpaceLettersOfText() {
        Object[] data = new Object[1];
        // row 1, all values of account is valid
        String whiteSpaceLetters = "     ";
        UserAccount user = valid_account_all_fields_available;
        valid_account_all_fields_available.setFirstName(whiteSpaceLetters + user.getFirstName() + whiteSpaceLetters);
        valid_account_all_fields_available.setLastName(whiteSpaceLetters + user.getLastName() + whiteSpaceLetters);
        valid_account_all_fields_available.setEmail(whiteSpaceLetters + user.getEmail() + whiteSpaceLetters);
        valid_account_all_fields_available.setTitle(whiteSpaceLetters + user.getTitle() + whiteSpaceLetters);
        valid_account_all_fields_available.setCompany(whiteSpaceLetters + user.getCompany() + whiteSpaceLetters);
        valid_account_all_fields_available.setPhone(whiteSpaceLetters + user.getPhone() + whiteSpaceLetters);
        data[0] = valid_account_all_fields_available;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckUIActivePage() {
        Object[][] data = new Object[2][4];
        // row 1, active code is empty
        data[0][0] = inactivated_SSO_account;
        data[0][1] = empty_text;
        data[0][2] = error_msg_empty_field;
        data[0][3] = empty_text;
        // row 2, active code is invalid code
        data[1][0] = inactivated_SSO_account;
        data[1][1] = active_code_short;
        data[1][2] = empty_text;
        data[1][3] = error_msg_invalid_active_code;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckInvalidCode() {
        Object[][] data = new Object[4][4];
        // row 1, the active code is empty
        data[0][0] = inactivated_SSO_account;
        data[0][1] = empty_text;
        data[0][2] = error_msg_empty_field;
        data[0][3] = empty_text;
        // row 2, the active code is short
        data[1][0] = data[0][0];
        data[1][1] = active_code_short;
        data[1][2] = empty_text;
        data[1][3] = error_msg_invalid_active_code;
        // row 3, the active code is extensive
        data[2][0] = data[0][0];
        data[2][1] = active_code_extensive;
        data[2][2] = empty_text;
        data[2][3] = error_msg_invalid_active_code;
        // row 3, the active code is right format, however it is an invalid code
        data[3][0] = data[0][0];
        data[3][1] = active_code_outdated;
        data[3][2] = empty_text;
        data[3][3] = error_msg_invalid_active_code;
        return data;
    }

    // the maximum number of columns of an 2 ways array is 4
    @DataProvider
    public Object[] getDataToCheckChangePw() {
        Object[][] data = new Object[11][4];
        // row 1, the password text is empty    -> ok
        data[0][0] = inactivated_SSO_account;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, the password text is only numbers     -> ok
        data[1][0] = inactivated_SSO_account;
        data[1][1] = pw_only_number;
        data[1][2] = pw_only_number;
        data[1][3] = error_msg_message_pw;
        // row 3, the password text is only letters     -> ok
        data[2][0] = inactivated_SSO_account;
        data[2][1] = pw_only_string;
        data[2][2] = pw_only_string;
        data[2][3] = error_msg_message_pw;
        // row 4, the password text is less than 8 characters   -> ok
        data[3][0] = inactivated_SSO_account;
        data[3][1] = pw_not_enough_length;
        data[3][2] = pw_not_enough_length;
        data[3][3] = error_msg_short_Pw;
        // row 5, the password text is valid and it consist a large number of special letters   -> ok
        data[4][0] = inactivated_SSO_account;
        data[4][1] = pw_contain_special_char;
        data[4][2] = pw_contain_special_char;
        data[4][3] = error_msg_message_pw;
        // row 6, the password text consists a/a few white space letters between other letters  -> ok
        data[5][0] = inactivated_SSO_account;
        data[5][1] = pw_has_whitespace;
        data[5][2] = pw_has_whitespace;
        data[5][3] = error_msg_message_pw;
        // row 7, the password text is valid and it consist a large number of special letters
        data[6][0] = inactivated_SSO_account;
        data[6][1] = pw_valid_strong;
        data[6][2] = pw_valid_strong;
        data[6][3] = empty_text;
        // row 8, new password, confirm password are same as the current password
        data[7][0] = activated_SSO_account;
        data[7][1] = activated_SSO_account.getPassword();
        data[7][2] = activated_SSO_account.getPassword();
        data[7][3] = error_msg_same_pw;
        // row 9, new password, confirm password are greater than 100 letters
        data[8][0] = inactivated_SSO_account;
        data[8][1] = pw_is_over_128_letters;
        data[8][2] = pw_is_over_128_letters;
        data[8][3] = empty_text;
        // row 10, new password, confirm password differences
        data[9][0] = activated_SSO_account;
        data[9][1] = pw_valid_strong;
        data[9][2] = pw_activated_strong;
        data[9][3] = error_msg_confirm_pw;
        // row 11, the current password is wrong
        data[10][0] = activated_SSO_account;
        data[10][1] = pw_valid_strong;
        data[10][2] = pw_valid_strong;
        data[10][3] = error_msg_current_pw_wrong;
        return data;
    }

    @DataProvider
    public Object[] getDataToUpdatePwSuccessful() {
        Object[][] data = new Object[2][4];
        // row 1, change password with inactive account
        data[0][0] = inactivated_SSO_account;
        data[0][1] = pw_valid_strong;
        data[0][2] = pw_valid_strong;
        data[0][3] = inactivated_SSO_account.getPassword();
        // row 2, change password with active account
        data[1][0] = activated_SSO_account;
        data[1][1] = pw_valid_strong;
        data[1][2] = pw_valid_strong;
        data[1][3] = activated_SSO_account.getPassword();
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckResetPassword() {
        Object[][] data = new Object[10][3];
        // row 1,
        data[0][0] = pw_only_string;
        data[0][1] = pw_only_string;
        data[0][2] = error_msg_message_pw;
        // row 2,
        data[1][0] = empty_text;
        data[1][1] = empty_text;
        data[1][2] = error_msg_empty_field;
        // row 3,
        data[2][0] = pw_only_number;
        data[2][1] = pw_only_number;
        data[2][2] = error_msg_message_pw;
        // row 4,
        data[3][0] = pw_contain_special_char;
        data[3][1] = pw_contain_special_char;
        data[3][2] = error_msg_message_pw;
        // row 5,
        data[4][0] = pw_not_enough_length;
        data[4][1] = pw_not_enough_length;
        data[4][2] = error_msg_message_pw;
        // row 6,
        data[5][0] = pw_has_whitespace;
        data[5][1] = pw_has_whitespace;
        data[5][2] = error_msg_message_pw;
        // row 7,
        data[6][0] = pw_is_over_100_letters;
        data[6][1] = pw_is_over_100_letters;
        data[6][2] = error_msg_confirm_pw;
        // row 8,
        data[7][0] = pw_activated_1;
        data[7][1] = pw_valid_strong;
        data[7][2] = error_msg_confirm_pw;
        // row 9,
        data[8][0] = pw_valid_strong;
        data[8][1] = pw_valid_strong;
        data[8][2] = empty_text;
        return data;
    }


}

/*
    public UserAccount activated_SSO_account = new UserAccount("internal testing only",
            "please ignored", "qatesting82@yopmail.com", "pass-02468",
            "pass-02468", "Logigear Test", "Logigear", "Uganda", "Abim", "0909999990");

    public UserAccount inactivated_SSO_account = new UserAccount("internal testing only", "please ignored",
            "qatesting95@yopmail.com", "pass-02468", "pass-02468", "Logigear Test",
            "Logigear Test", "Uganda", "Abim", "0909999990");
 */