package projects.Pre_Test_Sele_2.action.implement_action;

import common.Constant;
import common.URL;
import projects.Pre_Test_Sele_2.action.INavigateAction;

public class NavigateAction implements INavigateAction {

    @Override
    public void goToGoogleSearchPage() {
        Constant.webDriver.get(URL.googleURL);
    }

}
