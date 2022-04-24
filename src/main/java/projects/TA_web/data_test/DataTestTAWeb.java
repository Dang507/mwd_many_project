package projects.TA_web.data_test;

import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import common.TimeUtil;
import org.testng.annotations.DataProvider;
import projects.TA_web.entity.Coupon;
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

    // TA portal, Page 'Add/Edit coupon type'
    public String labelName = "Name*";
    public String labelLimit = "Limit*";
    public String labelStatus = "Status*";
    public String btnSave = "Save";
    public String placeholderTextForName = "Coupon Name";

    // TA portal, Page 'Manage Coupon Type'
    public String h5TitlePage = "Manage Coupon Type";
    public String btnAdd = "Add";
    public String spanName = "Name";
    public String spanLimit = "Limit";
    public String spanStatus = "Status";

    // TA portal, the dialog 'Delete coupon type'
    public String h2TitleDeleteDialogCouponType = "Do you want to delete ";
    public String btnDelete = "Delete";

    // TA portal, page 'Manage coupon'
    public String h5Title = "";
    public String labelType = "Type*";
    public String labelValue = "Value*";
    public String labelUnitFirst = "Unit Name*";
    public String labelPoint = "Point*";
    public String labelDuration = "Duration*";
    public String labelPresentee = "Presentee";

    //TA portal page Edit Coupon
    public String value_existed="Test Case";
    public String error_msg_existed="Value is existed";

    //TA portal page Add Coupon
    public Coupon new_coupon = new Coupon("10","Test Case 2","1010","210",
            "Active","Test Cases","Days","Test Case");

    public String value_test_case_existed= "Test Case";

    public String error_msg_existed_page_AddCoupon= "Test Case is existed";

    public String success_msg_add_coupon= "The Coupon Type has been added successfully.";

    public UserAccount activated_SSO_account_portal_staging = new UserAccount("internal testing only", "please ignored",
            "qatesting119@yopmail.com", "pass-02468", "pass-02468", "Logigear Test",
            "Logigear Test", "Uganda", "Abim", "0909999990");

    public UserAccount account_test_edit_profile = new UserAccount("aa","bb","tester_logi_2@yopmail.com",
            "tester_logi_2","tester_logi_2","aa","abc","Uganda",
            "Abim", "0909999990");

    public UserAccount inactivated_SSO_account_portal_staging = new UserAccount("internal testing only", "please ignored",
            "qatesting118@yopmail.com", "pass-02468", "pass-02468", "Logigear Test",
            "Logigear Test", "Uganda", "Abim", "0909999990");

    public UserAccount admin_SSO_account_portal_staging = new UserAccount("thien1111", "thien1",
            "thien.kieu@logigear.com", "abc123!@#", "abc123!@#", "sdfsf",
            "abc111", "Aruba", "Aruba", "11111111111111");

    // referral link from account qatesting118@yopmail.com/ pass-02468
    public String referralLink = "https://sso-stage1.logigear.com/register?referralCode=1649040169";

    public CouponType valid_coupon_type_active = new CouponType("coupon type for testing " + TimeUtil.getSystemTimeHMS("yyyyMMddHHmmss")
            , "100", "Active");
    public CouponType valid_coupon_type_inactive =
            new CouponType("coupon type for testing " + Math.random()*10000
            , "120", "In-Active");
    public CouponType coupon_type_empty_field = new CouponType("", "", "In-Active");
    public CouponType coupon_type_has_image_jpeg =
            new CouponType("coupon type for testing " + (int) (Math.random() * 100), "100", "Active"
                    , valid_image_file_path_jpeg);
    public CouponType coupon_type_has_image_png =
            new CouponType("coupon type for testing " + (int) (Math.random()*100), "100", "In-Active"
                    , valid_image_file_path_png);
    public CouponType coupon_type_has_image_jfif =
            new CouponType("coupon type for testing " + (int) (Math.random()*100), "100", "Active"
                    , valid_image_file_path_jfif);
    public CouponType coupon_type_has_huge_image =
            new CouponType("coupon type for testing " + (int) (Math.random()*100), "100", "Active"
                    , image_larger_than_10mbs_file_path_jpg);
    public CouponType coupon_type_already_in_use =
            new CouponType("Test case", "1", "Active", valid_image_file_path_jpeg);
    public CouponType coupon_type_existed_for_testing =
            new CouponType("coupon type for testing", "100", "Active", valid_image_file_path_png);

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
        data[0][0] = inactivated_SSO_account_portal_staging;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, the password text is only numbers     -> ok
        data[1][0] = inactivated_SSO_account_portal_staging;
        data[1][1] = pw_only_number;
        data[1][2] = pw_only_number;
        data[1][3] = error_msg_message_pw;
        // row 3, the password text is only letters     -> ok
        data[2][0] = inactivated_SSO_account_portal_staging;
        data[2][1] = pw_only_string;
        data[2][2] = pw_only_string;
        data[2][3] = error_msg_message_pw;
        // row 4, the password text is less than 8 characters   -> ok
        data[3][0] = inactivated_SSO_account_portal_staging;
        data[3][1] = pw_not_enough_length;
        data[3][2] = pw_not_enough_length;
        data[3][3] = error_msg_short_Pw;
        // row 5, the password text is valid and it consist a large number of special letters   -> ok
        data[4][0] = inactivated_SSO_account_portal_staging;
        data[4][1] = pw_contain_special_char;
        data[4][2] = pw_contain_special_char;
        data[4][3] = error_msg_message_pw;
        // row 6, the password text consists a/a few white space letters between other letters  -> ok
        data[5][0] = inactivated_SSO_account_portal_staging;
        data[5][1] = pw_has_whitespace;
        data[5][2] = pw_has_whitespace;
        data[5][3] = error_msg_message_pw;
        // row 7, the password text is valid and it consist a large number of special letters
        data[6][0] = inactivated_SSO_account_portal_staging;
        data[6][1] = pw_valid_strong;
        data[6][2] = pw_valid_strong;
        data[6][3] = empty_text;
        // row 8, new password, confirm password are same as the current password
        data[7][0] = inactivated_SSO_account_portal_staging;
        data[7][1] = activated_SSO_account.getPassword();
        data[7][2] = activated_SSO_account.getPassword();
        data[7][3] = error_msg_same_pw;
        // row 9, new password, confirm password are greater than 100 letters
        data[8][0] = inactivated_SSO_account_portal_staging;
        data[8][1] = pw_is_over_100_letters;
        data[8][2] = pw_is_over_100_letters;
        data[8][3] = empty_text;
        // row 10, new password, confirm password differences
        data[9][0] = inactivated_SSO_account_portal_staging;
        data[9][1] = pw_valid_strong;
        data[9][2] = pw_activated_strong;
        data[9][3] = error_msg_confirm_pw;
        // row 11, the current password is wrong
        data[10][0] = inactivated_SSO_account_portal_staging;
        data[10][1] = pw_valid_strong;
        data[10][2] = pw_valid_strong;
        data[10][3] = error_msg_current_pw_wrong;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckChangePwPageForAllEmptyField() {
        Object[] data = new Object[2];
        data[0] = inactivated_SSO_account_portal_staging;
        data[1] = activated_SSO_account_portal_staging;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckFieldPassword() {
        Object[][] data = new Object[6][3];
        // row 1, pw is only numbers
        data[0][0] = inactivated_SSO_account_portal_staging;
        data[0][1] = pw_only_number;
        data[0][2] = error_msg_message_pw;
        // row 2, pw is only letters
        data[1][0] = inactivated_SSO_account_portal_staging;
        data[1][1] = pw_only_string;
        data[1][2] = error_msg_message_pw;
        // row 3, pw is less than 8 characters
        data[2][0] = activated_SSO_account_portal_staging;
        data[2][1] = pw_not_enough_length;
        data[2][2] = error_msg_short_Pw;
        // row 4, the password text is valid and it consist a large number of special letters   -> ok
        data[3][0] = inactivated_SSO_account_portal_staging;
        data[3][1] = pw_contain_special_char;
        data[3][2] = error_msg_message_pw;
        // row 5, the password text consists a/a few white space letters between other letters  -> ok
        data[4][0] = activated_SSO_account_portal_staging;
        data[4][1] = pw_has_whitespace;
        data[4][2] = error_msg_message_pw;
        // row 6, new password, confirm password are greater than 100 letters
        data[5][0] = inactivated_SSO_account_portal_staging;
        data[5][1] = pw_is_over_100_letters;
        data[5][2] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckErrorMsgWhenSubmittingValidValue() {
        Object[][] data = new Object[2][3];
        // row 1, pw is only numbers
        data[0][0] = inactivated_SSO_account_portal_staging;
        data[0][1] = inactivated_SSO_account_portal_staging.getPassword();
        data[0][2] = error_msg_same_pw;
        // row 2, pw is only letters
        data[1][0] = activated_SSO_account_portal_staging;
        data[1][1] = activated_SSO_account_portal_staging.getPassword();
        data[1][2] = error_msg_current_pw_wrong;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckErrorMsgNoDisplayWhenEnteringValidValues() {
        Object[][] data = new Object[2][2];
        // row 7, the password text is valid and it consist a large number of special letters
        data[0][0] = inactivated_SSO_account_portal_staging;
        data[0][1] = pw_valid_strong;
        // row 11, the current password is wrong
        data[1][0] = activated_SSO_account_portal_staging;
        data[1][1] = pw_activated_strong;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckFieldConfirmPassword() {
        Object[][] data = new Object[2][4];
        // row 1
        data[0][0] = activated_SSO_account_portal_staging;
        data[0][1] = pw_valid_strong;
        data[0][2] = pw_activated_strong;
        data[0][3] = error_msg_confirm_pw;
        // row 2
        data[1][0] = inactivated_SSO_account_portal_staging;
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
        data[0][0] = admin_SSO_account_portal_staging;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, enter the text consist special letters
        data[1][0] = admin_SSO_account_portal_staging;
        data[1][1] = name_contain_special_char;
        data[1][2] = empty_text;
        data[1][3] = error_msg_special_letters_for_name;
        // row 3, enter an extensive text
        data[2][0] = admin_SSO_account_portal_staging;
        data[2][1] = name_extensive_text_300_letters;
        data[2][2] = name_extensive_text_300_letters.substring(0, 200);
        data[2][3] = empty_text;
        // row 4, enter the text consist a few white space letters at the beginning and end
        data[3][0] = admin_SSO_account_portal_staging;
        data[3][1] = text_white_space_at_begining_ending;
        data[3][2] = text_white_space_at_begining_ending.trim();
        data[3][3] = empty_text;
        // row 5, enter the unicode text
        data[4][0] = admin_SSO_account_portal_staging;
        data[4][1] = name_by_unicode_text;
        data[4][2] = name_by_unicode_text;
        data[4][3] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToCheckFieldLimitOfCouponType() {
        Object[][] data = new Object[6][4];
        RegexPattern regexPattern = new RegexPattern();
        // row 1, enter nothing to the field
        data[0][0] = admin_SSO_account_portal_staging;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, enter the text consist special letters
        data[1][0] = admin_SSO_account_portal_staging;
        data[1][1] = name_contain_special_char;
        data[1][2] = empty_text;
        data[1][3] = error_msg_empty_field;
        // row 3, enter an extensive text
        data[2][0] = admin_SSO_account_portal_staging;
        data[2][1] = name_by_unicode_text;
        data[2][2] = regexPattern.textOnlyNumberPattern;
        data[2][3] = empty_text;
        // row 4, enter the text consist a few white space letters at the beginning and end
        data[3][0] = admin_SSO_account_portal_staging;
        data[3][1] = number_white_space_at_beging_end;
        data[3][2] = number_white_space_at_beging_end.trim();
        data[3][3] = empty_text;
        // row 6, enter a text, and it is a mix of numbers and a few special letters
        data[4][0] = admin_SSO_account_portal_staging;
        data[4][1] = phone_contain_special_char;
        data[4][2] = empty_text;
        data[4][3] = error_msg_only_number;
        // row 7, enter a text that it is mix only letters and a few letters '0'
        data[5][0] = admin_SSO_account_portal_staging;
        data[5][1] = name_extensive_text_300_letters + "0000";
        data[5][2] = "0";
        data[5][3] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToCreateNewCouponTypeSuccessfully() {
        Object[][] data = new Object[3][3];
        // row 1, coupon type has an image that it is the file type .jpeg
        data[0][0] = admin_SSO_account_portal_staging;
        data[0][1] = coupon_type_has_image_jpeg;
        data[0][2] = success_msg_add_coupon_type;
        // row 2, coupon type has an image that it is the file type .png
        data[1][0] = admin_SSO_account_portal_staging;
        data[1][1] = coupon_type_has_image_png;
        data[1][2] = success_msg_add_coupon_type;
        // row 2, coupon type has an image that it is the file type .jfif
        data[2][0] = admin_SSO_account_portal_staging;
        data[2][1] = coupon_type_has_image_jfif;
        data[2][2] = success_msg_add_coupon_type;
        return data;
    }

    // page 'Add coupon type'
    @DataProvider
    public Object[] getDataToCheckFieldNameOfCoupon() {
        Object[][] data = new Object[5][3];
        // row 1, enter nothing to the field
        data[0][0] = empty_text;
        data[0][1] = empty_text;
        data[0][2] = error_msg_empty_field;
        // row 2, enter the text consist special letters

        data[1][0] = name_contain_special_char;
        data[1][1] = empty_text;
        data[1][2] = error_msg_special_letters_for_name;
        // row 3, enter an extensive text

        data[2][0] = name_extensive_text_300_letters;
        data[2][1] = name_extensive_text_300_letters.substring(0, 200);
        data[2][2] = empty_text;
        // row 4, enter the text consist a few white space letters at the beginning and end

        data[3][0] = text_white_space_at_begining_ending;
        data[3][1] = text_white_space_at_begining_ending.trim();

        // row 5, enter the unicode text

        data[4][0] = name_by_unicode_text;
        data[4][1] = name_by_unicode_text;
        data[4][2] = empty_text;
        return data;
    }

    @DataProvider
    public Object[] getDataToCreateNewCouponSuccessfully() {
        Object[][] data = new Object[2][2];

        data[0][1]=new_coupon;
        data[0][2]=success_msg_add_coupon;

        return  data;
    }

    @DataProvider
    public Object[][] CheckValueExistedOfCoupon(){
        Object[][] data = new Object[2][3];
        data [0][1]=value_test_case_existed;
        data [0][2]=error_msg_existed_page_AddCoupon;
        return data;
    }


}
