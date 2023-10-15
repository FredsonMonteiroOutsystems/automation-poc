package pages.home;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.base.PageBase;

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
        buttonCookieAccept.should(Condition.visible);
        saveScreenshot();
        buttonCookieAccept.click();
    }

    public void accessLogin(){
        divLogin.should(Condition.visible);
        saveScreenshot();
        divLogin.click();
    }

    public String getEmailLoggedUser(){
        divUserProfileIcon.should(Condition.visible);
        divUserProfileIcon.hover();
        spanEmailUser.should(Condition.visible);
        saveScreenshot();
        return spanEmailUser.getText();
    }
}
