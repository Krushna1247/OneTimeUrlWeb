package com.qt.sid.bdd.utils;

public interface EnvironmentConstants {

	/* **************** Environments **************** */
	String ENVIRONMENT = System.getProperty("env")!=null?System.getProperty("env"):"UAT";

	//Add Enum on Environments
	/* **************** TestData file paths **************** */
	
	String BASE_URL = BaseURL.valueOf(ENVIRONMENT).getBaseURL();
	String TEST_DATA_PATH = TestDataPath.valueOf(ENVIRONMENT).getTestDataPath();

	/**
	 * Enum BaseURL
	 * 
	 * @@author  
	 *
	 */
	enum BaseURL {
		PRODUCTION("https://www.skillindiadigital.gov.in/home"), UAT("https://uat-web-sid.betalaunch.in/home"), QA("https://testregistry.nsdcindia.co");

		private String baseURl;

		public String getBaseURL() {
			return this.baseURl;
		}

		private BaseURL(String baseURl) {
			this.baseURl = baseURl;
		}
	}

	/**
	 * Enum TestDataPath
	 * 
	 * @author 
	 *
	 */
	enum TestDataPath {
		LOCAL("src/test/resources/TestData/Local/"), STAGING("src/test/resources/TestData/Staging/"),
		QA("src/test/resources/TestData/Qa/");

		private String testDataPath;

		public String getTestDataPath() {
			return this.testDataPath;
		}

		private TestDataPath(String testDataPath) {
			this.testDataPath = testDataPath;
		}
	}
}