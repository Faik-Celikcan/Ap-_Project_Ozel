package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/test/resources/features/API",//features folder path
        glue = {"stepdefinitions","hooks"},   //stepdefinitions path
        tags = "@6",
        dryRun = false

)
public class US06Runner {

}
