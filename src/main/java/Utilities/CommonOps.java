package Utilities;

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


public class CommonOps extends Base {

    @BeforeClass
    @Parameters({"PlatformName", "BrowserName"})

    public void startSession(String platformName, String browserName) throws Exception {


        if (platformName.equals("web")) {
            initWeb(browserName);
        } else if (platformName.equals("api")) {
            initApi();
        } else if (platformName.equals("mobile")) {
            initAppium();
        } else if (platformName.equals("electron")) {
            initElectron();
        } else if (platformName.equals("desktop")) {
            initDeskTop();
        } else {
            throw new Exception("Invalid platform");
        }


    }


    public void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Step("init Web")
    public void initWeb(String browserName) throws Exception {

        String browser = browserName; //getData("BrowserName");
        if (browser.equals("chrome")) {
            initChrome();
        } else if (browser.equals("firefox")) {
            initFirefox();
        } else {
            throw new Exception("Unsupported browser");
        }
        sikulipath = getData("sikuliPath");
        driver.get(getData("urlGrafana"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action = new Actions(driver);
        softAssertion = new SoftAssert();
        ManagePages.initWeb();
//        JDBC.initSQLConnection();
        screen = new Screen();

    }

    //Apium start
    @Step("init mobile")
    public void initAppium() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, getData("mobileName"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("packageName"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("mainActivity"));
        androidDriver = new AndroidDriver<>(new URL(getData("appiumUrl")), dc);
        androidDriver.setLogLevel(Level.INFO);
        ManagePages.initAppium();
    }


    @Step("init Electron")
    public void initElectron() {
        System.setProperty(getData("chromeDriver"), getData("driverLocation"));
        opt = new ChromeOptions();
        opt.setBinary(getData("todoExeLocation"));
        electronCapabilities = new DesiredCapabilities();
        electronCapabilities.setCapability(getData("chromeOptions"), opt);
        electronCapabilities.setBrowserName(getData("chrome"));
        driver = new ChromeDriver(electronCapabilities);
        ManagePages.initElectron();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("init desktop")
    public void initDeskTop() throws MalformedURLException {
        deskTopCapabilities = new DesiredCapabilities();
        deskTopCapabilities.setCapability(getData("capabilityName"), getData("calcApp"));
        driver = new WindowsDriver(new URL(getData("desktopUrl")), deskTopCapabilities);
        ManagePages.initDeskTop();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Step("init api")
    public void initApi() {
        urlApi = getData("urlApi");
        urlKeysSuffix = getData("apiKeysUrl");
        RestAssured.baseURI = urlApi;
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("grafanaUserName"),
                getData("grafanaPassword"));
        params = new JSONObject();
        httpRequest.header("Accept", "application/json");
        httpRequest.header("Content-Type", "application/json");
        //httpRequest.header("Authorization", "Bearer " + apiKey);
    }


    @BeforeMethod
    @Parameters({"PlatformName"})
    public void beforeMethod(String platformName, Method method) {
        if (!platformName.equals("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @AfterClass
    @Parameters({"PlatformName"})
    public void endSession(String platformName) {


        switch (platformName) {
            case "web":
            case "desktop":
            case "electron":
                endSession();
                break;
            case "mobile":
                endAppium();
                break;
        }

    }


    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String getData(String nodeName) {
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


    //    public void endDesktop() {
//        driver.quit();
//    }


    @Step("End mobile")
    public void endAppium() {
        androidDriver.quit();
    }

    @Step("end web")
    public void endSession() {
        driver.quit();

    }
    //Apium End

    //start Electorn


//    @Step("end electron")
//    public void endElectron() {
//        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
//        driver.quit();
//    }

    //End Electron

    //start api init


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