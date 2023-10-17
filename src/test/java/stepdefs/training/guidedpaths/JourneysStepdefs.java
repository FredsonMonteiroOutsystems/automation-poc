package stepdefs.training.guidedpaths;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.training.guided_paths.JourneysPage;

public class JourneysStepdefs {
    // Instances of Pages
    JourneysPage journeysPage = new JourneysPage();

    @And("I select the training journey {}")
    public void iSelectTheTrainingJourney(String journeyName) {
        journeysPage.selectJourney(journeyName);
    }
}
