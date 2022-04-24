package SSO_project.entity;

public class UserAccount {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPw;
    private String title;
    private String company;
    private String country;
    private String state;
    private String phone;

    public UserAccount() {
    }

    public UserAccount(String firstName, String lastName, String email, String password, String confirmPw, String title,
                       String company, String country, String state, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPw = confirmPw;
        this.title = title;
        this.company = company;
        this.country = country;
        this.state = state;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPw() {
        return confirmPw;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPw(String confirmPw) {
        this.confirmPw = confirmPw;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
