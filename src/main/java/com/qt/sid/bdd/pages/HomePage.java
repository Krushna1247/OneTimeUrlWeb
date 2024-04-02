package com.qt.sid.bdd.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qt.sid.bdd.utils.FileReaderManager;
import org.testng.Assert;


public class HomePage extends BasePage{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Dismiss")
	private WebElement dismissBtn;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement selectProductBasedOn;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountBtn;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutBtn;
	
	@FindBy(xpath = "//input[@name='s']")
	private WebElement searchBox;

	@FindBy(xpath = "//span[text()=' English ']")
	private WebElement language;


	@FindAll({
			@FindBy(xpath = "//*[text()='Skill Courses']"),
			@FindBy(xpath = "//a[@title='Skill Courses']")
	})
	public WebElement skillCourses;
	
	@FindBy(xpath = "//div[text()=' Skill Courses ']")
	public WebElement mostPopularSkillCoursesTab;
	
	@FindBy(xpath = "//p[text()=' Online ']")
	public WebElement assertOnlineCourses;
	
	@FindBy(xpath = "//div[text()=' Job Exchange ']")
	public WebElement jobExchange;
	
	@FindBy(xpath = "//h5[text()='Job']")
	public WebElement assertJobText;
	
	@FindBy(xpath = "//div[text()=' Skill Centre ']")
	public WebElement skillCentre;
	
	@FindBy(xpath = "//div[@class='card-detail']")
	public WebElement assertSkillCentre;
	
	@FindBy(xpath = "//span[text()='Opportunities near you']")
	public WebElement opportunitiesNearYou;
	
	@FindBy(xpath = "//p[normalize-space()='Satellite View']")
	public WebElement assertSkillIndiaMap;

	@FindAll({
			@FindBy(xpath = "//*[text()='Learning Resources']"),
			@FindBy(xpath = "//span[text()='Learning Resources']")
	})
	public WebElement learningResourcestab;
	
	@FindBy(xpath = "//a[text()='Learning Resources']")
	public WebElement learningResourcePageText;
	
	@FindBy(xpath = "//span[text()=' All ']")
	public WebElement allSection;

	@FindAll({
			@FindBy(xpath = "//*[text()=' VIDEO ']"),
			@FindBy(xpath = "//span[text()=' Video ']")
	})
	public WebElement videoSection;

	@FindAll({
			@FindBy(xpath = "//*[text()=' PDF ']"),
			@FindBy(xpath = "//span[text()=' Pdf ']")
	})
	public WebElement pdfSection;

	@FindAll({
			@FindBy(xpath = "//a[@class='widget-menu important-links']"),
			@FindBy(xpath = "//span[text()='Important Links']")
	})
	public WebElement importantLinksTab;
	
	@FindBy(xpath = "//button[text()=' Sectors ']")
	public WebElement sectorsBtn;
	
	@FindBy(xpath = "//button[text()=' About us ']")
	public WebElement aboutUsBtn;
	
	@FindBy(xpath = "//button[text()=' e-books ']")
	public WebElement ebooksBtn;
	
	@FindBy(xpath = "//button[text()=' Skill Universities ']")
	public WebElement skillUniversitiesBtn;
	
	@FindBy(xpath = "//h2[text()='About Skill India Digital']")
	public WebElement aboutSKillIndiaDigitalPageText;
	
	@FindBy(xpath = "//h3[text()='eBooks']")
	public WebElement ebooksPageText;
	
	@FindBy(xpath = "//a[text()=' Skill Universities ']")
	public WebElement skillUniversitiesLink;

	@FindBy(xpath = "//span[text()='Opportunities near you']/parent::button")
	public WebElement OpportunitiesNearYouBtn;

	@FindBy(xpath = "//label[text()='Select Interest Area']/following-sibling::input")
	public WebElement selectInterestAreaTextField;

	@FindBy(xpath = "//span[@class='mat-option-text']/parent::mat-option")
	public WebElement clickOnSelecteedIntrestArea;

	@FindBy(xpath = "//button[contains(.,' Find Skill Courses ')]")
	public WebElement findSkikllCourseBtn;

	@FindBy(xpath = "//input[@data-placeholder='Search Job Exchange']")
	public WebElement searchJobExchemgeTextField;

	@FindBy(xpath = "//button[contains(.,'Explore Job Exchange')]")
	public WebElement exploreJobExchangeBtn;

	@FindBy(xpath = "//*[text()=' Flooring Work ']")
	public WebElement flooringWorkJobOption;

	@FindBy(xpath = "//*[text()=' Trainer ']")
	public WebElement trainerJobOption;
	@FindBy(xpath = "//button[contains(@class,'mat-focus-indicator mat-icon-button mat-button-base ng-tns-c')]")
	public WebElement matBtn;

	@FindBy(xpath = "//div[contains(@id,'mat-select')]//span[contains(text(),'Below 10th Standard')]/parent::mat-option")
	public WebElement selectEducationTextfield;

	@FindBy(xpath = "//button[contains(.,' Next')]")
	public WebElement nextBtn;

	@FindBy(xpath = "//span[normalize-space()='Recommendation']/parent::a")
	public WebElement recommendationLink;

	@FindBy(xpath = "//*[text()='Recommendation']")
	public WebElement recommendationHeader;


	@FindBy(xpath = "//*[text()='Skill Courses']")
	public WebElement skillCourseHeader;

	@FindBy(xpath = "//*[text()=' Job Exchange ']")
	public WebElement jobExchangeHeader;

	@FindBy(xpath = "//*[text()='Skill Centre']")
	public WebElement skillCentreHeader;

	@FindBy(xpath = "//*[text()='Skill India Map']")
	public WebElement skillIndiaMapHeader;

	@FindBy(xpath = "//span[@class='d-none d-md-block']/parent::a")
	public WebElement schemesLink;

	@FindBy(xpath = "//button[@title='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//input[@id='searchInput']")
	public WebElement search_place_holder;

	@FindBy(xpath = "//div[contains(@id,'mat-tab-label')]//div[@class='mat-tab-label-content']")
	public WebElement mostPopularText;

	String mostPopularCourses = "//div[contains(text(),'%s')]/ancestor::div[contains(@id,'mat-tab-label')]";

	@FindBy(xpath = "//input[@id='searchInput']")
	public WebElement mostPopularSearchTextField;

	@FindBy(xpath = "//button[@id='button-addon2']")
	public WebElement mostPopularSearchBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search Skill Courses']")
	public WebElement skillCoursesSearchField;
	
	@FindBy(xpath = "//input[@placeholder='Search Job exchange']")
	public WebElement jobExchangeSearchField;
	
	@FindBy(xpath = "//input[@placeholder='Search Skill Centres']")
	public WebElement skillCentresSearchField;

	@FindBy(xpath = "//a[text()='Government of India']")
	public WebElement governmentOfIndiaLink;

	@FindBy(xpath = "//img[@alt='Skill India Logo']")
	public WebElement skillIndiaLogo;

	@FindBy(xpath = "(//span[text()='Go To Course'])[1]")
	public WebElement goToCourse;

	@FindBy(xpath = "//button[text()=' Go To Course ']")
	public WebElement goToCourseOne;

	@FindBy(xpath = "//*[text()=' Course Details']")
	public WebElement courseDetailsSection;

	@FindBy(xpath = "(//button[text()=' View Details '])[1]")
	public WebElement viewDetails;

	@FindBy(xpath = "//span[text()='Job Description']")
	public WebElement jobDescriptionSection;

	@FindBy(xpath = "//h5[text()=' Courses Offered ']")
	public WebElement courseDetailsInPopup;

	@FindBy(xpath = "(//button[normalize-space(text())='Register'])[1]")
	public WebElement registerButton;

	@FindBy(xpath = "//div[@class='role-detail']")
	public WebElement learnerOption;

	@FindBy(xpath = "//button[@title='Register']")
	public WebElement registerTooltip;


	@FindBy(xpath = "//h3[text()='Welcome to Skill India Digital']")
	public WebElement welcomeToSkillIndiaText;

	@FindBy(xpath="//div[@class='government-text']/child::span[1]")
	public WebElement headerText;

	@FindBy(xpath = "//div[@class='government-text']/child::a")
	public WebElement headerText2;

	@FindBy(xpath="//ul[@class='navbar-nav']/li")
	public List<WebElement> header3;

