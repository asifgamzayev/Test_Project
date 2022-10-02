package com.test.Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


//        tags = "@ui-test",
        tags = "@api",



        features = "src/test/resources",
        glue = "com/test/StepDefenitions",
//          stepNotifications = true,

        plugin = {
                "pretty",
                "html:target/built-in-report/cucumber-html-report.html",
                "json:target/cucumber.json",
                "rerun:target/failedScenarios.txt"

        }



//        ,dryRun = true




)
public class CucumberRunner {

}
