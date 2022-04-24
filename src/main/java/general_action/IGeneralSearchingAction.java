package general_action;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IGeneralSearchingAction {
    void verifyListResultsContainText(String textQuery, List<WebElement> listElement, boolean isCheckAllElements);
}