	@FindBy(xpath = "//button[@title='Search']")
	public WebElement searchImage;

	@FindBy(id = "searchInput")
	public WebElement searchEditField;


	@FindBy(xpath = "//*[contains(text(),'Courses ')]")
	public WebElement coursesSection;

	@FindBy(xpath = "//*[text()='Microsoft']")
	public WebElement byMicrosoftCourses;

	@FindBy(xpath = "//*[contains(text(),'Employment Opportunities ')]")
	public WebElement employmentOpportunitiesSection;

	@FindBy(xpath = "//*[contains(text(),'Skill Centre ')]")
	public WebElement skillCentreSection;

	@FindBy(xpath = "(//*[@class='nav-icon'])[7]")
	public WebElement threeDots;

	@FindBy(xpath = "//button[text()=' Virtual Training Sessions ']")
	public WebElement virtualTrainingSessions;

	@FindBy(xpath = "//a[text()='Virtual Training Sessions']")
	public WebElement footerVirtualSessions;

	@FindBy(xpath = "//a[contains(@href,'https://play.google.com/')]")
	public WebElement playstoreLink;

	@FindBy(xpath = "//*[text()='google_logo Play']")
	public WebElement playStoreLogo;

	@FindBy(xpath = "//a[@href='https://www.apple.com/in/app-store/']")
	public WebElement appStoreLink;

	@FindBy(xpath = "//a[@href='/in/app-store/']")
	public WebElement appStoreLogo;

	@FindBy(xpath = "//*[text()=' Building a Skilled India ']//following::button[text()=' Register ']")
	public WebElement registerUnderSkilledSection;

	@FindBy(xpath = "//*[@alt='PMKVY Laptop Banner']")
	public WebElement pmkvyBanner;

	@FindBy(xpath = "//*[text()=' I want to learn! ']")
	public WebElement iWantToLearnSection;

	@FindBy(xpath = "//*[text()=' Look for a Skill Centre near you ']//following::button[text()=' Learn More ']")
	public WebElement learnMoreButton3;

	@FindBy(xpath = "//*[text()=' All ']")
	public WebElement allTab;

	@FindBy(xpath = "//*[@class='skill-course-card-v2']")
	public WebElement courseCard;

	@FindBy(xpath = "//*[text()='About Us']")
	public WebElement footerAboutUs;

	@FindBy(xpath = "//*[text()='About Skill India Digital']")
	public WebElement aboutUsPageText;

	@FindBy(xpath = "//*[text()='Features of Skill India Digital']")
	public WebElement featuresOfSkillIndiaSection;

	@FindBy(xpath = "//*[@data-icon='plus']")
	public List<WebElement> plusIcon;

	@FindBy(xpath = "//*[text()='Free Content and Services:']")
	public WebElement discoveryContent;

	@FindBy(xpath = "//*[text()=' My Dashboard ']")
	public WebElement myDashboard;

	@FindBy(xpath = "//*[text()=' Survey & Poll ']")
	public WebElement surveyAndPoll;

	@FindBy(xpath = "//*[text()=' View ']")
	public WebElement viewInProfile;

	@FindBy(xpath = "//*[text()=' My Activities ']")
	public WebElement myActivities;

	@FindBy(xpath = "//*[text()=' My Courses ']")
	public WebElement myCourses;

	@FindBy(xpath = "//*[text()=' My Credits ']")
	public WebElement myCredits;

	@FindBy(xpath = "//*[text()=' Favourite ']")
	public WebElement favourite;

	@FindBy(xpath = "//*[text()=' My Activity Analysis ']")
	public WebElement myActivityAnalysis;

	@FindBy(xpath = "//*[text()=' My Virtual Training Sessions ']")
	public WebElement myVirtualTrainingSessions;

	@FindBy(xpath = "//*[text()=' My Skilling Program ']")
	public WebElement mySkillingProgram;

	@FindBy(xpath = "//*[text()=' PMKVY ']")
	public WebElement pmkvy;

	@FindBy(xpath = "//*[text()=' e-SHRAM ']")
	public WebElement eshram;

	@FindBy(xpath = "//*[text()=' Settings ']")
	public WebElement settings;

	@FindBy(xpath = "//*[text()='Preferences']")
	public WebElement preferences;

	@FindBy(xpath = "//*[text()='Change Password']")
	public WebElement changePassword;

	@FindBy(xpath = "//*[text()='Privacy Consent']")
	public WebElement privacyConsent;

	@FindBy(xpath = "//*[text()='Manage Alerts']")
	public WebElement manageAlerts;

	@FindBy(xpath = "//*[text()=' Logout ']")
	public WebElement logout;

	@FindBy(xpath = "//*[text()=' Type ']")
	public WebElement typeInSkillUniversities;

	@FindBy(xpath = "//*[text()=' Location ']")
	public WebElement locationInSkillUniversities;

	@FindBy(id = "stateSearch")
	public WebElement locationSearch;

	@FindBy(xpath = "//*[text()='West Bengal ']")
	public WebElement searchedLocation;

	@FindBy(xpath = "//*[text()='Dashboards']")
	public WebElement dashabords;

	@FindBy(xpath = "//button[text()=' PMKVY ']")
	public WebElement PMKVYUnderDashboard;

	@FindBy(xpath = "//button[text()=' NAPS ']")
	public WebElement NapsUnderDashboard;

	@FindBy(xpath = "//button[text()=' Convergence ']")
	public WebElement ConvergenceUnderDashboard;

	@FindBy(xpath = "//a[@title='Contact Us']")
	public WebElement contactUsLink;

	@FindBy(xpath = "//button[text()=' Enroll ']")
	public WebElement enrollBtn;

	@FindBy(xpath = "//button[text()=' Continue ']")
	public WebElement continueBtn;

	@FindBy(xpath = "//*[text()='Start']")
	public WebElement startBtn;

	@FindBy(xpath = "//*[text()='Resume']")
	public WebElement resumeBtn;

	@FindBy(xpath = "//video")
	public WebElement video;
	@FindBy(xpath = "//*[@class='title-head']")
	public WebElement titleHead;

	@FindBy(xpath = "//*[text()=' Video ']")
	public WebElement videoSectionUnderLearningResource;

	@FindBy(xpath = "//*[@class='skill-course-card-v2']")
	public List<WebElement> videoContentCard;

	@FindBy(xpath = "//button[text()=' Download ']")
	public WebElement downloadBtn;


	@FindBy(xpath = "//button[@title='Share']")
	public WebElement shareVideoBtn;

	@FindBy(xpath = "//*[text()=' Share this Content ']")
	public WebElement shareThisContentPopupText;

	@FindBy(xpath = "//button[@title='Close']")
	public WebElement shareCrossBtn;

	@FindBy(xpath = "//*[text()=' Content Type ']")
	public WebElement contentType;

	@FindBy(xpath = "//*[text()='Video']")
	public WebElement videoContentType;

	@FindBy(xpath = "//*[text()='Pdf']")
	public WebElement pdfContentType;

	@FindBy(xpath = "//*[text()=' PMKVY ']")
	public WebElement pmkvyContentCard;

	@FindBy(xpath = "//*[text()=' Content Category ']")
	public WebElement contentCategory;

	@FindBy(xpath = "//*[text()='PMKVY']")
	public WebElement pmkvyCategory;

	@FindBy(xpath = "//*[text()=' Language ']")
	public WebElement languageCategory;

	@FindBy(xpath = "//*[text()='English']")
	public WebElement englishLanguage;

	@FindBy(xpath = "//button[text()=' RESET  ']")
	public WebElement resetButton;

	@FindBy(xpath = "//*[@class='card']")
	public List<WebElement> sectorCardList;

	@FindBy(xpath = "//p[text()='Courses']")
	public WebElement totalCoursesInSector;

	@FindBy(xpath = "//p[text()='Apprenticeships']")
	public WebElement totalApprenticeshipsInSector;

	@FindBy(xpath = "//p[text()=' Employment Opportunities ']")
	public WebElement totalEmploymentOpportunitiesInSector;

	@FindBy(xpath = "//p[text()='Skill Centre']")
	public WebElement totalSkillCentresInSector;

	@FindBy(xpath = "//button[@title='Share']")
	public List<WebElement> shareOption;

