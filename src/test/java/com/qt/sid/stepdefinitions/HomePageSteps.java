package com.qt.sid.stepdefinitions;

import com.qt.sid.bdd.helper.LoggerHelper;
import com.qt.sid.bdd.pages.*;

import com.qt.sid.bdd.utils.FileReaderManager;
import io.cucumber.java.bs.A;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qt.sid.bdd.utils.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePageSteps extends BasePage{

    TestContext testContext;
    HomePage homePage;
    WebDriver driver;
    LandingPage landingPage;



   Logger log = LoggerHelper.getLogger(LoggerHelper.class);

    public HomePageSteps(TestContext context) {
        testContext = context;
        landingPage = testContext.getPageObjectManager().getlandingPage();
        homePage = testContext.getPageObjectManager().getHomePage();
        driver = testContext.getDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();


    }

    @Given("i navigate to Landing page")
    public void i_navigateToLandingPage() {
        landingPage.navigateTo_LoginPage();

    }


    
    @Then("I verify switch between skillcourses skillcentres and jobexchange")
    public void i_verify_switch_between_skillcourses_skillcentres_and_jobexchange(){

        landingPage.skipToMainContent();
        log.info("Clicked on Skip to Main Content button");

        homePage.visibilityOfMostPopularSection();

        homePage.clickOnSkillCoursesFromMostPopularSection();
        log.info("Clicked on skill courses section");
        Assert.assertTrue(isElementPresent(homePage.skillCoursesSearchField),"User is not able to swith to skill courses");
        log.info("User is able to switch to skill courses in most popular sectoin");

        homePage.clickOnJobExchange();
        log.info("Clicked on job exchange section");

        Assert.assertTrue(isElementPresent(homePage.jobExchangeSearchField),"User is not able to swith to Job exchange");
        log.info("User is able to switch to job exchange in most popular sectoin");

        homePage.clickOnSkillCentre();
        log.info("Clicked on skill centres section");

        Assert.assertTrue(isElementPresent(homePage.skillCentresSearchField),"User is not able to swith to skill centres");
        log.info("User is able to switch to skill centres in most popular sectoin");

        log.info("User is able to switch between skill courses, job exchange and skill centres in most popular section");


    }
    

    
    @Then("I verify important links tab functionality")
    public void i_verify_important_links_tab_functionality(){
        waitWebDriver(2000);
        homePage.clickOnSkillIndiaLogo();
        homePage.clickOnImportantLinksTab();
        log.info("Clicked on Important links tab");

    }
    


    @Then("I verify all important links access functionality About US")
    public void i_verify_all_important_links_access_functionality_about_us(){
        homePage.clickOnSkillIndiaLogo();
        homePage.clickOnImportantLinksTab();

        log.info("Clicked on Important links tab");
        homePage.clickOnAboutUs();

        log.info("Clicked on About us link");

        Assert.assertTrue(isElementPresent(homePage.aboutSKillIndiaDigitalPageText),"Unable to access About us link");
        log.info("User able to access about us link from important links");
    }

    @Then("I verify all important links access functionality Sectors")
    public void i_verify_all_important_links_access_functionality_sectors(){

        waitWebDriver(2000);
        homePage.clickOnSkillIndiaLogo();

        homePage.clickOnImportantLinksTab();

        log.info("Clicked on Important links tab");
        homePage.clickOnSectors();
        log.info("Clicked on sectors link successfully");
        waitWebDriver(2000);
    }







}
