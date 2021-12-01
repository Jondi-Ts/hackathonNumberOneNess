package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.annotations.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import pageObjects.calculator.CalculatorPage;
import pageObjects.grafana.*;
import pageObjects.toDoLIst.TodoPage;
import pageObjects.uintConverter.CalculatorPage2;


public class CommonOps extends Base {

    @BeforeClass
    @Parameters({"PlatformName", "BrowserName"})

    public void startSession(String platformName, String browserName) throws MalformedURLException {

//        if(getData("PlatformName")=="web" { initWeb() } else if (getData("PlatformName")=="api" { initAPI() } else if (

        String platform = platformName;//getData("PlatformName");
        if (platform.equals("web")) {
            initWeb(browserName);
        } else if (platform.equals("api")) {
            initApi();
        } else if (platform.equals("mobile")) {
            initAppium();
        } else if (platform.equals("electron")) {
            initElectron();
        } else if (platform.equals("desktop")) {
            initDeskTop();
        }


    }

    //        if(getData("BrowserName")=="web" { initWeb() } else if (getData("PlatformName")=="api" { initAPI() } else if (

    public void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Step("init Web")
    public void initWeb(String browserName) {

        String browser = browserName; //getData("BrowserName");
        if (browser.equals("chrome")) {
            initChrome();
        } else if (browser.equals("firefox")) {
            initFirefox();
        } else {
            initChrome();
        }
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action = new Actions(driver);
        softAssertion = new SoftAssert();
        ManagePages.initWeb();
        sizeofuserstable = myserveradminpage.getrows().size();
        expectedsizeofrows = myserveradminpage.getrows().size();
        rows = myserveradminpage.getrows();
        loginName="group1";
        name ="winners" ;
        email="ness@gmail.com";
        passworduser="1212";
        Editname = "the best";
        search = "MySQL";
        expectedsizeoficons=7;
        JDBC.initSQLConnection();
        screen = new Screen();

    }

    @Step("init desktop")
    public void initDeskTop() throws MalformedURLException {
        deskTopCapabilities = new DesiredCapabilities();
        deskTopCapabilities.setCapability("app", calcApp);
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), deskTopCapabilities);
        ManagePages.initDeskTop();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void endDesktop() {
        driver.quit();
    }


    @BeforeMethod
    public void beforeMethod(Method method) {
        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    @Parameters({"PlatformName"})
    public void endSession(String platformName) {
        //        if(getData("PlatformName")=="web" { initWeb() } else if (getData("PlatformName")=="api" { initAPI() } else if (


        if (platformName.equals("web")) {
            endWeb();
        } else if (platformName.equals("mobile")) {
            endAppium();
        } else if (platformName.equals("electron")) {
            endElectron();
        } else if (platformName.equals("desktop")) {
            endDesktop();
        }

    }

    @Step("end web")
    public void endWeb() {
        driver.quit();
        JDBC.closeDBCon();
    }


    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("ExternalFiles/info.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    //Apium start
    @Step("init mobile")
    public void initAppium() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, MOBILE_NAME);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, MAIN_ACTIVITY);
        androidDriver = new AndroidDriver<>(new URL(APPIUM_URL), dc);
        androidDriver.setLogLevel(Level.INFO);
        ManagePages.initAppium();
    }

    @Step("End mobile")
    public void endAppium() {
        androidDriver.quit();
    }
    //Apium End

    //start Electorn
    @Step("init Electron")
    public void initElectron() {
        System.setProperty(CHROME_DRIVER, DRIVER_LOCATION);
        opt = new ChromeOptions();
        opt.setBinary(TODO_EXE_LOCATION);
        electronCapabilities = new DesiredCapabilities();
        electronCapabilities.setCapability(CHROME_OPTIONS_STRING, opt);
        electronCapabilities.setBrowserName(CHROME);
        driver = new ChromeDriver(electronCapabilities);
        ManagePages.initElectron();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("end electron")
    public void endElectron() {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.quit();
    }

    //End Electron

    //start api init
    @Step("init api")
    public void initApi() {
        RestAssured.baseURI = urlApi;
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("grafanaUserName"),
                getData("grafanaUserName"));
        params = new JSONObject();
        httpRequest.header("Accept", "application/json");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Authorization", "Bearer " + apiKey);
    }

    // Connect to API
    /*public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"), getData("Password"));
    }*/


    public static JSONObject createJson(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        JSONObject params = new JSONObject();
        params.putAll(map);

        return params;
    }
}