	@FindBy(xpath = "//*[text()=' Share this Opportunities ']")
	public WebElement shareThisOpportunitiesText;

	@FindBy(xpath = "//*[@title='Favorite']")
	public List<WebElement> favoriteOption;

	@FindBy(xpath = "(//button[contains(text(),'Favourite')])[1] ")
	public WebElement favoriteSectionInJobExchange;

	@FindBy(xpath = "(//*[@title='Favorite'])[1]")
	public WebElement selectedFavoriteBtn;

	@FindBy(xpath = "//button[text()=' View Details ']")
	public List<WebElement> viewDetailsList;

	@FindBy(xpath = "//button[text()=' Apply Now ']")
	public WebElement ApplyNowBtn;

	@FindBy(xpath = "//*[text()='Roles & Responsibilities']")
	public WebElement RolesAndResponsibilities;

	@FindBy(xpath = "//*[text()='Private ']")
	public WebElement privateType;

	@FindBy(xpath = "(//button[text()=' Apply '])[2]")
	public WebElement applyBtn1;

	@FindBy(xpath = "(//button[text()=' RESET FILTER '])[2]")
	public WebElement resetFilterBtn1;

	@FindBy(xpath = "//*[@class='skill-university-card-v2']")
	public WebElement skillUniversityCard;

	@FindBy(xpath = "//button[text()=' View Details ']")
	public List<WebElement> viewDetailsOfSkillUniversity;

	@FindBy(xpath = "//*[contains(text(),'West Bengal')]")
	public WebElement appliedFilteredSkillUniversityCard;

	@FindBy(xpath = "(//*[@class='skill-university-card-v2']//following::button)[1]")
	public WebElement locationIconButton;

	@FindBy(xpath = "(//*[@role='presentation'])[1]")
	public WebElement banner1;

	@FindBy(xpath = "//*[@aria-label='3 of 3']")
	public WebElement banner3;

	@FindBy(xpath = "//a[@href='https://www.skillindiadigital.gov.in/world-skills-india']")
	public WebElement indiaSkillBanner;

	@FindBy(xpath = "//a[@href='https://www.skillindiadigital.gov.in/user/profile/dashboard']")
	public WebElement firstBanner;


	@FindBy(xpath = "//*[text()='APPLY FOR INDIASKILLS 2023 INDIA’S LARGEST SKILL COMPETITION']")
	public WebElement indiaSkillsPageText;

	@FindBy(xpath = "//*[text()='Please Provide Your Aadhaar Number']")
	public WebElement completeeKYCPopup;

	@FindBy(xpath = "//*[@class='widget-menu announcement-menu']")
	public WebElement announcementsOption;

	@FindBy(xpath = "//span[normalize-space(text())='Announcements']")
	public WebElement announcementsBtn;

	@FindBy(xpath = "//*[text()=' Announcements ']")
	public WebElement announcementsPageText;

	@FindBy(xpath = "//*[text()=' Sort ']")
	public WebElement sortButtonInAnnouncements;

	@FindBy(xpath = "//*[@class='widget-menu dashboard-menu']")
	public WebElement dashboardOption;

	@FindBy(xpath = "//button[text()=' India Skills ']")
	public WebElement indiaSkillsOption;

	@FindBy(xpath = "//button[text()=' Digital Learning Analytics ']")
	public WebElement digitalLearningAnalyticsOption;

	@FindBy(xpath = "//button[text()=' NSDC International ']")
	public WebElement nsdcInternationalOption;

	@FindAll({
			@FindBy(xpath = "//*[text()='PM Vishwakarma Summary']"),
			@FindBy(xpath = "//button[text()=' PM Vishwakarma Summary ']")
	})
	public WebElement pmVishwakarmaSummaryOption;

	@FindBy(xpath = "//*[text()='Apprenticeship']")
	public WebElement apprenticeshipOption;

	@FindBy(xpath = "//span[normalize-space()='Apprenticeship Dashboard']")
	public WebElement apprenticeshipDashboardLink;

	@FindBy(xpath = "//span[normalize-space()='NAPS DBT Dashboard']")
	public WebElement napsDbtDashboard;

	@FindBy(xpath = "//*[text()='PMKVY']")
	public WebElement pmkvyOption;

	@FindBy(xpath = "//span[normalize-space()='Summary Dashboard']")
	public WebElement summaryDashboard;

	@FindBy(xpath = "//span[normalize-space()='Premium Analytics Dashboard']")
	public WebElement premiumAnalyticsDashboard;

	@FindBy(xpath = "//span[normalize-space()='State level performance Dashboard']")
	public WebElement stateLevelPerformanceDashboard;

	@FindBy(xpath = "//a[normalize-space()='Help & Support']")
	public WebElement helpAndSupportLink;

	@FindBy(xpath = "//a[@href='/scheme/list']")
	public WebElement schemesFooterLink;

	@FindBy(xpath = "//*[text()=' Skilling Program ']")
	public WebElement skillingProgramHeaderLink;

	@FindBy(xpath = "//*[text()=' Sector Skill Council ']")
	public WebElement sectorSkillCouncilLink;

	@FindBy(xpath = "//*[text()=' National Career Service ']")
	public WebElement nationalCareerServiceLink;

	@FindBy(xpath = "//*[text()='A&A Knowledge Bank']")
	public WebElement aaKnowledgeBank;

	@FindBy(xpath = "//*[text()='A&a FAQs']")
	public WebElement aaFAQsLInk;

	@FindBy(xpath = "//*[text()=' MoHUA ']")
	public WebElement mohuaLink;

	@FindBy(xpath = "//*[text()='PMKVY A&C Guidelines']")
	public WebElement pmkvyACGuidelinesLink;

	@FindBy(xpath = "//*[text()='Standalone NOS Listing']")
	public WebElement standaloneNOSListingLink;

	@FindBy(xpath = "//*[text()='Borrowed QP Listing']")
	public WebElement borrowedQPListingLink;

	@FindBy(xpath = "//*[text()='SCPwD Borrowed QP']")
	public WebElement scpwdBorrowedQPLink;

	@FindBy(xpath = "//*[text()='QP Listing']")
	public WebElement qpListingLink;

	@FindBy(xpath = "//*[text()=' Important Links ']")
	public WebElement importantLinksLink;

	@FindBy(xpath = "//*[@class='important-link-header']")
	public WebElement importantLinksHeader;

	@FindBy(xpath = "//*[text()='Accreditation Grading Metrics - Skill Ecosystem Guidelines']")
	public WebElement firstQuickLink;

	@FindBy(xpath = "//*[text()='Guidelines of Accreditation, Affiliation and continuous Monitoring of Training Centres']")
	public WebElement secondQuickLink;

	@FindBy(xpath = "//*[text()='National Qualifications Register (NQR)']")
	public WebElement thirdQuickLink;

	@FindBy(xpath = "//*[text()='NSQC process and guidelines']")
	public WebElement fourthQuickLink;

	@FindBy(xpath = "//*[text()='List of TOT/TOA certified Trainers/Assessors']")
	public WebElement fifthQuickLink;


	@FindBy(xpath = "//*[normalize-space()='Building a Skilled India']")
	public WebElement buildingASkillIndiaSection;

	@FindBy(xpath = "//*[normalize-space()='Citizen Centric']")
	public WebElement citizenCentricSection;

	@FindBy(xpath = "//*[normalize-space()='Career Focussed']")
	public WebElement careerFocussedSection;

	@FindBy(xpath = "//*[normalize-space()='Multilingual']")
	public WebElement multilingualSection;

	@FindBy(xpath = "//*[text()=' Skill India Connect ']")
	public WebElement skillIndiaConnectSection;


	@FindBy(xpath = "//*[@class='latest-news-card']")
	public WebElement skillIndiaConnectCard;

	@FindBy(xpath = "(//*[text()=' View Details '])[1]")
	public WebElement viewDetailsOnSkillIndiaConnect;


	@FindBy(xpath = "//button[text()=' View All ']")
	public WebElement viewAllInSkillIndiaConnect;

	@FindBy(xpath = "//a[text()=' Skill India Connect ']")
	public WebElement skillIndiaConnectHeader;

	@FindBy(xpath = "//button[text()=' All ']")
	public WebElement allSectionUnderSkillIndiaConnect;

	@FindBy(xpath = "//button[text()=' Last Week ']")
	public WebElement lastWeekSectionUnderSkillIndiaConnect;


