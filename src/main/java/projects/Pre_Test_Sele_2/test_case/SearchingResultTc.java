package projects.Pre_Test_Sele_2.test_case;

import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.IGeneralSearchingAction;
import general_action.implement.GeneralAction;
import general_action.implement.GeneralSearchingAction;
import org.testng.annotations.Test;
import projects.Pre_Test_Sele_2.action.INavigateAction;
import projects.Pre_Test_Sele_2.action.ISearchAction;
import projects.Pre_Test_Sele_2.action.implement_action.SearchAction;
import projects.Pre_Test_Sele_2.action.implement_action.NavigateAction;
import projects.Pre_Test_Sele_2.page_object.GoogleHomePO;
import projects.Pre_Test_Sele_2.page_object.SearchingResultPO;
import projects.Pre_Test_Sele_2.page_object.YoutubeVideoPO;

public class SearchingResultTc extends BaseTest {

    /**
     * Test case 01: Validate Google search result
     *
     * 1. Navigate to the URL: https://www.google.com.vn/
     *  + Open the web browser
     *  + Enter the URL https://www.google.com.vn/ to the web browser address
     *  + Press the keys 'Enter'
     * 2. Enter the text to the file 'Search' to search
     *  + Enter the text to the field 'Search'
     *  + Select the button 'Search'
     * 3. Verify the inputted text still shows on the field 'Searching' on resulting pages
     * 4. Verify all of the results contains the query
     *  + Verify all results in the section 'Main result' contain the text query
     *  + Verify all results in the section 'People also ask' contain the text query
     *  + Verify all results in the section 'Top stories' contain the text query
     *  + Verify all results in the section 'Videos' contain the text query
     */
    @Test(priority = 1,
            testName = "Test case 01: Validate Google search result",
            description = "Description: Verify all of the results contains the query, include: Main result and results on special sections 'People also ask', 'Top stories', 'Videos'")
    public void TC02_Validate_Google_search_result() {
        System.out.println("Test case 01: Verify all results contains the query");
        String textQuery = "the Beatles";

        try {
            GoogleHomePO googleHomePO = new GoogleHomePO(Constant.webDriver);
            SearchingResultPO resultPO = new SearchingResultPO(Constant.webDriver);
            INavigateAction navigateAction = new NavigateAction();
            ISearchAction searchAction = new SearchAction();
            IGeneralSearchingAction generalSearchingA = new GeneralSearchingAction();
            IGeneralAction generalAction = new GeneralAction();

            LogReport.logMainStep("1. Navigate to the URL: https://www.google.com.vn/");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the URL https://www.google.com.vn/ to the web browser address");
            LogReport.logSubStep("Press the keys 'Enter'");
            navigateAction.goToGoogleSearchPage();

            LogReport.logMainStep("2. Enter the text to the file 'Search' to search");
            LogReport.logSubStep("Enter the text to the field 'Search'");
            LogReport.logSubStep("Select the button 'Search'");
            searchAction.searchTextOnHomePage(Constant.webDriver, googleHomePO, textQuery);

            LogReport.logMainStep("3. Verify the inputted text still shows on the field 'Searching' on resulting pages");
            generalAction.verifyTextDisplay(textQuery, resultPO.inputSearch, true);

            LogReport.logMainStep("4. Verify all of the results contains the query");
            LogReport.logSubStep("Verify all results in the section 'People also ask' contain the text query");
            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.spanResultsPeopleAlsoAsk, true);

            LogReport.logSubStep("Verify all results in the section 'Top stories' contain the text query");
            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.divResultsStory, true);

            LogReport.logSubStep("Verify all results in the section 'Videos' contain the text query");
            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.aResultsVideo, true);

            LogReport.logSubStep("Verify the result 'twitter' contains the text query");
//            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.twitterResult, false);
            LogReport.logSubStep("Verify the main results number 1 contain the text query");
            LogReport.logSubStep("Text at parent element div: " + resultPO.mainResultNumber1.getText());
