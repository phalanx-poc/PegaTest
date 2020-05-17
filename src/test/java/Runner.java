import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
//        tags = {"@Pass"},
        features = "src/test/java",
        plugin = {"pretty", "html:target/Report"}
)
public class Runner {

}