	@FindBy(xpath = "(//button[@title='Play'])[1]")
	public WebElement playbutton;


	@FindBy(xpath = "//button[text()=' Learn More ']//following::button[3]")
	public WebElement skillCoursesSlider;


	@FindBy(xpath = "//button[text()=' Learn More ']")
	public List<WebElement> learnMoreButton;

	@FindBy(xpath = "//button[text()=' Learn More ']//following::button[4]")
	public WebElement jobExchangeSlider;

	@FindBy(xpath = "//button[text()=' Learn More ']//following::button[5]")
	public WebElement skillCentreSlider;

	//chatbot

	@FindBy(xpath = "//*[@class='minimized-view-v2-cross-icon  ']")
	public WebElement chatbot;

	@FindBy(xpath = "//*[text()='Find Skill Courses']")
	public WebElement skillCourseInChatbot;

	@FindBy(xpath = "//*[text()='Automotive']")
	public WebElement automotiveInChatbot;

	@FindBy(xpath = "//*[text()='Agriculture']")
	public WebElement agricultureinChatbot;

	@FindBy(xpath = "//*[contains(text(),'Would you like to take your course online or offline')]")
	public WebElement onlineOrOfflineMessageInChatbot;

	@FindBy(xpath = "//*[text()='Online']")
	public WebElement onlineInchatbot;

	@FindBy(xpath = "//*[text()='English']")
	public WebElement englishInChatbot;

	@FindBy(xpath = "//*[text()='Enroll Now']")
	public WebElement enrollNowInChatbot;

	@FindBy(xpath = "//span[text()='View More']")
	public WebElement viewMoreInChatbot;


	@FindBy(xpath = "//a[@title='Contact Us']")
	public WebElement contactUsLinkInHomePage;

	@FindBy(xpath = "//*[normalize-space()='Submit Query']")
	public WebElement submitQueryText;

	@FindBy(xpath = "//*[@formcontrolname='FirstName']")
	public WebElement firstNameTextField;

	@FindBy(xpath = "//*[@formcontrolname='LastName']")
	public WebElement lastNameTextField;


	@FindBy(xpath = "//*[@formcontrolname='Email']")
	public WebElement emailTextField;

	@FindBy(xpath = "//*[@formcontrolname='MobileNo']")
	public WebElement mobileNumberTextField;

	@FindBy(xpath = "//*[text()='Select State']")
	public WebElement selectStateDropdown;

	@FindBy(xpath = "//*[text()=' ANDHRA PRADESH ']")
	public WebElement andhraState;

	@FindBy(xpath = "//*[text()='Select District']")
	public WebElement districtDropdown;

	@FindBy(xpath = "//*[text()=' Anantapur ']")
	public WebElement anantapurDistrict;

	@FindBy(xpath = "//*[@formcontrolname='Feedback']")
	public WebElement feedbackTextField;

	@FindBy(xpath = "//*[@formcontrolname='Message']")
	public WebElement commentsTextField;

	@FindBy(xpath = "//*[text()=' Submit ']")
	public WebElement querySubmitBtn;

	@FindBy(xpath = "//*[text()='Response submited successfully']")
	public WebElement querySubmittedToastMessage;


	@FindBy(xpath = "//a[@href='tel:8800055555']")
	public WebElement contactNumber;

	@FindBy(xpath = "//a[text()=' Address - Ministry of Skill Development & Entrepreneurship Kaushal Bhawan, 3rd Floor, New Moti Bagh New Delhi 110023. ']")
	public WebElement addressLink;

	@FindBy(xpath = "//*[text()='Kaushal Bhawan']")
	public WebElement kaushalBhawanHeader;

	@FindBy(xpath = "//*[text()='New Moti Bagh, New Delhi, Delhi 110023']")
	public WebElement kaushalBhawanAddress;

	@FindBy(xpath = "//*[@class='rating-stars']")
	public WebElement ratings;

	@FindBy(xpath = "//*[contains(text(),'reviews')]")
	public WebElement reviews;

	@FindBy(xpath = "//a[text()='View larger map']")
	public WebElement viewLargerMapLink;

	@FindBy(xpath ="//*[text()='Directions']")
	public WebElement directionsBtn;

	@FindBy(xpath = "//button[@title='Zoom in']")
	public WebElement zoomInOption;

	@FindBy(xpath = "//button[@title='Zoom out']")
	public WebElement zoomOutOption;





	public void sendMostPopularSearchTextField(String value){
		mostPopularSearchTextField.sendKeys(value);
	}

	public WebElement getSearchBox() {
		return searchBox;
	}
	
	
	public void dismiss_TestPage_info() {
		object_Click(dismissBtn);
	}
	
	
	
	public void navigateTo_LoginPage() {
		object_Click(myAccountBtn);
	}
	
	public void navigateTo_CheckoutPage() {
		object_Click(checkoutBtn);
	}
	
	public void select_productBased(String value) {
		selectOptionByValue(selectProductBasedOn, value);

    }

	public void changeAppLanguage() { object_Click(language); }

	
	public void clickOnSkillCourses() {

		waitWebDriver(3000);
		clickWithJavaScript(skillCourses);
	}
	
	public void clickOnSkillCoursesFromMostPopularSection() {
		waitTillTheElementIsVisibleAndClickable(mostPopularSkillCoursesTab);
		clickWithJavaScript(mostPopularSkillCoursesTab);
	}
	
	public void clickOnJobExchange() {
		waitTillTheElementIsVisibleAndClickable(jobExchange);
		clickWithJavaScript(jobExchange);
	}
	
	public void clickOnSkillCentre() {
		waitTillTheElementIsVisibleAndClickable(skillCentre);
		clickWithJavaScript(skillCentre);
	}
	
	public void clickOnOpportunitiesNearYou() {
		waitTillTheElementIsVisibleAndClickable(opportunitiesNearYou);
		clickWithJavaScript(opportunitiesNearYou);
	}
	
	public void clickOnLearningResourcesTab() {
		waitTillTheElementIsVisibleAndClickable(learningResourcestab);
		object_Click(learningResourcestab);
	}
	
	public void clickOnImportantLinksTab() {
		waitWebDriver(2000);
		object_Click(importantLinksTab);
		waitWebDriver(2000);
		//object_Click(importantLinksTab);
	}
	
	public void clickOnSectors() {
		waitTillTheElementIsVisibleAndClickable(sectorsBtn);
		clickWithJavaScript(sectorsBtn);
	}
	
	public void clickOnAboutUs() {
		
		waitTillTheElementIsVisibleAndClickable(aboutUsBtn);
		clickWithJavaScript(aboutUsBtn);
	}
	
	public void clickOnEbooks() {
		
		waitTillTheElementIsVisibleAndClickable(ebooksBtn);
		clickWithJavaScript(ebooksBtn);
	}
	
	public void clickOnSkillUniversities() {
		waitTillTheElementIsVisibleAndClickable(skillUniversitiesBtn);
		clickWithJavaScript(skillUniversitiesBtn);
	}

	public void visibilityOfSkillIndiaMap() {
		waitTillTheElementIsVisibleAndClickable(assertSkillIndiaMap);
	}
	
	public void visibilityOfLearningResourcesPage() {
		waitTillTheElementIsVisibleAndClickable(allSection);
	}


	public void sendSelectInterestAreaTextField(String value) {
		scrollToElement(selectInterestAreaTextField);
		selectInterestAreaTextField.sendKeys(value);
	}

	public void clickOnSelectedIntrestArea(){
		clickWithJavaScript(clickOnSelecteedIntrestArea);
	}


	public void clickFindSkillCourseBtn() throws InterruptedException {

		Thread.sleep(2000);
		clickWithJavaScript(findSkikllCourseBtn);
	}

	public void sendSearchJobExchengeTextField(String value) {
		scrollToElement(searchJobExchemgeTextField);
		searchJobExchemgeTextField.sendKeys(value);
		//sendKeysToObjects(driver,searchJobExchemgeTextField,value);

	}

	public void clickExploreJobBtn() throws InterruptedException {

		Thread.sleep(2000);
		clickWithJavaScript(exploreJobExchangeBtn);


	}

	public void selectTheFlooringWorkJob() throws InterruptedException {

		Thread.sleep(2000);
		//clickWithJavaScript(flooringWorkJobOption);
		clickWithJavaScript(trainerJobOption);


	}

