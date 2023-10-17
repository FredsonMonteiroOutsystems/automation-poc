package pages.training;

import com.codeborne.selenide.SelenideElement;
import pages.PageBase;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageBase {

    // Elements

    // I used the property type in this locator because "b3-" in ID looks generic, may can change in the future
    // And others inputs can be added in the same page later, so "type" looked more secure to me
    private final SelenideElement inputEmail = $(byAttribute("type", "email"));
    private final SelenideElement inputPassword = $(byAttribute("type", "password"));

    // In deep analysis byText and byTagAndText uses Xpath to locate the object, but not using the entire path, it gets the page elements and find the element with the text
    // It appears over processing, but it's very clean, fast and resilient if the position of the object changes
    private final SelenideElement buttonLogin = $(byTextCaseInsensitive("Log in"));

    // Methods
    public void fillEmailField(String email) {
        inputEmail.shouldBe(enabled);
        inputEmail.setValue(email);
    }

    public void fillPasswordField(String password) {
        inputPassword.shouldBe(enabled);
        inputPassword.setValue(password);
    }

    public void pressLoginButton(){
        saveScreenshot();
        buttonLogin.click();
    }
}
