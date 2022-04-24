package projects.Pre_Test_Sele_2.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchingResultPO {

    /* ****  Locator & Element **** */
    @FindBy(css = "input[name='q']")
    public WebElement inputSearch;
    @FindBy(xpath = "//div[@id='hdtb-msb']//a[text() ='Videos']")
    public WebElement aVideo;

//    @FindBy(xpath = "//h2[text() = 'Web results']//ancestor::div[@class='hlcw0c']//*[normalize-space(text()) != '']")
//    public List<WebElement> mainResultNumber1;
    @FindBy(xpath = "//div[@id='rso']//div[@class='hlcw0c'][1]")
    public WebElement mainResultNumber1;

    // All searching result in the section 'People also ask', using method 'get text' of WebElement
    @FindBy(xpath = "//div[@jsname='jIA8B']//span")
    public List<WebElement> spanResultsPeopleAlsoAsk;

    // All searching result in the section 'Videos', attribute containing query text is 'aria-label'
    @FindBy(xpath = "//div[@jsname='TFTr6']//a[@role='heading']")
    public List<WebElement> aResultsVideo;

    // All searching results in the section 'Top stories', using method 'get text' of WebElement
    @FindBy(xpath = "//g-section-with-header//div[@aria-level='4']")
    public List<WebElement> divResultsStory;

    @FindBy(xpath = "//div[@id='rso']//div[@class='hlcw0c'][2]")
    public WebElement mainResultNumber2;

    // Searching result in the section 'twitter'
    @FindBy(xpath = "//div[@id='rso']//div[@class='ULSxyf'][4]")
    public WebElement twitterResult;

    @FindBy(xpath = "//div[@id='rso']//div[@class='g tF2Cxc'][2]")
    public WebElement mainResultNumber3;
    @FindBy(xpath = "//div[@id='rso']//div[@class='g tF2Cxc'][2]")
    public List<WebElement> mainResultNumber4;
    @FindBy(xpath = "//div[@id='eob_1']//ancestor::div[@class='hlcw0c']//following-sibling::div[@class='hlcw0c']//*[normalize-space(text()) != '']")
    public List<WebElement> mainResultNumber5;

    // for searching results are 'Video'
    @FindBy(xpath = "//h3[text()='Videos']//ancestor::div[@class='ULSxyf']//a//div[@class='uOId3b']//div")
    public List<WebElement> divTitleVideo;

    public SearchingResultPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}