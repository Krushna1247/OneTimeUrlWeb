package com.qt.sid.stepdefinitions;

import com.qt.sid.bdd.utils.DriverManager;
import com.qt.sid.bdd.utils.FileReaderManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class testing {

    private WebDriver driver = Hooks.getDriver();


    @Given("I launch the new Browser")
    public void iLaunchTheNewBrowser() {
        if (driver == null) {
            DriverManager driverManager = new DriverManager();
            driver = driverManager.getDriver();
        }
    }

    @And("I open SID Home Page")
    public void iOpenSIDHomePage() {
        if (driver == null) {
            throw new IllegalStateException("Browser has not been initialized");
        }
        driver.get(FileReaderManager.getInstance().getConfigReader().getHomePageUrl());
    }
}