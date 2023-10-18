package pages.training.general;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.TestUtils;
import pages.PageBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class MainMenu extends PageBase {

    // Elements
    private final ElementsCollection menuMainOptions = $$("nav > ul > span > li ");

    // Methods
    public void accessPath(String path) {
        // This method is an example of how to accelerate the automation process
        // We can go to any main menu option reusing it

        // Preparing path
        String[] pathItems = TestUtils.separeValuesInArray(path, ">>");

        // Opening children list
        SelenideElement parent = menuMainOptions.findBy(and("", text(pathItems[0]), visible));
        parent.hover();
        Selenide.sleep(2000);

        // Selecting children
        SelenideElement child = parent.$$("li").findBy(and("", text(pathItems[1]), visible));
        child.hover();
        Selenide.sleep(2000);
        saveScreenshot();
        child.click();
    }
}
