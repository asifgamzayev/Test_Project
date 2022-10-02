package com.test.HomePage;


import com.github.javafaker.Faker;
import com.test.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class HomePageSighUp {

    public HomePageSighUp(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = " //div[@class='signup-container ng-star-inserted']")
    public WebElement clickOnSighUp;

    @FindBy(xpath = "//input[@aria-label='First Name']")
    public WebElement clickOnFirstName;

    @FindBy(xpath = "//input[@aria-label='Last Name']")
    public WebElement clickOnLastName;

    @FindBy(id = "idp-month__selected")
    public WebElement clickOnMonth;

    @FindBy(xpath = "//li[@data-label='Jan']")
    public WebElement clickOnDateJan;

    @FindBy(id = "idp-date__selected")
    public WebElement clickOnDay;

    @FindBy(xpath = " //li[@data-label='1']")
    public WebElement clickOnDayOne;

    @FindBy(id = "idp-year__selected")
    public WebElement clickOnYear;

    @FindBy(xpath = " //li[@data-label='2000']")
    public WebElement clickOnYear2022;

    @FindBy(id = "idp-gender__selected")
    public WebElement clickOnGender;

    @FindBy(xpath = "//li[@data-label='Male (M)']")
    public WebElement clickOnMale;

    @FindBy(id = "basic-info-next")
    public WebElement clickOnNextButton;

    @FindBy(xpath = "//input[@aria-label='Address Line 1']")
    public WebElement clickOnAddressLine1;

    @FindBy(xpath = "//input[@aria-label='City']")
    public WebElement clickOnAddressLine2;

    @FindBy(xpath = "//div[@id='idp-countrySubdivisionCode__selected']")
    public WebElement clickOnSelectState;

    @FindBy(xpath = "//li[@data-label='Alabama']")
    public WebElement clickOnState;

    @FindBy(xpath = "//input[@aria-label='Postal Code']")
    public WebElement clickOnPostel;

    @FindBy(xpath = "//input[@aria-label='Phone Number (Mobile Preferred)']")
    public WebElement clickOnPhoneNumber;

//    @FindBy(xpath = "//input[@aria-label='Email Address']")
//    public WebElement clickOnEmail;
//
//    @FindBy(xpath = "//input[@aria-label='Confirm Email Address']")
//    public WebElement clickOnConfirmEmail;

   Faker faker = new Faker();
   String NewEmail=faker.internet().emailAddress();

    public void clickOnEmail(){

        Driver.getDriver().findElement(By.xpath("//input[@aria-label='Email Address']")).sendKeys(NewEmail);

    }

    public void clickOnConfirmEmail(){

        Driver.getDriver().findElement(By.xpath("//input[@aria-label='Confirm Email Address']")).sendKeys(NewEmail);

    }

    @FindBy(id = "contact-info-next")
    public WebElement clickOnNextButton2;

    @FindBy(xpath = "//input[@aria-label='Enter a Username']")
    public WebElement clickOnUsernameBox;

    public void clickOnUserName(){

        String chars = "abcdefghijklmnopqrstuvwxyz";
        String username = "";
        int length = 6;

        Random rand = new Random();

        char[]text = new char[length];
        for (int i = 0; i<length; i++){

            text[i]=chars.charAt(rand.nextInt(chars.length()));
        }
        for (int i = 0; i <text.length ; i++) {
            username+= text[i];
        }


        Driver.getDriver().findElement(By.xpath("//input[@aria-label='Enter a Username']")).sendKeys(username);

    }

    @FindBy(xpath = "//input[@aria-label='Enter  a Password']")
    public WebElement clickOnPassword;

    @FindBy(xpath = "//input[@aria-label='Confirm Password']")
    public WebElement clickOnConfirmPass;

    @FindBy(id = "idp-securityQs1__selected")
    public WebElement clickOn1Question;

    @FindBy(xpath = "//li[@id='securityQs1option-2']")
    public WebElement clickOnPetName;

    @FindBy(xpath = "//input[@aria-label='Answer 1']")
    public WebElement SelectOn1Answer;

    @FindBy(id = "idp-securityQs2__selected")
    public WebElement clickOn2Question;

    @FindBy(xpath = "//li[@id='securityQs2option-2']")
    public WebElement select2ndQuestion;

    @FindBy(xpath = "//input[@aria-label='Answer 2']")
    public WebElement ClickOn2ndAnswer;

    @FindBy(xpath = "//label[@class='idp-checkbox idp-checkbox__label']")
    public WebElement ClickOnMiles;

    @FindBy(xpath = "//button[@id='login-info-submit']")
    public WebElement SubmitButton;




}


