package com.test.StepDefenitions;


import com.github.javafaker.Faker;
import com.test.Utilities.TestUtils;
import com.test.Utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

//
//    @BeforeAll
//    public static void setupDb(){
//
//        TestUtils.createConnection();
//    }
//
//    @AfterAll
//    public static void closeDB(){
//
//       TestUtils.close();
//    }


    @Before("not @api")
    public void setup(){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }




    @After ("not @api")

    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){

            byte[] screenshotAs = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs,"image/png", "screenshotOfFailure");
        }

        Driver.quitDriver();
    }
}
