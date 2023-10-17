package stepdefs.general;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.GlobalParameters;
import io.cucumber.java.en.Given;

public class GeneralStepdefs {

    // Steps
    @Given("the OutSystems training website is opened")
    public void accessLoginOption() {
        Selenide.closeWebDriver(); // Used to finish any instance of webdriver if each execution will consider a new execution from zero
        Configuration.holdBrowserOpen = false; // Used as true for help in development
        //Configuration.headless = false; // Used for CLI or some CI/CD environments
        Configuration.timeout = 60000; // Increased the time because sometimes the website is getting slow
        Selenide.open(GlobalParameters.getInstance().getProperty("BASE_URL_TRAINING"));
        if(!Configuration.headless){
            Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        }
    }
}
