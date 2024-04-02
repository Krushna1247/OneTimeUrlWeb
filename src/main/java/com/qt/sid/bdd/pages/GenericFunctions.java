package com.qt.sid.bdd.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qt.sid.bdd.utils.ExecutionTimeException;

public class GenericFunctions {

    public Select select;
    public Action action;

    static WebDriver driver;

    static Logger log = Logger.getLogger(GenericFunctions.class.getName());

    // Method to Select DropDown From Text

    public GenericFunctions() {

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
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
        jse.executeScript("window.scrollBy(0, 250)", "");
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

}
