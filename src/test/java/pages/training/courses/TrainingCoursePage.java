package pages.training.courses;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.PageBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TrainingCoursePage extends PageBase {
    // Elements
    private final ElementsCollection itemsCourseMenu = $$(".left-menu-link.left-menu-level");
    private final SelenideElement courseTitle = $("h1.heading1");
    private final SelenideElement buttonStart = $("button.os-btn-confirm");


    // Methods
    public void selectMenuContent(String menuOption) {
        // Getting element visible or not
        itemsCourseMenu.should(CollectionCondition.texts(menuOption));
        saveScreenshot();
        SelenideElement item = itemsCourseMenu.findBy(text(menuOption));

        // Expanding menu dropdown items until find required menu item
        for (SelenideElement option : itemsCourseMenu) {
            if(option.getTagName().equalsIgnoreCase("div")){
                option.click();
                Selenide.sleep(2000);
            }
            if(item.isDisplayed()){
                item.click();
                break;
            }
        }

        // Expected result of the click
        buttonStart.shouldNotBe(visible);
    }

    public String getCourseTitle(){
        return courseTitle.getText();
    }

    public boolean buttonStartIsVisible(){
        saveScreenshot();
        return buttonStart.isDisplayed();
    }
}
