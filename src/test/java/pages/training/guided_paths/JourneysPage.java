package pages.training.guided_paths;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.PageBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.TestUtils.scrollToElement;

public class JourneysPage extends PageBase {

    // Elements
    private final ElementsCollection listOfJourneys = $$(".card-cronos__title");

    // Methods
    public void selectJourney(String journeyName){
        // Waiting for list with the option is loaded
        listOfJourneys.should(CollectionCondition.containExactTextsCaseSensitive(journeyName));

        // Getting the right option from the list
        SelenideElement course = listOfJourneys.findBy(and("", text(journeyName), visible));
        scrollToElement(course);
        saveScreenshot();
        course.click();
    }
}
