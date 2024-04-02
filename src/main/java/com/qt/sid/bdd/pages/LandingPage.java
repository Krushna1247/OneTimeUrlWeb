package com.qt.sid.bdd.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qt.sid.bdd.utils.FileReaderManager;

public class LandingPage extends BasePage {

    public WebDriver driver;
    @FindBy(xpath = "//span[text()='Recommendation']")
    private WebElement Recommendation;

    @FindBy(xpath = "//a[text()=' Disclaimer ']")
    private WebElement Disclaimer;

	@FindAll({
			@FindBy(xpath = "//a[text()='About Us']"),
			@FindBy(xpath = "//a[@href='/about-us']")
	})
    private WebElement AboutUsLink;

	@FindAll({
			@FindBy(xpath = "//a[@title='Facebook']"),
			@FindBy(xpath = "//a[@href='https://www.facebook.com/NSDCIndiaOfficial']")
	})
    private WebElement FaceBookLink;

	@FindAll({
			@FindBy(xpath = "//a[@title='Linkedin']"),
			@FindBy(xpath = "//a[@href='https://www.linkedin.com/company/national-skill-development-corporation']")
	})
    private WebElement LinkedInLink;

	@FindAll({
			@FindBy(xpath = "//a[@title='Twitter']"),
			@FindBy(xpath = "//a[@href='https://twitter.com/NSDCINDIA']")
	})
    private WebElement TwitterLink;

	@FindAll({
			@FindBy(xpath = "//a[@title='YouTube']"),
			@FindBy(xpath = "//a[@href='https://www.youtube.com/user/NSDCIndiaOfficial']")
	})
    private WebElement YoutubeLink;

	@FindAll({
			@FindBy(xpath = "//a[text()=' Skill Courses ']"),
			@FindBy(xpath = "//a[@href='/courses']")
	})
    private WebElement Courses;

    @FindBy(xpath = "//a[@href='/sector/list']")
    private WebElement Sectors;

    @FindBy(xpath = "//*[@alt='SatyamevJayate']")
    private WebElement MinisrtySkillDevLink;

    @FindBy(xpath = "//*[@alt='towardofnew']")
    private WebElement TowardOfNewLink;

    @FindBy(xpath = "//*[@alt='departmentofadminitration']")
    private WebElement PublicGrivances;

    @FindBy(xpath = "//*[@alt='indiagovin']")
    private WebElement IndiaGOVIn;
    
    @FindBy(xpath = "//button[@title='High Contrast']")
	public WebElement contrastBtn;
	
	@FindBy(xpath = "//a[@title='Reset font size']")
	public WebElement fontSizeBtn;
	
	@FindBy(xpath = "(//button[text()='A'])[1]")
	public WebElement decreseFontSizeBtn;
	
	@FindBy(xpath = "//button[text()='A']//sup[text()='-']")
	public WebElement fontDecreseSign;
	
	@FindBy(xpath = "//button[text()=' A ']")
	public WebElement standardFontSizeBtn;
	
	@FindBy(xpath = "(//button[text()='A'])[2]")
	public WebElement increaseFontSizeBtn;
	
	@FindBy(xpath = "//button[text()='A']//sup[text()='+']")
	public WebElement fontIncreaseSign;
	
	@FindBy(xpath = "(//li[@class='nav-item'])[1]")
	public WebElement locationBtn;
	
	@FindBy(xpath = "//h5[text()=' Popular Cities ']")
	public WebElement popularCitiesText;
	
	@FindBy(xpath = "//span[text()=' View All Cities ']")
	public WebElement viewAllCitiesText;
	
	@FindBy(xpath = "//h5[text()='Mumbai']")
	public WebElement mumbaiCity;
	
	@FindBy(id = "searchInput")
	public WebElement searchField;
	
	@FindBy(xpath = "//button[text()=' Search ']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//a[text()=' Bengaluru ']")
	public WebElement bengaluruCity;
	
	@FindBy(xpath = "//span[text()=' Skip To Main Content ']")
	public WebElement skipToMainContentBtn;
	
	@FindBy(xpath = "//h4[text()=' Most Popular ']")
	public WebElement mostPopularSection;
	
	@FindBy(xpath = "//span[text()='Go To Course']")
	public WebElement goToCourse;

	@FindBy(xpath = "//button[text()=' LOGIN ']")
	public WebElement loginBtn;



	@FindBy(xpath = "//div[@class='role-img']/img[@alt='Partner']")
	private WebElement partnerLink;


	@FindBy(xpath = "//div[@class='cdk-global-overlay-wrapper']//div[2]//div[1]//div[2]//button[1]")
	private WebElement mobilizerLoginBtn;

	@FindBy(xpath = "//div[@class='register-section']//div[1]//div[1]//div[2]//button[1]")
	private WebElement learningPartner;

	@FindBy(xpath = "//input[@id='number']")
	private WebElement mobileNumberTextfield;

	@FindBy(xpath = "//div[@class='pin-filed text-center text-md-start']/input")
	private List<WebElement> passwordTextField;

	@FindBy(xpath = "//button[@class='btn-primary-style1 ng-star-inserted']")
	private WebElement login;

	@FindBy(xpath = "//button[text()=' Continue ']")
	public WebElement continueBtn;

	@FindBy(xpath = "//*[@title='Schemes & Initiatives']")
	public WebElement schemesAndInitiativesSection;

