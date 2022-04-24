package SSO_project.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPO {

    @FindBy(xpath = "//div[text()='Thank you for your registration!']")
    public WebElement divThankYou;

    public ThankYouPO(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
