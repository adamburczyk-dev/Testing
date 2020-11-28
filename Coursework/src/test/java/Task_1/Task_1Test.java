package Task_1;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/NewAddress_Task1.feature",
        plugin = {"pretty","html:out"}
)
public class Task_1Test {
}
