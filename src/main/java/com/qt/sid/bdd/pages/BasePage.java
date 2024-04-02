package com.qt.sid.bdd.pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qt.sid.bdd.utils.FileReaderManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qt.sid.bdd.utils.ExecutionTimeException;
import org.testng.Assert;

public class BasePage {

	static WebDriver driver;

	public BasePage() {
	}
	static Logger log = Logger.getLogger(GenericFunctions.class.getName());
	public static void basePageDriver(WebDriver browser) {
		driver = browser;
	}

	/*
	 * public void object_Click(WebElement element) { try { element.click(); } catch
	 * (Exception e) { throw new
	 * ExecutionTimeException("Login textbox is absent / got changed on the webpage."
	 * ); } }
	 */

	public WebElement waitVisibleElement(WebElement element, int time) {
		return new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitClickableElement(WebElement element, int time) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void selectOptionByText(WebElement ele, String text) {
		try {
			new Select(ele).selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void mouseOverAction() {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 200).click().perform();

	}
	public void selectOptionByValue(WebElement ele, String text) {
		try {
			new Select(ele).selectByValue(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectOptionByIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void scrollToElement(WebElement ele) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void scrollDown300() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 300)", "");
	}
	public static void scrollDown100() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 100)", "");
	}
	
	
	
	public void clickWithJavaScript(WebElement ele) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escKey() {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER);
		a.sendKeys(Keys.ENTER);
		a.sendKeys(Keys.ESCAPE);
		GenericFunctions.waitWebDriver(2000);
	}


	public void scrollToPageEnd() {
		waitWebDriver(3000);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void takeScreenshot() {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Date dateTime = new Date();
			String screenshotPath = "test-output/screenshots/" + dateTime.getDate() + "-" + dateTime.getMonth() + " "
					+ dateTime.getHours() + "-" + dateTime.getMinutes() + "-" + dateTime.getSeconds() + ".png";
			FileUtils.copyFile(file, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static byte[] getScreenShot() {
		byte[] screenshot = null;
		try {

			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return screenshot;

	}

	public static void selectValueFromDropdown(WebDriver driver, String locator, String text) {
		WebElement lang = driver.findElement(By.xpath(locator));
		List<WebElement> list = lang.findElements(By.xpath(locator));
		for (WebElement opt : list) {
			String value = opt.getText();
			if (value.equalsIgnoreCase(text)) {
				System.out.println("Value clicked =" + value);
				opt.click();
			}
		}
	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	// Method to Upload File
	public static void uploadFile(String fileLocation) {
		try {
			// Setting Clipboard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			System.out.println("Failed uploading document");
			exp.printStackTrace();
		}
	}

	// Method to Press Tab using Robot Classes
	public static void pressTABInKeyboard() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	// Method to Write into Notepad
	public static void writeNotepad(String processID, String fileName) {
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName));
			bWriter.write(processID);
			System.out.println("Write ID: " + processID);
			bWriter.newLine();
			bWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Method to Read From NotePad
	@SuppressWarnings("resource")
	public static String readFromNotepad(String fileName) {
		String path = "";
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(fileName));
			while ((path = bReader.readLine()) != null) {
				System.out.println("Read ID: " + path);
				@SuppressWarnings("unused")
				String str = bReader.readLine();
				// System.out.println(str);
				return path;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

	// Returns True if WebElement is selected else throws Exception Fail
	public static boolean isWebElementSelected(WebElement webElement) {
		if (webElement.isSelected()) {
			System.out.println("Element selected");
			return true;
		} else {
			System.out.println("Element Not selected");
			return false;
		}
	}

	// Method to Wait till the Element is Visible and Clickable
	public static void waitTillTheElementIsVisibleAndClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(element));

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method to Wait till the Element is Visible
	public static void waitTillTheElementInVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// Method ot wait page to Load
	public static void waitForPageToLoad(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	public static void waitForElementState(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.stalenessOf(id));

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	// Method to wait page to Load all Elements
	public static void waitForPageToLoad(List<WebElement> id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(id));
	}

	// Method to wait till Element is disappear
	public static void waitForElementToDisAppear(List<WebElement> id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(id));
	}

	// Method to wait till all the Elements are disapper
	public static void waitForElementToDisAppear(List<WebElement> id, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(id));
	}

	// Method to wait till all the Elements to Appear
	public static WebElement waitForElementToAppear(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(id));
		return id;
	}

	// Method to wait till particular the Elements to Appear
	public WebElement waitForElementToAppear(WebElement id, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(id));
		return id;
	}

