package stepdefs.training.courses;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogStepdefs {
    @When("access menu {}")
    public void accessMenuTrainingCourses(String menuPath) {

    }

    @And("select tags {}")
    public void selectTags(String tags) {
    }

    @And("Select the course {}")
    public void selectTheCourse(String course) {
    }

    @Then("title, sidebar and main content will be displayed")
    public void titleSidebarMainContentWillBeDisplayed() {
    }

    @Then("selected curse will be opened to continue")
    public void selectedCurseWillBeOpenedToContinue() {
    }
}
