package pages.training;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.PageBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends PageBase {

    // Elements
    private final SelenideElement buttonCookieAccept = $(By.id("onetrust-accept-btn-handler"));
    private final SelenideElement divLogin = $(byTextCaseInsensitive("Log in"));
    private final SelenideElement divUserProfileIcon = $("div.header-login-dropdown-desktop.OSInline");
    private final SelenideElement spanEmailUser = $("span.menu-row-email");

    // Methods
    public void acceptCookies() {
        buttonCookieAccept.shouldBe(visible);
        // Added a little sleep to wait for fade in effect
        Selenide.sleep(2000);
        saveScreenshot();
        buttonCookieAccept.click();
    }

    public void accessLogin(){
        divLogin.shouldBe(visible);
        // Added a little sleep to wait for fade out effect
        Selenide.sleep(2000);
        saveScreenshot();
        divLogin.click();
    }

    public String getEmailLoggedUser(){
        divUserProfileIcon.shouldBe(visible);
        divUserProfileIcon.hover();
        spanEmailUser.shouldBe(visible);
        saveScreenshot();
        return spanEmailUser.getText();
    }
}