	public void clickMatBtn() throws InterruptedException {
		Thread.sleep(2000);
		scrollToElement(matBtn);
		clickWithJavaScript(matBtn);
	}

	public void clickSelectEducationTextField() {
		waitClickableElement(selectEducationTextfield,30);
		clickWithJavaScript(selectEducationTextfield);
	}

	public void clickNextBtn() throws InterruptedException {

		Thread.sleep(2000);
		clickWithJavaScript(nextBtn);
	}


	public void clickOpportunitiesNearYouBtn() {
		scrollToElement(OpportunitiesNearYouBtn);
		waitWebDriver(2000);
		scrollUp();
		waitTillTheElementIsVisibleAndClickable(OpportunitiesNearYouBtn);
		clickWithJavaScript(OpportunitiesNearYouBtn);
		waitWebDriver(2000);
	}


	public void clickOnSchemesLink() {
		waitTillTheElementIsVisibleAndClickable(schemesLink);
		clickWithJavaScript(schemesLink);
		waitWebDriver(3000);
	}
	public void clickOnRecommendationLink() {
		recommendationLink.click();
	}

	public void verifyRecommendationColor(){
		object_Click(recommendationHeader);

		waitWebDriver(1000);
		String color =recommendationHeader.getCssValue("color");
		String bc = Color.fromString(color).asHex();
		String expectedColor="#df6e12";
		org.testng.Assert.assertEquals(bc,expectedColor);

	}

	public void verifySkillCourseColor(){
		object_Click(skillCourseHeader);

		waitWebDriver(1000);
		String color =skillCourseHeader.getCssValue("color");
		String bc = Color.fromString(color).asHex();
		String expectedColor="#df6e12";
		org.testng.Assert.assertEquals(bc,expectedColor);

	}

	public void verifyJobExchangeColor(){
		object_Click(jobExchangeHeader);

		waitWebDriver(1000);
		String color =jobExchangeHeader.getCssValue("color");
		String bc = Color.fromString(color).asHex();
		String expectedColor="#df6e12";
		org.testng.Assert.assertEquals(bc,expectedColor);

	}

	public void verifySkillCentreColor(){
		object_Click(skillCentreHeader);

		waitWebDriver(1000);
		String color =skillCentreHeader.getCssValue("color");
		String bc = Color.fromString(color).asHex();
		String expectedColor="#df6e12";
		org.testng.Assert.assertEquals(bc,expectedColor);

	}

	public void verifySkillIndiaMapColor(){
		object_Click(skillIndiaMapHeader);

		waitWebDriver(1000);
		String color =skillIndiaMapHeader.getCssValue("color");
		String bc = Color.fromString(color).asHex();
		String expectedColor="#df6e12";
		org.testng.Assert.assertEquals(bc,expectedColor);

	}


	public void clickOnSearchBtnHomePage() {
		object_Click(searchBtn);
	}



	public String getAtributeSearchText(String value) {
		return search_place_holder.getAttribute(value);
	}

	public void scrollTillMostPopularElement(){
		scrollToElement(mostPopularText);
	}

	public WebElement converToWebElement(String currentXpath,String replacingXpath){
		String xpath = String.format(currentXpath,replacingXpath);
		return driver.findElement(By.xpath(xpath));
	}
	public void clickMostPopularCourses(String replacinXpath) throws InterruptedException {
		Thread.sleep(3000);
		clickWithJavaScript(converToWebElement(mostPopularCourses,replacinXpath));
	}

	public void clickOnMostPoularSearchTextBtn() {
		clickWithJavaScript(mostPopularSearchBtn);
	}
	
	public void visibilityOfMostPopularSection() {
		waitWebDriver(2000);
		scrollDown();
		waitWebDriver(2000);
		scrollDown();
	}

	public void clickOnGovernmentOfIndiaLink(){
		waitTillTheElementIsVisibleAndClickable(governmentOfIndiaLink);
		clickWithJavaScript(governmentOfIndiaLink);
		waitWebDriver(3000);
	}

	public void clickOnSkillIndiaLogo(){
		waitTillTheElementIsVisibleAndClickable(skillIndiaLogo);
		clickWithJavaScript(skillIndiaLogo);
		waitWebDriver(3000);
	}

	public void clickOnGoToCourse(){
		waitTillTheElementIsVisibleAndClickable(goToCourse);
		clickWithJavaScript(goToCourse);
		waitWebDriver(3000);
	}

	public void clickOnGoToCourseOne(){
		waitTillTheElementIsVisibleAndClickable(goToCourseOne);
		clickWithJavaScript(goToCourseOne);
		waitWebDriver(3000);
	}

	public void clickOnViewDetails(){
		waitWebDriver(3000);
		waitTillTheElementIsVisibleAndClickable(viewDetails);
		object_Click(viewDetails);
	}

	public void clickOnViewDetailsInSectors(){
		waitWebDriver(3000);
		waitTillTheElementIsVisibleAndClickable(viewDetailsList.get(0));
		clickWithJavaScript(viewDetailsList.get(0));
		waitWebDriver(2000);
	}

	public void verifyRegisterButtonColor(){
		String color =registerButton.getCssValue("background-color");
		String bc = Color.fromString(color).asHex();
		String expectedColor="#df6e12";
		Assert.assertEquals(bc,expectedColor);

		String fontColor =registerButton.getCssValue("color");
		String fc =Color.fromString(fontColor).asHex();
		String ec ="#ffffff";
		Assert.assertEquals(fc,ec);

	}



	public void verifyWelcomeToSkillIndiaTextColor(){
		object_Click(registerButton);
		waitWebDriver(1000);
		object_Click(learnerOption);
		waitWebDriver(1000);
		String color =welcomeToSkillIndiaText.getCssValue("color");
		String bc = Color.fromString(color).asHex();
		String expectedColor="#333333";
		Assert.assertEquals(bc,expectedColor);
	}

	public String verifyHeaderText(){
		String text=getTextOfObject(headerText).trim();
		return text;
	}

	public String verifyHeaderText2(){
		String text=getTextOfObject(headerText2).trim();
		return text;
	}

	public void verifyHeaderText3(){
		String[] values ={"Skip To Main Content","Location","English"};
		for(int i=0;i<header3.size()-2;i++){
			String actualValue =header3.get(i).getText().trim();
			String expectedValue=values[i];
			Assert.assertEquals(actualValue,expectedValue);
		}

	}

	public void clickOnSearchImage(){
		waitTillTheElementIsVisibleAndClickable(searchImage);
		clickWithJavaScript(searchImage);
	}

	public void clickOnSearchEditField(){
		waitTillTheElementIsVisibleAndClickable(searchEditField);
		object_Click(searchEditField);
	}


	public void enterKeywordInSearchField(){
		searchEditField.sendKeys("Microsoft");
		searchEditField.sendKeys(Keys.ENTER);

		waitWebDriver(4000);
	}


	public void clickOnThreeDots(){
        waitTillTheElementIsVisibleAndClickable(threeDots);
		object_Click(threeDots);
		waitWebDriver(2000);
	}

	public void clickOnVirtualTrainingSession(){
		waitTillTheElementIsVisibleAndClickable(virtualTrainingSessions);
		object_Click(virtualTrainingSessions);
		waitWebDriver(3000);
	}

	public void clickOnFooterVirtualTrainingSession(){
		waitWebDriver(4000);
		waitTillTheElementIsVisibleAndClickable(footerVirtualSessions);
		object_Click(footerVirtualSessions);
		waitWebDriver(3000);
	}

	public void clickOnPlaystoreLink(){
		scrollToElement(playstoreLink);
		waitWebDriver(2000);
		scrollUp();
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(playstoreLink);
		object_Click(playstoreLink);
		waitWebDriver(2000);
	}

	public void clickOnAppStoreLink(){
		scrollToElement(appStoreLink);
		waitWebDriver(2000);
		scrollUp();
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(appStoreLink);
		object_Click(appStoreLink);
		waitWebDriver(2000);
	}

	public void clickOnRegisterUnderBuildASkilledSection(){
		scrollToElement(registerUnderSkilledSection);
		waitWebDriver(2000);
		scrollUp();
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(registerUnderSkilledSection);
		object_Click(registerUnderSkilledSection);
		waitWebDriver(2000);
	}

