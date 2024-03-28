package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "rahulShettyAcadamy.stepDefination", monochrome = true,tags="@submitOrder", plugin = {
		"html:target/cucumber.html" })
public class testNGTestRunner extends AbstractTestNGCucumberTests {

}
