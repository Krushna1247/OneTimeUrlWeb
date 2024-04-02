package com.qt.sid.stepdefinitions;

import java.io.File;
import java.io.IOException;

import com.qt.sid.bdd.utils.DriverManager;
import com.qt.sid.bdd.utils.FileReaderManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qt.sid.bdd.pages.BasePage;
import com.qt.sid.bdd.utils.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	TestContext testContext;
	private static WebDriver driver;

	public Hooks(TestContext context){

		testContext=context;
	}

	@Before
	public void setup() {
		if (driver == null) {
			DriverManager driverManager = new DriverManager();
			driver = driverManager.getDriver();
			driver.get(FileReaderManager.getInstance().getConfigReader().getHomePageUrl());
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterStep(order = 1)
	public void addScreenshot(Scenario scenario) throws IOException {

		if(scenario.isFailed()) {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
			scenario.attach(fileContent,"image/png", "screenshot");
		}



		//File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		//scenario.attach(BasePage.getScreenShot(), "image/png", "screenshot");
	}
	@After
	public void tearDown() {
		System.out.println("Quitting driver");

//		driver.manage().deleteAllCookies();
//		testContext.getDriverManager().quitDriver();
	}
}