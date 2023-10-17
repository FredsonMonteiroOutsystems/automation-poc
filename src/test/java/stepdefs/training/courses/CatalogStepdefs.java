package stepdefs.training.courses;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.training.courses.CatalogPage;
import pages.training.courses.TrainingCoursePage;
import pages.training.general.MainMenu;

public class CatalogStepdefs {
    // Instances of pages
    MainMenu mainMenu = new MainMenu();
    CatalogPage catalogPage = new CatalogPage();
    TrainingCoursePage trainingCoursePage = new TrainingCoursePage();

    @When("I access the menu {}")
    public void iAccessTheMenu(String menuPath) {
        mainMenu.accessPath(menuPath);
    }

    @And("I select tags {}")
    public void iSelectTags(String tags) {
        catalogPage.openTagsDropdownMenu();
        catalogPage.selectTagsToFilter(tags);
    }

    @And("I choose the course {}")
    public void iChooseTheCourse(String courseName) {
        catalogPage.selectCourse(courseName);
    }

    @And("I pick the {} option from the sidebar")
    public void iPickTheOptionFromTheSidebar(String sidebarOption) {
        trainingCoursePage.selectMenuContent(sidebarOption);
    }

    @Then("the course title should be {}")
    public void theCourseTitleShouldBe(String courseName) {
        String courseTitle = trainingCoursePage.getCourseTitle();
        Assert.assertEquals("The Course Title is different", courseName, courseTitle);
    }

    @And("the course should already be started")
    public void theCourseShouldAlreadyBeStarted() {
        boolean buttonStartVisibility = trainingCoursePage.buttonStartIsVisible();
        Assert.assertFalse("Button Start still being displayed", buttonStartVisibility);
    }
}