	@FindBy(xpath = "//*[@alt='CPGRAMS Logo']")
	public WebElement cpgramsLogo;

	@FindBy(xpath = "//*[@alt='India Gov Logo']")
	public WebElement indiaGovLogo;

	@FindBy(xpath = "//*[text()='MINISTRY OF WOMEN & CHILD DEVELOPMENT ']")
	public WebElement ministryOfWomenAndChildDevelopmentText;

	@FindBy(xpath = "//*[text()='See more on Facebook']")
	public WebElement facebookPageText;

	@FindBy(id = "organization_guest_contextual-sign-in-modal-header")
	public WebElement linkedInlogo;

	@FindBy(xpath = "//*[@aria-label='X']")
	public WebElement twitterLogo;

	@FindBy(id = "logo-icon")
	public WebElement youtubeLogo;

	@FindBy(xpath = "//*[@class='minimized-view-v2-icon ']")
	public WebElement webChatBotIcon;

	@FindBy(id = "cross-button-polygon")
	public WebElement webChatBotCloseIcon;

	@FindBy(id="rufous-sandbox")
	public WebElement frameId;



	public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateTo_LoginPage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getHomePageUrl());
		waitWebDriver(3000);

    }
    public void clickFaceBookLink() {
		waitWebDriver(4000);
        clickWithJavaScript(FaceBookLink);
    }
    public void clickLinkedInLink() {
        clickWithJavaScript(LinkedInLink);
    }
    public void clickTwitterLink() {
        clickWithJavaScript(TwitterLink);
    }
    public void clickYoutubeLink() {
        clickWithJavaScript(YoutubeLink);
    }
    public void scrollToWhoWeAre() {
        scrollToElement(Disclaimer);
        waitVisibleElement(Disclaimer, 50);
    }
    public void clickAboutUsLink() {
        clickWithJavaScript(AboutUsLink);
    }

    public void clickRecommendationLink() {
        waitTillTheElementIsVisibleAndClickable(Recommendation);
        object_Click(Recommendation);
    }
    public void clickCoursesLink() {
		waitWebDriver(3000);
        clickWithJavaScript(Courses);
		waitWebDriver(3000);
    }
    public void clickMinisrtySkillDevLink() {
        clickWithJavaScript(MinisrtySkillDevLink);
    }
    public void clickPublicGrievences() {
        clickWithJavaScript(PublicGrivances);
    }
    public void clickTowardOfNewLink() {
        clickWithJavaScript(TowardOfNewLink);
    }
    public void clickIndiaGovInLink() {
        clickWithJavaScript(IndiaGOVIn);
    }
    public void clickSectorsLink() {
        clickWithJavaScript(Sectors);
    }
    
    public void contrastClick() {
    	waitTillTheElementIsVisibleAndClickable(contrastBtn);
    	object_Click(contrastBtn);
	}
	
	public void fontSizeClick() { 
		object_Click(fontSizeBtn); 
	}
	
	public void decreaseFontSizeClick() {
		waitTillTheElementIsVisibleAndClickable(decreseFontSizeBtn);
		object_Click(decreseFontSizeBtn);
    }
	
	public void standardFontSizeClick() {
		object_Click(standardFontSizeBtn);
	}
	
	public void increaseFontSizeClick() {
		waitTillTheElementIsVisibleAndClickable(increaseFontSizeBtn);
		object_Click(increaseFontSizeBtn);
	}
	
	public void locationClick() {
		waitTillTheElementIsVisibleAndClickable(locationBtn);
		object_Click(locationBtn);
	}
	
	public void searchFieldClick() {
		object_Click(searchField);
	}
	
	public void searchBtnClick() {
		object_Click(searchBtn);
	}
	
	public void skipToMainContent() {
		waitTillTheElementIsVisibleAndClickable(skipToMainContentBtn);
		object_Click(skipToMainContentBtn);
	}
	
	public void visibilityOfMostPopularSection() {
		waitTillTheElementIsVisibleAndClickable(mostPopularSection);
	}
   
	public void clickOnMumbaiCity() {
		waitTillTheElementIsVisibleAndClickable(mumbaiCity);
		object_Click(mumbaiCity);
	}
	
	public void switchToCity() {
		searchField.sendKeys(FileReaderManager.getInstance().getConfigReader().getBengaluruCity());
		searchBtnClick();
		waitTillTheElementIsVisibleAndClickable(bengaluruCity);
		object_Click(bengaluruCity);
		
	}

	public void logoinAppAsMobilizer( String mobilenumber,String password ){
		loginBtn.click();
		partnerLink.click();
		mobilizerLoginBtn.click();
		mobileNumberTextfield.sendKeys(mobilenumber);
		continueBtn.click();
		for(WebElement element : passwordTextField){
			element.sendKeys(password);
			int x = Integer.parseInt(password);
			x++;
			password = String.valueOf(x);
		}
		login.click();
	}

	public void clickOnWebChatBot(){
		//waitTillTheElementIsVisibleAndClickable(webChatBotIcon);
		clickWithJavaScript(webChatBotIcon);
		waitWebDriver(1000);
	}

	public void clickOnCloseWebChatbotIcon(){
		waitTillTheElementIsVisibleAndClickable(webChatBotCloseIcon);
		clickWithJavaScript(webChatBotCloseIcon);
		waitWebDriver(1000);
	}


}
