package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Base {

    //general
    protected static WebDriver driver;
    protected static  Actions action;
    //put the url in xml
    protected static String url;

    //web
    protected static WebDriverWait wait;

    //Rest API
    protected static RequestSpecification request;
    protected static Response response;
    protected static JSONObject parames;
    protected static JsonPath jp;

    //assert
    protected static SoftAssert softassert;

    //oop
    //protected static RioPage rioPage;

    //appium
    protected static AndroidDriver<AndroidElement> driverappium;


    //desktop
    protected static WindowsDriver driverdesktop;
    protected static DesiredCapabilities capabilities;

    //elektron
    private ChromeOptions opt;
    private DesiredCapabilities capabilitieselektron;

}
