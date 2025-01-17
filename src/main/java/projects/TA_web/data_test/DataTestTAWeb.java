package projects.TA_web.data_test;

import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import common.TimeUtil;
import org.testng.annotations.DataProvider;
import projects.TA_web.entity.CouponType;

public class DataTestTAWeb extends DataTestSSO {
    // Page 'Leave a message', form 'Leave a message'
    public String labelQuestion = "Question/ Comment";
    public String inputAttachFile = "Attached Files";
    public String btnSendMsg = "Send Message";

    // Page 'Leave a message', table 'Message history'
    public String divTableTitle = "Message History";
    public String thDate = "DATE SORTED ASCENDING";
    public String thMessage = "MESSAGE";
    public String thStatus = "STATUS";

    // Page 'Change password'
    public String h1TitleChangePassword = "Change Password";
    public String labelPassword = "Password*";
    public String labelNewPassword = "New password*";
    public String labelConfirmPw = "Confirm new password*";
    public String placeholderTextForPw = "Please enter your password";
    public String placeholderTextForNewPw = "Please enter your new password";
    public String placeholderTextForConfirmPw = "Please confirm your new password";
    public String btnSubmit = "Submit";
    public String btnCancel = "Cancel";

    // Page 'Add/Edit coupon type'
    public String labelName = "Name*";
    public String labelLimit = "Limit*";
    public String labelStatus = "Status*";
    public String btnSave = "Save";

    // Page 'Manage Coupon Type'
    public String h5TitlePage = "Manage Coupon Type";
    public String btnAdd = "Add";
    public String spanName = "Name";
    public String spanLimit = "Limit";
    public String spanStatus = "Status";

    // the dialog 'Delete coupon type'
    public String h2TitleDeleteDialogCouponType = "Do you want to delete ";
    public String btnDelete = "Delete";

    public UserAccount inactivated_SSO_account_for_server_23 = new UserAccount("internal testing only", "please ignored",
            "qatesting116@yopmail.com", "pass-02468", "pass-02468", "Logigear Test",
            "Logigear Test", "Uganda", "Abim", "0909999990");

    public CouponType valid_coupon_type_active = new CouponType("internal testing only please ignored 100"
            , "100", "Active");

    public CouponType valid_coupon_type_inactive = new CouponType("internal testing only please ignored 101"
            , "120", "InActive");

    public CouponType new_coupon_type_active =
            new CouponType("internal testing only please ignored" + TimeUtil.getSystemTimeHMS("yyyyMMddHHmmss")
            , "100", "Active");

    @DataProvider
    public Object[] getDataForFieldPhone() {
        Object[][] data = new Object[9][2];
        // row 1, the phone text is a empty text
        data[0][0] = empty_text;
        data[0][1] = "";
        // row 2, the phone text has some letters
        data[1][0] = phone_contain_text_char;
        data[1][1] = error_msg_phone_invalid_number;
        // row 3, the phone text has some special letters
        data[2][0] = phone_contain_special_char;
        data[2][1] = error_msg_phone_invalid_number;
        // row 4, the phone text is less than 10 numbers
        data[3][0] = phone_less_than_10_number;
        data[3][1] = error_msg_phone_short_or_too_long;
        // row 5, the phone text is greater than 15 numbers
        data[4][0] = phone_greater_than_15_numbers;
        data[4][1] = error_msg_phone_short_or_too_long;
        // row 6, the phone text is mistake format
        data[5][0] = phone_invalid_format;
        data[5][1] = error_msg_phone_invalid_number;
        // row 7, the phone text is valid numbers
        data[6][0] = valid_phone_1;
        data[6][1] = "";
        // row 8, the phone text is valid numbers
        data[7][0] = valid_phone_2;
        data[7][1] = "";
        // row 9, the phone text is valid numbers
        data[8][0] = phone_has_space_at_beginning_ending;
        data[8][1] = "";
        return data;
    }