	// Method to wait for Element to Appear
	public WebElement waitForElement(WebElement arg) {
		waitForPageToLoad(arg);
		WebElement el = arg;
		return el;
	}

	// Method to wait till frame to switch
	public static void WaitForFrameAndSwitchToIt(WebElement frame) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	public static void WaitForFrameAndSwitchToIt(int id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}

	// Method to wait for elements
	public static void waitForElements(List<WebElement> arg) {
		waitForPageToLoad(arg);
	}

	// Method to wait till Element is Appear On Screen.
	public static WebElement waitForElementToAppearOnScreen(WebElement arg) {
		waitForElementToAppear(arg);
		WebElement el = arg;
		return el;
	}

	public void object_Click(WebElement element) {
		try {
			implicitWaits();
			element.click();
		} catch (Exception e) {
			throw new ExecutionTimeException("Object is absent / got changed on the webpage.");
		}
	}

	public String getTextOfObject(WebElement element) {
		String textValue = null;
		try {
			textValue = element.getText();
		} catch (Exception e) {
			throw new ExecutionTimeException("Object is absent / got changed on the webpage.");
		}
		return textValue;
	}


	public void enterValueInTextBox(WebElement element,String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			throw new ExecutionTimeException("Object is absent / got changed on the webpage.");
		}
	}

	public String getCurrentMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	// returns True if Element Present
	public boolean isElementPresent(WebElement locator) {
		try {
			if (locator.isDisplayed())
				System.out.println("Element presend on screen ***********" + locator);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element not present on screen **************" + locator);
			return false;
		}
	}

	public String getCurrentMonth(int month) {
		int i = Calendar.getInstance().get(Calendar.MONTH);
		String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return monthNames[month + i];
	}

	// Method to refresh Web page
	public static void refreshWebPage() {
		driver.navigate().refresh();
		GenericFunctions.waitWebDriver(1500);
	}

	// Method to wait for time
	public static void waitWebDriver(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());

		}
	}

	// Method to Switch To New Window.
	public static void switchToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	// Method to switchToFrame
	public static void switchToFrame(WebDriver mDriver, WebElement frame) {
		try {
			mDriver.switchTo().frame(frame);
		} catch (Exception e) {
			log.error("Method: switchToFrame :: Exception is = " + e.getMessage());
		}
	}

	// Method Tab Operation
	public static void keyTab(WebDriver mDriver, String locator) {

		try {
			log.info("MethodName: keyTab :: element found = " + locator);

			mDriver.findElement(By.cssSelector(locator)).sendKeys(Keys.TAB);
		} catch (Exception e) {
			log.error("MethodName: TabKeys :: Exception occured for locator = " + locator + "exception = "
					+ e.getMessage());
		}
	}

	public static String currentDateAndTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
		// String newDate = dtf.toString().toCharArray().toString();
		// System.out.println(now.format(dtf).toCharArray());
		String date = now.format(dtf);
		return date;
	}

	public static String testDataIncrementer(String filePath) {
		String courseNum = GenericFunctions.readFromNotepad(filePath);
		Pattern compile = Pattern.compile("^(.*?)([9Z]*)$");
		Matcher matcher = compile.matcher(courseNum);
		String left = "";
		String right = "";
		if (matcher.matches()) {
			left = matcher.group(1);
			right = matcher.group(2);
		}
		courseNum = !left.isEmpty() ? Long.toString(Long.parseLong(left, 36) + 1, 36) : "";
		courseNum += right.replace("Z", "A").replace("9", "0");
		String writeData = courseNum.toUpperCase();
		GenericFunctions.writeNotepad(writeData, filePath);
		return writeData;
	}

	// Method to Double Click
	public static void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element);
		GenericFunctions.waitWebDriver(2000);
	}

	public static void sendTextFromRobotClass() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);

	}

	public static void edge(String APP_URL, String username, String password) throws IOException {
		System.out.println("Edge browser");
		String path = System.getProperty("user.dir") + "./AutoITScripts/Edge.exe";
		ProcessBuilder pb = new ProcessBuilder(path, username, password);
		pb.start();
		driver.get(APP_URL);
		GenericFunctions.waitWebDriver(10000);
		Runtime.getRuntime().exec("TASKKILL /F /IM Edge.exe");

	}

	public static void firefox(String APP_URL, String username, String password) throws IOException {
		String path = System.getProperty("user.dir") + "./AutoITScripts/Firefox.exe";
		ProcessBuilder pb = new ProcessBuilder(path, username, password);
		pb.start();
		driver.get(APP_URL);
		GenericFunctions.waitWebDriver(1000);
		Runtime.getRuntime().exec("TASKKILL /F /IM Firefox.exe");

	}

	public static void chrome(String APP_URL, String username, String password) throws IOException {
		if (APP_URL.contains("3")) {
			System.out.println("*****************RUNNING IN STAGE 3***********************");
			String path = System.getProperty("user.dir") + "/AutoITScripts/Stage3.exe";
			ProcessBuilder pb = new ProcessBuilder(path, username, password);
			pb.start();
			driver.get(APP_URL);
			GenericFunctions.waitWebDriver(1000);
			Runtime.getRuntime().exec("TASKKILL /F /IM Stage3.exe");
		} else if (APP_URL.contains("sp")) {
			System.out.println("*****************RUNNING IN PROD ***********************");
			String path = System.getProperty("user.dir") + "./AutoITScripts/PROD.exe";
			ProcessBuilder pb = new ProcessBuilder(path, username, password);
			pb.start();
			driver.get(APP_URL);
			GenericFunctions.waitWebDriver(1000);
			Runtime.getRuntime().exec("TASKKILL /F /IM PROD.exe");
		} else {
			System.out.println("*****************RUNNING IN STAGE ***********************");
			String path = System.getProperty("user.dir") + "./AutoITScripts/Stage.exe";
			ProcessBuilder pb = new ProcessBuilder(path, username, password);
			pb.start();
			driver.get(APP_URL);
			GenericFunctions.waitWebDriver(1000);
			Runtime.getRuntime().exec("TASKKILL /F /IM Stage.exe");

		}
	}

	// Method to send url to chromeBrowser.
	public static void chromeADFSLogin(String APP_URL, String username, String password) {
		StringBuffer sb = new StringBuffer(APP_URL);
		sb.insert(8, username + ":" + password + "@");
		String s = sb.toString();
		System.out.println(s);
		driver.get(s);
	}

	// Method to launch FireFox Browser
	public static void launchFirefox(String FIREFOX_KEY, String FIREFOX_VAL) {
		System.out.println("Browser selected FireFox");
		System.setProperty(FIREFOX_KEY, FIREFOX_VAL);
	}

	// Method to launch Chrome Browser
	public static void launchChrome(String CHROME_KEY, String CHROME_VAL) {
		System.out.println("Browser selected Chrome");
		System.setProperty(CHROME_KEY, CHROME_VAL);
	}

	// Method to launch Edge Browser
	public static void launchEdge(String EDGE_KEY, String EDGE_VAL) {
		System.out.println("Browser selected Edge");
		System.setProperty(EDGE_KEY, EDGE_VAL);

	}

	// Method to Select DropDown using Mouse
	public static void ClickDropdown(WebDriver driver, WebElement click1, WebElement click2) {
		Actions a = new Actions(driver);
		a.click(click1).build().perform();
		GenericFunctions.waitWebDriver(2000);
		a.click(click2).build().perform();
		GenericFunctions.waitWebDriver(2000);
	}

	// Method to Send text to Field
	public static void sendKeysToObjects(WebDriver mDriver, WebElement locator, String text) {
		GenericFunctions.waitForElementToAppearOnScreen(locator);
		locator.sendKeys(text);
	}

	// Method to Upload Unsupported File
	public static void unSupportedFile() throws IOException {
		String path = System.getProperty("user.dir") + "./Testupload/unSupportedFile.exe";
		Runtime.getRuntime().exec(path);
		GenericFunctions.waitWebDriver(3000);
		Runtime.getRuntime().exec("TASKKILL /F /IM unSupportedFile.exe");
	}

	// Method to Scroll Up
	public static void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -250)", "");
	}

	// Method to Scroll Down
	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 450)", "");
	}

	// method to Check Url contains Enteres Character in Parameter
	public static void checkURLContains(String text) {
		String currentURL = driver.getCurrentUrl();
		if (currentURL.contains(text)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	// Method to compare 2 String arrays
	public static boolean compareTwoArray(String[] s1, String[] s2) {
		if (s1 == s2)
			return true;

		if (s1 == null || s2 == null)
			return false;

		int n = s1.length;
		if (n != s2.length)
			return false;

		for (int i = 0; i < n; i++) {
			if (!s1[i].equals(s2[i]))
				return false;
		}

		return true;
	}

	// Method to Connect To GCSStage Data Base.
	public static String connectToDB(String DBurl, String DBdriver, String uname, String pass, String columnName)
			throws SQLException, ClassNotFoundException {
		Class.forName(DBdriver);
		Connection conn = DriverManager.getConnection(DBurl, uname, pass);
		System.out.println("Database connection established");
		String strcommand = "select * from GlobalSettings where GCSWebKey=" + "'" + columnName + "'";
		PreparedStatement preStat = conn.prepareStatement(strcommand);
		String s = "";
		ResultSet r = null;
		r = preStat.executeQuery();
		while (r.next()) {
			s = r.getString("GCSWebValue");
		}
		return s;

	}

	public static String getWindowHandle() {
		return driver.getWindowHandle();
	}

	// Method to get window handles
	public static Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	// Method to switch to window based on id
	public static WebDriver switchToWindowBasedOnId(String id) {
		return driver.switchTo().window(id);

	}

	public String getChildWindow(WebDriver driver)
	{
		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		it.next();
		String childWindow = it.next();
		return childWindow;

	}
	public static void navigateBack(){
		try {
			implicitWaits();
			driver.navigate().back();

		}
		catch (Exception e){
			System.out.println("Page not navigated back");
		}


	}
	public static void sleepMethod() throws InterruptedException {

		Thread.sleep(4000);
	}
	public String readexceltype(String sheetname, int rownum, int cellnum) throws IOException {
		String res = null;
		File file = new File(
				System.getProperty("user.dir")+"\\testdata\\SIDMicrosoftCourses.xlsx");
		FileInputStream fileinput = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(fileinput);
		Sheet sheet = work.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType Type = cell.getCellType();

		switch (Type) {
			case STRING:
				res = cell.getStringCellValue();
				break;

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat dateform = new SimpleDateFormat();
					dateform.format(date);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long round = Math.round(numericCellValue);
					if (numericCellValue == round) {
						res = String.valueOf(round);
					} else {
						res = String.valueOf(numericCellValue);
					}
				}
			default:
				break;
		}
		return res;
	}

	public String writexcel(String sheetname, int rownum, int cellnum,String cellval) throws IOException {
		String res = null;
		File file = new File(
				"D:\\LycaWebAutomation\\src\\test\\resources\\ExcelSheet\\Lyca.xlsx");
		FileInputStream fileinput = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(fileinput);
		Sheet sheet = work.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		if (cell==null) {
			cell = row.createCell(cellnum);
		}
		cell.setCellValue(cellval);
		FileOutputStream fileoutput = new FileOutputStream(file);
		work.write(fileoutput);
		return res;
	}

	public void updatecelldata(String sheetname, int rownum, int cellnum, String olddata, String newdata)
			throws IOException {
		File file = new File(
				"D:\\LycaWebAutomation\\src\\test\\resources\\ExcelSheet\\Lyca.xlsx");
		FileInputStream fileinput = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(fileinput);
		Sheet sheet = work.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream fileoutput = new FileOutputStream(file);
		work.write(fileoutput);

	}


   public  void sendkey(WebElement element,String name){
		try {
			implicitWaits();
			element.sendKeys(name);
		}
		catch (Exception e){
			System.out.println("Text not sended to the field");
		}

   }
   public static void parentWindow(){
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> I1=s.iterator();
		while (I1.hasNext()) {
			String childWindow = I1.next();


			if (parent.equals(childWindow)) {
				driver.switchTo().window(parent);
			}
		}


   }
	public  void sendkeys(WebElement element,String name){
		element.sendKeys(name,Keys.ENTER);

	}
	public void selectText(WebElement element,String text){
		try {
			Select select = new Select(element);

			select.selectByVisibleText(text);
		}
		catch (Exception e){
			System.out.println("Element didn't get selected");
		}
	}
	public void  sendWithJavaScript(WebElement element){
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value=", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void implicitWaits(){
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch (Exception e){
			System.out.println("Implicit wait is not fixed");
		}
	}
	public void selectByIndex(WebElement element,int index){
		Select select=new Select(element);
		select.selectByIndex(index);
	}

	public boolean isButtonEnabled(WebElement button) {
		return button.isEnabled();

	}


}