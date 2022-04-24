package projects.Pre_Test_Sele_2.action.implement_action;

import org.openqa.selenium.WebDriver;
import projects.Pre_Test_Sele_2.action.ISearchAction;
import projects.Pre_Test_Sele_2.page_object.GoogleHomePO;

public class SearchAction implements ISearchAction {

    @Override
    public void searchTextOnHomePage(WebDriver webDriver, GoogleHomePO googleHomePO, String inputText) {
        if(googleHomePO.aEnglish.isDisplayed()){
            googleHomePO.aEnglish.click();
        }
        googleHomePO.inputSearch.sendKeys(inputText);
        googleHomePO.inputSearchBtn.click();

    }
}
