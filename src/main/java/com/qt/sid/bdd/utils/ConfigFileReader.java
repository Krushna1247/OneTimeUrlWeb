package com.qt.sid.bdd.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "src/main/java/com/qt/sid/config/Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public long getImplicitWaitTime() {
		String implicitWaitTime = properties.getProperty("implicitWaitTime");
		if (implicitWaitTime != null)
			return Long.parseLong(implicitWaitTime);
		else
			throw new RuntimeException("implicitWaitTime not specified in the Configuration.properties file.");
	}

	public String getHomePageUrl() {
		String homePageURL = properties.getProperty("homePageURL");
		if (homePageURL != null)
			return homePageURL;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getBrowserName() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return "chrome";
		else if (browserName.equalsIgnoreCase("firefox"))
			return browserName;
		else if (browserName.equals("ie"))
			return browserName;
		else if (browserName.equals("edge"))
			return browserName;
		else if (browserName.equals("safari"))
			return browserName;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public String getPersonalDetailsJsonPath() {
		String personalDetailsJsonPath = properties.getProperty("personalDetailsJsonPath");
		if (personalDetailsJsonPath != null)
			return personalDetailsJsonPath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}


	public String getAboutUSTextFromProperty() {
		String aboutUS = properties.getProperty("AboutUS");
		if (aboutUS != null)
			return aboutUS;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}


	public String getTermsAndConditionsTextFromProperty() {
		String termsAndConditions = properties.getProperty("TermsAndConditions");
		if (termsAndConditions != null)
			return termsAndConditions;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getPrivacyPolicyTextFromProperty() {
		String privacyPolicy = properties.getProperty("PrivacyPolicy");
		if (privacyPolicy != null)
			return privacyPolicy;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getDisclaimerTextFromProperty() {
		String disclaimer = properties.getProperty("Disclaimer");
		if (disclaimer != null)
			return disclaimer;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getContactUsTextFromProperty() {
		String contactUs = properties.getProperty("ContactUs");
		if (contactUs != null)
			return contactUs;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getFaceBookTextFromProperty() {
		String faceBook = properties.getProperty("FaceBook");
		if (faceBook != null)
			return faceBook;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getLinkedInTextFromProperty() {
		String linkedIn = properties.getProperty("LinkedIn");
		if (linkedIn != null)
			return linkedIn;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getTwitterTextFromProperty() {
		String twitter = properties.getProperty("Twitter");
		if (twitter != null)
			return twitter;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getYouTubeTextFromProperty() {
		String youTube = properties.getProperty("YouTube");
		if (youTube != null)
			return youTube;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getPMKVY4SchemeTextFromProperty() {
		String PMKVY4Scheme = properties.getProperty("PMKVY4Scheme");
		if (PMKVY4Scheme != null)
			return PMKVY4Scheme;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getSectorsTextFromProperty() {
		String sectors = properties.getProperty("Sectors");
		if (sectors != null)
			return sectors;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getJobRolesTextFromProperty() {
		String jobRoles = properties.getProperty("JobRoles");
		if (jobRoles != null)
			return jobRoles;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getSkillIndiaMapTextFromProperty() {
		String skillIndiaMap = properties.getProperty("SkillIndiaMap");
		if (skillIndiaMap != null)
			return skillIndiaMap;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getMinisrtySkillDevTextFromProperty() {
		String minisrtySkillDev = properties.getProperty("MinisrtySkillDev");
		if (minisrtySkillDev != null)
			return minisrtySkillDev;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getPublicGrievancesTextFromProperty() {
		String PG = properties.getProperty("PublicGrievances");
		if (PG != null)
			return PG;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getIndiaGOVInTextFromProperty() {
		String indiaGovIn = properties.getProperty("IndiaGovIn");
		if (indiaGovIn != null)
			return indiaGovIn;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getTowardOfNewTextFromProperty() {
		String towardOfNew = properties.getProperty("TowardOfNew");
		if (towardOfNew != null)
			return towardOfNew;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getRecommendationInKannada(){
		String recommendation = properties.getProperty("RecommendationInKannada");
		if (recommendation != null)
			return  recommendation;
		else
			throw new RuntimeException("Recommendation not specified in the Config property file");
	}

	public String getSkillCoursesInKannada(){
		String skillCourses = properties.getProperty("SkillCoursesInKannada");
		if (skillCourses != null)
			return  skillCourses;
		else
			throw new RuntimeException("Recommendation not specified in the Config property file");
	}

	public String getJobExchangeInKannada(){
		String jobExchange = properties.getProperty("JobExchangeInKannada");
		if (jobExchange != null)
			return  jobExchange;
		else
			throw new RuntimeException("Recommendation not specified in the Config property file");
	}

	public String getSkillCentresInKannada(){
		String skillCentre = properties.getProperty("SkillCentresInKannada");
		if (skillCentre != null)
			return  skillCentre;
		else
			throw new RuntimeException("Skill Centres not specified in the Config property file");
	}

	public String getSkillIndiaMapInKannada(){
		String skillIndiaMap = properties.getProperty("SkillIndiaMapInKannada");
		if (skillIndiaMap != null)
			return  skillIndiaMap;
		else
			throw new RuntimeException("Skill India Map not specified in the Config property file");
	}
	
	public String getMobileNumberForEditBtnVerify() {
		String mobNumberForEdit = properties.getProperty("MobileNumberForEdit");
		if (mobNumberForEdit != null)
             return mobNumberForEdit;
		else
			throw new RuntimeException("Mobile number not specified in the config property file");
	}
	
	public String getMobileNumberForLoginWithLearner() {
		String mobNumberForLearner = properties.getProperty("LearnerMobileNumber");
		if (mobNumberForLearner != null)
             return mobNumberForLearner;
		else
			throw new RuntimeException("Learner Mobile number not specified in the config property file");
	}

	public String getMobileNumberForLoginWithLearningPartner() {
		String mobNumberForLearner = properties.getProperty("LearningPartnerMobileNumber");
		if (mobNumberForLearner != null)
			return mobNumberForLearner;
		else
			throw new RuntimeException("Learner Mobile number not specified in the config property file");
	}
	
	public String getPinZero() {
		String pinZero = properties.getProperty("PinZero");
		if (pinZero != null)
             return pinZero;
		else
			throw new RuntimeException("Pin zero is not specified in the config property file");
	}
	public String getPinOne() {
		String pinOne = properties.getProperty("PinOne");
		if (pinOne != null)
             return pinOne;
		else
			throw new RuntimeException("Pin one is not specified in the config property file");
	}
	public String getPinTwo() {
		String pinTwo = properties.getProperty("PinTwo");
		if (pinTwo != null)
             return pinTwo;
		else
			throw new RuntimeException("pinTwo is not specified in the config property file");
	}
	public String getPinThree() {
		String pinThree = properties.getProperty("PinThree");
		if (pinThree != null)
             return pinThree;
		else
			throw new RuntimeException("pinThree is not specified in the config property file");
	}
	
	public String getBengaluruCity() {
		String bengaluru = properties.getProperty("BangaloreCity");
		if (bengaluru != null)
             return bengaluru;
		else
			throw new RuntimeException("Bengaluru city is not specified in the config property file");
	}
	
	public String getIndustry() {
		String industry =  properties.getProperty("Industry");
		if(industry != null)
			return industry;
		else
			throw new RuntimeException("Industry is not specified in the config property file");
	}
	
	public String getLocation() {
		String location =  properties.getProperty("LocationCity");
		if(location != null)
			return location;
		else
			throw new RuntimeException("Location is not specified in the config property file");
	}
	
	public String getState() {
		String state =  properties.getProperty("StateFilter");
		if(state != null)
			return state;
		else
			throw new RuntimeException("State is not specified in the config property file");
	}
	
	public String getCourse() {
		String course =  properties.getProperty("CourseFilter");
		if(course != null)
			return course;
		else
			throw new RuntimeException("Course is not specified in the config property file");
	}
	
	public String getJobExchangeName(){
		String jobExchangeName =properties.getProperty("JobExchangeName");

		if(jobExchangeName!=null)
			return jobExchangeName;
		else throw  new RuntimeException("JobExchangeName is not specified in the config property file");
	}

	public String getJobExchangeRadioButtonSearch(){
		String jobExchangeRadioButtonSearch=properties.getProperty("JobExchangeRadioButtonSearch");

		if(jobExchangeRadioButtonSearch!=null)
			return jobExchangeRadioButtonSearch;

		else throw new RuntimeException("jobExchangeRadioButtonSearch is not specified in the config property file");
	}


	public String getSkillMapDigitalCity(){
		String skillMapDigitalCity =properties.getProperty("SkillMapDigitalCity");
		if(skillMapDigitalCity!=null)
			return skillMapDigitalCity;
		else  throw new RuntimeException("skillMapDigitalCity is not specified int he config property file");
	}

	public String getJobExchangeSearchValue(){
		String jobExchangeSearchValue =properties.getProperty("JobExchangeSearchValue");
		if(jobExchangeSearchValue!=null)
			return  jobExchangeSearchValue;
		else  throw new RuntimeException("jobExchangeSearchValue is not specified int he config property file");

	}
	
	public long getExplicitWaitTime() {
		   String explicitWaitTime = properties.getProperty("explicitWaitTime");
		   if (explicitWaitTime != null)
		      return Long.parseLong(explicitWaitTime);
		   else
		      throw new RuntimeException("implicitWaitTime not specified in the Configuration.properties file.");
		}

	public String getWelcomePopupTermsAndConditions() {
		String welcomeTermsAndConditions = properties.getProperty("WelcomePopupTermsAndConditions");
		if (welcomeTermsAndConditions != null)
			return welcomeTermsAndConditions;
		else
			throw new RuntimeException("Url not specified in the Configuration.properties file.");
	}

	public String getWelcomePopupPrivacyPolicy() {
		String welcomePrivacyPolicy = properties.getProperty("WelcomePopupPrivacyPolicy");
		if (welcomePrivacyPolicy != null)
			return welcomePrivacyPolicy;
		else
			throw new RuntimeException("Url not specified in the Configuration.properties file.");
	}

	public String getHomePageUrlToVerify() {
		String homePageUrl = properties.getProperty("Home");
		if (homePageUrl != null)
			return homePageUrl;
		else
			throw new RuntimeException("Url not specified in the Configuration.properties file.");
	}

	public String getGovernmentOfIndiaTextFromProperty() {
		String governmentOfIndia = properties.getProperty("GovernmentOfIndia");
		if (governmentOfIndia != null)
			return governmentOfIndia;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getAssessmentAgencyCredForUATFromProperty() {
		String assessmentAgencyUAT = properties.getProperty("AssessmentAgencyCredUAT");
		if (assessmentAgencyUAT != null)
			return assessmentAgencyUAT;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getMobileNumberForLoginWithRDSDE() {
		String mobNumberForLearner = properties.getProperty("RDSDEPROD");
		if (mobNumberForLearner != null)
			return mobNumberForLearner;
		else
			throw new RuntimeException("Learner Mobile number not specified in the config property file");
	}

	public String getMobileNumberForLoginWithNSDCAdminRole() {
		String mobNumberForLearner = properties.getProperty("NSDCAdminPROD");
		if (mobNumberForLearner != null)
			return mobNumberForLearner;
		else
			throw new RuntimeException("Learner Mobile number not specified in the config property file");
	}

	public String getMobileNumberForLoginWithApprenticeshipSSCRole() {
		String mobNumberForLearner = properties.getProperty("ApprenticeshipSSCRolePROD");
		if (mobNumberForLearner != null)
			return mobNumberForLearner;
		else
			throw new RuntimeException("Learner Mobile number not specified in the config property file");
	}

	public String getMobileNumberForLoginWithNSTIRole() {
		String mobNumberForLearner = properties.getProperty("NSTIRolePROD");
		if (mobNumberForLearner != null)
			return mobNumberForLearner;
		else
			throw new RuntimeException("Learner Mobile number not specified in the config property file");
	}

	public String getAnnouncementTitleerrorMessage() {
		String announcementTitleerrorMessage = properties.getProperty("TitleErrorMsg");
		if (announcementTitleerrorMessage != null)
			return announcementTitleerrorMessage;
		else
			throw new RuntimeException("TitleErrorMsg not specified in the Configuration.properties file.");
	}

	public String getAnnouncementDescriptionerrorMessage() {
		String AnnouncementDescriptionerror = properties.getProperty("DescriptionErrorMsg");
		if (AnnouncementDescriptionerror != null)
			return AnnouncementDescriptionerror;
		else
			throw new RuntimeException("DescriptionErrorMsg not specified in the Configuration.properties file.");
	}

	public String getDGTAdminCredForUATFromProperty() {
		String dgtAdminCredUAT = properties.getProperty("DGTAdminCredUAT");
		if (dgtAdminCredUAT != null)
			return dgtAdminCredUAT;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getDGTAdminCredForProdFromProperty() {
		String dgtAdminCredProd = properties.getProperty("DGTAdminCredProd");
		if (dgtAdminCredProd != null)
			return dgtAdminCredProd;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getStateCredForProdFromProperty() {
		String stateUserCredProd = properties.getProperty("StateUserProd");
		if (stateUserCredProd != null)
			return stateUserCredProd;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getITICredForProdFromProperty() {
		String itiUserCredProd = properties.getProperty("ITIUserProd");
		if (itiUserCredProd != null)
			return itiUserCredProd;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getITICredForUATFromProperty() {
		String itiUserCredUAT = properties.getProperty("ITIUserUAT");
		if (itiUserCredUAT != null)
			return itiUserCredUAT;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getBTPCredFromProperty() {
		String btpUserCred = properties.getProperty("BTPCred");
		if (btpUserCred != null)
			return btpUserCred;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getTPACredFromProperty() {
		String tpaUserCred = properties.getProperty("TPACred");
		if (tpaUserCred != null)
			return tpaUserCred;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getEstablishmentCredFromProperty() {
		String establishmentUserCred = properties.getProperty("EstablishmentCred");
		if (establishmentUserCred != null)
			return establishmentUserCred;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getTCUserCredForUATFromProperty() {
		String tcUserCredUAT = properties.getProperty("TCUserCredUAT");
		if (tcUserCredUAT != null)
			return tcUserCredUAT;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getStateCredForUATFromProperty() {
		String stateUserUAT = properties.getProperty("StateUserUAT");
		if (stateUserUAT != null)
			return stateUserUAT;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}


	public String getPinNine() {
		String pinNine = properties.getProperty("PinNine");
		if (pinNine != null)
			return pinNine;
		else
			throw new RuntimeException("Pin one is not specified in the config property file");
	}

	public String getPinEight() {
		String pinEight = properties.getProperty("PinEight");
		if (pinEight != null)
			return pinEight;
		else
			throw new RuntimeException("Pin one is not specified in the config property file");
	}

	public String getPinSeven() {
		String pinSeven = properties.getProperty("PinSeven");
		if (pinSeven != null)
			return pinSeven;
		else
			throw new RuntimeException("Pin one is not specified in the config property file");
	}

	public String getPinSix() {
		String pinSix = properties.getProperty("PinSix");
		if (pinSix != null)
			return pinSix;
		else
			throw new RuntimeException("Pin one is not specified in the config property file");
	}

	public String getZeroPinNumber() {
		String zeroPin = properties.getProperty("ZeroPinNumber");
		if (zeroPin != null)
			return zeroPin;
		else
			throw new RuntimeException("Pin one is not specified in the config property file");
	}
}
