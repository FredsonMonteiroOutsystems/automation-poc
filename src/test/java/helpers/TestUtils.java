package helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestUtils {
    // Helpers methods

    public static String[] separeValuesInArray(String text, String separator){
        String[] items = text.split(separator);
        return Arrays.stream(items).map(String::trim).toArray(String[]::new);
    }

    public static void scrollToElement(SelenideElement element) {
        int elementPosition = element.getLocation().getY();
        int viewPortHeight = Selenide.webdriver().driver().getWebDriver().manage().window().getSize().getHeight();
        int scrollY = elementPosition - (viewPortHeight / 2);

        executeJavaScript("window.scrollTo(0, " + scrollY + ");");
        Selenide.sleep(2000);
    }
}
