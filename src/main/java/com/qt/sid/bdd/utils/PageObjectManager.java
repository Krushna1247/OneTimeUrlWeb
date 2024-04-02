package com.qt.sid.bdd.utils;

import com.qt.sid.bdd.pages.*;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    private WebDriver driver;

    private HomePage homePage;



    private LandingPage landingPage;


    public PageObjectManager(WebDriver driver) {

        this.driver = driver;
        BasePage.basePageDriver(driver);
    }

    public HomePage getHomePage() {

        return (homePage == null) ? homePage = new HomePage(driver) : homePage;

    }



    public LandingPage getlandingPage() {

        return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;

    }





}