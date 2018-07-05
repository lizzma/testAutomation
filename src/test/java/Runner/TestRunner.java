package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(/*plugin = {"pretty"},*/
        format = {"pretty", "html:target/html/"},
        features = "src/test/resources/Features",
        tags = {"@sitenavigation"},
        glue = {"src/test/java/StepsDefinitions"})




public class TestRunner {

}
