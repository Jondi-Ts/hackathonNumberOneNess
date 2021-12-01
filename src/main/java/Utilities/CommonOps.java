package Utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import pageObjects.calculator.CalculatorPage;
import pageObjects.toDoLIst.TodoPage;
import pageObjects.uintConverter.CalculatorPage2;

public class CommonOps extends Base {

    @BeforeClass
    public void startSession() throws MalformedURLException {

//        if(getData("PlatformName")=="web" { initWeb() } else if (getData("PlatformName")=="api" { initAPI() } else if (


//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get(getData(("url")));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initDeskTop();
        ManagePages.initDeskTop();


    }

    //        if(getData("BrowserName")=="web" { initWeb() } else if (getData("PlatformName")=="api" { initAPI() } else if (

    @Step("init Web")
    public void initWeb(){


        driver.get("http://localhost:3000/");
        action = new Actions(driver);

        softAssertion = new SoftAssert();

        //inital the global size
        sizeofuserstable = myserveradminpage.getrows().size();
        expectedsizeofrows = myserveradminpage.getrows().size();
        rows = myserveradminpage.getrows();
        name = "mory";
        Editname="nana";
        search="MySQL";

        JDBC.initSQLConnection();
        //sikuli
        screen = new Screen();

    }

    @Step("init desktop")
    public void initDeskTop() throws MalformedURLException {
        deskTopCapabilities =new DesiredCapabilities();
        deskTopCapabilities.setCapability("app",calcApp);
        driver=new WindowsDriver(new URL("http://127.0.0.1:4723"), deskTopCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
    public void endSession() {
        //        if(getData("PlatformName")=="web" { initWeb() } else if (getData("PlatformName")=="api" { initAPI() } else if (


        driver.quit();
      //  RemoteDb.closeDBCon();
    }

    @Step
    public  void endWeb()
    {
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
    public void startAppium() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, MOBILE_NAME);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, MAIN_ACTIVITY);
        androidDriver = new AndroidDriver<>(new URL(APPIUM_URL), dc);
        androidDriver.setLogLevel(Level.INFO);
        calculatorPage = new CalculatorPage(androidDriver);
        androidDriver.resetApp();
        calculatorPage.okAfterReset();
    }

    public void endAppium() {
        androidDriver.quit();
    }
    //Apium End

    //start Electorn
    public void startElectron() {
        System.setProperty(CHROME_DRIVER, DRIVER_LOCATION);
        opt = new ChromeOptions();
        opt.setBinary(TODO_EXE_LOCATION);
        electronCapabilities = new DesiredCapabilities();
        electronCapabilities.setCapability(CHROME_OPTIONS_STRING, opt);
        electronCapabilities.setBrowserName(CHROME);
        electronWebDriver = new ChromeDriver(electronCapabilities);
        todoPage = PageFactory.initElements(electronWebDriver, TodoPage.class);
        electronWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void endElectron() {
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        electronWebDriver.quit();
    }

    //End Electron
}