package hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.GlobalParameters;
import io.cucumber.java.*;
import io.qameta.allure.selenide.AllureSelenide;

public class GeneralHook {

    public static Scenario scenario;

    // Metrics can be collected using annotations like these in a framework wrapping the project

    @BeforeAll
    public static void before_all(){
        // Here could be used to get the webdriver instance for pure Selenium. It's not needed using Selenide
        // Selenide.webdriver() <-  It can be used anytime to call webdriver and be able to use it directly
        GlobalParameters.getInstance();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Before
    public void testStart(Scenario _scenario) {
        scenario = _scenario;
    }

    @AfterStep
    public void testAfterStep() {
        // If you have an approach to take screenshot after each step, it can be inserted here
        // I prefer to save screenshot in key parts of the script to do not increase the final evidences unnecessarily
    }

    @After
    public void testEnd() {
    }
}
