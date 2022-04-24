package projects.Pre_Test_Sele_2.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePO {
    /* ****  Locator & Element **** */
    @FindBy(css = "img[alt='Google']")
    public WebElement imgGoogleTitle;
    @FindBy(css = "input[name='q']")
    public WebElement inputSearch;
    @FindBy(css = "input[name='btnK']")
    public WebElement inputSearchBtn;
    @FindBy(xpath = "//div[@id='SIvCob']//a[text() = 'English']")
    public WebElement aEnglish;

    public By aEnglishBy = By.xpath("//div[@id='SIvCob']//a[text() = 'English']");

    /* ****  Constructor  **** */
    public GoogleHomePO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