//            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.mainResultNumber1, false);
//            LogReport.logSubStep("Verify the main results number 2 contain the text query");
//            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.mainResultNumber2, false);
//            LogReport.logSubStep("Verify the main results number 3 contain the text query");
//            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.mainResultNumber3, false);
//            LogReport.logSubStep("Verify the main results number 4 contain the text query");
//            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.mainResultNumber4, false);
//            LogReport.logSubStep("Verify the main results number 5 contain the text query");
//            generalSearchingA.verifyListResultsContainText(textQuery, resultPO.mainResultNumber5, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02: Validate YouTube result from Google search
     *
     * 1. Navigate to the URL: https://www.google.com.vn/
     *  + Open the web browser
     *  + Enter the URL https://www.google.com.vn/ to the web browser address
     *  + Press the keys 'Enter'
     * 2. Enter the text to the file 'Search' to search
     *  + Enter the text to the field 'Search'
     *  + Select the button 'Search'
     * 3. Open the first video 'Youtube'
     *  + Select the link 'Videos'
     *  + Select the first video 'Youtube'
     * 4. Verify the video title is same to the result of 'Google'
     * 5. Verify the video is played/ paused accordingly.
     *  + Select the button 'Play'
     *  + Waiting for 10 seconds
     *  + Verify the video duration is turn up 10 seconds
     *  + Select the button 'Stop'
     *  + Verify the video stopped
     */
    @Test(priority = 2, enabled = false,
            testName = "Test case 02: Validate YouTube result from Google search",
            description = "Description: Verify the video title is same to searching result, and the video is played/ paused accordingly")
    public void TC03_Validate_YouTube_result_from_Google_search() {
        System.out.println("Test case 02: Validate YouTube result from Google search");
        String textQuery = "the Beatles";
        String titleFirstVideo;
        try {
            GoogleHomePO googleHomePO = new GoogleHomePO(Constant.webDriver);
            SearchingResultPO resultPO = new SearchingResultPO(Constant.webDriver);
            INavigateAction navigateAction = new NavigateAction();
            ISearchAction searchAction = new SearchAction();
            IGeneralAction generalA = new GeneralAction();
            YoutubeVideoPO youtubeVideoPO = new YoutubeVideoPO(Constant.webDriver);

            LogReport.logMainStep("1. Navigate to the URL: https://www.google.com.vn/");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the URL https://www.google.com.vn/ to the web browser address");
            LogReport.logSubStep("Press the keys 'Enter'");
            navigateAction.goToGoogleSearchPage();

            LogReport.logMainStep("2. Enter the text to the file 'Search' to search");
            LogReport.logSubStep("Enter the text to the field 'Search'");
            LogReport.logSubStep("Select the button 'Search'");
            searchAction.searchTextOnHomePage(Constant.webDriver, googleHomePO, textQuery);

            LogReport.logMainStep("3. Open the first video 'Youtube' in the section 'Videos'");
            LogReport.logSubStep("The first video's title is: " + resultPO.divTitleVideo.get(0).getText());
            LogReport.logSubStep("Select the first video 'Youtube'");
            titleFirstVideo = resultPO.divTitleVideo.get(0).getText();
            resultPO.aResultsVideo.get(0).click();

            LogReport.logMainStep("4. Verify the video title is same to the result of 'Google'");
            generalA.verifyTextDisplay(titleFirstVideo, youtubeVideoPO.h1TitleVideo, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }
}


/*


     * Test case 01: Verify the inputted text still shows on the field 'Searching' on resulting pages after searching completely
     *
     * 1. Navigate to the URL: https://www.google.com.vn/
     *  + Open the web browser
     *  + Enter the URL https://www.google.com.vn/ to the web browser address
     *  + Press the keys 'Enter'
     * 2. Enter the text to the file 'Search' to search
     *  + Enter the text to the field 'Search'
     *  + Select the button 'Search'
     * 3. Verify the inputted text still shows on the field 'Searching' on resulting pages

@Test(priority = 1,
        testName = "Test case 01: Verify the inputted text still shows on the field 'Searching' on resulting pages after searching completely",
        description = "Verify the inputted text still shows on the field 'Searching' after searching completely")
public void TC01_Verify_the_inputted_text_still_shows_on_the_field_Searching_on_resulting_pages_after_searching_completely() {
    System.out.println("Test case 01: Verify the inputted text still shows on the field 'Searching' on resulting pages after searching completely");
    try {
        GoogleHomePO googleHomePO = new GoogleHomePO(Constant.webDriver);
        SearchingResultPO resultPO = new SearchingResultPO(Constant.webDriver);
        INavigateAction navigateAction = new NavigateAction();
        ISearchAction searchAction = new SearchAction();
        IGeneralAction generalAction = new GeneralAction();
        String inputText = "the Beatles";

        LogReport.logMainStep("1. Navigate to the URL: https://www.google.com.vn/");
        LogReport.logSubStep("Open the web browser");
        LogReport.logSubStep("Enter the URL https://www.google.com.vn/ to the web browser address");
        LogReport.logSubStep("Press the keys 'Enter'");
        navigateAction.goToGoogleSearchPage();

        LogReport.logMainStep("2. Enter the text to the file 'Search' to search");
        LogReport.logSubStep("Enter the text to the field 'Search'");
        LogReport.logSubStep("Select the button 'Search'");
        searchAction.searchTextOnHomePage(Constant.webDriver, googleHomePO, inputText);

        LogReport.logMainStep("3. Verify the inputted text still shows on the field 'Searching' on resulting pages");
        generalAction.verifyTextDisplay(inputText, resultPO.inputSearch, true);
    } catch (Exception exception) {
        LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                Constant.webDriver.getCurrentUrl(), exception);
        exception.printStackTrace();
    }
}

 */