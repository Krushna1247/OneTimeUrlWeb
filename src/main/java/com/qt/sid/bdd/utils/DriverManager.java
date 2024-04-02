package com.qt.sid.bdd.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			initializeDriver();
		}
		return driver;
	}

	private static void initializeDriver() {
		String browserName = System.getProperty("browser", FileReaderManager.getInstance().getConfigReader().getBrowserName());
		switch (browserName.toLowerCase()) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options1 = new ChromeOptions();
				options1.addArguments("remote-allow-origins=*");
				driver = new ChromeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				WebDriverManager.iedriver().setup();
				driver = new EdgeDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}
		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(
				Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitWaitTime()));

	}
	public void quitDriver() {
		driver.quit();
	}
}
