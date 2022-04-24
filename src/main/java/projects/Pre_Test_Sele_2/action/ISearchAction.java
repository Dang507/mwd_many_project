package projects.Pre_Test_Sele_2.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projects.Pre_Test_Sele_2.page_object.GoogleHomePO;

public interface ISearchAction {
    void searchTextOnHomePage(WebDriver webDriver, GoogleHomePO googleHomePO, String inputText);
}
