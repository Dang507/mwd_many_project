package projects.Pre_Test_Sele_2.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubeVideoPO {

    @FindBy(xpath = "//div[@id='info-contents']//div[@id='container']//h1")
    public WebElement h1TitleVideo;

    /* ****  Constructor  **** */
    public YoutubeVideoPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
