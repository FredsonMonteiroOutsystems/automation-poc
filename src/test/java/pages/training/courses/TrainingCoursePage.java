package pages.training.courses;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.PageBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.TestUtils.scrollToElement;
import static helpers.TestUtils.waitForElementsCollection;

public class TrainingCoursePage extends PageBase {
    // Elements
    private final ElementsCollection itemsCourseMenu = $$(".left-menu-link.left-menu-level");
    private final SelenideElement courseTitle = $("h1.heading1");
    private final SelenideElement buttonStart = $("button.os-btn-confirm");


    // Private Methods
    private void clickInMenuSidebarOption(SelenideElement item){
        item.shouldBe(interactable);
        // Is necessary move scroll to object when running in headless mode
        scrollToElement(item);
        item.click();
        waitForElementsCollection(itemsCourseMenu);
        saveScreenshot();
    }

    // Public Methods
    public void selectMenuContent(String menuOption) {
        waitForElementsCollection(itemsCourseMenu);
        SelenideElement item = itemsCourseMenu.findBy(and("", text(menuOption), tagName("a")));
        saveScreenshot();

        // Expanding and closing menu dropdown items until find required menu item
        for (SelenideElement option : itemsCourseMenu) {
            if (item.isDisplayed()) {
                clickInMenuSidebarOption(item);
                break;
            }
            if (option.is(enabled) && option.is(interactable) && option.getTagName().equalsIgnoreCase("div")) {
                option.click();
                // Waiting for possible slow loading of the object
                waitForElementsCollection(itemsCourseMenu);
                if (item.isDisplayed()) {
                    clickInMenuSidebarOption(item);
                    break;
                } else {
                    option.click();
                }
            }
            waitForElementsCollection(itemsCourseMenu);
        }
    }

    public String getCourseTitle(String courseName) {
        courseTitle.shouldHave(exactText(courseName));
        return courseTitle.getText();
    }

    public boolean checkIfButtonStartNotExist() {
        // Waiting for the expected result
        buttonStart.shouldNotBe(visible);
        saveScreenshot();
        return buttonStart.isDisplayed();
    }
}