	public void clickOnPMKVYBannerInHomePage(){
        waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(pmkvyBanner);
		clickWithJavaScript(pmkvyBanner);
		waitWebDriver(3000);
	}

	public void clickOnLearnMoreButton(){
		waitWebDriver(2000);
		scrollToElement(iWantToLearnSection);
		waitWebDriver(2000);
		scrollDown();
		waitWebDriver(3000);
		scrollDown();
		waitTillTheElementIsVisibleAndClickable(learnMoreButton3);
		clickWithJavaScript(learnMoreButton3);
		waitWebDriver(3000);
	}

	public void clickOnAllTab(){
		waitTillTheElementIsVisibleAndClickable(allTab);
		object_Click(allTab);
		waitWebDriver(2000);
	}

	public void clickOnFooterAboutUs(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(footerAboutUs);
		object_Click(footerAboutUs);
		waitWebDriver(2000);
	}

	public void clickOnPlusIcon(){
		waitWebDriver(2000);
		scrollToElement(featuresOfSkillIndiaSection);
		waitWebDriver(2000);
		scrollUp();
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(plusIcon.get(0));
		object_Click(plusIcon.get(0));
		waitWebDriver(2000);
	}

	public void clickOnTypeInSkillUniversities(){
		waitTillTheElementIsVisibleAndClickable(typeInSkillUniversities);
		object_Click(typeInSkillUniversities);
		waitWebDriver(2000);
	}

	public void clickOnLocationInSkillUniversities(){
		waitTillTheElementIsVisibleAndClickable(locationInSkillUniversities);
		object_Click(locationInSkillUniversities);
		waitWebDriver(2000);
	}

	public void clickOnSearchInLocation(){
		waitTillTheElementIsVisibleAndClickable(locationSearch);
		object_Click(locationSearch);
		waitWebDriver(2000);
	}

	public void enterLocationNameInSearch(){
		locationSearch.sendKeys("West Bengal");
		waitWebDriver(2000);
	}

	public void clickOnDashboards(){
		waitTillTheElementIsVisibleAndClickable(dashabords);
		object_Click(dashabords);
		waitWebDriver(2000);
	}

	public void clickOnPMKVY(){
		waitWebDriver(2000);
		object_Click(PMKVYUnderDashboard);
		waitWebDriver(5000);
	}

	public void clickOnNaps(){
		waitWebDriver(2000);
		object_Click(NapsUnderDashboard);
		waitWebDriver(2000);
	}

	public void clickOnContactUsInHomePage(){
		waitWebDriver(2000);
		object_Click(contactUsLink);
		waitWebDriver(2000);
	}

	public void waitTillCoursesDisplayed(){
		waitWebDriver(5000);
		waitTillTheElementIsVisibleAndClickable(coursesSection);
		waitWebDriver(10000);
	}

	public void waitTillEmploymentOpportunitiesDisplay(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(employmentOpportunitiesSection);
		waitWebDriver(2000);
	}

	public void waitTillSkillCentreDisplay(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(skillCentreSection);
		waitWebDriver(2000);
	}

	public void clickOnVideoSectionOfLearningResources(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(videoSectionUnderLearningResource);
		object_Click(videoSectionUnderLearningResource);
		waitWebDriver(2000);
	}

	public void clickOnPDFSectionOfLearningResources(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(pdfSection);
		object_Click(pdfSection);
		waitWebDriver(2000);
	}

	public void clickOnVideoCard(){
		waitWebDriver(1000);
		object_Click(videoContentCard.get(0));
		waitWebDriver(2000);
	}

	public void clickOnShareButtonOfVideo(){
		waitTillTheElementIsVisibleAndClickable(shareVideoBtn);
		object_Click(shareVideoBtn);
		waitWebDriver(2000);
	}

	public void clickOnCrossButtonOfVideo(){
		waitTillTheElementIsVisibleAndClickable(shareCrossBtn);
		object_Click(shareCrossBtn);
		waitWebDriver(2000);
	}

	public void selectContentTypeFromDropdown(){
		waitTillTheElementIsVisibleAndClickable(pdfContentType);
		object_Click(pdfContentType);
		waitWebDriver(2000);
	}

	public void clickOnContentType(){
		waitTillTheElementIsVisibleAndClickable(contentType);
		object_Click(contentType);
		waitWebDriver(2000);
	}

	public void clickOnContentCategory(){
		waitTillTheElementIsVisibleAndClickable(contentCategory);
		object_Click(contentCategory);
		waitWebDriver(2000);
	}

	public void selectPMKVYContentCategory(){
		waitTillTheElementIsVisibleAndClickable(pmkvyCategory);
		object_Click(pmkvyCategory);
		waitWebDriver(2000);
	}

	public void clickOnLanguage(){
		waitTillTheElementIsVisibleAndClickable(languageCategory);
		object_Click(languageCategory);
		waitWebDriver(2000);
	}

	public void selectEnglishLanguageFromDropdown(){
		waitTillTheElementIsVisibleAndClickable(englishLanguage);
		object_Click(englishLanguage);
		waitWebDriver(2000);
	}

	public void clickOnResetButton(){
		waitTillTheElementIsVisibleAndClickable(resetButton);
		object_Click(resetButton);
		waitWebDriver(2000);
	}

	public void clickOnSectorCard(){
		waitTillTheElementIsVisibleAndClickable(sectorCardList.get(0));
		object_Click(sectorCardList.get(0));
		waitWebDriver(2000);
	}

	public void clickOnShareTheOpportunities(){
		waitTillTheElementIsVisibleAndClickable(shareOption.get(0));
		object_Click(shareOption.get(0));
		waitWebDriver(2000);
	}

	public void clickOnFavoriteOption(){
		waitTillTheElementIsVisibleAndClickable(favoriteOption.get(0));
		object_Click(favoriteOption.get(0));
		waitWebDriver(1000);
	}

	public void clickOnFavoriteSection(){
		waitTillTheElementIsVisibleAndClickable(favoriteSectionInJobExchange);
		object_Click(favoriteSectionInJobExchange);
		waitWebDriver(2000);
	}

	public void clickOnSelectedFavoriteButton(){
		waitTillTheElementIsVisibleAndClickable(selectedFavoriteBtn);
		object_Click(selectedFavoriteBtn);
		waitWebDriver(1000);
	}

	public void clickOnRolesAndResponsibilities(){
		waitTillTheElementIsVisibleAndClickable(RolesAndResponsibilities);
		object_Click(RolesAndResponsibilities);
		waitWebDriver(2000);
	}

	public void verifyColorOfRolesAndResponsibilities(){
		String fontColor =RolesAndResponsibilities.getCssValue("color");
		String fc =Color.fromString(fontColor).asHex();
		String ec ="#df6e12";
		Assert.assertEquals(fc,ec);
	}

	public void clickOnApplyNow(){
		waitTillTheElementIsVisibleAndClickable(ApplyNowBtn);
		object_Click(ApplyNowBtn);
		waitWebDriver(2000);
	}

	public void selectTypeFromDropdown(){
		waitTillTheElementIsVisibleAndClickable(privateType);
		object_Click(privateType);
		waitWebDriver(2000);
	}

	public void selectTheLocationFromDropdown(){
		waitTillTheElementIsVisibleAndClickable(searchedLocation);
		object_Click(searchedLocation);
		waitWebDriver(2000);
	}

	public void clickOnApplyButtonInSkillUniversities(){
		waitTillTheElementIsVisibleAndClickable(applyBtn1);
		object_Click(applyBtn1);
		waitWebDriver(2000);
	}

	public void clickOnResetFilterButtonInSkillUniversities(){
		waitTillTheElementIsVisibleAndClickable(resetFilterBtn1);
		object_Click(resetFilterBtn1);
		waitWebDriver(2000);
	}

	public void clickOnViewDetailsOfSkillUniversityCard(){
		waitWebDriver(1000);
		scrollDown();
		waitWebDriver(1000);
		waitTillTheElementIsVisibleAndClickable(viewDetailsOfSkillUniversity.get(0));
		object_Click(viewDetailsOfSkillUniversity.get(0));
		waitWebDriver(2000);
	}

	public void clickOnLocationIconButton(){
		waitTillTheElementIsVisibleAndClickable(locationIconButton);
		object_Click(locationIconButton);
		waitWebDriver(2000);
	}

