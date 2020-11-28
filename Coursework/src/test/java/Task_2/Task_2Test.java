package Task_2;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/Task_2.feature",
        plugin = {"pretty","html:out"}
)

public class Task_2Test {
}
