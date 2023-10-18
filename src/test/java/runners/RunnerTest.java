package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, // Allure integration give to us a rich report without lots of configurations
        features = {"classpath:features"},
        glue = {"stepdefs", "hooks"}
)
public class RunnerTest {
}