	public void clickOnConvergence(){
		waitTillTheElementIsVisibleAndClickable(ConvergenceUnderDashboard);
		object_Click(ConvergenceUnderDashboard);
		waitWebDriver(2000);
	}

	public void verifyRegisterToolTip(){
		waitTillTheElementIsVisibleAndClickable(registerButton);
		Actions ac = new Actions(driver);
		ac.moveToElement(registerButton).build().perform();
		WebElement toolTip = driver.findElement(By.xpath("//button[@title='Register']"));

		String toolTIP = toolTip.getText();

		log.info(toolTIP);

		if(toolTIP.equalsIgnoreCase("Register")){
			log.info("Testcase passed");
		}else{
			log.info("Testcase failed");
		}
	}

	public void clickOnBanner3Slider(){
		waitTillTheElementIsVisibleAndClickable(banner3);
		clickWithJavaScript(banner3);
		waitWebDriver(1000);
	}

	public void clickOnBanner1Slider(){
		waitTillTheElementIsVisibleAndClickable(banner1);
		clickWithJavaScript(banner1);
		waitWebDriver(1000);
	}

	public void clickOnIndiaSkillBanner(){
		waitTillTheElementIsVisibleAndClickable(indiaSkillBanner);
		clickWithJavaScript(indiaSkillBanner);
		waitWebDriver(1000);
	}

	public void clickOnBannerIndiaSkills(){
		waitTillTheElementIsVisibleAndClickable(firstBanner);
		clickWithJavaScript(firstBanner);
		waitWebDriver(1000);
	}
	public void scrollAndClickBanner(){
       waitWebDriver(2000);
	   scrollToElement(banner1);
	   waitWebDriver(1000);
	   scrollUp();
	   waitWebDriver(1000);

	   clickOnBanner3Slider();

	   clickOnIndiaSkillBanner();
	   waitWebDriver(3000);
	}

	public void clickOnBannerOne(){
		waitWebDriver(2000);
		scrollToElement(banner1);
		waitWebDriver(1000);
		scrollUp();
		waitWebDriver(1000);

		clickOnBanner1Slider();

		clickOnBannerIndiaSkills();
		waitWebDriver(3000);
	}

	public void verifyClickOnAnnouncemnetsOption() {
		waitTillTheElementIsVisibleAndClickable(announcementsOption);
		Actions ac = new Actions(driver);
		ac.moveToElement(announcementsOption).build().perform();
		waitTillTheElementIsVisibleAndClickable(announcementsBtn);
		clickWithJavaScript(announcementsBtn);
		waitWebDriver(3000);

	}

	public void clickOnDashboardInWidget(){
		waitTillTheElementIsVisibleAndClickable(dashboardOption);
		Actions ac = new Actions(driver);
		ac.moveToElement(dashboardOption).build().perform();
		waitWebDriver(1000);
	}

	public void clickOnIndiaSkillsDashboard(){
		waitTillTheElementIsVisibleAndClickable(indiaSkillsOption);
		clickWithJavaScript(indiaSkillsOption);
		waitWebDriver(3000);
	}

	public void clickOnDigitalLearningAnalyticsDashboard(){
		waitTillTheElementIsVisibleAndClickable(digitalLearningAnalyticsOption);
		clickWithJavaScript(digitalLearningAnalyticsOption);
		waitWebDriver(3000);
	}

	public void clickOnNSDCInternationalDashboard(){
		waitTillTheElementIsVisibleAndClickable(nsdcInternationalOption);
		clickWithJavaScript(nsdcInternationalOption);
		waitWebDriver(3000);
	}

	public void clickOnPMVishwakarmaSummaryDashboard(){
		waitTillTheElementIsVisibleAndClickable(pmVishwakarmaSummaryOption);
		clickWithJavaScript(pmVishwakarmaSummaryOption);
		waitWebDriver(3000);
	}

	public void clickOnSectorSkillCouncilLink(){
		waitTillTheElementIsVisibleAndClickable(sectorSkillCouncilLink);
		clickWithJavaScript(sectorSkillCouncilLink);
		waitWebDriver(3000);
	}

	public void clickOnNationalCareerServiceLink(){
		waitTillTheElementIsVisibleAndClickable(nationalCareerServiceLink);
		clickWithJavaScript(nationalCareerServiceLink);
		waitWebDriver(3000);
	}

	public void clickOnAAKnowledgeBankLink(){
		waitTillTheElementIsVisibleAndClickable(aaKnowledgeBank);
		clickWithJavaScript(aaKnowledgeBank);
		waitWebDriver(3000);
	}

	public void clickOnAAFAQSLink(){
		waitTillTheElementIsVisibleAndClickable(aaFAQsLInk);
		clickWithJavaScript(aaFAQsLInk);
		waitWebDriver(3000);
	}

	public void clickOnMOHUALink(){
		waitTillTheElementIsVisibleAndClickable(mohuaLink);
		clickWithJavaScript(mohuaLink);
		waitWebDriver(3000);
	}

	public void clickOnPMKVYAandCGuidelinesLink(){
		waitTillTheElementIsVisibleAndClickable(pmkvyACGuidelinesLink);
		clickWithJavaScript(pmkvyACGuidelinesLink);
		waitWebDriver(3000);
	}

	public void clickOnStanaloneNOsListingLink(){
		waitTillTheElementIsVisibleAndClickable(standaloneNOSListingLink);
		clickWithJavaScript(standaloneNOSListingLink);
		waitWebDriver(3000);
	}

	public void clickOnBorrowedQpListingLink(){
		waitTillTheElementIsVisibleAndClickable(borrowedQPListingLink);
		clickWithJavaScript(borrowedQPListingLink);
		waitWebDriver(3000);
	}

	public void clickOnSCPWDBorrowedQPLink(){
		waitTillTheElementIsVisibleAndClickable(scpwdBorrowedQPLink);
		clickWithJavaScript(scpwdBorrowedQPLink);
		waitWebDriver(3000);
	}

	public void clickOnQPListingLink(){
		waitTillTheElementIsVisibleAndClickable(qpListingLink);
		clickWithJavaScript(qpListingLink);
		waitWebDriver(3000);
	}

	public void clickOnImportantLinksLink(){
		waitTillTheElementIsVisibleAndClickable(importantLinksLink);
		clickWithJavaScript(importantLinksLink);
		waitWebDriver(3000);
	}

	public void clickOnFirstQuickLink(){
		waitTillTheElementIsVisibleAndClickable(firstQuickLink);
		clickWithJavaScript(firstQuickLink);
		waitWebDriver(3000);
	}

	public void clickOnSecondQuickLink(){
		waitTillTheElementIsVisibleAndClickable(secondQuickLink);
		clickWithJavaScript(secondQuickLink);
		waitWebDriver(3000);
	}

	public void clickOnThirdQuickLink(){
		waitTillTheElementIsVisibleAndClickable(thirdQuickLink);
		clickWithJavaScript(thirdQuickLink);
		waitWebDriver(3000);
	}

	public void clickOnFourthQuickLink(){
		waitTillTheElementIsVisibleAndClickable(fourthQuickLink);
		clickWithJavaScript(fourthQuickLink);
		waitWebDriver(3000);
	}

	public void clickOnFifthQuickLink(){
		waitTillTheElementIsVisibleAndClickable(fifthQuickLink);
		clickWithJavaScript(fifthQuickLink);
		waitWebDriver(3000);
	}

	public void verifyBuildingASkillIndia(){
		scrollToElement(buildingASkillIndiaSection);
		waitWebDriver(1000);
		scrollUp();
		waitWebDriver(1000);
	}

	public void verifyAccessSkillIndiaConnect(){
		waitWebDriver(2000);
		scrollToElement(skillIndiaConnectSection);
		waitWebDriver(1000);
		scrollUp();
		waitWebDriver(1000);
	}

	public void clickOnViewDetailsOfSkillIndiaConnect(){
		waitTillTheElementIsVisibleAndClickable(viewDetailsOnSkillIndiaConnect);
		clickWithJavaScript(viewDetailsOnSkillIndiaConnect);
		waitWebDriver(2000);
	}

