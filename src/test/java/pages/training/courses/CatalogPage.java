package pages.training.courses;

import com.codeborne.selenide.*;
import helpers.TestUtils;
import org.openqa.selenium.By;
import pages.PageBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.TestUtils.scrollToElement;

public class CatalogPage extends PageBase {

    // Elements
    private final SelenideElement selectTagsDropdown = $(".dropdown-multiselect.choices");

    // This SUT has a strong hierarchy of elements. Here I'm using it to find an element referencing other as an anchor
    private final SelenideElement inputSearchTags = selectTagsDropdown.$(By.tagName("input"));
    private final SelenideElement listOfTags = $(".choices__list");
    private final ElementsCollection listOfCourses = $$(".card-cronos__title");


    // Methods
    public void openTagsDropdownMenu() {
        selectTagsDropdown.shouldBe(visible);
        selectTagsDropdown.click();
        // Added a little sleep to wait for fade in effect
        Selenide.sleep(2000);
    }

    public void selectTagsToFilter(String tags){
        // Preparing tags from string parameter
        String[] allTags = TestUtils.separeValuesInArray(tags, ",");

        // Loop to select tags
        for (String tag : allTags) {
            inputSearchTags.setValue(tag);
            listOfTags.$$("label").findBy(and("", text(tag), visible)).click();
            inputSearchTags.shouldBe(enabled);
        }
        inputSearchTags.clear();
        saveScreenshot();
    }

    public void selectCourse(String courseName){
        // Waiting for the list with the option to load
        // This list is dynamic, so if you want to do this method explore the entire list you need to scroll for loading more options
        listOfCourses.should(CollectionCondition.containExactTextsCaseSensitive(courseName));

        // Getting the right option from the list
        SelenideElement course = listOfCourses.findBy(and("", text(courseName), visible));
        scrollToElement(course);
        saveScreenshot();
        course.click();
    }
}
