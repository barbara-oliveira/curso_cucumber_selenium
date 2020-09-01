import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/aprender_cucumber.feature",
        plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}
