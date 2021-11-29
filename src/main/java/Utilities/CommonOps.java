package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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

import org.w3c.dom.Document;
import pageObjects.calculator.CalculatorPage;

public class CommonOps extends Base {

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(getData(("url")));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //calculatorTablePage = PageFactory.initElements(driver, CalculatorTablePage.class);
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
        driver.quit();
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
}