	public void verifyAndClickOnViewAllUnderSkillIndiaConnect(){
		scrollToElement(viewAllInSkillIndiaConnect);
		waitWebDriver(1000);
		scrollUp();
		waitWebDriver(1000);
		object_Click(viewAllInSkillIndiaConnect);
		waitWebDriver(3000);
	}

	public void clickOnApprenticeships(){
		waitTillTheElementIsVisibleAndClickable(apprenticeshipOption);
		clickWithJavaScript(apprenticeshipOption);
		waitWebDriver(2000);
	}

	public void clickOnApprenticeshipDashboard(){
		waitTillTheElementIsVisibleAndClickable(apprenticeshipDashboardLink);
		clickWithJavaScript(apprenticeshipDashboardLink);

	}

	public void clickOnNAPSDBTDashboard(){
		waitTillTheElementIsVisibleAndClickable(napsDbtDashboard);
		clickWithJavaScript(napsDbtDashboard);
	}

	public void clickOnSummaryDashboard(){
		waitTillTheElementIsVisibleAndClickable(summaryDashboard);
		clickWithJavaScript(summaryDashboard);
	}

	public void clickOnPremiumAnalyticsDashboard(){
		waitTillTheElementIsVisibleAndClickable(premiumAnalyticsDashboard);
		clickWithJavaScript(premiumAnalyticsDashboard);
	}

	public void clickOnStateLevelPerformanceDashboard(){
		waitTillTheElementIsVisibleAndClickable(stateLevelPerformanceDashboard);
		clickWithJavaScript(stateLevelPerformanceDashboard);
	}

	public void clickOnPMKVYOption(){
		waitTillTheElementIsVisibleAndClickable(pmkvyOption);
		clickWithJavaScript(pmkvyOption);
		waitWebDriver(2000);
	}

	public void scrollToLearnMoreOptionInHomePage(){
		waitWebDriver(1000);
		scrollToElement(playbutton);
		waitWebDriver(1000);
		scrollUp();
		waitWebDriver(2000);
		clickWithJavaScript(playbutton);
		waitWebDriver(2000);
	}

	public void clickOnSkillCourseSlider(){
		waitTillTheElementIsVisibleAndClickable(skillCoursesSlider);
		clickWithJavaScript(skillCoursesSlider);
		waitWebDriver(1000);
	}

	public void clickOnSkillCoursesLearnMoreButton(){
		waitTillTheElementIsVisibleAndClickable(learnMoreButton.get(0));
		clickWithJavaScript(learnMoreButton.get(0));
		waitWebDriver(2000);
	}

	public void clickOnJobExchangeSlider(){
		waitTillTheElementIsVisibleAndClickable(jobExchangeSlider);
		clickWithJavaScript(jobExchangeSlider);
		waitWebDriver(1000);
	}

	public void clickOnJobExchangeLearnMoreButton(){
		waitTillTheElementIsVisibleAndClickable(learnMoreButton.get(1));
		clickWithJavaScript(learnMoreButton.get(1));
		waitWebDriver(2000);
	}

	public void clickOnSkillCentreSlider(){
		waitTillTheElementIsVisibleAndClickable(skillCentreSlider);
		clickWithJavaScript(skillCentreSlider);
		waitWebDriver(1000);
	}

	public void clickOnSkillCentreLearnMoreButton(){
		waitTillTheElementIsVisibleAndClickable(learnMoreButton.get(2));
		clickWithJavaScript(learnMoreButton.get(2));
		waitWebDriver(2000);
	}

	public void clickOnSkillCoursesInChatBot(){
		waitTillTheElementIsVisibleAndClickable(skillCourseInChatbot);
		clickWithJavaScript(skillCourseInChatbot);
		waitWebDriver(4000);
	}

	public void clickOnChatBot(){
        /*waitTillTheElementIsVisibleAndClickable(chatbot);
		clickWithJavaScript(chatbot);*/
		waitWebDriver(30000);
	}

	public void clickOnAutomotive(){
		waitTillTheElementIsVisibleAndClickable(automotiveInChatbot);
		clickWithJavaScript(automotiveInChatbot);
		waitWebDriver(4000);
	}

	public void clickOnOnlineInChatbot(){
		waitTillTheElementIsVisibleAndClickable(onlineInchatbot);
		clickWithJavaScript(onlineInchatbot);
		waitWebDriver(4000);
	}

	public void clickOnEnglishLanguage(){
		waitTillTheElementIsVisibleAndClickable(englishInChatbot);
		clickWithJavaScript(englishInChatbot);
		waitWebDriver(4000);
	}

	public void clickOnHelpAndSupport(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(helpAndSupportLink);
		object_Click(helpAndSupportLink);
	}

	public void clickOnSchemesFooterLink(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(schemesFooterLink);
		object_Click(schemesFooterLink);
	}

	public void clickAndEnterFirstNameInQuery(){
		waitTillTheElementIsVisibleAndClickable(firstNameTextField);
		object_Click(firstNameTextField);
		enterValueInTextBox(firstNameTextField,"Manjunath");
	}

	public void clickAndEnterLastNameInQuery(){
		waitTillTheElementIsVisibleAndClickable(lastNameTextField);
		object_Click(lastNameTextField);
		enterValueInTextBox(lastNameTextField,"S N");
	}

	public void clickAndEnterEmailIDInQuery(){
		waitTillTheElementIsVisibleAndClickable(emailTextField);
		object_Click(emailTextField);
		enterValueInTextBox(emailTextField,"test@yopmail.com");
	}

	public void clickAndEnterMobileNoInQuery(){
		waitTillTheElementIsVisibleAndClickable(mobileNumberTextField);
		object_Click(mobileNumberTextField);
		enterValueInTextBox(mobileNumberTextField,"9148574673");
	}

	public void clickOnStateDropdown(){
		waitTillTheElementIsVisibleAndClickable(selectStateDropdown);
		object_Click(selectStateDropdown);
	}

	public void selectAndhraState(){
		waitTillTheElementIsVisibleAndClickable(andhraState);
		object_Click(andhraState);
	}

	public void clickOnDistrictDropdown(){
		waitWebDriver(2000);
		waitTillTheElementIsVisibleAndClickable(districtDropdown);
		clickWithJavaScript(districtDropdown);
	}

	public void selectAnantapurDistrict(){
		waitTillTheElementIsVisibleAndClickable(anantapurDistrict);
		object_Click(anantapurDistrict);
	}

	public void clickAndEnterFeedback(){
		scrollToElement(feedbackTextField);
		waitWebDriver(1000);
		scrollUp();
		waitWebDriver(1000);
		waitTillTheElementIsVisibleAndClickable(feedbackTextField);
		object_Click(feedbackTextField);
		enterValueInTextBox(feedbackTextField,"SID App KT required");

	}

	public void clickAndEnterComments(){
		waitTillTheElementIsVisibleAndClickable(commentsTextField);
		object_Click(commentsTextField);
		enterValueInTextBox(commentsTextField,"Knowledge Transfer is required");
		waitWebDriver(1000);
	}

	public void clickOnQuerySubmitBtn(){
		waitTillTheElementIsVisibleAndClickable(querySubmitBtn);
		clickWithJavaScript(querySubmitBtn);
		waitWebDriver(1000);
	}

	public void clickOnContactNumberInContactUsPage(){
		waitTillTheElementIsVisibleAndClickable(contactNumber);
		clickWithJavaScript(contactNumber);
	}

	public void clickOnAddressInContactUspage(){
		waitTillTheElementIsVisibleAndClickable(addressLink);
		clickWithJavaScript(addressLink);
		waitWebDriver(3000);
	}

	public void clickOnViewLargerMapLink(){
		waitTillTheElementIsVisibleAndClickable(viewLargerMapLink);
		clickWithJavaScript(viewLargerMapLink);
	}

	public void clickOnDirectionsButton(){
		waitTillTheElementIsVisibleAndClickable(directionsBtn);
		clickWithJavaScript(directionsBtn);
	}

	public void clickOnReviewsButton(){
		waitTillTheElementIsVisibleAndClickable(reviews);
		clickWithJavaScript(reviews);
	}

	public void clickOnZoomInOption(){
		waitTillTheElementIsVisibleAndClickable(zoomInOption);
		clickWithJavaScript(zoomInOption);
	}

	public void clickOnZoomOutOption(){
		waitTillTheElementIsVisibleAndClickable(zoomOutOption);
		clickWithJavaScript(zoomOutOption);
	}





}
