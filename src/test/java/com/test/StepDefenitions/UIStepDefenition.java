package com.test.StepDefenitions;

import com.github.javafaker.Faker;

import com.test.HomePage.HomePageSighUp;
import com.test.Utilities.ConfigReader;
import com.test.Utilities.Driver;
import com.test.Utilities.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import javax.xml.ws.Response;

public class UIStepDefenition {
Response response;

Faker faker = new Faker();

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));


    }
    @When("I navigate to singup page and enter valid credentials.")
    public void i_navigate_to_singup_page_and_enter_valid_credentials() {
        HomePageSighUp homePage = new HomePageSighUp();

        homePage.clickOnSighUp.click();
        SeleniumUtils.jsClick( homePage.clickOnFirstName);
        homePage.clickOnFirstName.sendKeys(faker.address().firstName());
        SeleniumUtils.jsClick( homePage.clickOnLastName);
        homePage.clickOnLastName.sendKeys(faker.address().lastName());
        homePage.clickOnMonth.click();
        homePage.clickOnDateJan.click();
        homePage.clickOnDay.click();
        homePage.clickOnDayOne.click();
        homePage.clickOnYear.click();
        homePage.clickOnYear2022.click();
        homePage.clickOnGender.click();
        homePage.clickOnMale.click();
        homePage.clickOnNextButton.click();

        SeleniumUtils.waitFor(2);

        homePage.clickOnAddressLine1.click();
        homePage.clickOnAddressLine1.sendKeys(faker.address().streetAddress());
        SeleniumUtils.scroll(0,200);
        SeleniumUtils.jsClick( homePage.clickOnAddressLine2);
        homePage.clickOnAddressLine2.sendKeys(faker.address().city());
        SeleniumUtils.scroll(0,200);
        homePage.clickOnSelectState.click();
        homePage.clickOnState.click();
        SeleniumUtils.scroll(0,200);
        SeleniumUtils.jsClick( homePage.clickOnPostel);
        homePage.clickOnPostel.sendKeys(faker.address().zipCode());
        SeleniumUtils.jsClick( homePage.clickOnPhoneNumber);
        homePage.clickOnPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        SeleniumUtils.scroll(0,200);
        homePage.clickOnEmail();
        homePage.clickOnConfirmEmail();
        SeleniumUtils.waitFor(3);
        homePage.clickOnNextButton2.click();

        SeleniumUtils.waitFor(2);
        SeleniumUtils.jsClick(homePage.clickOnUsernameBox);

        homePage.clickOnUserName();
        homePage.clickOnPassword.click();
        SeleniumUtils.scroll(0,200);
        String pass= faker.internet().password(8, 15);
        homePage.clickOnPassword.sendKeys(pass+"LA");
        homePage.clickOnConfirmPass.click();
        homePage.clickOnConfirmPass.sendKeys(pass+"LA");
        SeleniumUtils.scroll(0,200);
        homePage.clickOn1Question.click();
        SeleniumUtils.scroll(500,200);
        homePage.clickOnPetName.click();
        homePage.SelectOn1Answer.click();
        homePage.SelectOn1Answer.sendKeys(faker.cat().name());
        SeleniumUtils.scroll(0,200);
        homePage.clickOn2Question.click();
        homePage.select2ndQuestion.click();
        homePage.ClickOn2ndAnswer.click();
        homePage.ClickOn2ndAnswer.sendKeys(faker.address().firstName());
        SeleniumUtils.scroll(0,200);
//        homePage.ClickOnMiles.click();
        homePage.SubmitButton.click();


    }
    @Then("I should be able to sing up successfully")
    public void i_should_be_able_to_sing_up_successfully() {
        Assert.assertEquals("https://www.delta.com/join-skymiles/", Driver.getDriver().getCurrentUrl());


    }



















//    https://www.delta.com/myprofile/personal-details?from=smenrollment&originalApp=web


}
