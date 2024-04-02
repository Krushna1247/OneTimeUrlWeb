package com.qt.sid.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Dashboard {
	

	public WebDriver driver;

	By Dashboard = By.xpath("//a[text()=\" Dashboard \"]");

	By Sid_Dashboard = By.xpath("//div[text()=\"SID Dashboard \"]");

	By Telementry_Dashboard = By.xpath("//button[text()=\" Telemetry Dashboard \"]");

	By Event_Type = By.xpath("//mat-expansion-panel-header[@id=\"mat-expansion-panel-header-9\"]");

	By Event_Type_Start = By.xpath("//input[@value='START']");

	By Calender_fromDate = By.xpath("(//div[@id='sidfilter']/div[1]//div[1]//input)[1]");
	
	
	By calendar_toDate = By.xpath("(//div[@id='sidfilter']/div[1]//div[1]//input)[2]");

	By FromDate_dashboard = By.xpath("//*[text()=\"From Date\"]");

	By ToDate_Dashboard = By.xpath("//*[text()=\"To Date\"]");

	By Dashboard_State = By.xpath("//mat-expansion-panel-header[@id='mat-expansion-panel-header-0']");

	By Dasboard_choose_State = By.xpath("//div[@id='cdk-accordion-child-0']//p//mat-radio-group//mat-radio-button");

	By Arunchalpradesh = By.xpath("//input[@value=\"Arunachal Pradesh\"]");

	By Dashboard_stateFinder = By.xpath("//input[@id=\" searchinput\"]");

	By Dashboard_AreaofInterest = By.xpath("//mat-expansion-panel-header[@id=\"mat-expansion-panel-header-1\"]");

	By Agriculture = By.xpath("//input[@id='mat-radio-110-input']");

	By Dashboard_choose_AreaofInteest = By.xpath("//div[@class='mat-expansion-panel-body ng-tns-c176-44']//div//p");

	By Dashboard_Gender = By.xpath("//mat-expansion-panel-header[@id=\"mat-expansion-panel-header-2\"]");

	By Male = By.xpath("//input[@value='Male']");

	By Dashbaord_Gender_List = By.xpath("//div[@class='mat-expansion-panel-content ng-tns-c176-10']//p");

	By Dashboard_AgeGroup = By.xpath("//mat-expansion-panel-header[@id='mat-expansion-panel-header-3']");

	By AgeGroup_16_25 = By.xpath("//input[@value=\"16-25\"]");

	By Dashbaord_AgeGroup_List = By.xpath("//div[@class='mat-expansion-panel-content ng-tns-c176-32']//input");

	By Dashboard_Reset_Filter = By.xpath("(//button[text()=\" RESET FILTER \"])[1]");

	By Telemetry_Reset_Filter = By.xpath("(//button[text()=\" RESET FILTER \"])[2]");
	
	By Tel_cal_From = By.xpath("(//div[@id='pills-profile']//div//input)[1]");
	
	By Tel_cal_To =By.xpath("(//div[@id='pills-profile']//div//input)[2]");


	By notificationIconBtn =By.xpath("//button[@title='Notifications']");

	public Dashboard(WebDriver driver) {

		this.driver = driver;
	}

	public void clickonDashboard() throws InterruptedException {

		WebElement das = driver.findElement(Dashboard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", das);
		Thread.sleep(2000);

	}
	public void enterCalender() throws InterruptedException {
		
	WebElement fromCalendar = driver.findElement(Calender_fromDate);
	fromCalendar.sendKeys("01");
	fromCalendar.sendKeys("01");
	fromCalendar.sendKeys("2022");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	System.out.println("Click on From Date");
	js.executeScript("arguments[0].click()", fromCalendar);
	Thread.sleep(500);
	
	
	
	WebElement ToCalendar = driver.findElement(calendar_toDate);
	ToCalendar.sendKeys("01");
	ToCalendar.sendKeys("03");
	ToCalendar.sendKeys("2023");
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	System.out.println("Click on To Date");
	js1.executeScript("arguments[0].click()", ToCalendar);
	Thread.sleep(2000);
	
	
	}

	public void ClickandselectStateFromList() throws InterruptedException {

		WebElement state = driver.findElement(Dashboard_State);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", state);
		Thread.sleep(2000);

		WebElement AP = driver.findElement(Arunchalpradesh);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", AP);
		Thread.sleep(2000);

//		List<WebElement> StateList = driver.findElements(Dasboard_choose_State);
//		System.out.println("Total element is " + StateList.size());
//
//		for (int i = 0; i < StateList.size(); i++) {
//
//			if (i == 2) {
//				Thread.sleep(2000);
//				WebElement list = StateList.get(i);
//				JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("arguments[0].click()", list);
//				Thread.sleep(3000);
//
//			}
//
//		}
	}

	public void ClickandSelectAreaofInterest() throws InterruptedException {

		WebElement Areaofinterest = driver.findElement(Dashboard_AreaofInterest);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Areaofinterest);

		Thread.sleep(2000);

		WebElement agri = driver.findElement(Agriculture);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", agri);
		Thread.sleep(2000);

//		List<WebElement> AreaofInterstList = driver.findElements(Dashboard_choose_AreaofInteest);
//		for (int i = 0; i < AreaofInterstList.size(); i++) {
//
//			if (i == 2) {
//			//	Thread.sleep(2000);
//				WebElement list = AreaofInterstList.get(i);
//				JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("arguments[0].click()", list);
//				Actions a = new Actions(driver);
//				// scroll down a page
//				a.sendKeys(Keys.PAGE_DOWN).build().perform();
//				Thread.sleep(3000);
//
//			}
//
//		}

	}

	public void clickandSelectGender() throws InterruptedException {

		WebElement Gender = driver.findElement(Dashboard_Gender);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Gender);
		Thread.sleep(2000);

		WebElement male = driver.findElement(Male);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", male);
		Thread.sleep(2000);

//		List<WebElement> GenderList = driver.findElements(Dashbaord_Gender_List);
//		System.out.println("Total element is " + GenderList.size());
//
//		for (int i = 0; i < GenderList.size(); i++) {
//
//			if (i == 2) {
//				//Thread.sleep(2000);
//				WebElement list = GenderList.get(i);
//				JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("arguments[0].click()", list);
//				Thread.sleep(3000);
//
//			}
//
//		}
	}

	public void clickandSelectAgeGroup() throws InterruptedException {

		WebElement AgeGroup = driver.findElement(Dashboard_AgeGroup);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", AgeGroup);
		Thread.sleep(2000);

		WebElement age_16_25 = driver.findElement(AgeGroup_16_25);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0,150)");
		js1.executeScript("arguments[0].click()", age_16_25);
		Thread.sleep(2000);