    // the maximum number of columns of an 2 ways array is 4
    @DataProvider
    public Object[] getDataToCheckChangePwPage() {
        Object[][] data = new Object[11][4];
        // row 1, the password text is empty    -> ok
        data[0][0] = inactivated_SSO_account_for_server_23;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, the password text is only numbers     -> ok
        data[1][0] = inactivated_SSO_account_for_server_23;
        data[1][1] = pw_only_number;
        data[1][2] = pw_only_number;
        data[1][3] = error_msg_message_pw;
        // row 3, the password text is only letters     -> ok
        data[2][0] = inactivated_SSO_account_for_server_23;
        data[2][1] = pw_only_string;
        data[2][2] = pw_only_string;
        data[2][3] = error_msg_message_pw;
        // row 4, the password text is less than 8 characters   -> ok
        data[3][0] = inactivated_SSO_account_for_server_23;
        data[3][1] = pw_not_enough_length;
        data[3][2] = pw_not_enough_length;
        data[3][3] = error_msg_short_Pw;
        // row 5, the password text is valid and it consist a large number of special letters   -> ok
        data[4][0] = inactivated_SSO_account_for_server_23;
        data[4][1] = pw_contain_special_char;
        data[4][2] = pw_contain_special_char;
        data[4][3] = error_msg_message_pw;
        // row 6, the password text consists a/a few white space letters between other letters  -> ok
        data[5][0] = inactivated_SSO_account_for_server_23;
        data[5][1] = pw_has_whitespace;
        data[5][2] = pw_has_whitespace;
        data[5][3] = error_msg_message_pw;
        // row 7, the password text is valid and it consist a large number of special letters
        data[6][0] = inactivated_SSO_account_for_server_23;
        data[6][1] = pw_valid_strong;
        data[6][2] = pw_valid_strong;
        data[6][3] = empty_text;
        // row 8, new password, confirm password are same as the current password
        data[7][0] = inactivated_SSO_account_for_server_23;
        data[7][1] = activated_SSO_account.getPassword();
        data[7][2] = activated_SSO_account.getPassword();
        data[7][3] = error_msg_same_pw;
        // row 9, new password, confirm password are greater than 100 letters
        data[8][0] = inactivated_SSO_account_for_server_23;
        data[8][1] = pw_is_over_100_letters;
        data[8][2] = pw_is_over_100_letters;
        data[8][3] = empty_text;
        // row 10, new password, confirm password differences
        data[9][0] = inactivated_SSO_account_for_server_23;
        data[9][1] = pw_valid_strong;
        data[9][2] = pw_activated_strong;
        data[9][3] = error_msg_confirm_pw;
        // row 11, the current password is wrong
        data[10][0] = inactivated_SSO_account_for_server_23;
        data[10][1] = pw_valid_strong;
        data[10][2] = pw_valid_strong;
        data[10][3] = error_msg_current_pw_wrong;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckChangePwPageForAllEmptyField() {
        Object[] data = new Object[2];
        data[0] = inactivated_SSO_account;
        data[1] = activated_SSO_account;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckFieldPassword() {
        Object[][] data = new Object[6][3];
        // row 1, pw is only numbers
        data[0][0] = inactivated_SSO_account_for_server_23;
        data[0][1] = pw_only_number;
        data[0][3] = error_msg_message_pw;
        // row 2, pw is only letters
        data[1][0] = inactivated_SSO_account_for_server_23;
        data[1][1] = pw_only_string;
        data[1][3] = error_msg_message_pw;
        // row 3, pw is less than 8 characters
        data[2][0] = inactivated_SSO_account_for_server_23;
        data[2][1] = pw_not_enough_length;
        data[2][3] = error_msg_short_Pw;
        // row 4, the password text is valid and it consist a large number of special letters   -> ok
        data[3][0] = inactivated_SSO_account_for_server_23;
        data[3][1] = pw_contain_special_char;
        data[3][3] = error_msg_message_pw;
        // row 5, the password text consists a/a few white space letters between other letters  -> ok
        data[4][0] = inactivated_SSO_account_for_server_23;
        data[4][1] = pw_has_whitespace;
        data[4][3] = error_msg_message_pw;
        // row 6, new password, confirm password are greater than 100 letters
        data[5][0] = inactivated_SSO_account_for_server_23;
        data[5][1] = pw_is_over_100_letters;
        data[5][3] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckErrorMsgWhenSubmittingValidValue() {
        Object[][] data = new Object[2][3];
        // row 1, pw is only numbers
        data[0][0] = inactivated_SSO_account;
        data[0][1] = inactivated_SSO_account.getPassword();
        data[0][3] = error_msg_same_pw;
        // row 2, pw is only letters
        data[1][0] = activated_SSO_account;
        data[1][1] = activated_SSO_account.getPassword();
        data[1][3] = error_msg_current_pw_wrong;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckErrorMsgNoDisplayWhenEnteringValidValues() {
        Object[][] data = new Object[2][2];
        // row 7, the password text is valid and it consist a large number of special letters
        data[0][0] = inactivated_SSO_account;
        data[0][1] = pw_valid_strong;
        // row 11, the current password is wrong
        data[1][0] = activated_SSO_account;
        data[1][1] = pw_activated_strong;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckFieldConfirmPassword() {
        Object[][] data = new Object[2][4];
        // row 1
        data[0][0] = activated_SSO_account;
        data[0][1] = pw_valid_strong;
        data[0][2] = pw_activated_strong;
        data[0][3] = error_msg_confirm_pw;
        // row 2
        data[1][0] = inactivated_SSO_account;
        data[1][1] = pw_only_number;
        data[1][2] = pw_not_enough_length;
        data[1][3] = error_msg_confirm_pw;
        return data;
    }


    // page 'Add coupon type'
    @DataProvider
    public Object[] getDataToCheckFieldNameOfCouponType() {
        Object[][] data = new Object[5][4];
        // row 1, enter nothing to the field
        data[0][0] = activated_SSO_account;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, enter the text consist special letters
        data[1][0] = activated_SSO_account;
        data[1][1] = name_contain_special_char;
        data[1][2] = empty_text;
        data[1][3] = error_msg_special_letters_for_name;
        // row 3, enter an extensive text
        data[2][0] = activated_SSO_account;
        data[2][1] = text_284_characters;
        data[2][2] = text_284_characters.substring(0, 200);
        data[2][3] = empty_text;
        // row 4, enter the text consist a few white space letters at the beginning and end
        data[3][0] = activated_SSO_account;
        data[3][1] = text_white_space_at_begining_ending;
        data[3][2] = text_white_space_at_begining_ending.trim();
        data[3][4] = empty_text;
        // row 5, enter the unicode text
        data[4][0] = activated_SSO_account;
        data[4][1] = name_by_unicode_text;
        data[4][2] = name_by_unicode_text;
        data[4][3] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckFieldLimitOfCouponType() {
        Object[][] data = new Object[5][4];
        RegexPattern regexPattern = new RegexPattern();
        // row 1, enter nothing to the field
        data[0][0] = activated_SSO_account;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, enter the text consist special letters
        data[1][0] = activated_SSO_account;
        data[1][1] = name_contain_special_char;
        data[1][2] = empty_text;
        data[1][3] = empty_text;
        // row 3, enter an extensive text
        data[2][0] = activated_SSO_account;
        data[2][1] = name_by_unicode_text;
        data[2][2] = regexPattern.textOnlyNumberPattern;
        data[2][3] = empty_text;
        // row 4, enter the text consist a few white space letters at the beginning and end
        data[3][0] = activated_SSO_account;
        data[3][1] = number_white_space_at_beging_end;
        data[3][2] = number_white_space_at_beging_end.trim();
        data[3][4] = empty_text;
        // row 5, enter the unicode text
        data[4][0] = activated_SSO_account;
        data[4][1] = active_code_extensive;
        data[4][2] = regexPattern.textOnlyNumberPattern;
        data[4][3] = empty_text;
        return data;
    }

}
