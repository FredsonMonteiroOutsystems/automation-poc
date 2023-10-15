package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class GeneralHook {

    public static Scenario scenario;

    // Metrics can be collected using annotations like these in a framework wrapping the project
    @Before
    public void testStart() {
        // Here could be used to get instance the webdriver for pure Selenium. It's not needed using Selenide
        // Selenide.webdriver() <-  It can be used anytime to call webdriver and be able to use it directly
    }

    @AfterStep
    public void testAfterStep() {
        // If you have an approach to take screenshot after each step, it can be done here
        // I prefer to save screenshot in key parts of the script to do not increase the final evidences unnecessarily
    }

    @After
    public void testEnd() {
    }
}