//		List<WebElement> AgeGroupList = driver.findElements(Dashbaord_AgeGroup_List);
//		System.out.println("Total element is " + AgeGroupList.size());
//
//		for (int i = 0; i < AgeGroupList.size(); i++) {
//
//			if (i == 2) {
//				Thread.sleep(2000);
//				WebElement list = AgeGroupList.get(i);
//				JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("arguments[0].click()", list);
//				Thread.sleep(3000);
//
//			}
//
//		}

	}

	public void clickonRestFilter() throws InterruptedException {

		WebElement ResetFilter = driver.findElement(Dashboard_Reset_Filter);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,150)");
		js.executeScript("arguments[0].click()", ResetFilter);
		Thread.sleep(3000);

	}

	public void clickonTelemetryDashboard() throws InterruptedException {

		WebElement TelemeteryDashboard = driver.findElement(Telementry_Dashboard);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", TelemeteryDashboard);
		Thread.sleep(3000);

	}
	
	public void enterCalenderTelmetry() throws InterruptedException {
		
		WebElement TelfromCalendar = driver.findElement(Tel_cal_From);
		TelfromCalendar.sendKeys("01");
		TelfromCalendar.sendKeys("01");
		TelfromCalendar.sendKeys("2022");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("Click on From Date");
		js.executeScript("arguments[0].click()", TelfromCalendar);
		Thread.sleep(500);
		
		
		
		WebElement TelToCalendar = driver.findElement(Tel_cal_To);
		TelToCalendar.sendKeys("01");
		TelToCalendar.sendKeys("03");
		TelToCalendar.sendKeys("2023");
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		System.out.println("Click on To Date");
		js1.executeScript("arguments[0].click()", TelToCalendar);
		Thread.sleep(2000);
		
		
		}


	public void clickandSelectEventType() throws InterruptedException {

		WebElement eventtype = driver.findElement(Event_Type);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", eventtype);
		Thread.sleep(3000);
		
		

		WebElement start = driver.findElement(Event_Type_Start);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", start);
		Thread.sleep(3000);

	}

	public void clickonTelemetry_reset() throws InterruptedException {

		WebElement tele_Reset = driver.findElement(Telemetry_Reset_Filter);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", tele_Reset);
		Thread.sleep(3000);

	}

	public void clickOnNotificationIcon() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(notificationIconBtn).click();
	}

}
